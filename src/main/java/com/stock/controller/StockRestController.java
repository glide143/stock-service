package com.stock.controller;

import com.stock.domain.Stock;
import com.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockRestController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stocks")
    List<Stock> getAllStocks() {
        return  stockService.getStocks();
    }


    @GetMapping("/symbols")
    List<String> getStocksNames() {
        return stockService.getStockNames();
    }
}
