import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static String Menu = "LoginPanel";
    public static void main(String[] args) {
        Database.CreateConnection();
        LoginPanel();
    }
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
    public static void RegisterUser() {
        String User = null;
        String Idade = null;
        String Senha = null;
        String CEP = null;
        String City;
        while (Objects.equals(Menu, "Registrar"))
        {
            loop_user: while (User == null) {
                System.out.println("[+] Bem-vindo ao painel de registro");
                System.out.println("[+] Por favor preencha as informações corretamente");
                System.out.print("[+] Digite seu usuário: ");
                Scanner ReadInput = new Scanner(System.in);
                String input = ReadInput.nextLine();
                System.out.println("------------------------");
                System.out.println("[?] O usuário digitado foi "+ input +", você tem certeza?");
                System.out.println("[?] Responda sim ou não:");
                System.out.print("[+] Resposta: ");
                String resposta = ReadInput.nextLine();
                switch (resposta.toLowerCase()) {
                    case "sim", "s", "si" -> {
                        User = input;
                        System.out.println("[+] Ok, prosseguindo :)");
                        System.out.println("------------------------");
                        break loop_user;
                    }
                    case "nao", "n", "no" -> {
                        System.out.println("------------------------");
                        System.out.println("[+] Ok, vamos de novo.");
                        System.out.println("------------------------");

                    }
                    default -> {
                        System.out.println("------------------------");
                        System.out.println("[!] Digite sim ou nao");
                        System.out.println("[+] Vamos de novo :)");
                        System.out.println("------------------------");
                    }
                }
            }
            loop_senha: while (Senha == null) {
                System.out.print("[+] Digite sua senha: ");
                Scanner ReadInput = new Scanner(System.in);
                String input = ReadInput.nextLine();
                System.out.println("------------------------");
                System.out.println("[?] A senha digitada foi "+ input +", você tem certeza?");
                System.out.println("[?] Responda sim ou não:");
                System.out.print("[+] Resposta: ");
                String resposta = ReadInput.nextLine();
                switch (resposta.toLowerCase()) {
                    case "sim", "s", "si" -> {
                        Senha = input;
                        System.out.println("[+] Prosseguindo :)");
                        System.out.println("------------------------");
                        break loop_senha;
                    }
                    case "nao", "n", "no" -> {
                        System.out.println("------------------------");
                        System.out.println("[+] Ok, vamos de novo.");
                        System.out.println("------------------------");

                    }
                    default -> {
                        System.out.println("------------------------");
                        System.out.println("[!] Digite sim ou nao");
                        System.out.println("[+] Vamos de novo :)");
                        System.out.println("------------------------");
                    }
                }
            }
            loop_idade: while (Idade == null) {
                System.out.print("[+] Digite sua idade: ");
                Scanner ReadInput = new Scanner(System.in);

                String input = ReadInput.nextLine();
                System.out.println("------------------------");
                System.out.println("[?] A idade digitada foi "+ input +", você tem certeza?");
                System.out.println("[?] Responda sim ou não:");
                System.out.print("[+] Resposta: ");
                String resposta = ReadInput.nextLine();
                switch (resposta.toLowerCase()) {
                    case "sim", "s", "si" -> {
                        Idade = input;
                        System.out.println("[+] Prosseguindo :)");
                        System.out.println("------------------------");
                        break loop_idade;

                    }
                    case "nao", "n", "no" -> {
                        System.out.println("------------------------");
                        System.out.println("[+] Ok, vamos de novo.");
                        System.out.println("------------------------");

                    }
                    default -> {
                        System.out.println("------------------------");
                        System.out.println("[!] Digite sim ou nao");
                        System.out.println("[+] Vamos de novo :)");
                        System.out.println("------------------------");
                    }
                }
            }
            loop_cep: while (CEP == null) {
                String json;
                String cidade;
                String logradouro;
                String bairro;
                String uf;
                System.out.print("[+] Digite seu CEP: ");
                Scanner ReadInput = new Scanner(System.in);

                String input = ReadInput.nextLine();
                System.out.println("------------------------");
                System.out.println("[?] O CEP digitado foi "+ input +"");
                System.out.print("[.] Estou procurando sua cidade baseado no cep.");
                try {
                    System.out.print(".");
                    TimeUnit.SECONDS.sleep(1);
                    URL url = new URL("http://viacep.com.br/ws/"+ input +"/json");
                    URLConnection urlConnection = url.openConnection();
                    System.out.print(".");
                    TimeUnit.SECONDS.sleep(1);
                    InputStream is = urlConnection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                    System.out.print(".");
                    TimeUnit.SECONDS.sleep(1);
                    StringBuilder jsonSb = new StringBuilder();

                    br.lines().forEach(l -> jsonSb.append(l.trim()));
                    json = jsonSb.toString();

                    json = json.replaceAll("[{},:]", "");
                    json = json.replaceAll("\"", "\n");
                    String[] array = new String[30];
                    array = json.split("\n");

                    logradouro = array[7];
                    bairro = array[15];
                    cidade = array[19];
                    uf = array[23];
                    System.out.println("\n------------------------");
                    System.out.println("[+] Encontrei!!");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("[!] Encontrei as seguintes informações deste CEP:\n[+] Cidade: " + cidade + "\n[+] Bairro: " + bairro + "\n[+] UF: "+ uf +"\n[+] Logradouro: " + logradouro + "");
                    System.out.println("[!] Esta informação está correta?");
                    System.out.println("[?] Responda sim ou não:");
                    System.out.print("[+] Resposta: ");
                    String resposta = ReadInput.nextLine();
                    switch (resposta.toLowerCase()) {
                        case "sim", "s", "si" -> {
                            CEP = input;
                            City = cidade;
                            System.out.println("[+] Prosseguindo :)");
                            System.out.println("------------------------");
                            break loop_cep;
                        }
                        case "nao", "n", "no" -> {
                            System.out.println("------------------------");
                            System.out.println("[+] Ok, vamos de novo.");
                            System.out.println("------------------------");

                        }
                        default -> {
                            System.out.println("------------------------");
                            System.out.println("[!] Digite sim ou nao");
                            System.out.println("[+] Vamos de novo :)");
                            System.out.println("------------------------");
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


