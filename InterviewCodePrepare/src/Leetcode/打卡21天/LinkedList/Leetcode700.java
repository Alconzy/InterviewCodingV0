package Leetcode.打卡21天.LinkedList;

public class Leetcode700 {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || root.val == val)
                return root;

            if (root.val > val)
                return searchBST(root.left, val);
            else
                return searchBST(root.right, val);
        }
}
