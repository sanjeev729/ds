# Data Structures & Algorithms - Java Edition

A comprehensive **Java implementation** of fundamental data structures, algorithms, and concurrent programming patterns with detailed examples, complexity analysis, and real-world applications.

**📌 Repository:** [github.com/sanjeev729/ds](https://github.com/sanjeev729/ds)

## 📚 Table of Contents

- [Overview](#overview)
- [What's Included](#whats-included)
- [Data Structures](#data-structures)
- [Key Topics](#key-topics)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Building & Running](#building--running)
- [Contributing](#contributing)
- [Resources](#resources)

## Overview

This repository contains a comprehensive collection of **Java implementations** for:
- 📊 **Data Structures**: Arrays, Linked Lists, Stacks, Queues, Trees, Graphs, Hash Maps, Heaps, Tries
- 🧮 **Algorithms**: Sorting, Searching, Dynamic Programming, Backtracking, Graph Algorithms
- ⚙️ **Concurrency**: Threading, Synchronization, Producer-Consumer patterns, Wait-Notify mechanisms
- 🔄 **Recursion**: Recursive algorithms and linked list operations
- 💡 **Advanced Topics**: Design patterns, Matrix operations, Mathematical algorithms

Each implementation includes:
- Clear, well-commented Java code
- Time and space complexity analysis
- Practical usage examples
- Edge case handling
- Performance optimization techniques

## What's Included

### 📦 Core Data Structures
- **Arrays**: Integer arrays, sorting, searching, and manipulation algorithms
- **Linked Lists**: Singly, doubly, and circular linked lists with recursive examples
- **Stacks & Queues**: Implementations with practical use cases
- **Trees**: Binary trees, BSTs, traversals, and path finding
- **Graphs**: DFS, BFS, shortest path, and spanning trees
- **Hash Maps**: Custom implementations and collision resolution
- **Heaps**: Min/Max heaps with priority queue operations
- **Tries**: String prefix matching and auto-completion

### 🧮 Algorithms
- **Sorting**: Bubble, Selection, Insertion, Merge, Quick, Heap sort
- **Searching**: Linear, Binary, Rotated arrays
- **Dynamic Programming**: Problem-solving with memoization
- **Backtracking**: N-Queens, Sudoku solver, coin change
- **Graph Algorithms**: Dijkstra's, Kruskal's, Prim's, topological sort
- **Matrix Operations**: Rotation, Island counting, minimum cost paths
- **Mathematical**: GCD, Prime numbers, Power function
- **String Algorithms**: Pattern matching, reversals, transformations

### ⚙️ Concurrency & Threading
- **Wait/Notify Pattern**: Producer-consumer with synchronization
- **Semaphore-based Patterns**: Thread coordination with semaphores
- **Busy-Wait Pattern**: Simple thread communication examples
- **BlockingQueue**: Optimized concurrent queue implementations
- **Thread Synchronization**: Mutex and lock mechanisms
- **Thread Safety**: Best practices and common pitfalls

## Data Structures

### Linear Data Structures

#### 📋 Arrays
- **Description**: Fixed-size sequential collection of elements
- **Time Complexity**: Access O(1), Search O(n), Insert/Delete O(n)
- **Space Complexity**: O(n)
- **Use Cases**: Static data storage, mathematical computations

#### 📝 Linked Lists
- **Singly Linked List**: Nodes with data and next pointer
- **Doubly Linked List**: Nodes with data, next, and previous pointers
- **Circular Linked List**: Last node points to first node
- **Time Complexity**: Access O(n), Insert/Delete O(1) at known position
- **Use Cases**: Dynamic memory allocation, undo functionality

#### 📚 Stacks
- **Description**: LIFO (Last In, First Out) data structure
- **Operations**: Push, Pop, Peek, IsEmpty
- **Time Complexity**: All operations O(1)
- **Use Cases**: Function calls, expression evaluation, backtracking

#### 🚶 Queues
- **Simple Queue**: FIFO (First In, First Out)
- **Circular Queue**: Fixed-size queue with wrap-around
- **Priority Queue**: Elements with associated priorities
- **Deque**: Double-ended queue
- **Time Complexity**: Enqueue/Dequeue O(1)
- **Use Cases**: Task scheduling, breadth-first search, buffering

### Non-Linear Data Structures

#### 🌳 Trees
- **Binary Tree**: Each node has at most two children
- **Binary Search Tree (BST)**: Ordered binary tree
- **AVL Tree**: Self-balancing BST
- **Red-Black Tree**: Self-balancing BST with color properties
- **B-Tree**: Self-balancing tree for databases
- **Trie**: Prefix tree for strings

| Tree Type | Search | Insert | Delete |
|-----------|--------|--------|--------|
| Binary Tree | O(n) | O(n) | O(n) |
| BST (avg) | O(log n) | O(log n) | O(log n) |
| AVL Tree | O(log n) | O(log n) | O(log n) |

#### 🕸️ Graphs
- **Undirected Graph**: Edges have no direction
- **Directed Graph (Digraph)**: Edges have direction
- **Weighted Graph**: Edges have weights/costs
- **Representations**: Adjacency Matrix, Adjacency List
- **Algorithms**: BFS, DFS, Dijkstra's, Kruskal's, Prim's

#### #️⃣ Hash Tables
- **Description**: Key-value pairs with hash function mapping
- **Collision Resolution**: Chaining, Open Addressing
- **Time Complexity**: Average O(1) for all operations
- **Load Factor**: Affects performance
- **Use Cases**: Caches, databases, sets, maps

#### 🗂️ Heaps
- **Min Heap**: Parent ≤ children
- **Max Heap**: Parent ≥ children
- **Binary Heap**: Complete binary tree implementation
- **Time Complexity**: Insert/Delete O(log n), Get Min/Max O(1)
- **Use Cases**: Priority queues, heap sort, graph algorithms

## Getting Started

### Prerequisites
```bash
# Clone the repository
git clone https://github.com/sanjeev729/ds.git
cd ds

# Ensure you have Java 8+ and Maven installed
java -version
mvn -version
```

### Building the Project
```bash
# Build with Maven
mvn clean compile

# Run tests (if available)
mvn test

# Package the project
mvn package
```

### Running Examples

#### Example 1: Using a Stack
```java
// In src/main/java/stack/
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.push(3);

System.out.println(stack.pop());    // Output: 3
System.out.println(stack.peek());   // Output: 2
System.out.println(stack.isEmpty()); // Output: false
```

#### Example 2: Binary Search Tree
```java
// In src/main/java/trees/
class Node {
    int data;
    Node left, right;
    Node(int data) { this.data = data; }
}

Node root = new Node(50);
root.left = new Node(30);
root.right = new Node(70);

// Perform BST operations...
```

#### Example 3: Threading - Producer Consumer
```java
// In src/main/java/Educative/Thread/ConsumerProducer/
// See 1.DemonstrationWaitNotify.java for wait/notify pattern
// See 2.DemonstrationBusyWait.java for busy-wait pattern
// See 3.DemonstrationSemaphore.java for semaphore pattern

final BlockingQueue<Integer> q = new ArrayBlockingQueue<>(5);

Thread producer = new Thread(() -> {
    for (int i = 0; i < 50; i++) {
        q.put(i);
        System.out.println("Produced: " + i);
    }
});

Thread consumer = new Thread(() -> {
    for (int i = 0; i < 50; i++) {
        System.out.println("Consumed: " + q.take());
    }
});

producer.start();
consumer.start();
```

## Project Structure

```
ds/
├── README.md
├── pom.xml                          # Maven configuration
├── scripts/
│   ├── git-commit-push.sh          # Git automation script
│   └── README.md                    # Script documentation
└── src/
    └── main/
        └── java/
            ├── arrays/              # Array algorithms & problems
            │   ├── ChocolateDistribution.java
            │   ├── KthSmallest.java
            │   ├── MaxSumNonAdjacent.java
            │   ├── SearchInRotatedArr.java
            │   └── ... (30+ more)
            ├── backtracking/        # Backtracking algorithms
            │   ├── NQueens.java
            │   ├── SudokuSolver.java
            │   └── CoinChange.java
            ├── binarysearch/        # Binary search problems
            ├── design/              # Design patterns
            ├── dp/                  # Dynamic programming
            ├── Educative/
            │   └── Thread/
            │       └── ConsumerProducer/
            │           ├── 1.DemonstrationWaitNotify.java
            │           ├── 2.DemonstrationBusyWait.java
            │           └── 3.DemonstrationSemaphore.java
            ├── graph/               # Graph algorithms
            │   └── Graph.java
            ├── hashMap/             # Hash table implementations
            │   └── LRUCache.java
            ├── heaps/               # Heap operations
            ├── linkedlist/          # Linked list operations
            ├── linkedlistrecursionexamples/
            │   ├── CustomLinkedList.java
            │   └── NewCustomListRecusive.java
            ├── math/                # Mathematical algorithms
            │   ├── Prime.java
            │   ├── Gcd.java
            │   └── Power.java
            ├── matrix/              # Matrix problems
            │   ├── RotateMatrix.java
            │   ├── NumberOfIslands.java
            │   └── MinimumCostPath.java
            ├── queue/               # Queue implementations
            ├── Recursion/           # Recursive algorithms
            ├── revise/              # LeetCode 75 & interview prep
            │   └── leetcode75/
            ├── sorting/             # Sorting algorithms
            ├── stack/               # Stack implementations
            ├── string/              # String algorithms
            ├── thread/              # Threading examples
            │   └── producerconsumer/
            ├── trees/               # Tree algorithms
            ├── trie/                # Trie (prefix tree)
            └── ... (more packages)
```

## Key Topics

### 🎯 Algorithms by Category

**Sorting (O(n log n) optimized)**
- Merge Sort, Quick Sort, Heap Sort
- Counting Sort, Radix Sort

**Searching**
- Binary Search, Linear Search
- Search in Rotated Array

**Graph Algorithms**
- Breadth-First Search (BFS)
- Depth-First Search (DFS)
- Dijkstra's Algorithm
- Kruskal's & Prim's Algorithm

**Dynamic Programming**
- Fibonacci, Longest Common Subsequence
- 0/1 Knapsack, Coin Change
- Longest Increasing Subsequence

**Backtracking**
- N-Queens Problem
- Sudoku Solver
- Maze Solving

### 📊 Complex Data Structures

**Custom Collections**
- Circular Arrays
- Custom Linked Lists
- LRU Cache Implementation

**Advanced Trees**
- Binary Search Trees
- Tree Traversals (Inorder, Preorder, Postorder)
- Level Order Traversal

**Thread-Safe Structures**
- Synchronized BlockingQueue
- Thread-safe collections with wait/notify

### ⚙️ Concurrency Patterns

**Producer-Consumer Pattern**
- Wait/Notify mechanism
- Semaphore-based approach
- Optimized BlockingQueue

**Thread Synchronization**
- Synchronized methods
- Locks and Conditions
- Race condition prevention

## Building & Running

```bash
# Compile all Java files
mvn compile

# Run a specific class (example: arrays)
java -cp target/classes arrays.ChocolateDistribution

# Run with IDE
# Open project in IntelliJ IDEA, Eclipse, or VS Code
# Run individual classes or main methods directly

# Create executable JAR
mvn package
java -jar target/ds-1.0-SNAPSHOT.jar
```

## Git Automation

This project includes a convenient script for committing and pushing changes:

```bash
# Use the automated git script
./scripts/git-commit-push.sh "Your commit message here"

# Example
./scripts/git-commit-push.sh "Optimize: Add O(n) solution to array problem"
```

For details, see [scripts/README.md](scripts/README.md)

## Complexity Cheat Sheet

| Data Structure | Access | Search | Insertion | Deletion | Space |
|----------------|--------|--------|-----------|----------|--------|
| Array | O(1) | O(n) | O(n) | O(n) | O(n) |
| Stack | O(n) | O(n) | O(1) | O(1) | O(n) |
| Queue | O(n) | O(n) | O(1) | O(1) | O(n) |
| Linked List | O(n) | O(n) | O(1) | O(1) | O(n) |
| Hash Table | N/A | O(1)* | O(1)* | O(1)* | O(n) |
| Binary Search Tree | O(log n)* | O(log n)* | O(log n)* | O(log n)* | O(n) |
| AVL Tree | O(log n) | O(log n) | O(log n) | O(log n) | O(n) |
| Binary Heap | N/A | O(n) | O(log n) | O(log n) | O(n) |

*Average case

## Common Interview Questions

### Easy
- Implement a stack using arrays
- Reverse a linked list
- Check if parentheses are balanced
- Find the maximum element in an array

### Medium
- Implement LRU cache
- Find the lowest common ancestor in a binary tree
- Detect cycle in a linked list
- Implement a trie (prefix tree)

### Hard
- Serialize and deserialize a binary tree
- Find median from data stream
- Design a data structure for social network
- Implement a B-tree

## Performance Tips

1. **Choose the right data structure** based on your use case
2. **Consider memory usage** vs. time complexity trade-offs
3. **Use built-in implementations** when available and appropriate
4. **Profile your code** to identify bottlenecks
5. **Understand amortized complexity** for dynamic structures

## Contributing

1. **Fork** the repository: [github.com/sanjeev729/ds](https://github.com/sanjeev729/ds)
2. **Create a branch**: `git checkout -b feature/new-algorithm`
3. **Implement your code** in the appropriate package
4. **Add documentation** with complexity analysis
5. **Test thoroughly** with edge cases
6. **Commit with clear messages**:
   ```bash
   ./scripts/git-commit-push.sh "Add: FeatureName with O(n) solution"
   ```
7. **Submit a pull request**

### Contribution Guidelines
- ✅ Use proper Java naming conventions (camelCase for methods, PascalCase for classes)
- ✅ Include time and space complexity analysis as comments
- ✅ Add comprehensive test cases
- ✅ Document edge cases and assumptions
- ✅ Update README.md with new topics
- ✅ Follow existing code style
- ✅ Keep methods focused and single-responsibility
- ✅ Use meaningful variable names

### Code Style
```java
// Good: Clear naming and documentation
/**
 * Finds the maximum element in an array
 * Time: O(n), Space: O(1)
 */
public int findMax(int[] arr) {
    int max = arr[0];
    for (int num : arr) {
        max = Math.max(max, num);
    }
    return max;
}
```

## Resources

### 📚 Books (Recommended)
- **"Introduction to Algorithms"** by Cormen, Leiserson, Rivest, and Stein - The definitive algorithms textbook
- **"Data Structures and Algorithms Made Easy"** by Narasimha Karumanchi - Great for practical examples
- **"Cracking the Coding Interview"** by Gayle Laakmann McDowell - Interview preparation

### 🌐 Online Platforms
- [LeetCode](https://leetcode.com/) - Practice coding problems with multiple solutions
- [GeeksforGeeks](https://www.geeksforgeeks.org/) - Comprehensive tutorials and examples
- [Visualgo](https://visualgo.net/) - Interactive algorithm and data structure visualizations
- [HackerRank](https://www.hackerrank.com/) - Coding challenges and competitions
- [Educative.io](https://educative.io/) - Interactive coding courses

### 📺 Video Courses
- **MIT OpenCourseWare** - Introduction to Algorithms (Free)
- **Coursera - Algorithms Specialization** by UC San Diego
- **YouTube Channels**:
  - CS Dojo: Algorithm explanations
  - Tushar Roy: Detailed algorithm walkthroughs
  - Abdul Bari: Data structures fundamentals

### 💡 Java-Specific Resources
- [Oracle Java Documentation](https://docs.oracle.com/javase/) - Official Java API
- [Java Collections Framework](https://docs.oracle.com/javase/tutorial/collections/) - Built-in data structures
- [Java Concurrency in Practice](https://jcip.net/) - Threading and concurrency best practices

### 🏆 Practice Platforms
- [LeetCode 75](https://leetcode.com/studyplan/leetcode-75/) - Curated interview questions
- [CodeSignal](https://codesignal.com/) - Coding assessments
- [InterviewBit](https://www.interviewbit.com/) - Interview preparation

## FAQ

**Q: How do I run the code?**  
A: Clone the repo, ensure Java 8+ is installed, run `mvn compile`, then execute classes via IDE or command line.

**Q: Are there test cases?**  
A: Many classes include main methods with examples. Expand the project with JUnit tests.

**Q: Can I contribute?**  
A: Absolutely! Fork the repo and submit a pull request following the guidelines above.

**Q: Which data structure should I learn first?**  
A: Start with Arrays → Linked Lists → Stacks/Queues → Trees → Graphs

**Q: How do I understand complexity analysis?**  
A: Check the comments in the code and the Complexity Cheat Sheet above.

## Connect & Support

- 📌 **GitHub**: [github.com/sanjeev729/ds](https://github.com/sanjeev729/ds)
- ⭐ **Star this repo** if you find it helpful
- 🐛 **Found a bug?** Open an issue
- 💡 **Have an idea?** Submit a pull request
- 📧 **Questions?** Create a discussion

## License

This project is open source and available under the MIT License.

---

## Quick Navigation

| Topic | Link |
|-------|------|
| Arrays | `src/main/java/arrays/` |
| Linked Lists | `src/main/java/linkedlist/` |
| Trees | `src/main/java/trees/` |
| Graphs | `src/main/java/graph/` |
| Dynamic Programming | `src/main/java/dp/` |
| Backtracking | `src/main/java/backtracking/` |
| Threading | `src/main/java/Educative/Thread/` |
| Interview Prep | `src/main/java/revise/leetcode75/` |

---

**🚀 Happy coding and learning!**

*Last Updated: May 2026*

