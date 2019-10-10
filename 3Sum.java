// https://leetcode.com/problems/3sum/

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length < 3) {
            return res;
        }
        Arrays.sort(num);
        /*
         *  Repeat!!!
         */
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < num.length - 2; i++) {
            for (int start = i + 1, end = num.length - 1; start < end;) {
                if (num[start] + num[end] + num[i] == 0) {
                    List<Integer> sol = Arrays.asList(num[i], num[start++], num[end--]);
                    if (set.add(sol)) {
                        res.add(sol);
                    }
                } else if (num[start] + num[end] + num[i] > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return res;
    }
}