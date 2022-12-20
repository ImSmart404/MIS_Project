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
        System.out.println("����� ������� �� ������ ��������: ������������, ���������, ���������?");
        String nameTable = sc.next();
        switch (nameTable) {
            case ("������������"): {
                System.out.println("�� ������ ������� �������, �������� ��� ��������?");
                String actionUsers = sc.next();
                switch (actionUsers) {
                    case "�������": {
                        System.out.println("������� ����� id:");
                        int id = sc.nextInt();
                        SQL del = new SQL("������������", field, connection);
                        del.delete(id);
                        break;
                    }
                    case "��������": {
                        System.out.println("������� id, ename, edescription, eyear, ephoto, evideo");
                        while (sc.hasNextLine())
                            field.add(sc.next());
                        SQL adding = new SQL("������������", field, connection);
                        adding.add(field);
                        field.clear();
                        break;
                    }
                }
            }
            case ("���������"): {
                System.out.println("�� ������ ������� �������, �������� ��� ��������?");
                String actionFavourites = sc.next();
                switch (actionFavourites) {
                    case "�������": {
                        System.out.println("������� ����� id:");
                        int id = sc.nextInt();
                        SQL del = new SQL("���������", field, connection);
                        del.delete(id);
                        break;
                    }
                    case "��������": {
                        System.out.println("������� id, ename, edescription, eyear, ephoto, evideo");
                        while (sc.hasNextLine())
                            field.add(sc.next());
                        SQL adding = new SQL("���������", field, connection);
                        adding.add(field);
                        field.clear();
                    }
                }
            }
            case ("���������"): {
                System.out.println("�� ������ ������� �������, �������� ��� ��������?");
                String actionExhibits = sc.next();
                switch (actionExhibits) {
                    case "�������": {
                        System.out.println("������� ����� id:");
                        int id = sc.nextInt();
                        SQL del = new SQL("���������", field, connection);
                        del.delete(id);
                        break;
                    }
                    case "��������": {
                        System.out.println("������� id, ename, edescription, eyear, ephoto, evideo");
                        while (sc.hasNextLine())
                            field.add(sc.next());
                        field.clear();
                        SQL adding = new SQL("���������", field, connection);
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
        System.out.println("����� ������� �� ������ ��������: ������������, ���������, ���������?");
        String nameTable = sc.next();
        switch (nameTable) {
            case ("������������"): {
                System.out.println("�� ������ ������� �������, �������� ��� ��������?");
                String actionUsers = sc.next();
                switch (actionUsers) {
                    case "�������": {
                        System.out.println("������� ����� id:");
                        int id = sc.nextInt();
                        SQL del = new SQL("������������", field, connection);
                        del.delete(id);
                        break;
                    }

                }
            }
            case ("���������"): {
                System.out.println("�� ������ ������� �������, �������� ��� ��������?");
                String actionFavourites = sc.next();
                switch (actionFavourites) {
                    case "�������": {
                        System.out.println("������� ����� id:");
                        int id = sc.nextInt();
                        SQL del = new SQL("���������", field, connection);
                        del.delete(id);
                        break;
                    }

                }
            }
            case ("���������"): {
                System.out.println("�� ������ ������� �������, �������� ��� ��������?");
                String actionExhibits = sc.next();
                switch (actionExhibits) {
                    case "�������": {
                        System.out.println("������� ����� id:");
                        int id = sc.nextInt();
                        SQL del = new SQL("���������", field, connection);
                        del.delete(id);
                        break;
                    }

                }
            }
        }
    }

}