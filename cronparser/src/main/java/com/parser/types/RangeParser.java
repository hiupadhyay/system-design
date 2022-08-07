package com.parser.types;

import java.time.DayOfWeek;

import com.parser.enums.ExpressionType;
import com.parser.enums.Type;
import com.parser.enums.Unit;
import com.parser.validator.Validator;

public class RangeParser {
    public String parse(final Unit unit, final String expression) {
        if (Type.NUMBERIC.equals(checkType(expression))) {
            final int startRange = Integer.parseInt(expression.split("-")[0]);
            final int endRange = Integer.parseInt(expression.split("-")[1]);
            Validator.validate(ExpressionType.RANGE, unit, startRange, endRange);
            return parseExpression(startRange, endRange);
        }

        if (Type.ALPHA.equals(checkType(expression))) {
            final String startRange = expression.split("-")[0];
            final String endRange = expression.split("-")[1];
            return parseExpression(startRange, endRange, Type.ALPHA);
        }

        return null;
    }

    private Type checkType(final String expression) {
        if (expression.contains("Mon") || expression.contains("Fri")) {
            return Type.ALPHA;
        }
        return Type.NUMBERIC;
    }

    private String parseExpression(int start, int end) {
        final StringBuilder st = new StringBuilder();
        for (int i = start; i <= end; i++) {
            st.append(i + " ");
        }
        return st.toString().trim();
    }

    private String parseExpression(String start, String end, Type type) {
        final StringBuilder st = new StringBuilder();
        for (int i = getDayIndex(start); i <= getDayIndex(end); i++) {
            st.append(DayOfWeek.of(i)).append(" ");
        }
        return st.toString().trim();
    }

    public int getDayIndex(String day) {
        if ("Mon".equalsIgnoreCase(day)) {
            return 1;
        }
        if ("Fri".equalsIgnoreCase(day)) {
            return 5;
        }
        return -1;
    }
}
