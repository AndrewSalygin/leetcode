package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode treeNode = treeNodes.pollFirst();
            if (treeNode != null) {
                swapTreeNodeChildren(treeNode);
                if (treeNode.left != null) {
                    treeNodes.push(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodes.push(treeNode.right);
                }
            }
        }
        return root;
    }

    private void swapTreeNodeChildren(TreeNode treeNode) {
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
    }
}
