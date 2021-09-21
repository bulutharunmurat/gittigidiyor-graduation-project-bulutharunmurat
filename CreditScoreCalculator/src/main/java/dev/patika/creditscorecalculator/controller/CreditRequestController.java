package dev.patika.creditscorecalculator.controller;

import dev.patika.creditscorecalculator.entity.CreditRequestResponse;
import dev.patika.creditscorecalculator.service.CreditRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CreditRequestController {

    private final CreditRequestService creditRequestService;

    @GetMapping("/credit-request/{customerSSID}")
    public List<CreditRequestResponse> findCustomerCreditResponsesWithSsid(@PathVariable long customerSSID){
        return creditRequestService.findCustomerCreditResponsesWithSsid(customerSSID);
    }
    @PostMapping("/credit-request/{customerSSID}")
    public CreditRequestResponse creditRequestWithCustomerId(@PathVariable long customerSSID){
        return creditRequestService.creditRequest(customerSSID);
    }
}
