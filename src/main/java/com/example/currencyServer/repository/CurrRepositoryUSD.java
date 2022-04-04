package com.example.currencyServer.repository;

import com.example.currencyServer.model.CurrencyEURModel;
import com.example.currencyServer.model.CurrencyUSDModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;

public interface CurrRepositoryUSD extends JpaRepository<CurrencyUSDModel, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT date,value from currencyrub;"
    )
    HashMap<String,String> selectDateAndValue();
}
