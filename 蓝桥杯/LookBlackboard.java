package 蓝桥杯;

import java.util.Scanner;

/**
 * @author BianWenKai
 * @DATE 2021/11/14 - 14:13
 **/
public class LookBlackboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        exam(array);
    }

    public static void exam(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (array[j] > array[i]) {
                    newArray[i] = j + 1;
                    break;
                }
            }
        }
        for (int value : newArray) {
            System.out.print(value);
        }
    }
}

