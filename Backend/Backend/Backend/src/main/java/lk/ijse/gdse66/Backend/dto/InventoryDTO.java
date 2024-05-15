package lk.ijse.gdse66.Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryDTO {
    private String itemCode;
    private String itemDesc;
    private String itemPicture;
    private String category;
    private int size;
    private int quantity;
    private String supplierCode;
    private String supplierName;
    private double unitPriceSale;
    private double unitPriceBuy;
    private double expectProfit;
    private double profitMargin;
    private String status;
}
