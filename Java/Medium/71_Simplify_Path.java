/*
Problem: Simplify Path
Problem No: 71
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Stack
- String Processing
- Deque

----------------------------------
Problem Statement:
----------------------------------
You are given an absolute Unix-style file path.
Simplify it to its canonical form by applying these rules:

- "." refers to the current directory
- ".." refers to the parent directory
- Multiple slashes are treated as a single slash
- Other dot sequences like "..." are valid directory names
- The result must:
  * Start with '/'
  * Have no trailing slash (unless root)
  * Contain no "." or ".."

----------------------------------
Approach / Explanation:
----------------------------------
1. Split the path using '/'.
2. Use a stack (Deque) to process directory names.
3. For each part:
   - Ignore empty strings and "."
   - Pop from stack for ".." if possible
   - Push valid directory names
4. Build the final path from stack.
5. If stack is empty, return "/".

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n)
Space Complexity: O(n)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/");

        for (String p : parts) {
            if (p.equals("") || p.equals(".")) {
                continue;
            } 
            else if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } 
            else {
                stack.push(p);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.insert(0, "/" + dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
