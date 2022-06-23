package ru.itis.examweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ExamWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamWebApplication.class, args);
    }

}
