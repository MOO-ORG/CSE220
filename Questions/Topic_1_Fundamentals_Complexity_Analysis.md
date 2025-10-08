# Topic 1: Fundamentals & Complexity Analysis
**Question Set: 35 Total Questions**

---

## Part A: Multiple Choice Questions (15 Questions)

### Easy Level (4 Questions)

**MCQ 1 (Easy)**
What does Big O notation represent?
A) Best case time complexity
B) Worst case time complexity  
C) Average case time complexity
D) Space complexity only

**Answer: B) Worst case time complexity**

---

**MCQ 2 (Easy)**
What is the time complexity of accessing an element in an array by index?
A) O(1)
B) O(n)
C) O(log n)
D) O(n²)

**Answer: A) O(1)**

---

**MCQ 3 (Easy)**
Which of the following represents constant time complexity?
A) O(n)
B) O(1)
C) O(log n)
D) O(n log n)

**Answer: B) O(1)**

---

**MCQ 4 (Easy)**
What does the term "algorithm" refer to?
A) A programming language
B) A step-by-step procedure to solve a problem
C) A data structure
D) A computer program

**Answer: B) A step-by-step procedure to solve a problem**

---

### Medium Level (4 Questions)

**MCQ 5 (Medium)**
What is the time complexity of finding the maximum element in an unsorted array?
A) O(1)
B) O(log n)
C) O(n)
D) O(n²)

**Answer: C) O(n)**

---

**MCQ 6 (Medium)**
Which statement about Big Theta (Θ) notation is correct?
A) It represents only the upper bound
B) It represents only the lower bound
C) It represents both upper and lower bounds (tight bound)
D) It represents average case only

**Answer: C) It represents both upper and lower bounds (tight bound)**

---

**MCQ 7 (Medium)**
If an algorithm has time complexity O(n log n), what happens to the running time when the input size doubles?
A) It doubles
B) It quadruples
C) It becomes slightly more than double
D) It remains the same

**Answer: C) It becomes slightly more than double**

---

**MCQ 8 (Medium)**
What is the space complexity of an algorithm that uses a fixed amount of extra memory regardless of input size?
A) O(n)
B) O(1)
C) O(log n)
D) O(n²)

**Answer: B) O(1)**

---

### Hard Level (4 Questions)

**MCQ 9 (Hard)**
Consider two algorithms: Algorithm A has time complexity O(n²) and Algorithm B has O(n log n). At what approximate input size will Algorithm B start outperforming Algorithm A?
A) Always, regardless of input size
B) When n > 10
C) When n > 100
D) It depends on the constants hidden in Big O

**Answer: D) It depends on the constants hidden in Big O**

---

**MCQ 10 (Hard)**
What is the relationship between Big O, Big Omega, and Big Theta notations?
A) O(f(n)) ⊆ Ω(f(n)) ⊆ Θ(f(n))
B) Ω(f(n)) ⊆ O(f(n)) ⊆ Θ(f(n))
C) Θ(f(n)) = O(f(n)) ∩ Ω(f(n))
D) They are completely independent

**Answer: C) Θ(f(n)) = O(f(n)) ∩ Ω(f(n))**

---

**MCQ 11 (Hard)**
Which of the following best describes amortized time complexity?
A) The worst-case time complexity
B) The average time complexity over all possible inputs
C) The average time complexity over a sequence of operations
D) The best-case time complexity

**Answer: C) The average time complexity over a sequence of operations**

---

**MCQ 12 (Hard)**
If f(n) = 3n² + 2n + 1, what is the Big O notation?
A) O(3n² + 2n + 1)
B) O(n²)
C) O(3n²)
D) O(n)

**Answer: B) O(n²)**

---

### Expert Level (3 Questions)

**MCQ 13 (Expert)**
Consider the recurrence relation T(n) = 2T(n/2) + n. Using the Master Theorem, what is the time complexity?
A) O(n)
B) O(n log n)
C) O(n²)
D) O(log n)

**Answer: B) O(n log n)**

---

**MCQ 14 (Expert)**
Which statement about asymptotic analysis is FALSE?
A) Constants and lower-order terms are ignored in Big O
B) Big Omega provides a lower bound
C) Big Theta means the function grows at exactly that rate
D) O(n) always performs better than O(n²) for any input size

**Answer: D) O(n) always performs better than O(n²) for any input size**

---

**MCQ 15 (Expert)**
What is the time complexity of the following nested loop structure?
```
for i = 1 to n:
    for j = i to n:
        // O(1) operation
```
A) O(n)
B) O(n log n)
C) O(n²)
D) O(2^n)

**Answer: C) O(n²)**

---

## Part B: Code Snippet Questions (5 Questions)

### Code Snippet 1
```java
public int mysteryFunction(int n) {
    int count = 0;
    for (int i = 1; i < n; i *= 2) {
        count++;
    }
    return count;
}
```
**Question:** What is the time complexity of this function and what does it compute?

**Answer:** Time complexity is O(log n). The function computes floor(log₂(n)).

---

### Code Snippet 2
```java
public void printPairs(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            System.out.println(arr[i] + ", " + arr[j]);
        }
    }
}
```
**Question:** Analyze the time and space complexity of this algorithm.

**Answer:** Time complexity: O(n²), Space complexity: O(1). It prints all unique pairs from the array.

---

### Code Snippet 3
```java
public int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```
**Question:** What is the time complexity of this recursive Fibonacci implementation and why is it inefficient?

**Answer:** Time complexity: O(2^n). It's inefficient due to repeated calculations of the same subproblems (overlapping subproblems).

---

### Code Snippet 4
```java
public boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}
```
**Question:** What is the time complexity and what optimization technique is used?

**Answer:** Time complexity: O(√n). Optimization: Only checking divisors up to √n instead of n-1.

---

### Code Snippet 5
```java
public void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // swap arr[j] and arr[j+1]
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
**Question:** Analyze the best, average, and worst-case time complexities. What optimization is present?

**Answer:** Best case: O(n) when array is already sorted, Average/Worst case: O(n²). Optimization: Early termination when no swaps occur.

---

## Part C: Problem Solving Questions (15 Questions)

### Easy Level (3 Questions)

**Problem 1 (Easy)**
Write a function that determines if a given algorithm's time complexity is better than O(n²).

```java
public boolean isBetterThanQuadratic(String complexity) {
    // Implementation here
}
```

**Sample Solution:**
```java
public boolean isBetterThanQuadratic(String complexity) {
    String[] betterComplexities = {"O(1)", "O(log n)", "O(n)", "O(n log n)"};
    for (String better : betterComplexities) {
        if (complexity.equals(better)) {
            return true;
        }
    }
    return false;
}
```

---

**Problem 2 (Easy)**
Implement a method that counts the number of operations in a simple loop and returns the Big O notation.

```java
public String analyzeLoop(int n) {
    // Analyze: for(int i = 0; i < n; i++) { /* O(1) operation */ }
    // Return the Big O notation as a string
}
```

**Sample Solution:**
```java
public String analyzeLoop(int n) {
    // The loop runs n times, each iteration is O(1)
    return "O(n)";
}
```

---

**Problem 3 (Easy)**
Write a function that compares two algorithms and returns which one is more efficient.

```java
public String compareAlgorithms(String complexity1, String complexity2) {
    // Return "First", "Second", or "Equal"
}
```

**Sample Solution:**
```java
public String compareAlgorithms(String complexity1, String complexity2) {
    HashMap<String, Integer> complexityOrder = new HashMap<>();
    complexityOrder.put("O(1)", 1);
    complexityOrder.put("O(log n)", 2);
    complexityOrder.put("O(n)", 3);
    complexityOrder.put("O(n log n)", 4);
    complexityOrder.put("O(n²)", 5);
    complexityOrder.put("O(2^n)", 6);
    
    int order1 = complexityOrder.getOrDefault(complexity1, Integer.MAX_VALUE);
    int order2 = complexityOrder.getOrDefault(complexity2, Integer.MAX_VALUE);
    
    if (order1 < order2) return "First";
    else if (order2 < order1) return "Second";
    else return "Equal";
}
```

---

### Medium Level (3 Questions)

**Problem 4 (Medium)**
Analyze and implement a function that calculates the time complexity of nested loops where the inner loop depends on the outer loop variable.

```java
public String analyzeNestedLoop(int n) {
    /*
    Analyze this pattern:
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            // O(1) operation
        }
    }
    */
}
```

**Sample Solution:**
```java
public String analyzeNestedLoop(int n) {
    // Sum from 1 to n: 1 + 2 + 3 + ... + n = n(n+1)/2 = O(n²)
    return "O(n²)";
}
```

---

**Problem 5 (Medium)**
Implement a method that determines the space complexity of an algorithm based on its description.

```java
public String determineSpaceComplexity(String algorithmDescription) {
    // Parse description and return space complexity
    // Examples: "uses array of size n", "uses constant extra space", etc.
}
```

**Sample Solution:**
```java
public String determineSpaceComplexity(String algorithmDescription) {
    if (algorithmDescription.contains("array of size n") || 
        algorithmDescription.contains("list of size n")) {
        return "O(n)";
    } else if (algorithmDescription.contains("constant") || 
               algorithmDescription.contains("fixed")) {
        return "O(1)";
    } else if (algorithmDescription.contains("recursive") && 
               algorithmDescription.contains("depth n")) {
        return "O(n)";
    }
    return "Unable to determine";
}
```

---

**Problem 6 (Medium)**
Create a function that estimates the runtime performance difference between two algorithms for a given input size.

```java
public double estimatePerformanceRatio(String algo1, String algo2, int inputSize) {
    // Return the ratio of algo2 runtime / algo1 runtime
}
```

**Sample Solution:**
```java
public double estimatePerformanceRatio(String algo1, String algo2, int inputSize) {
    double runtime1 = calculateRuntime(algo1, inputSize);
    double runtime2 = calculateRuntime(algo2, inputSize);
    return runtime2 / runtime1;
}

private double calculateRuntime(String complexity, int n) {
    switch (complexity) {
        case "O(1)": return 1.0;
        case "O(log n)": return Math.log(n) / Math.log(2);
        case "O(n)": return n;
        case "O(n log n)": return n * Math.log(n) / Math.log(2);
        case "O(n²)": return n * n;
        case "O(2^n)": return Math.pow(2, n);
        default: return n; // assume linear if unknown
    }
}
```

---

### Hard Level (5 Questions)

**Problem 7 (Hard)**
Implement a complexity analyzer that can parse and analyze the time complexity of simple code patterns.

```java
public class ComplexityAnalyzer {
    public String analyzeCode(String code) {
        // Analyze code patterns and return time complexity
        // Handle: single loops, nested loops, recursive calls
    }
}
```

**Sample Solution:**
```java
public class ComplexityAnalyzer {
    public String analyzeCode(String code) {
        if (code.contains("for") && countOccurrences(code, "for") == 1) {
            if (code.contains("i++") || code.contains("i += 1")) {
                return "O(n)";
            } else if (code.contains("i *= 2")) {
                return "O(log n)";
            }
        } else if (countOccurrences(code, "for") == 2) {
            if (code.contains("j < n") && code.contains("i < n")) {
                return "O(n²)";
            } else if (code.contains("j <= i")) {
                return "O(n²)";
            }
        } else if (code.contains("recursive") || code.contains("return") && 
                  code.contains("function")) {
            return "O(2^n)"; // assume binary recursion
        }
        return "O(1)";
    }
    
    private int countOccurrences(String str, String pattern) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(pattern, index)) != -1) {
            count++;
            index += pattern.length();
        }
        return count;
    }
}
```

---

**Problem 8 (Hard)**
Design and implement a performance benchmarking system that measures actual runtime and compares it with theoretical complexity.

```java
public class PerformanceBenchmark {
    public BenchmarkResult benchmark(Algorithm algorithm, int[] inputSizes) {
        // Measure actual runtime for different input sizes
        // Compare with expected theoretical complexity
    }
}
```

**Sample Solution:**
```java
public class PerformanceBenchmark {
    public class BenchmarkResult {
        public long[] actualTimes;
        public String theoreticalComplexity;
        public double accuracyScore;
    }
    
    public BenchmarkResult benchmark(Algorithm algorithm, int[] inputSizes) {
        BenchmarkResult result = new BenchmarkResult();
        result.actualTimes = new long[inputSizes.length];
        
        for (int i = 0; i < inputSizes.length; i++) {
            long startTime = System.nanoTime();
            algorithm.execute(inputSizes[i]);
            long endTime = System.nanoTime();
            result.actualTimes[i] = endTime - startTime;
        }
        
        result.theoreticalComplexity = algorithm.getExpectedComplexity();
        result.accuracyScore = calculateAccuracy(result.actualTimes, inputSizes, 
                                               result.theoreticalComplexity);
        return result;
    }
    
    private double calculateAccuracy(long[] times, int[] sizes, String complexity) {
        // Calculate how well actual times match theoretical complexity
        // This is a simplified version
        return 0.85; // placeholder
    }
}
```

---

**Problem 9 (Hard)**
Implement a recursive complexity calculator that can determine the time complexity of recursive algorithms using recurrence relations.

```java
public class RecurrenceAnalyzer {
    public String solveRecurrence(String recurrence) {
        // Parse and solve recurrence relations like "T(n) = 2T(n/2) + n"
        // Use Master Theorem when applicable
    }
}
```

**Sample Solution:**
```java
public class RecurrenceAnalyzer {
    public String solveRecurrence(String recurrence) {
        // Simplified parser for common patterns
        if (recurrence.contains("T(n/2)") && recurrence.contains("+ n")) {
            if (recurrence.contains("2T(n/2)")) {
                return "O(n log n)"; // Master Theorem case 2
            } else if (recurrence.contains("T(n/2)")) {
                return "O(n)"; // Master Theorem case 3
            }
        } else if (recurrence.contains("T(n-1)") && recurrence.contains("+ 1")) {
            return "O(n)"; // Linear recursion
        } else if (recurrence.contains("2T(n-1)")) {
            return "O(2^n)"; // Binary recursion
        }
        return "Unable to solve";
    }
}
```

---

**Problem 10 (Hard)**
Create a space-time tradeoff analyzer that suggests optimization strategies.

```java
public class TradeoffAnalyzer {
    public OptimizationSuggestion analyzeTradeoff(String algorithm, 
                                                 String currentComplexity,
                                                 String[] constraints) {
        // Suggest space-time tradeoffs and optimizations
    }
}
```

**Sample Solution:**
```java
public class TradeoffAnalyzer {
    public class OptimizationSuggestion {
        public String suggestion;
        public String newTimeComplexity;
        public String newSpaceComplexity;
        public String[] tradeoffs;
    }
    
    public OptimizationSuggestion analyzeTradeoff(String algorithm, 
                                                 String currentComplexity,
                                                 String[] constraints) {
        OptimizationSuggestion suggestion = new OptimizationSuggestion();
        
        if (currentComplexity.equals("O(n²)") && algorithm.contains("search")) {
            suggestion.suggestion = "Use hash table for O(1) lookups";
            suggestion.newTimeComplexity = "O(n)";
            suggestion.newSpaceComplexity = "O(n)";
            suggestion.tradeoffs = new String[]{"Increased space usage", "Faster lookups"};
        } else if (currentComplexity.equals("O(2^n)") && algorithm.contains("recursive")) {
            suggestion.suggestion = "Use dynamic programming with memoization";
            suggestion.newTimeComplexity = "O(n²)";
            suggestion.newSpaceComplexity = "O(n²)";
            suggestion.tradeoffs = new String[]{"Exponential to polynomial time", "Additional memory needed"};
        }
        
        return suggestion;
    }
}
```

---

**Problem 11 (Hard)**
Implement an algorithm complexity predictor that forecasts performance for large inputs.

```java
public class ComplexityPredictor {
    public PredictionResult predictPerformance(String complexity, 
                                             long targetInputSize,
                                             double[] benchmarkData,
                                             int[] benchmarkSizes) {
        // Predict runtime for very large inputs based on smaller benchmarks
    }
}
```

**Sample Solution:**
```java
public class ComplexityPredictor {
    public class PredictionResult {
        public double estimatedTime;
        public double confidenceLevel;
        public String[] warnings;
    }
    
    public PredictionResult predictPerformance(String complexity, 
                                             long targetInputSize,
                                             double[] benchmarkData,
                                             int[] benchmarkSizes) {
        PredictionResult result = new PredictionResult();
        
        // Find the constant factor from benchmark data
        double avgConstant = 0;
        for (int i = 0; i < benchmarkData.length; i++) {
            double theoreticalTime = calculateTheoreticalTime(complexity, benchmarkSizes[i]);
            avgConstant += benchmarkData[i] / theoreticalTime;
        }
        avgConstant /= benchmarkData.length;
        
        // Predict for target size
        double theoreticalTarget = calculateTheoreticalTime(complexity, targetInputSize);
        result.estimatedTime = avgConstant * theoreticalTarget;
        result.confidenceLevel = calculateConfidence(benchmarkData, benchmarkSizes);
        
        if (targetInputSize > 1000000 && complexity.contains("n²")) {
            result.warnings = new String[]{"Very large input with quadratic complexity - may be slow"};
        }
        
        return result;
    }
    
    private double calculateTheoreticalTime(String complexity, long n) {
        switch (complexity) {
            case "O(1)": return 1.0;
            case "O(log n)": return Math.log(n);
            case "O(n)": return n;
            case "O(n log n)": return n * Math.log(n);
            case "O(n²)": return n * n;
            default: return n;
        }
    }
    
    private double calculateConfidence(double[] data, int[] sizes) {
        // Simplified confidence calculation
        return 0.85;
    }
}
```

---

### Expert Level (4 Questions)

**Problem 12 (Expert)**
Design a comprehensive algorithm analysis framework that can handle amortized analysis, probabilistic analysis, and worst-case analysis.

```java
public class AdvancedAnalysisFramework {
    public AnalysisReport comprehensiveAnalysis(AlgorithmSpecification spec) {
        // Perform multiple types of complexity analysis
        // Include amortized, probabilistic, and competitive analysis
    }
}
```

**Sample Solution:**
```java
public class AdvancedAnalysisFramework {
    public class AnalysisReport {
        public String worstCase;
        public String averageCase;
        public String bestCase;
        public String amortizedComplexity;
        public double probabilisticBound;
        public String[] assumptions;
    }
    
    public AnalysisReport comprehensiveAnalysis(AlgorithmSpecification spec) {
        AnalysisReport report = new AnalysisReport();
        
        // Worst-case analysis
        report.worstCase = analyzeWorstCase(spec);
        
        // Average-case analysis
        report.averageCase = analyzeAverageCase(spec);
        
        // Best-case analysis
        report.bestCase = analyzeBestCase(spec);
        
        // Amortized analysis for data structures with occasional expensive operations
        if (spec.hasAmortizedBehavior()) {
            report.amortizedComplexity = analyzeAmortized(spec);
        }
        
        // Probabilistic analysis for randomized algorithms
        if (spec.isRandomized()) {
            report.probabilisticBound = analyzeProbabilistic(spec);
        }
        
        report.assumptions = spec.getAssumptions();
        return report;
    }
    
    private String analyzeWorstCase(AlgorithmSpecification spec) {
        // Implementation for worst-case analysis
        return "O(" + spec.getWorstCasePattern() + ")";
    }
    
    private String analyzeAverageCase(AlgorithmSpecification spec) {
        // Implementation for average-case analysis
        return "O(" + spec.getAverageCasePattern() + ")";
    }
    
    private String analyzeBestCase(AlgorithmSpecification spec) {
        // Implementation for best-case analysis
        return "O(" + spec.getBestCasePattern() + ")";
    }
    
    private String analyzeAmortized(AlgorithmSpecification spec) {
        // Amortized analysis using potential method or accounting method
        return "O(" + spec.getAmortizedPattern() + ")";
    }
    
    private double analyzeProbabilistic(AlgorithmSpecification spec) {
        // Probabilistic analysis for expected performance
        return spec.getExpectedPerformance();
    }
}
```

---

**Problem 13 (Expert)**
Implement a complexity optimization advisor that automatically suggests algorithmic improvements based on bottleneck analysis.

```java
public class OptimizationAdvisor {
    public OptimizationPlan generateOptimizationPlan(CodeProfile profile,
                                                    PerformanceConstraints constraints) {
        // Analyze code profile and suggest specific optimizations
        // Consider caching, memoization, better data structures, etc.
    }
}
```

**Sample Solution:**
```java
public class OptimizationAdvisor {
    public class OptimizationPlan {
        public List<OptimizationStep> steps;
        public String expectedImprovement;
        public double confidenceScore;
        public String[] risks;
    }
    
    public class OptimizationStep {
        public String description;
        public String technique;
        public String complexity;
        public int priority;
    }
    
    public OptimizationPlan generateOptimizationPlan(CodeProfile profile,
                                                    PerformanceConstraints constraints) {
        OptimizationPlan plan = new OptimizationPlan();
        plan.steps = new ArrayList<>();
        
        // Analyze bottlenecks
        if (profile.hasRepeatedCalculations()) {
            OptimizationStep memoization = new OptimizationStep();
            memoization.description = "Add memoization for repeated calculations";
            memoization.technique = "Dynamic Programming";
            memoization.complexity = "Reduce from O(2^n) to O(n²)";
            memoization.priority = 1;
            plan.steps.add(memoization);
        }
        
        if (profile.hasLinearSearches() && profile.getDataSize() > 1000) {
            OptimizationStep indexing = new OptimizationStep();
            indexing.description = "Replace linear search with hash table";
            indexing.technique = "Hash-based indexing";
            indexing.complexity = "Reduce from O(n) to O(1)";
            indexing.priority = 2;
            plan.steps.add(indexing);
        }
        
        if (profile.hasNestedLoops() && profile.getMaxNesting() > 2) {
            OptimizationStep algorithm = new OptimizationStep();
            algorithm.description = "Consider divide-and-conquer approach";
            algorithm.technique = "Algorithmic redesign";
            algorithm.complexity = "Reduce from O(n³) to O(n log n)";
            algorithm.priority = 3;
            plan.steps.add(algorithm);
        }
        
        plan.expectedImprovement = calculateExpectedImprovement(plan.steps, profile);
        plan.confidenceScore = calculateConfidenceScore(plan.steps);
        plan.risks = identifyRisks(plan.steps);
        
        return plan;
    }
    
    private String calculateExpectedImprovement(List<OptimizationStep> steps, CodeProfile profile) {
        // Calculate overall expected improvement
        return "50-80% performance improvement";
    }
    
    private double calculateConfidenceScore(List<OptimizationStep> steps) {
        // Calculate confidence in the optimization plan
        return 0.85;
    }
    
    private String[] identifyRisks(List<OptimizationStep> steps) {
        return new String[]{"Increased memory usage", "Code complexity increase"};
    }
}
```

---

**Problem 14 (Expert)**
Create a parallel algorithm complexity analyzer that considers parallelization opportunities and analyzes parallel speedup potential.

```java
public class ParallelComplexityAnalyzer {
    public ParallelAnalysisResult analyzeParallelization(Algorithm algorithm,
                                                        int processorCount) {
        // Analyze potential for parallelization
        // Calculate theoretical speedup using Amdahl's Law
        // Identify parallelizable and serial portions
    }
}
```

**Sample Solution:**
```java
public class ParallelComplexityAnalyzer {
    public class ParallelAnalysisResult {
        public double serialFraction;
        public double parallelFraction;
        public double theoreticalSpeedup;
        public double efficiency;
        public String bottleneck;
        public List<ParallelizationOpportunity> opportunities;
    }
    
    public class ParallelizationOpportunity {
        public String section;
        public String technique;
        public double expectedSpeedup;
        public String[] challenges;
    }
    
    public ParallelAnalysisResult analyzeParallelization(Algorithm algorithm,
                                                        int processorCount) {
        ParallelAnalysisResult result = new ParallelAnalysisResult();
        
        // Analyze algorithm structure
        AlgorithmStructure structure = analyzeStructure(algorithm);
        
        // Calculate serial and parallel fractions
        result.serialFraction = structure.getSerialFraction();
        result.parallelFraction = 1.0 - result.serialFraction;
        
        // Apply Amdahl's Law: Speedup = 1 / (S + P/N)
        // where S = serial fraction, P = parallel fraction, N = processor count
        result.theoreticalSpeedup = 1.0 / (result.serialFraction + 
                                          result.parallelFraction / processorCount);
        
        // Calculate efficiency
        result.efficiency = result.theoreticalSpeedup / processorCount;
        
        // Identify bottlenecks
        if (result.serialFraction > 0.5) {
            result.bottleneck = "High serial fraction limits parallelization";
        } else if (processorCount > 10 && result.efficiency < 0.5) {
            result.bottleneck = "Communication overhead dominates";
        } else {
            result.bottleneck = "No major bottlenecks identified";
        }
        
        // Identify parallelization opportunities
        result.opportunities = identifyOpportunities(structure, processorCount);
        
        return result;
    }
    
    private AlgorithmStructure analyzeStructure(Algorithm algorithm) {
        // Analyze the algorithm to identify parallel and serial sections
        // This is a simplified implementation
        return new AlgorithmStructure(0.2, 0.8); // 20% serial, 80% parallel
    }
    
    private List<ParallelizationOpportunity> identifyOpportunities(AlgorithmStructure structure,
                                                                  int processors) {
        List<ParallelizationOpportunity> opportunities = new ArrayList<>();
        
        if (structure.hasIndependentLoops()) {
            ParallelizationOpportunity loopParallel = new ParallelizationOpportunity();
            loopParallel.section = "Independent loop iterations";
            loopParallel.technique = "Loop parallelization";
            loopParallel.expectedSpeedup = Math.min(processors, structure.getLoopIterations() / 100.0);
            loopParallel.challenges = new String[]{"Load balancing", "Memory bandwidth"};
            opportunities.add(loopParallel);
        }
        
        if (structure.hasDivideAndConquer()) {
            ParallelizationOpportunity dacParallel = new ParallelizationOpportunity();
            dacParallel.section = "Divide and conquer recursion";
            dacParallel.technique = "Recursive task parallelism";
            dacParallel.expectedSpeedup = Math.log(processors) / Math.log(2);
            dacParallel.challenges = new String[]{"Task creation overhead", "Work stealing"};
            opportunities.add(dacParallel);
        }
        
        return opportunities;
    }
    
    // Helper class for algorithm structure analysis
    private class AlgorithmStructure {
        private double serialFraction;
        private double parallelFraction;
        
        public AlgorithmStructure(double serial, double parallel) {
            this.serialFraction = serial;
            this.parallelFraction = parallel;
        }
        
        public double getSerialFraction() { return serialFraction; }
        public double getParallelFraction() { return parallelFraction; }
        public boolean hasIndependentLoops() { return true; } // simplified
        public boolean hasDivideAndConquer() { return false; } // simplified
        public int getLoopIterations() { return 1000; } // simplified
    }
}
```

---

**Problem 15 (Expert)**
Design and implement a machine learning-based complexity predictor that learns from historical performance data to predict algorithm performance on new inputs.

```java
public class MLComplexityPredictor {
    public PredictionModel trainModel(List<AlgorithmProfile> historicalData) {
        // Train ML model on historical algorithm performance data
        // Use features like input characteristics, algorithm type, etc.
    }
    
    public PerformancePrediction predict(PredictionModel model, AlgorithmProfile newAlgorithm) {
        // Predict performance characteristics for new algorithm
    }
}
```

**Sample Solution:**
```java
public class MLComplexityPredictor {
    public class PredictionModel {
        private Map<String, Double> weights;
        private String modelType;
        private double accuracy;
        
        public PredictionModel(Map<String, Double> weights, String type, double acc) {
            this.weights = weights;
            this.modelType = type;
            this.accuracy = acc;
        }
        
        public Map<String, Double> getWeights() { return weights; }
        public String getModelType() { return modelType; }
        public double getAccuracy() { return accuracy; }
    }
    
    public class PerformancePrediction {
        public String predictedComplexity;
        public double confidence;
        public double estimatedRuntime;
        public String[] uncertaintyFactors;
    }
    
    public class AlgorithmProfile {
        public String algorithmType;
        public Map<String, Double> inputCharacteristics;
        public String actualComplexity;
        public double measuredRuntime;
        public int inputSize;
    }
    
    public PredictionModel trainModel(List<AlgorithmProfile> historicalData) {
        Map<String, Double> weights = new HashMap<>();
        
        // Feature extraction and weight calculation (simplified)
        // In real implementation, would use proper ML algorithms
        
        double totalSamples = historicalData.size();
        Map<String, Integer> complexityCounts = new HashMap<>();
        Map<String, Double> featureImportance = new HashMap<>();
        
        // Analyze historical data
        for (AlgorithmProfile profile : historicalData) {
            complexityCounts.put(profile.actualComplexity,
                complexityCounts.getOrDefault(profile.actualComplexity, 0) + 1);
            
            // Calculate feature importance based on correlation with performance
            for (Map.Entry<String, Double> feature : profile.inputCharacteristics.entrySet()) {
                double importance = calculateCorrelation(feature.getValue(), profile.measuredRuntime);
                featureImportance.put(feature.getKey(),
                    featureImportance.getOrDefault(feature.getKey(), 0.0) + importance);
            }
        }
        
        // Normalize feature importance
        for (Map.Entry<String, Double> entry : featureImportance.entrySet()) {
            weights.put(entry.getKey(), entry.getValue() / totalSamples);
        }
        
        // Calculate model accuracy (simplified)
        double accuracy = calculateCrossValidationAccuracy(historicalData, weights);
        
        return new PredictionModel(weights, "Linear Regression", accuracy);
    }
    
    public PerformancePrediction predict(PredictionModel model, AlgorithmProfile newAlgorithm) {
        PerformancePrediction prediction = new PerformancePrediction();
        
        // Calculate predicted complexity using weighted features
        double complexityScore = 0.0;
        Map<String, Double> weights = model.getWeights();
        
        for (Map.Entry<String, Double> feature : newAlgorithm.inputCharacteristics.entrySet()) {
            double weight = weights.getOrDefault(feature.getKey(), 0.0);
            complexityScore += feature.getValue() * weight;
        }
        
        // Map complexity score to actual complexity class
        prediction.predictedComplexity = mapScoreToComplexity(complexityScore);
        
        // Calculate confidence based on model accuracy and feature similarity
        prediction.confidence = model.getAccuracy() * calculateFeatureSimilarity(newAlgorithm);
        
        // Estimate runtime based on predicted complexity and input size
        prediction.estimatedRuntime = estimateRuntime(prediction.predictedComplexity, 
                                                    newAlgorithm.inputSize);
        
        // Identify uncertainty factors
        prediction.uncertaintyFactors = identifyUncertaintyFactors(newAlgorithm, model);
        
        return prediction;
    }
    
    private double calculateCorrelation(double feature, double runtime) {
        // Simplified correlation calculation
        return Math.abs(feature - runtime) / (feature + runtime + 1.0);
    }
    
    private double calculateCrossValidationAccuracy(List<AlgorithmProfile> data, 
                                                   Map<String, Double> weights) {
        // Simplified cross-validation
        return 0.85; // placeholder
    }
    
    private String mapScoreToComplexity(double score) {
        if (score < 1.0) return "O(1)";
        else if (score < 2.0) return "O(log n)";
        else if (score < 3.0) return "O(n)";
        else if (score < 4.0) return "O(n log n)";
        else if (score < 5.0) return "O(n²)";
        else return "O(2^n)";
    }
    
    private double calculateFeatureSimilarity(AlgorithmProfile profile) {
        // Calculate how similar the new algorithm is to training data
        return 0.8; // placeholder
    }
    
    private double estimateRuntime(String complexity, int inputSize) {
        switch (complexity) {
            case "O(1)": return 1.0;
            case "O(log n)": return Math.log(inputSize);
            case "O(n)": return inputSize;
            case "O(n log n)": return inputSize * Math.log(inputSize);
            case "O(n²)": return inputSize * inputSize;
            case "O(2^n)": return Math.pow(2, Math.min(inputSize, 20)); // cap for safety
            default: return inputSize;
        }
    }
    
    private String[] identifyUncertaintyFactors(AlgorithmProfile profile, PredictionModel model) {
        List<String> factors = new ArrayList<>();
        
        if (model.getAccuracy() < 0.8) {
            factors.add("Model accuracy is relatively low");
        }
        
        if (profile.algorithmType.equals("novel")) {
            factors.add("Algorithm type not well represented in training data");
        }
        
        if (profile.inputSize > 100000) {
            factors.add("Input size larger than most training examples");
        }
        
        return factors.toArray(new String[0]);
    }
}
```

---

## Summary
This question set covers the fundamental concepts of algorithm complexity analysis with a comprehensive range of difficulty levels. The questions progress from basic Big O understanding to advanced topics like amortized analysis, parallel computing, and machine learning applications in complexity prediction.

**Key Learning Objectives Covered:**
- Understanding of Big O, Big Theta, and Big Omega notations
- Time and space complexity analysis
- Practical algorithm analysis skills
- Advanced topics like amortized analysis and parallelization
- Real-world application of complexity theory

**Total Questions: 35**
- MCQ: 15 (Easy: 4, Medium: 4, Hard: 4, Expert: 3)
- Code Snippet: 5 (Mixed difficulty)
- Problem Solving: 15 (Easy: 3, Medium: 3, Hard: 5, Expert: 4)