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
        System.out.println("�� ������ ������� �������, �������� ��� �����������?");
        Scanner sc = new Scanner(System.in);
        String action = sc.next();
        switch (action) {
            case ("�������"):{
                deleteRow();
                break;
            }
            case ("��������"):{
                addRow();
                break;
            }

            case ("�����������"):{
                read();
                while (!field.isEmpty()){
                    String out = field.get(0);
                    field.remove(0);
                    System.out.println(out);
                }
                break;
            }
        }
        cn.closeConnect();
    }

    public static void addRow() throws SQLException {
        Scanner sc = new Scanner(System.in);
        field.clear();
        System.out.println("����� ������� �� ������ ��������: ������������, ���������, ���������?");
        String name_table = sc.next();
        switch (name_table) {
            case ("������������"): {
                System.out.println("������� uname, username, upartronymic, uemail, uhashedpassword, uadmin(true/false)");
                for (int i=0;i<7;i++)
                    field.add(sc.nextLine());
                field.remove(0);
                SQL adding = new SQL("������������", field, connection);
                adding.add();
                field.clear();
                break;
            }
            case ("���������"): {
                System.out.println("������� user_id, exhibits_id");
                for (int i=0;i<3;i++)
                    field.add(sc.nextLine());
                field.remove(0);
                SQL adding = new SQL("���������", field, connection);
                adding.add();
                field.clear();
                break;
            }
            case ("���������"): {
                System.out.println("������� ename, edescription, eyear, ephoto, evideo");
                for (int i=0;i<6;i++)
                    field.add(sc.nextLine());
                field.remove(0);
                SQL adding = new SQL("���������", field, connection);
                adding.add();
                field.clear();
                break;
            }
        }
    }

    public static void deleteRow() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("�� ����� ������� �� ������ ������� �������: ������������, ���������, ���������?");
        String nameTable = sc.next();
        switch (nameTable){
            case ("������������"):{
                System.out.println("������� id:");
                int id = sc.nextInt();
                SQL del = new SQL("������������", field, connection);
                del.delete(id);
                break;
            }
            case ("���������"):{
                System.out.println("������� id:");
                int id = sc.nextInt();
                SQL del = new SQL("���������", field, connection);
                del.delete(id);
                break;
            }
            case ("���������"):{
                System.out.println("������� id:");
                int id = sc.nextInt();
                SQL del = new SQL("���������", field, connection);
                del.delete(id);
                break;
            }
        }
    }
    public static void read() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("����� ������� �� ������ �����������: ������������, ���������, ���������?");
        String nameTable = sc.next();
        switch (nameTable) {
            case ("������������"): {
                System.out.println("������� ����� ������");
                int numberRows = sc.nextInt();
                SQL rg = new SQL("������������", field, connection);
                field = rg.reading(numberRows, nameTable);
                break;
            }
            case ("���������"): {
                System.out.println("������� ����� ������");
                int numberRows = sc.nextInt();
                SQL rg = new SQL("���������", field, connection);
                field = rg.reading(numberRows, nameTable);
                break;
            }
            case ("���������"): {
                System.out.println("������� ����� ������");
                int numberRows = sc.nextInt();
                SQL rg = new SQL("���������", field, connection);
                field = rg.reading(numberRows, nameTable);
                break;
            }
        }
    }
}