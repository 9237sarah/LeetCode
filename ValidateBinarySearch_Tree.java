// https://leetcode.com/problems/validate-binary-search-tree/

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean isValid(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        } else {
            return isValid(root.right, root.val, max) && isValid(root.left, min, root.val);
        }
    }
}