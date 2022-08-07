package com.parser.validator;

import com.parser.enums.ExpressionType;
import com.parser.enums.Unit;

public final class Validator {

    private Validator() {

    }

    //lIST mINIUTE 0-59
    public static void validate(final ExpressionType list, final Unit unit, final String expression) {
        //based on ExpressionType,Unit it will validate the range
        //it can throw some exception if range is invalid
    }

    public static void validate(final ExpressionType list,
            final Unit unit,
            final int startRange,
            final int endRange) {
        //based on ExpressionType,Unit it will validate the range
        //it can throw some exception if range is invalid
    }
}
