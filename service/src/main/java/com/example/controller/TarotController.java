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

/**
 * 塔罗牌占卜接口
 */
@RestController
@RequestMapping("api/tarot")
public class TarotController {

    @Resource
    private OllamaChatModel ollamaChatModel;

    /**
     * 塔罗牌基础牌阵占卜接口
     * 该方法通过接收一个问题，随机抽取三张塔罗牌，并将问题和选中的塔罗牌生成prompt，然后使用这个prompt调用大语言模型，返回模型的回答
     *
     * @param question 用户需要占卜的问题
     * @return 模型的回答，封装在ResponseEntity中返回
     */
    @GetMapping("basic")
    public ResponseEntity<String> basic(String question) {
        List<Card> cards = TarotUtils.getRandomCards(3);
        String prompt = TarotUtils.createSimplePrompt(cards, question);
        return ResponseEntity.ok(ollamaChatModel.call(prompt));
    }
}
