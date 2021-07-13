package com.qiang.leetcode.top_interview_questions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.qiang.leetcode.utils.Utils;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
 * 
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element 
 * in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 * 
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * 
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * 
 * Constraints:
 *     1 <= nums1.length, nums2.length <= 1000
 *     0 <= nums1[i], nums2[i] <= 1000
 * 
 * Follow up:
 *     What if the given array is already sorted? How would you optimize your algorithm?
 *     What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *     What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
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
        System.out.println(Utils.printArray(result));

    }
}
