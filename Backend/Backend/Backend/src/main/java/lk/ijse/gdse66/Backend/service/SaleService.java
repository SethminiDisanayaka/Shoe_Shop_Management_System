package lk.ijse.gdse66.Backend.service;

import lk.ijse.gdse66.Backend.dto.SaleDTO;

import java.util.List;

public interface SaleService {
    List<SaleDTO> getAllSales();
    SaleDTO getSaleDetails(String id);
    SaleDTO saveSales(SaleDTO salesDTO);
    void updateSales(String id, SaleDTO salesDTO);
    void deleteSales(String id);
}
