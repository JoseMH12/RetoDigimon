/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retodigimon;

import java.sql.*;

/**
 *
 * @author ismael
 */
public class Conexion {

    public static final String URL = "jdbc:mysql://localhost:3306/digimon";
    public static final String USER = "root";
    public static final String CLAVE = "culoculo";

    public Connection getConexion() throws Exception {
        Connection con = null;
        try {
            Connection connection = DriverManager.getConnection(URL, USER, CLAVE);

            //Statement statement = connection.createStatement();
           // ResultSet rs = statement.executeQuery("SELECT * FROM digimon");

            //while (rs.next()) {

              //  String nombre = rs.getString("nomDig");

                //System.out.println(nombre);
            //}
            //rs.close();
            //statement.close();
            //connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}
