package panels;

import main.Database;

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
                        System.out.println("------------------------");
                        Menu = "Logar";
                        LoginUser();
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
        public static void LoginUser() {
            String Usuario = null;
            String Senha = null;
            while (Objects.equals(Menu, "Logar")) {
                while (Usuario == null) {
                    System.out.print("[+] Digite seu usuário: ");
                    Scanner input = new Scanner(System.in);
                    Usuario = input.nextLine();
                    break;
                }
                while (Senha == null) {
                    System.out.print("[+] Digite sua senha: ");
                    Scanner input = new Scanner(System.in);
                    Senha = input.nextLine();
                    break;
                }
                if (Usuario != null && Senha != null) {
                    boolean result = Database.CheckPass(Usuario, Senha);
                    if (result) {
                        System.out.println("[+] Login efetuado com sucesso");
                        System.out.println("[+] Redirecionando ao menu principal..");
                        break;
                    } else {
                        System.out.println("[!] Usuário ou senha inválido.");
                        Usuario = null;
                        Senha = null;
                    }

                }
            }
        }
}

