package calculator.operations;


import org.springframework.stereotype.Service;

@Service("Addition")
public class Addition extends Operation {

    @Override
    public Integer calculate(Integer x,Integer y) {
        return x+y ;
    }

    @Override
    public String getSymbol() {
        return "+";
    }

}
