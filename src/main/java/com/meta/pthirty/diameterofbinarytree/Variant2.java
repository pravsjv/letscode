package com.meta.pthirty.diameterofbinarytree;

import java.util.ArrayList;
import java.util.List;
public class Variant2 {
    private int diameter = 0;
    public int calculateDiameter(Node root){
        // edge case
        if(root == null)
            throw new IllegalArgumentException("Empty input.");

        dfs(root);

        return diameter;
    }

    private int dfs(Node root){
        // base case
        if(root == null)
            return 0;

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(Node neighbor : root.children){
            int childDepth = dfs(neighbor);

            if(firstMax < childDepth){
                secondMax = firstMax;
                firstMax = Math.max(firstMax,childDepth);
            } else if(secondMax < childDepth){
                secondMax = childDepth;
            }

            // update the diameter (edges) if its nodes, add +1
            diameter = Math.max(diameter,firstMax+secondMax);
        }
        return firstMax+1;
    }

    private class Node {
        int val;
        List<Node> children;

        Node(int val){
            this.val = val;
            children = new ArrayList<>();
        }
    }
}
