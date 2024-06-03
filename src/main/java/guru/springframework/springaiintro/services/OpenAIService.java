package guru.springframework.springaiintro.services;

import guru.springframework.springaiintro.model.*;

public interface OpenAIService {
    String getAnswer(String question);

    Answer getAnswer(Question question);

    GetCapitalResponse getCapital(GetCapitalRequest request);

    GetCapitalResponseWithAdditionalInfo getCapitalWithInfo(GetCapitalRequest request);
}
