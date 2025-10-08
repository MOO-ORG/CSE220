# Topic 2: Arrays and Basic Data Structures
**Question Set: 35 Total Questions**

---

## Part A: Multiple Choice Questions (15 Questions)

### Easy Level (4 Questions)

**MCQ 1 (Easy)**
What is the time complexity of accessing an element at a specific index in an array?
A) O(n)
B) O(1)
C) O(log n)
D) O(n²)

**Answer: B) O(1)**

---

**MCQ 2 (Easy)**
In a zero-indexed array of size n, what is the valid range of indices?
A) 1 to n
B) 0 to n-1
C) 1 to n-1
D) 0 to n

**Answer: B) 0 to n-1**

---

**MCQ 3 (Easy)**
What happens when you try to access an array element beyond its bounds in Java?
A) Returns null
B) Returns 0
C) Throws ArrayIndexOutOfBoundsException
D) Creates a new element

**Answer: C) Throws ArrayIndexOutOfBoundsException**

---

**MCQ 4 (Easy)**
How much memory does an integer array of size 10 typically occupy in Java?
A) 10 bytes
B) 20 bytes
C) 40 bytes
D) 80 bytes

**Answer: C) 40 bytes (4 bytes per integer × 10 elements)**

---

### Medium Level (4 Questions)

**MCQ 5 (Medium)**
What is the time complexity of inserting an element at the beginning of an array?
A) O(1)
B) O(log n)
C) O(n)
D) O(n²)

**Answer: C) O(n) - All existing elements need to be shifted**

---

**MCQ 6 (Medium)**
In a circular array implementation, if the array has size 8, current index is 6, and we move 5 positions forward, what is the new index?
A) 11
B) 3
C) 4
D) 2

**Answer: B) 3 - (6 + 5) % 8 = 11 % 8 = 3**

---

**MCQ 7 (Medium)**
Which operation is most efficient in a dynamically resizing array (like ArrayList)?
A) Insertion at beginning
B) Deletion at beginning
C) Insertion at end (when space available)
D) Insertion at middle

**Answer: C) Insertion at end (when space available)**

---

**MCQ 8 (Medium)**
What is the space complexity of creating a 2D array of size m × n?
A) O(m + n)
B) O(m × n)
C) O(max(m, n))
D) O(m² + n²)

**Answer: B) O(m × n)**

---

### Hard Level (4 Questions)

**MCQ 9 (Hard)**
In a dynamic array that doubles in size when full, what is the amortized time complexity of insertion?
A) O(1)
B) O(log n)
C) O(n)
D) O(n log n)

**Answer: A) O(1) - Amortized analysis shows constant time per operation**

---

**MCQ 10 (Hard)**
For a sparse matrix with mostly zero values, which representation is most memory efficient?
A) 2D array
B) Array of arrays
C) Coordinate list (COO) format
D) Dense matrix representation

**Answer: C) Coordinate list (COO) format**

---

**MCQ 11 (Hard)**
What is the optimal approach to rotate an array of size n by k positions to the right?
A) Move each element one by one k times
B) Use extra array of size n
C) Reverse subarrays approach
D) Use nested loops

**Answer: C) Reverse subarrays approach (O(n) time, O(1) space)**

---

**MCQ 12 (Hard)**
In a circular buffer of size n, which condition indicates the buffer is full?
A) head == tail
B) (tail + 1) % n == head
C) tail - head == n
D) head - tail == 1

**Answer: B) (tail + 1) % n == head**

---

### Expert Level (3 Questions)

**MCQ 13 (Expert)**
What is the minimum number of comparisons needed to find both maximum and minimum elements in an array of n elements?
A) 2n - 2
B) 3n/2 - 2
C) n - 1
D) n

**Answer: B) 3n/2 - 2 (by comparing pairs first, then comparing winners/losers)**

---

**MCQ 14 (Expert)**
In a cache-friendly array traversal, which access pattern is most efficient for a row-major stored 2D array?
A) Column-wise traversal
B) Row-wise traversal
C) Diagonal traversal
D) Random access

**Answer: B) Row-wise traversal (better spatial locality)**

---

**MCQ 15 (Expert)**
For an array-based implementation of a circular queue with n elements, what is the most space-efficient way to distinguish between empty and full states?
A) Use a separate counter variable
B) Keep one slot empty
C) Use boolean flags
D) Store size separately

**Answer: A) Use a separate counter variable (allows all n slots to be used)**

---

## Part B: Code Snippet Questions (5 Questions)

### Code Snippet 1
```java
public void mystery(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n/2; i++) {
        int temp = arr[i];
        arr[i] = arr[n - 1 - i];
        arr[n - 1 - i] = temp;
    }
}
```
**Question:** What does this function do and what is its time complexity?

**Answer:** Reverses the array in-place. Time complexity: O(n), Space complexity: O(1)

---

### Code Snippet 2
```java
public int[] rotateRight(int[] arr, int k) {
    int n = arr.length;
    k = k % n;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
        result[(i + k) % n] = arr[i];
    }
    return result;
}
```
**Question:** What does this function accomplish and what is the space complexity?

**Answer:** Rotates array k positions to the right. Space complexity: O(n) for the new array.

---

### Code Snippet 3
```java
public boolean isCircularArrayEqual(int[] arr1, int[] arr2) {
    if (arr1.length != arr2.length) return false;
    
    String doubled = "";
    for (int x : arr1) doubled += x + ",";
    doubled += doubled;
    
    String pattern = "";
    for (int x : arr2) pattern += x + ",";
    
    return doubled.contains(pattern);
}
```
**Question:** What problem does this solve and what is its time complexity?

**Answer:** Checks if arr2 is a rotation of arr1. Time complexity: O(n²) due to string concatenation and contains() method.

---

### Code Snippet 4
```java
public void moveZeros(int[] nums) {
    int writeIndex = 0;
    for (int readIndex = 0; readIndex < nums.length; readIndex++) {
        if (nums[readIndex] != 0) {
            nums[writeIndex] = nums[readIndex];
            writeIndex++;
        }
    }
    while (writeIndex < nums.length) {
        nums[writeIndex] = 0;
        writeIndex++;
    }
}
```
**Question:** What does this algorithm do and what is its time and space complexity?

**Answer:** Moves all zeros to the end while maintaining order of non-zero elements. Time: O(n), Space: O(1).

---

### Code Snippet 5
```java
public int findDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        int index = Math.abs(nums[i]) - 1;
        if (nums[index] < 0) {
            return Math.abs(nums[i]);
        }
        nums[index] = -nums[index];
    }
    return -1;
}
```
**Question:** What does this algorithm find and what constraint must the input satisfy?

**Answer:** Finds a duplicate number in array. Input must contain numbers 1 to n with exactly one duplicate. Uses array indices as hash map.

---

## Part C: Problem Solving Questions (15 Questions)

### Easy Level (3 Questions)

**Problem 1 (Easy)**
Write a function that finds the second largest element in an integer array.

```java
public int findSecondLargest(int[] arr) {
    // Your implementation here
}
```

**Hint:** Keep track of largest and second largest while iterating through the array once.

---

**Problem 2 (Easy)**
Implement a function to check if an array is sorted in ascending order.

```java
public boolean isSorted(int[] arr) {
    // Your implementation here
}
```

**Hint:** Compare each element with the next one in a single pass.

---

**Problem 3 (Easy)**
Create a function that merges two sorted arrays into one sorted array.

```java
public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
    // Your implementation here
}
```

**Hint:** Use two pointers, one for each array, and compare elements to build the result.

---

### Medium Level (3 Questions)

**Problem 4 (Medium)**
Implement a function to rotate a 2D matrix 90 degrees clockwise in-place.

```java
public void rotate90Clockwise(int[][] matrix) {
    // Your implementation here
}
```

**Hint:** First transpose the matrix, then reverse each row. Or use layer-by-layer rotation.

---

**Problem 5 (Medium)**
Write a function that finds all pairs in an array that sum to a target value.

```java
public List<int[]> findPairsWithSum(int[] arr, int target) {
    // Your implementation here
}
```

**Hint:** Use HashMap to store complements, or sort array and use two pointers approach.

---

**Problem 6 (Medium)**
Implement a circular array class with basic operations (add, get, size).

```java
public class CircularArray<T> {
    // Your implementation here
    
    public void add(T item) { }
    public T get(int index) { }
    public int size() { }
}
```

**Hint:** Use modulo arithmetic to wrap indices. Keep track of actual size vs capacity.

---

### Hard Level (5 Questions)

**Problem 7 (Hard)**
Find the longest subarray with equal number of 0s and 1s.

```java
public int[] findLongestEqualSubarray(int[] arr) {
    // Return start and end indices of the longest subarray
}
```

**Hint:** Convert 0s to -1s and find longest subarray with sum 0 using prefix sums.

---

**Problem 8 (Hard)**
Implement an algorithm to find the kth largest element in an unsorted array.

```java
public int findKthLargest(int[] nums, int k) {
    // Your implementation here
}
```

**Hint:** Use QuickSelect algorithm (modified QuickSort) for O(n) average time complexity.

---

**Problem 9 (Hard)**
Given a 2D array where each row and column is sorted, search for a target efficiently.

```java
public boolean searchMatrix(int[][] matrix, int target) {
    // Your implementation here
}
```

**Hint:** Start from top-right or bottom-left corner. Use the sorted property to eliminate rows/columns.

---

**Problem 10 (Hard)**
Find all subarrays with sum equal to a given target.

```java
public List<List<Integer>> findSubarraysWithSum(int[] arr, int target) {
    // Your implementation here
}
```

**Hint:** Use prefix sums with HashMap. For each position, check if (currentSum - target) exists.

---

**Problem 11 (Hard)**
Implement rain water trapping: given heights, calculate trapped water.

```java
public int trapRainWater(int[] height) {
    // Your implementation here
}
```

**Hint:** Use two pointers or precompute max height to left and right of each position.

---

### Expert Level (4 Questions)

**Problem 12 (Expert)**
Design a data structure that supports insert, delete, and getRandom operations in O(1).

```java
public class RandomizedSet {
    // Your implementation here
    
    public boolean insert(int val) { }
    public boolean remove(int val) { }
    public int getRandom() { }
}
```

**Hint:** Use ArrayList for O(1) random access and HashMap for O(1) lookup. Handle removal by swapping with last element.

---

**Problem 13 (Expert)**
Find the minimum number of platforms needed for a railway station given arrival and departure times.

```java
public int findMinPlatforms(int[] arrivals, int[] departures) {
    // Your implementation here
}
```

**Hint:** Sort both arrays. Use two pointers to simulate events and track maximum overlapping intervals.

---

**Problem 14 (Expert)**
Implement a 2D range sum query data structure with O(1) query time.

```java
public class NumMatrix {
    public NumMatrix(int[][] matrix) { }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Return sum of rectangle from (row1,col1) to (row2,col2)
    }
}
```

**Hint:** Build 2D prefix sum array during construction. Use inclusion-exclusion principle for queries.

---

**Problem 15 (Expert)**
Given an array with duplicates, find the length of the longest arithmetic subsequence.

```java
public int longestArithmeticSubsequence(int[] arr) {
    // Your implementation here
}
```

**Hint:** Use dynamic programming with HashMap. For each pair of elements, track the longest sequence ending at current element with that difference.

---

## Summary
This question set covers fundamental array operations, multidimensional arrays, circular arrays, and advanced array manipulation techniques.

**Key Learning Objectives:**
- Array indexing and memory layout
- Time/space complexity of array operations
- Circular array implementations
- 2D array manipulations
- Advanced algorithmic techniques with arrays

**Total Questions: 35**
- MCQ: 15 (Easy: 4, Medium: 4, Hard: 4, Expert: 3)
- Code Snippet: 5 (with solutions)
- Problem Solving: 15 (Easy: 3, Medium: 3, Hard: 5, Expert: 4) - with hints only