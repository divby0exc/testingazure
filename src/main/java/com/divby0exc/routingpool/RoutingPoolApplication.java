package com.divby0exc.routingpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class RoutingPoolApplication {

    public WebClient.Builder getWebClient() {
        return WebClient.builder();
    }
    public static void main(String[] args) {
        SpringApplication.run(RoutingPoolApplication.class, args);
    }

}
