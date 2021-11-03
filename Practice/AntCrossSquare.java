package Practice;

/**
 * @author BianWenKai
 * @DATE 2021/10/31 - 22:33
 **/
public class AntCrossSquare {
    /*
        给定一个 n*m 的方格，一只蚂蚁从方格的左上角要走到方格的右下角有多少种走法。
        规定蚂蚁每次只能向下或向右移动一格
        1. 当只有一个格子时，只能有一种走法，拓展一下当这个格子只有一行或者一列时也只有一种走法。
     */
    public static void main(String[] args) {
        AntCrossSquare antCrossSquare = new AntCrossSquare();
        System.out.println(antCrossSquare.solution(3, 3));
    }
    public int solution(int n, int m){
        if (m == 1 || n == 1)
            return 1;
        else
            return solution(n, m-1) + solution(n-1, m);
    }
}
