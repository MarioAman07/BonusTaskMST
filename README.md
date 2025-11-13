## Bonus Task: Edge Removal from an MST

**Goal:** This project implements the efficient maintenance of a Minimum Spanning Tree (MST) after a single edge removal. When an edge is removed, the MST splits into two connected components (subtrees). The program identifies the lowest-weight edge from the original graph that can reconnect these two components, thus forming a new MST.

---

###  Project Structure and Algorithms Used

* **Initial MST Construction:** Kruskal's Algorithm (using Union-Find structure).
* **Component Identification:** Depth-First Search (DFS) after edge removal.
* **Replacement Edge Finding:** Linear scan over the full set of original graph edges, applying the MST Cut Property to find the minimum-weight bridge.

---

###  Prerequisites

* Java Development Kit (JDK 23 or higher)
* Apache Maven

###  How to Compile and Run the Program

The project is configured with the Maven Shade Plugin to create a single, runnable JAR file that includes all dependencies.

**1. Clone the repository:**
```bash
git clone https://github.com/MarioAman07/BonusTaskMST.git
cd BonusTaskMST
```

**2. Compile and package the project:**
Run the Maven package command. This will build the executable JAR file in the `target/` directory.
```bash
mvn package
```

**3. Run the executable:** 
The main class `(com.mst.bonus.Main)` will use a hardcoded example graph to demonstrate the entire process: building the initial MST, removing an edge, identifying the two resulting components, finding the optimal replacement edge, and calculating the total weight of the new MST.
```bash
java -jar target/BonusTaskMST-1.0-SNAPSHOT.jar
```
**(If using IntelliJ/Maven directly without JAR)**
```bash
mvn clean install exec:java -Dexec.mainClass="com.mst.bonus.Main"
```

### Project Notes and Conclusion
* **Objective Achieved:** This project successfully demonstrates an efficient method for maintaining the **Minimum Spanning Tree (MST)** after the removal of a single edge, effectively showcasing the **MST Cut Property**.
* **Core Efficiency:** The initial MST construction uses **Kruskal's Algorithm** with an optimized **Union-Find** data structure. The replacement edge search is highly efficient, requiring only a linear O(E) scan across the original graph's edges after the components are identified via DFS.
* **Solution Demonstrated:** The resulting output clearly shows the two components formed by the edge removal (the "cut") and proves that the chosen replacement edge is indeed the lightest one capable of reconnecting the graph, thus forming the new Minimum Spanning Tree.
