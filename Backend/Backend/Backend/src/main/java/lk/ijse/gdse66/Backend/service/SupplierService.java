package lk.ijse.gdse66.Backend.service;

import lk.ijse.gdse66.Backend.dto.EmployeeDTO;
import lk.ijse.gdse66.Backend.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO dto);
    SupplierDTO updateSupplier(SupplierDTO dto);
    void deleteSupplier(String supplierCode);
    List<SupplierDTO> getAllSuppliers();
}
