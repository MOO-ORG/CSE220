# Sorting Algorithms

## 1. Bubble Sort

### Basic Implementation

```java
import java.util.Arrays;

class Main {
  // perform the bubble sort
  static void bubbleSort(int array[]) {
    int size = array.length;
    
    // loop to access each array element
    for (int i = 0; i < size - 1; i++)
    
      // loop to compare array elements
      for (int j = 0; j < size - i - 1; j++)

        // compare two adjacent elements
        // change > to < to sort in descending order
        if (array[j] > array[j + 1]) {
          // swapping occurs if elements are not in the intended order
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
  }

  public static void main(String args[]) {
    int[] data = { -2, 45, 0, 11, -9 };
    
    // call method using class name
    Main.bubbleSort(data);
    
    System.out.println("Sorted Array in Ascending Order:");
    System.out.println(Arrays.toString(data));
  }
}
```

### Optimized Implementation

```java
import java.util.Arrays;

class Main {
  // perform the bubble sort
  static void bubbleSort(int array[]) {
    int size = array.length;
    
    // loop to access each array element
    for (int i = 0; i < (size-1); i++) {
      // check if swapping occurs
      boolean swapped = false;
      
      // loop to compare adjacent elements
      for (int j = 0; j < (size-i-1); j++) {
        // compare two array elements
        // change > to < to sort in descending order
        if (array[j] > array[j + 1]) {
          // swapping occurs if elements are not in the intended order
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          swapped = true;
        }
      }
      
      // no swapping means the array is already sorted
      // so no need for further comparison
      if (!swapped)
        break;
    }
  }

  public static void main(String args[]) {
    int[] data = { -2, 45, 0, 11, -9 };
    
    // call method using the class name
    Main.bubbleSort(data);
    
    System.out.println("Sorted Array in Ascending Order:");
    System.out.println(Arrays.toString(data));
  }
}
```

### Bubble Sort Complexity

| Complexity | Value |
|------------|-------|
| **Time Complexity (Best)** | O(n) |
| **Time Complexity (Worst)** | O(n²) |
| **Time Complexity (Average)** | O(n²) |
| **Space Complexity** | O(1) |
| **Stability** | Yes |

### Complexity Analysis

Bubble Sort compares adjacent elements in each pass.

| Cycle | Number of Comparisons |
|-------|----------------------|
| 1st   | (n-1) |
| 2nd   | (n-2) |
| 3rd   | (n-3) |
| ...   | ... |
| last  | 1 |

**Total Comparisons:**
- $(n-1) + (n-2) + (n-3) + ... + 1 = \frac{n(n-1)}{2} \approx n^2$
- **Complexity:** $O(n^2)$

The algorithm requires two nested loops, hence: $n \times n = n^2$

#### Time Complexities

- **Worst Case:** $O(n^2)$
  - Occurs when sorting in ascending order but the array is in descending order
- **Best Case:** $O(n)$
  - Occurs when the array is already sorted (optimized version)
- **Average Case:** $O(n^2)$
  - Occurs when elements are in random order

#### Space Complexity

- **Space:** $O(1)$ - Only uses extra variables for swapping
- In the optimized version: $O(2)$ (two extra variables: `temp` and `swapped`)

---
---

## 2. Selection Sort

### Implementation

```java
static void selectionSort(int arr[]) {
  int n = arr.length;
  
  for (int i = 0; i < n - 1; i++) {
    // Find minimum element in unsorted portion
    int min_idx = i;
    
    for (int j = i + 1; j < n; j++) {
      if (arr[j] < arr[min_idx]) {
        min_idx = j;
      }
    }
    
    // Swap minimum element with first element of unsorted portion
    int temp = arr[i];
    arr[i] = arr[min_idx];
    arr[min_idx] = temp;
  }
}
```

### Selection Sort Complexity

| Complexity | Value |
|------------|-------|
| **Time Complexity (Best)** | O(n²) |
| **Time Complexity (Worst)** | O(n²) |
| **Time Complexity (Average)** | O(n²) |
| **Space Complexity** | O(1) |
| **Stability** | No |

### Complexity Analysis

| Cycle | Number of Comparisons |
|-------|----------------------|
| 1st   | (n-1) |
| 2nd   | (n-2) |
| 3rd   | (n-3) |
| ...   | ... |
| last  | 1 |

**Total Comparisons:**
- $(n-1) + (n-2) + (n-3) + ... + 1 = \frac{n(n-1)}{2} \approx n^2$
- **Complexity:** $O(n^2)$

The algorithm has 2 nested loops, hence: $n \times n = n^2$

#### Time Complexities

- **Worst Case:** $O(n^2)$
  - Occurs when sorting in ascending order but the array is in descending order
- **Best Case:** $O(n^2)$
  - Occurs even when the array is already sorted (always searches for minimum)
- **Average Case:** $O(n^2)$
  - Occurs when elements are in random order

**Note:** Selection sort has the same time complexity in all cases because it always searches through the entire unsorted portion to find the minimum element, regardless of the initial order.

#### Space Complexity

- **Space:** $O(1)$ - Only uses one extra variable (`min_idx`) for tracking the minimum element index
