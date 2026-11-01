import java.util.Scanner;

public class Q5_UniversityLogin {

    static void login(String username) {

        try {
            if (username == null || username.equalsIgnoreCase("null")) {
                throw new NullPointerException();
            }

            System.out.println("Login successful");
            System.out.println("Welcome " + username);

        } catch (NullPointerException e) {
            System.out.println("Exception: Username cannot be null");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        login(username);

        sc.close();
    }
}