package dev.patika.creditscorecalculator.mappers;

import dev.patika.creditscorecalculator.DTO.CustomerDTO;
import dev.patika.creditscorecalculator.entity.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer mapFromCustomerDTOtoCustomer(CustomerDTO customerDTO);
    CustomerDTO mapFromCustomertoCustomerDTO(Customer customer);

}
