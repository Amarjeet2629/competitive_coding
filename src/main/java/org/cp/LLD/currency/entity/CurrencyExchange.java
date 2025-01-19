package org.cp.LLD.currency.entity;

public class CurrencyExchange {
    Currency startCurrency;
    Currency endCurrency;
    double value;

    public CurrencyExchange(Currency startCurrency, Currency endCurrency, double value){
        this.startCurrency = startCurrency;
        this.endCurrency = endCurrency;
        this.value = value;
    }

    public Currency getStartCurrency() {
        return startCurrency;
    }

    public Currency getEndCurrency() {
        return endCurrency;
    }

    public double getValue() {
        return value;
    }
}
