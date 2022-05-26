package com.example.apicontroleestoque.Repositories;

import com.example.apicontroleestoque.Domains.Product;
import com.example.apicontroleestoque.Domains.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findProductByStock(Stock stock);
}
