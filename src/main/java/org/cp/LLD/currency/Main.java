package org.cp.LLD.currency;

import org.cp.LLD.currency.entity.Currency;
import org.cp.LLD.currency.entity.CurrencyExchange;
import org.cp.LLD.currency.service.CurrencyExchangeManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String ...args){
        List<CurrencyExchange> currencyExchangeList = new ArrayList<>();

        currencyExchangeList.add(new CurrencyExchange(Currency.USD, Currency.INR, 78));
        currencyExchangeList.add(new CurrencyExchange(Currency.INR, Currency.GBR, 1.19));
//        currencyExchangeList.add(new CurrencyExchange(Currency.GBR, Currency.YBR, 2.0));
//        currencyExchangeList.add(new CurrencyExchange(Currency.BTC, Currency.USD, 10));



        System.out.println(CurrencyExchangeManager.exchangeCurrency(Currency.USD, Currency.GBR, currencyExchangeList, 3));


    }
}
