package dev.patika.creditscorecalculator.service;

import dev.patika.creditscorecalculator.DTO.CustomerDTO;
import dev.patika.creditscorecalculator.entity.Customer;
import dev.patika.creditscorecalculator.exceptions.CustomerAlreadyExists;
import dev.patika.creditscorecalculator.exceptions.CustomerNotFoundException;
import dev.patika.creditscorecalculator.mappers.CustomerMapper;
import dev.patika.creditscorecalculator.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements BaseService<Customer> {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private static Logger logger = Logger.getLogger(CustomerService.class);


    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Iterable<Customer> customers = customerRepository.findAll();
        customers.iterator().forEachRemaining(customerList::add);
        return customerList;
    }

    @Override
    public Customer findById(int customerId) {
        Customer customer = customerRepository.findById((long) customerId)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer with ID: %d could not found!", customerId)));
        return customer;
    }

    @Override
    public void deleteById(int id) {
    }


    @Transactional
    public Customer update(CustomerDTO customerDTO) {
        Customer customer = customerMapper.mapFromCustomerDTOtoCustomer(customerDTO);
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer save(CustomerDTO customerDTO) {

        boolean isExists = customerRepository.selectExistsSsid(customerDTO.getSsid());

        if(isExists){
            logger.info("Customer with SSID : " + customerDTO.getSsid() + " is already exists!");
            throw new CustomerAlreadyExists("Customer with SSID : " + customerDTO.getSsid() + " is already exists!");
        }
        Customer customer = customerMapper.mapFromCustomerDTOtoCustomer(customerDTO);
        return customerRepository.save(customer);
    }


}
