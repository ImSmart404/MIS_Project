import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SQL {
    private String table;
    private ArrayList<String> elem;

    private Connection conection;
    private static ResultSet rs;

    public SQL(String table, ArrayList<String> elem, Connection conection) {
        this.table = table;
        this.elem = elem;
        this.conection = conection;

    }

    public void add() throws SQLException {
        conection.createStatement();
        switch (table) {
            case ("экспонаты"): {
                String sql = "INSERT INTO art_exhibits(ename, edescription, eyear, ephoto, evideo)  VALUES(?,?,?,?,?)";
                try (PreparedStatement ps = conection.prepareStatement(sql)) {
                    ps.setString(1, elem.get(0));
                    ps.setString(2, elem.get(1));
                    ps.setInt(3, Integer.parseInt(elem.get(2)));
                    ps.setString(4, elem.get(3));
                    ps.setString(5, elem.get(4));
                    ps.executeUpdate();
                }
                break;
            }
            case ("пользователь"): {
                String sql = "INSERT INTO art_users(uname, username, upartronymic, uemail, uhashedpassword, uadmin)  VALUES(?,?,?,?,?,?)";
                try (PreparedStatement ps = conection.prepareStatement(sql)) {
                    ps.setString(1, elem.get(0));
                    ps.setString(2, elem.get(1));
                    ps.setString(3, elem.get(2));
                    ps.setString(4, elem.get(3));
                    ps.setString(5, elem.get(4));
                    ps.setBoolean(6, Boolean.parseBoolean(elem.get(5)));
                    ps.executeUpdate();
                }
                break;
            }
            case ("избранное"): {
                String sql = "INSERT INTO art_favorites(user_id, exhibit_id)  VALUES(?,?)";
                try (PreparedStatement ps = conection.prepareStatement(sql)) {
                    ps.setInt(1, Integer.parseInt(elem.get(0)));
                    ps.setInt(2, Integer.parseInt(elem.get(1)));
                    ps.executeUpdate();
                }
                break;
            }
        }
    }

    public void delete(int index) throws SQLException {
        conection.createStatement();
        switch (table) {
            case ("экспонаты"): {
                String sql = "DELETE from art_exhibits where id = ?";

               try (PreparedStatement ps = conection.prepareStatement(sql)) {
                    ps.setInt(1, index);
                    ps.executeUpdate();
                }

                break;

            }
            case ("пользователь"): {
                String sql = "DELETE from art_users where id = ?";
                try (PreparedStatement ps = conection.prepareStatement(sql)) {
                    ps.setInt(1, index);
                    ps.executeUpdate();
                }
                break;
            }
            case ("избранное"): {
                String sql = "DELETE from art_favorites where id = ? ";
                try (PreparedStatement ps = conection.prepareStatement(sql)) {
                    ps.setInt(1, index);
                    ps.executeUpdate();
                }
                break;
            }
        }

    }
    public ArrayList<String> reading (int id,String s) throws SQLException {
        ArrayList<String> result = new ArrayList<>();
        switch (s){
            case ("экспонаты"):{
                String sql = "Select * from art_exhibits where id = ?";
                try (PreparedStatement ps = conection.prepareStatement(sql, rs.HOLD_CURSORS_OVER_COMMIT)) {
                    ps.setInt(1, id);
                    rs=ps.executeQuery();
                    while (rs.next()){
                        for (int i = 1; i < 7; i++) {
                            result.add(rs.getString(i));
                        }
                    }
                    rs.close();
                }
                break;
            }
            case ("пользователь"):{
                String sql = "Select * from art_users where id = ?";
                try (PreparedStatement ps = conection.prepareStatement(sql, rs.HOLD_CURSORS_OVER_COMMIT)) {
                    ps.setInt(1, id);
                    rs=ps.executeQuery();
                    while (rs.next()){
                        for (int i = 1; i < 8; i++) {
                            result.add(rs.getString(i));
                        }
                    }
                    rs.close();
                }
                break;
            }
            case ("избранное"):{
                String sql = "Select * from art_favorites where id = ?";
                try (PreparedStatement ps = conection.prepareStatement(sql, rs.HOLD_CURSORS_OVER_COMMIT)) {
                    ps.setInt(1, id);
                    rs=ps.executeQuery();
                    while (rs.next()){
                        for (int i = 1; i < 4; i++) {
                            result.add(rs.getString(i));
                        }
                    }
                    rs.close();
                }
                break;
            }
        }
        return result;
    }
}

