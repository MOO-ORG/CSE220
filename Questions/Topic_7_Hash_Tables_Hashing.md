# Topic 7: Hash Tables and Hashing
**Question Set: 35 Total Questions**

---

## Part A: Multiple Choice Questions (15 Questions)

### Easy Level (4 Questions)

**MCQ 1 (Easy)**
What is the average time complexity for search, insert, and delete operations in a hash table?
A) O(1)
B) O(log n)
C) O(n)
D) O(n²)

**Answer: A) O(1) - Constant time on average**

---

**MCQ 2 (Easy)**
What is a hash collision?
A) When the hash table runs out of space
B) When two different keys map to the same index
C) When a key is not found
D) When the hash function returns negative values

**Answer: B) When two different keys map to the same index**

---

**MCQ 3 (Easy)**
Which of the following is NOT a collision resolution technique?
A) Chaining
B) Linear probing
C) Quadratic probing
D) Binary search

**Answer: D) Binary search - This is a search algorithm, not collision resolution**

---

**MCQ 4 (Easy)**
What is the load factor of a hash table?
A) Number of collisions / table size
B) Number of elements / table size
C) Table size / number of elements
D) Number of successful searches / total searches

**Answer: B) Number of elements / table size**

---

### Medium Level (4 Questions)

**MCQ 5 (Medium)**
In separate chaining, what happens when the load factor becomes very high?
A) Hash table automatically resizes
B) Performance degrades to O(n) for operations
C) Collisions stop occurring
D) Memory usage decreases

**Answer: B) Performance degrades to O(n) for operations**

---

**MCQ 6 (Medium)**
Which probing technique has the best cache performance?
A) Linear probing
B) Quadratic probing
C) Double hashing
D) Random probing

**Answer: A) Linear probing - Better spatial locality**

---

**MCQ 7 (Medium)**
What is the main disadvantage of linear probing?
A) High memory usage
B) Poor worst-case performance
C) Primary clustering
D) Complex implementation

**Answer: C) Primary clustering - Consecutive occupied slots**

---

**MCQ 8 (Medium)**
When should a hash table be resized?
A) When load factor exceeds 0.75
B) When number of collisions is high
C) When search time becomes O(log n)
D) Both A and B are common criteria

**Answer: D) Both A and B are common criteria**

---

### Hard Level (4 Questions)

**MCQ 9 (Hard)**
What is the worst-case time complexity of operations in a hash table with chaining?
A) O(1)
B) O(log n)
C) O(n)
D) O(n log n)

**Answer: C) O(n) - When all elements hash to the same bucket**

---

**MCQ 10 (Hard)**
In double hashing, what should be the relationship between the two hash functions?
A) h2(k) should be 0 for some keys
B) h1(k) and h2(k) should be identical
C) h2(k) should be relatively prime to table size
D) h1(k) should depend on h2(k)

**Answer: C) h2(k) should be relatively prime to table size**

---

**MCQ 11 (Hard)**
What is the expected number of probes in unsuccessful search with linear probing (load factor α)?
A) 1 + α/2
B) (1 + 1/(1-α)²)/2
C) 1 + α²/2
D) log(1-α)

**Answer: B) (1 + 1/(1-α)²)/2**

---

**MCQ 12 (Hard)**
Which hash function property is most important for uniform distribution?
A) Deterministic
B) Avalanche effect
C) Fast computation
D) All of the above

**Answer: D) All of the above - All properties are important**

---

### Expert Level (3 Questions)

**MCQ 13 (Expert)**
In consistent hashing, what is the main advantage over traditional hashing?
A) Better worst-case performance
B) Minimal redistribution when servers are added/removed
C) Lower space complexity
D) Faster hash computation

**Answer: B) Minimal redistribution when servers are added/removed**

---

**MCQ 14 (Expert)**
What is the time complexity of rehashing n elements in a hash table?
A) O(1) amortized
B) O(log n)
C) O(n)
D) O(n²)

**Answer: C) O(n) - Must rehash all n elements, but amortized O(1) per operation**

---

**MCQ 15 (Expert)**
Which technique is used in Bloom filters to achieve space efficiency?
A) Perfect hashing
B) Multiple hash functions with bit array
C) Consistent hashing
D) Cuckoo hashing

**Answer: B) Multiple hash functions with bit array**

---

## Part B: Code Snippet Questions (5 Questions)

### Code Snippet 1
```java
public class SimpleHashTable {
    private Entry[] table;
    private int size;
    
    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = hash * 31 + key.charAt(i);
        }
        return Math.abs(hash % table.length);
    }
}
```
**Question:** What issue might occur with this hash function and how can it be prevented?

**Answer:** Integer overflow causing negative values. Use proper overflow handling or unsigned operations.

---

### Code Snippet 2
```java
public void put(String key, String value) {
    int index = hash(key);
    
    if (table[index] == null) {
        table[index] = new LinkedList<>();
    }
    
    for (Entry entry : table[index]) {
        if (entry.key.equals(key)) {
            entry.value = value;
            return;
        }
    }
    
    table[index].add(new Entry(key, value));
    size++;
}
```
**Question:** What collision resolution technique is being used here?

**Answer:** Separate chaining using linked lists at each bucket.

---

### Code Snippet 3
```java
public String get(String key) {
    int index = hash(key);
    int originalIndex = index;
    
    while (table[index] != null) {
        if (table[index].key.equals(key)) {
            return table[index].value;
        }
        index = (index + 1) % table.length;
        if (index == originalIndex) break;
    }
    return null;
}
```
**Question:** What probing technique is implemented and what problem does the originalIndex check solve?

**Answer:** Linear probing. The originalIndex check prevents infinite loops when the table is full.

---

### Code Snippet 4
```java
private void resize() {
    Entry[] oldTable = table;
    table = new Entry[table.length * 2];
    size = 0;
    
    for (Entry entry : oldTable) {
        if (entry != null) {
            put(entry.key, entry.value);
        }
    }
}
```
**Question:** Why is the size reset to 0 and what assumption does this code make about the table structure?

**Answer:** Size is reset because put() increments it. Assumes open addressing (one entry per slot), not chaining.

---

### Code Snippet 5
```java
public class BloomFilter {
    private boolean[] bitArray;
    private int numHashFunctions;
    
    public void add(String item) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = hash(item, i);
            bitArray[hash % bitArray.length] = true;
        }
    }
    
    public boolean mightContain(String item) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = hash(item, i);
            if (!bitArray[hash % bitArray.length]) {
                return false;
            }
        }
        return true;
    }
}
```
**Question:** What are the characteristics of this data structure's false positive and false negative rates?

**Answer:** Can have false positives (says item exists when it doesn't) but never false negatives (never misses actual items).

---

## Part C: Problem Solving Questions (15 Questions)

### Easy Level (3 Questions)

**Problem 1 (Easy)**
Implement a simple hash table with separate chaining.

```java
public class HashTableChaining {
    private LinkedList<Entry>[] table;
    
    public void put(String key, String value) { }
    public String get(String key) { }
    public boolean remove(String key) { }
}
```

**Hint:** Use array of LinkedLists. Handle collisions by adding to the appropriate list.

---

**Problem 2 (Easy)**
Design a hash function for strings that distributes keys uniformly.

```java
public int hashString(String key, int tableSize) {
    // Create a good hash function for string keys
}
```

**Hint:** Use polynomial rolling hash: hash = (hash * prime + char) % tableSize. Consider overflow handling.

---

**Problem 3 (Easy)**
Implement a method to check if two strings are anagrams using hashing.

```java
public boolean areAnagrams(String s1, String s2) {
    // Use hash-based approach to check if strings are anagrams
}
```

**Hint:** Count character frequencies using HashMap or use character sum with prime weights.

---

### Medium Level (3 Questions)

**Problem 4 (Medium)**
Implement a hash table with linear probing.

```java
public class HashTableLinearProbing {
    private Entry[] table;
    private boolean[] deleted;
    
    public void put(String key, String value) { }
    public String get(String key) { }
    public boolean remove(String key) { }
}
```

**Hint:** Use deleted array to mark removed entries. Continue probing through deleted slots during search.

---

**Problem 5 (Medium)**
Design a LRU Cache using HashMap and doubly linked list.

```java
public class LRUCache {
    public LRUCache(int capacity) { }
    
    public int get(int key) { }
    public void put(int key, int value) { }
}
```

**Hint:** HashMap for O(1) access, doubly linked list for O(1) insertion/deletion. Move accessed nodes to head.

---

**Problem 6 (Medium)**
Find the first non-repeating character in a string using hashing.

```java
public char firstNonRepeatingChar(String s) {
    // Return first character that appears exactly once
}
```

**Hint:** Use HashMap to count character frequencies, then iterate through string to find first with count 1.

---

### Hard Level (5 Questions)

**Problem 7 (Hard)**
Implement a hash table with quadratic probing.

```java
public class HashTableQuadraticProbing {
    public void put(String key, String value) { }
    public String get(String key) { }
    public boolean remove(String key) { }
    
    private int probe(String key, int attempt) {
        // Implement quadratic probing formula
    }
}
```

**Hint:** Use probe sequence: (hash + attempt²) % tableSize. Ensure table size is prime or power of 2.

---

**Problem 8 (Hard)**
Design a system to find all anagram groups in an array of strings.

```java
public List<List<String>> groupAnagrams(String[] strs) {
    // Group strings that are anagrams of each other
}
```

**Hint:** Use sorted string as key in HashMap. All anagrams will have the same sorted representation.

---

**Problem 9 (Hard)**
Implement a hash table that automatically resizes based on load factor.

```java
public class DynamicHashTable {
    private static final double MAX_LOAD_FACTOR = 0.75;
    
    private void resize() { }
    private boolean needsResize() { }
}
```

**Hint:** Monitor load factor after each insertion. When exceeded, double table size and rehash all elements.

---

**Problem 10 (Hard)**
Design a data structure to detect duplicate URLs with memory constraints.

```java
public class DuplicateURLDetector {
    public boolean isDuplicate(String url) {
        // Detect if URL has been seen before, optimized for space
    }
}
```

**Hint:** Use Bloom filter for space efficiency. Accept small false positive rate for memory savings.

---

**Problem 11 (Hard)**
Implement Robin Hood hashing for better performance.

```java
public class RobinHoodHashTable {
    private Entry[] table;
    private int[] distances; // Distance from ideal position
    
    public void put(String key, String value) { }
    public String get(String key) { }
}
```

**Hint:** Track how far each element is from its ideal position. Swap with elements that are closer to their ideal spot.

---

### Expert Level (4 Questions)

**Problem 12 (Expert)**
Implement consistent hashing for distributed systems.

```java
public class ConsistentHashing {
    public void addServer(String server) { }
    public void removeServer(String server) { }
    public String getServer(String key) { }
}
```

**Hint:** Use TreeMap to maintain sorted ring of hash values. Map keys to first server clockwise on the ring.

---

**Problem 13 (Expert)**
Design a Bloom filter with configurable false positive rate.

```java
public class BloomFilter {
    public BloomFilter(int expectedElements, double falsePositiveRate) { }
    
    public void add(String item) { }
    public boolean mightContain(String item) { }
}
```

**Hint:** Calculate optimal bit array size and number of hash functions based on expected elements and desired false positive rate.

---

**Problem 14 (Expert)**
Implement Cuckoo hashing with two hash functions.

```java
public class CuckooHashTable {
    private String[] table1, table2;
    private final int MAX_ITERATIONS = 10;
    
    public boolean put(String key) { }
    public boolean contains(String key) { }
}
```

**Hint:** If collision occurs, evict existing element and try to place it in alternate table. Rehash if too many evictions.

---

**Problem 15 (Expert)**
Design a distributed hash table (DHT) with fault tolerance.

```java
public class DistributedHashTable {
    public void put(String key, String value) { }
    public String get(String key) { }
    public void handleNodeFailure(String nodeId) { }
    public void addNode(String nodeId) { }
}
```

**Hint:** Use consistent hashing with virtual nodes. Implement replication and redistribution when nodes join/leave.

---

## Summary
This question set covers hash table fundamentals, advanced collision resolution techniques, and real-world applications.

**Key Learning Objectives:**
- Understanding hash functions and their properties
- Mastering collision resolution techniques
- Analyzing performance characteristics and trade-offs
- Implementing advanced hashing schemes
- Applying hashing to solve complex problems

**Hash Table Variants Covered:**
- **Collision Resolution**: Chaining, Linear/Quadratic Probing, Double Hashing
- **Advanced Techniques**: Robin Hood Hashing, Cuckoo Hashing
- **Distributed Systems**: Consistent Hashing, DHT
- **Specialized Structures**: Bloom Filters, Count-Min Sketch

**Real-world Applications:**
- **Caching**: LRU Cache implementation
- **Databases**: Index structures, query optimization
- **Distributed Systems**: Load balancing, data partitioning  
- **Web Systems**: URL deduplication, session management
- **Security**: Password hashing, data integrity

**Performance Analysis Focus:**
- **Load Factor**: Impact on performance and space usage
- **Hash Function Quality**: Distribution and collision minimization
- **Amortized Analysis**: Cost of dynamic resizing
- **Space-Time Tradeoffs**: Bloom filters vs exact structures

**Total Questions: 35**
- MCQ: 15 (Easy: 4, Medium: 4, Hard: 4, Expert: 3)
- Code Snippet: 5 (with solutions)
- Problem Solving: 15 (Easy: 3, Medium: 3, Hard: 5, Expert: 4) - with hints only