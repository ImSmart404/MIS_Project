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

    public void add(ArrayList<String> elem) throws SQLException {
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
            }
            case ("пользователь"): {
                String sql = "INSERT INTO art_users(uname, usurename, upartronymic, uemail, uhashedpassword, uadmin)  VALUES(?,?,?,?,?,?)";
                try (PreparedStatement ps = conection.prepareStatement(sql)) {
                    ps.setString(1, elem.get(0));
                    ps.setString(2, elem.get(1));
                    ps.setString(3, elem.get(2));
                    ps.setString(4, elem.get(3));
                    ps.setString(5, elem.get(4));
                    ps.setBoolean(6, Boolean.parseBoolean(elem.get(5)));
                    ps.executeUpdate();
                }
            }
            case ("избранное"): {
                String sql = "INSERT INTO art_favorites(user_id, exhibit_id)  VALUES(?,?)";
                try (PreparedStatement ps = conection.prepareStatement(sql)) {
                    ps.setInt(1, Integer.parseInt(elem.get(0)));
                    ps.setInt(2, Integer.parseInt(elem.get(1)));
                    ps.executeUpdate();
                }
            }
        }
    }

    public void delete(int index) throws SQLException {
        conection.createStatement();
        switch (table) {
            case ("экспонаты"): {
                String sql = "DELETE from art_exhibits where id = ?";
                String sql1 = "alter sequence art_exhibits_id_seq restart with ?";
                try (PreparedStatement ps = conection.prepareStatement(sql)) {
                    ps.setInt(1, index);
                    ps.executeUpdate();
                }
                try (PreparedStatement ps = conection.prepareStatement(sql1)) {
                    ps.setInt(1, index - 1);
                    ps.executeUpdate();
                }

            }
            case ("пользователь"): {
                String sql = "DELETE from art_users where id = ?";
                String sql1 = "alter sequence art_users_id_seq restart with ?";
                try (PreparedStatement ps = conection.prepareStatement(sql)) {
                    ps.setInt(1, index);
                    ps.executeUpdate();
                }
                try (PreparedStatement ps = conection.prepareStatement(sql1)) {
                    ps.setInt(1, index - 1);
                    ps.executeUpdate();
                }
            }
            case ("избранное"): {
                String sql = "DELETE from art_users where id = ?";
                String sql1 = "alter sequence art_favorites_id_seq restart with ?";
                try (PreparedStatement ps = conection.prepareStatement(sql)) {
                    ps.setInt(1, index);
                    ps.executeUpdate();
                }
                try (PreparedStatement ps = conection.prepareStatement(sql1)) {
                    ps.setInt(1, index - 1);
                    ps.executeUpdate();
                }
            }
        }

    }
    public ArrayList<String> reading (int id,String s) throws SQLException {
        String sql = "Select * from ? where id = ?";
        ArrayList<String> result = new ArrayList<>();
        conection.createStatement();
        try (PreparedStatement ps = conection.prepareStatement(sql)) {
            ps.setString(1, s);
            ps.setInt(2, id);
            rs = ps.executeQuery();
        }
        switch (table){
            case ("экспонаты"):{
                rs.next();
                for(int i = 1; i<6;i++){
                    result.add(rs.getString(i));
                }
            }
            case ("пользователь"):{
                rs.next();
                for(int i = 1; i<7;i++){
                    result.add(rs.getString(i));
                }
            }
            case ("избранное"):{
                rs.next();
                for(int i = 1; i<3;i++){
                    result.add(rs.getString(i));
                }
            }
        }
        return result;
    }
}

