package com.qiang.leetcode.utils;

public class Utils {
    
    public static String printArray(int[] array) {
        StringBuffer out = new StringBuffer();
        out.append("[");
        for (int i=0; i<array.length; i++) {
            out.append(array[i]);
            if (i!=array.length-1) {
                out.append(", ");
            }
        }
        out.append("]");
        return out.toString();
    }
    
    public static String printArray(char[] array) {
        StringBuffer out = new StringBuffer();
        out.append("[");
        for (int i=0; i<array.length; i++) {
            out.append(array[i]);
            if (i!=array.length-1) {
                out.append(", ");
            }
        }
        out.append("]");
        return out.toString();
    }
    
}
