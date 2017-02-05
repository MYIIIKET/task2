package com.mylllket_inc.app;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class IntArrayListTest extends TestCase {
    public void testSortList() throws Exception {
        int[] arr = {9, -5, 3, 0, -2, -1, 1, -4, 11, -6, -15, 12, 4, 44, -54, -511, 445 -41};
        IntArrayList list = new IntArrayList(arr);
//        list.sortList();
//        list.printList();
//        System.out.println(list.Search(10));
        list.ascendSort();
        list.printList();
    }


}