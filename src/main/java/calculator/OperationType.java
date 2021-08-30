package calculator;

import calculator.operations.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OperationType {
    ADD(Addition.class),
    DIV(Division.class),
    MUL(Multiplication.class),
    SUB(Subtraction.class);

    private Class<? extends Operation> beanName;


}
