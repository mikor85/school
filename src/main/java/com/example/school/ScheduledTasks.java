package com.example.school;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //@Scheduled(fixedRate = 5000) // раз в 5 секунд
    //@Scheduled(fixedRate = 5, timeUnit = TimeUnit.SECONDS) // раз в 5 секунд
    //@Scheduled(fixedRate = 5, timeUnit = TimeUnit.SECONDS, initialDelay = 50_000) // раз в 5 секунд с задержкой 50сек после старта приложения

    // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html
    // https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#scheduling-cron-expression
    @Scheduled(cron = "0 03 21 * * *")  // запуск в определенные дни и время
    public void reportCurrentTime() {
        log.info("reportCurrentTime time is: " + dateFormat.format(new Date()));
    }

}