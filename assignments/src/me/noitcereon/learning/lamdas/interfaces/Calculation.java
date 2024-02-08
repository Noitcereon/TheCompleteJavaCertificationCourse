package me.noitcereon.learning.lamdas.interfaces;

@FunctionalInterface
public interface Calculation {
    /**
     * Performs a calculation using 2 numbers.
     * @param n1 First number.
     * @param n2 Second number.
     */
    Number calculate(Number n1, Number n2);
}
