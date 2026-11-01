import java.util.Scanner;

class MinimumAmountException extends Exception {

    MinimumAmountException(String message) {
        super(message);
    }
}

public class Q6_OnlineShopping {

    static void placeOrder(int amount)
            throws MinimumAmountException {

        if (amount < 500) {
            throw new MinimumAmountException(
                "Minimum cart value must be Rs. 500"
            );
        }

        System.out.println("Order placed successfully");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cart amount: ");
        int amount = sc.nextInt();

        try {
            placeOrder(amount);

        } catch (MinimumAmountException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}