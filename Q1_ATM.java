import java.util.Scanner;

class ATM {
    double balance;

    ATM(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) {
        try {
            if (amount > balance) {
                throw new Exception("Insufficient Balance");
            }

            balance -= amount;
            System.out.println("Withdrawal Successful");
            System.out.println("Remaining Balance: " + balance);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());

        } finally {
            System.out.println("Transaction Completed");
        }
    }
}

public class Q1_ATM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        ATM atm = new ATM(balance);
        atm.withdraw(amount);

        sc.close();
    }
}
