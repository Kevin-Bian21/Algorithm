package 蓝桥杯;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author BianWenKai
 * @DATE 2021/11/28 - 18:42
 *
 * 链接：https://ac.nowcoder.com/acm/contest/24500/F
 *
 * 每组输入数据分为三行,第一行有两个数字n,m,分别表示包裹A和包裹B的手办个数.后两行分别表示包裹A和包裹B中所含手办的序号.
 * 每个手办序号为不超出int范围的整数,每个序号之间有一个空格隔开.
 *0 ≤ n,m ≤ 10000
 *
 * 针对每组数据输出一行数据,表示全部可以拿走的手办序号,要求从小到大输出,每个手办序号之间有一个空格隔开.
 *
 * 输入：
 * 1 2
 * 1
 * 2 3
 * 1 2
 * 1
 * 1 2
 *
 * 输出
 * 1 2 3
 * 1 2
 **/
public class CanNotRepeatKit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            //使用拉姆达表达式来对set集合进行排序 ：(x, y) -> x-y
//            Set<Integer> set = new TreeSet<>((x, y) -> x-y );

            //使用匿名对象进行实现compare方法
            Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            while (m > 0) {
                set.add(sc.nextInt());
                m --;
            }
            while (n > 0) {
                set.add(sc.nextInt());
                n --;
            }
            for (int value : set) {
                System.out.print(value);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
