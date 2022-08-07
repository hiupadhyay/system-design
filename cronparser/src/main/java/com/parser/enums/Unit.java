package com.parser.enums;

public enum Unit {
    MINUTE("minute"),
    HOUR("hour"),
    DAYOFMONTH("day of Month"),
    MONTH("month"),
    DAYOFWEEK("day of week"),
    COMMAND("command");

    private String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
