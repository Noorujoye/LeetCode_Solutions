package DepthFIrstSearch;

public class MinDepth {
    // 1. Pehle hum Tree ke Node ka structure define karenge
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int minDepth(TreeNode root) {
        // Base Case 1: if tree is empty
        if (root == null) return 0;

        // Base Case 2: Agar node ek leaf hai (no children)
        if (root.left == null && root.right == null) return 1;

        // Case A: Agar sirf left child missing hai, toh right side jao
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        // Case B: Agar sirf right child missing hai, toh left side jao
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // Case C: Agar dono children maujood hain, toh dono ka minimum lo
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    static void main(String[] args) {

        /*
           TEST CASE 1 (Normal Tree - Example 1)
                 3
                / \
               9  20
                 /  \
                15   7
           Expected Output: 2 (Shortest path is 3 -> 9)
        */
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println("Test Case 1 Minimum Depth: " + minDepth(root1)); // Output: 2


        /*
           TEST CASE 2 (Skewed/Line Tree - Example 2 - The Trap Case)
             2
              \
               3
                \
                 4
           Expected Output: 3 (Path is 2 -> 3 -> 4)
        */
        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);

        System.out.println("Test Case 2 Minimum Depth: " + minDepth(root2)); // Output: 3
    }
}
