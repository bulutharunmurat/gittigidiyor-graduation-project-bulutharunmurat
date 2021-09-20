package dev.patika.creditscorecalculator.service;

import dev.patika.creditscorecalculator.exceptions.CustomerAlreadyExists;
import dev.patika.creditscorecalculator.DTO.CustomerDTO;
import dev.patika.creditscorecalculator.entity.Customer;
import dev.patika.creditscorecalculator.exceptions.CustomerAlreadyExists;
import dev.patika.creditscorecalculator.mappers.CustomerMapper;
import dev.patika.creditscorecalculator.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    CustomerRepository mockCustomerRepository;
    @Mock
    CustomerMapper mockCustomerMapper;
    @InjectMocks
    CustomerService customerService;

    @Test
    void findAll() {
    }

    @Test
    void findBySsid() {
        //given
        Customer expected = new Customer();
        expected.setSsid(1);
        when(mockCustomerRepository.findBySsid(anyLong())).thenReturn(java.util.Optional.of(expected));

        //when
        Customer actual = this.customerService.findBySsid(1);

        //then
        assertAll(
                ()-> assertNotNull(actual),
                ()-> assertEquals(expected, actual),
                ()-> assertEquals(expected.getSsid(), actual.getSsid())
        );
    }

    @Test
    void update() {
        //given
        Customer expected = new Customer();
        expected.setCustomerName("Murat");
        when(mockCustomerRepository.save(any())).thenReturn(expected);
        when(mockCustomerMapper.mapFromCustomerDTOtoCustomer(any())).thenReturn(expected);

        //when
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerName("Murat");
        Customer actual = this.customerService.update(customerDTO);

        //then
        assertAll(
                ()-> assertNotNull(actual),
                ()-> assertEquals(expected, actual),
                ()-> assertEquals(expected.getCustomerName(), actual.getCustomerName())
        );
    }

    @Test
    void save() {

        //given
        Customer expected = new Customer();
        expected.setCustomerSalary(5000F);
        when(mockCustomerRepository.save(any())).thenReturn(expected);
        when(mockCustomerMapper.mapFromCustomerDTOtoCustomer(any())).thenReturn(expected);

        //when
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerSalary(5000F);
        Customer actual = this.customerService.save(customerDTO);

        //then
        assertAll(
                ()-> assertNotNull(actual),
                ()-> assertEquals(expected, actual)
        );
    }

    @Test
    void savingExistingCustomer() {

        //given
        Customer expected = new Customer();
        when(mockCustomerRepository.selectExistsSsid(anyLong())).thenReturn(Boolean.TRUE);

        //when
        CustomerDTO customerDTO = new CustomerDTO();
        Executable executable = ()-> this.customerService.save(customerDTO);

        //then
        assertThrows(CustomerAlreadyExists.class, executable);
    }

    @Test
    void deleteBySsid() {

    }
}