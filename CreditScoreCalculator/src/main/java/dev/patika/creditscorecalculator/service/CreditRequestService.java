package dev.patika.creditscorecalculator.service;

import dev.patika.creditscorecalculator.entity.CreditRequestResponse;
import dev.patika.creditscorecalculator.entity.Customer;
import dev.patika.creditscorecalculator.exceptions.CustomerNotFoundException;
import dev.patika.creditscorecalculator.exceptions.IllegalSSIDNumberException;
import dev.patika.creditscorecalculator.repository.CreditRequestRepository;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditRequestService{

    private final CustomerService customerService;
    private final CreditRequestRepository creditRequestRepository;
    private static Logger logger = Logger.getLogger(CustomerService.class);

    public List<CreditRequestResponse> findCustomerCreditResponsesWithSsid(long customerSSID) {
        return creditRequestRepository.findCustomerCreditResponsesWithSsid(customerSSID);
    }

    @Transactional
    public CreditRequestResponse creditRequest(long customerSSID) {

        // Getting last number of SSID
        long lastNumberOfCustomerSSID = customerSSID % 10;

        if(lastNumberOfCustomerSSID % 2 == 1  ){
            logger.info("Customers SSID cannot end with with odd number!!!");
            throw new IllegalSSIDNumberException("Customers SSID cannot end with with odd number!!!");
        }

        // Initialized custom credit ratio
        final float customCreditRatio = 4;

        // Finds the customer from database
        Customer customer = customerService.findBySsid(customerSSID);


        // Credit Score calculated with CreditScoreCalculator Logic, in future credit scores can pull from database!!!
        double creditScore = creditScoreCalculator(lastNumberOfCustomerSSID);


        if (creditScore < 500){
            CreditRequestResponse creditResponse = new CreditRequestResponse("Reject",0.00, customer);
            creditRequestRepository.save(creditResponse);
            return creditResponse;
        }
        else if (500 < creditScore && creditScore < 1000 ){
            if(customer.getCustomerSalary() < 5000){
                CreditRequestResponse creditResponse = new CreditRequestResponse("Approve", 10000.00, customer);
                creditRequestRepository.save(creditResponse);
                return creditResponse;
            }
            else {
                CreditRequestResponse creditResponse = new CreditRequestResponse("Approve", 20000.00, customer);
                creditRequestRepository.save(creditResponse);
                return creditResponse;
            }
        }
        else {
            double customerLimit = customer.getCustomerSalary() * customCreditRatio;
            CreditRequestResponse creditResponse = new CreditRequestResponse("Approve", customerLimit, customer);
            creditRequestRepository.save(creditResponse);
            return creditResponse;
        }

    }

    private double creditScoreCalculator(long lastNumberOfSSID){
        double creditScore;
        switch((int) lastNumberOfSSID) {
            case 0:
                creditScore =  2000;
                break;
            case 2:
                creditScore = 550;
                break;
            case 4:
                creditScore = 1000;
                break;
            case 6:
                creditScore = 400;
                break;
            case 8:
                creditScore = 900;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + lastNumberOfSSID);
        }
        return creditScore;
    }
}
