package com.meta.pthirty.diameterofbinarytree;

public class Solution {

    private int diameter = 0;
    public int findDiameter(TreeNode root){
        // edge case
        if(root == null)
            throw new IllegalArgumentException("Empty input.");

        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root) {
        // base case
        if(root == null)
            return 0;
        // compute height of left and right subtrees
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        // update the diameter(we need only edges)
        diameter = Math.max(leftHeight+rightHeight,diameter);

        // explore the tree with larger height/number of edges
        return Math.max(leftHeight,rightHeight)+1;
    }
}
