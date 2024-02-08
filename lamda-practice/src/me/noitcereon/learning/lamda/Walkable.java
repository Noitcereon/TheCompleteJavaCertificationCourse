package me.noitcereon.learning.lamda;

@FunctionalInterface // optional annotation for functional interfaces. Good practice, because it ensures you can't make it non-functional.)
// An interface with only 1 abstract method is a functional interface.
public interface Walkable {
    void walk();
}
