package com.olerym.springai.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olerym.springai.domain.ActorFilms;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class Controller {
  private final OllamaChatModel chatClient;
  private final ObjectMapper objectMapper;

  @SneakyThrows
  @GetMapping("/actors")
  ActorFilms generation() {
    String promptText =
        """
                        Generate the filmography for a random actor.
                        Respond strictly in JSON format ONLY, exactly like this:
                        {
                          "actor": "string",
                          "movies": ["string"]
                        }
                        Do NOT include any extra words, explanations, or punctuation outside this JSON.
                        """;

    ChatResponse jsonResponse =
        chatClient.call(
            new Prompt(
                promptText, OllamaOptions.builder().model("llama2:7b").temperature(0.7).build()));
    System.out.println(jsonResponse.getResult().getOutput().getText());
    String json = jsonResponse.getResult().getOutput().getText();
    return objectMapper.readValue(json, ActorFilms.class);
  }
}
