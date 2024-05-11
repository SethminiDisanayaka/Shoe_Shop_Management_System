package lk.ijse.gdse66.Backend.enttity;

import jakarta.persistence.*;
import lk.ijse.gdse66.Backend.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "supplier")
public class SupplierEntity {
    @Id
    private String supplierCode;
    private String supplierName;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String address;
    private String contactNo1;
    private String contactNo2;
    private String email;
}
