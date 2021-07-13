package com.qiang.leetcode.top_interview_questions.array;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
 * 
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * 
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * 
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * 
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * 
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 * 
 * Constraints:
 *     1 <= nums.length <= 3 * 10^4
 *     -3 * 10^4 <= nums[i] <= 3 * 10^4
 *     Each element in the array appears twice except for one element which appears only once.
 */
public class SingleNumber {
    
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length==1) return nums[0];
        if (nums.length==2) return -999999;
        if (nums[0]!=nums[1] && nums[1]==nums[2]) return nums[0];
        for (int i=1; i<nums.length;) {
            if (nums[i]!=nums[i-1]) return nums[i-1];
            if (i==nums.length-2) return nums[nums.length-1];
            i+=2;
        }
        return -999999;
    }

    public static void main(String[] args) {

        int[] nums = {4,1,2,1,2};

        SingleNumber singleNumber = new SingleNumber();
        System.out.println("Single Number: " + singleNumber.singleNumber(nums));
    }
}
