package oj;

import java.util.*;

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
            if(line==null || line.equals("")){
                continue;
            }

            ArrayList<CalNode> nodeList = new ArrayList<>();//存储所有节点
            StringBuilder builder = new StringBuilder();//缓存数字

            //1.读取所有节点
            int index=0;
            while (index < line.length()) {
                if (!isLegalNumeric(String.valueOf(line.charAt(index)))) {
                    index++;
                    continue;
                }

                String word = String.valueOf(line.charAt(index));
                if (isOperator(word)) {
                    //flush剩余的数值.
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
                    builder = null;
                }
            }

            //2.首先处理乘除两种运算符.
            LinkedList<CalNode> linkedQueue = new LinkedList<>();
            index = 0;
            boolean isError = false;//除数为0，则输出err信息.
            while (index < nodeList.size()) {
                CalNode curNode = nodeList.get(index);
                if (curNode instanceof Operator) {
                    Operator operator = (Operator) curNode;
                    //如果运算符为乘除
                    if (operator.value.equals(Operator.DIVIDE)
                            || operator.value.equals(Operator.MULTIPLY)) {
                        Operand operand1 = (Operand) linkedQueue.pop();
                        Operand operand2 = (Operand) nodeList.get(++index);
                        if (operator.value.equals(Operator.DIVIDE)) {
                            if (operand2.value == 0) {
                                isError = true;
                                break;
                            } else {
                                linkedQueue.push(new Operand(operand1.value / operand2.value));
                            }
                        } else if (operator.value.equals(Operator.MULTIPLY)) {
                            linkedQueue.push(new Operand(operand1.value * operand2.value));
                        }
                    } else {
                        linkedQueue.push(new Operator(operator.value));
                    }
                } else {
                    Operand operand = (Operand) curNode;
                    linkedQueue.push(operand);
                }
                index++;
            }


            //输出错误信息
            if (isError) {
                System.out.println("err");
                continue;
            }

            //计算栈中剩余元素的值,只有加减运算符和数值
            while (linkedQueue.size() > 1) {
                Operand operand1 = (Operand) linkedQueue.pollLast();
                Operator operator = (Operator) linkedQueue.pollLast();
                Operand operand2 = (Operand) linkedQueue.pollLast();

                switch (operator.value) {
                    case Operator.PLUS:
                        linkedQueue.addLast(new Operand(operand1.value + operand2.value));
                        break;
                    case Operator.MINUS:
                        linkedQueue.addLast(new Operand(operand1.value - operand2.value));
                        break;
                }
            }

            //输出最终结果
            Operand result = (Operand) linkedQueue.pollFirst();
            System.out.println(result.value);

        }
    }

    private static boolean isOperator(String character) {
        return Operator.DIVIDE.equals(character) ||
                Operator.MINUS.equals(character) ||
                Operator.MULTIPLY.equals(character) ||
                Operator.PLUS.equals(character);
    }

    private static boolean isLegalNumeric(String word) {
        boolean illegal = word != null && !word.trim().equals("");

        if (!illegal) {
            return false;
        }

        boolean isOperator = (word.equals(Operator.MULTIPLY)
                || word.equals(Operator.DIVIDE)
                || word.equals(Operator.MINUS)
                || word.equals(Operator.PLUS));

        if (isOperator) {
            return true;
        }

        try {
            Integer.valueOf(word);
            return true;
        } catch (Exception e) {
            return false;
        }

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

    }

}
