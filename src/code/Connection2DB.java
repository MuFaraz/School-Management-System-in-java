/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammad Faraz
 */
public class Connection2DB {
     public Connection setConnection(){
        String dataSourceName="Database/skol.accdb";
        String dir = System.getProperty("user.dir");
        String url = "jdbc:ucanaccess://"+dir+"/" + dataSourceName;
        //String url = "jdbc:ucanaccess://C:/Users/INTEL/Documents/NetBeansProjects/prjPassword/database/PasswordDB.accdb";
        java.sql.Connection con=null;
        try {
              con = DriverManager.getConnection(url);
        }
        catch(Exception e){
                   JOptionPane.showMessageDialog( null, "CONNECTION  ","Error", JOptionPane.ERROR_MESSAGE);
       }
        return con;
    }
    
    
}
