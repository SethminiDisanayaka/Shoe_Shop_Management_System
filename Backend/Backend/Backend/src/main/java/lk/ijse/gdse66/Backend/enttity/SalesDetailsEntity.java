package lk.ijse.gdse66.Backend.enttity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Sales_Details")
public class SalesDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salesId;

    private String itemDescription;

    private Integer size;

    private Double unitPriceSale;

    private int quantity;


}
