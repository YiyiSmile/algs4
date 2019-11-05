package algs4.rewrite.sort;

import java.util.Arrays;

/**
 * @Author totian
 * @Date 2019/11/5 11:22
 * @Version 1.0
 * @Description 希尔排序(改进的选择排序),具体可以先写里边的两层循环，步距可以使用2, 然后再加上外层循环，将里层的两层循环的步距替换曾外层的循环变量(步距)
 */
public class MyShellSort {
    int[] values = {9, 1, 5, 6, 10, 11, 21, 2, 4, 7, 8, 34, 12, 4, 17};

    public static void main(String[] args) {
        int[] values = {9, 1, 5, 6, 10, 11, 21, 2, 4, 7, 8, 34, 12, 4, 17};
        System.out.println("排序前数组：");
        System.out.println(Arrays.toString(values));
        shellSort(values);
        System.out.println("排序后数组：");
        System.out.println(Arrays.toString(values));
    }

    public static void shellSort(int[] elements){
        int temp;
        for(int gap = elements.length/2;gap>0;gap/=2) {
            /*里层两层循环泵可以先写成这样，步距以2为例子*/
            /*for (int i = 2; i < elements.length; i++) {
                for (int j = i - 2; j >= 0; j -= 2) {
                    if (elements[j] > elements[j + 2]) {
                        temp = elements[j];
                        elements[j] = elements[j + 2];
                        elements[j + 2] = temp;
                    }
                }
            }*/
            for (int i = gap; i < elements.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (elements[j] > elements[j + gap]) {
                        temp = elements[j];
                        elements[j] = elements[j + gap];
                        elements[j + gap] = temp;
                    }
                }
            }
        }
    }
}
