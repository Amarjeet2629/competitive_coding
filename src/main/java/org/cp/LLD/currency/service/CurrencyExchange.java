package org.cp.LLD.currency.service;

import org.cp.LLD.currency.entity.Currency;
import org.cp.LLD.currency.entity.CurrencyExchangeValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CurrencyExchange implements ICurrencyExchangeStrategy {
    List<CurrencyExchangeValue> currencyExchangeValues = new ArrayList<>();

    public CurrencyExchange(List<CurrencyExchangeValue> currencyExchangeValues){
        this.currencyExchangeValues = currencyExchangeValues;
    }

    private double checkAllWaysToExchange(Currency start, Currency end,  HashMap<Currency, List<CurrencyExchangeValue>> graph, double value,  HashMap<Currency, Boolean> visitedMap){
        if(start == end) {
            return value;
        };

        visitedMap.put(start, true);
        double result = 0;

        for(CurrencyExchangeValue currencyExchangeValue: graph.getOrDefault(start, new ArrayList<>())){
            if(!visitedMap.getOrDefault(currencyExchangeValue.getEndCurrency(), false)){

                result = Math.max(
                        checkAllWaysToExchange(currencyExchangeValue.getEndCurrency(),
                        end, graph,
                        value * currencyExchangeValue.getValue(),
                        visitedMap), result);
            }
        }
        visitedMap.put(start, false);
        return result;
    }

    @Override
    public double exchange(Currency start, Currency end) {
        HashMap<Currency, List<CurrencyExchangeValue>> currencyExchangeValueHashMap = new HashMap<>();
        for(CurrencyExchangeValue currencyExchangeValue : currencyExchangeValues){
            Currency startCurrency = currencyExchangeValue.getStartCurrency();
            List<CurrencyExchangeValue> exchangeValueList = currencyExchangeValueHashMap.getOrDefault(
                    currencyExchangeValue.getStartCurrency(),
                    new ArrayList<>());
            exchangeValueList.add(currencyExchangeValue);
            currencyExchangeValueHashMap.put(startCurrency, exchangeValueList);

            //reverse mapping
            Currency endCurrency = currencyExchangeValue.getEndCurrency();
            List<CurrencyExchangeValue> reversExchangeValueList = currencyExchangeValueHashMap.getOrDefault(
                    currencyExchangeValue.getEndCurrency(),
                    new ArrayList<>());

            reversExchangeValueList.add(
                    new CurrencyExchangeValue(
                            currencyExchangeValue.getEndCurrency(),
                            currencyExchangeValue.getStartCurrency(),
                            1.0/currencyExchangeValue.getValue()));

            currencyExchangeValueHashMap.put(endCurrency, reversExchangeValueList);
        }

        HashMap<Currency, Boolean> visitedMap = new HashMap<>();

        return checkAllWaysToExchange(start, end, currencyExchangeValueHashMap, 1.0, visitedMap);
    }
}
