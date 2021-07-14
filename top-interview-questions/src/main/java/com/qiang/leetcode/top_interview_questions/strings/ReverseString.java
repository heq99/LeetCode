package com.qiang.leetcode.top_interview_questions.strings;

import com.qiang.leetcode.utils.Utils;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 * 
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * 
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * 
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * Constraints:
 *     1 <= s.length <= 10^5
 *     s[i] is a printable ascii character.
 * 
 * Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * Hide Hint #1  
 * The entire logic for reversing a string is based on using the opposite directional two-pointer approach!
 * 
 */
public class ReverseString {

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        char[] s1 = new char[] {'h','e','l','l','o'};
        System.out.println("Input: " + Utils.printArray(s1));
        reverseString(s1);
        System.out.println("Output: " + Utils.printArray(s1));

        System.out.println();

        char[] s2 = new char[] {'H','a','n','n','a','h'};
        System.out.println("Input: " + Utils.printArray(s2));
        reverseString(s2);
        System.out.println("Output: " + Utils.printArray(s2));
    }
}
