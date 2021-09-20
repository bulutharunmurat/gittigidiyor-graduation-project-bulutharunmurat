package dev.patika.creditscorecalculator.service;

import dev.patika.creditscorecalculator.repository.CreditRequestRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreditRequestServiceTest {

    @Mock
    CustomerService mockCustomerService;
    @Mock
    CreditRequestRepository mockCreditRequestRepository;
    @InjectMocks
    CreditRequestService creditRequestService;
    @Test
    void findCustomerCreditResponsesWithSsid() {
    }

    @Test
    void creditRequest() {
    }
}