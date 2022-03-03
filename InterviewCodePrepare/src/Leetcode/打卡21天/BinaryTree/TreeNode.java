package Leetcode.打卡21天.BinaryTree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
