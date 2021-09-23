package dev.patika.creditscorecalculator.service;

import dev.patika.creditscorecalculator.entity.CreditRequestResponse;
import dev.patika.creditscorecalculator.entity.Customer;
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
    void shouldRejectCreditRequestIfCreditScoreUnder500ThatCorrespondLastNumberOfSsid6(){

        //given
        Customer customer = new Customer(19250706426L, "Harun Murat", 15000F, "05314094416");
        CreditRequestResponse actual = new CreditRequestResponse("Reject",0.00, customer);
        when(mockCreditRequestRepository.save(any())).thenReturn(actual);
        when(mockCustomerService.findBySsid(anyLong())).thenReturn(customer);

        // when
        CreditRequestResponse expected = creditRequestService.creditRequest(customer.getSsid());

        //then
        assertAll(
                ()-> assertEquals(actual.getCreditLimit(), expected.getCreditLimit()),
                ()-> assertEquals(actual, expected),
                ()-> assertEquals(expected.getCreditResponseType(), "Reject")
        );
    }
    @Test
    void shouldReturnApproveWith10000LimitIfSalaryUnder5000andCreditScoreBetween500and1000ThatCorrespondLastNumberOfSsid2and8(){

        //given
        Customer customer = new Customer(19250706428L, "Harun Murat", 4000F, "05314094416");
        CreditRequestResponse actual = new CreditRequestResponse("Approve", 10000.00, customer);
        when(mockCreditRequestRepository.save(any())).thenReturn(actual);
        when(mockCustomerService.findBySsid(anyLong())).thenReturn(customer);

        // when
        CreditRequestResponse expected = creditRequestService.creditRequest(customer.getSsid());

        //then
        assertAll(
                ()-> assertEquals(actual.getCreditLimit(), expected.getCreditLimit()),
                ()-> assertEquals(actual, expected),
                ()-> assertEquals(expected.getCreditLimit(), 10000)
        );
    }
    @Test
    void shouldReturnApproveWith10000LimitIfSalaryGreater5000andCreditScoreBetween500and1000ThatCorrespondLastNumberOfSsid2and8(){

        //given
        Customer customer = new Customer(19250706428L, "Harun Murat", 4000F, "05314094416");
        CreditRequestResponse actual = new CreditRequestResponse("Approve", 20000.00, customer);
        when(mockCreditRequestRepository.save(any())).thenReturn(actual);
        when(mockCustomerService.findBySsid(anyLong())).thenReturn(customer);

        // when
        CreditRequestResponse expected = creditRequestService.creditRequest(customer.getSsid());

        //then
        assertAll(
                ()-> assertEquals(actual.getCreditLimit(), expected.getCreditLimit()),
                ()-> assertEquals(actual, expected),
                ()-> assertEquals(expected.getCreditLimit(), 20000)
        );
    }
    @Test
    void shouldReturnApproveWithSalaryMultipliedByCreditScoreLimitIfCreditScoreEqualOrGreaterThan1000ThatCorrespondLastNumberOfSsid0and4(){

        //given
        final float customCreditRatio = 4;
        Customer customer = new Customer(19250706420L, "Harun Murat", 4000F, "05314094416");
        CreditRequestResponse actual = new CreditRequestResponse("Approve", (double) (customer.getCustomerSalary()*customCreditRatio), customer);
        when(mockCreditRequestRepository.save(any())).thenReturn(actual);
        when(mockCustomerService.findBySsid(anyLong())).thenReturn(customer);

        // when
        CreditRequestResponse expected = creditRequestService.creditRequest(customer.getSsid());

        //then
        assertAll(
                ()-> assertEquals(actual.getCreditLimit(), expected.getCreditLimit()),
                ()-> assertEquals(actual, expected),
                ()-> assertEquals(expected.getCreditLimit(), customer.getCustomerSalary()*customCreditRatio)
        );
    }
    @Test
    void creditRequest() {
    }
}