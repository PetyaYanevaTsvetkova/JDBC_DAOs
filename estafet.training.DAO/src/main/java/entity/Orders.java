package entity;

import lombok.AllArgsConstructor;
import lombok.CustomLog;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements Serializable {
    @Id
    private Long order_id;
    @Column(name = "customer_id")
    private Long customer_id;
    @Column(name = "is_order_payed")
    private boolean is_order_payed;
    @Column(name = "date_of_order")
    private Date date_of_order;
    @Column(name = "date_order_completed")
    private Date date_order_completed;
}
