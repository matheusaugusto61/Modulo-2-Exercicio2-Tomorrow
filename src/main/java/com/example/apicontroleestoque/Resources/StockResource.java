package com.example.apicontroleestoque.Resources;

import com.example.apicontroleestoque.DTOs.StockDTO;
import com.example.apicontroleestoque.Domains.Stock;
import com.example.apicontroleestoque.Repositories.StockRepository;
import com.example.apicontroleestoque.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockResource {

    private StockService stockService;

    public StockResource(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Stock>> findAll(){
        List<Stock> listStock = stockService.findAll();
        return ResponseEntity.ok().body(listStock);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody StockDTO stockDto){
        Stock stock = stockService.fromDTO(stockDto);
        stockService.save(stock);
        return ResponseEntity.ok().build();
    }
}
