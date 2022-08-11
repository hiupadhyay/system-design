package strategies;

public class AdditionStrategy implements CalculationStrategy<Integer> {
    @Override
    public Integer calculate(final Integer leftOperand, final Integer rightOperand) {
        return leftOperand + rightOperand;
    }
}
