package org.cp.LLD.currency.service;

import org.cp.LLD.currency.entity.Currency;
import org.cp.LLD.currency.entity.CurrencyExchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CurrencyExchangeManager {
    public static double exchangeCurrency(Currency start, Currency end, List<CurrencyExchange> currencyExchanges, int currencyCnt){
        List<CurrencyExchange> duplicateExchanges = new ArrayList<>();
        int n = currencyExchanges.size();

        for(int i = 0; i < n; i++){
            duplicateExchanges.add(new CurrencyExchange(currencyExchanges.get(i).getStartCurrency(),
                    currencyExchanges.get(i).getEndCurrency(),
                    -Math.log10(currencyExchanges.get(i).getValue())));

            duplicateExchanges.add(new CurrencyExchange(currencyExchanges.get(i).getEndCurrency(),
                    currencyExchanges.get(i).getStartCurrency(),
                    Math.log10(1/currencyExchanges.get(i).getValue())));
        }

        HashMap<Currency, Double> disMap = new HashMap<>();

        for(int i = 0; i < duplicateExchanges.size(); i++){
            disMap.put(duplicateExchanges.get(i).getStartCurrency(), Double.MAX_VALUE);
            disMap.put(duplicateExchanges.get(i).getEndCurrency(), Double.MAX_VALUE);
        }

        disMap.put(start, 0.0);

        for(int i = 1; i < currencyCnt; i++){
            for(CurrencyExchange currencyExchange : duplicateExchanges){
                Currency startCurrency = currencyExchange.getStartCurrency();
                Currency endCurrency = currencyExchange.getEndCurrency();

                if(disMap.get(endCurrency) > disMap.get(startCurrency) + currencyExchange.getValue()){
                    disMap.put(endCurrency, disMap.get(startCurrency) + currencyExchange.getValue());
                }
            }
        }

        if(disMap.get(end) == Double.MAX_VALUE) return 0;

        System.out.println(-disMap.get(end));
        return Math.pow(10, -disMap.get(end));
    }
}
