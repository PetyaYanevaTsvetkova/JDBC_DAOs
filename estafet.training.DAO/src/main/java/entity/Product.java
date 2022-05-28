package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    private Long product_id;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "available_quantity")
    private Integer available_quantity;
    @Column(name = "product_type")
    private String product_type;
    @Column(name = "price_without_VAT")
    private Double price_without_VAT;
    @Column(name = "price_with_VAT")
    private Double price_with_VAT;
    @Column(name = "is_product_in_stock")
    private boolean is_product_in_stock;
    @Column(name = "warehouse")
    private String warehouse;
}
