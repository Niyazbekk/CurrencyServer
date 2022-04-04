package com.example.currencyServer;

import com.example.currencyServer.controller.CurrencyController;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CurrencyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyServerApplication.class, args);

	}



}
