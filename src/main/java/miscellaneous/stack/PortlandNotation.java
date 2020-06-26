package miscellaneous.stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Tom
 * @Date 2020/6/25 17:40
 * @Version 1.0
 * @Description: demostrate reverse polish expression used for arithmetic expression calculation.
 * For example:
 * 1. 1+((2+3)×4)-5 =>   1 2 3 + 4 × + 5 –
 * 2. Because it's not convinient to operate on string, convert infix expression "1+((2+3)×4)-5"  to List
 * ie. "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
 * 3. convert infix expression list to suffix expression list
 * ie. ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]
 */
public class PortlandNotation {

    @Test
    public void test() {
        //Example: ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]
        String expression = "1+((2+3)*4)-5";
        List<String> list = convertStringInfixExpToList(expression);
        System.out.println(list);

        List<String> list1 = convertInfixExpToSuffixExp(list);
        System.out.println(list1);

        System.out.printf("expression=%d",calculate(list1));

    }

    @Test
    public void test2(){
        System.out.println(isNumber("+123.56.2234"));
    }

    public static boolean isNumber(String s){
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(s).matches();
//        return s.matches("^[-\\+]?[.\\d]*$");
    }
    public static boolean isNumberAll(List<String> list){
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        for (String s : list) {
            if(!pattern.matcher(s).matches())  return false;
        }
        return true;
    }

    @Test
    public void test3(){
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        System.out.println(list.get(0));
        System.out.println(list.get(4));
    }




    //convert string infix expression to List<String>
    //example: 1+((2+3)×4)-5
    private static List<String> convertStringInfixExpToList(String exp) {
        if (null == exp || exp.equals(""))
            throw new IllegalArgumentException("Argument can't be null or \"\"");

        ArrayList<String> list = new ArrayList<>();

        String temp = "";

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) < 48 || exp.charAt(i) > 57) {
                list.add(exp.charAt(i) + "");
            } else {
//                while (exp.charAt(i) > 48 && exp.charAt(i) < 57) {
//                    temp += exp.charAt(i);
//                    i++;
//                    if (i == exp.length()) break;
//                }
                do {
                    temp += exp.charAt(i);
                    i++;
                }while (exp.charAt(i) > 48 && exp.charAt(i) < 57 && i != exp.length());
                list.add(temp);
                i--;
                temp = "";
            }
        }
        return list;
    }

    //Example: ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]
    private static List<String> convertInfixExpToSuffixExp(List<String> infixList) {
        if (infixList == null || infixList.size() == 0)
            throw new IllegalArgumentException();

        ArrayList<String> suffixList = new ArrayList<>();

        Stack<String> stack1 = new Stack<>();

        for (String s : infixList) {
            if (s.matches("\\d+"))
                suffixList.add(s);
            else if (s.equals("("))
                stack1.push(s);
            else if(s.equals(")")){
                while (!stack1.peek().equals("(")){
                    suffixList.add(stack1.pop());
                }
                stack1.pop();
            }else{
                while(!stack1.isEmpty() && !stack1.peek().equals("(") && Operation.getValue(s) < Operation.getValue(stack1.peek())){
                    suffixList.add(stack1.pop());
                }
                stack1.push(s);
            }

        }
        while(stack1.size()!=0)
            suffixList.add(stack1.pop());

        return suffixList;
    }

    private static int calculate(List<String> suffixList){
        if(suffixList == null || suffixList.size() == 0)
            throw new IllegalArgumentException("Illegal argument!");
        Stack<String> stack = new Stack<>();
        int result;
        for (String s : suffixList) {
            if(s.matches("\\d")){
                stack.push(s);
            }else{
                int operand1 = Integer.parseInt(stack.pop());
                int operand2 = Integer.parseInt(stack.pop());
                switch(s){
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand2 - operand1;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("unrecognized operation " + s);
                }
                stack.push(result + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }



}

class Operation{
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    public static int getValue(String operator){
        int result;
        switch (operator){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                throw new IllegalArgumentException("Non-exist operator!");
        }
        return result;
    }


}
