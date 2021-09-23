package dev.patika.creditscorecalculator.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data //-> @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode, @ToString
@Table(name = "Customer")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends AbstractBaseEntity{


//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    @Id
    private long ssid; // Customer SSID considered as an unique ID.
    private String customerName;
    private Float customerSalary;
    private String customerPhoneNumber;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CreditRequestResponse> creditRequestResponse = new ArrayList<>();

    public Customer(long ssid, String customerName, Float customerSalary, String customerPhoneNumber) {
        this.ssid = ssid;
        this.customerName = customerName;
        this.customerSalary = customerSalary;
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
