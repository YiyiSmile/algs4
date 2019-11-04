package algs4.exercises;

import java.util.Scanner;

/**
 * @Author totian
 * @Date 2019/11/3 17:30
 * @Version 1.0
 * @Description Receive a string from standin, then reverse it and print it to stand out.
 */
public class ReverseStringTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a sequence of characters, end with Enter:");
        String inputString;
        String outputString;
        while(scanner.hasNext()){
            inputString = scanner.nextLine();
            outputString = reverseString(inputString);
            System.out.println("The reversed string is: " + outputString);
            System.out.println("Please enter a sequence of characters again, end with Enter:");

        }
    }
    public static String reverseString(String s){
        int length = s.length();
        if(length <= 1) return s;
        String a = s.substring(0, length/2);
        String b = s.substring(length/2, length);
        return reverseString(b) + reverseString(a);
    }
}
