package algs4.rewrite.stack;

import edu.princeton.cs.algs4.Stack;

import java.util.Scanner;

/**
 * @Author totian
 * @Date 2019/11/3 21:16
 * @Version 1.0
 * @Description 计算用括号括起来的表达式的值, 注意每个表达式都必须用括号括起来，
 * 而且每个括号里边的逻辑操作数不能超过2个，比如这样不可以 ( 1 + ( 2 * 3 ) - 5 )
 * 使用的算法是Dijkstra's 2-stack algorithm。
 */
public class MyEvaluate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入算数表达式，每个括号之间，以及括号与数字之间需要有一个空格隔开，");
        System.out.println("表达式需要用括号括起来：");
        while(scanner.hasNext()){
            String expression = scanner.nextLine();
            String[] elements = expression.split(" ");

            Stack<Integer> operands = new Stack<>();
            Stack<String> operators = new Stack<>();

            for(int i=0;i<elements.length;i++){
                String element = elements[i];
                if(element.equals("+") || element.equals("-") ||
                        element.equals("*") || element.equals("/")) operators.push(element);
                else if(element.equals("(")) ;
                else if(element.equals(")")) {
                    String operator = operators.pop();
                    int val1 = operands.pop();
                    int val2 = operands.pop();
                    if(operator.equals("+")) operands.push(val2 + val1);
                    else if(operator.equals("-")) operands.push(val2 - val1);
                    else if(operator.equals("*")) operands.push(val2 * val1);
                    else if(operator.equals("/")) operands.push(val2 / val1);

                }else operands.push(Integer.parseInt(element));
            }

            System.out.println(expression + "计算结果：");
            System.out.println(operands.pop());
        }
    }
}
