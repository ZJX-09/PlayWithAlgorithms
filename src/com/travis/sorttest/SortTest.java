package com.travis.sorttest;

import com.travis.sortingbasic_02.selectionsort.SelectionSort;

/**
 * 排序测试
 */
public class SortTest {

    //private static int[] originalArray = {2,100,10,70,18,90};
    private static int[] arr ={10,9,8,7,6,5,4,3,2,1};
    public static void main(String[] args) {
        SelectionSort.sort(arr);
        print(arr);
    }

    private  static void print(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1)
            {
                System.out.print(" ");
            }
        }
        System.out.println();

    }
}
