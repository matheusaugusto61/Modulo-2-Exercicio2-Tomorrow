package com.example.apicontroleestoque.Domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Stock implements Serializable {
    private static final long serialVersionUID=1L;

    public Stock(String name) {
        this.name = name;
    }

    public Stock() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy="stock")
    private List<Product> listProdutc = new ArrayList<>();

}
