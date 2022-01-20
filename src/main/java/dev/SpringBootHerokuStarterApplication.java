package dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringBootHerokuStarterApplication {

//    Initialisation branche develop avec flow

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHerokuStarterApplication.class, args);
    }

}
