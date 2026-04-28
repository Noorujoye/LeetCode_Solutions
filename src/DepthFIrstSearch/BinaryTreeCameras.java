package DepthFIrstSearch;


public class BinaryTreeCameras {

    // States for each node:
    // 0: The node is not covered. The parent must have a camera.
    // 1: The node is covered, but does not have a camera. The parent does not need one yet.
    // 2: The node has a camera. It covers itself, its parent, and its children.

    private int cameras = 0;

    private int minCamera(TreeNode node) {
        // A null node is considered 'covered' (covered by a hypothetical parent).
        if (node == null) {
            return 1;
        }

        int leftChildState = minCamera(node.left);
        int rightChildState = minCamera(node.right);

        // If either child is not covered (state 0), the current node *must* have a camera
        // to cover its children. We increment the camera count and return state 2.
        if (leftChildState == 0 || rightChildState == 0) {
            cameras++;
            return 2;
        }

        // If either child has a camera (state 2), the current node is covered by that camera.
        // It doesn't need a camera itself and can signal to its parent that it is covered
        // by returning state 1.
        if (leftChildState == 2 || rightChildState == 2) {
            return 1;
        }

        // If both children are covered but don't have cameras (state 1), the current node
        // is not covered yet. It needs to signal to its parent that it requires coverage
        // by returning state 0.
        return 0;
    }
    public int noOfCameras(TreeNode root) {
        // After the DFS, if the root itself is not covered (state 0), we must place a camera there.
        if (minCamera(root) == 0) {
            cameras++;
        }
        return cameras;
    }
    public static void main(String[] args) {
        // Construct the binary tree
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

        BinaryTreeCameras solution = new BinaryTreeCameras();
        int cameraCount = solution.noOfCameras(root);
        System.out.println("no of cameras : " + cameraCount);
    }
}
