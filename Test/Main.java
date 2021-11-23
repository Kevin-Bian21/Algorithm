package Test;

/**
 * @author BianWenKai
 * @DATE 2021/11/22 - 20:07
 **/
public class Main {

    public static void main(String[] args) {
        Parent parent;
        parent = new Son();
        test(parent);
    }

    public static void test(Parent parent) {
        parent.test();
    }

}
