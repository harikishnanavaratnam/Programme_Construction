import java.util.Scanner;
//Bank Details 
//acc_no --> account number
//br_Name --> branch name 
//curr --> currency
class B_Account {
    private String acc_no;
    private String currency_type;
    private String br_Name;
    private double balance;

    public B_Account(String acc_no, String currency_type, String br_Name, double balance) {
        this.acc_no = acc_no;
        this.currency_type = currency_type;
        this.br_Name = br_Name;
        this.balance = balance;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public String getcurr() {
        return currency_type;
    }

    public String getbr_Name() {
        return br_Name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

//Saving accout
class saving_Account extends B_Account {
    private double interestRate;

    public saving_Account(String acc_no, String currency_type, String br_Name, double balance, double interestRate) {
        super(acc_no, currency_type, br_Name, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}

//Classs for loan
class Loan {
    private double amount;
    private double interest;
    private int timeperiod;
    private String methodofpay;
    private B_Account account;

    public Loan(double amount, double interest, int timeperiod, String methodofpay, B_Account account) {
        this.amount = amount;
        this.interest = interest;
        this.timeperiod = timeperiod;
        this.methodofpay = methodofpay;
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public double getInterest() {
        return interest;
    }

    public int gettimeperiod() {
        return timeperiod;
    }

    public String getmethodofpay() {
        return methodofpay;
    }

    public B_Account getAccount() {
        return account;
    }
}

//Details of clients
//acc --> account
class Client {
    private int id;
    private String name;
    private String nationality;
    private String work;
    private String address;
    private int age;
    private String gender;
    private String pin;
    private B_Account[] acc;
    private Loan[] loans;

    public Client(int id, String name, String nationality, String work, String address, int age, String gender, String pin, B_Account[] acc, Loan[] loans) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.work = work;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.pin = pin;
        this.acc = acc;
        this.loans = loans;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getOccupation() {
        return work;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPin() {
        return pin;
    }

    public B_Account[] getacc() {
        return acc;
    }

    public Loan[] getLoans() {
        return loans;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}

//Main class that contains ATM
//C_person --> Client
public class ATM {
    private Client C_person;
    private B_Account curr_acc;
    
    public ATM(Client C_person) {
        this.C_person = C_person;
        authenticate();
        selectaccount();
        mainMenu();
        }
    
        private void authenticate() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome!");
            System.out.print("Please enter your PIN: ");
            String pin = scanner.nextLine();
            while (!pin.equals(C_person.getPin())) {
                System.out.print("Invalid PIN. Please try again: ");
                pin = scanner.nextLine();
            }
        }
        
        private void selectaccount() {
            Scanner scanner = new Scanner(System.in);
            B_Account[] acc = C_person.getacc();
            System.out.println("Please select an account:");
            for (int i = 0; i < acc.length; i++) {
                System.out.printf("%d. %s (%.2f %s)%n", i + 1, acc[i].getAcc_no(), acc[i].getBalance(), acc[i].getcurr());
            }
            System.out.print("Enter the number of the account: ");
            int accountIndex = scanner.nextInt() - 1;
            curr_acc = acc[accountIndex];
        }
        
        private void mainMenu() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Main Menu");
                System.out.println("1. View Balance");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Deposit Money");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        viewBalance();
                        break;
                    case 2:
                        withdrawMoney();
                        break;
                    case 3:
                        depositMoney();
                        break;
                    case 4:
                        exit();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        
        private void viewBalance() {
            System.out.printf("Your balance is %.2f %s.%n", curr_acc.getBalance(), curr_acc.getcurr());
        }
        
        private void withdrawMoney() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the amount to withdraw: ");
            double amount = scanner.nextDouble();
            if (amount > curr_acc.getBalance()) {
                System.out.println("Insufficient balance.");
            } else {
                curr_acc.withdraw(amount);
                System.out.printf("Your new balance is %.2f %s.%n", curr_acc.getBalance(), curr_acc.getcurr());
            }
        }
        
        private void depositMoney() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the amount to deposit: ");
            double amount = scanner.nextDouble();
            curr_acc.deposit(amount);
            System.out.printf("Your new balance is %.2f %s.%n", curr_acc.getBalance(), curr_acc.getcurr());
        }
        
        private void exit() {
            System.out.println("Thank you for using ABC Bank ATM.");
            System.exit(0);
        }
        
        //Test case
        public static void main(String[] args) {
            B_Account[] acc = {new B_Account("123456789", "USD", "New York", 1000.0),
                                      new saving_Account("987654321", "EUR", "London", 2000.0, 0.02)};
            Client C_person = new Client(1, "John Doe", "US", "Engineer", "123 Main St", 30, "Male", "1234", acc, null);
            new ATM(C_person);
        }
    }
        
   
