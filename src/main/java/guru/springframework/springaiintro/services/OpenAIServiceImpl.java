package guru.springframework.springaiintro.services;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenAIServiceImpl implements OpenAIService {
    private final ChatClient client;

    @Override
    public String getAnswer(String question) {
        PromptTemplate promptTemplate = new PromptTemplate(question);
        ChatResponse response = client.call(promptTemplate.create());
        return response.getResult().getOutput().getContent();
    }
}
