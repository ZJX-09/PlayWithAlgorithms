package com.travis.sortingbasic_02.usingcomparable;

/**
 *  解决选择排序只能排序int类型的数据
 */
public class SelectionSort {

    // 我们的算法类不允许产生任何实例
    private SelectionSort(){}

    @SuppressWarnings("unchecked")
    public static void sort(Comparable[] arr){
        int len = arr.length;
        for ( int i = 0 ; i < len - 1; i++ ) {
            int minIndex = i;
            for ( int j = i + 1 ; j < len ; j++ ) {
                // 使用compareTo方法比较两个Comparable对象的大小
                if ( arr[j].compareTo(arr[minIndex]) < 0 ) minIndex = j;
            }
            // swap each other
            if ( minIndex != i ) swap(arr,i,minIndex);
        }
    }

    private static void swap(Object[] arr,int i,int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
