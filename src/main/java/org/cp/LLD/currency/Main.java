package org.cp.LLD.currency;

import org.cp.LLD.currency.entity.Currency;
import org.cp.LLD.currency.entity.CurrencyExchangeValue;
import org.cp.LLD.currency.service.CurrencyExchange;
import org.cp.LLD.currency.service.CurrencyExchangeManager;
import org.cp.LLD.currency.service.ICurrencyExchangeStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String ...args){
        List<CurrencyExchangeValue> currencyExchangeList = new ArrayList<>();

        currencyExchangeList.add(new CurrencyExchangeValue(Currency.USD, Currency.INR, 78));
        currencyExchangeList.add(new CurrencyExchangeValue(Currency.INR, Currency.GBR, 1.19));
        currencyExchangeList.add(new CurrencyExchangeValue(Currency.GBR, Currency.YBR, 2.0));
        currencyExchangeList.add(new CurrencyExchangeValue(Currency.BTC, Currency.USD, 10));

        ICurrencyExchangeStrategy currencyExchange = new CurrencyExchange(currencyExchangeList);
        System.out.println(currencyExchange.exchange(Currency.USD, Currency.BTC));


    }
}
