package calculator.operations;

import calculator.exception.CustomException;
import org.springframework.stereotype.Service;

@Service("Division")
public class Division extends Operation {
    @Override
    public Integer calculate(Integer x, Integer y) throws CustomException {
        return x / y;
    }

    @Override
    public void validate(Integer x, Integer y) throws CustomException {
        if (y <= 0) {
            throw new CustomException("You are trying to divide a zero!");
        }
    }

    @Override
    public String getSymbol() {
        return "/";
    }
}
