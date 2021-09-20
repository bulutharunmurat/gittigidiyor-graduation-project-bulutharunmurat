package dev.patika.creditscorecalculator.repository;

import dev.patika.creditscorecalculator.entity.CreditRequestResponse;
import dev.patika.creditscorecalculator.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CreditRequestRepository extends CrudRepository<CreditRequestResponse, Integer> {
    @Query("SELECT c FROM CreditRequestResponse c WHERE c.customer.ssid=?1")
    List<CreditRequestResponse> findCustomerCreditResponsesWithSsid(long ssid);
}
