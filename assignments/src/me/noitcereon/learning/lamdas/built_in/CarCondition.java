package me.noitcereon.learning.lamdas.built_in;

import me.noitcereon.learning.lamdas.built_in.models.Car;

/**
 * @deprecated Use built-in {@link java.util.function.Predicate} instead.
 */
@FunctionalInterface
@Deprecated
public interface CarCondition {
    boolean test(Car c);
}