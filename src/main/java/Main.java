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
    private static Connection connection;
    public static void main(String[] args) throws SQLException {
        Connect cn = new Connect(URL, USER, PASSWORD);
        cn.connect();
        connection = cn.getConnection();
        cn.closeConnect();
    }
    public void addAndDelete() throws SQLException {
        ArrayList<String> field = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Какую таблицу вы хотите изменить: пользователь, избранное, экспонаты?");
        String nameTable = sc.next();
        switch (nameTable) {
            case ("пользователь"): {
                System.out.println("Вы хотите удалить элемент, добавить или изменить?");
                String actionUsers = sc.next();
                switch (actionUsers) {
                    case "удалить": {
                        System.out.println("Введите номер id:");
                        int id = sc.nextInt();
                        SQL del = new SQL("пользователь", field, connection);
                        del.delete(id);
                        break;
                    }
                    case "добавить": {
                        System.out.println("Введите id, ename, edescription, eyear, ephoto, evideo");
                        while (sc.hasNextLine())
                            field.add(sc.next());
                        SQL adding = new SQL("пользователь", field, connection);
                        adding.add(field);
                        field.clear();
                        break;
                    }
                }
            }
            case ("избранное"): {
                System.out.println("Вы хотите удалить элемент, добавить или изменить?");
                String actionFavourites = sc.next();
                switch (actionFavourites) {
                    case "удалить": {
                        System.out.println("Введите номер id:");
                        int id = sc.nextInt();
                        SQL del = new SQL("избранное", field, connection);
                        del.delete(id);
                        break;
                    }
                    case "добавить": {
                        System.out.println("Введите id, ename, edescription, eyear, ephoto, evideo");
                        while (sc.hasNextLine())
                            field.add(sc.next());
                        SQL adding = new SQL("избранное", field, connection);
                        adding.add(field);
                        field.clear();
                    }
                }
            }
            case ("экспонаты"): {
                System.out.println("Вы хотите удалить элемент, добавить или изменить?");
                String actionExhibits = sc.next();
                switch (actionExhibits) {
                    case "удалить": {
                        System.out.println("Введите номер id:");
                        int id = sc.nextInt();
                        SQL del = new SQL("экспонаты", field, connection);
                        del.delete(id);
                        break;
                    }
                    case "добавить": {
                        System.out.println("Введите id, ename, edescription, eyear, ephoto, evideo");
                        while (sc.hasNextLine())
                            field.add(sc.next());
                        field.clear();
                        SQL adding = new SQL("экспонаты", field, connection);
                        adding.add(field);
                        break;
                    }
                }
            }
        }
    }
    public ArrayList<String> read(int i,String s){
        ArrayList<String> field = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Какую таблицу вы хотите изменить: пользователь, избранное, экспонаты?");
        String nameTable = sc.next();
        switch (nameTable) {
            case ("пользователь"): {
                System.out.println("Вы хотите удалить элемент, добавить или изменить?");
                String actionUsers = sc.next();
                switch (actionUsers) {
                    case "удалить": {
                        System.out.println("Введите номер id:");
                        int id = sc.nextInt();
                        SQL del = new SQL("пользователь", field, connection);
                        del.delete(id);
                        break;
                    }

                }
            }
            case ("избранное"): {
                System.out.println("Вы хотите удалить элемент, добавить или изменить?");
                String actionFavourites = sc.next();
                switch (actionFavourites) {
                    case "удалить": {
                        System.out.println("Введите номер id:");
                        int id = sc.nextInt();
                        SQL del = new SQL("избранное", field, connection);
                        del.delete(id);
                        break;
                    }

                }
            }
            case ("экспонаты"): {
                System.out.println("Вы хотите удалить элемент, добавить или изменить?");
                String actionExhibits = sc.next();
                switch (actionExhibits) {
                    case "удалить": {
                        System.out.println("Введите номер id:");
                        int id = sc.nextInt();
                        SQL del = new SQL("экспонаты", field, connection);
                        del.delete(id);
                        break;
                    }

                }
            }
        }
    }

}