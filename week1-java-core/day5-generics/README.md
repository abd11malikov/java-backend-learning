# 📦 Universal Warehouse System (Generics & Sorting)

On Day 5, I explored how to write flexible, reusable code using **Java Generics**. I built a Warehouse inventory system that can manage products safely and sort them using different strategies.

##  The Problem
In earlier days, if I wanted a list of Strings, I wrote one class. If I wanted a list of Products, I wrote another. This caused code duplication. I also needed a way to sort Products by ID by default, but switch to Price sorting on demand.

##  The Solution
I built a Generic **Inventory System**:

1.  **Generic Storage (`Inventory<T>`):**
    The warehouse handles storage logic generically. I added **Bounded Type Parameters** (`<T extends Product>`) to ensure the warehouse only accepts sellable items, allowing me to calculate total inventory value dynamically.

2.  **Flexible Sorting:**
    - **Comparable:** Implemented `Comparable` in the `Product` class to define "ID order" as the natural sort.
    - **Comparator:** Created a separate logic strategy (`PriceComparator`) to sort by price (Desc/Asc) without changing the original class code.

##  Challenges Solved
- **Bounded Generics:** I modified the generic class to `extends Product` so I could access the `.getPrice()` method inside the generic inventory.
- **Sorting Logic:** Implemented a tie-breaker algorithm: if prices are equal, the sorter automatically falls back to ID sorting to ensure a consistent order.

##  Key Takeaway
"Generics let us write code once and use it for many types, while Comparators give us the flexibility to change behavior at runtime."