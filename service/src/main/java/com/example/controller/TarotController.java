package com.example.controller;

import com.example.bean.Card;
import com.example.bean.CardRequest;
import com.example.utils.TarotUtils;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.StreamingResponseHandler;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.data.message.AiMessage;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

/**
 * 塔罗牌占卜接口
 */
@Slf4j
@RestController
@RequestMapping("api/tarot")
public class TarotController {

    @Resource
    private StreamingChatLanguageModel streamingChatLanguageModel;

    @PostMapping(value = "basic", produces = MediaType.TEXT_PLAIN_VALUE)
    public Flux<String> basic(@RequestBody CardRequest request) {
        log.debug("user question: {}", request.getQuestion());
        String userPrompt = TarotUtils.createSimplePrompt(request.getCards(), request.getQuestion());

        SystemMessage systemMessage = SystemMessage.from(TarotUtils.SYSTEM_PROMPT);
        UserMessage userMessage = UserMessage.from(userPrompt);

        return Flux.create(sink -> {
            streamingChatLanguageModel.generate(Arrays.asList(systemMessage, userMessage), new StreamingResponseHandler<AiMessage>() {
                @Override
                public void onNext(String token) {
                    sink.next(token);
                }

                @Override
                public void onComplete(Response<AiMessage> response) {
                    sink.complete();
                }

                @Override
                public void onError(Throwable error) {
                    sink.error(error);
                }
            });
        });
    }

    @GetMapping("cards/basic3")
    public ResponseEntity<List<Card>> getBasic3Cards() {
        return ResponseEntity.ok(TarotUtils.getRandomCards(3));
    }

}
