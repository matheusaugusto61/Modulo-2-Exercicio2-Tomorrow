package com.example.apicontroleestoque.DTOs;


import lombok.Data;
import org.springframework.beans.factory.annotation.Required;
@Data
public class StockDTO {

    private String name;

    public StockDTO() {
    }

    public StockDTO(String name) {
        this.name = name;
    }
}
