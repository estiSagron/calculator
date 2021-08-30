package calculator.operations;

import org.springframework.stereotype.Service;

@Service("Subtraction")
public class Subtraction extends Operation {

    @Override
    public Integer calculate(Integer x, Integer y) {
        return x - y;
    }

    @Override
    public String getSymbol() {
        return "-";
    }
}
