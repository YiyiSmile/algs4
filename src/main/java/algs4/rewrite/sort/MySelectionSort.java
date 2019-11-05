package algs4.rewrite.sort;

import java.util.Arrays;

/**
 * @Author totian
 * @Date 2019/11/5 10:52
 * @Version 1.0
 * @Description 选择排序
 */
public class MySelectionSort {
    public static void main(String[] args) {
        int[] values = {9, 1, 5, 6, 10, 11, 21, 2, 4, 7, 8, 34, 12, 4, 17};
        System.out.println("排序前数组：");
        System.out.println(Arrays.toString(values));
        selectionSort(values);
        System.out.println("排序后数组：");
        System.out.println(Arrays.toString(values));
    }

    public static void selectionSort(int[] elements){
        for(int i=0; i<elements.length;i++){
            int temp = elements[i];
            int index = i;
            for(int j=i+1;j<elements.length;j++){
                if(temp>elements[j]){
                    temp = elements[j];
                    index = j;
                }
            }
            temp = elements[i];
            elements[i] = elements[index];
            elements[index] = temp;
        }
    }
    /*另一种实现*/
    /*public static String selectionSort(int[] arr) {

        for(int i=0; i<arr.length; i++) {

            //最小数的索引
            int minIndex = i;
            for(int j=i; j<arr.length; j++) {

                //找到最小数，并记录最小数的索引
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            //交换符合条件的数
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        return Arrays.toString(arr);
    }*/
}
