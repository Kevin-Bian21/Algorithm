package LeetCode;

import java.util.*;

/**
 * @author BianWenKai
 * @DATE 2021/11/21 - 14:18
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * https://gitee.com/Kevin_Bian/img_bed/raw/master/img/拨号盘.png
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 输入：digits = ""
 * 输出：[]
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 **/
public class LetterCombination {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.equals(""))
            return list;

        String[] array = {"abc", "def", "ghi", "jkl", "mon", "pqrs", "tuv", "wxyz"};

        //'2' 的ASCII码值为50
        String s = array[digits.charAt(0)-50];
        for (int j = 0; j < s.length(); j++)
            list.add(String.valueOf(s.charAt(j)));
        if (digits.length() == 1)
            return list;
        for (int i = 1; i < digits.length(); i++) {
            List<String> ls = new ArrayList<>();
            for (String value : list) {
                String s1 = array[digits.charAt(i)-50];
                for (int k = 0; k < s1.length(); k++) {
                    ls.add(value + s1.charAt(k));
                }
            }
            list = ls;
        }
        return list;
    }
}
