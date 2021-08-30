package calculator.cache.aspect;

import calculator.cache.helper.CacheHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class CacheAspect {

    @Autowired
    private CacheHelper cacheHelper;

    @Around("@annotation(calculator.cache.annotation.resultMethodCachable)")
    public Object interceptor(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] arguments = joinPoint.getArgs();
        return getMethodResult(joinPoint, method.getName());
    }


    public synchronized String getMethodResult(ProceedingJoinPoint joinPoint, String methodName) throws Throwable {
        String key =cacheHelper.getKey(methodName, joinPoint.getArgs());
        if(cacheHelper.containCache(key)){
            return cacheHelper.getCache(key);
        }
        String result = (String) joinPoint.proceed();
        cacheHelper.putCache(key,result);
        return result;
    }


}
