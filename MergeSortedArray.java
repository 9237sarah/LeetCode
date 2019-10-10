// https://leetcode.com/problems/merge-sorted-array/

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null || n == 0) {
            return;
        }
        for (int aIndex = m - 1, bIndex = n - 1, index = m + n - 1; index >= 0; index--) {
            if (bIndex < 0 || (aIndex >= 0 && A[aIndex] > B[bIndex])) {
                A[index] = A[aIndex--];
            } else {
                A[index] = B[bIndex--];
            }
        }
    }
}