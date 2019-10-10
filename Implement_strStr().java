// https://leetcode.com/problems/implement-strstr/

public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            /*
             *  isSubstring handle ("someString", "") ---> "someString" situation
             */
            boolean isSubstring = true;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    isSubstring = false;
                    break;
                }
            }
            if (isSubstring) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}