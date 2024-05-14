package lk.ijse.gdse66.Backend.enttity;


import jakarta.persistence.*;
import lk.ijse.gdse66.Backend.dto.InventoryDTO;
import lk.ijse.gdse66.Backend.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    private String itemCode;
    private String itemDesc;
    private String itemPicture;
    private int size;
    private int quantity;
    private String supplierCode;
    private String supplierName;
    private double unitPriceSale;
    private double unitPriceBuy;
    private double expectProfit;
    private double profitMargin;
    @Enumerated(EnumType.STRING)
    private Status status;
}
