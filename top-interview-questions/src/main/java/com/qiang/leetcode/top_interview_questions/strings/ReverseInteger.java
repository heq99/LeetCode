package com.qiang.leetcode.top_interview_questions.strings;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
 * 
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * 
 * Example 1:
 * Input: x = 123
 * Output: 321
 * 
 * Example 2:
 * Input: x = -123
 * Output: -321
 * 
 * Example 3:
 * Input: x = 120
 * Output: 21
 * 
 * Example 4:
 * Input: x = 0
 * Output: 0
 * 
 * Constraints:
 *     -2^31 <= x <= 2^31 - 1
 */
public class ReverseInteger {
    
    public static int reverse(int x) {

        int sign = x < 0 ? -1 : 1;

        char[] c = String.valueOf(Math.abs(x)).toCharArray();

        int left = 0;
        int right = c.length-1;
        while (left < right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left ++;
            right --;
        }

        String s = String.copyValueOf(c);

        try {
            return sign * Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int x = 123;
        int y = reverse(x);
        System.out.println("Input: " + x);
        System.out.println("Output: " + y);

        System.out.println();

        x = -123;
        y = reverse(x);
        System.out.println("Input: " + x);
        System.out.println("Output: " + y);

        System.out.println();

        x = Integer.MAX_VALUE;
        y = reverse(x);
        System.out.println("Input: " + x);
        System.out.println("Output: " + y);

        System.out.println();

        x = Integer.MIN_VALUE;
        y = reverse(x);
        System.out.println("Input: " + x);
        System.out.println("Output: " + y);

    }
}
