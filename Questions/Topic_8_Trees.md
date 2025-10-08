# Topic 8: Trees
**Question Set: 35 Total Questions**

---

## Part A: Multiple Choice Questions (15 Questions)

### Easy Level (4 Questions)

**MCQ 1 (Easy)**
What is the maximum number of children a node can have in a binary tree?
A) 1
B) 2
C) 3
D) Unlimited

**Answer: B) 2**

---

**MCQ 2 (Easy)**
What is a leaf node in a tree?
A) The root node
B) A node with no children
C) A node with exactly one child
D) A node with two children

**Answer: B) A node with no children**

---

**MCQ 3 (Easy)**
In a binary tree with n nodes, what is the minimum possible height?
A) 1
B) log₂(n)
C) n
D) n-1

**Answer: B) log₂(n) - When tree is complete/balanced**

---

**MCQ 4 (Easy)**
What is the time complexity of searching in a balanced Binary Search Tree?
A) O(1)
B) O(log n)
C) O(n)
D) O(n²)

**Answer: B) O(log n)**

---

### Medium Level (4 Questions)

**MCQ 5 (Medium)**
In an in-order traversal of a Binary Search Tree, in what order are the nodes visited?
A) Random order
B) Ascending order
C) Descending order
D) Level order

**Answer: B) Ascending order**

---

**MCQ 6 (Medium)**
What is the worst-case time complexity for search in an unbalanced BST?
A) O(1)
B) O(log n)
C) O(n)
D) O(n log n)

**Answer: C) O(n) - When BST degenerates into a linked list**

---

**MCQ 7 (Medium)**
In a complete binary tree with n nodes, how many leaf nodes are there approximately?
A) n/4
B) n/2
C) 3n/4
D) n

**Answer: B) n/2 - About half the nodes are leaves**

---

**MCQ 8 (Medium)**
What is the space complexity of recursive in-order traversal?
A) O(1)
B) O(log n) for balanced tree
C) O(n) for skewed tree
D) Both B and C depending on tree structure

**Answer: D) Both B and C depending on tree structure**

---

### Hard Level (4 Questions)

**MCQ 9 (Hard)**
In an AVL tree, what is the maximum difference in heights between left and right subtrees?
A) 0
B) 1
C) 2
D) log n

**Answer: B) 1**

---

**MCQ 10 (Hard)**
What is the time complexity of inserting n elements into an empty BST in sorted order?
A) O(n)
B) O(n log n)
C) O(n²)
D) O(log n)

**Answer: C) O(n²) - Creates a skewed tree**

---

**MCQ 11 (Hard)**
In a Red-Black tree, what is the maximum height in terms of the number of nodes?
A) log₂(n)
B) 2 × log₂(n+1)
C) n
D) n/2

**Answer: B) 2 × log₂(n+1)**

---

**MCQ 12 (Hard)**
What property must be maintained during deletion in a BST?
A) Height balance
B) Color properties
C) Binary search property
D) Complete tree structure

**Answer: C) Binary search property**

---

### Expert Level (3 Questions)

**MCQ 13 (Expert)**
In a B-tree of order m, what is the maximum number of children a node can have?
A) m
B) m-1
C) 2m
D) m+1

**Answer: A) m**

---

**MCQ 14 (Expert)**
What is the amortized time complexity of splay tree operations?
A) O(1)
B) O(log n)
C) O(n)
D) O(n log n)

**Answer: B) O(log n) - Amortized analysis**

---

**MCQ 15 (Expert)**
In a segment tree for range minimum queries, what is the space complexity?
A) O(n)
B) O(2n)
C) O(4n)
D) O(n log n)

**Answer: C) O(4n) - Approximately 4 times the array size**

---

## Part B: Code Snippet Questions (5 Questions)

### Code Snippet 1
```java
public void inorderTraversal(TreeNode root) {
    if (root != null) {
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
}
```
**Question:** What is the output for a BST with values [4, 2, 6, 1, 3, 5, 7]?

**Answer:** 1 2 3 4 5 6 7 - In-order traversal of BST gives sorted order.

---

### Code Snippet 2
```java
public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    
    return Math.max(leftDepth, rightDepth) + 1;
}
```
**Question:** What does this function compute and what is its time complexity?

**Answer:** Computes maximum depth/height of binary tree. Time complexity: O(n), visits each node once.

---

### Code Snippet 3
```java
public TreeNode insertBST(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }
    
    if (val < root.val) {
        root.left = insertBST(root.left, val);
    } else if (val > root.val) {
        root.right = insertBST(root.right, val);
    }
    
    return root;
}
```
**Question:** What happens when trying to insert a duplicate value and what is the space complexity?

**Answer:** Duplicate values are ignored (not inserted). Space complexity: O(h) where h is height due to recursion stack.

---

### Code Snippet 4
```java
public boolean isValidBST(TreeNode root, Integer min, Integer max) {
    if (root == null) return true;
    
    if (min != null && root.val <= min) return false;
    if (max != null && root.val >= max) return false;
    
    return isValidBST(root.left, min, root.val) &&
           isValidBST(root.right, root.val, max);
}
```
**Question:** Why are Integer objects used instead of int for min and max parameters?

**Answer:** Integer allows null values to represent unbounded ranges at root level, whereas int cannot be null.

---

### Code Snippet 5
```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
        return root;
    }
    
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    
    if (left != null && right != null) return root;
    return left != null ? left : right;
}
```
**Question:** What is the time complexity and what does the algorithm assume about p and q?

**Answer:** Time complexity: O(n). Assumes both p and q exist in the tree.

---

## Part C: Problem Solving Questions (15 Questions)

### Easy Level (3 Questions)

**Problem 1 (Easy)**
Implement pre-order traversal of a binary tree (both recursive and iterative).

```java
public List<Integer> preorderTraversal(TreeNode root) {
    // Return list of node values in pre-order
}
```

**Hint:** Recursive: root → left → right. Iterative: Use stack, push right child first, then left child.

---

**Problem 2 (Easy)**
Find the minimum value in a Binary Search Tree.

```java
public int findMin(TreeNode root) {
    // Find minimum value in BST
}
```

**Hint:** In BST, minimum value is always the leftmost node. Keep going left until you reach a leaf.

---

**Problem 3 (Easy)**
Check if two binary trees are identical.

```java
public boolean isSameTree(TreeNode p, TreeNode q) {
    // Check if trees have same structure and values
}
```

**Hint:** Trees are identical if roots have same value and left/right subtrees are identical recursively.

---

### Medium Level (3 Questions)

**Problem 4 (Medium)**
Implement level-order traversal (BFS) of a binary tree.

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    // Return nodes level by level
}
```

**Hint:** Use queue for BFS. Process all nodes at current level before moving to next level.

---

**Problem 5 (Medium)**
Find the diameter of a binary tree (longest path between any two nodes).

```java
public int diameterOfBinaryTree(TreeNode root) {
    // Return length of longest path between any two nodes
}
```

**Hint:** For each node, diameter is either in left subtree, right subtree, or passes through current node (left_height + right_height).

---

**Problem 6 (Medium)**
Convert a sorted array to a balanced Binary Search Tree.

```java
public TreeNode sortedArrayToBST(int[] nums) {
    // Create height-balanced BST from sorted array
}
```

**Hint:** Use divide and conquer. Middle element becomes root, recursively build left and right subtrees.

---

### Hard Level (5 Questions)

**Problem 7 (Hard)**
Serialize and deserialize a binary tree.

```java
public class Codec {
    public String serialize(TreeNode root) {
        // Convert tree to string representation
    }
    
    public TreeNode deserialize(String data) {
        // Reconstruct tree from string
    }
}
```

**Hint:** Use pre-order traversal with null markers. For deserialization, use queue to process tokens.

---

**Problem 8 (Hard)**
Find all root-to-leaf paths that sum to a target value.

```java
public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    // Find all root-to-leaf paths with given sum
}
```

**Hint:** Use backtracking. Add current node to path, recurse on children, remove current node when backtracking.

---

**Problem 9 (Hard)**
Implement an iterator for Binary Search Tree (in-order).

```java
public class BSTIterator {
    public BSTIterator(TreeNode root) { }
    
    public int next() { }
    public boolean hasNext() { }
}
```

**Hint:** Use stack to simulate in-order traversal. Push all left children, pop when needed, then move to right child.

---

**Problem 10 (Hard)**
Find the maximum path sum in a binary tree (path can start and end at any nodes).

```java
public int maxPathSum(TreeNode root) {
    // Find maximum sum path between any two nodes
}
```

**Hint:** For each node, consider paths: through left child, through right child, or through current node connecting both children.

---

**Problem 11 (Hard)**
Construct binary tree from pre-order and in-order traversal arrays.

```java
public TreeNode buildTree(int[] preorder, int[] inorder) {
    // Reconstruct tree from traversal arrays
}
```

**Hint:** First element in preorder is root. Find root in inorder to divide left and right subtrees. Recurse.

---

### Expert Level (4 Questions)

**Problem 12 (Expert)**
Implement an AVL tree with insertion and rotation operations.

```java
public class AVLTree {
    public TreeNode insert(TreeNode root, int key) { }
    private TreeNode rotateLeft(TreeNode node) { }
    private TreeNode rotateRight(TreeNode node) { }
    private int getBalance(TreeNode node) { }
}
```

**Hint:** After each insertion, check balance factor. Perform appropriate rotations (LL, RR, LR, RL) to maintain AVL property.

---

**Problem 13 (Expert)**
Implement a segment tree for range sum queries.

```java
public class SegmentTree {
    public SegmentTree(int[] arr) { }
    
    public int query(int left, int right) { }
    public void update(int index, int value) { }
}
```

**Hint:** Build tree bottom-up. Each internal node stores sum of its range. For queries and updates, recursively navigate tree.

---

**Problem 14 (Expert)**
Design a data structure for range minimum queries with updates.

```java
public class RMQWithUpdates {
    public void update(int index, int value) { }
    public int rangeMinQuery(int left, int right) { }
}
```

**Hint:** Use segment tree or sqrt decomposition. Segment tree gives O(log n) for both operations.

---

**Problem 15 (Expert)**
Implement a persistent Binary Search Tree (functional data structure).

```java
public class PersistentBST {
    public TreeNode insert(TreeNode root, int key) {
        // Return new tree version with key inserted
    }
    
    public TreeNode delete(TreeNode root, int key) {
        // Return new tree version with key deleted
    }
}
```

**Hint:** Use path copying - create new nodes only along path to modified node. Share unchanged parts between versions.

---

## Summary
This question set covers binary trees, Binary Search Trees, balanced trees, and advanced tree data structures.

**Key Learning Objectives:**
- Understanding tree terminology and properties
- Mastering tree traversal algorithms
- Implementing and analyzing Binary Search Trees
- Understanding self-balancing trees (AVL, Red-Black)
- Advanced tree applications and optimizations

**Tree Types Covered:**
- **Binary Trees**: Basic structure and traversals
- **Binary Search Trees**: Search, insertion, deletion operations
- **Balanced Trees**: AVL trees, Red-Black trees
- **Advanced Structures**: B-trees, Segment trees, Tries

**Traversal Algorithms:**
- **Depth-First**: Pre-order, In-order, Post-order
- **Breadth-First**: Level-order traversal
- **Specialized**: Morris traversal, iterative implementations

**Applications and Use Cases:**
- **Expression Trees**: Mathematical expression evaluation
- **File Systems**: Directory structure representation
- **Database Indexing**: B+ trees for efficient queries
- **Range Queries**: Segment trees for interval problems
- **Auto-completion**: Trie data structures

**Performance Analysis:**
- **Balanced vs Unbalanced**: Impact on operation complexities
- **Space-Time Tradeoffs**: Recursive vs iterative approaches
- **Tree Rotations**: Maintaining balance in AVL/Red-Black trees
- **Amortized Analysis**: Self-adjusting trees like Splay trees

**Total Questions: 35**
- MCQ: 15 (Easy: 4, Medium: 4, Hard: 4, Expert: 3)
- Code Snippet: 5 (with solutions)
- Problem Solving: 15 (Easy: 3, Medium: 3, Hard: 5, Expert: 4) - with hints only