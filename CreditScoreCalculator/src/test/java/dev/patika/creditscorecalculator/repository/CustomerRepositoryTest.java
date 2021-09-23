package dev.patika.creditscorecalculator.repository;

import dev.patika.creditscorecalculator.entity.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @AfterEach
    public void tearDown(){
        customerRepository.deleteAll();
    }


    @Test
    void shouldCheckWhenCustomerSsidIsExists() {
        // given
        Customer customer = new Customer(19250706428L, "Harun Murat", 15000F, "05314094416");
        customerRepository.save(customer);

        // when
        boolean expected = customerRepository.selectExistsSsid(customer.getSsid());

        // then
        assertTrue(expected);
    }

    @Test
    void shouldCheckWhenCustomerSsidIsNotExists() {
        // given
        Customer customer = new Customer(19250706428L, "Harun Murat", 15000F, "05314094416");

        // when
        boolean expected = customerRepository.selectExistsSsid(customer.getSsid());

        // then
        assertFalse(expected);
    }

    @Test
    void shouldFindCustomerBySsid(){
        // given
        Customer actual = new Customer(19250706428L, "Harun Murat", 15000F, "05314094416");
        customerRepository.save(actual);

        // when
        Customer expected = customerRepository.findBySsid(actual.getSsid()).get();

        //then
        assertAll(
                ()-> assertNotNull(expected),
                ()-> assertEquals(expected.getSsid(), actual.getSsid())
        );
    }

}