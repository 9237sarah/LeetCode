// https://leetcode.com/problems/string-to-integer-atoi/

public class Solution {
    public int atoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int i = 0;
        int flag = 1;
        if (str.charAt(0) == '+') {
            i++;
        } else if (str.charAt(0) == '-') {
            i++;
            flag = -1;
        }
        double res = 0.0;
        /*
         *  '+-2' ---> 0
         */
        for (; i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'; i++) {
            res = res * 10 + str.charAt(i) - '0';
        }
        res *= flag;
        res = Math.min(res, Integer.MAX_VALUE);
        res = Math.max(res, Integer.MIN_VALUE);
        return (int)res;
    }
}