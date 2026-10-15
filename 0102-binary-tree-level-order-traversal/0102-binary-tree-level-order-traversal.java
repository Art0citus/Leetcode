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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case: if the tree is empty, return an empty list
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // Start by pushing the root node onto the queue
        queue.add(root);

        // Process the tree level by level until the queue is empty
        while (!queue.isEmpty()) {
            // The current size of the queue represents the number of elements at this specific level
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();

            // Process all nodes belonging to the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelList.add(currentNode.val);

                // Enqueue the left child if it exists for the next level iteration
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                // Enqueue the right child if it exists for the next level iteration
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // Append the fully constructed level list to our final results list
            result.add(currentLevelList);
        }

        return result;
    }
}