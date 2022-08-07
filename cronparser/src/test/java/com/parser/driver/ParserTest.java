package com.parser.driver;

import com.parser.enums.Unit;
import com.parser.service.ParserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class ParserTest {

    private static Parser parser;

    @BeforeAll
    public static void before() {
        parser = new Parser(new ParserService());
    }

    @Test
    public void parser_should_throw_exception_if_invalid_string() {
        assertThatCode(() -> parser.parse("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void parser_should_parse_if_valid_string() {
        assertThat(parser.parse("*/15 0 1,15 * 1-5 /usr/bin/find")).hasSize(6).containsKey(Unit.MINUTE.getUnit());
        assertThat(parser.parse("*/15 0 1,15 * 1-5 /usr/bin/find")).containsEntry(Unit.MINUTE.getUnit(), "0 15 30 45");
        assertThat(parser.parse("*/15 0 1,15 * 1-5 /usr/bin/find")).containsEntry(Unit.HOUR.getUnit(), "0");
        assertThat(parser.parse("*/15 0 1,15 * 1-5 /usr/bin/find")).containsEntry(Unit.DAYOFMONTH.getUnit(), "1 15");
        assertThat(parser.parse("*/15 0 1,15 * 1-5 /usr/bin/find")).containsEntry(Unit.MONTH.getUnit(),
                "1 2 3 4 5 6 7 8 9 10 11 12");
        assertThat(parser.parse("*/15 0 1,15 * 1-5 /usr/bin/find")).containsEntry(Unit.DAYOFWEEK.getUnit(),
                "1 2 3 4 5");
        assertThat(parser.parse("*/15 0 1,15 * 1-5 /usr/bin/find")).containsEntry(Unit.COMMAND.getUnit(),
                "/usr/bin/find");
        assertThat(parser.parse("*/15 0 1,15 * Mon-Fri /usr/bin/find")).containsEntry(Unit.DAYOFWEEK.getUnit(),
                "MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY");

    }
}
