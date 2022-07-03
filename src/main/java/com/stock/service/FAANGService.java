package com.stock.service;

import com.stock.domain.Stock;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FAANGService implements StockService {
    private List<Stock> stocks;

    public FAANGService() {
        Stock stockAPPL = new Stock("AAPL", BigDecimal.valueOf(138.93), BigDecimal.valueOf(2.2099915),
                BigDecimal.valueOf(0.01616436));
        Stock stockGOOG = new Stock("GOOG", BigDecimal.valueOf(2181.62), BigDecimal.valueOf(-5.829834),
                BigDecimal.valueOf(-0.0026651279));
        Stock stockFB = new Stock("FB", BigDecimal.valueOf(196.64), BigDecimal.valueOf(0.9900055),
                BigDecimal.valueOf(0.0050600846));
        Stock stockAMZN = new Stock("AMZN", BigDecimal.valueOf(109.56), BigDecimal.valueOf(3.3499985),
                BigDecimal.valueOf(0.031541273));
        Stock stockTWTR = new Stock("TWTR", BigDecimal.valueOf(38.23), BigDecimal.valueOf(0.84000015),
                BigDecimal.valueOf(0.022465907));

        this.stocks = Arrays.asList(stockAPPL,stockGOOG,stockFB,stockAMZN,stockTWTR);
    }

    @Override
    public List<Stock> getStocks() {
        return stocks;
    }

    @Override
    public List<String> getStockNames() {
        return stocks.stream().map(Stock::getSymbol).collect(Collectors.toList());
    }

    @Override
    public Stock findStockByName(String name) {
        return stocks.stream().filter(stock -> stock.getSymbol().equals(name)).findFirst().get();
    }
}
