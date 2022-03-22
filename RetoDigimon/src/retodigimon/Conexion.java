/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retodigimon;

import Sleer1.SLeer1;
import java.sql.*;

/**
 *
 * @author ismael
 */
public class Conexion {

    public static final String URL = "jdbc:mysql://localhost:3306/digimon";
    public static final String USER = "root";
    public static final String CLAVE = "123";

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
    
    public static void crearJugador(){
        Jugador j1 = new Jugador();
        String nomJug = SLeer1.datoString("Introduce el nombre de usuario: ");
        j1.setNick(nomJug);
        String conJug = SLeer1.datoString("Introduce la contrseña del usuario: ");
        j1.setContrasenya(conJug);
        
        getConexion();
        String consulta = "SELECT * FROM jugadores WHERE nombre=?";
        PrepareStatement si = prepareStatement(consulta);
        
    }
}
