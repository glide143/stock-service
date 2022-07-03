package com.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    private String symbol;
    private BigDecimal lastTradePriceOnly;
    private BigDecimal change;
    private BigDecimal changeInPercent;

}
