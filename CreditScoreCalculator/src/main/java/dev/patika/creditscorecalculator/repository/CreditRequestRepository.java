package dev.patika.creditscorecalculator.repository;

import dev.patika.creditscorecalculator.entity.CreditRequestResponse;
import org.springframework.data.repository.CrudRepository;

public interface CreditRequestRepository extends CrudRepository<CreditRequestResponse, Integer> {
}
