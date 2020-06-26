package miscellaneous.recursion;

import com.sun.xml.internal.fastinfoset.stax.factory.StAXOutputFactory;
import org.junit.Test;

/**
 * @Author Tom
 * @Date 2020/6/26 17:14
 * @Version 1.0
 * @Description
 */
public class Queen {
    @Test
    public void test(){
        check(0);
        System.out.printf("There are %d possibilities.\n", count);
        System.out.printf("Total judge number is: %d.\n", judgeCount);

    }
    private static int array[] = new int[8];
    private static int count;
    private static int judgeCount;
    private static void check(int n){
        if(n == 8){
            print();
            return;

        }
        for (int i = 0; i < 8; i++) {
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }

    private static boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    private static void print(){
        count++;
        System.out.println(array);
    }

}
