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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long ssid;
    private String customerName;
    private Float customerSalary;
    private String customerPhoneNumber;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CreditResponse> creditResponseList = new ArrayList<>();

}
