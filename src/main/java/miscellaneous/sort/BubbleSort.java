package miscellaneous.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author Tom
 * @Date 2020/6/26 17:46
 * @Version 1.0
 * @Description
 */
public class BubbleSort {
    @Test
    public void test(){
        Integer[] array = {3,1,2,4,7,8,9,0,23,14,788,12,45,78,9,67,87,43,21};
        System.out.println(Arrays.asList(array));
        bubbleSort(array);
        System.out.println("****************************");
        System.out.println(Arrays.asList(array));
    }

    //[3,1,2,4,7,8,9,0,23,14,788,12,45,78,9,67,87,43,21]
    private static void bubbleSort(Integer[] originalArray){
        int temp;
        //if no swap happened during one round, then no need to check further because they are in
        //the order already.
        boolean flag=false;
        //compare times
        int count = 0;

        for (int i = 0; i < originalArray.length-1; i++) {
            for (int j = 0; j < originalArray.length-i-1; j++) {
                count++;
                if(originalArray[j] > originalArray[j+1]){
                    flag = true;
                    temp = originalArray[j];
                    originalArray[j] = originalArray[j+1];
                    originalArray[j+1] = temp;
                }
            }
            if(!flag){
                break;
            }
            flag = false;
        }
        System.out.printf("Comparision happened %d times.\n",count);
    }
}
