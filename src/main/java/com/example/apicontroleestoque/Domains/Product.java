package com.example.apicontroleestoque.Domains;

import com.example.apicontroleestoque.Domains.Enums.Tipo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Product implements Serializable {
    private static final long serialVersionUID=1;

    public Product(String name, String session, String tipo, Integer quantityStock, String brand, Stock stock) {
        this.name = name;
        this.session = session;
        this.tipo = tipo;
        this.quantityStock = quantityStock;
        this.brand = brand;
        this.stock = stock;
    }

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String session;
    private String tipo;
    private Integer quantityStock;
    private String brand;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

}
