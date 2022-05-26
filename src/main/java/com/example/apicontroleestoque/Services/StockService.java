package com.example.apicontroleestoque.Services;

import com.example.apicontroleestoque.DTOs.StockDTO;
import com.example.apicontroleestoque.Domains.Stock;
import com.example.apicontroleestoque.Repositories.StockRepository;
import com.example.apicontroleestoque.Services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    public List<Stock> findAll(){
        return stockRepository.findAll();
    }

    public Stock findById(Long id){
        Optional<Stock> stock = stockRepository.findById(id);
        return stock.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Stock.class.getName()));
    }

    public void save(Stock stock){
        stock.setId(null);
        stockRepository.save(stock);
    }

    public Stock fromDTO(StockDTO stockDTO) {
        return new Stock(stockDTO.getName());
    }
}
