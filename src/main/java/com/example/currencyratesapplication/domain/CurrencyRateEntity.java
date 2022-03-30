package com.example.currencyratesapplication.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "currency_rate")
public class CurrencyRateEntity extends BaseEntity {
    private Double rate;
    private LocalDate fetchedOn;
    private OffsetDateTime createdOn;
}
