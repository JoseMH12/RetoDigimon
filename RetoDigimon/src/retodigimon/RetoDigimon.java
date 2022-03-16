/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package retodigimon;

import java.sql.*;

/**
 *
 * @author auron
 */
public class RetoDigimon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        try {
            Conexion con = new Conexion();
            con.getConexion();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
