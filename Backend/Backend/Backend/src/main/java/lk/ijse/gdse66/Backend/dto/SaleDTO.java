package lk.ijse.gdse66.Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleDTO {
    private String itemCode;
    private String orderNo;
    private String customerName;
    private String itemDesc;
    private int size;
    private double unitPrice;
    private int quantity;
    private double totalPrice;
    private Timestamp purchaseDate;
    private String paymentMethod;
    private double addedPoint;
    private String cashierName;
}
