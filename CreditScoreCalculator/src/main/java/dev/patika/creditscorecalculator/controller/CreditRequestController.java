package dev.patika.creditscorecalculator.controller;

import dev.patika.creditscorecalculator.entity.CreditRequestResponse;
import dev.patika.creditscorecalculator.service.CreditRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CreditRequestController {

    private final CreditRequestService creditRequestService;

    @GetMapping("/credit-request/{customerSSID}")
    public CreditRequestResponse creditRequestWithCustomerId(@PathVariable long customerSSID){
        return creditRequestService.creditRequest(customerSSID);
    }
}
