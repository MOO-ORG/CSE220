# Topic 3: Linked Lists
**Question Set: 35 Total Questions**

---

## Part A: Multiple Choice Questions (15 Questions)

### Easy Level (4 Questions)

**MCQ 1 (Easy)**
What is the time complexity of accessing the kth element in a singly linked list?
A) O(1)
B) O(log k)
C) O(k)
D) O(n)

**Answer: C) O(k) - Need to traverse from head to reach kth element**

---

**MCQ 2 (Easy)**
Which component is NOT part of a basic node in a singly linked list?
A) Data field
B) Next pointer
C) Previous pointer
D) Node constructor

**Answer: C) Previous pointer - That's for doubly linked lists**

---

**MCQ 3 (Easy)**
What happens when you try to delete a node from an empty linked list?
A) Creates a new node
B) Returns null
C) Throws an exception or returns error
D) Does nothing

**Answer: C) Throws an exception or returns error**

---

**MCQ 4 (Easy)**
In a singly linked list, what does the last node's next pointer contain?
A) Points to first node
B) Points to itself
C) Contains null
D) Contains garbage value

**Answer: C) Contains null**

---

### Medium Level (4 Questions)

**MCQ 5 (Medium)**
What is the space complexity of reversing a singly linked list iteratively?
A) O(1)
B) O(log n)
C) O(n)
D) O(n²)

**Answer: A) O(1) - Only need constant extra space for pointers**

---

**MCQ 6 (Medium)**
In a circular linked list, how do you detect if you've completed one full traversal?
A) Count nodes
B) Check if next pointer is null
C) Check if current node equals starting node
D) Use a separate flag

**Answer: C) Check if current node equals starting node**

---

**MCQ 7 (Medium)**
What advantage does a dummy head node provide in a linked list implementation?
A) Faster access to elements
B) Simplifies insertion and deletion at beginning
C) Reduces memory usage
D) Improves cache performance

**Answer: B) Simplifies insertion and deletion at beginning**

---

**MCQ 8 (Medium)**
In a doubly linked list, what is the time complexity of deleting a node when you have a reference to that node?
A) O(1)
B) O(log n)
C) O(n)
D) O(n²)

**Answer: A) O(1) - Can directly update prev and next pointers**

---

### Hard Level (4 Questions)

**MCQ 9 (Hard)**
Using Floyd's Cycle Detection Algorithm, if the slow pointer moves 1 step and fast pointer moves 2 steps, what is the maximum number of steps needed to detect a cycle in a linked list of n nodes?
A) n
B) n/2
C) 2n
D) log n

**Answer: A) n - In worst case, slow pointer needs to traverse entire list**

---

**MCQ 10 (Hard)**
In a skip list with n elements, what is the expected time complexity for search operation?
A) O(1)
B) O(log n)
C) O(n)
D) O(sqrt(n))

**Answer: B) O(log n) - Skip list provides logarithmic search time**

---

**MCQ 11 (Hard)**
When merging two sorted linked lists, what is the optimal approach?
A) Convert to arrays, merge, then recreate list
B) Use recursive approach
C) Use iterative approach with dummy head
D) Both B and C are optimal

**Answer: D) Both B and C are optimal - Both have O(m+n) time, O(1) space for iterative**

---

**MCQ 12 (Hard)**
In a memory-constrained environment, which linked list variant is most space-efficient for storing n integers?
A) Singly linked list
B) Doubly linked list
C) Circular linked list
D) XOR linked list

**Answer: D) XOR linked list - Uses XOR of prev and next addresses to save one pointer**

---

### Expert Level (3 Questions)

**MCQ 13 (Expert)**
What is the time complexity of finding the intersection point of two linked lists using the optimal approach?
A) O(m + n) where m, n are lengths of lists
B) O(m * n)
C) O(max(m, n))
D) O(min(m, n))

**Answer: A) O(m + n) - Calculate lengths, then traverse with offset**

---

**MCQ 14 (Expert)**
In a self-organizing linked list using "Move-to-Front" heuristic, what is the amortized time complexity for a sequence of m searches?
A) O(m)
B) O(m log n)
C) O(m * n)
D) O(m + n log n)

**Answer: A) O(m) - Amortized analysis shows linear total cost**

---

**MCQ 15 (Expert)**
For a lock-free linked list implementation in a multi-threaded environment, which technique is most commonly used?
A) Mutex locks
B) Compare-and-swap (CAS) operations
C) Read-write locks
D) Semaphores

**Answer: B) Compare-and-swap (CAS) operations**

---

## Part B: Code Snippet Questions (5 Questions)

### Code Snippet 1
```java
public ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    
    while (current != null) {
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    return prev;
}
```
**Question:** What does this function do and what is its time and space complexity?

**Answer:** Reverses a linked list iteratively. Time complexity: O(n), Space complexity: O(1)

---

### Code Snippet 2
```java
public ListNode findMiddle(ListNode head) {
    if (head == null) return null;
    
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```
**Question:** What does this algorithm find and what happens for even vs odd length lists?

**Answer:** Finds the middle node using two pointers. For odd length: returns exact middle. For even length: returns first of two middle nodes.

---

### Code Snippet 3
```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    
    ListNode slow = head;
    ListNode fast = head.next;
    
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
}
```
**Question:** What algorithm is this and what is its space complexity advantage?

**Answer:** Floyd's Cycle Detection (Tortoise and Hare). Space complexity: O(1) vs O(n) for HashSet approach.

---

### Code Snippet 4
```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    
    for (int i = 1; i <= n + 1; i++) {
        first = first.next;
    }
    
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    
    second.next = second.next.next;
    return dummy.next;
}
```
**Question:** What does this function accomplish and why is the dummy node used?

**Answer:** Removes the nth node from the end in one pass using two pointers. Dummy node simplifies edge case when removing the first node.

---

### Code Snippet 5
```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    
    if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
```
**Question:** What is the space complexity of this recursive merge implementation?

**Answer:** Space complexity: O(m + n) due to recursive call stack, where m and n are lengths of the lists.

---

## Part C: Problem Solving Questions (15 Questions)

### Easy Level (3 Questions)

**Problem 1 (Easy)**
Implement a function to insert a node at the beginning of a singly linked list.

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public ListNode insertAtBeginning(ListNode head, int val) {
    // Your implementation here
}
```

**Hint:** Create new node and make its next pointer point to current head, then return new node as new head.

---

**Problem 2 (Easy)**
Write a function to find the length of a linked list.

```java
public int getLength(ListNode head) {
    // Your implementation here
}
```

**Hint:** Traverse the list while counting nodes until you reach null.

---

**Problem 3 (Easy)**
Implement a function to delete the first occurrence of a value in a linked list.

```java
public ListNode deleteValue(ListNode head, int val) {
    // Your implementation here
}
```

**Hint:** Handle edge case of deleting head node. For other nodes, maintain previous pointer to update links.

---

### Medium Level (3 Questions)

**Problem 4 (Medium)**
Implement a function to detect and return the starting node of a cycle in a linked list.

```java
public ListNode detectCycleStart(ListNode head) {
    // Return the node where cycle begins, or null if no cycle
}
```

**Hint:** First detect cycle with Floyd's algorithm, then find start by moving one pointer to head and advancing both one step at a time.

---

**Problem 5 (Medium)**
Write a function to remove all duplicates from a sorted linked list, keeping only distinct elements.

```java
public ListNode deleteDuplicates(ListNode head) {
    // Remove all nodes that have duplicates
}
```

**Hint:** Use dummy head and three pointers: prev, current, and next. Skip entire groups of duplicates.

---

**Problem 6 (Medium)**
Implement a function to swap nodes in pairs in a linked list.

```java
public ListNode swapPairs(ListNode head) {
    // Swap every two adjacent nodes: 1->2->3->4 becomes 2->1->4->3
}
```

**Hint:** Use dummy node and keep track of previous node. For each pair, update four pointer connections.

---

### Hard Level (5 Questions)

**Problem 7 (Hard)**
Implement a function to reverse nodes in k-group. If remaining nodes < k, leave them as is.

```java
public ListNode reverseKGroup(ListNode head, int k) {
    // Reverse every k consecutive nodes
}
```

**Hint:** First check if k nodes available, then reverse them. Use helper function to reverse a portion of list.

---

**Problem 8 (Hard)**
Design and implement a Least Recently Used (LRU) Cache using linked list and hash map.

```java
public class LRUCache {
    public LRUCache(int capacity) { }
    
    public int get(int key) { }
    
    public void put(int key, int value) { }
}
```

**Hint:** Use doubly linked list for O(1) insertion/deletion and HashMap for O(1) access. Move accessed nodes to head.

---

**Problem 9 (Hard)**
Find the intersection point of two linked lists (if they merge at some point).

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // Return the intersection node, or null if no intersection
}
```

**Hint:** Calculate lengths of both lists, then start traversing from same relative position, or use two pointers switching lists.

---

**Problem 10 (Hard)**
Implement a function to sort a linked list using merge sort.

```java
public ListNode sortList(ListNode head) {
    // Sort the linked list and return new head
}
```

**Hint:** Divide list into halves using slow/fast pointers, recursively sort each half, then merge sorted halves.

---

**Problem 11 (Hard)**
Clone a linked list where each node has a next and a random pointer.

```java
class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) { this.val = val; }
}

public Node copyRandomList(Node head) {
    // Create deep copy of the list
}
```

**Hint:** Three-pass approach: 1) Create copies after each original node, 2) Set random pointers for copies, 3) Separate original and copied lists.

---

### Expert Level (4 Questions)

**Problem 12 (Expert)**
Design a data structure that supports insertion, deletion, and getting random element in O(1) time for a linked list.

```java
public class RandomLinkedList {
    public void insert(int val) { }
    public boolean delete(int val) { }
    public int getRandom() { }
}
```

**Hint:** Combine linked list with ArrayList and HashMap. Keep track of positions and update when elements move.

---

**Problem 13 (Expert)**
Implement a skip list data structure with search, insert, and delete operations.

```java
public class SkipList {
    public SkipList() { }
    
    public boolean search(int target) { }
    public void add(int num) { }
    public boolean erase(int num) { }
}
```

**Hint:** Use multiple levels of linked lists. Randomly promote nodes to higher levels. Start search from top level.

---

**Problem 14 (Expert)**
Design a lock-free linked list for concurrent access using compare-and-swap operations.

```java
public class LockFreeLinkedList<T> {
    public boolean add(T item) { }
    public boolean remove(T item) { }
    public boolean contains(T item) { }
}
```

**Hint:** Use atomic references and mark nodes as deleted before actual removal. Handle ABA problem with versioning.

---

**Problem 15 (Expert)**
Implement a persistent linked list that maintains all previous versions after modifications.

```java
public class PersistentLinkedList {
    public PersistentLinkedList add(int index, int val) { }
    public PersistentLinkedList remove(int index) { }
    public int get(int index, int version) { }
}
```

**Hint:** Use path copying - create new nodes only for changed path. Share unchanged parts between versions. Consider using fat node method.

---

## Summary
This question set comprehensively covers linked list fundamentals, advanced operations, and specialized implementations.

**Key Learning Objectives:**
- Basic linked list operations and traversals
- Advanced pointer manipulation techniques
- Cycle detection and list intersection problems
- Memory-efficient linked list variants
- Concurrent and persistent data structures

**Total Questions: 35**
- MCQ: 15 (Easy: 4, Medium: 4, Hard: 4, Expert: 3)
- Code Snippet: 5 (with solutions)
- Problem Solving: 15 (Easy: 3, Medium: 3, Hard: 5, Expert: 4) - with hints only