package com.qiang.leetcode.top_interview_questions.array;

import com.qiang.leetcode.utils.Utils;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
 * 
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * 
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * 
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * 
 * Example 3:
 * Input: digits = [0]
 * Output: [1]
 * 
 * Constraints:
 *     1 <= digits.length <= 100
 *     0 <= digits[i] <= 9
 */
public class PlusOne {
    
    public int[] plusOne(int[] digits) {
        int carry=0;
        for (int i=digits.length-1; i>=0; i--) {
            if (i==digits.length-1) {
                digits[i] ++;
            } else {
                digits[i] += carry;
                carry=0;
            }
            if (digits[i]>9) {
                carry=1;
                digits[i] -= 10;
            }
        }
        if (carry>0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            for (int i=1; i<digits.length + 1; i++) {
                newDigits[i] = digits[i-1];
            }
            return newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {1};
        PlusOne solution = new PlusOne();
        System.out.println(Utils.printArray(solution.plusOne(digits)));
    }
}
