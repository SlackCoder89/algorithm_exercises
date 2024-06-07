package org.hmk.minimum_number_of_jumps;

/*

i = 0
maxReach = 1
step = 1
arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 */
public class Solution {
    static int minJumps(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        int step = arr[0];
        int maxReach = arr[0];
        int jump = 1;
        for (int i = 1; i < arr.length; ++i) {
            if (i == arr.length - 1) {
                return jump;
            }
            maxReach = Math.max(maxReach, i + arr[i]);
            step--;
            if (step == 0) {
                step = maxReach - i;
                jump++;
            }
            if (step <= 0) {
                return -1;
            }
        }
        return -1;
    }
}
