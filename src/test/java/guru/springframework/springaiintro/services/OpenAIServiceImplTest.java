package guru.springframework.springaiintro.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenAIServiceImplTest {

    @Autowired
    OpenAIService service;

    @Test
    void getAnswer() {
        String question = "Tell me a dad joke.";
        System.out.println("Get the answer...");
        System.out.println(service.getAnswer(question));
    }
}