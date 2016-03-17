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
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    public connectToAndQueryDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection) DriverManager.getConnection("mysql://127.11.26.2:3306/java", "adminiTh2QFu", "FCmhgwXPwVC2");
            st = (Statement) con.createStatement();
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
                int age = rs.getInt("age");
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
