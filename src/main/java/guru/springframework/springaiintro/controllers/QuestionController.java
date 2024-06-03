package guru.springframework.springaiintro.controllers;

import guru.springframework.springaiintro.model.*;
import guru.springframework.springaiintro.services.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final OpenAIService service;

    @PostMapping("/ask")
    public Answer askQuestion(@RequestBody Question question) {
        return service.getAnswer(question);
    }

    @PostMapping("/capital")
    public GetCapitalResponse getCapital(@RequestBody GetCapitalRequest request) {
        return service.getCapital(request);
    }

    @PostMapping("/capitalWithInfo")
    public GetCapitalResponseWithAdditionalInfo getCapitalWithInfo(@RequestBody GetCapitalRequest request) {
        return service.getCapitalWithInfo(request);
    }
}
