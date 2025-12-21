# Day 2: Inheritance & Interfaces Notes

## 1. Inheritance (`extends`)
- **What is it?** A way for a child class to inherit fields/methods from a parent.
- **Keywords:** `extends`, `super`, `protected`.
- **Rule:** Java supports single inheritance only (A class can extend only one parent).

## 2. Interfaces (`implements`)
- **What is it?** A contract. It defines *what* a class must do, but not *how*.
- **Why use it?** To achieve loose coupling. The backend doesn't care if it's sending an Email or SMS, as long as the class implements `send()`.

## 3. Method Overriding
- **Annotation:** `@Override`
- **Purpose:** Changing the behavior of a parent method in the child class.

## 4. Polymorphism (The Magic)
- **Definition:** Treating different objects (Dog, Cat) as the same type (Animal).
- **Backend Use:** `List<Notification> list = new ArrayList<>();` (We don't care what concrete implementation is inside).