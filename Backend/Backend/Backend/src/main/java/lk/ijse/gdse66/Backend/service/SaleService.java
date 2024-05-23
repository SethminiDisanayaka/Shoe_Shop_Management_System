package lk.ijse.gdse66.Backend.service;

import lk.ijse.gdse66.Backend.dto.CustomDTO;
import lk.ijse.gdse66.Backend.dto.SaleDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface SaleService {
    List<SaleDTO> getAllOrders();
    SaleDTO getOrderDetails(String id);
    SaleDTO saveOrder(SaleDTO salesDTO);
    void updateOrder(String id, SaleDTO salesDTO);
    void deleteOrder(String id);

    @ResponseBody
    CustomDTO orderGenerateId();
}
