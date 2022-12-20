import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.Executor;

public class Main {
    private static String URL = "jdbc:postgresql://127.0.0.1:5432/MIS";
    private static String USER = "postgres";
    private static String PASSWORD = "admin";
    static ArrayList<String> field = new ArrayList<>();
    private static Connection connection;
    public static void main(String[] args) throws SQLException {
        Connect cn = new Connect(URL, USER, PASSWORD);
        cn.connect();
        connection = cn.getConnection();
        cn.closeConnect();
        System.out.println("Вы хотите удалить элемент, добавить или изменить?");
        Scanner sc = new Scanner(System.in);
        String action = sc.next();
        switch (action) {
            case ("удалить"):{
                deleteRow();
            }
            case ("добавить"):{
                addRow();
            }

            case ("изменить"):{
                read();
                while (!field.isEmpty()){
                    String out = field.get(0);
                    field.remove(0);
                    System.out.println(out);
                }
            }
        }
    }

    public static void addRow() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Какую таблицу вы хотите изменить: пользователь, избранное, экспонаты?");
        String name_table = sc.next();
        switch (name_table) {
            case ("пользователь"): {
                System.out.println("Введите uname, username, upartronymic, uemail, uhashedpassword, uadmin(true/false)");
                while (sc.hasNextLine())
                    field.add(sc.next());
                SQL adding = new SQL("пользователь", field, connection);
                adding.add(field);
                field.clear();
            }
            case ("избранное"): {
                System.out.println("Введите user_id, exhibits_id");
                while (sc.hasNextLine())
                    field.add(sc.next());
                SQL adding = new SQL("избранное", field, connection);
                adding.add(field);
                field.clear();
            }
            case ("экспонаты"): {
                System.out.println("Введите ename, edescription, eyear, ephoto, evideo");
                while (sc.hasNextLine())
                    field.add(sc.next());
                SQL adding = new SQL("экспонаты", field, connection);
                adding.add(field);
                field.clear();
            }
        }
    }

    public static void deleteRow() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Из какой таблицы вы хотите удалить элемент: пользователь, избранное, экспонаты?");
        String nameTable = sc.next();
        switch (nameTable){
            case ("пользователь"):{
                System.out.println("Введите id:");
                int id = sc.nextInt();
                SQL del = new SQL("пользователь", field, connection);
                del.delete(id);
            }
            case ("избранное"):{
                System.out.println("Введите id:");
                int id = sc.nextInt();
                SQL del = new SQL("избранное", field, connection);
                del.delete(id);
            }
            case ("экспонаты"):{
                System.out.println("Введите id:");
                int id = sc.nextInt();
                SQL del = new SQL("экспонаты", field, connection);
                del.delete(id);
            }
        }
    }
    public static void read() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Какую таблицу вы хотите просмотреть: пользователь, избранное, экспонаты?");
        String nameTable = sc.next();
        switch (nameTable) {
            case ("пользователь"): {
                System.out.println("Укажите номер строки");
                int numberRows = sc.nextInt();
                SQL rg = new SQL("пользователь", field, connection);
                field = rg.reading(numberRows, nameTable);
            }
            case ("избранное"): {
                System.out.println("Укажите номер строки");
                int numberRows = sc.nextInt();
                SQL rg = new SQL("избранное", field, connection);
                field = rg.reading(numberRows, nameTable);
            }
            case ("экспонаты"): {
                System.out.println("Укажите номер строки");
                int numberRows = sc.nextInt();
                SQL rg = new SQL("избранное", field, connection);
                field = rg.reading(numberRows, nameTable);
            }
        }
    }
}