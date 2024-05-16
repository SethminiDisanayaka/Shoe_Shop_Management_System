package lk.ijse.gdse66.Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleDTO {

   private String orderNo;
   private String customerName;
   private LocalDateTime purchaseDate;
   private Double total;
   private String paymentMethod;
   private Double totalPoints;
   private String cashier;
}
