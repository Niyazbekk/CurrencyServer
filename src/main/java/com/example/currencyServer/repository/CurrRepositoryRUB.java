package com.example.currencyServer.repository;

import com.example.currencyServer.model.CurrencyEURModel;
import com.example.currencyServer.model.CurrencyRUBModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CurrRepositoryRUB extends JpaRepository<CurrencyRUBModel, Long> {
}
