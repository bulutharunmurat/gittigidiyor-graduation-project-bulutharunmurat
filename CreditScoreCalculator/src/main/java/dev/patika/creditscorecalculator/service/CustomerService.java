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
public class CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private static Logger logger = Logger.getLogger(CustomerService.class);

    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Iterable<Customer> customers = customerRepository.findAll();
        customers.iterator().forEachRemaining(customerList::add);
        return customerList;
    }

    public Customer findBySsid(long customerSSID) {
        Customer customer = customerRepository.findBySsid(customerSSID)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer with SSID: %d could not found!", customerSSID)));
        return customer;
    }

    // Customer SSID considered as an unique and cannot be change in future
    @Transactional
    public Customer update(CustomerDTO customerDTO) {
        Customer customer = customerMapper.mapFromCustomerDTOtoCustomer(customerDTO);
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer save(CustomerDTO customerDTO) {

        boolean isCustomerDtoValid = this.checkCustomerDTOValidity(customerDTO);
        boolean isExists = customerRepository.selectExistsSsid(customerDTO.getSsid());
        if(isCustomerDtoValid){
            // SHOULD BE IMPLEMENT
        }
        if(isExists){
            logger.debug("Customer with SSID : " + customerDTO.getSsid() + " is already exists!");
//            Log log = new Log(Instant.now(),"Customer with SSID : " + customerDTO.getSsid() + " is already exists!", "course error");
//            logService.save(log);
            throw new CustomerAlreadyExists("Customer with SSID : " + customerDTO.getSsid() + " is already exists!");
        }
        Customer customer = customerMapper.mapFromCustomerDTOtoCustomer(customerDTO);
        return customerRepository.save(customer);
    }



    // When the customer deleted customer's all credit requests would be delete as well
    public void deleteBySsid(long ssid) {
        customerRepository.deleteById(ssid);
    }

    /**
     * Checks the customerDTO valid or not
     * @param customerDTO
     * @return boolean
     */
    public boolean checkCustomerDTOValidity(CustomerDTO customerDTO){
        // SHOULD BE IMPLEMENT
        return true;
    }
}
