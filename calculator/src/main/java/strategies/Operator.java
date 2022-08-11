package strategies;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operator {
    ADD,
    SUB,
    MUL,
    DIV;

    private static Map<String, Operator> validOperatorMap = Arrays.stream(Operator.values())
            .collect(Collectors.toMap(operator -> operator.name(), Function.identity()));

    public static boolean isValid(final String operator) {
        return validOperatorMap.containsKey(operator);
    }

}
