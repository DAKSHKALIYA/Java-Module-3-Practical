class PrinterJob implements Runnable {

    int jobNumber;
    String studentName;

    PrinterJob(int jobNumber, String studentName) {
        this.jobNumber = jobNumber;
        this.studentName = studentName;
    }

    public void run() {

        System.out.println("Printing job " +
            jobNumber + " by " + studentName);

        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            System.out.println("Printing interrupted");
            Thread.currentThread().interrupt();
        }
    }
}

public class Q8_PrinterJob {

    public static void main(String[] args) {

        Thread t1 = new Thread(
            new PrinterJob(1, "Student A"));

        Thread t2 = new Thread(
            new PrinterJob(2, "Student B"));

        Thread t3 = new Thread(
            new PrinterJob(3, "Student C"));

        t1.start();
        t2.start();
        t3.start();
    }
}