package dev.patika.creditscorecalculator.controller;

import dev.patika.creditscorecalculator.DTO.CustomerDTO;
import dev.patika.creditscorecalculator.entity.Customer;
import dev.patika.creditscorecalculator.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    CustomerService mockCustomerService;
    @InjectMocks
    CustomerController customerController;

    @Test
    void findAll() {
    }

    @Test
    void shouldFindCustomerBySsid() {
        //given
        Customer expected = new Customer();
        expected.setSsid(1);
        when(mockCustomerService.findBySsid(anyLong())).thenReturn(expected);

        //when
        Customer actual = this.customerController.findCustomerBySsid(1).getBody();

        //then
        assertAll(
                ()-> assertNotNull(actual),
                ()-> assertEquals(expected, actual),
                ()-> assertEquals(expected.getSsid(), actual.getSsid())
        );
    }

    @Test
    void shouldDeleteCustomerBySsid() {
        //given
        String expected = "Customer with " + 1 + " SSID deleted";;

        //when
        String actual = this.customerController.deleteCustomerBySsid(1);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void shouldSaveCustomer() {
        //given
        Customer expected = new Customer();
        expected.setCustomerName("Murat");
        when(mockCustomerService.save(any())).thenReturn(expected);

        //when
        CustomerDTO customerDTO = new CustomerDTO();
        Customer actual = this.customerController.saveCustomer(customerDTO);

        //then
        assertAll(
                ()-> assertNotNull(actual),
                ()-> assertEquals(expected, actual),
                ()-> assertEquals(expected.getCustomerName(), actual.getCustomerName())
        );
    }

    @Test
    void shouldUpdateCustomer() {
        //given
        Customer expected = new Customer();
        when(mockCustomerService.update(any())).thenReturn(expected);

        //when
        CustomerDTO customerDTO = new CustomerDTO();
        Customer actual = this.customerController.updateCustomer(customerDTO);

        //then
        assertAll(
                ()-> assertNotNull(actual),
                ()-> assertEquals(expected, actual)
        );
    }
}