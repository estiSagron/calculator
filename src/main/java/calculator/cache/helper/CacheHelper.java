package calculator.cache.helper;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class CacheHelper {

    private Map<String, String> casheMap = new ConcurrentHashMap();


    public static String getKey(String methodName,
                                Object[] arguments) {
        StringBuilder key = new StringBuilder();
        String argsKey = Arrays.asList(arguments).stream().map(arg -> arg.toString()).collect(Collectors.joining(";"));
        key.append(methodName);
        key.append(argsKey);
        return key.toString();
    }

    public String getCache(String key) {
        if (!ObjectUtils.isEmpty(key)) {
            return casheMap.get(key);
        }
        return null;
    }

    public boolean containCache(String key) {
        return casheMap.containsKey(key);

    }

    public void putCache(String key, String result) {
        if (!ObjectUtils.isEmpty(key)) {
            casheMap.put(key, result);
        }
    }

}
