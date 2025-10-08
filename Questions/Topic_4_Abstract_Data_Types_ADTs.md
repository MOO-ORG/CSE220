# Topic 4: Abstract Data Types (ADTs) - Stacks and Queues
**Question Set: 35 Total Questions**

---

## Part A: Multiple Choice Questions (15 Questions)

### Easy Level (4 Questions)

**MCQ 1 (Easy)**
What principle does a stack follow?
A) First In First Out (FIFO)
B) Last In First Out (LIFO)
C) Random Access
D) Priority Based

**Answer: B) Last In First Out (LIFO)**

---

**MCQ 2 (Easy)**
Which operation is NOT typically supported by a basic stack?
A) push()
B) pop()
C) peek() or top()
D) get(index)

**Answer: D) get(index) - Stacks don't support random access**

---

**MCQ 3 (Easy)**
What happens when you try to pop from an empty stack?
A) Returns null
B) Returns 0
C) Throws StackUnderflowException
D) Creates a new element

**Answer: C) Throws StackUnderflowException**

---

**MCQ 4 (Easy)**
In a queue, where are elements added and removed?
A) Both at the front
B) Both at the rear
C) Added at rear, removed from front
D) Added at front, removed from rear

**Answer: C) Added at rear, removed from front**

---

### Medium Level (4 Questions)

**MCQ 5 (Medium)**
What is the time complexity of push and pop operations in a stack implemented using arrays?
A) O(1) for both
B) O(n) for both
C) O(1) for push, O(n) for pop
D) O(n) for push, O(1) for pop

**Answer: A) O(1) for both**

---

**MCQ 6 (Medium)**
In a circular queue implementation with array size n, which condition indicates the queue is full?
A) rear == front
B) (rear + 1) % n == front
C) rear - front == n
D) front == -1

**Answer: B) (rear + 1) % n == front**

---

**MCQ 7 (Medium)**
What is the main advantage of implementing a stack using linked lists over arrays?
A) Faster access time
B) Better memory locality
C) Dynamic size (no overflow)
D) Less memory usage per element

**Answer: C) Dynamic size (no overflow)**

---

**MCQ 8 (Medium)**
Which data structure is best suited for implementing function call management in programming languages?
A) Queue
B) Stack
C) Priority Queue
D) Circular Buffer

**Answer: B) Stack - Function calls follow LIFO for recursive calls and return addresses**

---

### Hard Level (4 Questions)

**MCQ 9 (Hard)**
In the "Valid Parentheses" problem, what is the time complexity of the stack-based solution?
A) O(1)
B) O(log n)
C) O(n)
D) O(n²)

**Answer: C) O(n) - Need to scan through all characters once**

---

**MCQ 10 (Hard)**
For implementing a queue using two stacks, what is the amortized time complexity of dequeue operation?
A) O(1)
B) O(log n)
C) O(n)
D) O(n²)

**Answer: A) O(1) - Amortized analysis shows each element is moved at most twice**

---

**MCQ 11 (Hard)**
Which application does NOT typically use a queue data structure?
A) CPU task scheduling
B) Breadth-First Search (BFS)
C) Undo operation in text editors
D) Print job management

**Answer: C) Undo operation in text editors - This uses a stack**

---

**MCQ 12 (Hard)**
In a priority queue implemented as a binary heap, what is the time complexity of extracting the minimum element?
A) O(1)
B) O(log n)
C) O(n)
D) O(n log n)

**Answer: B) O(log n) - Need to heapify after removing root**

---

### Expert Level (3 Questions)

**MCQ 13 (Expert)**
What is the space complexity of implementing a queue using a single stack and recursion?
A) O(1)
B) O(log n)
C) O(n)
D) O(n²)

**Answer: C) O(n) - Recursion stack can grow up to n elements**

---

**MCQ 14 (Expert)**
In a monotonic stack used for finding next greater elements, what is the total time complexity for processing an array of n elements?
A) O(n)
B) O(n log n)
C) O(n²)
D) O(2^n)

**Answer: A) O(n) - Each element is pushed and popped at most once**

---

**MCQ 15 (Expert)**
For a double-ended queue (deque) implemented with a circular buffer, what is the time complexity of adding/removing elements at both ends?
A) O(1) at one end, O(n) at other
B) O(1) at both ends
C) O(log n) at both ends
D) O(n) at both ends

**Answer: B) O(1) at both ends**

---

## Part B: Code Snippet Questions (5 Questions)

### Code Snippet 1
```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if ((c == ')' && top != '(') ||
                (c == ']' && top != '[') ||
                (c == '}' && top != '{')) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}
```
**Question:** What problem does this solve and what is its time complexity?

**Answer:** Validates balanced parentheses using stack. Time complexity: O(n), Space complexity: O(n) in worst case.

---

### Code Snippet 2
```java
public class QueueUsingStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    public void enqueue(int x) {
        s1.push(x);
    }
    
    public int dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
```
**Question:** How does this implement a queue and what are the time complexities?

**Answer:** Uses two stacks to simulate queue. Enqueue: O(1), Dequeue: O(1) amortized, O(n) worst case.

---

### Code Snippet 3
```java
public int[] nextGreaterElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() <= nums[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(nums[i]);
    }
    return result;
}
```
**Question:** What does this algorithm compute and what type of stack is used?

**Answer:** Finds next greater element for each position using a monotonic decreasing stack. Time: O(n), Space: O(n).

---

### Code Snippet 4
```java
public class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;
    
    public boolean enqueue(int value) {
        if (size == capacity) return false;
        queue[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }
    
    public int dequeue() {
        if (size == 0) return -1;
        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }
}
```
**Question:** Why is a separate size variable used instead of checking (rear + 1) % capacity == front?

**Answer:** To distinguish between empty and full queue states. Without size, both empty and full would have the same front/rear relationship.

---

### Code Snippet 5
```java
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
```
**Question:** What is the space complexity and why use <= instead of < when comparing with minStack?

**Answer:** Space complexity: O(n) worst case. Use <= to handle duplicate minimum values correctly.

---

## Part C: Problem Solving Questions (15 Questions)

### Easy Level (3 Questions)

**Problem 1 (Easy)**
Implement a stack using an array with basic operations.

```java
public class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;
    
    public ArrayStack(int size) { }
    
    public void push(int item) { }
    public int pop() { }
    public int peek() { }
    public boolean isEmpty() { }
    public boolean isFull() { }
}
```

**Hint:** Use top as index of last inserted element. Check bounds for overflow/underflow conditions.

---

**Problem 2 (Easy)**
Implement a simple queue using an array with circular buffer approach.

```java
public class ArrayQueue {
    private int[] queue;
    private int front, rear, size, capacity;
    
    public ArrayQueue(int size) { }
    
    public void enqueue(int item) { }
    public int dequeue() { }
    public boolean isEmpty() { }
    public boolean isFull() { }
}
```

**Hint:** Use modulo arithmetic for circular indexing. Track size separately to distinguish empty from full.

---

**Problem 3 (Easy)**
Write a function to reverse a string using a stack.

```java
public String reverseString(String str) {
    // Use stack to reverse the input string
}
```

**Hint:** Push all characters onto stack, then pop them to build reversed string.

---

### Medium Level (3 Questions)

**Problem 4 (Medium)**
Design a stack that supports getMin() operation in O(1) time.

```java
public class MinStack {
    public void push(int x) { }
    public void pop() { }
    public int top() { }
    public int getMin() { }
}
```

**Hint:** Use auxiliary stack to keep track of minimum values, or encode min with each element.

---

**Problem 5 (Medium)**
Implement a queue using a single stack and recursion.

```java
public class QueueUsingSingleStack {
    public void enqueue(int x) { }
    public int dequeue() { }
}
```

**Hint:** Use recursion to reverse the order. For dequeue, recursively remove all elements, save the bottom one, then restore.

---

**Problem 6 (Medium)**
Evaluate a postfix expression using a stack.

```java
public int evaluatePostfix(String expression) {
    // Evaluate postfix notation: "2 3 + 4 *" = 20
}
```

**Hint:** Push operands onto stack. When encountering operator, pop two operands, compute, and push result back.

---

### Hard Level (5 Questions)

**Problem 7 (Hard)**
Find the largest rectangular area in a histogram using stack.

```java
public int largestRectangleArea(int[] heights) {
    // Find maximum area of rectangle that can be formed
}
```

**Hint:** Use monotonic increasing stack. For each bar, calculate area when this bar is the shortest in the rectangle.

---

**Problem 8 (Hard)**
Design a data structure that supports push, pop, and getMax operations in O(1) time.

```java
public class MaxStack {
    public void push(int x) { }
    public int pop() { }
    public int top() { }
    public int peekMax() { }
    public int popMax() { }
}
```

**Hint:** Use two stacks or combine stack with doubly linked list and TreeMap for efficient max operations.

---

**Problem 9 (Hard)**
Implement a sliding window maximum using deque.

```java
public int[] maxSlidingWindow(int[] nums, int k) {
    // Return array of maximum elements in each window of size k
}
```

**Hint:** Use deque to maintain indices in decreasing order of their values. Remove elements outside current window.

---

**Problem 10 (Hard)**
Design a stack that supports increment operation on bottom k elements.

```java
public class CustomStack {
    public CustomStack(int maxSize) { }
    
    public void push(int x) { }
    public int pop() { }
    public void increment(int k, int val) { }
}
```

**Hint:** Use lazy propagation - store increments separately and apply them only when needed (during pop).

---

**Problem 11 (Hard)**
Implement basic calculator that handles +, -, *, / and parentheses.

```java
public int calculate(String s) {
    // Calculate: "2-1 + 2" = 3, "2*(5+5*2)/3+(6/2+8)" = 21
}
```

**Hint:** Use stack to handle operator precedence and parentheses. Process operators based on precedence rules.

---

### Expert Level (4 Questions)

**Problem 12 (Expert)**
Design a double-ended queue (deque) that supports insertion and deletion at both ends in O(1).

```java
public class Deque<T> {
    public void addFirst(T item) { }
    public void addLast(T item) { }
    public T removeFirst() { }
    public T removeLast() { }
    public boolean isEmpty() { }
    public int size() { }
}
```

**Hint:** Use circular buffer with front and rear pointers, or doubly linked list for dynamic sizing.

---

**Problem 13 (Expert)**
Implement a stack with O(1) push, pop, and findMiddle operations.

```java
public class MiddleStack {
    public void push(int x) { }
    public int pop() { }
    public int findMiddle() { }
    public void deleteMiddle() { }
}
```

**Hint:** Use doubly linked list with a middle pointer. Update middle pointer based on size changes.

---

**Problem 14 (Expert)**
Design a data structure for range minimum queries on a stack.

```java
public class RMQStack {
    public void push(int x) { }
    public int pop() { }
    public int rangeMin(int start, int end) { }
    // start and end are positions from bottom of stack
}
```

**Hint:** Combine stack with segment tree or use auxiliary data structure to precompute range minimums.

---

**Problem 15 (Expert)**
Implement a lock-free stack for concurrent access using compare-and-swap.

```java
public class LockFreeStack<T> {
    public void push(T item) { }
    public T pop() { }
    public boolean isEmpty() { }
}
```

**Hint:** Use atomic reference for top node. Handle ABA problem with version numbers or hazard pointers for memory management.

---

## Summary
This question set covers fundamental stack and queue operations, advanced implementations, and real-world applications.

**Key Learning Objectives:**
- Understanding LIFO and FIFO principles
- Array vs linked list implementations
- Applications in expression evaluation and parsing
- Advanced data structures like deque and priority queue
- Concurrent programming with stacks and queues

**Total Questions: 35**
- MCQ: 15 (Easy: 4, Medium: 4, Hard: 4, Expert: 3)
- Code Snippet: 5 (with solutions)
- Problem Solving: 15 (Easy: 3, Medium: 3, Hard: 5, Expert: 4) - with hints only