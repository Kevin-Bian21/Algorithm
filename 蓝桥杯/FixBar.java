package 蓝桥杯;

import java.util.Scanner;

/**
 * @author BianWenKai
 * @DATE 2021/11/14 - 15:20
 *
 *小明才放暑假就接到老爸电话，需要他回老家帮助爷爷重建羊圈，爷爷的要求很奇怪，要求重修羊圈栅栏，且栅栏的每个部分只能沿着南北或东西的方向修建，
 * 在栅栏改变方向的地方，得有一个立柱。现在小明才刚建好了所有的立柱，但他不小心丢了设计图纸，所以没有办法进行栅栏的制作，所以请你帮一下他。
 * 在给定所有立柱坐标的情况下，计算出栅栏的长度，保证修建能继续进行。假设横纵坐标的单位长度一致，都为L。
 *
 *
 * 输入包含了多组测试用例，每组测试用例的第一行为一个数字N,1 <=N <= 100 000,N代表了已经建好的立柱的个数.
 * 接下来的N行每行都包含两个整数，代表着羊圈上的坐标X和Y，0 <= X, Y <= 10 000，任意两个立柱的坐标不会重合。
 * 每组测试用例都以一个空行做分隔，以一个仅包含一个数字0的单行作为所有输入的结束。
 *
 * 输入：
 * -------------------------------
 *8
 * 1 1
 * 2 1
 * 2 2
 * 3 3
 * 3 2
 * 4 3
 * 4 4
 * 1 4
 *
 * 4
 * 0 0
 * 4 0
 * 4 1
 * 0 1
 *
 * 0
 * ------------------------------------
 * 输出：
 * The length is 12 L
 * The length is 10 L
 **/
public class FixBar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            int x = 0;
            int y = 0;
            int x1 = 1 << 20;
            int y1 = 1 << 20;
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                x = Math.max(x, a);
                y = Math.max(y, b);

                x1 = Math.min(x1, a);
                y1 = Math.min(y1, b);

            }

            int len = (x - x1 + y - y1)*2;
            System.out.println("The length is " + len + " L");
        }

    }
}
