package lk.ijse.gdse66.Backend.dto;

import lk.ijse.gdse66.Backend.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {
    private String supplierCode;
    private String supplierName;
    private Category category;
    private String address;
    private String contactNo1;
    private String contactNo2;
    private String email;
}
