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
        System.out.println("����� ������� �� ������ ��������: ������������, ���������, ���������?");
        String name_table = sc.next();
        switch (name_table) {
            case ("������������"):
                System.out.println("�� ������ ������� �������, �������� ��� ��������?");
                String action_users = sc.next();
                switch (action_users) {
                    case "�������":
                        System.out.println("������� ����� id:");
                        String id = sc.next();
                        SQL del = new SQL();
                        del.delete();
                        break;
                    case "��������":
                        System.out.println("������� id, ename, edescription, eyear, ephoto, evideo");
                        while (sc.hasNextLine())
                            field.add(sc.next());
                        SQL adding = new SQL();
                        adding.add(field);
                        return field;
                    field.clear();
                    break;
                    case "��������":
                        System.out.println("������� �������� ������� ������ ��������");

                }
            case ("���������"):
                System.out.println("�� ������ ������� �������, �������� ��� ��������?");
                String action_favourites = sc.next();
                switch (action_favourites) {
                    case "�������":
                        System.out.println("������� ����� id:");
                        String id = sc.next();
                        SQL del = new SQL();
                        del.delete();
                        break;
                    case "��������":
                        System.out.println("������� id, ename, edescription, eyear, ephoto, evideo");
                        while (sc.hasNextLine())
                            field.add(sc.next());
                        return field;
                    field.clear();
                    SQL adding = new SQL();
                    adding.add(field);
                    break;
                    case "��������":
                        System.out.println("������� �������� ������� ������ ��������");

                }
            case ("���������"):
                System.out.println("�� ������ ������� �������, �������� ��� ��������?");
                String action_exhibits = sc.next();
                switch (action_exhibits) {
                    case "�������":
                        System.out.println("������� ����� id:");
                        String id = sc.next();
                        SQL del = new SQL();
                        del.delete();
                        break;
                    case "��������":
                        System.out.println("������� id, ename, edescription, eyear, ephoto, evideo");
                        while (sc.hasNextLine())
                            field.add(sc.next());
                        return field;
                    field.clear();
                    SQL adding = new SQL();
                    adding.add(field);
                    break;
                    case "��������":
                        System.out.println("������� �������� ������� ������ ��������");

                }
        }
        return field;
    }
}