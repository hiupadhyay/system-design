package com.parser.types;

import java.time.DayOfWeek;

import com.parser.enums.Type;
import com.parser.enums.Unit;

public class AnyValueParser {

    public String parse(final Unit unit, final String expression) {
        if (Unit.MINUTE.equals(unit)) {
            return parseUnit(0, 59);
        } else if (Unit.HOUR.equals(unit)) {
            return parseUnit(0, 23);
        } else if (Unit.DAYOFMONTH.equals(unit)) {
            return parseUnit(1, 31);
        } else if (Unit.DAYOFWEEK.equals(unit)) {
            return parseUnit(1, 7, Type.ALPHA);
        } else if (Unit.MONTH.equals(unit)) {
            return parseUnit(1, 12);
        } else {
            return expression;
        }
    }

    private String parseUnit(final int start, final int end, Type type) {
        final StringBuilder st = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if(type.equals(Type.ALPHA))
            st.append(DayOfWeek.of(i) + " ");
        }
        return st.toString().trim();
    }

    private String parseUnit(final int start, final int end) {
        final StringBuilder st = new StringBuilder();
        for (int i = start; i <= end; i++) {
            st.append(i + " ");
        }
        return st.toString().trim();
    }
}
