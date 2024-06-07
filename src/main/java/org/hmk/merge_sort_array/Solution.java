package org.hmk.merge_sort_array;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mi = 0;
        int ni = 0;
        int[] res = new int[m + n];
        int i = 0;
        while (mi < m || ni < n) {
            if (mi < m && ni < n) {
                if (nums1[mi] < nums2[ni]) {
                    res[i] = nums1[mi];
                    i++;
                    mi++;
                } else {
                    res[i] = nums2[ni];
                    i++;
                    ni++;
                }
            } else {
                if (mi < m) {
                    res[i] = nums1[mi];
                    i++;
                    mi++;
                } else {
                    res[i] = nums2[ni];
                    i++;
                    ni++;
                }
            }
        }

        System.arraycopy(res, 0, nums1, 0, res.length);
    }
}
