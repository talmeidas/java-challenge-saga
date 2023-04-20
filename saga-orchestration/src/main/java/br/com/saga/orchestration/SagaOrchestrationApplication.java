package br.com.saga.orchestration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SagaOrchestrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(SagaOrchestrationApplication.class, args);
    }
}
