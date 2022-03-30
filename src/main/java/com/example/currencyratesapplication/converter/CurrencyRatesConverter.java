package com.example.currencyratesapplication.converter;

import com.example.currencyratesapplication.domain.CurrencyRateEntity;
import com.example.currencyratesapplication.model.CurrencyRateDTO;
import org.springframework.stereotype.Component;

@Component
public class CurrencyRatesConverter {
    public CurrencyRateDTO convertToCurrencyRateDTO(CurrencyRateEntity currencyRateEntity) {
        CurrencyRateDTO currencyRateDTO = new CurrencyRateDTO();
        currencyRateDTO.setRate(currencyRateEntity.getRate());
        currencyRateDTO.setCreatedOn(currencyRateEntity.getCreatedOn());
        currencyRateDTO.setFetchedOn(currencyRateEntity.getFetchedOn());
        return currencyRateDTO;
    }
}
