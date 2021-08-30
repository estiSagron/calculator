package calculator.controller;

import calculator.OperationType;
import calculator.UserInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void displayAdd() throws Exception {
        UserInput userInput = new UserInput(4, 5, OperationType.ADD);
        mockMvc.perform(post("/calculate/displayResult").
                        content(asJsonObject(userInput)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("4 + 5 = 9"));
    }

    @Test
    public void displaySub() throws Exception {
        UserInput userInput = new UserInput(10, 5, OperationType.SUB);
        mockMvc.perform(post("/calculate/displayResult").
                        content(asJsonObject(userInput)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("10 - 5 = 5"));
    }

    @Test
    public void displayMul() throws Exception {
        UserInput userInput = new UserInput(10, 5, OperationType.MUL);
        mockMvc.perform(post("/calculate/displayResult").
                        content(asJsonObject(userInput)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("10 * 5 = 50"));
    }


    @Test
    public void displayDiv() throws Exception {
        UserInput userInput = new UserInput(10, 5, OperationType.DIV);
        mockMvc.perform(post("/calculate/displayResult").
                        content(asJsonObject(userInput)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("10 / 5 = 2"));
    }


    public static String asJsonObject(final Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }


}
