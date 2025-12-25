# 📊 Analytics Tool (Streams API)

On Day 6, I migrated from traditional Loops to **Java Streams (Java 8)**. I built an analytics system that processes "Big Data" (simulated orders) using functional programming.

##  The Problem
Loop-based code is often verbose and hard to read. A simple task like "Find all delivered orders and calculate tax" requires multiple intermediate lists and 10+ lines of code.

##  The Solution
I used **Stream Pipelines** to make the code declarative:
1.  **Filtering:** Removed CANCELLED orders effortlessly.
2.  **Mapping:** Transformed Objects into financial figures.
3.  **Aggregating:** Used `groupingBy` to create a status report (Map) in a single line of code.
4.  **Enum Strategy:** Moved String-to-Enum conversion logic into the Enum itself to ensure type safety in the stream pipeline.

##  Code Comparison
**Before (Loop):** 7 lines, manual iterator, temp variable.
**After (Stream):** 1 line (`stream().filter().collect()`).

##  Key Takeaway
"Streams allow us to treat data flow like a conveyor belt—filtering, transforming, and boxing items up efficiently."