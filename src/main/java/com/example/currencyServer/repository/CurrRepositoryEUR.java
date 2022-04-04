package com.example.currencyServer.repository;

import com.example.currencyServer.model.CurrencyEURModel;
import com.example.currencyServer.model.CurrencyUSDModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CurrRepositoryEUR extends JpaRepository<CurrencyEURModel , Long> {
}
