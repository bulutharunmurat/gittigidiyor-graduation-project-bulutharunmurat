package dev.patika.creditscorecalculator.controller;

import dev.patika.creditscorecalculator.DTO.CustomerDTO;
import dev.patika.creditscorecalculator.entity.Customer;
import dev.patika.creditscorecalculator.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findAll(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/customers/{ssid}")
    public ResponseEntity<Customer> findCustomerBySsid(@PathVariable long ssid){
        return new ResponseEntity<>(customerService.findBySsid(ssid), HttpStatus.OK);
    }
    @DeleteMapping("/customers/{ssid}")
    public String deleteCustomerBySsid(@PathVariable long ssid){
        customerService.deleteBySsid(ssid);
        return "Customer with " + ssid + " SSID deleted";
    }
    @PostMapping("/customers")
    public Customer saveCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        return customerService.save(customerDTO);
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        return customerService.update(customerDTO);
    }
}
