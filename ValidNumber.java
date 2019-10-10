// https://leetcode.com/problems/valid-number/

public class Solution {
    // public boolean isNumber(String s) {
    //     return s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*([eE][-+]?\\d+)?");
    // }
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        // "3e" ---> false
        if (s.length() == 0 || s.charAt(s.length() - 1) == 'e') {
            return false;
        }
        String[] res = s.split("e");
        if (res.length == 0 || res.length > 2) {
            return false;
        }
        boolean isValid = isValid(res[0], true);
        if (res.length == 2) {
            isValid = isValid && isValid(res[1], false);
        }
        return isValid;
    }
    private boolean isValid(String s, boolean mayHasDot) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        //  "." ---> false
        if (s.length() == 0 || s.equals(".")) {
            return false;
        }
        char[] cArr = s.toCharArray();
        int numberOfDot = 0;
        for (char c : cArr) {
            if (c == '.') {
                if (!mayHasDot || numberOfDot++ >= 1) {
                    return false;
                }
            } else if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}

// public class Solution {
//     public boolean isNumber(String s) {
//         if (s == null) {
//             return false;
//         }
//         s = s.trim();
//         if (s.length() == 0) {
//             return false;
//         }
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == 'e') {
//                 return i != s.length() - 1 && isValid(s.substring(i + 1), false) && isValid(s.substring(0, i), true);
//             }
//         }
//         return isValid(s, true);
//     }
    
//     public boolean isValid(String s, boolean couldBeDecimal) {
//         if (s == null || s.length() == 0) {
//             return false;
//         }
//         if (s.charAt(0) == '-' || s.charAt(0) == '+') {
//             s = s.substring(1);
//         }
//         if (s == null || s.length() == 0 || s.equals(".")) {
//             return false;
//         }
//         for (int numOfDecimal = 0, i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '.') {
//                 if (!couldBeDecimal || numOfDecimal != 0) {
//                     return false;
//                 }
//                 numOfDecimal++;
//             } else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
//                 return false;
//             } 
//         }
//         return true;
//     }
// }