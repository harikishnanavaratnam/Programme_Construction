# Assessment 3: ATM Simulation for ABC Bank

## Problem Statement

### Scenario

You are required to simulate an ATM for ABC Bank. For each client, ABC Bank keeps a record of the client’s ID, name, nationality, occupation, address, age, and gender. A client must obtain a PIN (Personal Identification Number) to access the ATM. ABC Bank offers savings accounts, current accounts, and loans for its clients. A client can have multiple bank accounts. Each account has an account number, the currency in which the account is operated, the branch, and the balance. The bank pays interest for savings accounts. ABC Bank has a restriction that all the accounts of a given client should be operated in a single currency. A client with any bank account can request a loan, and a loan is linked to an account. A loan has the amount, interest, duration, and payment method.

Using the ATM, clients of ABC Bank can perform various transactions. Each transaction is recorded with a transaction ID, bank account ID, date, and status (whether the transaction is a success, failure, or cancellation). The possible transactions are deposits, withdrawals, and balance inquiries. The transaction amount should be recorded for deposits and withdrawals, while the balance should be recorded for balance inquiries.

### ATM Sequence of Events

Upon visiting the ABC ATM, the client will experience the following sequence of events:

1. The client is shown “Welcome!” and asked to enter the PIN.
2. The client is shown their accounts in ABC Bank and asked to select one account to proceed.
3. The client is shown the main menu:
   - **Main Menu**
     - View Balance.
     - Withdraw Money.
     - Deposit Money.
     - Exit.
4. The client will enter their choice. If Option 2 (Withdraw Money) or Option 3 (Deposit Money) is selected, the client will be asked to enter the amount. Once the transaction is completed, the remaining balance should be displayed.

### Tasks

1. **Create a Class Diagram**:
   - Design a class diagram based on the above scenario.
   - Self-study class diagrams from the following sources:
     - [JavaTpoint - UML Class Diagram](https://www.javatpoint.com/uml-class-diagram)
     - [TutorialsPoint - UML Class Diagram](https://www.tutorialspoint.com/uml/uml_class_diagram.htm)
   - Use an online tool like Creately to create the class diagrams:
     - [Creately - Class Diagram Relationships](https://creately.com/guides/class-diagram-relationships/)

2. **Implement Java Code for the ATM Machine**:
   - Implement the ATM system for ABC Bank in Java.
   - Ensure your code is readable with comments, and proper class, variable, and method names.

3. **Submission**:
   - Include your class diagram and Java code in a PDF file.
   - Rename the PDF with your index number (e.g., 211234A).
   - Upload the PDF to Moodle.
   - **Note**: This is a Turnitin assignment, and code plagiarism will be checked automatically.
