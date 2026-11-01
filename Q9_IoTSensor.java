import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class SquareCalculator extends Thread {

    BlockingQueue<Integer> queue;

    SquareCalculator(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {

        try {
            while (true) {

                int num = queue.take();

                if (num == -1) {
                    break;
                }

                System.out.println("Square: " + (num * num));
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class CubeCalculator extends Thread {

    BlockingQueue<Integer> queue;

    CubeCalculator(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {

        try {
            while (true) {

                int num = queue.take();

                if (num == -1) {
                    break;
                }

                System.out.println("Cube: " +
                    ((long) num * num * num));
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class RandomNumberGenerator extends Thread {

    BlockingQueue<Integer> evenQueue;
    BlockingQueue<Integer> oddQueue;

    RandomNumberGenerator(
        BlockingQueue<Integer> evenQueue,
        BlockingQueue<Integer> oddQueue) {

        this.evenQueue = evenQueue;
        this.oddQueue = oddQueue;
    }

    public void run() {

        Random random = new Random();

        try {
            for (int i = 1; i <= 5; i++) {

                int num = random.nextInt(20) + 1;

                System.out.println("Generated: " + num);

                if (num % 2 == 0) {
                    evenQueue.put(num);
                } else {
                    oddQueue.put(num);
                }

                Thread.sleep(1000);
            }

            evenQueue.put(-1);
            oddQueue.put(-1);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Q9_IoTSensor {

    public static void main(String[] args)
            throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Start Simulation");
        System.out.println("2. Exit");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {

            BlockingQueue<Integer> evenQueue =
                new LinkedBlockingQueue<>();

            BlockingQueue<Integer> oddQueue =
                new LinkedBlockingQueue<>();

            SquareCalculator square =
                new SquareCalculator(evenQueue);

            CubeCalculator cube =
                new CubeCalculator(oddQueue);

            RandomNumberGenerator generator =
                new RandomNumberGenerator(evenQueue, oddQueue);

            square.start();
            cube.start();
            generator.start();

            generator.join();
            square.join();
            cube.join();

        } else if (choice == 2) {

            System.out.println("Exiting simulation");

        } else {

            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
