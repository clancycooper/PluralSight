package com.pluralsight;

public interface Valuable extends Comparable<Valuable>{
    default double getValue() {
        return 0;
    }
}
