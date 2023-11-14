package com.pluralsight;

public interface Valuable {
    default double getValue() {
        return 0;
    }
}
