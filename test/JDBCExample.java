/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author venecia2
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class JDBCExample {

     public static void main(String[] args){
        try
      {
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pollwebdb?serverTimezone=UTC&useSSL=false","website","webpass");


  JOptionPane.showMessageDialog(null,"connected with "+con.toString());


      }
      catch(Exception e)
      {
          System.out.println("not connect to server and message is "+e.getMessage());
      }
     }
}
