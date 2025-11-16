/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;
import java.sql.*;

/** @author Adilson Lima
 * Data: 15/09/2025
 */

public class ConectaBanco {
    public static Connection conectar() throws ClassNotFoundException {
        // Abre uma conexão
        Connection conn = null; 
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresas","root","563526");            
        }catch(SQLException ex){
                System.out.println("Erro - SQL: " + ex);
        }
        return conn;
    }
}
