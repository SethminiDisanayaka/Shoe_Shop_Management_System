package lk.ijse.gdse66.Backend.enttity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class AdminEntity {
    @Id
    private String adminId;
    private double totalSales;
    private double totalProfit;
    private String  mostSaleItem;
    private String mostSaleItemPic;
    private int mostSaleItemQty;
}
