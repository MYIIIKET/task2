package com.mylllket_inc.app;

public class IntArrayList {
    private int[] data;


    public IntArrayList(int[] data) {
        this.data = new int[data.length];
        System.arraycopy(data, 0, this.data, 0, data.length);
    }

    public void sortList() {
        int[] free = new int[this.data.length];
        doMerge(this.data, free, 0, this.data.length);
    }

    public int Search(int value) {
        return binSearch(this.data, 0, this.data.length, value);
    }

    private static int binSearch(int[] data, int start, int end, int value) {
        final int mid = (start + end) / 2;
        int res = 0;
        if (start > end)
            return mid;
        else if (value < data[mid])
            return res = binSearch(data, start, mid - 1, value);
        else if (value > data[mid])
            return res = binSearch(data, mid + 1, end, value);
        else return mid;
    }

    private void ensureCapasity(int requiredCapasity) {
        if (requiredCapasity <= getCapasity()) return;
        int[] tmp = new int[(data.length * 3) / 2 + 1];
        System.arraycopy(data, 0, tmp, 0, data.length);
        data = tmp;
    }

    private void doMerge(int[] data, int[] free, int start, int end) {
        final int length = end - start;
        if (length <= 1) return;
        final int mid = start + length / 2;
        doMerge(data, free, start, mid);
        doMerge(data, free, mid, end);
        merger(data, free, start, mid, end);
    }

    private static void merger(int[] data, int[] free, int start, int mid, int end) {
        System.arraycopy(data, start, free, start, end - start);

        int i = start;
        int j = mid;
        for (int k = start; k < end; k++) {
            if (i >= mid)
                data[k] = free[j++];
            else if (j >= end)
                data[k] = free[i++];
            else if (free[i] < free[j])
                data[k] = free[i++];
            else
                data[k] = free[j++];
        }
    }

    public void printList() {
        for (int i = 0; i < this.data.length; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }

    private int getCapasity() {
        return this.data.length;
    }


    public void ascendSort() {
        int[] free = new int[this.data.length];
        System.arraycopy(data, 0, free, 0, free.length);
        int i;
        int j;
        int start;
        int end;
        int mid;
        int size = 2;
        while (!(size > this.data.length)) {
            for (int k2 = 0; k2 < free.length; k2 += size) {
                start = k2;
                end = start + size;
                mid = start + size / 2;
                if (end > data.length)
                    break;
                merger(data, free, start, mid, end);
            }
            System.arraycopy(data, 0, free, 0, free.length);
            size *= 2;
        }

        int rem = size - this.data.length;
        int elems = size / 2 - rem;
        mid = size / 2;
        for (; ; ) {
            if (size <= elems)
                break;
            size /= 2;
        }
        for (; ; ) {
            if (elems == 0) break;
            end = mid + size;
            if (end > this.data.length || size == 0) {
//                end = this.data.length;
//                merger(data, free, 0, mid, end);
                break;
            }
            merger(data, free, 0, mid, end);
            mid += size;
            size = elems - size;
        }
    }
}
