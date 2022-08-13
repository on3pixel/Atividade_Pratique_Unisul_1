package panels;

import java.util.Objects;
import java.util.Scanner;

import static main.Main.Menu;
import static panels.Register.RegisterUser;

public class Login {
        public static void LoginPanel() {
            while (Objects.equals(Menu, "LoginPanel")) {
                Scanner ReadInput = new Scanner(System.in);
                System.out.flush();
                System.out.println("------------------------");
                System.out.println("[+] Escolha entre as opções a baixo:");
                System.out.println("[+] 1 - Logar");
                System.out.println("[+] 2 - Registrar-se");
                System.out.println("------------------------");
                System.out.print("[+] Escolha 1 ou 2: ");
                String input = ReadInput.nextLine();
                switch (input) {
                    case "1" -> {
                        System.out.println("1!");
                        Menu = "Logar";
                    }
                    case "2" -> {
                        System.out.println("------------------------");
                        Menu = "Registrar";
                        RegisterUser();
                    }
                    default -> System.out.println("[!] Escolha 1 ou 2 :)");
                }
            }
        }
}
