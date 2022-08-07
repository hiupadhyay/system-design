package com.parser.types;

import com.parser.enums.Unit;

public class StepValueParser {
    public String parse(final Unit unit, final String expression) {
        final int stepValue = Integer.parseInt(expression.split("/")[1]);
        if (Unit.MINUTE.equals(unit)) {
            return parse(0, 59, stepValue);
        } else if (Unit.HOUR.equals(unit)) {
            return parse(0, 23, stepValue);
        } else if (Unit.DAYOFMONTH.equals(unit)) {
            return parse(1, 31, stepValue);
        } else if (Unit.DAYOFWEEK.equals(unit)) {
            return parse(1, 7, stepValue);
        } else if (Unit.MONTH.equals(unit)) {
            return parse(1, 12, stepValue);
        } else {
            return expression;
        }
    }

    String parse(int start, int end, int factor) {
        final StringBuilder st = new StringBuilder();
        for (int i = start; i <= end; i += factor) {
            st.append(i + " ");
        }
        return st.toString().trim();
    }
}
