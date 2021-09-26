package dev.patika.creditscoreofcustomer.service;

import org.springframework.stereotype.Service;

@Service
public class CreditScoreService {

    public double creditScoreCalculator(long customerSSID){
        long lastNumberOfCustomerSSID = customerSSID % 10;
        double creditScore;
        switch((int) lastNumberOfCustomerSSID) {
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
                throw new IllegalStateException("Unexpected value: " + lastNumberOfCustomerSSID);
        }
        return creditScore;
    }
}
