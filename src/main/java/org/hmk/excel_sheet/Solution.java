package org.hmk.excel_sheet;

public class Solution {
    public String excelColumn(int n){
        final int MOD = 26;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int tmp = n % MOD;
            char c = 'A';
            boolean carriage = false;
            if (tmp == 0) {
                c = 'Z';
                carriage = true;
            } else {
                c = (char) (c + tmp - 1);
            }
            sb.insert(0, c);

            n /= MOD;
            if (carriage) {
                n--;
            }
        }

        return sb.toString();
    }
}
