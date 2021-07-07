import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlTest {

    public static void main(String [] args) throws Exception {
        // Class.forName( "com.mysql.jdbc.Driver" ); // do this in init
        // // edit the jdbc url 
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mybatis?user=root&password=123456");
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery( "select * from user" );
         while (rs.next()) {
             System.out.println(rs.getString("name"));
         }

        System.out.println("Connected?");
    }
}