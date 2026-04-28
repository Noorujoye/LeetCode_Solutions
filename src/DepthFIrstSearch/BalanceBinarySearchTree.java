package DepthFIrstSearch;

import java.util.*;

/**
 * Definition for a binary tree node.
 */

public class BalanceBinarySearchTree {
    // Step 1: Inorder traversal to store sorted values
    private void isTraverse(TreeNode root, List<Integer> inorder) {
        if (root == null) return;

        isTraverse(root.left, inorder);
        inorder.add(root.val);
        isTraverse(root.right, inorder);
    }

    // Step 2: Construct balanced BST from sorted inorder list
    private TreeNode constructBST(List<Integer> inorder, int low, int high) {
        if (low > high) return null;

        int mid = low + (high - low) / 2;

        TreeNode newRoot = new TreeNode(inorder.get(mid));
        newRoot.left = constructBST(inorder, low, mid - 1);
        newRoot.right = constructBST(inorder, mid + 1, high);

        return newRoot;
    }

    // Main logic to balance BST
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;

        List<Integer> inorder = new ArrayList<>();
        isTraverse(root, inorder);

        return constructBST(inorder, 0, inorder.size() - 1);
    }

    // Utility method to print inorder traversal
    private static void printInorder(TreeNode root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // MAIN FUNCTION
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.print("Inorder of Original BST: ");
        printInorder(root);
        System.out.println();

        BalanceBinarySearchTree solution = new BalanceBinarySearchTree();
        TreeNode balancedRoot = solution.balanceBST(root);

        System.out.print("Inorder of Balanced BST: ");
        printInorder(balancedRoot);
        System.out.println();
    }
}
