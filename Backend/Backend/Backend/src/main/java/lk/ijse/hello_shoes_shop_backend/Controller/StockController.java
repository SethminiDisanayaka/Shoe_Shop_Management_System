package lk.ijse.hello_shoes_shop_backend.Controller;

import lk.ijse.hello_shoes_shop_backend.Service.StockService;
import lk.ijse.hello_shoes_shop_backend.entity.StockEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping
    public List<StockEntity> getAllStock(){
        List<StockEntity> allStock = stockService.getAllStock();
        return allStock;
    }
}
