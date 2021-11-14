package 蓝桥杯;

import java.util.Scanner;

/**
 * @author BianWenKai
 * @DATE 2021/11/14 - 14:29
 **/
public class Fight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int counts = 0;
        for (int i = 0; i <= n; i++) {
            String string = sc.nextLine();
            counts += process(string);
        }
        System.out.println(n - counts);
    }

    private static int process(String string) {
        int index = 0;
        while ((index + 2) < string.length()) {
            if (string.charAt(index) == 'W' && string.charAt(index + 1) == 'Z' && string.charAt(index + 2) == 'Y')
                return 1;
            index ++;
        }
        return 0;
    }

}
