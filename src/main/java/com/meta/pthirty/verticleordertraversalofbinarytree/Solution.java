package com.meta.pthirty.verticleordertraversalofbinarytree;
import java.util.*;

public class Solution {
    public List<List<Integer>> verticleTraversal(TreeNode root) {
        // edge case: empty input
        if(root == null)
            throw new IllegalArgumentException("Empty input.");

        Map<Integer,List<Integer>> colToElementMap = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                Pair entry = q.poll();
                TreeNode curr = entry.key();
                int col = entry.col();

                colToElementMap.computeIfAbsent(col, k -> new ArrayList<>()).add(curr.val);

                minCol = Math.min(minCol,col);
                maxCol = Math.max(maxCol,col);

                if(curr.left != null)
                    q.offer(new Pair(curr.left,col-1));
                if(curr.right != null)
                    q.offer(new Pair(curr.right,col+1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=minCol; i<=maxCol; i++){
            result.add(new ArrayList<>(colToElementMap.get(i)));
        }

        return result;
    }

    record Pair(TreeNode key, int col){}
}
