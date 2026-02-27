package com.example.controller;

import dev.langchain4j.model.StreamingResponseHandler;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.data.message.AiMessage;
import org.springframework.http.MediaType;
import reactor.core.publisher.Flux;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直接对话大模型接口
 */
@RestController
@RequestMapping("api/chat")
public class ChatController {

    @jakarta.annotation.Resource
    private StreamingChatLanguageModel streamingChatLanguageModel;

    /**
     * 处理GET请求，用于直接与大语言模型进行对话
     *
     * @param prompt 用户输入的提示信息，用于生成聊天回复.
     * @return 返回流式的聊天回复.
     */
    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public Flux<String> chat(String prompt) {
        return Flux.create(sink -> {
            streamingChatLanguageModel.generate(prompt, new StreamingResponseHandler<AiMessage>() {
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
}
