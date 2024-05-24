package lk.ijse.gdse66.Backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleDTO {

   private List<SalesDetailsDTO> salesDetails;

   @NotBlank(message = "Order number is required")
   @Pattern(regexp = "^ORD\\d{4}$", message = "Invalid order number format. Must start with 'ORD' followed by 4 digits.")
   private String orderNo;

   @NotBlank
   @Pattern(regexp = "^[a-zA-Z]+(?:[ '-][a-zA-Z]+)*$", message = "Invalid name format")
   private String customerName;

   @NotNull(message = "Total price is required")
   private Double totalPrice;

   @NotNull(message = "Purchase date is required")
   private Date purchaseDate;

   @NotBlank(message = "Payment method is required")
   @Pattern(regexp = "^(CASH|CARD)$", message = "Invalid payment method. Must be 'cash' or 'card'.")
   private String paymentMethod;

   private Double addedPoints;

   @NotBlank(message = "Cashier name is required")
   @Pattern(regexp = "^[a-zA-Z]+(?:[ '-][a-zA-Z]+)*$", message = "Invalid name format")
   private String cashierName;
}
