package calculator.operations;

import calculator.UserInput;
import calculator.exception.CustomException;
import org.springframework.stereotype.Service;

@Service
public abstract class Operation {

    public abstract Integer calculate(Integer x, Integer y) throws CustomException;

    public  void validate(Integer x,Integer y) throws CustomException{

    }


    public abstract String getSymbol();

    public  String displayResult(UserInput userInput) throws CustomException {
        Integer x=userInput.getX();
        Integer y=userInput.getY();
        validate(x,y);
        Integer result = calculate(x,y);
        return  getDisplayResult(x,y,result);
    }

    private String getDisplayResult(Integer x, Integer y, Integer result) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(x);
        sb.append(' ');
        sb.append(getSymbol());
        sb.append(' ');
        sb.append(y);
        sb.append(" = ");
        sb.append(result);
        return sb.toString();

    }


}
