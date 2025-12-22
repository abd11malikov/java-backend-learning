# Day 3:  Java Collections Framework

## 1. List (`ArrayList`, `LinkedList`)
- **Behavior:** Ordered list. Allows duplicates.
- **Analogy:** A To-Do list (Item 1, Item 2, Item 2 again).
- **Syntax:** `List<String> names = new ArrayList<>();`

## 2. Set (`HashSet`)
- **Behavior:** Unordered. **NO** duplicates allowed.
- **Analogy:** A bag of marbles. You just reach in and grab one. If you try to put the same marble in twice, it ignores you.
- **Syntax:** `Set<String> ids = new HashSet<>();`

## 3. Map (`HashMap`) - THE MOST IMPORTANT 
- **Behavior:** Key-Value pairs.
- **Analogy:** A Dictionary (Word -> Definition) or a Phone Book (Name -> Number).
- **Syntax:** `Map<String, Integer> salaries = new HashMap<>();`
- **Backend Use:** This is exactly how JSON looks (`{ "name": "John", "age": 25 }`).