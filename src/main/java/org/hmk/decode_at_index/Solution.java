package org.hmk.decode_at_index;

public class Solution {
    public String decodeAtIndex(String s, int k) {
        long len = 0;
        int index = 0;
        for (; index < s.length(); ++index) {
            if (Character.isLetter(s.charAt(index))) {
                len++;
            } else {
                len *= s.charAt(index) - '0';
            }
            if (len >= k) {
                break;
            }
        }
        long start = 1;
        long end = len;
        for (; index >= 0; index--) {
            if (end == k) {
                while (!Character.isLetter(s.charAt(index))) {
                    --index;
                }
                return String.valueOf(s.charAt(index));
            }
            if (Character.isLetter(s.charAt(index))) {
                end--;
            } else {
                int count = s.charAt(index) - '0';
                long interval = (end - start + 1) / count;
                for (int i = 1; i <= count; ++i) {
                    if (start + (i - 1) * interval <= k && k <= start + i * interval - 1) {
                        end = start + i * interval - 1;
                        start += (i - 1) * interval;
                        break;
                    }
                }
            }
        }
        return null;
    }
}
