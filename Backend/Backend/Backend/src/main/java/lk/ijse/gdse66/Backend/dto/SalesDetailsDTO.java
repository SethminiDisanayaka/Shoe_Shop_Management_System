package lk.ijse.gdse66.Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesDetailsDTO {

    private String id;

    private InventoryDTO inventoryDTO;

    private String itemDesc;

    private Integer size;

    private double unitPriceSale;

    private Integer quantity;

    private SaleDTO sales;

}
