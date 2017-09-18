package com.travis.sortingbasic_02.generatetestcases;

import com.travis.sortingbasic_02.usingcomparable.SelectionSort;

import java.lang.reflect.Method;

/**
 * 测试用例辅助类
 */
public class SortTestHelper {


    private SortTestHelper(){}


    public static void main(String[] args) {

        int n = 10000;
        Integer[] integers = generateRandomArray(n, 0, n);
        System.out.println("排序前的数组为：");
        printArry(integers);
        Class[] paramtypes = new Class[]{Comparable[].class};
        testSort("com.travis.sortingbasic_02.usingcomparable.SelectionSort",
                "sort",paramtypes,integers);
        System.out.println("排序后的数组为：");
        printArry(integers);

    }

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

    /**
     * 生成一个接近有序的整型数组
     * @param n 元素个数
     * @param rangeL 最小范围
     * @param t 交换的次数
     * @return 接近有序数组
     */
    public static Integer[] generateAlmostOrderlyArray(int n,int rangeL,int t){
        Integer[] arr = new Integer[n];

        for (int i = 0 ; i < n ; i++) {
            arr[i] = i + rangeL;
        }
        for (int i = 0 ; i < t ; i++) {
            int random1 = (int) (Math.random() * n);
            int random2 = (int) (Math.random() * n);
            int temp = arr[random1];
            arr[random1] = arr[random2];
            arr[random2] = temp;
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

    /**
     * 判断arr数组是否有序
     * @param arr
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean isSorted(Comparable[] arr){

        // 就是按照排序的顺序，一个个依次对比
        for ( int i = 0 ; i < arr.length - 1; i++ )
            if ( arr[i].compareTo(arr[i + 1]) > 0 )
                return false;

        return true;

    }

    /**
     * 测试className所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
     * @param className 类名
     * @param methodName 方法名
     * @param paramTypes 方法类型列表（数组）
     * @param arr 待排序数组
     */
    @SuppressWarnings("unchecked")
    public static void testSort(String className,String methodName,Class[] paramTypes,Comparable[] arr){

        try {
            // 动态加载对象
            Class sortClass = Class.forName(className);
            // 获取方法
            Method sortMethod = sortClass.getMethod(methodName, paramTypes);
            // 拼装参数
            Object[] params = new Object[]{arr};
            // 统计时间
            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();
            // 判断正确性
            if (!isSorted(arr)) return;
            // 输出统计时间
            System.out.println(sortClass.getSimpleName() + "排序所花费的时间是：" + (endTime - startTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
