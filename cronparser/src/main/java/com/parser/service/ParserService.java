package com.parser.service;

import com.parser.enums.ExpressionType;
import com.parser.enums.Unit;
import com.parser.types.AnyValueParser;
import com.parser.types.ListParser;
import com.parser.types.RangeParser;
import com.parser.types.StepValueParser;

public class ParserService {

    private static final String SPACE = " ";
    private static final int BEGIN_INDEX_OF_COMMAND = 5;

    public String[] split(String expression) throws IllegalArgumentException {
        if (expression.isEmpty() && expression.split(SPACE).length < 6) {
            throw new IllegalArgumentException("Illegal argument");
        }
        return decorate(expression.split(SPACE), BEGIN_INDEX_OF_COMMAND);
    }

    private String[] decorate(final String[] split, final int start) {
        StringBuilder st = new StringBuilder();
        for (int i = start; i < split.length; i++) {
            st.append(split[i]).append(SPACE);
        }
        split[start] = st.toString().trim();
        return split;
    }

    public String parse(final Unit unit, final String expression) {
        switch (identify(expression)) {
            case ALL:
                return new AnyValueParser().parse(unit, expression);
            case RANGE:
                return new RangeParser().parse(unit, expression);
            case STEPVALUE:
                return new StepValueParser().parse(unit, expression);
            case LIST:
                return new ListParser().parse(unit, expression);
            default:
                return expression;
        }
    }

    private ExpressionType identify(String expression) {
        if (expression.contains("*/") || expression.contains("/")) {
            return ExpressionType.STEPVALUE;
        }
        if (expression.contains("*")) {
            return ExpressionType.ALL;
        }
        if (expression.contains("-")) {
            return ExpressionType.RANGE;
        }
        if (expression.contains(",")) {
            return ExpressionType.LIST;
        }
        return ExpressionType.NOTYPE;
    }
}
