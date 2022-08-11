package strategies;

public interface CalculationStrategy<DATATYPE> {

    DATATYPE calculate(DATATYPE leftOperand, DATATYPE rightOperand);
}
