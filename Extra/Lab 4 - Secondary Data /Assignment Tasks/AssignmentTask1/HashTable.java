/*You will have to complete the PairNode Contrustor first
 then within this class you only have to complete two methods
 hashFunction() and remove()
 the rest of the methods are already written
 DO NOT TOUCH any other methods or codes*/
public class HashTable {

    // ht is the HashTable array that stores the PairNode objects
    // It is an intance variable
    private PairNode[] ht;

    // Constructor that initializes the HashTable array
    // DO NOT change and DO NOT SUBMIT this method
    public HashTable(int size) {
        this.ht = new PairNode[size];
    }

    // This method is called to insert each pair from the 2D Array
    // DO NOT change and DO NOT SUBMIT this method
    public void createFromArray(Object[][] arr) {
        for (Object[] x : arr)
            this.insert(x);
    }

    // The insert() method inserts the pair into proper Hashed Index
    // This method is already written including collision resolve using Forward
    // Chaining
    // DO NOT change and DO NOT SUBMIT this method
    public void insert(Object[] keyValuePair) {
        Integer key = (Integer) keyValuePair[0];
        String value = (String) keyValuePair[1];

        int idx = hashFunction(key);
        if (idx == -1) {
            // leaving it blank
        } else if (ht[idx] == null) {
            ht[idx] = new PairNode(key, value);
        } else {
            PairNode pair = new PairNode(key, value);
            pair.next = ht[idx];
            ht[idx] = pair;
        }
    }

    // This method basically prints the HashTable
    // DO NOT change and DO NOT SUBMIT this method
    public void printHashTable() {
        for (int i = 0; i < ht.length; i++) {
            System.out.print(i + ": ");
            PairNode pNode = ht[i];
            if (pNode == null)
                System.out.println("null");
            while (pNode != null) {
                System.out.print("(" + pNode.key + ", '" + pNode.value + "') --> ");
                if (pNode.next == null)
                    System.out.println("null");
                pNode = pNode.next;
            }
        }
    }
/*Hashtable: Deletion Operation :

You are given the hash function, h(key) = (key + 3) % 6 for a hash-table of length 6. In this 
hashing, forward chaining is used for resolving conflict and a 6-length array of singly linked lists
is used as the hash-table. In the singly linked list, each node has a next pointer, an Integer key
and a string value, for example: (4 (key) , “Rafi” (value)). The hash-table stores this key-value
pair.

Implement a function remove(hashTable, key) that takes a key and a hash-table as
parameters. The function removes the key-value pair from the aforementioned hashtable if such a key-value pair (whose key matches the key passed as argument) exists in the hashtable. 

Consider,Node class and hashTable are given to you. You just need to complete the
remove(hashTable, key) function.

class Node:
   def __init__(self, key, value, next=None):
         self.key, self.value, self.next = key, value, next

Sample Input and Output:
Some Key-value pairs:
(34, “Abid”) , (4, “Rafi”), (6, “Karim”), (3, “Chitra”), (22, “Nilu”)

HashTable is given in the following:
0: (3, “Chitra”)
1: (22, “Nilu”) → (4, “Rafi”) → (34, “Abid”)
2: None
3: (6, “Karim”)
4: None
5: None

remove(hashTable, key=4) returns the changed hashTable where (4, “Rafi”) is removed.

New HashTable Output:
0: (3, “Chitra”)
1: (22, “Nilu”) → (34, “Abid”)
2: None
3: (6, “Karim”)
4: None
5: None

remove(hashTable, key=9) returns the same given hashTable since 9 doesn’t exist in the table.
 */
    // you need to COMPLETE this method and MUST SUBMIT IT
    // Complete this method first the write remove
    
    private int hashFunction(Integer key) {

        return (key + 3) % 6;
    }

    // you need to COMPLETE this method and MUST SUBMIT IT
    // before writing remove you should complete hashFunction
    public void remove(Integer key) {
        int idx = hashFunction(key);
        
        if (ht[idx] == null) {
            return; // Key not found
        }
        
        // If the key is at the head of the linked list
        if (ht[idx].key.equals(key)) {
            ht[idx] = ht[idx].next;
            return;
        }
        
        // Traverse the linked list to find the key
        PairNode current = ht[idx];
        while (current.next != null) {
            if (current.next.key.equals(key)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

}
