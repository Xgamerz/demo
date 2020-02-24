package com.example.demo.models;

public enum CommandType {
    TYPE1("Type1"),
    TYPE2("Type2"),
    TYPE3("Type3");

    private final String displayValue;

    private CommandType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}