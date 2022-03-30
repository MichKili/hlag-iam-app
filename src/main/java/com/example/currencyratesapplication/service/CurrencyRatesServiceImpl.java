package com.example.currencyratesapplication.service;

import com.example.currencyratesapplication.converter.CurrencyRatesConverter;
import com.example.currencyratesapplication.domain.CurrencyRateEntity;
import com.example.currencyratesapplication.exception.JsonConversionException;
import com.example.currencyratesapplication.exception.RatesNotFoundException;
import com.example.currencyratesapplication.model.CurrencyRateDTO;
import com.example.currencyratesapplication.model.CurrencyRateValue;
import com.example.currencyratesapplication.repository.CurrencyRateRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyRatesServiceImpl implements CurrencyRatesService {

    private final RestTemplate restTemplate;
    private final CurrencyRateRepository currencyRateRepository;
    private final CurrencyRatesConverter currencyRatesConverter;


    @Override
    public CurrencyRateValue getCurrencyRatesByDate(LocalDate fetchedOn) {
        String forObject = restTemplate.getForObject("https://api.frankfurter.app/" + fetchedOn + "?to=USD", String.class);
        String rate = parseRateFromResponse(forObject);
        CurrencyRateEntity currencyRateEntity = createCurrencyRateEntity(fetchedOn, rate);
        currencyRateRepository.save(currencyRateEntity);
        return new CurrencyRateValue(Double.parseDouble(rate));
    }

    private CurrencyRateEntity createCurrencyRateEntity(LocalDate fetchedOn, String rate) {
        CurrencyRateEntity currencyRateEntity = new CurrencyRateEntity();
        currencyRateEntity.setRate(Double.parseDouble(rate));
        currencyRateEntity.setCreatedOn(OffsetDateTime.now());
        currencyRateEntity.setFetchedOn(fetchedOn);
        return currencyRateEntity;
    }

    private String parseRateFromResponse(String forObject) {
        ObjectNode node = null;
        try {
            node = new ObjectMapper().readValue(forObject, ObjectNode.class);
        } catch (JsonProcessingException e) {
            throw new JsonConversionException(e.getMessage());
        }
        if (node != null && node.has("rates")) {
            JsonNode rates = node.get("rates");
            return rates.get("USD").asText();

        }
        throw new RatesNotFoundException("Rates not found.");
    }

    @Override
    public List<CurrencyRateDTO> getHistoryOfCurrencyRatesSearching() {
        Sort sort = Sort.by(Sort.Direction.DESC, "fetchedOn");
        List<CurrencyRateEntity> all = currencyRateRepository.findAll(sort);
        return all
                .stream()
                .map(currencyRatesConverter::convertToCurrencyRateDTO)
                .collect(Collectors.toList());
    }


}
