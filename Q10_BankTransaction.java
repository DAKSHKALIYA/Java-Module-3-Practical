class BankTransaction extends Thread {

    String transactionName;
    int amount;

    BankTransaction(String transactionName, int amount) {
        this.transactionName = transactionName;
        this.amount = amount;
    }

    public void run() {

        System.out.println(
            transactionName + " processed: Rs. " + amount
        );
    }
}

public class Q10_BankTransaction {

    public static void main(String[] args)
            throws InterruptedException {

        BankTransaction low =
            new BankTransaction("Low-value transaction", 5000);

        BankTransaction high =
            new BankTransaction("High-value transaction", 50000);

        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);

        high.start();
        high.join();

        low.start();
        low.join();
    }
}
