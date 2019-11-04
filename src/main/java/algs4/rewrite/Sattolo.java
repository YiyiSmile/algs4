package algs4.rewrite;

import java.util.Random;
import java.util.Scanner;

/**
 *
 */
public class Sattolo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string of integer separated by space, press enter to finish:");
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int[] intArray = new int[s1.length];
        for(int i=0;i<s1.length;i++){
            intArray[i] = Integer.parseInt(s1[i]);
        }
        handle(intArray);
        for(int i=0;i<s1.length;i++){
            System.out.print(intArray[i] + " ");
        }

    }
    public static int[] handle(int[] a){
        if(a.length == 0 || null == a){
            return null;
        }
        Random random = new Random();
        for(int i=a.length -1; i>0; i--){
            int r = random.nextInt(i+1);
            int temp = a[i];
            a[i] = a[r];
            a[r]= temp;
        }
        return a;
    }
}
