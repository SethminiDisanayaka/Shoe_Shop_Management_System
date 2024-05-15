package lk.ijse.gdse66.Backend.service;

import lk.ijse.gdse66.Backend.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    InventoryDTO saveItem(InventoryDTO dto);
    InventoryDTO updateItem(InventoryDTO dto);
    boolean deleteItem(String id);
    List<InventoryDTO> getAllItems();
    List<InventoryDTO> searchItem(String id);
}
