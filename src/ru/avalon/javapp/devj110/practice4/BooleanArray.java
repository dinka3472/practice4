package ru.avalon.javapp.devj110.practice4;



public class BooleanArray implements BoolSet, Cloneable {
    private boolean[] bools = new boolean[SIZE];

    @Override
    public Object clone() throws CloneNotSupportedException {
        BooleanArray copy = (BooleanArray) super.clone();
        copy.bools = new boolean[SIZE];
        System.arraycopy(this.bools, 0, copy.bools, 0, SIZE);
        return copy;
    }

    @Override
    public boolean check(int index) {
        checkIndex(index);
        return bools[index];
    }

    @Override
    public void set(int index) {
        checkIndex(index);
        bools[index] = true;
    }

    @Override
    public void set(int index, boolean value) {
        checkIndex(index);
        bools[index] = value;
    }

    @Override
    public void clear(int index) {
        checkIndex(index);
        bools[index] = false;
    }

    @Override
    public void flip(int index) {
        checkIndex(index);
        bools[index] = !bools[index];
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= bools.length)
            throw new IllegalArgumentException("index is out of bound of BoolsSet");
    }

    @Override
    public int count() {
        int res = 0;
        for (boolean b : bools) {
            if(b) res++;
        }
        return res;
    }

    @Override
    public String toString() {
        /* Не эффективно!!!
        String res = "";
        for (boolean b : bools) {
            // res = res + (b ? '1' : '0');
            res += b ? '1' : '0';
        }
        return res;*/

        /* Уже хорошо!
        //StringBuilder sb = new StringBuilder();
        StringBuilder sb = new StringBuilder(SIZE);
        for (boolean b : bools) {
            sb.append(b ? '1' : '0');
        }
        return sb.toString();*/

        // Быстрее всего!
        char[] ac = new char[SIZE];
        for (int i = 0; i < bools.length; i++) {
            ac[i] = bools[i] ? '1' : '0';
        }
        return new String(ac);
    }
}
