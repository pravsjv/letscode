**Problem Statement:**
You’re building a utility for a shell or file manager that interprets user-provided cd commands and computes the resulting absolute path. You are now given:

A current working directory (cwd) that is already simplified.
A cd command that could be:
    An absolute path (starting with /)
    A relative path (based on cwd)
Implement a method to normalize the result and return the new absolute path.

Example:
Input: cwd = "/home/user/docs", cd = "../photos"
Output: "/home/user/photos"

Input: cwd = "/home/user", cd = "/etc//../var/log"
Output: "/var/log"

Input: cwd = "/", cd = "tmp/"
Output: "/tmp"

Input: cwd = "/a/b/c", cd = "../../../../x"
Output: "/x"

Input: cwd = "/a", cd = "./"
Output: "/a"`



