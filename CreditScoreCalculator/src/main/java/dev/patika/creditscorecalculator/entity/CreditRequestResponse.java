package dev.patika.creditscorecalculator.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.*;

@Data //-> @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode, @ToString
@Table(name = "CreditResponse")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditRequestResponse extends AbstractBaseEntity{
    public CreditRequestResponse(String creditResponseType, Double creditLimit, Customer customer) {
        this.creditResponseType = creditResponseType;
        this.creditLimit = creditLimit;
        this.customer = customer;
    }

    public CreditRequestResponse(String creditResponseType, Customer customer) {
        this.creditResponseType = creditResponseType;
        this.customer = customer;
    }

    @Id//for persistence context - primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String creditResponseType;
    private Double creditLimit;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Customer customer;
}
