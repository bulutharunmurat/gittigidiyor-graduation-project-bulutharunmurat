package dev.patika.creditscorecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient
public class CreditScoreCalculator {

    public static void main(String[] args) {
        SpringApplication.run(CreditScoreCalculator.class, args);
    }

}
