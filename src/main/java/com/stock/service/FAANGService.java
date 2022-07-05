package com.stock.service;

import com.stock.domain.Stock;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FAANGService implements StockService {

    @Override
    public List<Stock> getStocks(List<String> symbols) {
        if(symbols.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
       List<Stock> stocks = new ArrayList<>();

        for (String symbol : symbols) {
            for (Stock stock : generateStock()) {
                if (symbol.equals(stock.getSymbol())) {
                    stocks.add(stock);
                }
            }
        }

        return stocks;
    }

    @Override
    public List<String> getStockNames() {
        return Arrays.asList("AAPL","GOOG","FB", "AMZN", "TWTR");
    }


    private List<Stock> generateStock() {
        Stock stockAPPL = generateStock("AAPL");
        Stock stockGOOG = generateStock("GOOG");
        Stock stockFB = generateStock("FB");
        Stock stockAMZN = generateStock("AMZN");
        Stock stockTWTR = generateStock("TWTR");

        List<Stock> stocks = new ArrayList<>();
        stocks.add(stockAPPL);
        stocks.add(stockGOOG);
        stocks.add(stockFB);
        stocks.add(stockAMZN);
        stocks.add(stockTWTR);

        return stocks;
    }

    private Stock generateStock(String symbol) {
        BigDecimal lastTradePriceOnly = generateRandomBigDecimalFromRange(BigDecimal.valueOf(-500L),
                BigDecimal.valueOf(5_000L));
        BigDecimal change = generateRandomBigDecimalFromRange(BigDecimal.valueOf(-500L),
                BigDecimal.valueOf(1000L));
        BigDecimal changeInPercent = generateRandomBigDecimalFromRange(BigDecimal.valueOf(0.022465907), BigDecimal.valueOf(1L));

        return new Stock(symbol, lastTradePriceOnly, change, changeInPercent);
    }

    private static BigDecimal generateRandomBigDecimalFromRange(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
