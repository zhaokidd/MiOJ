package src.oj;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述：
 * 给定一个只包含小写字母的字符串，
 * 现在我 mi 被众友商品牌的字符串围困在其中，需要我们将字符串中的 mi 全部移除然后输出，保证最后输出的字符串中没有 "mi"。
 *
 * 用栈这个数据结构
 * 1.需要注意peek和pop操作要注意当前栈的size，避免空栈情况下弹栈导致异常
 * 2.可能会有mmmii这种情况，所以需要用栈来处理
 */
public class Problem102 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();

            Stack<Character> stack = new Stack<>();
            char topCharacter = '@';
            char curCharacter = '@';

            for (int i = line.length() - 1; i >= 0; i--) {
                char temp = line.charAt(i);
                curCharacter = temp;
                if (topCharacter == 'i' && curCharacter == 'm') {
                    stack.pop();
                    if (stack.size() <= 0) {
                        topCharacter = '@';
                        continue;
                    } else {
                        topCharacter = stack.peek();
                    }
                } else {
                    stack.push(temp);
                    topCharacter = temp;
                }
            }

            StringBuilder builder = new StringBuilder();
            while (stack.size() > 0) {
                builder.append(stack.pop());
            }

            System.out.println(builder.toString());
        }
    }
}