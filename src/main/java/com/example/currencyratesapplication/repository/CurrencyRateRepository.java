package com.example.currencyratesapplication.repository;

import com.example.currencyratesapplication.domain.CurrencyRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRateEntity, Long> {
}
