package com.macro.cloud.mallgeteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MallGetewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallGetewayApplication.class, args);
    }

}
