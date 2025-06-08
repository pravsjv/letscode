package com.meta.pthirty.diameterofbinarytree;

public class Variant1 {
    private int diameter = 0;
    public int findDiameter(TreeNode root){
        // edge case
        if(root == null)
            return 0;

        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root){
        // base case
        if(root == null)
            return 0;

        // compute height of left and right subtrees
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        // update the diameter (we need to return nodes)
        diameter = Math.max(diameter,leftHeight+rightHeight+1);

        // explore the tree that has larger height
        return Math.max(leftHeight,rightHeight)+1;
    }
}
