package org.cp.LLD.currency.service;

import org.cp.LLD.currency.entity.Currency;

public interface ICurrencyExchangeStrategy {
    public double exchange(Currency start, Currency end);
}
