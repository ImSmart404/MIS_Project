import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class SQL {
    private String table;
    private ArrayList<String> elem;

    private Connection conection;
    private Statement statement;
    public SQL(String table, ArrayList<String> elem, Connection conection, Statement statement){
        this.table = table;
        this.elem = elem;
        this.conection = conection;
        this.statement = statement;

    }
    public void add(ArrayList<String> elem) throws SQLException {
        conection.createStatement();
        switch (table){
            case ("art_exhibits"):{
                String sql = "INSERT INTO art_exhibits(id,ename, edescription, eyear, ephoto, evideo)" + "VALUES(5,'Постоянство памяти','Одна из самых известных картин художника Сальвадора Дали.','1931','https://losko.ru/wp-content/uploads/2019/11/ebd7ff7f9d8ddb7b9a8502168187.jpg','https://www.youtube.com/watch?v=hi0sujvzt8s');";
                statement.executeUpdate(sql);
            }
            case ("art_users"):{
                String sql = "INSERT INTO art_users() " + "VALUES('','','','','','');";
                statement.executeUpdate(sql);
            }
        }
    }
    public void delete() throws SQLException {
        conection.createStatement();
        switch (table){
            case ("art_exhibits"):{
                String sql = "DELETE from art_exhibits where id = 8";
                statement.executeUpdate(sql);
            }
            case ("art_users"):{
                String sql = "DELETE from art_users where id = 8";
                statement.executeUpdate(sql);
            }
        }
    }
    public void reading(ArrayList<String> elem){
        String request = null;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) request = sc.nextLine();
        else System.out.println("Поле пустое");
        elem.add(request);
    }
}
