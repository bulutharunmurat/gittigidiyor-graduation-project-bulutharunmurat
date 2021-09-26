package dev.patika.creditscorecalculator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(value = "score-service")
public interface CreditScoreClient {

    @GetMapping("/api/credit-score/{customerSSID}")
    double findCustomerCreditScoreWithSsid(@PathVariable long customerSSID);
}
