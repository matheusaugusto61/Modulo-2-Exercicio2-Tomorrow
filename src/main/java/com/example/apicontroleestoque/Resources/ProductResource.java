package com.example.apicontroleestoque.Resources;

import com.example.apicontroleestoque.DTOs.ProductDTO;
import com.example.apicontroleestoque.Domains.Product;
import com.example.apicontroleestoque.Domains.Stock;
import com.example.apicontroleestoque.Services.ProductService;
import com.example.apicontroleestoque.Services.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping(value = "stock/{idStock}/product")
public class ProductResource {


    private StockService stockService;
    private ProductService productService;

    public ProductResource(StockService stockService, ProductService productService){
        this.stockService = stockService;
        this.productService = productService;
    }

    @RequestMapping(value = "/{idProduct}", method = RequestMethod.GET)
    public ResponseEntity<Product> findById(@PathVariable("idStock") Long stockId, @PathVariable("idProduct") Long productId){
        Stock stock = stockService.findById(stockId);
        Product product = productService.findById(productId);
        return ResponseEntity.ok().body(product);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAll(@PathVariable("idStock") Long stockId){
        Stock stock = stockService.findById(stockId);
        return ResponseEntity.ok().body(productService.findByStock(stock));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@PathVariable("idStock") Long stockId, ProductDTO productDTO){
        Stock stock = stockService.findById(stockId);
        Product product = productService.fromDTO(productDTO, stock);
        productService.insert(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
