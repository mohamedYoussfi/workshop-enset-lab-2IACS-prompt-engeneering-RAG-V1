package net.youssfi.promptengineeringspringai.web;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.util.Map;

@RestController
public class ChatGPTRestController {

    private OpenAiChatClient openAiChatClient;

    public ChatGPTRestController(OpenAiChatClient openAiChatClient) {
        this.openAiChatClient = openAiChatClient;
    }

    @GetMapping("/open-ai/generate")
    public Map generate(@RequestParam(name = "message", defaultValue = "tell me a joke") String message){
        return Map.of("response",openAiChatClient.call(message));
    }

    @GetMapping("/open-ai/generate2")
    public ChatResponse generate2(@RequestParam(name = "message", defaultValue = "tell me a joke") String message){
        ChatResponse chatResponse = openAiChatClient.call(
                new Prompt(message, OpenAiChatOptions.builder()
                        .withModel("gpt-4")
                        .withTemperature(Float.valueOf(0))
                        .withMaxTokens(400)
                        .build())
                );
        return chatResponse;
    }

    @GetMapping(path="/open-ai/generateStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return openAiChatClient.stream(prompt);
    }


}
