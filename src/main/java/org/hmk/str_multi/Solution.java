package org.hmk.str_multi;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("9133", "0"));
    }
    public String multiply(String num1, String num2) {
        String sum = "0";
        int length = num2.length();
        for (int i = 1; i <= length; ++i) {
            String tmp = singleMultiply(num1, num2.charAt(length - i), i);
            sum = add(tmp, sum);
        }
        return sum;
    }

    private String add(String add1, String add2) {
        int length = Math.max(add1.length(), add2.length());
        StringBuilder sb = new StringBuilder();
        int add = 0;
        for (int i = 1; i <= length; ++i) {
            int ad1 = getAddition(add1, i);
            int ad2 = getAddition(add2, i);
            int tmp = ad1 + ad2 + add;
            add = tmp / 10;
            char cur = (char) (tmp % 10 + '0');
            sb.insert(0, cur);
        }
        if (add > 0) {
            char cur = (char) (add + '0');
            sb.insert(0, cur);
        }
        return sb.toString();
    }

    private int getAddition(String num, int index) {
        int i = num.length() - index;
        if (i < 0) {
            return 0;
        } else {
            return num.charAt(i) - '0';
        }
    }

    private String singleMultiply(String num, char c, int cardinal) {
        if (c == '0') {
            return "0";
        }
        int length = num.length();
        int add = 0;
        int mul2 = c - '0';
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; --i) {
            int mul1 = num.charAt(i) - '0';
            int product = mul1 * mul2 + add;
            add = product / 10;
            char cur = (char) (product % 10 + '0');
            sb.insert(0, cur);
        }
        if (add > 0) {
            char cur = (char) (add + '0');
            sb.insert(0, cur);
        }
        if (sb.charAt(0) != '0') {
            for (int i = 1; i < cardinal; ++i) {
                sb.append('0');
            }
        }
        return sb.toString();
    }
}
