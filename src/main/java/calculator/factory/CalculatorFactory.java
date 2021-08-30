package calculator.factory;


import calculator.OperationType;
import calculator.exception.CustomException;
import calculator.operations.Operation;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorFactory {

    @Autowired
    public BeanFactory beanFactory;

    public Operation getFactory(OperationType operationType) throws CustomException {
        return (Operation) beanFactory.getBean(operationType.getBeanName().getSimpleName());
    }


}
