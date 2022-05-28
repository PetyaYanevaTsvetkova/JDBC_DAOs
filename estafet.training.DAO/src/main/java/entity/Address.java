package entity;

import lombok.*;

import javax.persistence.*;
import javax.swing.*;
import java.io.Serializable;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * Class of type POJO using Annotations.
 * 'Column' annotations are with 'name' value same as that of SQL column.
 * The fields are with same type as that of SQL column.
 * The annotation 'Entity' is required to mark the class capable of hold database values.
 * The annotation 'Build' is required to use Builder Design Pattern for creating a instance of type Address.
 */
public class Address implements Serializable {
    @Id
    @Column(name = "address_id")
    private Long address_id;
    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "customer_id")
    private Long customer_id;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "province")
    private String province;
    @Column(name = "state_uk")
    public String state_uk;
    @Column(name = "postal_code")
    private Integer postal_code;
    @Column(name = "country")
    private String country;
}
