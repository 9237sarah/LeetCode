// https://leetcode.com/problems/word-ladder/

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null || dict.size() == 0 || start.equals(end)) {
            return 0;
        }
        
        List<String> list = new ArrayList<>();
        list.add(start);
        int res = 2;
        while (!dict.isEmpty() && !list.isEmpty()) {
            List<String> temp = new ArrayList<>();
            for (String s : list) {
                char[] cArr = s.toCharArray();
                for (int i = 0; i < cArr.length; i++) {
                    char origin = cArr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        cArr[i] = c;
                        String str = new String(cArr);
                        if (str.equals(end)) {
                            return res;
                        }
                        if (dict.remove(str)) {
                            temp.add(str);
                        }
                    }
                    cArr[i] = origin;
                }
            }
            list = temp;
            res++;
        }
        return 0;
    }
}