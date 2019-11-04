package algs4.rewrite.stack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Author totian
 * @Date 2019/11/3 19:59
 * @Version 1.0
 * @Description
 * Arithmetic expression evaluation. Evaluate.java is a stack client that evaluates fully parenthesized
 * arithmetic expressions. It uses Dijkstra's 2-stack algorithm:
 * Push operands onto the operand stack.
 * Push operators onto the operator stack.
 * Ignore left parentheses.
 * On encountering a right parenthesis, pop an operator, pop the requisite number of operands, and push
 * onto the operand stack the result of applying that operator to those operands.
 * This code is a simple example of an interpreter.
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops  = new Stack<>();
        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            System.out.println(s);
            if      (s.equals("("))               ;
            else if (s.equals("+"))    ops.push(s);
            else if (s.equals("-"))    ops.push(s);
            else if (s.equals("*"))    ops.push(s);
            else if (s.equals("/"))    ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if      (op.equals("+"))    v = vals.pop() + v;
                else if (op.equals("-"))    v = vals.pop() - v;
                else if (op.equals("*"))    v = vals.pop() * v;
                else if (op.equals("/"))    v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
