package com.parser.driver;

import java.util.LinkedHashMap;
import java.util.Map;

import com.parser.enums.Unit;
import com.parser.service.ParserService;

public class Parser {

    private final ParserService parserService;

    public Parser(final ParserService parserService) {
        this.parserService = parserService;
    }


    public Map<String, String> parse(String expression) throws IllegalArgumentException {
        //to maintain insertion order
        final Map<String, String> result=new LinkedHashMap<>();
        final String[] splittedExpression = parserService.split(expression);
        result.put(Unit.MINUTE.getUnit(), parserService.parse(Unit.MINUTE, splittedExpression[0]));
        result.put(Unit.HOUR.getUnit(), parserService.parse(Unit.HOUR, splittedExpression[1]));
        result.put(Unit.DAYOFMONTH.getUnit(), parserService.parse(Unit.DAYOFMONTH, splittedExpression[2]));
        result.put(Unit.MONTH.getUnit(), parserService.parse(Unit.MONTH, splittedExpression[3]));
        result.put(Unit.DAYOFWEEK.getUnit(), parserService.parse(Unit.DAYOFWEEK, splittedExpression[4]));
        result.put(Unit.COMMAND.getUnit(), splittedExpression[5]);
        return result;
    }
}
