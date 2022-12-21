package com.example.school;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SchoolController {
    private List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1L, "Max", "Petrov", 19),
                    new Student(2L, "Dina", "Borisova", 29),
                    new Student(3L, "Leonid", "Kasatonov", 23),
                    new Student(4L, "Sergey", "Borodov", 22),
                    new Student(5L, "Masha", "Poruvaeva", 39)
            )
    );

    private Teacher teacher = new Teacher(1L, "Maria Ivanovna", true);

    @GetMapping("/students")
    public String getStudents(Model model) {

        String status = null;

        model.addAttribute("message", "It's a test message");
        model.addAttribute("students", students);
        model.addAttribute("teacher", teacher);
        model.addAttribute("status", status);
        return "list";
    }

    @GetMapping("/add")
    public String addNewStudent(Student student) {
        return "add-student";
    }

    @PostMapping("/students")
    public String createStudent(
            @Valid @ModelAttribute Student student,
            BindingResult result,   // нужна, чтобы проверить, соответствует ли студент правилам валидации
            Model model
    ) {
        if (result.hasErrors()) {  // age = 12, first = '', last = 'Kotkov', id = 3
            return "add-student";
        }
        students.add(student);
        return "redirect:/students";
    }

    // ДЗ проф ява
    // 1. Добавьте в вывод списка студентов ссылки для их изменения в виде /students/1.
    // 2. Добавьте шаблон для изменения студента.
    @GetMapping("/student/{studentId}")
    public String changeStudent(
            @PathVariable(name = "studentId") Long studentId,
            Model model
    ) {
        int studId = Math.toIntExact(studentId);
        model.addAttribute("student", students.get(studId-1));
        return "change-student";
    }

    @PostMapping("/student")
    public String updateStudent(
            //@PathVariable(name = "studentId") Long studentId,
            @Valid @ModelAttribute Student student,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "change-student";
        }
        students.set(Math.toIntExact(student.getId()), student);
        return "redirect:/students";
    }

    @GetMapping("/change")
    public String changeTeacher(Model model) {
        model.addAttribute("teacher", teacher);
        return "change-teacher";
    }

    @PostMapping("/teachers")
    public String updateTeacher(
            @Valid @ModelAttribute Teacher teacher,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "change-teacher";
        }
        this.teacher = teacher;
//        this.teacher.setName(teacher.getName());
//        this.teacher.setWorking(teacher.getWorking());
        return "redirect:/students";
    }


}