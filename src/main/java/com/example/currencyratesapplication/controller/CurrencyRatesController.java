package com.example.currencyratesapplication.controller;

import com.example.currencyratesapplication.model.CurrencyRateDTO;
import com.example.currencyratesapplication.model.CurrencyRateValue;
import com.example.currencyratesapplication.service.CurrencyRatesService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
@RequestMapping("${app.mapping.path}")
@RequiredArgsConstructor
public class CurrencyRatesController {

    private final CurrencyRatesService ratesService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CurrencyRateValue getCurrencyRatesByDate(@RequestParam("fetchedOn") @NotNull
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                        @JsonFormat(pattern = "yyyy-MM-dd") LocalDate fetchedOn){
        return ratesService.getCurrencyRatesByDate(fetchedOn);
    }


    @GetMapping("/history")
    @ResponseStatus(HttpStatus.OK)
    public List<CurrencyRateDTO> getHistoryOfCurrencyRatesSearching(){
        return ratesService.getHistoryOfCurrencyRatesSearching();
    }

}
