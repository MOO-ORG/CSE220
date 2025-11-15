public class RemoveConsecutiveDuplicates {

    // You have to write this method
    // YOU MUST SUBMIT THIS METHOD
    public static String removeConsecDups(String word) {
        // TODO
        // You MUST create a LinkedListQueue Object to solve this task
        LinkedListQueue queue = new LinkedListQueue();

        if (word == null || word.length() == 0) {
            return word;
        }

        // Add first character to queue
        queue.enqueue(word.charAt(0));

        // Traverse the string and add only non-consecutive duplicates
        for (int i = 1; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            // Find the last character in queue
            LinkedListQueue tempQueue = new LinkedListQueue();
            char lastInQueue = ' ';
            while (!queue.isEmpty()) {
                Object elem = queue.dequeue();
                lastInQueue = (char) elem;
                tempQueue.enqueue(elem);
            }

            // Restore queue
            while (!tempQueue.isEmpty()) {
                queue.enqueue(tempQueue.dequeue());
            }

            // Only add if it's different from the last character
            if (currentChar != lastInQueue) {
                queue.enqueue(currentChar);
            }
        }

        // Build result string from queue without using StringBuilder or concatenation
        // First, count the size
        int size = 0;
        LinkedListQueue tempQueue = new LinkedListQueue();
        while (!queue.isEmpty()) {
            Object elem = queue.dequeue();
            tempQueue.enqueue(elem);
            size++;
        }

        // Create char array
        char[] resultArray = new char[size];
        int index = 0;
        while (!tempQueue.isEmpty()) {
            resultArray[index++] = (char) tempQueue.dequeue();
        }

        return new String(resultArray);
    }

    // DO NOT CHANGE and DO NOT SUBMIT THIS METHOD
    public static void assertTest(Object actual, Object expected) {
        if (actual == null || !actual.equals(expected)) {
            System.out.println("Test Failed! Expected: " + expected + ", but got: " + actual);
        } else {
            System.out.println("Test Success!!! Expected: " + expected + ", but got: " + actual);
        }
    }

    // DO NOT SUBMIT THE TESTER METHOD
    // DO NOT MODIFY THE MAIN METHOD
    public static void main(String[] args) {
        System.out.println("Test 01");
        String string1 = "aabbbccccdd";
        String returned1 = removeConsecDups(string1);
        assertTest(returned1, "abcd");
        System.out.println("-----------------------------------------");

        System.out.println("Test 02");
        String string2 = "aaabbaa";
        String returned2 = removeConsecDups(string2);
        assertTest(returned2, "aba");
        System.out.println("-----------------------------------------");

        System.out.println("Test 03");
        String string3 = "abcabcabc";
        String returned3 = removeConsecDups(string3);
        assertTest(returned3, "abcabcabc");
        System.out.println("-----------------------------------------");

        System.out.println("Test 04");
        String string4 = "aaaaa";
        String returned4 = removeConsecDups(string4);
        assertTest(returned4, "a");
        System.out.println("-----------------------------------------");
    }
}
