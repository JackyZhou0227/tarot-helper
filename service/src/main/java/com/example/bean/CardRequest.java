package com.example.bean;

import lombok.Data;

import java.util.List;

@Data
public class CardRequest {

    private List<Card> cards;

    private String question;
}
