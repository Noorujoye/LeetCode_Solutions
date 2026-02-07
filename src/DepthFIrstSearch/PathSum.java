package DepthFIrstSearch;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {

        // if root is null means no path , return false
        if (root == null) return false;

        // if we reaches leaf node , no left , no right ,
        // then if leaf node == target sum , then return true , else false
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int remaining = targetSum - root.val;

        return hasPathSum(root.left, remaining) ||
                hasPathSum(root.right, remaining);
    }
    public static void main (String[]args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        PathSum sum = new PathSum();
        boolean ans = hasPathSum(root , 20);
        System.out.println(ans);
    }
}
