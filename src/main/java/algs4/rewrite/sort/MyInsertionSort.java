package algs4.rewrite.sort;

import java.util.Arrays;

/**
 * @Author totian
 * @Date 2019/11/5 10:36
 * @Version 1.0
 * @Description 插入排序，非通用方法，只能比较整形数组
 */
public class MyInsertionSort {
    public static void main(String[] args) {
        int[] values = {9, 1, 5, 6, 10, 11, 21, 2, 4, 7, 8, 34, 12, 4, 17};
        System.out.println("原始数据：");
        System.out.println(Arrays.toString(values));
        MyInsertionSort(values);
        System.out.println("计算后的数据：");
        System.out.println(Arrays.toString(values));
    }

    public static void MyInsertionSort(int[] values){
        int temp;
        for(int i=1; i< values.length;i++){
            for(int j=i-1;j>=0;j-=1){
                if(values[j]>values[j+1]){
                    temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                }else{
                    //如果第一次比较，高位比低位大，跳出里层循环
                    break;
                }
            }
        }
    }
}
