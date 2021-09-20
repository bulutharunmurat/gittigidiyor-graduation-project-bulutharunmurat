package dev.patika.creditscorecalculator.repository;

import dev.patika.creditscorecalculator.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE c.ssid=?1")
    Optional<Customer> findBySsid(long ssid);

    @Query("SELECT " +
            "  CASE " +
            "   WHEN " +
            "       COUNT(c)>0 " +
            "   THEN " +
            "       TRUE " +
            "   ELSE " +
            "       FALSE " +
            "   END " +
            "FROM Customer c " +
            "WHERE c.ssid = ?1")
    boolean selectExistsSsid(long ssid);
}
