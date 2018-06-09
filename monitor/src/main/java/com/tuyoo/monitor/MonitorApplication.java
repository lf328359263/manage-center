package com.tuyoo.monitor;

import com.tuyoo.monitor.service.DiscoveryService;
import com.tuyoo.monitor.service.impl.EurekaDiscoveryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableEurekaClient
@Configuration
@SpringBootApplication
public class MonitorApplication {

    @Bean
    public DiscoveryService discoveryService() {
        return new EurekaDiscoveryService();
    }

    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);
    }
}
