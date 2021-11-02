package 蓝桥杯;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author BianWenKai
 * @DATE 2021/11/1 - 23:04
 **/
public class MaxLengthChildStr {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     * 输入: abcabcbb
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: bbbbb
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: pwwkew
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 示例 4:
     * 输入:  （输入为空）
     * 输出: 0
     * @param args
     */
    public static void main(String[] args) {
        String string = "mssd";
        MaxLengthChildStr maxLengthChildStr = new MaxLengthChildStr();
        System.out.println(maxLengthChildStr.solution(string));
        System.out.println(maxLengthChildStr.solutionWithQueue(string));
    }
    //方法一：使用双指针法
    public int solution(String str) {
        int max = 0;
       if (str == null) {
           return max;
       }
       int i = 0;
       int j = 1;
       int cur = i;
       while (j < str.length()) {
           if (str.charAt(i) != str.charAt(j)) {
               while (cur < j) {
                   if (str.charAt(cur) == str.charAt(j)) {
                       i = cur + 1;
                   }
                   cur ++;
               }
               j++;
               cur = i;
           }else {
               //从j-1位置处开始从后往前找，找到第一个和j位置处的元素一致的元素退出。
               for (int k = j - 1; k > 0; k--) {
                   if (str.charAt(k) == str.charAt(j)) {
                       i = k + 1;
                       break;
                   }
               }
           }
           if (max < j-i) {
               max = j - i;
           }
       }
        if (max < j-i) {
            max = j - i;
        }
       return max;
    }

    //方法二：使用队列，当队列中没有和要加入的元素一样的元素时，则将该加入队列，否则的话从队列头开始移除元素，直到将队列中和该元素一样的元素移除时结束。
    public int solutionWithQueue(String str) {
        int max = 0;
        if (str == null)
            return max;
        Queue<Character> queue = new ConcurrentLinkedDeque<>();
        int i = 0;
        while (i < str.length()) {
            if (queue.contains(str.charAt(i))) {
                while (true) {
                    Character c = queue.remove();
                    if (c.equals(str.charAt(i)))
                        break;
                }
            }
            queue.add(str.charAt(i));
            i ++;
            if (queue.size() > max)
                max = queue.size();
        }
        return max;
    }
}
