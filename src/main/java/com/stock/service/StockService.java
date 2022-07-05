package com.stock.service;

import com.stock.domain.Stock;

import java.util.List;

public interface StockService {

    List<Stock> getStocks(List<String> symbols);

    List<String> getStockNames();
}
