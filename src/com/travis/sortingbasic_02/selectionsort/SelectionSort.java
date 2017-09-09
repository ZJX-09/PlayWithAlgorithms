package com.travis.sortingbasic_02.selectionsort;

/**
 * 2017/9/3
 * 选择排序,只能排序int类型的数据
 */
public class SelectionSort {

    // 我们的算法类不允许产生任何实例
    private SelectionSort(){}

    public static void sort(int[] arr){
        int len = arr.length;
        for ( int i = 0 ; i < len - 1; i++ ) {
            int minIndex = i;
            for ( int j = i + 1 ; j < len ; j++ ) {
                if ( arr[minIndex] > arr[j] ) minIndex = j;
            }
            // swap each other
            if ( minIndex != i ) swap(arr,i,minIndex);
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
