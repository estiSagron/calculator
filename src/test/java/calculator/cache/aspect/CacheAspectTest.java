package calculator.cache.aspect;

import calculator.OperationType;
import calculator.UserInput;
import calculator.cache.aspect.CacheAspect;
import calculator.cache.helper.CacheHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringJUnit4ClassRunner.class)
public class CacheAspectTest {

    @InjectMocks
    CacheAspect cacheAspect;

    @Spy
    private ProceedingJoinPoint proceedingJoinPoint;

    @Spy
    private CacheHelper cacheHelper;


    @Test
    public void getMethodResult() throws Throwable {
        UserInput userInput = new UserInput(1, 2, OperationType.ADD);
        Object[] argumentValues = {userInput};
        Mockito.doReturn(argumentValues).when(proceedingJoinPoint).getArgs();
        Mockito.doReturn("1 + 2 = 3").when(proceedingJoinPoint).proceed();
        cacheAspect.getMethodResult(proceedingJoinPoint, "displayResult");
        cacheAspect.getMethodResult(proceedingJoinPoint, "displayResult");
        verify(proceedingJoinPoint,times(1)).proceed();
    }


}