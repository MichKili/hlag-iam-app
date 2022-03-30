package com.example.currencyratesapplication.model;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;


@Value
@RequiredArgsConstructor
public class CurrencyRateValue {
    Double value;
}
