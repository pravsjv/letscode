package com.meta.pthirty.randompickwithweight;

public class Solution {
    private int[] weights;
    private int totalWeight;
    private int[] prefix_weights;
    public Solution(int[] weights){
        this.totalWeight = 0;
        this.prefix_weights = new int[weights.length];
        this.weights = weights;

        for(int i=0; i<weights.length; i++){
            totalWeight += weights[i];
            prefix_weights[i] = totalWeight;
        }
    }

    public int pickIndex(){
        double target = Math.random()*totalWeight;
        int left = 0;
        int right = weights.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(prefix_weights[mid] < target){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
