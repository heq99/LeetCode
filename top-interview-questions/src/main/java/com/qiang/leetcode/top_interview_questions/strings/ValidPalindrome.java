package com.qiang.leetcode.top_interview_questions.strings;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/
 * 
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * 
 * Constraints:
 *     1 <= s.length <= 2 * 10^5
 *     s consists only of printable ASCII characters.
 * 
 */
public class ValidPalindrome {
    
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;

        int left = -1;
        int right = s.length();

        while (left < right) {
            char leftC = ' ';
            char rightC = ' ';
            do {
                left ++;
                if (left >= right) return true;
                leftC = Character.toLowerCase(s.charAt(left));
            } while ((leftC < 'a' || leftC > 'z') && (leftC < '0' || leftC > '9'));
            do {
                right --;
                if (right <= left) return true;
                rightC = Character.toLowerCase(s.charAt(right));
            } while ((rightC < 'a' || rightC > 'z') && (rightC < '0' || rightC > '9'));
            if (leftC != rightC) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s1));

        String s2 = "race a car";
        System.out.println(isPalindrome(s2));

        String s3 = " ";
        System.out.println(isPalindrome(s3));

        String s4 = ".,";
        System.out.println(isPalindrome(s4));
    }
}
