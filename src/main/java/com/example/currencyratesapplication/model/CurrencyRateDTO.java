package com.example.currencyratesapplication.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
public class CurrencyRateDTO {

    Double rate;
    LocalDate fetchedOn;
    OffsetDateTime createdOn;
}
