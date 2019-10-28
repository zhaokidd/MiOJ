package oj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述:实现一个算法，可以进行任意非负整数的加减乘除组合四则运算。
 *         请注意运算符的优先级。
 *
 * https://code.mi.com/problem/list/view?id=16
 *
 * 可以使用栈来解决此类问题。
 *
 * 解题思路：所有数字和运算符均入栈,遇乘除运算符时弹出运算数运算，结果重新入栈．
 *         剩余运算数顺序出栈运算.最终栈中只剩一个最终运算结果.
 * */
public class Problem16 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;

        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            ArrayList<CalNode> nodeList = new ArrayList<>();//存储所有节点
            StringBuilder builder = new StringBuilder();//缓存数字

            //读取所有节点
            int index=0;
            while (index < line.length()) {
                String word = String.valueOf(line.charAt(index));
                if (isOperator(word)) {
                    nodeList.add(new Operand(Integer.parseInt(builder.toString())));
                    builder = new StringBuilder();
                    nodeList.add(new Operator(word));
                } else {
                    builder.append(word);
                }

                index++;

                //清空builder中的数字
                if (index >= line.length() && builder.length() > 0) {
                    nodeList.add(new Operand(Integer.parseInt(builder.toString())));
                    builder = new StringBuilder();
                }
            }


            Stack<CalNode> stack = new Stack<>();
            index =0 ;
            boolean isError = false;
            while (index < nodeList.size()) {
                CalNode curNode = nodeList.get(index);
                if (curNode instanceof Operator) {
                    Operator operator = (Operator) curNode;
                    //如果运算符为乘除
                    if (operator.value.equals(Operator.DIVIDE)
                            || operator.value.equals(Operator.MULTIPLY)) {
                        Operand operand1 = (Operand) stack.pop();
                        Operand operand2 = (Operand) nodeList.get(++index);
                        if (operator.value.equals(Operator.DIVIDE)) {
                            if (operand2.value == 0) {
                                System.out.println("err");
                                isError = true;
                                break;
                            } else {
                                stack.push(new Operand(operand1.value / operand2.value));
                            }
                        } else {
                            stack.push(new Operand(operand1.value * operand2.value));
                        }
                    } else {
                        stack.push(new Operator(operator.value));
                    }
                }else{
                    Operand operand = (Operand) curNode;
                    stack.push(operand);
                }
                index++;
            }

            //计算栈中剩余元素的值,只有加减运算符和数值
            while (stack.size() > 1) {
                Operand operand2 = (Operand) stack.pop();
                Operator operator = (Operator) stack.pop();
                Operand operand1 = (Operand) stack.pop();

                switch (operator.value){
                    case Operator.PLUS:
                        break;
                    case Operator.MINUS:
                }
            }

        }
    }

    private static boolean isOperator(String character) {
        return Operator.DIVIDE.equals(character) ||
                Operator.MINUS.equals(character) ||
                Operator.MULTIPLY.equals(character) ||
                Operator.PLUS.equals(character);
    }

    abstract static class CalNode{
    }

    static class Operand extends CalNode{
        int value;

        public Operand(int value) {
            this.value = value;
        }
    }

    static class Operator extends CalNode{
        static final String PLUS     = "+";
        static final String MINUS    = "-";
        static final String DIVIDE   = "/";
        static final String MULTIPLY = "*";

        String value;

        public Operator(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
