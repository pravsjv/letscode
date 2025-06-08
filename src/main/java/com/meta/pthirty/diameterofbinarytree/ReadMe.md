**Problem Statement:**
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
The length of a path between two nodes in represented by the number of edges between them.

Example: 
    Input: root = {1,2,3,4,5} output : 3

**Problem Breakdown:**
- We need the large number of edges. 
- input: root of the tree
- output: largest number of edges
- Key Insight:
  - find largest number of edges between two leaf nodes.

**Approach:**
- Tree problem. So we have two traversals:
    - BFS : Traverses the tree at each level
    - DFS : Traverses the tree till the depth 
- Maximum number of edges should be between two leaf nodes
- The maximum number of edges may or may not pass through the root. 
- DFS will be an intuitive for this problem for the following reasons:
  - We need to calculate height of left and right subtrees at each node.
  - The longest path through a node is leftHeight + rightHeight (in edges).
  - Update a global diameter variable if this is greater than the current maximum.

**Algorithm:**
- Use a recursive function dfs(node) that returns the height of the current node.
- At each node, compute:
  - left = dfs(root.left)
  - right = dfs(root.right)
  - update the diameter
  - explore the tree with max height

**Complexities:**
- Time Complexity:
  - O(N) where N is the number of nodes. Worst case happens if it's a skewed tree
- Space Complexity:
  - O(N) where N is the number of nodes. Worst case happens if it's a skewed tree.

**Variant1 Notes:**
    - While finding diameter of binary tree(edges version), the diameter is updated as Math.max(diameter,leftHeigh+rightheight);
    - For this variant1, if diameter is the number of nodes, we update the diameter as Math.max(diameter, leftHeight+rightHeight+1);