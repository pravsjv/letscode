**Problem Statement(Leetcode 528)**
Given a zero indexed array of positive integers w where w[i] describes the weight of the ith index, implement a method pickIndex(), which randomly picks an index in the range [0,w.length-1](inclusive) and returns it. The probability of picking an index i is w[i]/sum(w).
Example: 
    Input: w = [1, 3]
    Output:
    pickIndex() returns:
        - Index 0 with probability 1 / (1 + 3) = 0.25 (25%)
        - Index 1 with probability 3 / (1 + 3) = 0.75 (75%)


**Problem Breakdown**
- Input : arr of integers w (weights)
- Implementation: pickIndex() 
- Output: return a random index based on probability of w[i]/total_Weight
- Subproblems:
  - Simulate Weighted Randomness
  - Generate a random weight
  - Map Index to the random weight

**Approach:**
- Simulate Weighted Randomness:
  - As per problem statement, the probability of picking random index depends on the weight and sum of the weights. 
  - To simulate weighted randomness, if we place the weights on number line. For example, 
    ```text
    weights = [1, 3, 2], compute prefix sums
    prefixSum = [1, 4, 6]
    Index 0 → (0, 1]  → weight 1
    Index 1 → (1, 4]  → weight 3
    Index 2 → (4, 6]  → weight 2
  - Hence, precompute the total Weight and prefix sum of weights. 
  - output: totalWeight;prefix_weights[]
- Genarate Random Index:
  - Random function to generate a random values from the total Weight : Math.random()*totalWeight : double target
  - Find the smallest index i such that prefix_weights[i]<target.
    - Linear Search: scan prefix_weights linearly to check if the target falls in that range. TC:O(N)
    - Binary Search: perform a binary Search to fiin prefixWeights for the target. TC: O(log N)

**Complexities**
- Time Complexity:
  - constructor : O(N) to build prefix sum weights and total weight
  - pickIndex() : O(N) if Linear Search; O(log N) for Binary Search
- Space Complexity:
  - O(N) store the prefix sum array