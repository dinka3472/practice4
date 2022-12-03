package ru.avalon.javapp.devj110.practice4;

public interface BoolSet {
    int SIZE = 1024;

    boolean check(int index);
    void set (int index);
    void set (int index, boolean value);
    void clear(int index);
    void flip (int index);
    int count();
    String toString();
}
