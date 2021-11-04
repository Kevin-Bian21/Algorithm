package 蓝桥杯;

/**
 * @author BianWenKai
 * @DATE 2021/11/4 - 15:16
 **/
public class BinarySum {

    public static void main(String[] args) {
        String s = "1010";
        String s1 = "1011";
        BinarySum binarySum = new BinarySum();
        System.out.println(binarySum.sum(s, s1));
    }
    public String sum(String str1, String str2) {
        if (str1 == null && str2 == null)
            return "";
        int sum;  //本位和
        int carry = 0;  //进位
        StringBuilder res = new StringBuilder();
        StringBuilder string1 = new StringBuilder(str1).reverse();
        StringBuilder string2 = new StringBuilder(str2).reverse();
        int i = 0;
        int m;
        int n;
        while (i < Math.min(string1.length(), string2.length())) {
            m = charCastInt(string1.charAt(i));
            n = charCastInt(string2.charAt(i));
            sum = (m + n + carry) % 2;
            carry = (m + n + carry) / 2;
            res.append(sum);
            i++;
        }
        while (i < string1.length()) {
            m = charCastInt(string1.charAt(i));
            if (carry == 1) {
                sum = (m + carry) % 2;
                carry = (m + carry) / 2;
                res.append(sum);
            }
            if (carry != 1) {
                res.append(string1.substring(i));
                i += string1.length() - i;
            }
            i++;
        }
        while (i < string2.length()) {
            n = charCastInt(string2.charAt(i));
            if (carry == 1) {
                sum = (n + carry) % 2;
                carry = (n + carry) / 2;
                res.append(sum);
            }
            if (carry != 1) {
                res.append(string2.substring(i));
                i = i + string2.length() - i;
            }
            i++;
        }
        if (carry == 1)
            res.append(1);

        return res.reverse().toString();
    }
    private int charCastInt(char c) {
        if (c == '0')
            return 0;
        if (c == '1')
            return 1;
        return 0;
    }

}
