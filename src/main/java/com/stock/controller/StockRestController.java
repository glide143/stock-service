package com.stock.controller;

import com.stock.domain.Stock;
import com.stock.service.StockService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class StockRestController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stocks")
    List<Stock> getStocks(@ApiParam(example = "AAPL,GOOG", value = "Stock Symbol")
    @RequestParam("symbols") String symbol) {
        List<String> symbols = Stream.of(symbol.split(","))
                                  .map(String::trim)
                                  .collect(Collectors.toList());

        return  stockService.getStocks(symbols);
    }


    @GetMapping("/symbols")
    List<String> getStocksSymbols() {
        return stockService.getStockNames();
    }
}
