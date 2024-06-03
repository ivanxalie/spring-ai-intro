package guru.springframework.springaiintro.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.springaiintro.model.*;
import lombok.SneakyThrows;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OpenAIServiceImpl implements OpenAIService {
    private final ChatClient client;

    @Value("classpath:templates/get-capital-prompt.st")
    private Resource getCapitalPrompt;

    @Value("classpath:templates/get-capital-with-info.st")
    private Resource getCapitalWithInfoPrompt;

    @Autowired
    private ObjectMapper mapper;

    public OpenAIServiceImpl(ChatClient client) {
        this.client = client;
    }

    @Override
    public String getAnswer(String question) {
        PromptTemplate promptTemplate = new PromptTemplate(question);
        ChatResponse response = client.call(promptTemplate.create());
        return response.getResult().getOutput().getContent();
    }

    @Override
    public Answer getAnswer(Question question) {
        return new Answer(getAnswer(question.question()));
    }

    @Override
    @SneakyThrows
    public GetCapitalResponse getCapital(GetCapitalRequest request) {
        BeanOutputParser<GetCapitalResponse> parser = new BeanOutputParser<>(GetCapitalResponse.class);
        String format = parser.getFormat();
        System.out.printf("Schema is:%n %s", format);

        PromptTemplate template = new PromptTemplate(getCapitalPrompt);
        Prompt prompt = template.create(Map.of(
                "stateOrCountry", request.stateOrCountry(),
                "format", format
        ));
        ChatResponse response = client.call(prompt);

        return parser.parse(response.getResult().getOutput().getContent());
    }

    @Override
    public GetCapitalResponseWithAdditionalInfo getCapitalWithInfo(GetCapitalRequest request) {
        BeanOutputParser<GetCapitalResponseWithAdditionalInfo> parser = new BeanOutputParser<>(GetCapitalResponseWithAdditionalInfo.class);
        String format = parser.getFormat();
        System.out.printf("Schema is:%n %s", format);

        PromptTemplate template = new PromptTemplate(getCapitalWithInfoPrompt);
        Prompt prompt = template.create(Map.of(
                "stateOrCountry", request.stateOrCountry(),
                "format", format
        ));
        ChatResponse response = client.call(prompt);

        return parser.parse(response.getResult().getOutput().getContent());
    }
}
