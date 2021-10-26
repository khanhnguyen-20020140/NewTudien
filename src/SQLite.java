import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SQLite {
//     Dictionary dictionary;
//    SQLite(){
//        dictionary= new Dictionary();
//    }
//    private Connection connect() {
//        // SQLite connection string
//        String url = "jdbc:sqlite:C://Users/Dell/Downloads/dict_hh.db";
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return conn;
//    }
//
//    public void selectAll(){
//        String sql = "SELECT * FROM av";
//
//        try {
//            Connection conn = this.connect();
//            Statement stmt  = conn.createStatement();
//            ResultSet rs    = stmt.executeQuery(sql);
//            String engWord="";
//            String meaningWord="";
//            // loop through the result set
//            while (rs.next()) {
////                System.out.println(rs.getString("word") +  "\t" +
////                        rs.getString("description")) ;
//                engWord=rs.getString("word");
//                meaningWord= rs.getString("description");
//                Word word=new Word(engWord, meaningWord);
//                dictionary.setList(word);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }


    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        SQLite app = new SQLite();
//        app.selectAll();
//    }
//    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            System.out.println("System.out");
//            System.err.println("System.err");
//        }
//    }
}
