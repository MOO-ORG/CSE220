# 📚 STACKS - COMPLETE LEARNING GUIDE

## 📋 TABLE OF CONTENTS
1. [Foundation Building](#-foundation-building)
2. [Theory Section](#-theory-section)
3. [Code Implementation](#-code-implementation)
4. [Practical Exercises](#-practical-exercises)
5. [Deep Dive Analysis](#-deep-dive-analysis)
6. [Real-World Applications](#-real-world-applications)
7. [Summary Cheat Sheet](#-summary-cheat-sheet)

---

## 📚 FOUNDATION BUILDING

### 🤔 What is a Stack?
Imagine a **stack of plates** 🍽️ in a cafeteria. You can only:
- Add a new plate on TOP
- Remove a plate from the TOP
- See what's on the TOP plate

You CAN'T pull a plate from the middle or bottom without removing all the plates above it first!

A **Stack** in programming works exactly like this. It's a **linear data structure** that follows the **LIFO principle**:
- **LIFO = Last In, First Out**
- The last element you put in is the first one you take out

### 🎯 Why Do Stacks Exist?

**Real-Life Problem:** Imagine you're reading a book and come across a reference to another chapter. You bookmark your current page, go to that chapter, find another reference, bookmark again, and so on. When you're done with each reference, you return to your most recent bookmark. This is exactly how stacks work!

**Programming Problems Stacks Solve:**
- ✅ **Function calls** - keeping track of which function called which
- ✅ **Undo operations** - remembering the last action to reverse
- ✅ **Expression evaluation** - handling parentheses and operators
- ✅ **Browser history** - back button functionality
- ✅ **Recursive algorithms** - storing intermediate results

### 🏠 Real-World Analogies

1. **Stack of Books** 📚
   - Add book on top (PUSH)
   - Remove book from top (POP)
   - Look at top book (PEEK/TOP)

2. **Tennis Ball Container** 🎾
   - Balls go in and come out from the same end
   - Can only access the topmost ball

3. **Browser Back Button** 🔙
   - Each page visit is "pushed" onto history
   - Back button "pops" the last page

### 📖 Key Terms Defined
- **Stack**: A LIFO data structure
- **Push**: Adding an element to the top
- **Pop**: Removing the top element
- **Peek/Top**: Looking at the top element without removing it
- **Empty/Underflow**: Stack has no elements
- **Full/Overflow**: Stack can't accept more elements (for fixed-size stacks)

---

## 🏗️ THEORY SECTION

### 📖 Basic Stack Operations

```
    TOP
     ↓
[   30   ] ← Most recently added
[   20   ]
[   10   ] ← First element added
[_______] ← Bottom
```

**Core Operations:**
1. **PUSH(x)** - Add element x to top
2. **POP()** - Remove and return top element
3. **PEEK/TOP()** - Return top element without removing
4. **ISEMPTY()** - Check if stack is empty
5. **SIZE()** - Get number of elements

### 🔄 Step-by-Step Example

**Starting with empty stack:**
```
Stack: [ ] (empty)
```

**PUSH(10):**
```
Stack: [10]
       ↑ top
```

**PUSH(20):**
```
Stack: [10, 20]
            ↑ top
```

**PUSH(30):**
```
Stack: [10, 20, 30]
                ↑ top
```

**POP():** (returns 30)
```
Stack: [10, 20]
            ↑ top
```

**PEEK():** (returns 20, doesn't remove)
```
Stack: [10, 20]  ← 20 is still there
            ↑ top
```

### 🏗️ Two Implementation Approaches

#### 1. **Array-Based Stack**
```
[10][20][30][ ][ ][ ]  ← Fixed size array
              ↑ top index = 2
```
**Pros:** Fast operations, less memory per element
**Cons:** Fixed size, potential overflow

#### 2. **Linked List-Based Stack**
```
[30|•] → [20|•] → [10|NULL]
 ↑ head (top of stack)
```
**Pros:** Dynamic size, no overflow
**Cons:** Extra memory for pointers

### ⚠️ Common Misconceptions

1. **"You can access elements in the middle"** - FALSE! Only top element is accessible
2. **"Pop returns the index"** - FALSE! Pop returns the actual element value
3. **"Stacks are always small"** - FALSE! They can grow very large (like call stacks)
4. **"Array implementation is always better"** - FALSE! Depends on your needs

---

## 💻 CODE IMPLEMENTATION

### 🏗️ Implementation 1: Array-Based Stack

```java
public class ArrayStack {
    private int[] stack;      // Array to store elements
    private int top;          // Index of top element
    private int maxSize;      // Maximum capacity
    
    // Constructor - creates empty stack with given capacity
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.top = -1;  // -1 indicates empty stack
        System.out.println("Created array stack with capacity: " + maxSize);
    }
    
    // 1. PUSH - Add element to top - O(1)
    public boolean push(int element) {
        // Check for overflow
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + element);
            return false;
        }
        
        // Increment top and add element
        top++;
        stack[top] = element;
        System.out.println("Pushed: " + element);
        return true;
    }
    
    // 2. POP - Remove and return top element - O(1)
    public int pop() {
        // Check for underflow
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop from empty stack");
            return -1; // or throw exception
        }
        
        // Get top element and decrement top
        int poppedElement = stack[top];
        top--;
        System.out.println("Popped: " + poppedElement);
        return poppedElement;
    }
    
    // 3. PEEK - Return top element without removing - O(1)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek");
            return -1;
        }
        
        System.out.println("Top element: " + stack[top]);
        return stack[top];
    }
    
    // 4. CHECK IF EMPTY - O(1)
    public boolean isEmpty() {
        return top == -1;
    }
    
    // 5. CHECK IF FULL - O(1)
    public boolean isFull() {
        return top == maxSize - 1;
    }
    
    // 6. GET SIZE - O(1)
    public int size() {
        return top + 1;
    }
    
    // 7. DISPLAY STACK - O(n)
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        
        System.out.print("Stack (bottom to top): ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i]);
            if (i < top) System.out.print(" -> ");
        }
        System.out.println(" <- TOP");
    }
    
    // 8. CLEAR STACK - O(1)
    public void clear() {
        top = -1;
        System.out.println("Stack cleared!");
    }
}
```

### 🔗 Implementation 2: Linked List-Based Stack

```java
// Node class for linked list implementation
class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedStack {
    private Node top;    // Reference to top node
    private int size;    // Keep track of size
    
    // Constructor - creates empty stack
    public LinkedStack() {
        this.top = null;
        this.size = 0;
        System.out.println("Created linked list stack");
    }
    
    // 1. PUSH - Add element to top - O(1)
    public void push(int element) {
        Node newNode = new Node(element);
        
        // Point new node to current top
        newNode.next = top;
        
        // Update top to new node
        top = newNode;
        size++;
        
        System.out.println("Pushed: " + element);
    }
    
    // 2. POP - Remove and return top element - O(1)
    public int pop() {
        // Check for underflow
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop from empty stack");
            return -1;
        }
        
        // Get data from top node
        int poppedElement = top.data;
        
        // Move top to next node
        top = top.next;
        size--;
        
        System.out.println("Popped: " + poppedElement);
        return poppedElement;
    }
    
    // 3. PEEK - Return top element without removing - O(1)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek");
            return -1;
        }
        
        System.out.println("Top element: " + top.data);
        return top.data;
    }
    
    // 4. CHECK IF EMPTY - O(1)
    public boolean isEmpty() {
        return top == null;
    }
    
    // 5. GET SIZE - O(1)
    public int size() {
        return size;
    }
    
    // 6. DISPLAY STACK - O(n)
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        
        System.out.print("Stack (top to bottom): ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    // 7. CLEAR STACK - O(1)
    public void clear() {
        top = null;
        size = 0;
        System.out.println("Stack cleared!");
    }
}
```

### 🚀 Example Usage and Testing

```java
public class StackDemo {
    public static void main(String[] args) {
        System.out.println("=== ARRAY STACK DEMO ===");
        ArrayStack arrayStack = new ArrayStack(5);
        
        // Test push operations
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayStack.display(); // 10 -> 20 -> 30 <- TOP
        
        // Test peek
        arrayStack.peek(); // Top element: 30
        
        // Test pop operations
        arrayStack.pop();  // Popped: 30
        arrayStack.pop();  // Popped: 20
        arrayStack.display(); // 10 <- TOP
        
        // Test overflow
        arrayStack.push(40);
        arrayStack.push(50);
        arrayStack.push(60);
        arrayStack.push(70); // Stack Overflow!
        
        System.out.println("\n=== LINKED STACK DEMO ===");
        LinkedStack linkedStack = new LinkedStack();
        
        // Test push operations
        linkedStack.push(100);
        linkedStack.push(200);
        linkedStack.push(300);
        linkedStack.display(); // 300 -> 200 -> 100
        
        // Test operations
        linkedStack.peek();    // Top element: 300
        linkedStack.pop();     // Popped: 300
        linkedStack.display(); // 200 -> 100
        
        // No overflow possible with linked implementation
        for (int i = 400; i <= 1000; i += 100) {
            linkedStack.push(i);
        }
        linkedStack.display();
    }
}
```

### 🎯 Generic Stack Implementation (Bonus)

```java
public class GenericStack<T> {
    private Node<T> top;
    private int size;
    
    private class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public int size() {
        return size;
    }
}

// Usage:
GenericStack<String> stringStack = new GenericStack<>();
stringStack.push("Hello");
stringStack.push("World");
System.out.println(stringStack.pop()); // "World"
```

---

## 🧠 PRACTICAL EXERCISES

### 🎯 Exercise 1: Balanced Parentheses (Beginner)
**Problem:** Check if parentheses in a string are balanced.
Examples: `"(())"` ✅ | `"(()"` ❌ | `"()())"` ❌

**Solution:**
```java
public boolean isBalanced(String expression) {
    LinkedStack stack = new LinkedStack();
    
    for (char ch : expression.toCharArray()) {
        if (ch == '(') {
            stack.push(1); // Push any value for opening bracket
        } else if (ch == ')') {
            if (stack.isEmpty()) {
                return false; // More closing than opening
            }
            stack.pop();
        }
    }
    
    return stack.isEmpty(); // Balanced if stack is empty
}

// Test
System.out.println(isBalanced("(())"));   // true
System.out.println(isBalanced("(()"));    // false
System.out.println(isBalanced("())"));    // false
```

### 🎯 Exercise 2: Reverse a String (Beginner)
**Problem:** Use a stack to reverse a string.

**Solution:**
```java
public String reverseString(String str) {
    GenericStack<Character> stack = new GenericStack<>();
    
    // Push all characters onto stack
    for (char ch : str.toCharArray()) {
        stack.push(ch);
    }
    
    // Pop all characters to build reversed string
    StringBuilder reversed = new StringBuilder();
    while (!stack.isEmpty()) {
        reversed.append(stack.pop());
    }
    
    return reversed.toString();
}

// Test
System.out.println(reverseString("hello")); // "olleh"
System.out.println(reverseString("world")); // "dlrow"
```

### 🎯 Exercise 3: Evaluate Postfix Expression (Intermediate)
**Problem:** Evaluate a postfix expression like "2 3 + 4 *" (which equals 20).

**Solution:**
```java
public int evaluatePostfix(String expression) {
    LinkedStack stack = new LinkedStack();
    String[] tokens = expression.split(" ");
    
    for (String token : tokens) {
        if (isNumber(token)) {
            stack.push(Integer.parseInt(token));
        } else {
            // Operator: pop two operands
            int operand2 = stack.pop();
            int operand1 = stack.pop();
            
            int result = performOperation(operand1, operand2, token);
            stack.push(result);
        }
    }
    
    return stack.pop(); // Final result
}

private boolean isNumber(String str) {
    try {
        Integer.parseInt(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

private int performOperation(int a, int b, String operator) {
    switch (operator) {
        case "+": return a + b;
        case "-": return a - b;
        case "*": return a * b;
        case "/": return a / b;
        default: throw new IllegalArgumentException("Invalid operator: " + operator);
    }
}

// Test
System.out.println(evaluatePostfix("2 3 +")); // 5
System.out.println(evaluatePostfix("2 3 + 4 *")); // 20
System.out.println(evaluatePostfix("5 2 - 3 *")); // 9
```

### 🎯 Exercise 4: Next Greater Element (Advanced)
**Problem:** For each element in an array, find the next greater element to its right.
Input: `[4, 5, 2, 25]` → Output: `[5, 25, 25, -1]`

**Solution:**
```java
public int[] nextGreaterElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    LinkedStack stack = new LinkedStack(); // Store indices
    
    // Process from right to left
    for (int i = n - 1; i >= 0; i--) {
        // Pop elements smaller than current
        while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
            stack.pop();
        }
        
        // If stack is empty, no greater element
        result[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
        
        // Push current index
        stack.push(i);
    }
    
    return result;
}

// Test
int[] nums = {4, 5, 2, 25};
int[] result = nextGreaterElement(nums);
System.out.println(Arrays.toString(result)); // [5, 25, 25, -1]
```

### 🎯 Exercise 5: Implement Min Stack (Advanced)
**Problem:** Design a stack that supports push, pop, top, and retrieving minimum element in O(1).

**Solution:**
```java
public class MinStack {
    private LinkedStack mainStack;
    private LinkedStack minStack;
    
    public MinStack() {
        mainStack = new LinkedStack();
        minStack = new LinkedStack();
    }
    
    public void push(int x) {
        mainStack.push(x);
        
        // Push to min stack if it's empty or x is smaller/equal to current min
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    public void pop() {
        if (mainStack.isEmpty()) return;
        
        int popped = mainStack.pop();
        
        // If popped element was minimum, pop from min stack too
        if (popped == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

// Test
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
System.out.println(minStack.getMin()); // -3
minStack.pop();
System.out.println(minStack.top());    // 0
System.out.println(minStack.getMin()); // -2
```

---

## 🔍 DEEP DIVE ANALYSIS

### ⏰ Time Complexity Analysis

| Operation | Array Stack | Linked Stack |
|-----------|-------------|--------------|
| **Push** | O(1) | O(1) |
| **Pop** | O(1) | O(1) |
| **Peek** | O(1) | O(1) |
| **isEmpty** | O(1) | O(1) |
| **Size** | O(1) | O(1)* |
| **Search** | O(n) | O(n) |

*O(1) only if you maintain size counter

### 💾 Space Complexity Analysis

**Array Stack:**
- Space: O(n) where n is maximum capacity
- Fixed memory allocation
- No extra memory per element

**Linked Stack:**
- Space: O(n) where n is number of elements
- Dynamic memory allocation
- Extra memory for pointers (usually 8 bytes per node on 64-bit systems)

### 🎯 When to Use Each Implementation

#### ✅ Use Array Stack When:
- You know the maximum size beforehand
- Memory usage is critical
- You want slightly faster performance (no dynamic allocation)
- Cache locality is important

#### ✅ Use Linked Stack When:
- Size can vary dramatically
- You want to avoid overflow conditions
- Memory is not tightly constrained
- You prefer dynamic memory management

### 🐛 Common Pitfalls and Debugging Tips

#### 1. **Stack Overflow/Underflow**
```java
// ❌ WRONG - no bounds checking
public void push(int x) {
    stack[++top] = x; // Can exceed array bounds!
}

// ✅ CORRECT - always check bounds
public boolean push(int x) {
    if (isFull()) {
        return false; // or throw exception
    }
    stack[++top] = x;
    return true;
}
```

#### 2. **Forgetting to Check Empty Stack**
```java
// ❌ WRONG - can cause exceptions
int value = stack.pop(); // What if stack is empty?

// ✅ CORRECT - always check first
if (!stack.isEmpty()) {
    int value = stack.pop();
} else {
    // Handle empty stack case
}
```

#### 3. **Off-by-One Errors with Indices**
```java
// ❌ WRONG - top starts at 0
private int top = 0;

// ✅ CORRECT - top starts at -1 for empty stack
private int top = -1;
```

#### 4. **Memory Leaks in Linked Implementation**
```java
// ❌ WRONG - nodes not properly dereferenced
public int pop() {
    int data = top.data;
    top = top.next; // Old top node still referenced
    return data;
}

// ✅ CORRECT - explicitly clear reference
public int pop() {
    int data = top.data;
    Node oldTop = top;
    top = top.next;
    oldTop.next = null; // Help GC
    return data;
}
```

### 🚀 Advanced Optimizations and Variations

#### 1. **Dynamic Array Stack**
```java
public class DynamicArrayStack {
    private int[] stack;
    private int top;
    private int capacity;
    
    private void resize() {
        capacity *= 2;
        stack = Arrays.copyOf(stack, capacity);
    }
    
    public void push(int x) {
        if (top == capacity - 1) {
            resize(); // Automatically grow
        }
        stack[++top] = x;
    }
}
```

#### 2. **Stack with Maximum**
Track maximum element efficiently:
```java
public class MaxStack extends LinkedStack {
    private LinkedStack maxStack;
    
    public void push(int x) {
        super.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }
    
    public int getMax() {
        return maxStack.peek();
    }
}
```

#### 3. **Thread-Safe Stack**
```java
public class ThreadSafeStack {
    private LinkedStack stack;
    private final Object lock = new Object();
    
    public void push(int x) {
        synchronized(lock) {
            stack.push(x);
        }
    }
    
    public int pop() {
        synchronized(lock) {
            return stack.pop();
        }
    }
}
```

---

## 🌟 REAL-WORLD APPLICATIONS

### 💼 Industry Use Cases

#### 1. **Function Call Stack**
```java
void functionA() {
    int x = 5;
    functionB(); // functionA's variables pushed to stack
}

void functionB() {
    int y = 10;
    functionC(); // functionB's variables pushed to stack
}
// When functions return, their stack frames are popped
```

#### 2. **Undo/Redo Operations**
```java
public class TextEditor {
    private GenericStack<String> undoStack;
    private GenericStack<String> redoStack;
    
    public void type(String text) {
        undoStack.push(currentState);
        currentState += text;
        redoStack.clear(); // Clear redo after new action
    }
    
    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentState);
            currentState = undoStack.pop();
        }
    }
}
```

#### 3. **Expression Evaluation**
- **Infix to Postfix conversion** (Shunting Yard Algorithm)
- **Calculator applications**
- **Compiler parsing**

#### 4. **Browser History**
```java
public class BrowserHistory {
    private GenericStack<String> backStack;
    private GenericStack<String> forwardStack;
    
    public void visit(String url) {
        backStack.push(currentUrl);
        currentUrl = url;
        forwardStack.clear();
    }
    
    public void back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentUrl);
            currentUrl = backStack.pop();
        }
    }
}
```

#### 5. **Memory Management**
- **Call stack in programming languages**
- **Recursive function calls**
- **Local variable storage**

### 🛠️ Popular Libraries Using Stacks

#### Java:
- `java.util.Stack` - Legacy stack implementation
- `java.util.Deque` - Recommended modern alternative
- `ArrayDeque` - Array-based double-ended queue

#### Python:
- `list` - Built-in list can act as stack (append/pop)
- `collections.deque` - More efficient for stack operations

#### JavaScript:
- `Array.push()` and `Array.pop()` - Built-in stack operations

### 🔗 Related Data Structures to Explore Next

1. **Queues** - FIFO data structure (opposite of stack)
2. **Deque** - Double-ended queue (stack + queue hybrid)
3. **Expression Trees** - Use stacks for construction
4. **Recursion** - Understand how call stacks work
5. **Depth-First Search (DFS)** - Uses stack for traversal
6. **Backtracking** - Stack-based problem-solving technique

---

## 📝 SUMMARY CHEAT SHEET

### 🎯 Key Concepts
- **LIFO**: Last In, First Out principle
- **Top**: Only accessible element
- **Push**: Add to top (O(1))
- **Pop**: Remove from top (O(1))
- **Peek**: Look at top without removing (O(1))

### ⚡ Quick Operations Reference
```java
// Array Stack
ArrayStack stack = new ArrayStack(10);
stack.push(element);     // Add to top
int value = stack.pop(); // Remove from top
int top = stack.peek();  // Look at top
boolean empty = stack.isEmpty();

// Linked Stack
LinkedStack stack = new LinkedStack();
// Same operations, no size limit

// Generic Stack
GenericStack<String> stack = new GenericStack<>();
stack.push("Hello");
String value = stack.pop();
```

### 🏆 Array vs Linked Implementation

| Feature | Array Stack | Linked Stack |
|---------|-------------|--------------|
| **Memory** | Fixed, efficient | Dynamic, extra pointers |
| **Overflow** | Possible | No (until out of memory) |
| **Cache** | Better locality | Scattered in memory |
| **Complexity** | All O(1) | All O(1) |

### 🧠 Problem-Solving Patterns

1. **Matching Patterns**: Use stack for parentheses, brackets
2. **Reverse Operations**: Stack naturally reverses order
3. **Expression Evaluation**: Stack for operators and operands
4. **Backtracking**: Stack to remember previous states
5. **DFS Traversal**: Stack for depth-first exploration

### 🎪 Common Interview Questions
- Implement stack using arrays/linked lists
- Balanced parentheses
- Evaluate postfix expression
- Next greater element
- Min/Max stack
- Sort a stack using another stack
- Design browser history

### 🚨 Common Mistakes to Avoid
- Not checking for empty stack before pop/peek
- Array overflow in fixed-size implementations
- Forgetting to update size counters
- Memory leaks in manual memory management languages

---

**🎉 Congratulations! You now have a complete understanding of Stacks!**

Stacks are fundamental to computer science and appear everywhere in programming. From function calls to undo operations, understanding stacks will make you a better programmer and problem solver.

**Practice Tips:**
- Implement both array and linked versions
- Solve problems step by step using stack visualization
- Think "LIFO" whenever you see patterns that need reversal or backtracking

**Next Topics to Explore:** Queues, Recursion, Expression Parsing, Depth-First Search