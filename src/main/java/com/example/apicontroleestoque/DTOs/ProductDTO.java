package com.example.apicontroleestoque.DTOs;

import com.example.apicontroleestoque.Domains.Stock;
import lombok.Data;

import javax.persistence.*;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private String session;
    private String tipo;
    private Integer quantityStock;
    private String brand;

    public ProductDTO(String name, String session, String tipo, Integer quantityStock, String brand) {
        this.id = null;
        this.name = name;
        this.session = session;
        this.tipo = tipo;
        this.quantityStock = quantityStock;
        this.brand = brand;
    }

    public ProductDTO() {
    }
}
