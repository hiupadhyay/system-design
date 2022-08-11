import java.util.List;

import context.CalculatorService;
import org.apache.commons.lang3.tuple.Pair;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import strategies.AdditionStrategy;
import strategies.DivisionStrategy;
import strategies.MultiplicationStrategy;
import strategies.Operator;
import strategies.SubtractionStrategy;

public class CalculatorServiceTest {

    private static CalculatorService calculatorService;

    @BeforeAll
    static void setup() {
        calculatorService = CalculatorService.getInstance();
        calculatorService.addStrategy(Operator.ADD, new AdditionStrategy());
        calculatorService.addStrategy(Operator.SUB, new SubtractionStrategy());
        calculatorService.addStrategy(Operator.MUL, new MultiplicationStrategy());
        calculatorService.addStrategy(Operator.DIV, new DivisionStrategy());
    }

    @Test
    void calculatorShowThrowExceptionForInvalidOperator() {
        Assertions.assertThatThrownBy(() -> calculatorService.computeResult("Invalid", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculatorShowCorrectResult() {

        final var instructions = List.of(Pair.of("ADD", 1),
                Pair.of("ADD", 2),
                Pair.of("SUB", 1),
                Pair.of("MUL", 44),
                Pair.of("DIV", 22));
        instructions.forEach((pair) -> calculatorService.computeResult(pair.getLeft(), pair.getRight()));
        Assertions.assertThat(calculatorService.getResult()).isEqualTo(4);
    }

}
