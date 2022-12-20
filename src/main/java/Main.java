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
    public static void main(String[] args) throws SQLException {
        Connect cn = new Connect(URL, USER, PASSWORD);
        cn.connect();
        Connection connection = cn.getConnection();
        cn.closeConnect();
    }
    public ArrayList<String> addlist() throws SQLException {
        ArrayList<String> field = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Какую таблицу вы хотите изменить: пользователь, избранное, экспонаты?");
        String name_table = sc.next();
        switch (name_table) {
            case ("пользователь"):
                System.out.println("Вы хотите удалить элемент, добавить или изменить?");
                String action_users = sc.next();
                switch (action_users) {
                    case "удалить":
                        System.out.println("Введите номер id:");
                        String id = sc.next();
                        SQL del = new SQL();
                        del.delete();
                        break;
                    case "добавить":
                        System.out.println("Введите id, ename, edescription, eyear, ephoto, evideo");
                        while (sc.hasNextLine())
                            field.add(sc.next());
                        SQL adding = new SQL();
                        adding.add(field);
                        return field;
                    field.clear();
                    break;
                    case "изменить":
                        System.out.println("Введите значения которые хотите изменить");

                }
            case ("избранное"):
                System.out.println("Вы хотите удалить элемент, добавить или изменить?");
                String action_favourites = sc.next();
                switch (action_favourites) {
                    case "удалить":
                        System.out.println("Введите номер id:");
                        String id = sc.next();
                        SQL del = new SQL();
                        del.delete();
                        break;
                    case "добавить":
                        System.out.println("Введите id, ename, edescription, eyear, ephoto, evideo");
                        while (sc.hasNextLine())
                            field.add(sc.next());
                        return field;
                    field.clear();
                    SQL adding = new SQL();
                    adding.add(field);
                    break;
                    case "изменить":
                        System.out.println("Введите значения которые хотите изменить");

                }
            case ("экспонаты"):
                System.out.println("Вы хотите удалить элемент, добавить или изменить?");
                String action_exhibits = sc.next();
                switch (action_exhibits) {
                    case "удалить":
                        System.out.println("Введите номер id:");
                        String id = sc.next();
                        SQL del = new SQL();
                        del.delete();
                        break;
                    case "добавить":
                        System.out.println("Введите id, ename, edescription, eyear, ephoto, evideo");
                        while (sc.hasNextLine())
                            field.add(sc.next());
                        return field;
                    field.clear();
                    SQL adding = new SQL();
                    adding.add(field);
                    break;
                    case "изменить":
                        System.out.println("Введите значения которые хотите изменить");

                }
        }
        return field;
    }
}