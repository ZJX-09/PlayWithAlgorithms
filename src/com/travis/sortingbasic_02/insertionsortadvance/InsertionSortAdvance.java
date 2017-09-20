package com.travis.sortingbasic_02.insertionsortadvance;

/**
 * 改进后的插入排序算法
 */
public class InsertionSortAdvance {

    private InsertionSortAdvance() {
    }

    @SuppressWarnings("unchecked")
   /* public static void sort(Comparable[] arr){
        for (int i = 1 ; i < arr.length ; i++) {
            Comparable temp = arr[i];
            int targetIndex = i;
            for (int j = i ; j > 0 && temp.compareTo(arr[j-1]) < 0 ; j--)
            {
                targetIndex = j - 1;
                arr[j] = arr[j - 1];
            }
            arr[targetIndex] = temp;
        }
    }*/
    public static void sort(Comparable[] arr){
        for (int i = 1 ; i < arr.length ; i++) {
            Comparable e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

}
