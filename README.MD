# VAPASI-2025 Java Training Project

Welcome to the **VAPASI-2025** training program!  
This repository contains Java exercises on covered topics:

✅ Association  
✅ Exception Handling  
✅ Multilevel Inheritance  
✅ Polymorphism   
✅ Multi Threading


### Assignments Covered:

✅ Splitwise App

---

## 📘 Concept Breakdown

---

### Association

**Definition:**  
Association represents a "has-a" relationship between two or more classes.  
This is a loosely coupled relationship where both entities can exist independently.

**Example Scenario:**
- A `Library` has a list of `Book` objects.
- A `Student` can be associated with a `Department`.

---

### Exception Handling

**Definition:**  
Exception handling allows a program to deal with unexpected events (errors) gracefully using try-catch blocks.

**Key Concepts:**
- `try-catch-finally`
- `throw` and `throws`
- Custom exception classes

**Example Scenario:**
- Throw `InvalidAgeException` if a user inputs age below 18 for voter registration.

---

### Multilevel Inheritance

**Definition:**  
In multilevel inheritance, a class is derived from a class which is also derived from another class.  
This creates a parent → child → grandchild chain.

**Example Scenario:**
- `GrandParent` → `Parent` → `Child`  
  Each level adds or overrides behavior from the previous.

---

### Polymorphism

**Definition:**  
Polymorphism enables methods to behave differently based on the object context.  
It includes:

- **Compile-time Polymorphism:** Method overloading
- **Runtime Polymorphism:** Method overriding using inheritance

**Example Scenario:**
- A `Shape` class has a `draw()` method.
  - `Circle`, `Rectangle`, and `Triangle` each override `draw()` with their specific implementation.

---

### Multi-Threading

**Definition:**  
Multithreading allows concurrent execution of two or more threads (smaller units of a process) to improve application performance, especially in I/O or CPU-intensive tasks.
Java provides built-in support for multithreading using:

- Thread class : Directly extends the Thread class to define the logic to run concurrently.
- Runnable interface : Defines a task to be executed by a thread (more flexible than Thread class).
- ExecutorService (from java.util.concurrent package) : Manages a pool of threads efficiently for large-scale or repeated tasks.
- Thread Lifecycle : NEW → RUNNABLE → RUNNING → BLOCKED → TERMINATED
- Synchronization : Used to avoid thread interference and ensure thread-safe operations.


**Example Scenario:**
- Ticket Booking Using ExecutorService
  - A TicketBookingTask class represents a single booking operation. 
  - It performs validation, payment processing, and confirmation. 
  - Multiple booking requests arrive simultaneously. 
  - An ExecutorService with a fixed thread pool is used to handle each booking task concurrently.



---

## 📘 Assignments Breakdown

---

### Splitwise-App

**Definition:**  
When multiple people incur and share expenses — such as during a trip, group outing, or household — it's often unclear who owes whom and how much. This application calculates each person’s fair share and determines a minimal set of transactions needed to settle all balances.

- Parses expense data from a text file (e.g., "A spent 100 for A, B, C, D")
- Calculates each person’s balance: how much they owe or are owed
- Outputs detailed per-expense settlements or optimized net settlements


---
