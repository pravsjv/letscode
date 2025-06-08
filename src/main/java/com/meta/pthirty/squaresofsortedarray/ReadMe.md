**Problem Statement:**
You are working with a logistic company's data analytics team. One of your tasks is to help analyze delivery deviations from their expected delivery times. These deviations(in days) are stored in a sorted array in non-decreasing order. Negative values indicate early deliveries, and positive values indicate late deliveries.
Given sorted list of delivery time deviations(in days), return a new list where each deviation is squared(to reflect magnitude of deviation regardless of early or late), and the resulting values are sorted in non-decreasing order.

Example: 
    Input: arr = {-7,-3,0,2,5}
    Output: {0,4,9,25,49}

**Approaches:**
- Naive approach: Square the elements in the array and then sorted them. TC: O(N logN) N is number of elements in the input.
- Two pointer approach: 
  - Initialize two pointers to traverse the input from front and rear ends and a result array.
  - Traverse the input
    - Square the elements at both front and rear indices
    - copy the largest value among the elements squared to the result array from the rear end
  - return the result array

**Complexities:**
- Time Complexity: O(N) N: number of elements in the input
- Space Complexity: O(N) if result array is considered
