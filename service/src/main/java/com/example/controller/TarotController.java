package com.example.controller;

import com.example.bean.Card;
import com.example.bean.CardRequest;
import com.example.utils.TarotUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 塔罗牌占卜接口
 */
@Slf4j
@RestController
@RequestMapping("api/tarot")
public class TarotController {

    @Resource
    private OllamaChatModel ollamaChatModel;

    @PostMapping(value = "basic", produces = MediaType.TEXT_PLAIN_VALUE)
    public Flux<String> basic(@RequestBody CardRequest request) {
        log.debug("user question: {}", request.getQuestion());
        String prompt = TarotUtils.createSimplePrompt(request.getCards(), request.getQuestion());
        return ollamaChatModel.stream(prompt);
    }

    @GetMapping("cards/basic3")
    public ResponseEntity<List<Card>> getBasic3Cards() {
        return ResponseEntity.ok(TarotUtils.getRandomCards(3));
    }

}
