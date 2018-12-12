package com.olga.elements;

public interface TextField extends Element {
    void type(String text);

    void clear();

    void clearAndType(String text);

    void waitForElement();
}
