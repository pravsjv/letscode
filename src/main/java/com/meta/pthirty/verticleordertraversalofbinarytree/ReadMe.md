**Problem Statement:**
You're building a feature for a visual layout system in a graphical content editor. The editor allows users to place UI components in a tree-like structure. Each component has a relative position defined in terms of left/right children, similar to a binary tree.
The editor needs to render these components vertically column-by-column — meaning, from the leftmost column to the rightmost. Within the same column:
* Components higher in the tree (i.e., top-down) appear first. 
* If two components are on the same row and column, they are rendered from left to right.

Given the root of a binary tree representing the layout, return a list of lists, where each sublist contains componentIDs(node values) from top to bottom and left to right by column.
Example: 
    `- Input:
            3
           / \
          9   20
              / \
            15   7
    - Output: {{9},{3,15},{20},{7}}`

**Problem Breakdown:**
- Input is root of the binary tree
- Output is the list of elements in each column of tree in a list
- Tree Traversal:
  - BFS : gives us level order
  - DFS : gives us depth of the tree
- Map all the elements to their columns
- Iterate the columns from minCol to maxCol and add them as a list to the result list.

**Approach:**
- Use BFS traversal to traverse the nodes. This helps us to traverse the nodes at each level.
- If we mark root's col as zero, then 
  - all the cols in the left of the tree are reduced by 1
  - all the cols in the right of the tree are increased by 1
- Traverse the tree using BFS approach:
  - Map all the cols to the elements
  - track minCol and maxCol found so far
  - add left and right node pairs with col-1 and col+1 respectively to the queue
- Traverse from minCol to maxCol
  - retrieve the list from the elements mapped to the col and add it to the result
- return result


**Complexities:**
- Time Complexity: O(N) N: number of elements
- Space Complexity: O(N) N: Number of elements, Map and result list