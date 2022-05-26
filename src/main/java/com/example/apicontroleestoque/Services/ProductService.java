package com.example.apicontroleestoque.Services;

import com.example.apicontroleestoque.DTOs.ProductDTO;
import com.example.apicontroleestoque.Domains.Product;
import com.example.apicontroleestoque.Domains.Stock;
import com.example.apicontroleestoque.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public List<Product> findByStock(Stock stock){
        return productRepository.findProductByStock(stock);
    }

    public void insert(Product product){
        productRepository.save(product);
    }

    public Product fromDTO(ProductDTO productDTO, Stock stock){
        return new Product(productDTO.getName(), productDTO.getSession(), productDTO.getTipo(), productDTO.getQuantityStock(), productDTO.getBrand(), stock);
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow();
    }
}
