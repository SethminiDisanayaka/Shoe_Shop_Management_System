package lk.ijse.gdse66.Backend.service;

import lk.ijse.gdse66.Backend.dto.CustomDTO;
import lk.ijse.gdse66.Backend.dto.EmployeeDTO;
import lk.ijse.gdse66.Backend.dto.SupplierDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO dto);
    SupplierDTO updateSupplier(SupplierDTO dto);
    boolean deleteSupplier(String id);
    List<SupplierDTO> getAllSuppliers();

    @ResponseBody
    CustomDTO supplierIdGenerate();
}
