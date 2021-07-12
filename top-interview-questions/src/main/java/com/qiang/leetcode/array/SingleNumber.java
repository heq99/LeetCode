package com.qiang.leetcode.array;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
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
