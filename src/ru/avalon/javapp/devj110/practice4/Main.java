package ru.avalon.javapp.devj110.practice4;

public class Main {
    public static void main(String[] args) {
        BoolSet bs = new BooleanArray();
        BoolSet bs2 = new IntArray();
        bs2.set(1, true);
        bs2.set(5, true);
        bs2.set(1023, true);
        bs2.flip(1);

        System.out.println(bs2.count());
        System.out.println(bs2.toString().substring(0,15));


    }
}

