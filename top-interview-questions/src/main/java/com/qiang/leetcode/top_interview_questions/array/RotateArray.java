package com.qiang.leetcode.top_interview_questions.array;

import com.qiang.leetcode.utils.Utils;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 */
public class RotateArray {

    public int[] rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i=0; i<k; i++) {
            int pos = i;
            int oldTemp = nums[pos];
            do {
                int newPos = (pos + k) % nums.length;
                int newTemp = nums[newPos];
                nums[newPos] = oldTemp;
                oldTemp = newTemp;
                pos = newPos;
                count ++;
            } while (count < nums.length && pos != i);
            if (count == nums.length) break;
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        System.out.print("Original array: ");
        RotateArray solution = new RotateArray();
        System.out.println(Utils.printArray(nums));
        int[] rotated = solution.rotate(nums, k);
        System.out.print("Rotated array: ");
        System.out.println(Utils.printArray(rotated));
    }
    
}
