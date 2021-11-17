package 蓝桥杯;

import java.util.Scanner;

/**
 * @author BianWenKai
 * @DATE 2021/11/17 - 11:38
 *
 * 小明练习书写英语单词效果不错，今天竟然老师表扬他字体大有进步，
 * 喜出望外的小明回家后又开始奋笔疾书练英语字幕，写着写着他又发现了一个有意思的现象，
 * 比如写出的abcabcabcabc，是由某个长度为k的字符串重复多次得到，则该串以k为周期。
 * 例如，刚才的那个长字符串就是以3为周期（注意，它也以6和12为周期）
 *
 **/
public class RepeatStringPeriod {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(foundRepeatPeriod(string));
    }
    public static int foundRepeatPeriod(String string) {
        int len = 0;
        for (int i = 1; i < string.length(); i++) {
            String per = string.substring(0, i);
            for (int j = 0, k = i; j < string.length(); j+=i) {
                if (k <= string.length())
                    if (!per.equals(string.substring(j,k)))
                        break;
                k += i;
                if (k == string.length())
                    return i;
            }
        }
        return len;
    }
}
