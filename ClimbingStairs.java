// https://leetcode.com/problems/climbing-stairs/

public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[] {1, 1};
        for (int i = 2; i <= n; i++) {
            dp[i % 2] += dp[(i - 1) % 2];
        }
        return dp[n % 2];
    }
}