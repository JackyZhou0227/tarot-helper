package com.example.controller;

import com.example.bean.Card;
import com.example.utils.TarotUtils;
import jakarta.annotation.Resource;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tarot")
public class TarotController {

    @Resource
    private OllamaChatModel ollamaChatModel;

    @GetMapping("basic")
    public ResponseEntity<String> basic(String question) {
        List<Card> cards = TarotUtils.getRandomCards(3);
        String prompt = TarotUtils.createSimplePrompt(cards, question);
        return ResponseEntity.ok(ollamaChatModel.call(prompt));
    }
}
