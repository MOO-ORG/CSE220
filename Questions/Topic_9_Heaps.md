# Topic 9: Heaps
**Question Set: 35 Total Questions**

---

## Part A: Multiple Choice Questions (15 Questions)

### Easy Level (4 Questions)

**MCQ 1 (Easy)**
What property does a max heap satisfy?
A) Parent node is smaller than its children
B) Parent node is larger than its children
C) All nodes are in ascending order
D) Left child is always smaller than right child

**Answer: B) Parent node is larger than its children**

---

**MCQ 2 (Easy)**
In a binary heap implemented using an array, where is the parent of node at index i?
A) i/2
B) (i-1)/2
C) 2*i
D) 2*i + 1

**Answer: B) (i-1)/2**

---

**MCQ 3 (Easy)**
What is the time complexity of finding the maximum element in a max heap?
A) O(1)
B) O(log n)
C) O(n)
D) O(n log n)

**Answer: A) O(1) - Maximum is always at the root**

---

**MCQ 4 (Easy)**
What is the height of a binary heap with n elements?
A) n
B) log₂(n)
C) n/2
D) sqrt(n)

**Answer: B) log₂(n) - Heaps are complete binary trees**

---

### Medium Level (4 Questions)

**MCQ 5 (Medium)**
What is the time complexity of inserting an element into a binary heap?
A) O(1)
B) O(log n)
C) O(n)
D) O(n log n)

**Answer: B) O(log n) - May need to bubble up to maintain heap property**

---

**MCQ 6 (Medium)**
In the heapify operation (sift down), what is the time complexity?
A) O(1)
B) O(log n)
C) O(n)
D) O(n log n)

**Answer: B) O(log n) - May need to sift down to leaf level**

---

**MCQ 7 (Medium)**
What is the time complexity of building a heap from an unsorted array using bottom-up approach?
A) O(log n)
B) O(n)
C) O(n log n)
D) O(n²)

**Answer: B) O(n) - Optimal heapify algorithm**

---

**MCQ 8 (Medium)**
In a min heap, which element is guaranteed to be at a leaf node?
A) Minimum element
B) Maximum element
C) Median element
D) Any element

**Answer: B) Maximum element - Cannot have children larger than itself**

---

### Hard Level (4 Questions)

**MCQ 9 (Hard)**
What is the time complexity of heap sort?
A) O(n)
B) O(n log n)
C) O(n²)
D) O(log n)

**Answer: B) O(n log n) - Build heap O(n) + n deletions O(log n) each**

---

**MCQ 10 (Hard)**
In a binary heap with n elements, what is the maximum number of comparisons needed to find the second largest element?
A) 1
B) log n
C) n
D) n + log n

**Answer: B) log n - Second largest is among children of root or their children**

---

**MCQ 11 (Hard)**
What is the space complexity of heap sort?
A) O(1)
B) O(log n)
C) O(n)
D) O(n log n)

**Answer: A) O(1) - In-place sorting algorithm**

---

**MCQ 12 (Hard)**
In a d-ary heap (each node has d children), what is the time complexity of extract-min?
A) O(1)
B) O(log_d n)
C) O(d log_d n)
D) O(d²)

**Answer: C) O(d log_d n) - Height is log_d n, each level requires d comparisons**

---

### Expert Level (3 Questions)

**MCQ 13 (Expert)**
What is the time complexity of decreasing a key in a binary heap?
A) O(1)
B) O(log n)
C) O(n)
D) O(n log n)

**Answer: B) O(log n) - May need to bubble up after decreasing key**

---

**MCQ 14 (Expert)**
In a Fibonacci heap, what is the amortized time complexity of decrease-key operation?
A) O(1)
B) O(log n)
C) O(n)
D) O(log* n)

**Answer: A) O(1) - Amortized constant time**

---

**MCQ 15 (Expert)**
What is the main advantage of a binomial heap over a binary heap?
A) Better worst-case complexities
B) Supports efficient merge operation
C) Uses less memory
D) Simpler implementation

**Answer: B) Supports efficient merge operation - O(log n) merge time**

---

## Part B: Code Snippet Questions (5 Questions)

### Code Snippet 1
```java
public void heapify(int[] arr, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    
    if (left < n && arr[left] > arr[largest])
        largest = left;
        
    if (right < n && arr[right] > arr[largest])
        largest = right;
        
    if (largest != i) {
        swap(arr, i, largest);
        heapify(arr, n, largest);
    }
}
```
**Question:** What type of heap does this code maintain and what is its time complexity?

**Answer:** Maintains max heap property. Time complexity: O(log n) for single heapify operation.

---

### Code Snippet 2
```java
public void insert(int key) {
    heap.add(key);
    int index = heap.size() - 1;
    
    while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
        swap(index, parent(index));
        index = parent(index);
    }
}

private int parent(int i) {
    return (i - 1) / 2;
}
```
**Question:** What heap operation is this implementing and what is the worst-case scenario?

**Answer:** Heap insertion with bubble-up. Worst case: O(log n) when element bubbles up to root.

---

### Code Snippet 3
```java
public int extractMax() {
    if (heap.isEmpty()) throw new RuntimeException("Heap is empty");
    
    int max = heap.get(0);
    int lastElement = heap.remove(heap.size() - 1);
    
    if (!heap.isEmpty()) {
        heap.set(0, lastElement);
        heapify(0);
    }
    
    return max;
}
```
**Question:** Why is the last element moved to the root before heapifying?

**Answer:** Maintains complete binary tree structure. Moving last element avoids creating holes in the heap.

---

### Code Snippet 4
```java
public void buildHeap(int[] arr) {
    int n = arr.length;
    
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);
    }
}
```
**Question:** Why does the loop start from n/2 - 1 and what is the time complexity?

**Answer:** Starts from last non-leaf node (n/2 - 1). Leaf nodes already satisfy heap property. Time complexity: O(n).

---

### Code Snippet 5
```java
public class MedianFinder {
    PriorityQueue<Integer> maxHeap; // left half
    PriorityQueue<Integer> minHeap; // right half
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? 
               maxHeap.peek() : 
               (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
```
**Question:** What problem does this solve and why are two heaps needed?

**Answer:** Finds median of data stream. Two heaps maintain sorted halves: max heap for smaller half, min heap for larger half.

---

## Part C: Problem Solving Questions (15 Questions)

### Easy Level (3 Questions)

**Problem 1 (Easy)**
Implement a basic max heap using an array.

```java
public class MaxHeap {
    private int[] heap;
    private int size;
    
    public void insert(int key) { }
    public int extractMax() { }
    public int peek() { }
    private void heapifyUp(int index) { }
    private void heapifyDown(int index) { }
}
```

**Hint:** Use array indexing: parent at (i-1)/2, children at 2*i+1 and 2*i+2. Maintain heap property during insert/delete.

---

**Problem 2 (Easy)**
Find the kth largest element in an unsorted array using a heap.

```java
public int findKthLargest(int[] nums, int k) {
    // Find kth largest element using heap
}
```

**Hint:** Use min heap of size k. Maintain only k largest elements, the root will be the kth largest.

---

**Problem 3 (Easy)**
Check if a binary tree satisfies the max heap property.

```java
public boolean isMaxHeap(TreeNode root) {
    // Check if binary tree is a valid max heap
}
```

**Hint:** Check two conditions: complete binary tree structure and max heap property (parent ≥ children).

---

### Medium Level (3 Questions)

**Problem 4 (Medium)**
Merge k sorted arrays using a heap.

```java
public int[] mergeKSortedArrays(int[][] arrays) {
    // Merge k sorted arrays into one sorted array
}
```

**Hint:** Use min heap to track smallest element from each array. Store (value, arrayIndex, elementIndex) in heap.

---

**Problem 5 (Medium)**
Design a data structure that supports insert, delete, and getRandom in O(log n) time.

```java
public class RandomizedHeap {
    public void insert(int val) { }
    public boolean delete(int val) { }
    public int getRandom() { }
}
```

**Hint:** Use heap with hash map for O(log n) delete. For getRandom, use heap property to generate random valid indices.

---

**Problem 6 (Medium)**
Find the smallest range that includes at least one element from each of k sorted arrays.

```java
public int[] smallestRange(List<List<Integer>> nums) {
    // Find smallest range covering all arrays
}
```

**Hint:** Use min heap to track current minimum from each array. Track maximum separately. Update range when advancing minimum.

---

### Hard Level (5 Questions)

**Problem 7 (Hard)**
Implement heap sort algorithm.

```java
public void heapSort(int[] arr) {
    // Sort array using heap sort
}
```

**Hint:** Build max heap, then repeatedly extract maximum and place at end of array. Heapify remaining elements.

---

**Problem 8 (Hard)**
Design a data structure for sliding window maximum.

```java
public int[] maxSlidingWindow(int[] nums, int k) {
    // Find maximum in each window of size k
}
```

**Hint:** Use deque (not heap) for O(n) solution, or use heap with lazy deletion for simpler O(n log k) solution.

---

**Problem 9 (Hard)**
Find the maximum sum of k non-overlapping subarrays.

```java
public int maxSumKSubarrays(int[] arr, int k) {
    // Find k non-overlapping subarrays with maximum sum
}
```

**Hint:** Use heap to track best subarray sums. For each selected subarray, split remaining array and continue search.

---

**Problem 10 (Hard)**
Implement a priority queue that supports updating priorities.

```java
public class UpdatablePriorityQueue<T> {
    public void insert(T item, int priority) { }
    public T extractMin() { }
    public void updatePriority(T item, int newPriority) { }
}
```

**Hint:** Use indexed binary heap with hash map to track item positions. Update requires reheapifying up or down.

---

**Problem 11 (Hard)**
Find the running median of a data stream.

```java
public class RunningMedian {
    public void addNumber(int num) { }
    public double getMedian() { }
}
```

**Hint:** Use two heaps: max heap for smaller half, min heap for larger half. Balance sizes to maintain median at heap tops.

---

### Expert Level (4 Questions)

**Problem 12 (Expert)**
Implement a binomial heap with merge operation.

```java
public class BinomialHeap {
    public void insert(int key) { }
    public int extractMin() { }
    public BinomialHeap merge(BinomialHeap other) { }
    private void decreaseKey(Node node, int key) { }
}
```

**Hint:** Maintain list of binomial trees. Merge by combining trees of same degree. Use cascading cuts for decrease-key.

---

**Problem 13 (Expert)**
Design an external sorting algorithm for data larger than memory using heaps.

```java
public class ExternalSort {
    public void sort(String inputFile, String outputFile, int memoryLimit) {
        // Sort large file using limited memory
    }
}
```

**Hint:** Create sorted runs that fit in memory, then use k-way merge with heap to combine runs.

---

**Problem 14 (Expert)**
Implement a soft heap with corruption parameter.

```java
public class SoftHeap {
    public SoftHeap(double epsilon) { }
    public void insert(int key) { }
    public int extractMin() { }
    // Allows epsilon fraction of elements to be corrupted for better performance
}
```

**Hint:** Use rank-based corruption. Allow some elements to have incorrect heap order to achieve better amortized complexity.

---

**Problem 15 (Expert)**
Design a persistent heap that maintains all previous versions.

```java
public class PersistentHeap {
    public PersistentHeap insert(int key) { }
    public PersistentHeap extractMin() { }
    public int getMin(int version) { }
}
```

**Hint:** Use path copying with shared nodes. Only create new nodes along the path of modification. Share unchanged subtrees.

---

## Summary
This question set covers heap fundamentals, priority queue implementations, and advanced heap-based algorithms.

**Key Learning Objectives:**
- Understanding heap properties and structure
- Mastering heap operations (insert, delete, heapify)
- Implementing priority queues and their applications
- Analyzing time complexities of heap operations
- Advanced heap variants and their use cases

**Heap Types Covered:**
- **Binary Heaps**: Max heap, min heap implementations
- **d-ary Heaps**: Generalization with d children per node
- **Binomial Heaps**: Support for efficient merge operations
- **Fibonacci Heaps**: Improved amortized complexities
- **Specialized Heaps**: Soft heaps, persistent heaps

**Core Applications:**
- **Priority Queues**: Task scheduling, event simulation
- **Sorting**: Heap sort algorithm
- **Graph Algorithms**: Dijkstra's shortest path, Prim's MST
- **Data Streams**: Running median, sliding window problems
- **External Sorting**: Handling large datasets

**Algorithm Patterns:**
- **Heapify Operations**: Maintaining heap property
- **Two-Heap Technique**: Finding median in data streams
- **K-way Merge**: Merging multiple sorted sequences
- **Priority-based Selection**: Finding kth largest/smallest elements

**Performance Characteristics:**
- **Time Complexities**: O(1) peek, O(log n) insert/delete, O(n) build heap
- **Space Complexities**: In-place operations vs auxiliary space trade-offs
- **Amortized Analysis**: Advanced heap variants with better average performance

**Total Questions: 35**
- MCQ: 15 (Easy: 4, Medium: 4, Hard: 4, Expert: 3)
- Code Snippet: 5 (with solutions)
- Problem Solving: 15 (Easy: 3, Medium: 3, Hard: 5, Expert: 4) - with hints only