import java.util.Scanner;

import context.CalculatorService;
import strategies.AdditionStrategy;
import strategies.DivisionStrategy;
import strategies.MultiplicationStrategy;
import strategies.Operator;
import strategies.SubtractionStrategy;

public class CalculatorDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome!!! Press any of the below Instructions");
        System.out.println("ADD <AMOUNT TO ADD>");
        System.out.println("SUB <Amount to Subtract >");
        System.out.println("MUL <Amount to Multiply >");
        System.out.println("DIV <Amount to Divide >");
        System.out.println("AC Type AC to cancel");
        System.out.println(":::::::::::::::::::::");
        CalculatorService calculatorService = CalculatorService.getInstance();
        calculatorService.addStrategy(Operator.ADD, new AdditionStrategy());
        calculatorService.addStrategy(Operator.SUB, new SubtractionStrategy());
        calculatorService.addStrategy(Operator.MUL, new MultiplicationStrategy());
        calculatorService.addStrategy(Operator.DIV, new DivisionStrategy());

        while (true) {
            final var operator = sc.next();
            if (operator.equalsIgnoreCase("AC")) {
                calculatorService.printResult();
                System.exit(0);
            }
            final var operand = sc.nextInt();
            calculatorService.computeResult(operator, operand);
        }
    }
}
