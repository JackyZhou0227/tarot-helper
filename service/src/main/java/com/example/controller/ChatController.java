package com.example.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/chat")
public class ChatController {

    @Resource
    private OllamaChatModel ollamaChatModel;

    @GetMapping
    public ResponseEntity<String> chat(String prompt) {
        return ResponseEntity.ok(ollamaChatModel.call(prompt));
    }
}
