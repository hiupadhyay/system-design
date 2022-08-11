package context;

import java.util.HashMap;
import java.util.Map;

import strategies.CalculationStrategy;
import strategies.Operator;

public final class CalculatorService {

    private final Map<Operator, CalculationStrategy<Integer>> calculationStrategyMap;

    private static CalculatorService CALCULATOR_INSTANCE = null;

    //?? can there be a better way to store previous results???
    private int previousResult;

    private CalculatorService() {
        this.calculationStrategyMap = new HashMap<>();
        this.previousResult = 0;
    }

    // singleton instance, is this thread-safe?????
    public static CalculatorService getInstance() {
        if (CALCULATOR_INSTANCE == null) {
            CALCULATOR_INSTANCE = new CalculatorService();
        }
        return CALCULATOR_INSTANCE;
    }

    public void addStrategy(final Operator operator, final CalculationStrategy calculationStrategy) {
        calculationStrategyMap.put(operator, calculationStrategy);
    }

    public void computeResult(final String operator, final int operand) {

        if (!Operator.isValid(operator)) {
            throw new IllegalArgumentException("Invalid Operator" + operator);
        }
        final var operatorEnum = Operator.valueOf(operator);
        final var result = calculationStrategyMap.get(operatorEnum).calculate(previousResult, operand);
        setPreviousResult(result);
    }

    private void setPreviousResult(final Integer result) {
        this.previousResult = result;
    }

    //should be responsibility of printer class ideally..
    public void printResult() {
        System.out.println("Current Result is: " + this.previousResult);
    }

    public int getResult() {
        return this.previousResult;
    }

}
