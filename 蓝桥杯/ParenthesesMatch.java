package 蓝桥杯;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author BianWenKai
 * @DATE 2021/11/14 - 16:28
 **/
public class ParenthesesMatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(exam(s));
        }
    }

    public static String exam(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.contains('(')) {
                    while (true) {
                        char ch = stack.pop();
                        if (ch == '(')
                            break;
                    }
                }else
                    return "Wrong";
            }
            stack.push(s.charAt(i));
        }
        if (stack.contains('('))
            return "Wrong";
        return "Ok";
    }
}
