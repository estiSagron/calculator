package calculator.services;

import calculator.UserInput;
import calculator.cache.annotation.resultMethodCachable;
import calculator.exception.CustomException;
import calculator.factory.CalculatorFactory;
import calculator.operations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculatorService {

    @Autowired
    public  CalculatorFactory calculatorFactory;

    @resultMethodCachable
    public String displayResult(UserInput userInput) throws CustomException {
        Operation operation = calculatorFactory.getFactory(userInput.getOperationType());
        return operation.displayResult(userInput);
    }

}
