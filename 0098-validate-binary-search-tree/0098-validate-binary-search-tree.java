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
    public boolean isValidBST(TreeNode root) {
         // Use Long.MIN_VALUE and Long.MAX_VALUE to comfortably cover Integer bounds
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        // An empty tree/node is a valid BST
        if (node == null) {
            return true;
        }

        // Current node's value must be strictly greater than the lower bound (if it exists)
        if (low != null && node.val <= low) {
            return false;
        }

        // Current node's value must be strictly less than the upper bound (if it exists)
        if (high != null && node.val >= high) {
            return false;
        }

        // Recursively validate left and right subtrees with updated bounds:
        // Left child must be less than the current node's value (node.val becomes high)
        // Right child must be greater than the current node's value (node.val becomes low)
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}