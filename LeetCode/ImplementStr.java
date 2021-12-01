package LeetCode;

/**
 * @author BianWenKai
 * @DATE 2021/12/1 - 10:39
 *
 * 28. 实现 strStr()
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 **/
public class ImplementStr {
    public static void main(String[] args) {
        ImplementStr implementStr = new ImplementStr();
        System.out.println(implementStr.strStr("aaa", "aaaa"));
    }

    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i ++;
                j ++;
            } else {
                i ++;
                i = i -j;
                j = 0;
            }
            if (j == needle.length() || i == haystack.length())
                break;

        }
        return j == needle.length() ? i-j : -1;
    }
}
