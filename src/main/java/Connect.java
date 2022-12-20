import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Connect {
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private Connection conection;

    private Statement  statement;
    public Connect(String URL,String USER,String PASSWORD){
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }
    public void connect() throws SQLException{

        try {
            Driver driver = new org.postgresql.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException ex){
            System.err.println("Ошибка при создании драйвера");
            ex.printStackTrace();
        }
        conection = DriverManager.getConnection(URL,USER,PASSWORD);
    }
    public Connection getConnection(){
        return conection;
    }
    public void closeConnect() throws SQLException {
        conection.close();
        System.out.println("Соединение с бд закрыто");
    }
}
