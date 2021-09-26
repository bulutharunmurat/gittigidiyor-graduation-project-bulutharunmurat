package dev.patika.creditscoreofcustomer.controller;

import dev.patika.creditscoreofcustomer.service.CreditScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CreditScoreController {

    private final CreditScoreService creditScoreService;

    @GetMapping("/credit-score/{customerSSID}")
    public double findCustomerCreditScoreWithSsid(@PathVariable long customerSSID){
        return creditScoreService.creditScoreCalculator(customerSSID);
    }
}
