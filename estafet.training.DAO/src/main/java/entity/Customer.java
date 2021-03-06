package entity;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Class of type POJO using Annotations.
 * 'Column' annotations are with 'name' value same as that of SQL column.
 * The fields are with same type as that of SQL column.
 * The annotation 'Entity' is required to mark the class capable of hold database values.
 * The annotation 'Build' is required to use Builder Design Pattern for creating an instance of type Customer.
 */
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    @Id()
    @Column(name = "customer_id")
    private Long customer_id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "age")
    private int age;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "postal_code")
    private int postal_code;
    @Column(name = "country")
    private String country;
    @Column(name = "consent_status", nullable = false)
    private boolean consent_status;
    @Column(name = "is_profile_active", nullable = false)
    private boolean is_profile_active;
    @Column(name = "date_profile_created")
    private Date date_profile_created;
    @Column(name = "date_profile_deactivated")
    private Date date_profile_deactivated;
    @Column(name = "reason_for_deactivation")
    private String reason_for_deactivation;
    @Column(name = "notes")
    private String notes;
}


