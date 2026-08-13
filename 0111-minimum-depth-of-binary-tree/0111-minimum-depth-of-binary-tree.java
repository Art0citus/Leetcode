/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // Find the depth of left and right subtrees
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        
        // If left child is missing, path must go through the right child
        if (root.left == null) {
            return rightDepth + 1;
        }
        
        // If right child is missing, path must go through the left child
        if (root.right == null) {
            return leftDepth + 1;
        }
        
        // If both children exist, take the shorter path
        return Math.min(leftDepth, rightDepth) + 1;
    }
}