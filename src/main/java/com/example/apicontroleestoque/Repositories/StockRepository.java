package com.example.apicontroleestoque.Repositories;

import com.example.apicontroleestoque.Domains.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
