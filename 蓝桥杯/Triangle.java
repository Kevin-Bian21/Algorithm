package 蓝桥杯;

import java.util.Scanner;

/**
 * @author BianWenKai
 * @DATE 2021/11/14 - 14:48
 **/
public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        n = sc.nextInt();
        String s = sc.nextLine();
        for (int i = 0; i < n; i++) {
            s = sc.nextLine();
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            int c = Integer.parseInt(s.split(" ")[2]);
            judge(i+1, a, b, c);
        }
    }
    private static void judge(int n, int a, int b, int c) {
        int max = Math.max(Math.max(a, b), c);
        boolean flag = false;
        if (max == a && (a*a == b*b + c*c))
            flag = true;
        if (max == b && (b*b == a*a + c*c))
            flag = true;
        if (max == c && (c*c == a*a + b*b))
            flag = true;
        if (flag){
            System.out.println("Test"+n+":");
            System.out.println("Yes");
        }else {
            System.out.println("Test"+n+":");
            System.out.println("No");
        }
    }
}
