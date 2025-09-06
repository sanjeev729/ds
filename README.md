# Datastructures and Algorithms

LinkedLists Trees Arrays DP
Threads custom collections

A comprehensive collection of data structure implementations and algorithms with examples, explanations, and analysis.

## 📚 Table of Contents

- [Overview](#overview)
- [Data Structures](#data-structures)
- [Getting Started](#getting-started)
- [Implementation Languages](#implementation-languages)
- [Contributing](#contributing)
- [Resources](#resources)

## Overview

This repository contains implementations of fundamental data structures used in computer science and software development. Each data structure includes:

- Clear implementation with comments
- Time and space complexity analysis
- Usage examples
- Common operations
- Real-world applications

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
git clone https://github.com/yourusername/data-structures.git
cd data-structures

# Choose your language directory
cd python/  # or java/, cpp/, javascript/, etc.
```

### Running Examples

#### Python
```python
# Example: Using a Stack
from stack import Stack

stack = Stack()
stack.push(1)
stack.push(2)
stack.push(3)

print(stack.pop())  # Output: 3
print(stack.peek()) # Output: 2
print(stack.is_empty()) # Output: False
```

#### JavaScript
```javascript
// Example: Using a Binary Search Tree
const BST = require('./bst');

const tree = new BST();
tree.insert(50);
tree.insert(30);
tree.insert(70);

console.log(tree.search(30)); // true
console.log(tree.inorder());  // [30, 50, 70]
```

## Implementation Languages

- **Python** 🐍 - Clear, readable implementations
- **JavaScript** 🟨 - Web-friendly with modern ES6+ syntax
- **Java** ☕ - Object-oriented with generics
- **C++** ⚡ - Performance-optimized with templates
- **Go** 🔷 - Simple, efficient implementations
- **Rust** 🦀 - Memory-safe systems programming

## Directory Structure

```
data-structures/
├── README.md
├── docs/
│   ├── complexity-analysis.md
│   ├── algorithms.md
│   └── interview-questions.md
├── python/
│   ├── arrays/
│   ├── linked_lists/
│   ├── stacks/
│   ├── queues/
│   ├── trees/
│   ├── graphs/
│   ├── hash_tables/
│   └── heaps/
├── javascript/
├── java/
├── cpp/
├── tests/
└── examples/
```

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

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-structure`)
3. Add your implementation with tests
4. Update documentation
5. Submit a pull request

### Contribution Guidelines
- Include time/space complexity analysis
- Add comprehensive test cases
- Follow language-specific coding conventions
- Update README with new data structures

## Resources

### Books
- "Introduction to Algorithms" by Cormen, Leiserson, Rivest, and Stein
- "Data Structures and Algorithms Made Easy" by Narasimha Karumanchi
- "Cracking the Coding Interview" by Gayle Laakmann McDowell

### Online Resources
- [Visualgo](https://visualgo.net/) - Algorithm and data structure visualizations
- [LeetCode](https://leetcode.com/) - Practice problems
- [GeeksforGeeks](https://www.geeksforgeeks.org/) - Tutorials and examples

### Video Courses
- MIT OpenCourseWare - Introduction to Algorithms
- Coursera - Algorithms Specialization
- YouTube - CS Dojo, Tushar Roy


## Acknowledgments

- Contributors and maintainers
- Computer science educators and textbook authors
- Open source community for inspiration and feedback

---

⭐ **Star this repository** if you find it helpful!

📝 **Found an issue or want to contribute?** Open an issue or submit a pull request.

🚀 **Happy coding and learning!**

