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
   private String itemName;
   private String price;
   private int orderQty;
   private double total;
}
