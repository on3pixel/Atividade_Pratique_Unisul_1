import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner ReadInput = new Scanner(System.in);
        System.out.println("Enter username");

        String userName = ReadInput.nextLine();
        System.out.println("Username is: " + userName);

        System.out.println("Enter username");

        String userPass = ReadInput.nextLine();
        System.out.println("Username is "+ userName + "Password is: " + userPass);
    }
}
