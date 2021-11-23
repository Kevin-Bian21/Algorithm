package Test;

import org.junit.Test;

/**
 * @author BianWenKai
 * @DATE 2021/11/21 - 16:20
 **/
public class TestCode {
    public static void main(String[] args) {
        System.out.println('A');

        try {
            System.out.println("1");
            System.out.println(1/0);
        } catch (Exception e) {
            System.out.println("2");
            System.out.println(e);
            return;
        } finally {
            System.out.println("3");
        }
    }
    @Test
    public void test() {
        System.out.println('2' + 1);
    }

}
