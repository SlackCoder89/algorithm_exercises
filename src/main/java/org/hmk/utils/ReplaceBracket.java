package org.hmk.utils;

public class ReplaceBracket {
    public static void main(String[] args) {
        String s = "[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]";
        System.out.println(s.replace("[", "{").replace("]", "}"));
    }
}
