package org.hmk.square_root;

public class Solution {
    public static void main(String[] args) {
        double num = 2;
        double t;
        double sqrtroot=num/2;
        do
        {
            t=sqrtroot;
            sqrtroot=(t+(num/t))/2;
        }
        while((t-sqrtroot)!= 0);
        double res = sqrtroot;
        return;
    }
}

