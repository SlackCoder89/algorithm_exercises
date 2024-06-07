package org.hmk.find_duplicate;

public class Solution {
    public int findDuplicate(int[] nums) {
        int[] bits = new int[3300];
        for (int num : nums) {
            if (isExist(num, bits)) {
                return num;
            }
        }
        return -1;
    }

    private boolean isExist(int num, int[] bits) {
        int index = num / 31;
        int offset = num % 31 - 1;
        if (offset < 0) {
            offset += 31;
        }
        int mask = 1;
        mask <<= offset;
        if ((bits[index] & mask) > 0) {
            return true;
        } else {
            bits[index] |= mask;
            return false;
        }
    }
}
