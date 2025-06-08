**Problem Statement:**
You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.

The rules of a Unix-style file system are as follows:

A single period '.' represents the current directory.
A double period '..' represents the previous/parent directory.
Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
The simplified canonical path should follow these rules:

The path must start with a single slash '/'.
Directories within the path must be separated by exactly one slash '/'.
The path must not end with a slash '/', unless it is the root directory.
The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
Return the simplified canonical path.

**Problem Breakdown:**
- input: absolute path
- output: canonical path
- split the string into directories
- process the absolute path as per problem requirement
- if the processed path is empty return "/"
- create the result if processed path is not empty and return it.

**Approach:**
- Split the path with "/" as directories
- Traverse the directories 
  - add the directories to the stack if its not empty and current directory
  - remove the last pushed element from the stack if its ".." as we need to move to previous directory
  - Edge case: pop the last pushed element only if stack is not empty
- Traverse the stack(remember the directories will be in reverse order in stack)
  - poll Last element from the stack to the String builder and as well append "/" for each directory.
- return the result if it's not empty, otherwise "/"