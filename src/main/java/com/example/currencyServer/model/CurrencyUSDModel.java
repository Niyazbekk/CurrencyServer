package com.example.currencyServer.model;

import lombok.*;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "CurrencyUSD")
public class CurrencyUSDModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    private String date;
    private String value;


}
