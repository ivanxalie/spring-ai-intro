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
        String question = """
                It takes one person 5 hours to dig a 10 foot hole in the ground.
                How long would it take 5 people?
                """;
        System.out.println("Get the answer...");
        System.out.println(service.getAnswer(question));
    }
}