package LeetCode;

import java.util.Stack;

/**
 * @author BianWenKai
 * @DATE 2021/11/23 - 12:49
 *
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 **/
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("({})"));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.contains('('))
                    return false;
                else {
                    while (stack.contains('(')) {
                        char ch = stack.pop();
                        if(ch == '[' || ch == '{')
                            return false;
                        if (ch == ('('))
                            break;
                    }
                }
            }
            if (s.charAt(i) == ']') {
                if (!stack.contains('['))
                    return false;
                else {
                    while (stack.contains('[')) {
                        char ch = stack.pop();
                        if(ch == '(' || ch == '{')
                            return false;
                        if (ch == ('['))
                            break;
                    }
                }
            }
            if (s.charAt(i) == '}') {
                if (!stack.contains('{'))
                    return false;
                else {
                    while (stack.contains('{')) {
                        char ch = stack.pop();
                        if(ch == '(' || ch == '[')
                            return false;
                        if (ch == ('{'))
                            break;
                    }
                }
            }
            stack.push(s.charAt(i));
        }
        if(stack.contains('(') || stack.contains('[') || stack.contains('{'))
            return false;
        return true;
    }
}
