package dev.patika.creditscorecalculator.controller;

import dev.patika.creditscorecalculator.DTO.CustomerDTO;
import dev.patika.creditscorecalculator.entity.Customer;
import dev.patika.creditscorecalculator.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findAll(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable int id){
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.save(customerDTO);
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.update(customerDTO);
    }
}
