/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
     const result = [];

    function dfs(node) {
        if (node === null) return;

        dfs(node.left);      // LEFT
        result.push(node.val); // ROOT
        dfs(node.right);     // RIGHT
    }

    dfs(root);
    return result;
};