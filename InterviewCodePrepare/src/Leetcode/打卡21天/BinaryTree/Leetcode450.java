package Leetcode.打卡21天.BinaryTree;

public class Leetcode450 {
    //写法1
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        if (root.val == key) {
            //case 1, leaf node
            if (root.left == null && root.right == null) {
                root = null;
            }else if (root.right != null) {
                root.val = findSuccessor(root);
                root.right = deleteNode(root.right, root.val);
            }else {
                root.val = findPredecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    /**
    官方题解给的找后继与前驱节点的函数，都是为了找更低层的节点来进行替换。官方的解中：

    如果只有左子树，则沿着左子树去找前驱。之所以不找后继，是因为想要 更低层 的节点来替换；
    同理，如果只有右子树，则只能找后继才能找到 更低层 的节点来替换。
    对于 既有左子树，也有右子树的情况，找前驱或后继来替换都可以，这时前驱后继都是 更低层 的节点，只不过官方将其归为到只有右子树的处理中去了。
    之所以每次要找 更低层 的节点来替换是因为整个过程是从根节点开始往下到叶节点的过程

     */

    //todo 代表的是中序遍历序列的下一个节点。即比当前节点大的最小节点，简称后继节点。
    // 先取当前节点的右节点，然后一直取该节点的左节点，直到左节点为空，则最后指向的节点为后继节点。
    public int findSuccessor(TreeNode root) {
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    //todo 代表的是中序遍历序列的前一个节点。即比当前节点小的最大节点，简称前驱节点。
    // 先取当前节点的左节点，然后取该节点的右节点，直到右节点为空，则最后指向的节点为前驱节点。
    public int findPredecessor(TreeNode root) {
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root.val;
    }


    /**
     * Approach 2, 方法2
     */
    //写法2
//https://github.com/liweiwei1419/LeetCode-Solutions-in-Good-Style/blob/master/11-Binary-Search-Tree/1-Basic/0450-delete-node-in-a-bst/src/Solution.java

    private TreeNode minNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 删除一个二分搜索树中最小的节点，把新的二分搜索树的根返回回去
     * 使用递归，要特别注意，定义的递归函数，返回的是，删除了最小值结点以后的新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            // 就是那个我们要删除的节点
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            // 如果待删除的节点左孩子为空
            if (root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }
            // 如果待删除的节点只有右孩子
            if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }
            // 从它的右子树中拿到最小的
            TreeNode successor = new TreeNode(minNode(root.right).val);
            successor.left = root.left;
            successor.right = removeMin(root.right);
            root.left = null;
            root.right = null;
            return successor;
        }
    }
}

