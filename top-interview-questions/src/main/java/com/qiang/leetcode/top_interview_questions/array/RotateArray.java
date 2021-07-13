package com.qiang.leetcode.top_interview_questions.array;

import com.qiang.leetcode.utils.Utils;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 * 
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * Constraints:
 *     1 <= nums.length <= 10^5
 *     -2^31 <= nums[i] <= 2^31 - 1
 *     0 <= k <= 10^5
 * 
 * Follow up:
 *     Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 *     Could you do it in-place with O(1) extra space?
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
