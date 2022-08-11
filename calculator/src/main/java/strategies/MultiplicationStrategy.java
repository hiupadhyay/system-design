package strategies;

public class MultiplicationStrategy implements CalculationStrategy<Integer> {
    @Override
    public Integer calculate(final Integer leftOperand, final Integer rightOperand) {
        return leftOperand * rightOperand;
    }
}
