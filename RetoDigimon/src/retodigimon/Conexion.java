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
    public static final String CLAVE = "a";

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

    public static boolean existeJugador(String nombre) {
        try {

            Connection con = getConexion();
            String consulta = ("SELECT nick FROM jugador WHERE nick = '" + nombre + "';");
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public static void crearJugador() throws Exception {
        Jugador j1 = new Jugador();
        String nomJug = SLeer1.datoString("Introduce el nombre de usuario: ");
        j1.setNick(nomJug);
        String conJug = SLeer1.datoString("Introduce la contrseña del usuario: ");
        j1.setContrasenya(conJug);

        Connection con = getConexion();
        String insert = "INSERT INTO jugador (nick, contraseña) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(insert);
        ps.setString(1, j1.getNick());
        ps.setString(2, j1.getContrasenya());
        ps.executeUpdate();
        System.out.println("Se ha agregado el jugador " + nomJug + " a la base de datos\n\n");
    }

    public static void eliminarJugador() throws Exception {
        boolean salir = false;
        while (salir != true) {
            String nombreEliminar = SLeer1.datoString("Nombre del jugador a eliminar: ");
            Connection con = getConexion();
            if (existeJugador(nombreEliminar) == true) {
                String eliminarJug = "DELETE FROM jugador WHERE nick='" + nombreEliminar + "'";
                PreparedStatement psEliminar = con.prepareStatement(eliminarJug);
                psEliminar.executeUpdate();
                System.out.println("Jugador eliminado correctamente\n\n");
                salir = true;
            } else {
                System.out.println("El jugador " + nombreEliminar + " no existe.");
            }

        }
    }

    public static void modificarJugador() throws Exception {
        boolean salir = false;
        while (salir != true) {

            String nomJug = SLeer1.datoString("Introduce el nombre del jugador a modificar: ");

            Connection con = getConexion();

            if (existeJugador(nomJug) == true) {
                int menuMod = 0;
                do {
                    menuMod = SLeer1.datoInt("\n\nElige el campo a modificar: \n\t1 - Nick\n\t2 - Contraseña\nOpcion: ");

                    if (menuMod < 1 && menuMod > 2) {
                        System.err.println("Error, opcion no valida");
                    }
                } while (menuMod < 1 || menuMod > 2);
                SLeer1.limpiar();
                switch (menuMod) {
                    case 1:
                        String nuevoNombre = SLeer1.datoString("Introduce el nuevo nombre: ");
                        String update = "UPDATE jugador SET nick = '" + nuevoNombre + "' WHERE nick = '" + nomJug + "';";
                        PreparedStatement psUpdate = con.prepareStatement(update);
                        psUpdate.executeUpdate();
                        System.out.println("Nombre del jugador modificado correctamente\n\n");
                        salir = true;
                        break;

                    case 2:
                        String nuevaPassword = SLeer1.datoString("Introduce la nueva contraseña: ");
                        String update2 = "UPDATE jugador SET contraseña = '" + nuevaPassword + "' WHERE nick = '" + nomJug + "';";
                        PreparedStatement psUpdate2 = con.prepareStatement(update2);
                        psUpdate2.executeUpdate();
                        System.out.println("Contraseña modificada correctamente\n\n");
                        salir = true;
                        break;

                }

            } else {
                System.err.println("El jugador " + nomJug + " no existe");
            }

        }
    }

    public static boolean existeDigimon(String nombre) {
        try {

            Connection con = getConexion();
            String consulta = ("SELECT nomDig FROM digimon WHERE nomDig = '" + nombre + "';");
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public static void crearDigimon() throws Exception {

        Digimon d1 = new Digimon();
        System.out.println(d1.getTipo());

        String nomDig = SLeer1.datoString("Introduce el nombre del digimon: ");
        d1.setNombreDig(nomDig);

        int atqDig = SLeer1.datoInt("Introduce el ataque del digimon: ");
        d1.setAtaque(atqDig);

        int defDig = SLeer1.datoInt("Introduce la defensa del digimon: ");
        d1.setDefensa(defDig);
        SLeer1.limpiar();

        boolean bandera = false;
        do {
            String t = SLeer1.datoString("Introduce el tipo (NULO,VACUNA,VIRUS,ANIMAL,PLANTA,ELEMENTAL): ").toUpperCase();

            if (t.equals(Tipo.NULO.name())) {
                d1.setTipo(Tipo.NULO);
                bandera = true;
            } else if (t.equals(Tipo.VACUNA.name())) {
                d1.setTipo(Tipo.VACUNA);
                bandera = true;
            } else if (t.equals(Tipo.VIRUS.name())) {
                d1.setTipo(Tipo.VIRUS);
                bandera = true;
            } else if (t.equals(Tipo.ANIMAL.name())) {
                d1.setTipo(Tipo.ANIMAL);
                bandera = true;
            } else if (t.equals(Tipo.PLANTA.name())) {
                d1.setTipo(Tipo.PLANTA);
                bandera = true;
            } else if (t.equals(Tipo.ELEMENTAL.name())) {
                d1.setTipo(Tipo.ELEMENTAL);
                bandera = true;
            } else {
                System.err.println("Tipo no válido.\n");
            }

        } while (bandera != true);

        int nvlDig = SLeer1.datoInt("Introduce el nivel del Digimon: ");
        d1.setNivel(nvlDig);
        SLeer1.limpiar();

        String evoDigEvo = SLeer1.datoString("Introduce el nombre de la digievolucion: ");
        d1.setNombreDigEvo(evoDigEvo);

        Connection con = getConexion();
        String insertdos = "INSERT INTO digimon (nomDig, ataque, defensa, tipo, nivel, nomDigiEv) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insertdos);
        ps.setString(1, d1.getNombreDig());
        ps.setInt(2, d1.getAtaque());
        ps.setInt(3, d1.getDefensa());
        ps.setString(4, d1.getTipo().name());
        ps.setInt(5, d1.getNivel());
        ps.setString(6, d1.getNombreDigEvo());
        ps.executeUpdate();
        System.out.println("Se ha agregado el digimon " + nomDig + " a la base de datos\n\n");

    }

    public static void eliminarDigimon() throws Exception {
        boolean salir = false;
        while (salir != true) {
            String digiEliminar = SLeer1.datoString("Nombre del digimon a eliminar: ");
            Connection con = getConexion();
            if (existeDigimon(digiEliminar) == true) {
                String eliminarDig = "DELETE FROM digimon WHERE nomDig='" + digiEliminar + "';";
                PreparedStatement psEliminar = con.prepareStatement(eliminarDig);
                psEliminar.executeUpdate();
                System.out.println("Digimon eliminado correctamente\n\n");
                salir = true;
            } else {
                System.out.println("El digimon " + digiEliminar + " no existe");
            }

        }
    }

    public static void modificarDigimon() throws Exception {
        boolean salir = false;
        while (salir != true) {

            String nomDig = SLeer1.datoString("Introduce el nombre del digimon a modificar: ");

            Connection con = getConexion();
            
            if (existeDigimon(nomDig) == true) {
                int menuMod = 0;
                do {
                    menuMod = SLeer1.datoInt("\n\nElige el campo a modificar: \n\t1 - Nombre\n\t2 - Ataque\n\t3 - Defensa\n\t4 - Tipo\n\t5 - Nivel\n\t6 - Nombre Evolución\nOpcion: ");

                    if (menuMod < 1 && menuMod > 6) {
                        System.err.println("Error, opcion no valida");
                    }
                } while (menuMod < 1 || menuMod > 6);
                SLeer1.limpiar();
                switch (menuMod) {
                    case 1:
                        String nuevoNombreD = SLeer1.datoString("Introduce el nuevo nombre: ");
                        String update = "UPDATE digimon SET nomDig = '" + nuevoNombreD + "' WHERE nomDig = '" + nomDig + "';";
                        PreparedStatement psUpdate = con.prepareStatement(update);
                        psUpdate.executeUpdate();
                        System.out.println("Nombre del digimon modificado correctamente\n\n");
                        salir = true;
                        break;

                    case 2:
                        String nuevoAtaque = SLeer1.datoString("Introduce el nuevo ataque del digimon : ");
                        String update2 = "UPDATE digimon SET ataque = '" + nuevoAtaque + "' WHERE nomDig = '" + nomDig + "';";
                        PreparedStatement psUpdate2 = con.prepareStatement(update2);
                        psUpdate2.executeUpdate();
                        System.out.println("Ataque modificado correctamente\n\n");
                        salir = true;
                        break;

                    case 3:
                        String nuevaDefensa = SLeer1.datoString("Introduce la nueva defensa del digimon : ");
                        String update3 = "UPDATE digimon SET defensa = '" + nuevaDefensa + "' WHERE nomDig = '" + nomDig + "';";
                        PreparedStatement psUpdate3 = con.prepareStatement(update3);
                        psUpdate3.executeUpdate();
                        System.out.println("Defensa modificada correctamente\n\n");
                        salir = true;
                        break;

                    case 4:
                        Tipo t= null;
                        boolean bandera = false;
                        do {
                            //String nuevoTipo = SLeer1.datoString("Introduce el nuevo tipo del digimon (NULO,VACUNA,VIRUS,ANIMAL,PLANTA,ELEMENTAL): ").toUpperCase();

                            int menuMod2 = 0;
                            
                            do {
                                menuMod2 = SLeer1.datoInt("\n\nElige el tipo: \n\t1 - NULO\n\t2 - VACUNA\n\t3 - VIRUS\n\t4 - ANIMAL\n\t5 - PLANTA\n\t6 - ELEMENTAL\nOpcion: ");

                                if (menuMod2 < 1 && menuMod2 > 6) {
                                    System.err.println("Error, opcion no valida");
                                }
                            } while (menuMod2 < 1 || menuMod2 > 6);
                            
                            switch (menuMod2){
                                case 1 : t= Tipo.NULO;bandera = true; break;
                                case 2 : t= Tipo.VACUNA;bandera = true; break;
                                case 3 : t= Tipo.VIRUS;bandera = true; break;
                                case 4 : t= Tipo.ANIMAL;bandera = true; break;
                                case 5 : t= Tipo.PLANTA;bandera = true; break;
                                case 6 : t= Tipo.ELEMENTAL;bandera = true; break;
                                
                            }

                        } while (bandera != true);
                        String update4 = "UPDATE digimon SET tipo = '" + t.name() + "' WHERE nomDig = '" + nomDig + "';";
                        PreparedStatement psUpdate4 = con.prepareStatement(update4);
                        psUpdate4.executeUpdate();
                        System.out.println("Tipo modificado correctamente\n\n");
                        salir = true;
                        break;
                         
                        
                         case 5:
                        String nuevoNivel = SLeer1.datoString("Introduce el nuevo nivel del digimon : ");
                        String update5 = "UPDATE digimon SET nivel = '" + nuevoNivel + "' WHERE nomDig = '" + nomDig + "';";
                        PreparedStatement psUpdate5 = con.prepareStatement(update5);
                        psUpdate5.executeUpdate();
                        System.out.println("Nivel modificado correctamente\n\n");
                        salir = true;
                        break;
                        
                         case 6:
                        String nuevaEvolucion = SLeer1.datoString("Introduce la nueva evolucion del digimon : ");
                        String update6 = "UPDATE digimon SET nomDigiEv  = '" + nuevaEvolucion + "' WHERE nomDig = '" + nomDig + "';";
                        PreparedStatement psUpdate6 = con.prepareStatement(update6);
                        psUpdate6.executeUpdate();
                        System.out.println("Evolución modificada correctamente\n\n");
                        salir = true;
                        break;
                }

            } else {
                System.err.println("El digimon " + nomDig + " no existe");
            }
            
            

        }
    }
}
