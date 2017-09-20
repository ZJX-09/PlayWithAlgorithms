package com.travis.sortingbasic_02.generatetestcases;

/**
 * 使用泛型去解决只能排序int类型数据
 */
public class SelectionSort {

    // 我们的算法类不允许产生任何实例
    private SelectionSort(){}

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void sort(T[] arr){
        int len = arr.length;
        for ( int i = 0 ; i < len - 1; i++ ) {
            int minIndex = i;
            for ( int j = i + 1 ; j < len ; j++ ) {
                // 使用compareTo方法比较两个Comparable对象的大小
                if ( arr[j].compareTo(arr[minIndex]) < 0 ) {
                    minIndex = j;
                }
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

    public static void main(String[] args) {

        int n = 1000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0,n);
        sort(arr);
        if (!SortTestHelper.isSorted(arr)) return ;
        SortTestHelper.printArry(arr);

    }



}
