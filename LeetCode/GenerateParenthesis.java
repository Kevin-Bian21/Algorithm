package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BianWenKai
 * @DATE 2021/11/25 - 17:06
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 输入：n = 1
 * 输出：["()"]
 **/
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.dfs(4));
    }
    public List<String> dfs(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, n, n, "");
        return list;
    }
    private void dfs(List<String> list, int left, int right, String curStr) {
        if (left == 0 && right == 0) {
            list.add(curStr);
            return;
        }
        if (left > 0)
            dfs(list, left - 1, right, curStr + "(");

        if (right > left)
            dfs(list, left,  right - 1, curStr + ")");
    }
}
