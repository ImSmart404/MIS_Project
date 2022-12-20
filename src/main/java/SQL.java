import java.sql.Connection;
import java.sql.Statement;

public class SQL {
    private String table;
    private String[] elem;

    private Connection conection;
    private Statement statement;
    public SQL(String table,String[] elem, Connection conection){
        this.table = table;
        this.elem = elem;
        this.conection = conection;

    }
    public void add(){
        switch (table){
            case ("art_exhibits"):{
                String sql = "INSERT INTO art_exhibits(id,ename, edescription, eyear, ephoto, evideo) " + "VALUES(5,'Постоянство памяти','Одна из самых известных картин художника Сальвадора Дали.','1931','https://losko.ru/wp-content/uploads/2019/11/ebd7ff7f9d8ddb7b9a8502168187.jpg','https://www.youtube.com/watch?v=hi0sujvzt8s');";
            }
            case ("art_users"):{

            }
        }
    }
}
