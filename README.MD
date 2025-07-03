# VAPASI-2025 Java Training Project

Welcome to the **VAPASI-2025** training program!  
This repository contains Java examples and exercises that cover core OOP concepts, including:

✅ Association  
✅ Exception Handling  
✅ Multilevel Inheritance  
✅ Polymorphism

---


---

## 📘 Concept Breakdown

---

### 1️⃣ Association

**Definition:**  
Association represents a "has-a" relationship between two or more classes.  
This is a loosely coupled relationship where both entities can exist independently.

**Example Scenario:**
- A `Library` has a list of `Book` objects.
- A `Student` can be associated with a `Department`.

**File:**  
`association/AssociationDemo.java`

---

### 2️⃣ Exception Handling

**Definition:**  
Exception handling allows a program to deal with unexpected events (errors) gracefully using try-catch blocks.

**Key Concepts:**
- `try-catch-finally`
- `throw` and `throws`
- Custom exception classes

**Example Scenario:**
- Throw `InvalidAgeException` if a user inputs age below 18 for voter registration.

**File:**  
`exception/CustomExceptionDemo.java`

---

### 3️⃣ Multilevel Inheritance

**Definition:**  
In multilevel inheritance, a class is derived from a class which is also derived from another class.  
This creates a parent → child → grandchild chain.

**Example Scenario:**
- `GrandParent` → `Parent` → `Child`  
  Each level adds or overrides behavior from the previous.

**File:**  
`inheritance/MultilevelInheritanceDemo.java`

---

### 4️⃣ Polymorphism

**Definition:**  
Polymorphism enables methods to behave differently based on the object context.  
It includes:

- **Compile-time Polymorphism:** Method overloading
- **Runtime Polymorphism:** Method overriding using inheritance

**Example Scenario:**
- A `Shape` class has a `draw()` method.
  - `Circle`, `Rectangle`, and `Triangle` each override `draw()` with their specific implementation.

**File:**  
`polymorphism/PolymorphismDemo.java`

---

## 🚀 How to Run the Project

Make sure Java (JDK 8 or above) is installed on your system.

### 🔧 Compile and Run Each File Individually:

```bash
javac association/AssociationDemo.java
java association.AssociationDemo

javac exception/CustomExceptionDemo.java
java exception.CustomExceptionDemo

javac inheritance/MultilevelInheritanceDemo.java
java inheritance.MultilevelInheritanceDemo

javac polymorphism/PolymorphismDemo.java
java polymorphism.PolymorphismDemo
```