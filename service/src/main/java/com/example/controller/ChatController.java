package com.example.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直接对话大模型接口
 */
@RestController
@RequestMapping("api/chat")
public class ChatController {

    @Resource
    private OllamaChatModel ollamaChatModel;

    /**
     * 处理GET请求，用于直接与大语言模型进行对话
     *
     * @param prompt 用户输入的提示信息，用于生成聊天回复.
     * @return 返回聊天模型根据提示信息生成的回复.
     */
    @GetMapping
    public ResponseEntity<String> chat(String prompt) {
        return ResponseEntity.ok(ollamaChatModel.call(prompt));
    }
}
