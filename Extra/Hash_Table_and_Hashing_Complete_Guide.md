# 🗂️ Hash Table and Hashing - Complete Learning Guide

## 📚 Table of Contents
1. [Foundation Building](#-foundation-building)
2. [Theory Section](#-theory-section)
3. [Code Implementation](#-code-implementation)
4. [Practical Exercises](#-practical-exercises)
5. [Deep Dive Analysis](#-deep-dive-analysis)
6. [Real-World Applications](#-real-world-applications)
7. [Summary & Cheat Sheet](#-summary--cheat-sheet)

---

## 📚 FOUNDATION BUILDING

### 🤔 What is a Hash Table?

Imagine you're organizing a massive library with millions of books. Instead of placing books randomly on shelves and searching through every single one when someone asks for a book, you create a smart system:

- You give each book a unique "address" based on its title
- Using this address, you can instantly know exactly which shelf and position the book is in
- When someone wants "Harry Potter," you don't search through millions of books - you calculate its address and go directly to it

A **Hash Table** (also called Hash Map) is exactly this smart library system, but for data in computer programs. It's a way to store and find information instantly.

### 🔑 Key Definitions:
- **Hash Table**: A data structure that maps keys to values using a hash function
- **Key**: The identifier used to store/retrieve data (like a book title)
- **Value**: The actual data being stored (like the book itself)
- **Hash Function**: A formula that converts keys into array indices
- **Bucket**: A storage location in the hash table
- **Collision**: When two different keys hash to the same location
- **Load Factor**: Ratio of stored items to total capacity

### 🎯 Why Do Hash Tables Exist?

**Problems Hash Tables Solve:**
1. **Slow search in arrays** - O(n) time to find an item
2. **Inefficient lookups** - having to check every element
3. **Need for fast insertion and deletion** - O(1) operations
4. **Memory vs Speed tradeoff** - using more memory for faster access

**Real-World Analogies:**

1. **Phone Book** 📞:
   - Name = Key
   - Phone Number = Value
   - Instead of reading every page, you jump to the right section instantly

2. **Library Card Catalog** 📚:
   - Book Title = Key  
   - Shelf Location = Value
   - Card catalog lets you find books without wandering the aisles

3. **Dictionary** 📖:
   - Word = Key
   - Definition = Value
   - Alphabetical organization lets you jump to the right page

4. **Parking Garage** 🅿️:
   - License Plate = Key
   - Parking Spot = Value
   - Electronic system tells you exactly where you parked

### 🆚 Hash Table vs Other Data Structures

| Data Structure | Search | Insert | Delete | Space |
|----------------|--------|--------|--------|-------|
| **Hash Table** | O(1)* | O(1)* | O(1)* | O(n) |
| Array (unsorted) | O(n) | O(1) | O(n) | O(n) |
| Array (sorted) | O(log n) | O(n) | O(n) | O(n) |
| Linked List | O(n) | O(1) | O(n) | O(n) |
| Binary Search Tree | O(log n) | O(log n) | O(log n) | O(n) |

*Average case - worst case can be O(n)

---

## 🏗️ THEORY SECTION

### 🔢 How Hash Functions Work

A hash function is like a magical formula that converts any key into a number (array index).

#### **Simple Hash Function Example:**
```
hash(key) = key % table_size

Example:
- Table size: 10
- Key: 25
- hash(25) = 25 % 10 = 5
- Store value at index 5
```

#### **Visual Example:**
```
Keys: [23, 45, 17, 38, 29]
Table size: 10

hash(23) = 23 % 10 = 3
hash(45) = 45 % 10 = 5  
hash(17) = 17 % 10 = 7
hash(38) = 38 % 10 = 8
hash(29) = 29 % 10 = 9

Hash Table:
Index: 0  1  2  3   4  5   6  7   8   9
Value: -  -  -  23  -  45  -  17  38  29
```

### 🎲 Types of Hash Functions

#### 1. **Division Method** ➗
```
hash(key) = key % m
```
- Simple and fast
- m should be prime number
- Works well when keys are uniformly distributed

#### 2. **Multiplication Method** ✖️
```
hash(key) = floor(m * (key * A % 1))
where A is constant (0 < A < 1)
```
- More complex but better distribution
- A = (√5 - 1)/2 ≈ 0.6180339887 (golden ratio) works well

#### 3. **String Hash Functions** 🔤
For string keys like names:
```java
// Simple string hash
public int hash(String key) {
    int hash = 0;
    for (char c : key.toCharArray()) {
        hash += c;  // Add ASCII values
    }
    return hash % tableSize;
}

// Better polynomial hash
public int hash(String key) {
    int hash = 0;
    int base = 31;  // Prime number
    for (char c : key.toCharArray()) {
        hash = hash * base + c;
    }
    return Math.abs(hash) % tableSize;
}
```

### 💥 Collision Handling

**Collision**: When two different keys produce the same hash value.

#### **Example of Collision:**
```
Keys: 23 and 33, Table size: 10
hash(23) = 23 % 10 = 3
hash(33) = 33 % 10 = 3  ← COLLISION!
```

### 🔗 Collision Resolution Methods

#### 1. **Separate Chaining** (Linked Lists)

Each table slot contains a linked list of all items that hash to that location.

```
Hash Table with Chaining:
Index: 0   1   2   3        4   5   ...
Value: []  []  []  [23→33]  []  []  
```

**Pros:**
- ✅ Simple to implement
- ✅ No limit on number of items
- ✅ Good performance if chains stay short

**Cons:**
- ❌ Extra memory for pointers
- ❌ Poor cache performance
- ❌ Performance degrades if chains get long

#### 2. **Open Addressing** (Linear Probing)

When collision occurs, find the next empty slot.

```
Linear Probing Example:
Initial: [_, _, _, _, _, _, _, _, _, _]

Insert 23: hash(23) = 3
Result:  [_, _, _, 23, _, _, _, _, _, _]

Insert 33: hash(33) = 3 (collision!)
Try index 4: empty, so insert there
Result:  [_, _, _, 23, 33, _, _, _, _, _]

Insert 43: hash(43) = 3 (collision!)
Try index 4: occupied
Try index 5: empty, so insert there  
Result:  [_, _, _, 23, 33, 43, _, _, _, _]
```

**Probing Strategies:**
- **Linear**: Check next slot (index + 1)
- **Quadratic**: Check slots at quadratic distances (index + 1², index + 2²)
- **Double Hashing**: Use second hash function for step size

### 📊 Load Factor and Resizing

**Load Factor** = Number of items / Table size

```
Examples:
- 7 items in table of size 10: Load factor = 0.7
- 15 items in table of size 10: Load factor = 1.5
```

**Guidelines:**
- **Separate Chaining**: Keep load factor < 1.0
- **Open Addressing**: Keep load factor < 0.75

**Resizing Process:**
1. Create new table (usually 2x size)
2. Rehash all existing items into new table
3. Replace old table with new table

### ❌ Common Misconceptions

1. **"Hash tables are always O(1)"** ❌
   - Average case is O(1), worst case can be O(n)
   - Bad hash function or high load factor can cause problems

2. **"Any function can be a hash function"** ❌
   - Hash functions should distribute keys uniformly
   - Bad distribution leads to many collisions

3. **"Bigger table is always better"** ❌
   - Larger tables use more memory
   - Empty tables waste space
   - Load factor balance is key

4. **"Hash tables maintain insertion order"** ❌
   - Hash tables don't preserve order (unless specifically designed to)
   - Use LinkedHashMap in Java if order matters

---

## 💻 CODE IMPLEMENTATION

### 🏗️ Basic Hash Table with Separate Chaining

```java
import java.util.*;

public class HashTableChaining<K, V> {
    // Inner class for key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;  // For chaining
        
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private Entry<K, V>[] table;  // Array of entry chains
    private int size;             // Number of key-value pairs
    private int capacity;         // Size of the table
    private static final int DEFAULT_CAPACITY = 16;
    private static final double MAX_LOAD_FACTOR = 0.75;
    
    // Constructor
    @SuppressWarnings("unchecked")
    public HashTableChaining() {
        this.capacity = DEFAULT_CAPACITY;
        this.table = new Entry[capacity];
        this.size = 0;
    }
    
    @SuppressWarnings("unchecked")
    public HashTableChaining(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
        this.size = 0;
    }
    
    // Hash function
    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        
        // Use Java's hashCode() and ensure positive result
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }
    
    // Put method - insert or update key-value pair
    public V put(K key, V value) {
        int index = hash(key);
        Entry<K, V> current = table[index];
        
        // Check if key already exists in the chain
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                // Key exists, update value and return old value
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }
        
        // Key doesn't exist, add new entry at beginning of chain
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = table[index];  // Point to current head
        table[index] = newEntry;       // Make new entry the head
        size++;
        
        // Check if resize is needed
        if (getLoadFactor() > MAX_LOAD_FACTOR) {
            resize();
        }
        
        return null;  // No previous value
    }
    
    // Get method - retrieve value by key
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];
        
        // Search through the chain
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }
        
        return null;  // Key not found
    }
    
    // Remove method - delete key-value pair
    public V remove(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];
        Entry<K, V> previous = null;
        
        // Search for the key
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                // Found the key, remove it
                if (previous == null) {
                    // Removing head of chain
                    table[index] = current.next;
                } else {
                    // Removing middle or end of chain
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        
        return null;  // Key not found
    }
    
    // Check if key exists
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    
    // Get current size
    public int size() {
        return size;
    }
    
    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Get load factor
    public double getLoadFactor() {
        return (double) size / capacity;
    }
    
    // Resize the hash table
    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldTable = table;
        int oldCapacity = capacity;
        
        // Double the capacity
        capacity = oldCapacity * 2;
        table = new Entry[capacity];
        size = 0;  // Will be recounted during rehashing
        
        // Rehash all existing entries
        for (int i = 0; i < oldCapacity; i++) {
            Entry<K, V> current = oldTable[i];
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
        
        System.out.println("Resized hash table to capacity: " + capacity);
    }
    
    // Get all keys
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            Entry<K, V> current = table[i];
            while (current != null) {
                keys.add(current.key);
                current = current.next;
            }
        }
        return keys;
    }
    
    // Print hash table structure (for debugging)
    public void printTable() {
        System.out.println("Hash Table (Size: " + size + ", Capacity: " + capacity + 
                          ", Load Factor: " + String.format("%.2f", getLoadFactor()) + ")");
        
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            Entry<K, V> current = table[i];
            
            if (current == null) {
                System.out.println("empty");
            } else {
                while (current != null) {
                    System.out.print("(" + current.key + ", " + current.value + ")");
                    current = current.next;
                    if (current != null) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
```

### 🎯 Hash Table with Linear Probing

```java
public class HashTableLinearProbing<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        boolean deleted;  // For lazy deletion
        
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.deleted = false;
        }
    }
    
    private Entry<K, V>[] table;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 16;
    private static final double MAX_LOAD_FACTOR = 0.75;
    
    @SuppressWarnings("unchecked")
    public HashTableLinearProbing() {
        this.capacity = DEFAULT_CAPACITY;
        this.table = new Entry[capacity];
        this.size = 0;
    }
    
    private int hash(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % capacity;
    }
    
    public V put(K key, V value) {
        if (getLoadFactor() >= MAX_LOAD_FACTOR) {
            resize();
        }
        
        int index = hash(key);
        
        // Linear probing to find empty slot or existing key
        while (table[index] != null && !table[index].deleted) {
            if (Objects.equals(table[index].key, key)) {
                // Key exists, update value
                V oldValue = table[index].value;
                table[index].value = value;
                return oldValue;
            }
            index = (index + 1) % capacity;  // Move to next slot (wrap around)
        }
        
        // Found empty slot or deleted slot
        table[index] = new Entry<>(key, value);
        size++;
        return null;
    }
    
    public V get(K key) {
        int index = hash(key);
        
        // Linear probing to find key
        while (table[index] != null) {
            if (!table[index].deleted && Objects.equals(table[index].key, key)) {
                return table[index].value;
            }
            index = (index + 1) % capacity;
        }
        
        return null;  // Key not found
    }
    
    public V remove(K key) {
        int index = hash(key);
        
        // Linear probing to find key
        while (table[index] != null) {
            if (!table[index].deleted && Objects.equals(table[index].key, key)) {
                V value = table[index].value;
                table[index].deleted = true;  // Lazy deletion
                size--;
                return value;
            }
            index = (index + 1) % capacity;
        }
        
        return null;  // Key not found
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public double getLoadFactor() {
        return (double) size / capacity;
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldTable = table;
        int oldCapacity = capacity;
        
        capacity = oldCapacity * 2;
        table = new Entry[capacity];
        size = 0;
        
        // Rehash all non-deleted entries
        for (Entry<K, V> entry : oldTable) {
            if (entry != null && !entry.deleted) {
                put(entry.key, entry.value);
            }
        }
        
        System.out.println("Resized hash table to capacity: " + capacity);
    }
    
    public void printTable() {
        System.out.println("Hash Table (Linear Probing) - Size: " + size + 
                          ", Capacity: " + capacity);
        for (int i = 0; i < capacity; i++) {
            if (table[i] == null) {
                System.out.println("Index " + i + ": empty");
            } else if (table[i].deleted) {
                System.out.println("Index " + i + ": deleted");
            } else {
                System.out.println("Index " + i + ": (" + table[i].key + ", " + 
                                 table[i].value + ")");
            }
        }
        System.out.println();
    }
}
```

### 🧪 Complete Usage Example

```java
public class HashTableDemo {
    public static void main(String[] args) {
        System.out.println("=== HASH TABLE WITH CHAINING DEMO ===");
        
        // Create hash table with small capacity to demonstrate resizing
        HashTableChaining<String, Integer> studentGrades = new HashTableChaining<>(4);
        
        // Add student grades
        System.out.println("Adding student grades...");
        studentGrades.put("Alice", 95);
        studentGrades.put("Bob", 87);
        studentGrades.put("Carol", 92);
        studentGrades.put("David", 78);
        studentGrades.put("Eve", 88);
        
        studentGrades.printTable();
        
        // Test retrieval
        System.out.println("Alice's grade: " + studentGrades.get("Alice"));
        System.out.println("Bob's grade: " + studentGrades.get("Bob"));
        System.out.println("Frank's grade: " + studentGrades.get("Frank")); // Not found
        
        // Test update
        System.out.println("Updating Alice's grade to 98...");
        Integer oldGrade = studentGrades.put("Alice", 98);
        System.out.println("Alice's old grade was: " + oldGrade);
        System.out.println("Alice's new grade: " + studentGrades.get("Alice"));
        
        // Test removal
        System.out.println("Removing David...");
        Integer removedGrade = studentGrades.remove("David");
        System.out.println("Removed grade: " + removedGrade);
        
        studentGrades.printTable();
        
        // Test with numbers (demonstrating collisions)
        System.out.println("\n=== COLLISION DEMONSTRATION ===");
        HashTableChaining<Integer, String> numbers = new HashTableChaining<>(5);
        
        numbers.put(5, "five");     // 5 % 5 = 0
        numbers.put(10, "ten");     // 10 % 5 = 0 (collision!)
        numbers.put(15, "fifteen"); // 15 % 5 = 0 (collision!)
        numbers.put(7, "seven");    // 7 % 5 = 2
        
        numbers.printTable();
        
        // Linear probing demo
        System.out.println("\n=== LINEAR PROBING DEMO ===");
        HashTableLinearProbing<Integer, String> linearProbing = 
            new HashTableLinearProbing<>();
        
        linearProbing.put(5, "five");
        linearProbing.put(15, "fifteen");  // Will cause collision
        linearProbing.put(25, "twenty-five"); // Another collision
        
        linearProbing.printTable();
        
        System.out.println("Get 5: " + linearProbing.get(5));
        System.out.println("Get 15: " + linearProbing.get(15));
        System.out.println("Get 25: " + linearProbing.get(25));
    }
}
```

### 🎯 Advanced Hash Function Implementation

```java
public class AdvancedHashFunctions {
    
    // Polynomial rolling hash for strings (commonly used)
    public static int polynomialHash(String str, int base, int mod) {
        int hash = 0;
        long basePower = 1;
        
        for (char c : str.toCharArray()) {
            hash = (int)((hash + (c * basePower)) % mod);
            basePower = (basePower * base) % mod;
        }
        
        return Math.abs(hash);
    }
    
    // FNV-1a hash (good for general purpose)
    public static int fnv1aHash(String str) {
        int hash = 0x811c9dc5;  // FNV offset basis
        int prime = 0x01000193; // FNV prime
        
        for (char c : str.toCharArray()) {
            hash ^= c;
            hash *= prime;
        }
        
        return Math.abs(hash);
    }
    
    // Double hashing for open addressing
    public static class DoubleHash {
        private int tableSize;
        private int prime;  // Should be less than table size
        
        public DoubleHash(int tableSize) {
            this.tableSize = tableSize;
            this.prime = getPrime(tableSize - 1);
        }
        
        public int hash1(int key) {
            return key % tableSize;
        }
        
        public int hash2(int key) {
            return prime - (key % prime);
        }
        
        public int doubleHash(int key, int attempt) {
            return (hash1(key) + attempt * hash2(key)) % tableSize;
        }
        
        private int getPrime(int n) {
            for (int i = n; i >= 1; i--) {
                if (isPrime(i)) return i;
            }
            return 3; // Fallback
        }
        
        private boolean isPrime(int n) {
            if (n <= 1) return false;
            if (n <= 3) return true;
            if (n % 2 == 0 || n % 3 == 0) return false;
            
            for (int i = 5; i * i <= n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) return false;
            }
            return true;
        }
    }
}
```

---

## 🧠 PRACTICAL EXERCISES

### 💪 Exercise 1: Word Frequency Counter (Beginner)
**Problem:** Count the frequency of words in a text using a hash table.

**Task:**
1. Read a sentence
2. Split into words (ignore case and punctuation)  
3. Count frequency of each word
4. Display results

**Solution:**
```java
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWords(String text) {
        // Using our custom hash table
        HashTableChaining<String, Integer> wordCount = new HashTableChaining<>();
        
        // Clean and split text
        String[] words = text.toLowerCase()
                            .replaceAll("[^a-zA-Z\\s]", "")
                            .split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                Integer currentCount = wordCount.get(word);
                if (currentCount == null) {
                    wordCount.put(word, 1);
                } else {
                    wordCount.put(word, currentCount + 1);
                }
            }
        }
        
        // Convert to regular map for return
        Map<String, Integer> result = new HashMap<>();
        for (String key : wordCount.keySet()) {
            result.put(key, wordCount.get(key));
        }
        
        return result;
    }
    
    public static void exercise1() {
        String text = "The quick brown fox jumps over the lazy dog. The dog was lazy.";
        
        System.out.println("=== WORD FREQUENCY COUNTER ===");
        System.out.println("Text: " + text);
        System.out.println();
        
        Map<String, Integer> frequencies = countWords(text);
        
        System.out.println("Word frequencies:");
        frequencies.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(entry -> 
                System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
```

### 🎯 Exercise 2: Anagram Grouping (Intermediate)
**Problem:** Group anagrams together using hash tables.

**Solution:**
```java
import java.util.*;

public class AnagramGrouper {
    public static List<List<String>> groupAnagrams(String[] words) {
        HashTableChaining<String, List<String>> groups = new HashTableChaining<>();
        
        for (String word : words) {
            // Create signature by sorting characters
            char[] chars = word.toLowerCase().toCharArray();
            Arrays.sort(chars);
            String signature = new String(chars);
            
            // Get or create group
            List<String> group = groups.get(signature);
            if (group == null) {
                group = new ArrayList<>();
                groups.put(signature, group);
            }
            group.add(word);
        }
        
        // Convert to list of lists
        List<List<String>> result = new ArrayList<>();
        for (String key : groups.keySet()) {
            result.add(groups.get(key));
        }
        
        return result;
    }
    
    public static void exercise2() {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        System.out.println("\n=== ANAGRAM GROUPING ===");
        System.out.println("Words: " + Arrays.toString(words));
        
        List<List<String>> groups = groupAnagrams(words);
        
        System.out.println("Anagram groups:");
        for (int i = 0; i < groups.size(); i++) {
            System.out.println("Group " + (i + 1) + ": " + groups.get(i));
        }
    }
}
```

### 🔥 Exercise 3: LRU Cache Implementation (Intermediate)
**Problem:** Implement a Least Recently Used (LRU) cache using hash table + doubly linked list.

**Solution:**
```java
public class LRUCache<K, V> {
    private class Node {
        K key;
        V value;
        Node prev, next;
        
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private HashTableChaining<K, Node> map;
    private Node head, tail;
    private int capacity;
    private int size;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashTableChaining<>();
        
        // Create dummy head and tail nodes
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }
    
    public V get(K key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        
        // Move to front (most recently used)
        moveToFront(node);
        return node.value;
    }
    
    public void put(K key, V value) {
        Node node = map.get(key);
        
        if (node != null) {
            // Update existing node
            node.value = value;
            moveToFront(node);
        } else {
            // Add new node
            node = new Node(key, value);
            
            if (size >= capacity) {
                // Remove least recently used (tail)
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
                size--;
            }
            
            addToFront(node);
            map.put(key, node);
            size++;
        }
    }
    
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }
    
    public void printCache() {
        System.out.print("LRU Cache (most recent first): ");
        Node current = head.next;
        while (current != tail) {
            System.out.print("(" + current.key + "," + current.value + ") ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void exercise3() {
        System.out.println("\n=== LRU CACHE DEMO ===");
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.printCache();
        
        System.out.println("Get 1: " + cache.get(1)); // Makes 1 most recent
        cache.printCache();
        
        cache.put(4, "four"); // Should evict 2 (least recent)
        cache.printCache();
        
        System.out.println("Get 2: " + cache.get(2)); // Should return null
        System.out.println("Get 3: " + cache.get(3)); // Should return "three"
        cache.printCache();
    }
}
```

### 🌟 Exercise 4: Two Sum Problem (Advanced)
**Problem:** Find two numbers in an array that add up to a target sum.

**Solution:**
```java
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashTableChaining<Integer, Integer> map = new HashTableChaining<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer complementIndex = map.get(complement);
            
            if (complementIndex != null) {
                return new int[]{complementIndex, i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[]{}; // No solution found
    }
    
    public static List<List<Integer>> twoSumAllPairs(int[] nums, int target) {
        HashTableChaining<Integer, List<Integer>> map = new HashTableChaining<>();
        List<List<Integer>> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        
        // Build map of value -> list of indices
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indices = map.get(nums[i]);
            if (indices == null) {
                indices = new ArrayList<>();
                map.put(nums[i], indices);
            }
            indices.add(i);
        }
        
        // Find all pairs
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            List<Integer> complementIndices = map.get(complement);
            
            if (complementIndices != null) {
                for (int j : complementIndices) {
                    if (i < j) { // Avoid duplicates and self-pairing
                        String pair = Math.min(nums[i], nums[j]) + "," + 
                                     Math.max(nums[i], nums[j]);
                        if (!seen.contains(pair)) {
                            result.add(Arrays.asList(nums[i], nums[j]));
                            seen.add(pair);
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void exercise4() {
        System.out.println("\n=== TWO SUM PROBLEM ===");
        
        int[] nums = {2, 7, 11, 15, 3, 4};
        int target = 9;
        
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        
        int[] result = twoSum(nums, target);
        if (result.length > 0) {
            System.out.println("First pair indices: " + Arrays.toString(result));
            System.out.println("Values: [" + nums[result[0]] + ", " + nums[result[1]] + "]");
        }
        
        List<List<Integer>> allPairs = twoSumAllPairs(nums, target);
        System.out.println("All pairs that sum to " + target + ": " + allPairs);
    }
}
```

### 🚀 Exercise 5: Hash Table Performance Analysis (Advanced)
**Problem:** Compare performance of different collision resolution methods.

**Solution:**
```java
import java.util.*;

public class HashTablePerformanceAnalysis {
    
    public static void performanceTest() {
        System.out.println("\n=== HASH TABLE PERFORMANCE ANALYSIS ===");
        
        int[] sizes = {1000, 10000, 100000};
        
        for (int size : sizes) {
            System.out.println("\nTesting with " + size + " elements:");
            
            // Generate random data
            List<Integer> keys = new ArrayList<>();
            Random random = new Random(42); // Fixed seed for reproducibility
            
            for (int i = 0; i < size; i++) {
                keys.add(random.nextInt(size * 10));
            }
            
            // Test separate chaining
            long startTime = System.nanoTime();
            HashTableChaining<Integer, Integer> chainTable = new HashTableChaining<>();
            for (Integer key : keys) {
                chainTable.put(key, key * 2);
            }
            // Test retrieval
            for (Integer key : keys) {
                chainTable.get(key);
            }
            long chainTime = System.nanoTime() - startTime;
            
            // Test linear probing
            startTime = System.nanoTime();
            HashTableLinearProbing<Integer, Integer> probingTable = 
                new HashTableLinearProbing<>();
            for (Integer key : keys) {
                probingTable.put(key, key * 2);
            }
            // Test retrieval
            for (Integer key : keys) {
                probingTable.get(key);
            }
            long probingTime = System.nanoTime() - startTime;
            
            // Test Java's HashMap for comparison
            startTime = System.nanoTime();
            Map<Integer, Integer> javaMap = new HashMap<>();
            for (Integer key : keys) {
                javaMap.put(key, key * 2);
            }
            // Test retrieval
            for (Integer key : keys) {
                javaMap.get(key);
            }
            long javaTime = System.nanoTime() - startTime;
            
            System.out.printf("Chaining:      %.2f ms\n", chainTime / 1_000_000.0);
            System.out.printf("Linear Probing: %.2f ms\n", probingTime / 1_000_000.0);
            System.out.printf("Java HashMap:   %.2f ms\n", javaTime / 1_000_000.0);
            
            System.out.println("Load factors:");
            System.out.printf("Chaining: %.2f\n", chainTable.getLoadFactor());
            System.out.printf("Linear Probing: %.2f\n", probingTable.getLoadFactor());
        }
    }
    
    public static void collisionAnalysis() {
        System.out.println("\n=== COLLISION ANALYSIS ===");
        
        // Test different hash functions
        String[] testStrings = {"hello", "world", "java", "hash", "table", 
                               "algorithm", "data", "structure"};
        
        System.out.println("Hash values for different functions:");
        System.out.println("String\t\tSimple\tPolynomial\tFNV-1a");
        
        for (String str : testStrings) {
            int simpleHash = Math.abs(str.hashCode()) % 100;
            int polyHash = AdvancedHashFunctions.polynomialHash(str, 31, 100);
            int fnvHash = AdvancedHashFunctions.fnv1aHash(str) % 100;
            
            System.out.printf("%-12s\t%d\t%d\t\t%d\n", str, simpleHash, polyHash, fnvHash);
        }
    }
    
    public static void exercise5() {
        performanceTest();
        collisionAnalysis();
    }
}
```

---

## 🔍 DEEP DIVE ANALYSIS

### ⏱️ Time Complexity Analysis

#### **Average Case Performance:**

| Operation | Hash Table | Array | Linked List | BST |
|-----------|------------|-------|-------------|-----|
| **Search** | O(1) | O(n) | O(n) | O(log n) |
| **Insert** | O(1) | O(n) | O(1) | O(log n) |
| **Delete** | O(1) | O(n) | O(n) | O(log n) |

#### **Worst Case Performance:**

| Operation | Hash Table | Explanation |
|-----------|------------|-------------|
| **Search** | O(n) | All keys hash to same bucket |
| **Insert** | O(n) | Need to check all elements in bucket |
| **Delete** | O(n) | Search + removal from bucket |

**Why worst case is O(n):**
- Bad hash function causes all keys to collide
- Essentially becomes a linked list or requires linear probing through entire table

#### **Load Factor Impact:**

```
Separate Chaining:
- Load factor α = n/m (n = items, m = table size)
- Average search time: 1 + α/2
- α = 0.75 → average 1.375 comparisons
- α = 2.0 → average 2.0 comparisons

Open Addressing (Linear Probing):
- Average search time: (1 + 1/(1-α)²)/2
- α = 0.5 → 1.5 comparisons
- α = 0.75 → 4.5 comparisons  
- α = 0.9 → 50.5 comparisons (!)
```

### 💾 Space Complexity Analysis

#### **Memory Usage:**

| Method | Space Complexity | Extra Space |
|--------|------------------|-------------|
| **Separate Chaining** | O(n + m) | Pointers for linked lists |
| **Linear Probing** | O(m) | No extra pointers |
| **Quadratic Probing** | O(m) | No extra pointers |

**Detailed Breakdown:**
- **Table array**: m entries × (key + value + metadata)
- **Chaining**: Extra pointer per entry + linked list nodes
- **Open addressing**: Deleted flags for lazy deletion

### ⚖️ When to Use Hash Tables vs Alternatives

#### **Choose Hash Tables when:**
✅ **Need fast lookups** - O(1) average case is crucial
✅ **Key-based access** - Don't need ordered traversal  
✅ **Frequent insertions/deletions** - Dynamic data
✅ **Cache/memoization** - Store computed results
✅ **Counting/frequency** - Track occurrences
✅ **Set operations** - Membership testing

#### **Don't use Hash Tables when:**
❌ **Need sorted order** - Hash tables don't maintain order
❌ **Range queries** - Can't efficiently find keys in range
❌ **Memory constrained** - Extra space overhead
❌ **Small datasets** - Array linear search might be faster
❌ **Worst-case guarantees** - BST gives O(log n) guarantee

### 🪤 Common Pitfalls and Debugging Tips

#### 1. **Poor Hash Function**
```java
// BAD: Causes clustering
public int badHash(String key) {
    return key.length() % tableSize;
}

// GOOD: Better distribution
public int goodHash(String key) {
    int hash = 0;
    for (char c : key.toCharArray()) {
        hash = hash * 31 + c;
    }
    return Math.abs(hash) % tableSize;
}
```

#### 2. **Not Handling Null Keys/Values**
```java
// Always check for null
public V put(K key, V value) {
    if (key == null) {
        // Decide: throw exception or handle specially
        throw new IllegalArgumentException("Null key not allowed");
    }
    // ... rest of implementation
}
```

#### 3. **Forgetting to Resize**
```java
// Monitor load factor
public void checkResize() {
    if (getLoadFactor() > MAX_LOAD_FACTOR) {
        resize();
    }
}
```

#### 4. **Incorrect Equals/HashCode Contract**
```java
// If you override equals(), must override hashCode()
class Person {
    String name;
    int age;
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age); // MUST be consistent with equals()
    }
}
```

#### 5. **Modifying Keys After Insertion**
```java
// DON'T DO THIS:
List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
map.put(list, "value");
list.add(4); // Hash code changes! Entry becomes unreachable
```

### 🚀 Advanced Optimizations

#### 1. **Robin Hood Hashing**
```java
// In linear probing, let entries "steal" spots from less displaced entries
public void robinHoodPut(K key, V value) {
    int distance = 0;
    int index = hash(key);
    
    while (table[index] != null) {
        if (table[index].distance < distance) {
            // Current entry is less displaced, swap
            swap(table[index], new Entry(key, value, distance));
            key = table[index].key;
            value = table[index].value;
            distance = table[index].distance;
        }
        index = (index + 1) % capacity;
        distance++;
    }
    
    table[index] = new Entry(key, value, distance);
}
```

#### 2. **Cuckoo Hashing**
```java
// Use two hash functions, guarantee O(1) worst case lookup
class CuckooHashTable<K, V> {
    private Entry<K, V>[] table1, table2;
    private int size, capacity;
    
    public V get(K key) {
        int index1 = hash1(key);
        if (table1[index1] != null && table1[index1].key.equals(key)) {
            return table1[index1].value;
        }
        
        int index2 = hash2(key);
        if (table2[index2] != null && table2[index2].key.equals(key)) {
            return table2[index2].value;
        }
        
        return null; // Guaranteed to find in at most 2 lookups
    }
}
```

#### 3. **Consistent Hashing**
```java
// Used in distributed systems (like load balancing)
class ConsistentHash {
    private TreeMap<Integer, String> ring = new TreeMap<>();
    
    public void addServer(String server) {
        for (int i = 0; i < 100; i++) { // Virtual nodes
            int hash = hash(server + ":" + i);
            ring.put(hash, server);
        }
    }
    
    public String getServer(String key) {
        int hash = hash(key);
        Map.Entry<Integer, String> entry = ring.ceilingEntry(hash);
        return entry != null ? entry.getValue() : ring.firstEntry().getValue();
    }
}
```

---

## 🌟 REAL-WORLD APPLICATIONS

### 💼 Industry Use Cases

#### 1. **Database Indexing**
```java
class DatabaseIndex {
    // Hash index for fast lookups
    private HashTableChaining<Object, List<Integer>> index;
    
    public DatabaseIndex() {
        this.index = new HashTableChaining<>();
    }
    
    public void addRecord(Object key, int recordId) {
        List<Integer> records = index.get(key);
        if (records == null) {
            records = new ArrayList<>();
            index.put(key, records);
        }
        records.add(recordId);
    }
    
    public List<Integer> findRecords(Object key) {
        List<Integer> records = index.get(key);
        return records != null ? records : new ArrayList<>();
    }
    
    // Example: Customer database
    public void exampleUsage() {
        DatabaseIndex customerIndex = new DatabaseIndex();
        
        // Index customers by email
        customerIndex.addRecord("john@email.com", 101);
        customerIndex.addRecord("jane@email.com", 102);
        customerIndex.addRecord("bob@email.com", 103);
        
        // Fast lookup: O(1) instead of scanning entire table
        List<Integer> johnRecords = customerIndex.findRecords("john@email.com");
        System.out.println("John's record IDs: " + johnRecords);
    }
}
```

#### 2. **Web Server Session Management**
```java
class SessionManager {
    private HashTableChaining<String, Session> sessions;
    private long sessionTimeout;
    
    public SessionManager(long timeoutMs) {
        this.sessions = new HashTableChaining<>();
        this.sessionTimeout = timeoutMs;
    }
    
    public String createSession(String userId) {
        String sessionId = generateSessionId();
        Session session = new Session(userId, System.currentTimeMillis());
        sessions.put(sessionId, session);
        return sessionId;
    }
    
    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        
        if (session != null) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - session.createdTime > sessionTimeout) {
                sessions.remove(sessionId); // Expired
                return null;
            }
            session.lastAccessed = currentTime; // Update access time
        }
        
        return session;
    }
    
    public boolean isValidSession(String sessionId) {
        return getSession(sessionId) != null;
    }
    
    private String generateSessionId() {
        return UUID.randomUUID().toString();
    }
    
    static class Session {
        String userId;
        long createdTime;
        long lastAccessed;
        Map<String, Object> attributes;
        
        Session(String userId, long createdTime) {
            this.userId = userId;
            this.createdTime = createdTime;
            this.lastAccessed = createdTime;
            this.attributes = new HashMap<>();
        }
    }
}
```

#### 3. **Compiler Symbol Table**
```java
class SymbolTable {
    private HashTableChaining<String, Symbol> symbols;
    private SymbolTable parent; // For nested scopes
    
    public SymbolTable(SymbolTable parent) {
        this.symbols = new HashTableChaining<>();
        this.parent = parent;
    }
    
    public void define(String name, Symbol symbol) {
        symbols.put(name, symbol);
    }
    
    public Symbol lookup(String name) {
        // Check current scope first
        Symbol symbol = symbols.get(name);
        if (symbol != null) {
            return symbol;
        }
        
        // Check parent scopes
        if (parent != null) {
            return parent.lookup(name);
        }
        
        return null; // Undefined variable
    }
    
    public boolean isDefinedInCurrentScope(String name) {
        return symbols.get(name) != null;
    }
    
    static class Symbol {
        String name;
        String type;
        Object value;
        boolean isConstant;
        
        Symbol(String name, String type, Object value, boolean isConstant) {
            this.name = name;
            this.type = type;
            this.value = value;
            this.isConstant = isConstant;
        }
        
        @Override
        public String toString() {
            return name + ":" + type + "=" + value + (isConstant ? " (const)" : "");
        }
    }
    
    // Example usage in a simple interpreter
    public void interpreterExample() {
        // Global scope
        SymbolTable global = new SymbolTable(null);
        global.define("PI", new Symbol("PI", "double", 3.14159, true));
        
        // Function scope
        SymbolTable function = new SymbolTable(global);
        function.define("x", new Symbol("x", "int", 10, false));
        function.define("y", new Symbol("y", "int", 20, false));
        
        // Block scope
        SymbolTable block = new SymbolTable(function);
        block.define("temp", new Symbol("temp", "int", 30, false));
        
        // Lookups
        System.out.println("temp: " + block.lookup("temp"));  // Found in current scope
        System.out.println("x: " + block.lookup("x"));        // Found in parent scope
        System.out.println("PI: " + block.lookup("PI"));      // Found in grandparent scope
        System.out.println("undefined: " + block.lookup("undefined")); // null
    }
}
```

#### 4. **Distributed Cache (Simplified)**
```java
class DistributedCache {
    private List<CacheNode> nodes;
    private ConsistentHash ring;
    
    public DistributedCache() {
        this.nodes = new ArrayList<>();
        this.ring = new ConsistentHash();
    }
    
    public void addNode(CacheNode node) {
        nodes.add(node);
        ring.addServer(node.getId());
    }
    
    public void put(String key, Object value) {
        String nodeId = ring.getServer(key);
        CacheNode node = findNode(nodeId);
        node.put(key, value);
    }
    
    public Object get(String key) {
        String nodeId = ring.getServer(key);
        CacheNode node = findNode(nodeId);
        return node.get(key);
    }
    
    private CacheNode findNode(String nodeId) {
        return nodes.stream()
                   .filter(n -> n.getId().equals(nodeId))
                   .findFirst()
                   .orElse(nodes.get(0));
    }
    
    static class CacheNode {
        private String id;
        private HashTableChaining<String, Object> cache;
        
        public CacheNode(String id) {
            this.id = id;
            this.cache = new HashTableChaining<>();
        }
        
        public String getId() { return id; }
        
        public void put(String key, Object value) {
            cache.put(key, value);
            System.out.println("Stored " + key + " on node " + id);
        }
        
        public Object get(String key) {
            Object value = cache.get(key);
            System.out.println("Retrieved " + key + " from node " + id);
            return value;
        }
    }
}
```

### 🎯 Related Topics to Explore Next

#### **Immediate Next Steps:**
1. **Bloom Filters** - Space-efficient probabilistic data structure
2. **Consistent Hashing** - For distributed systems
3. **Hash-based Set Operations** - Union, intersection, difference
4. **Perfect Hashing** - No collisions for static data

#### **Advanced Hashing Techniques:**
1. **Cuckoo Hashing** - Guarantees O(1) worst-case lookup
2. **Robin Hood Hashing** - Reduces variance in probe distances
3. **Hopscotch Hashing** - Good cache performance
4. **Count-Min Sketch** - Approximate counting with hashes

#### **Related Data Structures:**
1. **Trie (Prefix Tree)** - For string-based operations
2. **Suffix Arrays** - For string processing
3. **B+ Trees** - For database indexing
4. **Skip Lists** - Probabilistic alternative to trees

#### **System Design Applications:**
1. **Load Balancers** - Consistent hashing for server selection
2. **Databases** - Hash joins, partitioning
3. **Caches** - Redis, Memcached implementations
4. **Distributed Storage** - Sharding strategies

---

## 🎯 SUMMARY & CHEAT SHEET

### 📝 Key Takeaways

🗂️ **Hash Table = Array + Hash Function + Collision Resolution**
- **Hash Function**: Converts keys to array indices
- **Collision Resolution**: Handle when multiple keys map to same index
- **Load Factor**: Keep it balanced for optimal performance

### 🚀 Quick Reference

#### **Core Concepts:**
```java
// Basic hash table operations
HashTable<String, Integer> table = new HashTable<>();

table.put("key", 42);        // Insert/Update: O(1) average
Integer value = table.get("key");  // Search: O(1) average  
table.remove("key");         // Delete: O(1) average
boolean exists = table.containsKey("key"); // Check: O(1) average
```

#### **Hash Function Design:**
```java
// Good hash function properties:
// 1. Deterministic (same key → same hash)
// 2. Uniform distribution
// 3. Efficient to compute
// 4. Avalanche effect (small change → big difference)

public int hash(String key) {
    int hash = 0;
    for (char c : key.toCharArray()) {
        hash = hash * 31 + c;  // 31 is prime, good for strings
    }
    return Math.abs(hash) % tableSize;
}
```

#### **Collision Resolution:**
```java
// Separate Chaining (linked lists)
bucket[index] = newNode -> existingNode -> null

// Linear Probing (open addressing)
if (bucket[index] occupied) {
    try bucket[(index + 1) % size]
    try bucket[(index + 2) % size]
    // ... until empty slot found
}
```

#### **Time Complexities:**
| Operation | Average | Worst Case | When Worst Happens |
|-----------|---------|------------|-------------------|
| **Get** | O(1) | O(n) | All keys hash to same bucket |
| **Put** | O(1) | O(n) | Collision resolution takes long |
| **Remove** | O(1) | O(n) | Must search through long chain |
| **Resize** | O(n) | O(n) | Must rehash all elements |

#### **Load Factor Guidelines:**
- **Separate Chaining**: Keep < 1.0 (ideally 0.75)
- **Linear Probing**: Keep < 0.75 (performance degrades quickly)
- **Quadratic Probing**: Keep < 0.5

### 🔧 Debugging Checklist

- [ ] Is your hash function distributing keys uniformly?
- [ ] Are you handling null keys/values correctly?
- [ ] Is your load factor reasonable? (< 0.75 for most cases)
- [ ] Are you resizing when load factor gets too high?
- [ ] If using custom objects as keys, did you override equals() AND hashCode()?
- [ ] Are you handling integer overflow in hash calculations?
- [ ] For open addressing, are you using tombstones for deletions?

### 💡 Pro Tips

1. **Use prime table sizes** to reduce clustering
2. **Monitor load factor** and resize proactively
3. **Choose collision resolution** based on data access patterns
4. **Profile your hash function** with real data
5. **Consider Java's HashMap** for production (highly optimized)
6. **Use consistent hashing** for distributed systems
7. **Test with edge cases**: empty strings, null values, many collisions
8. **Remember the equals/hashCode contract**

### 🎨 Visual Memory Aid

```
HASH TABLE STRUCTURE:
Hash Function: "apple" → hash("apple") % 10 = 7

Index: 0    1    2    3    4    5    6    7         8    9
Value: []   []   []   []   []   []   []   [apple]   []   []

SEPARATE CHAINING (collision):
Index: 7 → [apple] → [banana] → [cherry] → null

LINEAR PROBING (collision):
Index: 7: apple, 8: banana, 9: cherry
```

**Remember:**
- **Hash Function**: Key → Index
- **Collision**: Different keys → Same index  
- **Load Factor**: Items / Table Size
- **Resize**: When load factor too high

---

## 🎉 Congratulations!

You now have a comprehensive understanding of Hash Tables and Hashing! You've mastered:

- ✅ **What hash tables are** and why they provide O(1) operations
- ✅ **How hash functions work** and what makes a good one
- ✅ **Collision resolution methods** and when to use each
- ✅ **Complete implementations** with both chaining and open addressing
- ✅ **Real-world applications** from databases to distributed systems
- ✅ **Performance analysis** and optimization techniques

**Next Challenge:** Try implementing a **Bloom Filter** for space-efficient membership testing, or explore **Consistent Hashing** for distributed system design!

---

*Keep hashing those problems efficiently! 🗂️*