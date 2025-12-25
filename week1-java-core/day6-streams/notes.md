# Day 6: Modern Java (Streams & Lambdas)

## 1. Key Concepts
- **Imperative (Loops):** Describing *how* to do things (Step-by-step).
- **Declarative (Streams):** Describing *what* result you want.

## 2. Lambda Expressions (`->`)
- Syntax: `(parameter) -> logic`.
- **Method Reference (`::`)**: A shorthand used when the lambda just calls an existing method (e.g., `Order::getPrice` instead of `o -> o.getPrice()`).

## 3. The Stream Pipeline
1.  **Source:** `list.stream()` (Opens the flow).
2.  **Intermediate Operations:** Lazy! Nothing happens until the end.
    -   `.filter(predicate)`: Keeps items that return true.
    -   `.map(function)`: Transforms items (e.g., Order -> Double).
    -   `.sorted()`: Sorts the stream.
3.  **Terminal Operations:** Triggers the work.
    -   `.collect(Collectors.toList())`: Puts result in a List.
    -   `.forEach()`: Performs an action on every item.
    -   `.anyMatch()`: returns boolean if condition is met.
    -   `.collect(Collectors.groupingBy(...))`: Creates a Map (SQL Group By style).

## 4. Status Enums
- Use logic inside Enums (`fromString`) to handle data conversion cleanly, rather than cluttering your data class.