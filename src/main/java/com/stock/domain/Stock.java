package com.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Stock {
    private String symbol;
    private BigDecimal lastTradePriceOnly;
    private BigDecimal change;
    private BigDecimal changeInPercent;

}
