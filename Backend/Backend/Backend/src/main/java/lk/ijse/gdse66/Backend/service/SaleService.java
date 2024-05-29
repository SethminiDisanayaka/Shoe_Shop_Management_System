package lk.ijse.gdse66.Backend.service;


import lk.ijse.gdse66.Backend.dto.SalesDTO;

import java.util.List;

public interface SaleService {
    List<SalesDTO> getAllSales();
    SalesDTO getSaleDetails(String id);
    SalesDTO saveSales(SalesDTO salesDTO);
    void updateSales(String id, SalesDTO salesDTO);
    void deleteSales(String id);
    String nextOrderCode();
}
