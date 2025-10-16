**Big O Notation**

## 🧠 What Is Big O?

**Big O notation** is a way to **describe how fast an algorithm grows** — or how its running time (or space usage) increases as the size of the input increases.

It helps us answer questions like:

> “If I double the input size, how much longer will my program take?”

---

## 🧩 Why Do We Need Big O?

Let’s say you and your friend write two sorting algorithms.

* Yours sorts 1,000 numbers in **1 second**.
* Your friend’s sorts 1,000 numbers in **0.5 seconds**.

You might think your friend’s is better — but what if you try **1 million numbers**?

* Yours takes 10 seconds.
* Your friend’s takes 10 minutes.

Big O helps predict such behavior. It’s not about **actual time**, but about **how performance scales**.

---

## ⚙️ How We Measure

We measure the number of **basic operations** (like comparisons, additions, etc.) as the input size grows.

Let’s call the input size **n**.

So Big O describes performance as a **function of n**, like:

* **O(1)** → constant time
* **O(log n)** → logarithmic time
* **O(n)** → linear time
* **O(n log n)** → “n log n” time
* **O(n²)** → quadratic time
* **O(2ⁿ)** → exponential time
* **O(n!)** → factorial time (very slow)

---
# 🧭 How to Analyze Big O

Here’s how to reason step-by-step:

1. **Look for loops**

   * One loop → O(n)
   * Two nested loops → O(n²)

2. **Ignore constants**

   * O(2n) → O(n)

3. **Keep the highest order term**

   * O(n² + n) → O(n²)

4. **Think about input size**

   * A loop over 2D array → O(n × m)

---

## 🔍 Let’s See Examples



## 🧮 Example 1: Constant Time — **O(1)**

### Java

```java
void printFirst(int[] arr) {
    System.out.println(arr[0]);
}
```

### C++

```cpp
void printFirst(vector<int> arr) {
    cout << arr[0] << endl;
}
```

✅ No matter the size of `arr`, this always takes **one step**.

---

## 🧮 Example 2: Linear Time — **O(n)**

### Java

```java
void printAll(int[] arr) {
    for (int i : arr) {
        System.out.println(i);
    }
}
```

### C++

```cpp
void printAll(vector<int> arr) {
    for (int i : arr) {
        cout << i << endl;
    }
}
```

✅ The loop runs once for every element → **linear growth**.

---

## 🧮 Example 3: Quadratic Time — **O(n²)**

### Java

```java
void printPairs(int[] arr) {
    for (int i : arr) {
        for (int j : arr) {
            System.out.println(i + ", " + j);
        }
    }
}
```

### C++

```cpp
void printPairs(vector<int> arr) {
    for (int i : arr) {
        for (int j : arr) {
            cout << i << ", " << j << endl;
        }
    }
}
```

✅ Double nested loops → `n × n` → **O(n²)**

---

## 🧮 Example 4: Logarithmic Time — **O(log n)**

### Java

```java
int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1;
}
```

### C++

```cpp
int binarySearch(vector<int> arr, int target) {
    int low = 0, high = arr.size() - 1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1;
}
```

✅ Each step cuts the data in half → **O(log n)**

---

## 🧮 Example 5: n log n — **O(n log n)**

Typical for **efficient sorting** like Merge Sort or Quick Sort.

### Java (Merge Sort)

```java
void mergeSort(int[] arr) {
    if (arr.length <= 1) return;
    int mid = arr.length / 2;
    int[] left = Arrays.copyOfRange(arr, 0, mid);
    int[] right = Arrays.copyOfRange(arr, mid, arr.length);
    mergeSort(left);
    mergeSort(right);
    merge(arr, left, right);
}
```

✅ Each recursion divides (`log n`) and merges (`n`) → **O(n log n)**


---

## 🪜 How to Think About Growth

| Big O      | Input (n=10) | Input (n=100) | Relative Growth |
| ---------- | ------------ | ------------- | --------------- |
| O(1)       | 1            | 1             | Constant        |
| O(log n)   | 3            | 7             | Small growth    |
| O(n)       | 10           | 100           | Linear          |
| O(n log n) | 33           | 664           | Moderate        |
| O(n²)      | 100          | 10,000        | Large           |
| O(2ⁿ)      | 1,024        | 1.27×10³⁰     | Explodes!       |

---

## 🧭 Big O is About the **Worst Case**

When we say an algorithm is **O(n)**, we usually mean:

> “In the **worst case**, it will take time proportional to n.”

There are also:

* **Best case** (fastest)
* **Average case**
* **Worst case** (usually the one we care about)

---

## ⚖️ Space Complexity

Big O isn’t only about time.
It also measures **space (memory)** usage.

Example:

```java
int[] copyArray(int[] arr) {
    int[] newArr = Arrays.copyOf(arr, arr.length);
    return newArr;
}
```

➡ Extra array → **O(n)** space

→ Space complexity: **O(n)**

---

## 🧩 Common Big O Values to Remember

| Big O      | Name         | Example                    |
| ---------- | ------------ | -------------------------- |
| O(1)       | Constant     | Accessing an array element |
| O(log n)   | Logarithmic  | Binary search              |
| O(n)       | Linear       | Loop through list          |
| O(n log n) | Linearithmic | Merge sort                 |
| O(n²)      | Quadratic    | Nested loops               |
| O(2ⁿ)      | Exponential  | Recursive Fibonacci        |
| O(n!)      | Factorial    | Brute-force permutations   |

---

# ⚖️ Example Analysis

When analyzing code:

1. **Keep the largest term only**

   * O(n² + n) → **O(n²)**
2. **Ignore constants**

   * O(2n) → **O(n)**

Example:


```java
void example(int[] arr) {
    for (int i : arr) { // O(n)
        for (int j : arr) { // O(n)
            System.out.println(i + j);
        }
    }

    for (int k : arr) { // O(n)
        System.out.println(k);
    }
}
```

➡ Total = O(n² + n) = **O(n²)**

---

## 🧩 Practice Questions

Try these! (Answers below)

 What’s the Big O of these codes?


### 🧭 Q1

```java
void func1(int[] arr) {
    System.out.println(arr[0]);
}
```

### 🧭 Q2

```cpp
void func2(vector<int> arr) {
    for (int i : arr)
        cout << i << endl;
}
```

### 🧭 Q3

```java
void func3(int[] arr) {
    for (int i : arr)
        for (int j : arr)
            System.out.println(i + " " + j);
}
```

### 🧭 Q4

```cpp
void func4(vector<int> arr) {
    for (int i : arr)
        cout << i << endl;

    for (int i : arr)
        for (int j : arr)
            cout << i << ", " << j << endl;
}
```


### ✅ Answers

| Question | Big O     | Explanation          |
| -------- | --------- | -------------------- |
| Q1       | **O(1)**  | Constant work        |
| Q2       | **O(n)**  | One loop             |
| Q3       | **O(n²)** | Two nested loops     |
| Q4       | **O(n²)** | O(n) + O(n²) → O(n²) |

---


## 💡 Summary


## 🔍 Let’s Visualize the Growth

Imagine you have an input of size `n`.
Here’s roughly how many operations each complexity might take:

| n     | O(1) | O(log n) | O(n)  | O(n log n) | O(n²)     | O(2ⁿ)     | O(n!)              |
| ----- | ---- | -------- | ----- | ---------- | --------- | --------- | ------------------ |
| 10    | 1    | 3        | 10    | 33         | 100       | 1 024     | 3.6 million        |
| 100   | 1    | 7        | 100   | 664        | 10 000    | 1.27×10³⁰ | Too big to compute |
| 1 000 | 1    | 10       | 1 000 | 10 000     | 1 000 000 | 10³⁰⁰     | Unthinkable        |

💡 Notice:

* O(1) stays flat.
* O(log n) barely increases.
* O(n) grows steadily.
* O(n²), O(2ⁿ), and O(n!) blow up quickly.

---

## 🧠 Intuition Summary

| Type           | Behavior            | Typical Example                | Rule of Thumb                    |
| -------------- | ------------------- | ------------------------------ | -------------------------------- |
| **O(1)**       | Constant            | Access element                 | Super fast — ideal!              |
| **O(log n)**   | Divide & conquer    | Binary search                  | Excellent for large data.        |
| **O(n)**       | Straight loop       | Linear search                  | Fine for most programs.          |
| **O(n log n)** | Smart sorting       | Merge sort                     | Good for sorting big data.       |
| **O(n²)**      | Double loop         | Comparing all pairs            | OK only for small `n`.           |
| **O(2ⁿ)**      | Recursive explosion | Subset generation              | Avoid — grows too fast.          |
| **O(n!)**      | All permutations    | Traveling salesman brute force | Impractical — only for tiny `n`. |

---
#### Question ❓ 

you asked:

> When `n = 10`, for O(log n), the value is 3.
> Where does that “3” come from? What does it represent?

---

## 🧩 Step 1: What the Numbers Mean

These numbers don’t represent **time in seconds** or **actual operations** — they are **relative growth values**.

They show *how many basic steps* (like comparisons, loops, or recursive calls) an algorithm might perform, compared to other Big O classes, when the input size is `n`.

So it’s a **conceptual measure** of *how much work grows* — not an exact count.

---

## 🧩 Step 2: Why O(log n) ≈ 3 when n = 10

That “3” is roughly derived from the **logarithm of n** — usually using **base 2**, because many algorithms (like binary search) cut the data in half each step.

Let’s calculate it:

$$
\log_2(10) \approx 3.32
$$

That’s where the “3” came from!

So if your algorithm is O(log n), and `n = 10`, it means it takes about 3 steps (because each step halves the data):

* Start: 10 elements
* Step 1 → 5 elements
* Step 2 → 2–3 elements
* Step 3 → 1 element
  → ✅ Done in about 3 steps.

---

### 🔎 Another Example: n = 100

$$
\log_2(100) \approx 6.64
$$

→ So about **7 steps** to reduce 100 elements down to 1
(each step cutting the problem in half).

So that “7” in the chart for O(log n) at n = 100 comes from log₂(100).

---

## 🧩 Step 3: What About the Other Columns?

Let’s quickly interpret each column again for `n = 10`:

| Big O          | Meaning                  | What “value” roughly means     |
| -------------- | ------------------------ | ------------------------------ |
| **O(1)**       | Constant                 | Always 1 step, regardless of n |
| **O(log n)**   | Halves data each step    | log₂(10) ≈ 3 steps             |
| **O(n)**       | Processes every element  | 10 steps                       |
| **O(n log n)** | n × log₂(n)              | 10 × 3 = 30 (≈33 in table)     |
| **O(n²)**      | Nested loops             | 10 × 10 = 100                  |
| **O(2ⁿ)**      | Doubles work per element | 2¹⁰ = 1,024                    |
| **O(n!)**      | All permutations         | 10! = 3,628,800                |

---

## 🧠 Step 4: What These Numbers *Represent Conceptually*

These numbers represent **how many units of work** an algorithm might perform **in proportion to the input size**.

They don’t measure time directly (like milliseconds).
They help compare how quickly different algorithms “blow up” as n grows.

---

## 🔎 Example Intuition

Let’s say you have three algorithms to process an array of size 10:

| Algorithm | Big O    | Approx Steps | Time (if 1 step = 1 ms) |
| --------- | -------- | ------------ | ----------------------- |
| A         | O(1)     | 1            | 1 ms                    |
| B         | O(log n) | 3            | 3 ms                    |
| C         | O(n)     | 10           | 10 ms                   |

Now if you increase `n` to 1,000:

| Algorithm | Big O    | Approx Steps | Time (if 1 step = 1 ms) |
| --------- | -------- | ------------ | ----------------------- |
| A         | O(1)     | 1            | 1 ms                    |
| B         | O(log n) | 10           | 10 ms                   |
| C         | O(n)     | 1,000        | 1,000 ms (1 sec)        |

See how O(1) and O(log n) barely change, but O(n) grows 100×?

That’s the **power of Big O notation** — it tells you how performance *scales* as inputs grow.

---
