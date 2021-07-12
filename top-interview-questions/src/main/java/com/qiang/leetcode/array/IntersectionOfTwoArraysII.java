package com.qiang.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.qiang.leetcode.utils.Utils;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pos1 = 0;
        int pos2 = 0;
        List<Integer> result = new ArrayList<>();
        while (pos1<nums1.length && pos2<nums2.length) {

            if (nums1[pos1]<nums2[pos2]) {
                pos1++;
            } else if (nums1[pos1]>nums2[pos2]) {
                pos2++;
            } else if (nums1[pos1]==nums2[pos2]) {
                result.add(nums1[pos1]);
                pos1++;
                pos2++;
            }

        }

        int[] resultArray = new int[result.size()];
        for (int i=0; i<result.size(); i++) resultArray[i] = result.get(i);
        return resultArray;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {1,1};

        IntersectionOfTwoArraysII solution = new IntersectionOfTwoArraysII();
        int[] result = solution.intersect(nums1, nums2);
        Utils.printArray(result);

    }
}
