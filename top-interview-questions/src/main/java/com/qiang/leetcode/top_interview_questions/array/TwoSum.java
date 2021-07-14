package com.qiang.leetcode.top_interview_questions.array;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 * Constraints:
 * 
 *     2 <= nums.length <= 10^4
 *     -10^9 <= nums[i] <= 10^9
 *     -10^9 <= target <= 10^9
 *     Only one valid answer exists.
 * 
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {
    
    public int[] twoSum(int[] nums, int target) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int i = 0;
        int j = sortedNums.length-1;

        int num1=0, num2=0;

        boolean isFound = false;
        while (j>i && !isFound) {
            int sum = sortedNums[i] + sortedNums[j];
            if (sum < target) {
                i ++;
            } else if (sum > target) {
                j --;
            } else {
                num1 = sortedNums[i];
                num2 = sortedNums[j];
                isFound = true;
            }
        }

        int[] result = new int[2];
        int l=0;
        for (int k=0; k<nums.length; k++) {
            if (nums[k] == num1 || nums[k] == num2) {
                result[l++] = k;
                if (l==2) return result;    
            }
        }
        
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, target);
        if (result!=null) {
            System.out.println(result[0] + ", " + result[1]);
        }
    }

}
