package com.travis.sortingbasic_02.generatetestcases;

/**
 * 测试用例辅助类
 */
public class SortTestHelper {


    private SortTestHelper(){}

    /**
     * // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     * @param n 元素个数
     * @param rangeL 最小范围
     * @param rangeR 最大范围
     * @return 随机产生数组
     */
    public static Integer[] generateRandomArray(int n,int rangeL,int rangeR){

        Integer[] arr = null;

        if (n > 0 && rangeR >= rangeL )
        {
            arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
            }
        }
        return arr;

    }

    public static void printArry(Object[] arr){

        int len = arr.length;
        for ( int i = 0 ; i < len ; i++ ) {
            System.out.print(arr[i]);
            if ( i != len - 1 ) System.out.print(" ");
        }
        System.out.println();

    }
}
