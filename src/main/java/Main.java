import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Main {
    private static String URL = "jdbc:postgresql://127.0.0.1:5432/MIS";
    private static String USER = "postgres";
    private static String PASSWORD = "admin";

    public static void main(String[] args) throws SQLException {
        Connect cn = new Connect(URL, USER, PASSWORD);
        cn.connect();
        Connection connection = cn.getConnection();
        //SQL sql = new SQL();
        cn.closeConnect();
    }
}