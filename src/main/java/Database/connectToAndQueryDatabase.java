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
    Statement stmt = null;
    ResultSet rs = null;
    
    public connectToAndQueryDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("mysql://127.11.26.2:3306/java", "adminiTh2QFu", "FCmhgwXPwVC2");
            stmt = (Statement) con.createStatement();
            
            String query = "SELECT * FROM Person";
            rs = stmt.executeQuery(query);
            out.println("records from database");
            while(rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                out.println("Name: " + name + "Age: " + age);
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
    }

    private void createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
