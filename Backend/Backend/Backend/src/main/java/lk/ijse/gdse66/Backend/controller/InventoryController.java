package lk.ijse.gdse66.Backend.controller;

import lk.ijse.gdse66.Backend.dto.CustomerDTO;
import lk.ijse.gdse66.Backend.dto.InventoryDTO;
import lk.ijse.gdse66.Backend.service.CustomerService;
import lk.ijse.gdse66.Backend.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventories")
@CrossOrigin("*")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    public InventoryController(CustomerService customerService) {
        System.out.println("Inventory Working");
    }

    @GetMapping("/getAllItems")
    public List<InventoryDTO> getAllItems(){
        return inventoryService.getAllItems();
    }

    @PostMapping("/save")
    public InventoryDTO save(@RequestBody InventoryDTO inventoryDTO){
        System.out.println(inventoryDTO);
        return inventoryService.saveItem(inventoryDTO);
    }

    @PostMapping("/update")
    public InventoryDTO update(@RequestBody InventoryDTO inventoryDTO){
        System.out.println(inventoryDTO);
        return inventoryService.updateItem(inventoryDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id){
        inventoryService.deleteItem(id);
    }
}
