package com.qiang.leetcode.top_interview_questions.strings;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * 
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * 
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 * 
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 * 
 * Constraints:
 *     1 <= s.length <= 10^5
 *     s consists of only lowercase English letters.
 * 
 */
public class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {
        
        char[] chars = s.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();

        for (int i=0; i<chars.length; i++) {
            Integer charCount = charMap.get(chars[i]);
            if (charCount==null) {
                charMap.put(chars[i], 1);
            } else {
                charMap.put(chars[i], charMap.get(chars[i]) + 1);
            }
        }

        for (int i=0; i<chars.length; i++) {
            if (charMap.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static int firstUniqCharFast(String s) {
        int pos = Integer.MAX_VALUE;
        for (char c='a'; c<'z'+1; c++) {
            if (s.indexOf(c) != -1 && s.indexOf(c) == s.lastIndexOf(c)) {
                pos = Math.min(pos, s.indexOf(c));
            }
        }
        return pos == Integer.MAX_VALUE ? -1 : pos;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println("s = " + s1);
        System.out.println(firstUniqChar(s1));
        System.out.println(firstUniqCharFast(s1));
        System.out.println();

        String s2 = "loveleetcode";
        System.out.println("s = " + s2);
        System.out.println(firstUniqChar(s2));
        System.out.println(firstUniqCharFast(s2));
        System.out.println();

        String s3 = "aabb";
        System.out.println("s = " + s3);
        System.out.println(firstUniqChar(s3));
        System.out.println(firstUniqCharFast(s3));

    }
    
}
