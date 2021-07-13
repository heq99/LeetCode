package com.qiang.leetcode.top_interview_questions.array;

import com.qiang.leetcode.utils.Utils;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
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
