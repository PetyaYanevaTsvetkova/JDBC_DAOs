package entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Class of type POJO using Annotations.
 * 'Column' annotations are with 'name' value same as that of SQL column.
 * The fields are with same type as that of SQL column.
 * The annotation 'Entity' is required to mark the class capable of hold database values.
 */
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
