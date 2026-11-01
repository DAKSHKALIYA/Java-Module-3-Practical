import java.util.Scanner;

class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

public class Q2_StudentAge {

    static void registerStudent(int age) throws InvalidAgeException {

        if (age <= 17) {
            throw new InvalidAgeException(
                "Age must be above 17 for registration"
            );
        }

        System.out.println("Student registered successfully");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        try {
            registerStudent(age);
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}