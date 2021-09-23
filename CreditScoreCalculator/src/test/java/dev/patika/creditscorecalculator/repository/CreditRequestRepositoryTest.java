package dev.patika.creditscorecalculator.repository;

import dev.patika.creditscorecalculator.entity.CreditRequestResponse;
import dev.patika.creditscorecalculator.entity.Customer;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CreditRequestRepositoryTest {
    @Autowired
    CreditRequestRepository creditRequestRepository;
    @AfterEach
    void tearDown() { creditRequestRepository.deleteAll();
    }

    @Test
    void shouldFindCustomerCreditResponsesWithSsid(){
        // given
        Customer actual = new Customer(19250706428L, "Harun Murat", 15000F, "05314094416");
        CreditRequestResponse creditRequestResponse = new CreditRequestResponse(1, "Approve", 15000D, actual);
        creditRequestRepository.save(creditRequestResponse);

        // when
        Customer expected = creditRequestRepository.findCustomerCreditResponsesWithSsid(actual.getSsid()).get(0).getCustomer();

        // then
        assertEquals(actual, expected);
    }

}