package com.travis.sortingbasic_02.insertionsort;

import com.travis.sortingbasic_02.generatetestcases.SortTestHelper;
import com.travis.sorttest.SortTest;
import org.junit.Test;

import java.util.Arrays;

public class InsertionSortTest {

    /**
     * 测试插入排序
     */
    @Test
    public void sortTest(){

        int n = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0,n);
        SortTestHelper.printArry(arr);
        SortTestHelper.testSort("com.travis.sortingbasic_02.insertionsort.InsertionSort",
                "sort",new Class[]{Comparable[].class},arr);
        SortTestHelper.printArry(arr);

    }

    /**
     * 插入排序和选择排序效率对比测试
     * 对于同一个数组明显选择排序是要比插入排序要快
     */
    @Test
    public void selectionAndInsertionTest(){

        int n = 5000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(n, 0,n);
        int length = arr1.length;
        Integer[] arr2 = new Integer[length];
        //Integer[] arr2 = Arrays.copyOf(arr1, length);
        System.arraycopy(arr1,0,arr2,0,length);

        SortTestHelper.testSort("com.travis.sortingbasic_02.insertionsort.InsertionSort",
                "sort",new Class[]{Comparable[].class},arr1);

        SortTestHelper.testSort("com.travis.sortingbasic_02.usingcomparable.SelectionSort",
                "sort",new Class[]{Comparable[].class},arr2);

    }

    /**
     *  插入排序、改进后的插入排序、选择排序测试
     */
    @Test
    public void selectionAndInsertionSortAdvanceTest() {

        int n = 100000;
        //Integer[] arr1 = SortTestHelper.generateAlmostOrderlyArray(n, 0, 100);
        Integer[] arr1 = SortTestHelper.generateRandomArray(n, 0, 3);
        int length = arr1.length;
        Integer[] arr2 = new Integer[length];
        System.arraycopy(arr1, 0, arr2, 0, length);
        Integer[] arr3 = Arrays.copyOf(arr1, length);

        Object[] arrName = {arr1,arr2,arr3};
        for (int i = 0; i < 3; i++) {
            System.out.println("arr" + (i + 1));
            SortTestHelper.printArry((Integer[])arrName[i]);
        }

        SortTestHelper.testSort("com.travis.sortingbasic_02.insertionsortadvance.InsertionSortAdvance",
                "sort", new Class[]{Comparable[].class}, arr1);
        SortTestHelper.testSort("com.travis.sortingbasic_02.usingcomparable.SelectionSort",
                "sort", new Class[]{Comparable[].class}, arr2);
        SortTestHelper.testSort("com.travis.sortingbasic_02.insertionsort.InsertionSort",
                "sort", new Class[]{Comparable[].class}, arr3);
    }

    /**
     * 测试改进后的插入排序
     */
    @Test
    public void InsertionSortAdvanceTest(){

        int n = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0,n);
        SortTestHelper.printArry(arr);
        SortTestHelper.testSort("com.travis.sortingbasic_02.insertionsortadvance.InsertionSortAdvance",
                "sort",new Class[]{Comparable[].class},arr);
        SortTestHelper.printArry(arr);

    }

    /**
     * 测试改进后的插入排序
     */
    @Test
    public void generateAlmostOrderlyArrayTest(){
        Integer[] integerArr = SortTestHelper.generateAlmostOrderlyArray(10, 100, 0);
        SortTestHelper.printArry(integerArr);
    }

}
