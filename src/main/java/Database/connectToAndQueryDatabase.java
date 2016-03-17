/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jorda
 */
public class connectToAndQueryDatabase {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public connectToAndQueryDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cs313", "root", "");
            con.createStatement();
        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
    }
    
    public void getData() {
        try {
            String query = "SELECT * FROM Person";
            rs = st.executeQuery(query);
            out.println("records from database");
            while(rs.next()) {
                String name = rs.getString("name");
                String age = rs.getString("age");
                out.println("Name: " + name + "<br>Age: " + age);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    private void createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
