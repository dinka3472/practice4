package ru.avalon.javapp.devj110.practice4;

public class IntArray implements BoolSet {
    private int[] ints = new int[SIZE/32];

    @Override
    public boolean check(int index) {
        checkIndex(index);
        int cellNum = index/32;
        int bitNdx = index%32;

        return ((ints[cellNum] >> (31-bitNdx)) & 1) == 1;

    }

    @Override
    public void set(int index) {
        checkIndex(index);
        int cellNum = index/32;
        int bitNdx = index%32;
        ints[cellNum] = ints[cellNum] | (1 << (31-bitNdx));
    }

    @Override
    public void set(int index, boolean value) {
        checkIndex(index);
       if (value) {
           set(index);
       } else {
         clear(index);
       }
    }

    @Override
    public void clear(int index) {
        checkIndex(index);
        int cellNum = index/32;
        int bitNdx = index%32;
        ints[cellNum] = ints[cellNum] & ~(1<<(31-bitNdx));
    }

    @Override
    public void flip(int index) {
        checkIndex(index);
        int cellNum = index/32;
        int bitNdx = index%32;
        ints[cellNum] = ints[cellNum] ^ (1<<(31-bitNdx));
    }

    @Override
    public int count() {
        int res = 0;
        for (int i = 0; i < SIZE/32; i ++) {
            for (int j = 0; j < 32; j++) {
               if(((ints[i] >> (31-j)) & 1) == 1) res++;
            }
        }
        return res;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= SIZE)
            throw new IllegalArgumentException("index is out of bound of intArray");
    }

    public  String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE/32; i++) {
            for (int j = 0; j < 32; j++) {
                sb.append((((ints[i] >> (31-j)) & 1) == 1) ? '1':'0');
            }
        }
        return sb.toString();
    }
}
