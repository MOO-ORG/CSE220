# Topic 5: Recursion
**Question Set: 35 Total Questions**

---

## Part A: Multiple Choice Questions (15 Questions)

### Easy Level (4 Questions)

**MCQ 1 (Easy)**
What is the base case in recursion?
A) The first recursive call
B) The condition that stops further recursive calls
C) The most complex case
D) The return statement

**Answer: B) The condition that stops further recursive calls**

---

**MCQ 2 (Easy)**
What happens if a recursive function doesn't have a proper base case?
A) It returns null
B) It executes faster
C) It causes infinite recursion (stack overflow)
D) It automatically terminates

**Answer: C) It causes infinite recursion (stack overflow)**

---

**MCQ 3 (Easy)**
In the factorial function factorial(n) = n * factorial(n-1), what is the base case?
A) n = 0 or n = 1 (returns 1)
B) n = 2
C) n > 1
D) n < 0

**Answer: A) n = 0 or n = 1 (returns 1)**

---

**MCQ 4 (Easy)**
What is the space complexity of a simple recursive function that makes n recursive calls?
A) O(1)
B) O(log n)
C) O(n)
D) O(n²)

**Answer: C) O(n) - Due to the call stack**

---

### Medium Level (4 Questions)

**MCQ 5 (Medium)**
What is the time complexity of the naive recursive Fibonacci function?
A) O(n)
B) O(log n)
C) O(n²)
D) O(2^n)

**Answer: D) O(2^n) - Exponential due to repeated subproblems**

---

**MCQ 6 (Medium)**
Which technique can optimize recursive solutions with overlapping subproblems?
A) Tail recursion
B) Memoization
C) Loop unrolling
D) Binary search

**Answer: B) Memoization - Stores results of subproblems**

---

**MCQ 7 (Medium)**
What is tail recursion?
A) Recursion that calls itself multiple times
B) Recursion where the recursive call is the last operation
C) Recursion with no base case
D) Recursion that returns void

**Answer: B) Recursion where the recursive call is the last operation**

---

**MCQ 8 (Medium)**
In the Tower of Hanoi problem with n disks, how many moves are required?
A) n
B) n²
C) 2^n - 1
D) n!

**Answer: C) 2^n - 1**

---

### Hard Level (4 Questions)

**MCQ 9 (Hard)**
What is the time complexity of merge sort, which uses divide-and-conquer recursion?
A) O(n)
B) O(n log n)
C) O(n²)
D) O(2^n)

**Answer: B) O(n log n) - T(n) = 2T(n/2) + O(n)**

---

**MCQ 10 (Hard)**
Which statement about mutual recursion is correct?
A) It's always less efficient than single recursion
B) Two or more functions call each other recursively
C) It cannot have base cases
D) It's equivalent to iteration

**Answer: B) Two or more functions call each other recursively**

---

**MCQ 11 (Hard)**
What is the maximum depth of recursion for binary search on an array of size n?
A) n
B) log n
C) n/2
D) sqrt(n)

**Answer: B) log n - Divides search space by half each time**

---

**MCQ 12 (Hard)**
In dynamic programming, what does "optimal substructure" mean?
A) The problem has overlapping subproblems
B) Optimal solution contains optimal solutions to subproblems
C) The problem can be solved recursively
D) The base case is optimal

**Answer: B) Optimal solution contains optimal solutions to subproblems**

---

### Expert Level (3 Questions)

**MCQ 13 (Expert)**
What is the space complexity of tail-recursive factorial when optimized by the compiler?
A) O(1)
B) O(log n)
C) O(n)
D) O(n²)

**Answer: A) O(1) - Tail call optimization eliminates stack growth**

---

**MCQ 14 (Expert)**
In the Master Theorem, for recurrence T(n) = aT(n/b) + f(n), when is the complexity Θ(n^(log_b(a)))?
A) When f(n) = O(n^(log_b(a)-ε)) for some ε > 0
B) When f(n) = Θ(n^(log_b(a)))
C) When f(n) = Ω(n^(log_b(a)+ε)) for some ε > 0
D) Never

**Answer: A) When f(n) = O(n^(log_b(a)-ε)) for some ε > 0 (Case 1)**

---

**MCQ 15 (Expert)**
What technique is used in CYK algorithm for context-free grammar parsing?
A) Linear recursion
B) Tail recursion
C) Dynamic programming with 3D memoization
D) Mutual recursion

**Answer: C) Dynamic programming with 3D memoization**

---

## Part B: Code Snippet Questions (5 Questions)

### Code Snippet 1
```java
public int mystery(int n) {
    if (n <= 1) return 1;
    return mystery(n-1) + mystery(n-2);
}
```
**Question:** What does this function compute and what is its time complexity?

**Answer:** Computes Fibonacci numbers. Time complexity: O(2^n) - exponential due to repeated calculations.

---

### Code Snippet 2
```java
public void printPattern(int n) {
    if (n <= 0) return;
    System.out.println(n);
    printPattern(n - 1);
    System.out.println(n);
}
```
**Question:** What output does printPattern(3) produce?

**Answer:** Output: 3, 2, 1, 1, 2, 3. It prints numbers in descending order, then ascending order.

---

### Code Snippet 3
```java
public int power(int base, int exp) {
    if (exp == 0) return 1;
    if (exp % 2 == 0) {
        int temp = power(base, exp / 2);
        return temp * temp;
    }
    return base * power(base, exp - 1);
}
```
**Question:** What optimization technique is used here and what is the time complexity?

**Answer:** Uses exponentiation by squaring (fast exponentiation). Time complexity: O(log exp).

---

### Code Snippet 4
```java
public int binarySearch(int[] arr, int target, int left, int right) {
    if (left > right) return -1;
    
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;
    
    if (arr[mid] > target) 
        return binarySearch(arr, target, left, mid - 1);
    return binarySearch(arr, target, mid + 1, right);
}
```
**Question:** What is the space complexity of this recursive binary search?

**Answer:** Space complexity: O(log n) due to recursive call stack depth.

---

### Code Snippet 5
```java
public void hanoi(int n, char from, char to, char aux) {
    if (n == 1) {
        System.out.println("Move disk 1 from " + from + " to " + to);
        return;
    }
    hanoi(n-1, from, aux, to);
    System.out.println("Move disk " + n + " from " + from + " to " + to);
    hanoi(n-1, aux, to, from);
}
```
**Question:** What is the time complexity and how many print statements execute for n disks?

**Answer:** Time complexity: O(2^n). Total moves: 2^n - 1. Each move prints one statement.

---

## Part C: Problem Solving Questions (15 Questions)

### Easy Level (3 Questions)

**Problem 1 (Easy)**
Write a recursive function to calculate the sum of digits in a positive integer.

```java
public int sumOfDigits(int n) {
    // Calculate sum of all digits recursively
}
```

**Hint:** Base case: when n < 10. Recursive case: (n % 10) + sumOfDigits(n / 10).

---

**Problem 2 (Easy)**
Implement recursive function to find the maximum element in an array.

```java
public int findMax(int[] arr, int index) {
    // Find maximum element starting from given index
}
```

**Hint:** Base case: when index is last element. Compare current element with max of remaining array.

---

**Problem 3 (Easy)**
Write a recursive function to check if a string is a palindrome.

```java
public boolean isPalindrome(String str, int start, int end) {
    // Check if substring from start to end is palindrome
}
```

**Hint:** Base case: start >= end. Compare characters at start and end, then recurse on middle part.

---

### Medium Level (3 Questions)

**Problem 4 (Medium)**
Implement recursive solution for generating all permutations of a string.

```java
public List<String> generatePermutations(String str) {
    // Generate all permutations of the given string
}
```

**Hint:** For each character, fix it at current position and generate permutations of remaining characters.

---

**Problem 5 (Medium)**
Write a recursive function to solve the "Valid Parentheses" problem.

```java
public boolean isValidParentheses(String s, int index, int count) {
    // Check if parentheses are balanced using recursion
}
```

**Hint:** Track count of open parentheses. Increment for '(', decrement for ')'. Return false if count goes negative.

---

**Problem 6 (Medium)**
Implement recursive solution for the "Coin Change" problem (minimum coins).

```java
public int coinChange(int[] coins, int amount) {
    // Find minimum number of coins needed to make the amount
}
```

**Hint:** For each coin, try using it and recurse on remaining amount. Take minimum across all choices. Add memoization.

---

### Hard Level (5 Questions)

**Problem 7 (Hard)**
Solve the N-Queens problem using backtracking recursion.

```java
public List<List<String>> solveNQueens(int n) {
    // Place n queens on n×n chessboard such that no two attack each other
}
```

**Hint:** Try placing queens row by row. For each row, try each column and check if placement is safe.

---

**Problem 8 (Hard)**
Implement recursive solution for "Generate Parentheses" problem.

```java
public List<String> generateParenthesis(int n) {
    // Generate all combinations of n pairs of valid parentheses
}
```

**Hint:** Track count of open and close parentheses. Add '(' if open < n, add ')' if close < open.

---

**Problem 9 (Hard)**
Write recursive function to find all paths from top-left to bottom-right in a matrix.

```java
public List<List<Integer>> findAllPaths(int[][] matrix) {
    // Find all paths from (0,0) to (m-1,n-1) moving only right or down
}
```

**Hint:** At each cell, try going right and down. Backtrack by removing current cell from path.

---

**Problem 10 (Hard)**
Implement recursive solution for "Word Search" in a 2D grid.

```java
public boolean wordSearch(char[][] board, String word) {
    // Find if word exists in the board by connecting adjacent cells
}
```

**Hint:** Try starting from each cell. Use DFS with backtracking, marking visited cells temporarily.

---

**Problem 11 (Hard)**
Solve the "Sudoku Solver" using recursive backtracking.

```java
public void solveSudoku(char[][] board) {
    // Fill the 9×9 Sudoku puzzle following the rules
}
```

**Hint:** Find empty cell, try digits 1-9. For each valid digit, place it and recurse. Backtrack if no solution.

---

### Expert Level (4 Questions)

**Problem 12 (Expert)**
Implement recursive solution for "Regular Expression Matching" with '.' and '*'.

```java
public boolean isMatch(String s, String p) {
    // Match string s against pattern p (. matches any char, * matches zero or more)
}
```

**Hint:** Handle cases: exact match, '.', and '*' with preceding character. Use memoization for optimization.

---

**Problem 13 (Expert)**
Design recursive algorithm for "Optimal Binary Search Tree" construction.

```java
public TreeNode optimalBST(int[] keys, int[] freq) {
    // Construct BST with minimum expected search cost
}
```

**Hint:** Use dynamic programming. For each subarray, try each key as root and minimize total cost.

---

**Problem 14 (Expert)**
Implement recursive solution for "Edit Distance" (Levenshtein distance).

```java
public int editDistance(String word1, String word2) {
    // Find minimum operations to convert word1 to word2 (insert, delete, replace)
}
```

**Hint:** If characters match, recurse on remaining. Otherwise, try all three operations and take minimum.

---

**Problem 15 (Expert)**
Solve "Longest Common Subsequence" using recursive approach with memoization.

```java
public int longestCommonSubsequence(String text1, String text2) {
    // Find length of longest common subsequence
}
```

**Hint:** If characters match, include both and recurse. Otherwise, try skipping each character and take maximum.

---

## Summary
This question set covers fundamental recursion concepts, advanced recursive algorithms, and optimization techniques.

**Key Learning Objectives:**
- Understanding base cases and recursive relationships
- Analyzing time and space complexity of recursive solutions
- Backtracking and dynamic programming techniques
- Divide-and-conquer algorithms
- Recursive data structure operations

**Key Algorithm Patterns:**
- **Linear Recursion**: Single recursive call (factorial, sum)
- **Binary Recursion**: Two recursive calls (Fibonacci, tree traversals)
- **Mutual Recursion**: Functions calling each other
- **Tail Recursion**: Optimizable recursive calls
- **Backtracking**: Exploring all possibilities with rollback
- **Memoization**: Caching results to avoid recomputation

**Total Questions: 35**
- MCQ: 15 (Easy: 4, Medium: 4, Hard: 4, Expert: 3)
- Code Snippet: 5 (with solutions)
- Problem Solving: 15 (Easy: 3, Medium: 3, Hard: 5, Expert: 4) - with hints only