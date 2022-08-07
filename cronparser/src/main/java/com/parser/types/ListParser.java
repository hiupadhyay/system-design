package com.parser.types;

import com.parser.enums.ExpressionType;
import com.parser.enums.Unit;
import com.parser.validator.Validator;

public class ListParser {

    public String parse(final Unit unit, final String expression) {
        Validator.validate(ExpressionType.LIST, unit, expression);
        return String.join(" ", expression.split(",")).trim();

    }
}
