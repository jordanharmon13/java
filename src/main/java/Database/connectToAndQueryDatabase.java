/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
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
        } catch (Exception ex) {
            System.out.println("ERror " + ex);
        }
    }
}
