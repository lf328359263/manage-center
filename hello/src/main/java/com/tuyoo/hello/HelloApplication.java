package com.tuyoo.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
//    @Value("${server.port}")
//    String port;
//
//    @Value("${from}")
//    String from;
    @Autowired
    private Environment environment;

    @RequestMapping("/hi")
    public String home() {
        return String.format("hi %s ", environment.getProperty("from", "unknown"));
    }
}
