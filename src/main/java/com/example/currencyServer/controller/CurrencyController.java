package com.example.currencyServer.controller;

import com.example.currencyServer.model.CurrencyEURModel;
import com.example.currencyServer.model.CurrencyRUBModel;
import com.example.currencyServer.model.CurrencyUSDModel;
import com.example.currencyServer.repository.CurrRepositoryEUR;
import com.example.currencyServer.repository.CurrRepositoryRUB;
import com.example.currencyServer.repository.CurrRepositoryUSD;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
public class CurrencyController {
    private static final String token = "5247380242:AAEaCpLJi-e0e3QxnmZCslPpWa5Sppel3s8";
    private static final String usdLink = "http://www.finmarket.ru/currency/rates/?id=10123&pv=1#archive";
    private static final String eurLink = "http://www.finmarket.ru/currency/rates/?id=10123&pv=1&cur=52170#archive";
    private static final String rubLink = "http://www.finmarket.ru/currency/rates/?id=10123&pv=1&cur=52144#archive";


    @Autowired
    CurrRepositoryEUR currRepositoryEUR;
    @Autowired
    CurrRepositoryUSD currRepositoryUSD;
    @Autowired
    CurrRepositoryRUB currRepositoryRUB;

    @SneakyThrows
    @GetMapping("/getUSD")
    public List<CurrencyUSDModel> getUSD(){
        setUSD();
        //currRepositoryUSD.deleteClones();
        return currRepositoryUSD.findAll();
    }

    @SneakyThrows
    @GetMapping("/getRUB")
    public List<CurrencyRUBModel> getRUB(){
        setRUB();
//        currRepositoryRUB.deleteClones();
        return currRepositoryRUB.findAll();
    }

    @SneakyThrows
    @GetMapping("/getEUR")
    public List<CurrencyEURModel> getEUR(){
        setEUR();
        return currRepositoryEUR.findAll();
    }

    public void setUSD() throws IOException {
        Document doc = Jsoup.connect(usdLink).get();
        Elements table = doc.select(".noborder");

        for (int i = 0; i < 11; i++) {

            CurrencyUSDModel currencyUSDModel = new CurrencyUSDModel();
            //currencyUSDModel.setId(UUID.randomUUID().toString());
            currencyUSDModel.setDate(table.text().substring(0,5));
            currencyUSDModel.setValue((table.text().substring(13,19).replaceAll("," , ".")));
            currRepositoryUSD.save(currencyUSDModel);
            table = table.prev();
        }

    }

    public void setRUB() throws IOException {
        Document doc = Jsoup.connect(rubLink).get();
        Elements table = doc.select(".noborder");

        for (int i = 0; i < 11; i++) {

            CurrencyRUBModel currencyRUBModel = new CurrencyRUBModel();
            //currencyRUBModel.setId(UUID.randomUUID().toString());
            currencyRUBModel.setDate(table.text().substring(0,5));
            currencyRUBModel.setValue((table.text().substring(13,17).replaceAll("," , ".")));
            currRepositoryRUB.save(currencyRUBModel);
            table = table.prev();
        }

    }
    public void setEUR() throws IOException {
        Document doc = Jsoup.connect(eurLink).get();
        Elements table = doc.select(".noborder");

        for (int i = 0; i < 11; i++) {

            CurrencyEURModel currencyEURModel = new CurrencyEURModel();
            //currencyEURModel.setId(UUID.randomUUID().toString());
            currencyEURModel.setDate(table.text().substring(0,5));
            currencyEURModel.setValue((table.text().substring(13,19).replaceAll("," , ".")));
            currRepositoryEUR.save(currencyEURModel);
            table = table.prev();
        }

    }


}

