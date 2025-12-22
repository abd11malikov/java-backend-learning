# JavaBank - Console Banking Application 🏦

This is a mini-project I built on **Day 3** of my Java Backend learning journey. The goal was to move away from simple variables and arrays and build a system using the **Java Collections Framework** to manage data relationships in memory.

##  Why I built this
I wanted to simulate how a real backend manages data before learning Databases. I realized that a bank needs to link **Users** to **Balances** and **Transactions**, which is impossible with just Arrays.

##  How it works
This application runs in the console and simulates a session-based banking system.
- **Users** can register with a unique ID.
- **Balances** are updated in real-time.
- **Transactions** are recorded and can be printed as a statement.

##  Design Choices & Data Structures
Instead of using a Database (since I haven't learned SQL yet), I used Collections to act as an in-memory store:

- **`HashMap<Integer, Double>` for Balances:**
  I chose a Map instead of a List for balances because I needed to look up a user's money instantly using their ID, without looping through all users.

- **`HashMap<Integer, List<Transaction>>` for History:**
  This was the trickiest part. I needed to map one User ID to *many* transactions. I used a Map where the value is an `ArrayList`.

- **`ArrayList` for Users:**
  Used for simple storage of User objects to iterate through logins.

##  How to Run
1. Run the `Main.java` file.
2. Use the menu to **Sign Up** first.
3. **Sign In** with your ID to deposit/withdraw money.

##  Future Improvements
Currently, data is lost when the program stops. In Week 2, I plan to refactor this to use **PostgreSQL** so the data persists.