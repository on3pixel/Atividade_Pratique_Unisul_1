import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection DBConnection = null;
    public static boolean CreateConnection () {
        if (DBConnection == null) {
            try {
                DBConnection = DriverManager.getConnection("jdbc:sqlite:banco.db");
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }
    public static boolean DestroyConnection () {
        if (DBConnection != null) {
            try {
                DBConnection.close();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public static void CreateEvent() {
        /*
        Categoria de eventos disponíveis:
        Festas, Evento Esportivo, Shows.

        Eventos devem possuír: Nome do evento, Endereço, Categoria, Data, Horário e descrição
         */

    }

    public static void FetchEvent() {

    }

    public static void DeleteEvent() {

    }

    public static void ParticipateEvent() {

    }

    public static void CreateUser() {

    }

    public static void Login(String user, String pass) {
        try {
            boolean connected = CreateConnection();
            if (connected) {

            }
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }
}