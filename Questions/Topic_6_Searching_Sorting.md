# Topic 6: Searching and Sorting
**Question Set: 35 Total Questions**

---

## Part A: Multiple Choice Questions (15 Questions)

### Easy Level (4 Questions)

**MCQ 1 (Easy)**
What is the time complexity of linear search in an unsorted array?
A) O(1)
B) O(log n)
C) O(n)
D) O(n²)

**Answer: C) O(n) - May need to check all elements**

---

**MCQ 2 (Easy)**
Which sorting algorithm is considered the simplest but least efficient?
A) Quick Sort
B) Merge Sort
C) Bubble Sort
D) Heap Sort

**Answer: C) Bubble Sort**

---

**MCQ 3 (Easy)**
What is the prerequisite for binary search to work correctly?
A) Array must be sorted
B) Array must be unsorted
C) Array must have even number of elements
D) Array must contain only positive numbers

**Answer: A) Array must be sorted**

---

**MCQ 4 (Easy)**
What is the time complexity of binary search?
A) O(1)
B) O(log n)
C) O(n)
D) O(n log n)

**Answer: B) O(log n)**

---

### Medium Level (4 Questions)

**MCQ 5 (Medium)**
Which sorting algorithm has the best worst-case time complexity?
A) Quick Sort
B) Merge Sort
C) Selection Sort
D) Insertion Sort

**Answer: B) Merge Sort - O(n log n) in all cases**

---

**MCQ 6 (Medium)**
What is the average time complexity of Quick Sort?
A) O(n)
B) O(n log n)
C) O(n²)
D) O(log n)

**Answer: B) O(n log n)**

---

**MCQ 7 (Medium)**
Which sorting algorithm is most suitable for sorting a small, nearly sorted array?
A) Quick Sort
B) Merge Sort
C) Insertion Sort
D) Heap Sort

**Answer: C) Insertion Sort - O(n) for nearly sorted data**

---

**MCQ 8 (Medium)**
In counting sort, what determines the space complexity?
A) Number of elements (n)
B) Range of input values (k)
C) Both n and k
D) Neither n nor k

**Answer: C) Both n and k - O(n + k) space**

---

### Hard Level (4 Questions)

**MCQ 9 (Hard)**
What is the minimum number of comparisons needed to sort n elements in the worst case?
A) n
B) n log n
C) n(n-1)/2
D) 2^n

**Answer: B) n log n - Lower bound for comparison-based sorting**

---

**MCQ 10 (Hard)**
Which statement about stable sorting algorithms is correct?
A) They maintain the relative order of equal elements
B) They always have O(n log n) complexity
C) They require extra space
D) They cannot be implemented in-place

**Answer: A) They maintain the relative order of equal elements**

---

**MCQ 11 (Hard)**
What is the space complexity of the standard implementation of merge sort?
A) O(1)
B) O(log n)
C) O(n)
D) O(n²)

**Answer: C) O(n) - Requires auxiliary arrays for merging**

---

**MCQ 12 (Hard)**
In interpolation search, what is the expected time complexity for uniformly distributed data?
A) O(1)
B) O(log log n)
C) O(log n)
D) O(n)

**Answer: B) O(log log n)**

---

### Expert Level (3 Questions)

**MCQ 13 (Expert)**
Which sorting algorithm has the best space complexity while maintaining O(n log n) time complexity?
A) Merge Sort
B) Quick Sort (with optimization)
C) Heap Sort
D) Radix Sort

**Answer: C) Heap Sort - O(1) space, O(n log n) time**

---

**MCQ 14 (Expert)**
What is the time complexity of finding the kth smallest element using Quickselect algorithm on average?
A) O(k)
B) O(log k)
C) O(n)
D) O(n log n)

**Answer: C) O(n) - Linear expected time**

---

**MCQ 15 (Expert)**
In external sorting, what is the primary consideration?
A) Time complexity
B) Space complexity
C) I/O operations minimization
D) Code simplicity

**Answer: C) I/O operations minimization**

---

## Part B: Code Snippet Questions (5 Questions)

### Code Snippet 1
```java
public int search(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}
```
**Question:** What type of search is this and what is its space complexity?

**Answer:** Linear/Sequential search. Space complexity: O(1).

---

### Code Snippet 2
```java
public void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // swap
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }
        if (!swapped) break;
    }
}
```
**Question:** What optimization is implemented here and how does it improve best-case complexity?

**Answer:** Early termination when no swaps occur. Improves best-case from O(n²) to O(n) for sorted arrays.

---

### Code Snippet 3
```java
public int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
    
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    
    return i + 1;
}
```
**Question:** This is part of which sorting algorithm and what does the return value represent?

**Answer:** Quick Sort partition function. Returns the final position of the pivot element after partitioning.

---

### Code Snippet 4
```java
public void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    
    int[] L = new int[n1];
    int[] R = new int[n2];
    
    for (int i = 0; i < n1; i++)
        L[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
        R[j] = arr[mid + 1 + j];
    
    int i = 0, j = 0, k = left;
    
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}
```
**Question:** What algorithm uses this merge function and why is <= used instead of <?

**Answer:** Merge Sort. Uses <= to ensure stability - equal elements maintain their relative order.

---

### Code Snippet 5
```java
public int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) return mid;
        
        if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}
```
**Question:** Why is `left + (right - left) / 2` used instead of `(left + right) / 2`?

**Answer:** Prevents integer overflow when left + right exceeds Integer.MAX_VALUE.

---

## Part C: Problem Solving Questions (15 Questions)

### Easy Level (3 Questions)

**Problem 1 (Easy)**
Implement selection sort algorithm.

```java
public void selectionSort(int[] arr) {
    // Sort array by repeatedly finding minimum element
}
```

**Hint:** For each position, find the minimum element in remaining array and swap it to current position.

---

**Problem 2 (Easy)**
Write a function to find the first and last occurrence of a target in a sorted array.

```java
public int[] searchRange(int[] nums, int target) {
    // Return [first_occurrence, last_occurrence] or [-1, -1]
}
```

**Hint:** Use binary search twice - once for leftmost occurrence and once for rightmost occurrence.

---

**Problem 3 (Easy)**
Implement insertion sort algorithm.

```java
public void insertionSort(int[] arr) {
    // Sort by inserting each element into its correct position
}
```

**Hint:** Start from second element, insert each element into its correct position in the sorted portion.

---

### Medium Level (3 Questions)

**Problem 4 (Medium)**
Implement binary search to find the square root of a number.

```java
public int mySqrt(int x) {
    // Find floor of square root using binary search
}
```

**Hint:** Search between 0 and x/2. Check if mid*mid equals, exceeds, or is less than x.

---

**Problem 5 (Medium)**
Find the peak element in an array (element greater than its neighbors).

```java
public int findPeakElement(int[] nums) {
    // Find any peak element index using binary search
}
```

**Hint:** If mid element is greater than next element, peak lies in left half; otherwise in right half.

---

**Problem 6 (Medium)**
Implement merge sort algorithm.

```java
public void mergeSort(int[] arr, int left, int right) {
    // Sort array using divide and conquer approach
}
```

**Hint:** Divide array into halves, recursively sort both halves, then merge the sorted halves.

---

### Hard Level (5 Questions)

**Problem 7 (Hard)**
Find the median of two sorted arrays.

```java
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // Find median in O(log(min(m,n))) time
}
```

**Hint:** Use binary search on the smaller array. Partition both arrays such that left half has equal elements as right half.

---

**Problem 8 (Hard)**
Implement quick sort with random pivot selection.

```java
public void quickSort(int[] arr, int low, int high) {
    // Sort using quick sort with randomized pivot
}
```

**Hint:** Choose random pivot to avoid worst-case performance on sorted arrays. Partition around pivot and recurse.

---

**Problem 9 (Hard)**
Search in a rotated sorted array.

```java
public int search(int[] nums, int target) {
    // Find target in rotated sorted array using binary search
}
```

**Hint:** One half will always be sorted. Determine which half is sorted and whether target lies in that half.

---

**Problem 10 (Hard)**
Find the kth largest element in an unsorted array.

```java
public int findKthLargest(int[] nums, int k) {
    // Find kth largest element efficiently
}
```

**Hint:** Use QuickSelect algorithm (like QuickSort but only recurse on one side) for O(n) average time.

---

**Problem 11 (Hard)**
Implement counting sort for integers in a given range.

```java
public void countingSort(int[] arr, int maxValue) {
    // Sort using counting approach for bounded integers
}
```

**Hint:** Count frequency of each value, then reconstruct sorted array using cumulative counts.

---

### Expert Level (4 Questions)

**Problem 12 (Expert)**
Implement radix sort for positive integers.

```java
public void radixSort(int[] arr) {
    // Sort using digit-by-digit approach
}
```

**Hint:** Sort by each digit position using stable counting sort, starting from least significant digit.

---

**Problem 13 (Expert)**
Design an algorithm to find all elements that appear more than n/3 times.

```java
public List<Integer> majorityElement(int[] nums) {
    // Find all majority elements (appearing > n/3 times)
}
```

**Hint:** Use Boyer-Moore majority vote algorithm extended for n/3. At most 2 elements can appear > n/3 times.

---

**Problem 14 (Expert)**
Implement external merge sort for files too large to fit in memory.

```java
public void externalMergeSort(String inputFile, String outputFile, int memorySize) {
    // Sort large file using limited memory
}
```

**Hint:** Create sorted runs that fit in memory, then merge runs using k-way merge with priority queue.

---

**Problem 15 (Expert)**
Find the smallest missing positive integer in an unsorted array.

```java
public int firstMissingPositive(int[] nums) {
    // Find smallest positive integer not in array, O(n) time, O(1) space
}
```

**Hint:** Use array indices as hash map. Place each positive number x at index x-1. Then find first index with wrong value.

---

## Summary
This question set covers fundamental to advanced searching and sorting concepts with practical implementations.

**Key Learning Objectives:**
- Understanding various searching algorithms and their applications
- Mastering different sorting techniques and their trade-offs
- Analyzing time and space complexities
- Implementing efficient algorithms for specific constraints
- Understanding stability and adaptability in sorting

**Algorithm Categories Covered:**
- **Searching**: Linear, Binary, Interpolation, Exponential
- **Simple Sorts**: Bubble, Selection, Insertion
- **Efficient Sorts**: Quick, Merge, Heap
- **Non-comparison Sorts**: Counting, Radix, Bucket
- **Specialized**: External sorting, Partial sorting

**Key Concepts:**
- **Stability**: Maintaining relative order of equal elements
- **Adaptability**: Performance improvement on partially sorted data
- **In-place**: Sorting without extra space
- **Divide-and-conquer**: Breaking problems into smaller subproblems
- **Lower bounds**: Theoretical limits of comparison-based sorting

**Total Questions: 35**
- MCQ: 15 (Easy: 4, Medium: 4, Hard: 4, Expert: 3)
- Code Snippet: 5 (with solutions)
- Problem Solving: 15 (Easy: 3, Medium: 3, Hard: 5, Expert: 4) - with hints only