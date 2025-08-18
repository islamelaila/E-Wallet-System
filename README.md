💳 E-Wallet System

E-Wallet System is a digital wallet application built in Java with a command-line interface (CLI).
It is designed to securely manage personal financial accounts and perform basic financial transactions such as registration, login, password management, balance checking, deposits, withdrawals, and money transfers.

📌 Key Features

Account Management: Create new accounts with validation for username, email, phone number, and password.

Login & Logout: Secure login using email and password, with a “Forgot Password” feature.

Password Management: Change your password with validation according to security rules.

Financial Transactions:

Deposit: Add money to your digital wallet.

Withdraw: Withdraw money from your wallet.

Transfer: Send money to other registered users.

Profile Management: View and update personal information like email, phone number, and password.

🛠️ Technologies Used

Language: Java

Data Storage: Collections (ArrayList)

Input Validation: Custom logic and regex

Password Validation: Custom rules to ensure security

🚀 How to Run
git clone https://github.com/islamelaila/E-Wallet-System.git
cd E-Wallet-System
javac Main.java
java Main

🧪 How to Use

Register a new account: Select option "b" from the main menu and enter the required details.

Login: Select option "a" and enter your email and password.

Forgot Password: Select option "f" and follow instructions to reset your password.

Perform transactions: After login, choose from the submenu to deposit, withdraw, or transfer money.

🔐 Security Notes

Password validation rules:

Must include at least one uppercase and one lowercase letter.

Must include at least one number.

Must include at least one special character from: @#$%&^*_+)(!

Must be at least 10 characters long.

🔮 Future Work

The E-Wallet System is a basic CLI-based application. The following improvements and features could be added in future versions:

Graphical User Interface (GUI)

Implement a user-friendly interface using JavaFX or Swing to enhance usability.

Database Integration

Replace in-memory storage (ArrayList) with a relational database (MySQL, PostgreSQL) for persistent storage.

Enhanced Security

Add password hashing (e.g., using BCrypt) instead of storing plain text passwords.

Implement two-factor authentication (2FA) for login.

Transaction History

Track and display a user’s transaction history, including deposits, withdrawals, and transfers.

Multi-Currency Support

Support multiple currencies and conversion rates for international transactions.

Email Notifications

Send confirmation emails for registration, password resets, and transactions.

APIs & Web Version

Build a RESTful API to allow integration with web or mobile applications.

Unit Testing & CI/CD

Implement automated testing using JUnit.

Set up continuous integration pipelines to improve reliability.

Advanced Features

Budgeting and spending analytics.

Scheduled transfers and recurring payments.
