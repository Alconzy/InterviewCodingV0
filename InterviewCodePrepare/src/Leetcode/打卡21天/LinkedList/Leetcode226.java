package Leetcode.打卡21天.LinkedList;

public class Leetcode226 {
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

        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            return root;
        }

        public static void main(String[] args) {

        }
}
