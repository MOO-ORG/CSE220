# 🚶‍♂️ QUEUES - COMPLETE LEARNING GUIDE

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

### 🤔 What is a Queue?
Imagine you're standing in line at a coffee shop ☕. The person who arrives **first** gets served **first**. You can't cut in line or leave from the middle - new people join at the **back**, and people leave from the **front**.

A **Queue** in programming works exactly like this line! It's a **linear data structure** that follows the **FIFO principle**:
- **FIFO = First In, First Out**
- The first element you put in is the first one you take out
- This is the **opposite** of a Stack (which is LIFO - Last In, First Out)

### 🎯 Why Do Queues Exist?

**Real-Life Problem:** Imagine you're managing a customer service system. Customers call in, and you need to handle them fairly - whoever called first should be helped first. You can't help someone who called later before helping someone who called earlier!

**Programming Problems Queues Solve:**
- ✅ **Fair scheduling** - First come, first served
- ✅ **Buffer management** - Handling data streams
- ✅ **Breadth-first search** - Level-by-level exploration
- ✅ **Print job management** - Documents print in order
- ✅ **Process scheduling** - Operating system task management
- ✅ **Handling requests** - Web servers processing requests

### 🏠 Real-World Analogies

1. **Coffee Shop Line** ☕
   - People join at the back (ENQUEUE)
   - People leave from the front (DEQUEUE)
   - First person in line gets served first

2. **Drive-Through Lane** 🚗
   - Cars enter at one end
   - Cars exit at the other end
   - Can't skip ahead or leave from middle

3. **Printer Queue** 🖨️
   - Documents get added to print queue
   - Printer processes them in order
   - First document submitted prints first

4. **Assembly Line** 🏭
   - Items enter production line
   - Get processed step by step
   - Exit in the same order they entered

### 📖 Key Terms Defined
- **Queue**: A FIFO data structure
- **Enqueue**: Adding an element to the rear/back
- **Dequeue**: Removing an element from the front
- **Front**: The first element (next to be removed)
- **Rear/Back**: The last element (most recently added)
- **Empty**: Queue has no elements
- **Full**: Queue can't accept more elements (for fixed-size queues)

---

## 🏗️ THEORY SECTION

### 📖 Basic Queue Operations

```
FRONT                    REAR
  ↓                        ↓
[ 10 ][ 20 ][ 30 ][ 40 ][   ]
  ↑                        ↑
First to                Last to
leave                   arrive
```

**Core Operations:**
1. **ENQUEUE(x)** - Add element x to the rear
2. **DEQUEUE()** - Remove and return front element
3. **FRONT/PEEK()** - Return front element without removing
4. **REAR()** - Return rear element without removing  
5. **ISEMPTY()** - Check if queue is empty
6. **ISFULL()** - Check if queue is full (for fixed-size)
7. **SIZE()** - Get number of elements

### 🔄 Step-by-Step Example

**Starting with empty queue:**
```
Queue: [ ] (empty)
FRONT: null, REAR: null
```

**ENQUEUE(10):**
```
Queue: [10]
FRONT: 10, REAR: 10
```

**ENQUEUE(20):**
```
Queue: [10][20]
FRONT: 10, REAR: 20
```

**ENQUEUE(30):**
```
Queue: [10][20][30]
FRONT: 10, REAR: 30
```

**DEQUEUE():** (returns 10)
```
Queue: [20][30]
FRONT: 20, REAR: 30
```

**ENQUEUE(40):**
```
Queue: [20][30][40]
FRONT: 20, REAR: 40
```

**DEQUEUE():** (returns 20)
```
Queue: [30][40]
FRONT: 30, REAR: 40
```

### 🏗️ Two Implementation Approaches

#### 1. **Array-Based Queue (Circular)**
```
[40][  ][  ][10][20][30]
 ↑              ↑       ↑
rear          front   (wrap around)
```
**Pros:** Fast operations, memory efficient per element
**Cons:** Fixed size, potential overflow, circular logic needed

#### 2. **Linked List-Based Queue**
```
FRONT → [10|•] → [20|•] → [30|•] → [40|NULL] ← REAR
```
**Pros:** Dynamic size, no overflow, simple logic
**Cons:** Extra memory for pointers

### ⚠️ Common Misconceptions

1. **"You can access elements in the middle"** - FALSE! Only front and rear are accessible
2. **"Queues work like stacks"** - FALSE! Opposite order (FIFO vs LIFO)
3. **"Array implementation is always linear"** - FALSE! Circular arrays are more efficient
4. **"Dequeue returns the index"** - FALSE! Returns the actual element value
5. **"You add and remove from the same end"** - FALSE! Different ends (unlike stacks)

---

## 💻 CODE IMPLEMENTATION

### 🏗️ Implementation 1: Circular Array-Based Queue

```java
public class ArrayQueue {
    private int[] queue;     // Array to store elements
    private int front;       // Index of front element
    private int rear;        // Index of rear element
    private int size;        // Current number of elements
    private int maxSize;     // Maximum capacity
    
    // Constructor - creates empty queue with given capacity
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        this.front = 0;
        this.rear = -1;  // -1 indicates no elements yet
        this.size = 0;
        System.out.println("Created circular array queue with capacity: " + maxSize);
    }
    
    // 1. ENQUEUE - Add element to rear - O(1)
    public boolean enqueue(int element) {
        // Check for overflow
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot enqueue " + element);
            return false;
        }
        
        // Move rear to next position (circular)
        rear = (rear + 1) % maxSize;
        queue[rear] = element;
        size++;
        
        System.out.println("Enqueued: " + element + " at position " + rear);
        return true;
    }
    
    // 2. DEQUEUE - Remove and return front element - O(1)
    public int dequeue() {
        // Check for underflow
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot dequeue from empty queue");
            return -1; // or throw exception
        }
        
        // Get front element
        int dequeuedElement = queue[front];
        
        // Move front to next position (circular)
        front = (front + 1) % maxSize;
        size--;
        
        System.out.println("Dequeued: " + dequeuedElement);
        return dequeuedElement;
    }
    
    // 3. FRONT - Return front element without removing - O(1)
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No front element");
            return -1;
        }
        
        System.out.println("Front element: " + queue[front]);
        return queue[front];
    }
    
    // 4. REAR - Return rear element without removing - O(1)
    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No rear element");
            return -1;
        }
        
        System.out.println("Rear element: " + queue[rear]);
        return queue[rear];
    }
    
    // 5. CHECK IF EMPTY - O(1)
    public boolean isEmpty() {
        return size == 0;
    }
    
    // 6. CHECK IF FULL - O(1)
    public boolean isFull() {
        return size == maxSize;
    }
    
    // 7. GET SIZE - O(1)
    public int size() {
        return size;
    }
    
    // 8. DISPLAY QUEUE - O(n)
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % maxSize;  // Handle circular nature
            System.out.print(queue[index]);
            if (i < size - 1) System.out.print(" <- ");
        }
        System.out.println();
        System.out.println("Front index: " + front + ", Rear index: " + rear);
    }
    
    // 9. CLEAR QUEUE - O(1)
    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Queue cleared!");
    }
}
```

### 🔗 Implementation 2: Linked List-Based Queue

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

public class LinkedQueue {
    private Node front;  // Reference to front node
    private Node rear;   // Reference to rear node
    private int size;    // Keep track of size
    
    // Constructor - creates empty queue
    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
        System.out.println("Created linked list queue");
    }
    
    // 1. ENQUEUE - Add element to rear - O(1)
    public void enqueue(int element) {
        Node newNode = new Node(element);
        
        // If queue is empty, both front and rear point to new node
        if (rear == null) {
            front = rear = newNode;
        } else {
            // Link new node to current rear and update rear
            rear.next = newNode;
            rear = newNode;
        }
        
        size++;
        System.out.println("Enqueued: " + element);
    }
    
    // 2. DEQUEUE - Remove and return front element - O(1)
    public int dequeue() {
        // Check for underflow
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot dequeue from empty queue");
            return -1;
        }
        
        // Get data from front node
        int dequeuedElement = front.data;
        
        // Move front to next node
        front = front.next;
        
        // If queue becomes empty, update rear to null
        if (front == null) {
            rear = null;
        }
        
        size--;
        System.out.println("Dequeued: " + dequeuedElement);
        return dequeuedElement;
    }
    
    // 3. FRONT - Return front element without removing - O(1)
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No front element");
            return -1;
        }
        
        System.out.println("Front element: " + front.data);
        return front.data;
    }
    
    // 4. REAR - Return rear element without removing - O(1)
    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No rear element");
            return -1;
        }
        
        System.out.println("Rear element: " + rear.data);
        return rear.data;
    }
    
    // 5. CHECK IF EMPTY - O(1)
    public boolean isEmpty() {
        return front == null;
    }
    
    // 6. GET SIZE - O(1)
    public int size() {
        return size;
    }
    
    // 7. DISPLAY QUEUE - O(n)
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <- ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    // 8. CLEAR QUEUE - O(1)
    public void clear() {
        front = rear = null;
        size = 0;
        System.out.println("Queue cleared!");
    }
}
```

### 🚀 Example Usage and Testing

```java
public class QueueDemo {
    public static void main(String[] args) {
        System.out.println("=== ARRAY QUEUE DEMO ===");
        ArrayQueue arrayQueue = new ArrayQueue(5);
        
        // Test enqueue operations
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.display(); // 10 <- 20 <- 30
        
        // Test front and rear
        arrayQueue.front(); // Front element: 10
        arrayQueue.rear();  // Rear element: 30
        
        // Test dequeue operations
        arrayQueue.dequeue(); // Dequeued: 10
        arrayQueue.dequeue(); // Dequeued: 20
        arrayQueue.display(); // 30
        
        // Test circular nature
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
        arrayQueue.enqueue(60);
        arrayQueue.enqueue(70); // Should work (circular)
        arrayQueue.enqueue(80); // Queue Overflow!
        arrayQueue.display();
        
        System.out.println("\n=== LINKED QUEUE DEMO ===");
        LinkedQueue linkedQueue = new LinkedQueue();
        
        // Test enqueue operations
        linkedQueue.enqueue(100);
        linkedQueue.enqueue(200);
        linkedQueue.enqueue(300);
        linkedQueue.display(); // 100 <- 200 <- 300
        
        // Test operations
        linkedQueue.front();   // Front element: 100
        linkedQueue.rear();    // Rear element: 300
        linkedQueue.dequeue(); // Dequeued: 100
        linkedQueue.display(); // 200 <- 300
        
        // No overflow possible with linked implementation
        for (int i = 400; i <= 1000; i += 100) {
            linkedQueue.enqueue(i);
        }
        linkedQueue.display();
        
        System.out.println("Final size: " + linkedQueue.size());
    }
}
```

### 🎯 Generic Queue Implementation (Bonus)

```java
public class GenericQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;
    
    private class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        
        T data = front.data;
        front = front.next;
        
        if (front == null) {
            rear = null;
        }
        
        size--;
        return data;
    }
    
    public T front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }
    
    public boolean isEmpty() {
        return front == null;
    }
    
    public int size() {
        return size;
    }
}

// Usage:
GenericQueue<String> stringQueue = new GenericQueue<>();
stringQueue.enqueue("First");
stringQueue.enqueue("Second");
System.out.println(stringQueue.dequeue()); // "First"
```

---

## 🧠 PRACTICAL EXERCISES

### 🎯 Exercise 1: Hot Potato Game (Beginner)
**Problem:** Simulate the "Hot Potato" game where people pass a potato and every k-th person is eliminated.
Input: `people = ["Alice", "Bob", "Charlie", "Diana"]`, `k = 2`

**Solution:**
```java
public String hotPotato(String[] people, int k) {
    GenericQueue<String> queue = new GenericQueue<>();
    
    // Add all people to queue
    for (String person : people) {
        queue.enqueue(person);
    }
    
    // Eliminate people until only one remains
    while (queue.size() > 1) {
        // Pass potato k-1 times (move people to back)
        for (int i = 1; i < k; i++) {
            queue.enqueue(queue.dequeue());
        }
        
        // Eliminate k-th person
        String eliminated = queue.dequeue();
        System.out.println(eliminated + " is eliminated!");
    }
    
    return queue.dequeue(); // Last person remaining
}

// Test
String[] people = {"Alice", "Bob", "Charlie", "Diana"};
String winner = hotPotato(people, 2);
System.out.println("Winner: " + winner);
```

### 🎯 Exercise 2: Generate Binary Numbers (Intermediate)
**Problem:** Generate binary numbers from 1 to n using a queue.
Input: `n = 5` → Output: `1, 10, 11, 100, 101`

**Solution:**
```java
public void generateBinaryNumbers(int n) {
    GenericQueue<String> queue = new GenericQueue<>();
    queue.enqueue("1"); // Start with "1"
    
    for (int i = 0; i < n; i++) {
        // Dequeue front and print
        String front = queue.dequeue();
        System.out.println(front);
        
        // Generate next two binary numbers
        queue.enqueue(front + "0");  // Append "0"
        queue.enqueue(front + "1");  // Append "1"
    }
}

// Test
generateBinaryNumbers(5);
// Output: 1, 10, 11, 100, 101
```

### 🎯 Exercise 3: Implement Queue using Two Stacks (Intermediate)
**Problem:** Implement a queue using two stacks.

**Solution:**
```java
import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stack1; // For enqueue
    private Stack<Integer> stack2; // For dequeue
    
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // Enqueue: Always push to stack1 - O(1)
    public void enqueue(int x) {
        stack1.push(x);
    }
    
    // Dequeue: Use stack2, transfer from stack1 if needed - O(1) amortized
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            
            // Transfer all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.pop();
    }
    
    // Front: Similar to dequeue but don't remove
    public int front() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.peek();
    }
    
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

// Test
QueueUsingStacks queue = new QueueUsingStacks();
queue.enqueue(1);
queue.enqueue(2);
System.out.println(queue.dequeue()); // 1
queue.enqueue(3);
System.out.println(queue.dequeue()); // 2
System.out.println(queue.dequeue()); // 3
```

### 🎯 Exercise 4: First Non-Repeating Character in Stream (Advanced)
**Problem:** Find the first non-repeating character in a stream of characters.

**Solution:**
```java
import java.util.*;

public class FirstNonRepeating {
    private GenericQueue<Character> queue;
    private Map<Character, Integer> frequency;
    
    public FirstNonRepeating() {
        queue = new GenericQueue<>();
        frequency = new HashMap<>();
    }
    
    public char addCharacter(char ch) {
        // Update frequency
        frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        queue.enqueue(ch);
        
        // Remove characters that are no longer non-repeating
        while (!queue.isEmpty() && frequency.get(queue.front()) > 1) {
            queue.dequeue();
        }
        
        // Return first non-repeating character
        return queue.isEmpty() ? '#' : queue.front();
    }
}

// Test
FirstNonRepeating fnr = new FirstNonRepeating();
System.out.println(fnr.addCharacter('a')); // 'a'
System.out.println(fnr.addCharacter('a')); // '#'
System.out.println(fnr.addCharacter('b')); // 'b'
System.out.println(fnr.addCharacter('c')); // 'b'
```

### 🎯 Exercise 5: Sliding Window Maximum (Advanced)
**Problem:** Find the maximum element in every sliding window of size k.
Input: `arr = [1,3,-1,-3,5,3,6,7]`, `k = 3`

**Solution:**
```java
import java.util.*;

public int[] slidingWindowMaximum(int[] nums, int k) {
    Deque<Integer> deque = new ArrayDeque<>(); // Store indices
    int[] result = new int[nums.length - k + 1];
    int resultIndex = 0;
    
    for (int i = 0; i < nums.length; i++) {
        // Remove indices outside current window
        while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
            deque.pollFirst();
        }
        
        // Remove smaller elements from rear
        while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
            deque.pollLast();
        }
        
        deque.offerLast(i);
        
        // Add maximum to result when window is complete
        if (i >= k - 1) {
            result[resultIndex++] = nums[deque.peekFirst()];
        }
    }
    
    return result;
}

// Test
int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
int[] result = slidingWindowMaximum(nums, 3);
System.out.println(Arrays.toString(result)); // [3, 3, 5, 5, 6, 7]
```

---

## 🔍 DEEP DIVE ANALYSIS

### ⏰ Time Complexity Analysis

| Operation | Array Queue | Linked Queue |
|-----------|-------------|--------------|
| **Enqueue** | O(1) | O(1) |
| **Dequeue** | O(1) | O(1) |
| **Front** | O(1) | O(1) |
| **Rear** | O(1) | O(1) |
| **isEmpty** | O(1) | O(1) |
| **Size** | O(1) | O(1) |
| **Search** | O(n) | O(n) |

### 💾 Space Complexity Analysis

**Array Queue (Circular):**
- Space: O(n) where n is maximum capacity
- Fixed memory allocation
- No extra memory per element
- May waste space if not full

**Linked Queue:**
- Space: O(n) where n is number of elements
- Dynamic memory allocation
- Extra memory for pointers (~8 bytes per node on 64-bit)
- Uses only needed memory

### 🎯 When to Use Each Implementation

#### ✅ Use Array Queue When:
- You know the maximum size beforehand
- Memory usage is critical
- You want slightly faster performance (better cache locality)
- You need predictable memory usage

#### ✅ Use Linked Queue When:
- Size can vary dramatically
- You want to avoid overflow conditions  
- You prefer dynamic memory management
- Memory fragmentation is not a concern

### 🐛 Common Pitfalls and Debugging Tips

#### 1. **Array Queue Overflow/Underflow**
```java
// ❌ WRONG - no bounds checking
public void enqueue(int x) {
    queue[++rear] = x; // Can exceed array bounds!
}

// ✅ CORRECT - always check bounds
public boolean enqueue(int x) {
    if (isFull()) {
        return false; // or throw exception
    }
    rear = (rear + 1) % maxSize; // Circular increment
    queue[rear] = x;
    return true;
}
```

#### 2. **Circular Array Logic Errors**
```java
// ❌ WRONG - linear increment
rear = rear + 1;

// ✅ CORRECT - circular increment
rear = (rear + 1) % maxSize;
```

#### 3. **Forgetting to Update Rear Pointer in Linked Queue**
```java
// ❌ WRONG - rear not updated when queue becomes empty
public int dequeue() {
    int data = front.data;
    front = front.next;
    // Missing: if (front == null) rear = null;
    return data;
}

// ✅ CORRECT - handle empty queue case
public int dequeue() {
    int data = front.data;
    front = front.next;
    if (front == null) {
        rear = null; // Queue is now empty
    }
    return data;
}
```

#### 4. **Size Tracking Issues**
```java
// ❌ WRONG - forgetting to update size
public void enqueue(int x) {
    // Add element logic...
    // Missing: size++;
}

// ✅ CORRECT - always update size
public void enqueue(int x) {
    // Add element logic...
    size++;
}
```

### 🚀 Advanced Optimizations and Variations

#### 1. **Double-Ended Queue (Deque)**
```java
public class Deque {
    // Can add/remove from both ends
    public void addFront(int x) { /* Implementation */ }
    public void addRear(int x) { /* Implementation */ }
    public int removeFront() { /* Implementation */ }
    public int removeRear() { /* Implementation */ }
}
```

#### 2. **Priority Queue**
```java
public class PriorityQueue {
    // Elements dequeued based on priority, not order
    public void enqueue(int element, int priority) { /* Implementation */ }
    public int dequeue() { /* Returns highest priority element */ }
}
```

#### 3. **Circular Buffer with Dynamic Resizing**
```java
public class DynamicArrayQueue {
    private void resize() {
        int newCapacity = capacity * 2;
        int[] newQueue = new int[newCapacity];
        
        // Copy elements maintaining order
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % capacity];
        }
        
        queue = newQueue;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
    }
}
```

#### 4. **Thread-Safe Queue**
```java
public class ThreadSafeQueue {
    private final Object lock = new Object();
    private LinkedQueue queue = new LinkedQueue();
    
    public void enqueue(int x) {
        synchronized(lock) {
            queue.enqueue(x);
        }
    }
    
    public int dequeue() {
        synchronized(lock) {
            return queue.dequeue();
        }
    }
}
```

---

## 🌟 REAL-WORLD APPLICATIONS

### 💼 Industry Use Cases

#### 1. **Operating System Process Scheduling**
```java
public class ProcessScheduler {
    private GenericQueue<Process> readyQueue;
    
    public void scheduleProcess(Process process) {
        readyQueue.enqueue(process); // Add to end of ready queue
    }
    
    public Process getNextProcess() {
        return readyQueue.dequeue(); // Get next process to run
    }
}
```

#### 2. **Print Job Management**
```java
public class PrinterQueue {
    private GenericQueue<PrintJob> printQueue;
    
    public void submitJob(PrintJob job) {
        printQueue.enqueue(job);
        System.out.println("Job added to print queue");
    }
    
    public void processNextJob() {
        if (!printQueue.isEmpty()) {
            PrintJob job = printQueue.dequeue();
            job.print();
        }
    }
}
```

#### 3. **Web Server Request Handling**
```java
public class WebServer {
    private GenericQueue<HttpRequest> requestQueue;
    private final int MAX_QUEUE_SIZE = 1000;
    
    public boolean handleRequest(HttpRequest request) {
        if (requestQueue.size() < MAX_QUEUE_SIZE) {
            requestQueue.enqueue(request);
            return true;
        }
        return false; // Server overloaded
    }
    
    public void processRequests() {
        while (!requestQueue.isEmpty()) {
            HttpRequest request = requestQueue.dequeue();
            processRequest(request);
        }
    }
}
```

#### 4. **Breadth-First Search (BFS)**
```java
public void breadthFirstSearch(Node startNode) {
    GenericQueue<Node> queue = new GenericQueue<>();
    Set<Node> visited = new HashSet<>();
    
    queue.enqueue(startNode);
    visited.add(startNode);
    
    while (!queue.isEmpty()) {
        Node current = queue.dequeue();
        System.out.println("Visiting: " + current.value);
        
        for (Node neighbor : current.neighbors) {
            if (!visited.contains(neighbor)) {
                queue.enqueue(neighbor);
                visited.add(neighbor);
            }
        }
    }
}
```

#### 5. **Buffer for Data Streaming**
```java
public class DataBuffer {
    private GenericQueue<DataPacket> buffer;
    private final int BUFFER_SIZE = 1024;
    
    public boolean addData(DataPacket packet) {
        if (buffer.size() < BUFFER_SIZE) {
            buffer.enqueue(packet);
            return true;
        }
        
        // Buffer full - might drop packet or block
        return false;
    }
    
    public DataPacket readData() {
        return buffer.isEmpty() ? null : buffer.dequeue();
    }
}
```

### 🛠️ Popular Libraries Using Queues

#### Java:
- `java.util.Queue` - Interface for queue implementations
- `java.util.LinkedList` - Can be used as queue
- `java.util.ArrayDeque` - Resizable array implementation
- `java.util.concurrent.BlockingQueue` - Thread-safe queues

#### Python:
- `collections.deque` - Double-ended queue
- `queue.Queue` - Thread-safe FIFO queue
- `queue.PriorityQueue` - Priority-based queue

#### JavaScript:
- `Array.push()` and `Array.shift()` - Basic queue operations
- No built-in queue, but arrays can simulate

### 🔗 Related Data Structures to Explore Next

1. **Deque (Double-Ended Queue)** - Add/remove from both ends
2. **Priority Queue** - Order by priority, not insertion time
3. **Circular Queue** - Advanced array-based implementation
4. **Breadth-First Search** - Uses queues for level-order traversal
5. **Trees (Level-order traversal)** - BFS using queues
6. **Graph Algorithms** - Many use queues for traversal
7. **Producer-Consumer Problem** - Synchronization using queues

---

## 📝 SUMMARY CHEAT SHEET

### 🎯 Key Concepts
- **FIFO**: First In, First Out principle
- **Front**: First element (next to be removed)
- **Rear**: Last element (most recently added)
- **Enqueue**: Add to rear (O(1))
- **Dequeue**: Remove from front (O(1))
- **Different ends**: Unlike stacks, add and remove from opposite ends

### ⚡ Quick Operations Reference
```java
// Array Queue (Circular)
ArrayQueue queue = new ArrayQueue(10);
queue.enqueue(element);     // Add to rear
int value = queue.dequeue(); // Remove from front
int front = queue.front();   // Look at front
boolean empty = queue.isEmpty();

// Linked Queue
LinkedQueue queue = new LinkedQueue();
// Same operations, no size limit

// Generic Queue
GenericQueue<String> queue = new GenericQueue<>();
queue.enqueue("Hello");
String value = queue.dequeue();
```

### 🏆 Array vs Linked Implementation

| Feature | Array Queue | Linked Queue |
|---------|-------------|--------------|
| **Memory** | Fixed, efficient | Dynamic, extra pointers |
| **Overflow** | Possible | No (until out of memory) |
| **Cache** | Better locality | Scattered in memory |
| **Complexity** | All O(1) | All O(1) |
| **Circular Logic** | Required | Not needed |

### 🧠 Problem-Solving Patterns

1. **Level-Order Processing**: Use queue for breadth-first approaches
2. **Fair Scheduling**: FIFO ensures fairness
3. **Buffer Management**: Queue for data streaming
4. **State Exploration**: BFS uses queues to explore level by level
5. **Producer-Consumer**: Queue as buffer between processes

### 🎪 Common Interview Questions
- Implement queue using arrays/linked lists
- Implement queue using two stacks
- Generate binary numbers using queue
- First non-repeating character in stream
- Sliding window maximum
- Hot potato game simulation
- Level-order tree traversal

### 🚨 Common Mistakes to Avoid
- Forgetting circular logic in array implementation
- Not updating rear pointer when queue becomes empty
- Confusing FIFO (queue) with LIFO (stack)
- Not checking for empty queue before dequeue
- Array overflow in fixed-size implementations

### 🎯 Queue vs Stack Quick Comparison

| Aspect | Queue (FIFO) | Stack (LIFO) |
|--------|--------------|--------------|
| **Add** | Rear (enqueue) | Top (push) |
| **Remove** | Front (dequeue) | Top (pop) |
| **Use Cases** | Scheduling, BFS | Function calls, DFS |
| **Order** | First in, first out | Last in, first out |

---

**🎉 Congratulations! You now have a complete understanding of Queues!**

Queues are fundamental for fair processing, scheduling, and breadth-first algorithms. They complement stacks perfectly - where stacks reverse order (LIFO), queues preserve order (FIFO).

**Practice Tips:**
- Visualize the queue as a line of people
- Remember FIFO - opposite of stack's LIFO
- Practice with both array (circular) and linked implementations
- Understand when each implementation is better

**Next Topics to Explore:** Priority Queues, Deques, BFS Algorithms, Trees, Graph Traversal