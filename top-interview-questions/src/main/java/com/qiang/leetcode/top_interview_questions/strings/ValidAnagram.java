package com.qiang.leetcode.top_interview_questions.strings;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * Constraints:
 *     1 <= s.length, t.length <= 5 * 10^4
 *     s and t consist of lowercase English letters.
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 * 
 */
public class ValidAnagram {
    
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);

        String sortedS = String.copyValueOf(sChar);
        String sortedT = String.copyValueOf(tChar);

        return sortedS.equals(sortedT);
    }

    public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram";
        System.out.println(isAnagram(s1, t1));

        String s2 = "rat", t2 = "car";
        System.out.println(isAnagram(s2, t2));
    }
}
