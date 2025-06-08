package com.meta.pthirty.squaresofsortedarray;

public class Solution {
    public int[] calcDeviations(int[] deviations){
        // edge case: validate input
        if(deviations == null || deviations.length == 0)
            throw new IllegalArgumentException("Empty input.");

        int left = 0, right = deviations.length-1;
        int[] sortedDeviations = new int[deviations.length];
        int x = deviations.length-1;
        while(left <= right){
            int leftSq = deviations[left]*deviations[left];
            int rightSq = deviations[right]*deviations[right];

            // Place the larger square at the current end of the result array
            if(leftSq > rightSq){
                sortedDeviations[x--] = leftSq;
                left++;
            } else {
                sortedDeviations[x--] = rightSq;
                right--;
            }
        }

        return sortedDeviations;
    }
}
