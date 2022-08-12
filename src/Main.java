import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
//
public class Main {
    public static String Menu = "Login";
    public static void main(String[] args) {
        LoginUser();
    }
    public static void LoginUser() {
        while (Objects.equals(Menu, "Login")) {
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
                case "1":
                    System.out.println("1!");
                    Menu = "Logar";
                    break;
                case "2":
                    System.out.println("2!");
                    Menu = "Registrar";
                    RegisterUser();
                    break;

                default:
                    System.out.println("[!] Escolha 1 ou 2 :)");
                    break;
            }
        }
    }
    public static void RegisterUser() {
        String User = null;
        String Nome;
        String Idade;
        while (Objects.equals(Menu, "Registrar"))
        {
            if (User == null) {
                System.out.print("[+] Digite seu usuário: ");
                Scanner ReadInput = new Scanner(System.in);
                String input = ReadInput.nextLine();
                System.out.println("[?] O usuário digitado foi "+ input +", você tem certeza?");
                System.out.println("[?] Responda sim ou não:");
                System.out.print("[+] Resposta: ");
                String resposta = ReadInput.nextLine();
                switch (resposta.toLowerCase()) {
                    case "sim":
                        User = input;
                        System.out.println("[+] Redirecionando para o login :)");
                        Menu = "Login";
                        LoginUser();
                        break;

                    case "nao":
                        System.out.println("------------------------");
                        System.out.println("[+] Ok, vamos de novo.");
                        System.out.println("------------------------");
                        continue;
                    default:
                        System.out.println("------------------------");
                        System.out.println("[!] Digite sim ou nao");
                        System.out.println("[+] Vamos de novo :)");
                        System.out.println("------------------------");
                        break;
                }
            }
        }

    }
}



//        try {
//                URL url = new URL("http://viacep.com.br/ws/88085201/json");
//                URLConnection urlConnection = url.openConnection();
//                InputStream is = urlConnection.getInputStream();
//                BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//                StringBuilder jsonSb = new StringBuilder();
//
//                br.lines().forEach(l -> jsonSb.append(l.trim()));
//                json = jsonSb.toString();
//
//                // JOptionPane.showMessageDialog(null, json);
//
//                json = json.replaceAll("[{},:]", "");
//                json = json.replaceAll("\"", "\n");
//                String[] array = new String[30];
//                array = json.split("\n");
//
//                // JOptionPane.showMessageDialog(null, array);
//
//                logradouro = array[7];
//                bairro = array[15];
//                cidade = array[19];
//                uf = array[23];
//
//                System.out.println(cidade);
//
//                } catch (Exception e) {
//                throw new RuntimeException(e);
//                }