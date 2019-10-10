// https://leetcode.com/problems/valid-palindrome/

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        s = s.trim().toLowerCase();
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int left = 0, right = s.length() - 1; left < right;) {
            while (left < right && !isValid(s.charAt(left))) {
                left++;
            }
            while (left < right && !isValid(s.charAt(right))) {
                right--;
            }
            if (left < right && s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}