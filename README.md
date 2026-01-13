# 💰 Banking System Application

A console-based banking application built in Java that demonstrates Object-Oriented Programming principles including inheritance, encapsulation, and exception handling.

## 📋 Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [Usage Examples](#usage-examples)
- [Object-Oriented Concepts Demonstrated](#object-oriented-concepts-demonstrated)
- [Future Enhancements](#future-enhancements)
- [Author](#author)

## ✨ Features

- **Account Management**: Create and manage savings accounts
- **Deposit Funds**: Add money to your account with input validation
- **Withdraw Funds**: Remove money with overdraft protection
- **Interest Calculation**: Automatically calculate and add interest to savings accounts
- **Balance Inquiry**: Check current account balance
- **Error Handling**: Graceful handling of invalid transactions
- **User-Friendly Menu**: Interactive console-based interface

## 🛠️ Technologies Used

- **Language**: Java
- **Development Environment**: IntelliJ IDEA
- **Version Control**: Git & GitHub
- **Java Version**: 11 or higher

## 📁 Project Structure
```
TahaProject2/
├── src/
│   ├── Account.java          # Base account class with core banking operations
│   ├── SavingsAccount.java   # Extends Account, adds interest calculation
│   └── Main.java             # Entry point with user interface
├── .gitignore
└── README.md
```

### Class Descriptions

#### `Account.java`
The parent class that provides fundamental banking operations:
- Stores account number and balance
- Handles deposits and withdrawals
- Validates transactions
- Throws exceptions for insufficient funds

#### `SavingsAccount.java`
Extends `Account` to provide savings-specific features:
- Inherits all Account functionality
- Adds interest rate management
- Calculates and applies interest to balance

#### `Main.java`
The application interface:
- Presents interactive menu to users
- Handles user input and navigation
- Manages the account lifecycle
- Implements exception handling for robust operation

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 11 or higher installed
- Command line or IDE (IntelliJ IDEA recommended)

### Running from Command Line

1. **Clone the repository**
```bash
   git clone https://github.com/tahaf786/TahaProject2.git
   cd TahaProject2/src
```

2. **Compile the Java files**
```bash
   javac Account.java
   javac SavingsAccount.java
   javac Main.java
```

3. **Run the application**
```bash
   java Main
```

### Running from IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `Main.java`
3. Click the green ▶️ run button next to `public static void main`
4. Interact with the application in the console

## 💻 Usage Examples

### Sample Session
```
Account Created: SAV001
Balance: $1000.0

=== BANKING SYSTEM ===

--- MENU ---
1. Deposit
2. Withdraw
3. Add Interest
4. Check Balance
5. Exit
Choose option: 1
Deposit amount: $500
Deposited: 500.0
New balance: $1500.0

--- MENU ---
1. Deposit
2. Withdraw
3. Add Interest
4. Check Balance
5. Exit
Choose option: 3
Interest added: 75.0
New balance: $1575.0

--- MENU ---
1. Deposit
2. Withdraw
3. Add Interest
4. Check Balance
5. Exit
Choose option: 2
Withdraw amount: $2000
ERROR: Insufficient funds for account SAV001

--- MENU ---
1. Deposit
2. Withdraw
3. Add Interest
4. Check Balance
5. Exit
Choose option: 5
Goodbye!
```

## 🎓 Object-Oriented Concepts Demonstrated

### 1. **Encapsulation**
- Private fields (`accountNumber`, `balance`, `interestRate`)
- Public methods provide controlled access
- Data integrity maintained through validation

### 2. **Inheritance**
```java
public class SavingsAccount extends Account
```
- `SavingsAccount` inherits all properties and methods from `Account`
- Demonstrates IS-A relationship (SavingsAccount IS-AN Account)
- Code reusability through parent-child relationship

### 3. **Exception Handling**
```java
try {
    savings.withdraw(amount);
} catch (Exception e) {
    System.out.println("ERROR: " + e.getMessage());
}
```
- Throws exceptions for invalid operations
- Gracefully handles errors without crashing
- Provides meaningful error messages to users

### 4. **Constructor Chaining**
```java
super(accountNumber, initialBalance);
```
- Child class calls parent constructor using `super()`
- Proper initialization of inherited fields
- Maintains object creation hierarchy

### 5. **Input Validation**
- Checks for positive deposit amounts
- Prevents overdrafts through balance verification
- Validates user menu choices

## 🔮 Future Enhancements

### Planned Features (Coming Soon)
- [ ] Support for multiple accounts using ArrayList
- [ ] Checking account with overdraft protection
- [ ] Account-to-account transfers
- [ ] Transaction history logging
- [ ] File persistence (save/load account data)
- [ ] JavaFX graphical user interface
- [ ] Account authentication system
- [ ] Monthly statement generation

### Technical Improvements
- [ ] Unit testing with JUnit
- [ ] Logging framework integration
- [ ] Configuration file support
- [ ] Database integration (MySQL/PostgreSQL)
- [ ] REST API for web integration

## 📚 Learning Outcomes

This project demonstrates proficiency in:
- ✅ Core Java programming
- ✅ Object-Oriented Programming (OOP) principles
- ✅ Exception handling and error management
- ✅ Input validation and defensive programming
- ✅ Version control with Git
- ✅ Code organization and documentation
- ✅ User interface design (console-based)

## 🐛 Known Issues

- Menu accepts only integers; entering text causes input mismatch
- No data persistence; accounts reset when application closes
- Single account limitation (to be addressed in v2.0)

## 📝 License

This project is open source and available for educational purposes.

## 👤 Author

**Taha Farooqi**
- LinkedIn: https://www.linkedin.com/in/taha-farooqi-b84119244/
- Email: tahafarooqi2002@gmai.com

## 🙏 Acknowledgments

- Inspired by real-world banking systems
- Built as part of Java learning journey
- Thanks to the Java community for excellent documentation

---

**⭐ If you found this project helpful, please consider giving it a star!**

*Last Updated: January 2026*
