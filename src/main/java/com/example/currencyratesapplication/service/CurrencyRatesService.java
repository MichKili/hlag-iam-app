package com.example.currencyratesapplication.service;

import com.example.currencyratesapplication.model.CurrencyRateDTO;
import com.example.currencyratesapplication.model.CurrencyRateValue;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface CurrencyRatesService {
    CurrencyRateValue getCurrencyRatesByDate(LocalDate fetchedOn);

    List<CurrencyRateDTO> getHistoryOfCurrencyRatesSearching();
}
