package com.travis.sortingbasic_02.insertionsort;

import com.travis.sortingbasic_02.generatetestcases.SortTestHelper;

/**
 * 插入排序基本实现
 */
public class InsertionSort {

    private InsertionSort(){}
    @SuppressWarnings("unchecked")
    public static void sort(Comparable[] arr){
        for (int i = 1 ; i < arr.length ; i++) {
            // 写法1
           /* for (int j = i ; j > 0 ; j--)
                if (arr[j].compareTo(arr[j-1]) < 0)
                  swap(arr,j,j-1);
                else
                    break;*/
           // 学法2 更加简洁
            for (int j = i ; j > 0 && arr[j].compareTo(arr[j-1]) < 0 ; j--)
                swap(arr,j,j-1);
        }
    }

    private static void swap(Object[] arr,int i,int j){

        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
