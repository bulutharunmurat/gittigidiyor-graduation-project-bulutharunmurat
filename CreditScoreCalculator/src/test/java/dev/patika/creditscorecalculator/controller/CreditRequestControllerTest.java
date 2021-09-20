package dev.patika.creditscorecalculator.controller;

import dev.patika.creditscorecalculator.DTO.CustomerDTO;
import dev.patika.creditscorecalculator.entity.CreditRequestResponse;
import dev.patika.creditscorecalculator.entity.Customer;
import dev.patika.creditscorecalculator.service.CreditRequestService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreditRequestControllerTest {

    @Mock
    CreditRequestService mockCreditRequestService;
    @InjectMocks
    CreditRequestController creditRequestController;

    @Test
    void findCustomerCreditResponsesWithSsid() {
    }

    @Test
    void creditRequestWithCustomerId() {
        //given
        CreditRequestResponse expected = new CreditRequestResponse();
        when(mockCreditRequestService.creditRequest(anyLong())).thenReturn(expected);

        //when
        CreditRequestResponse actual = this.creditRequestController.creditRequestWithCustomerId(1);

        //then
        assertAll(
                ()-> assertNotNull(actual),
                ()-> assertEquals(expected, actual),
                ()-> assertEquals(expected.getCustomer(), actual.getCustomer())
        );
    }
}