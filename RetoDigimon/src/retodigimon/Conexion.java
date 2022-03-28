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
    public static final String CLAVE = "culoculo";

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
        boolean salir = false;
        while (salir != true) {
            String nomJug = SLeer1.datoString("Introduce el nombre de usuario: ");
            j1.setNick(nomJug);

            Connection con = getConexion();
            if (existeJugador(nomJug) == false) {
                String conJug = SLeer1.datoString("Introduce la contraseña del usuario: ");
                j1.setContrasenya(conJug);

                String insert = "INSERT INTO jugador (nick, contraseña) VALUES (?,?)";
                PreparedStatement ps = con.prepareStatement(insert);
                ps.setString(1, j1.getNick());
                ps.setString(2, j1.getContrasenya());
                ps.executeUpdate();
                System.out.println("Se ha agregado el jugador " + nomJug + " a la base de datos\n\n");
                salir = true;
            } else {
                System.out.println("El jugador " + nomJug + " ya existe, prueba con otro nombre.");
            }
        }

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
                    menuMod = SLeer1.datoInt("\nElige el campo a modificar:\n---------------------------- \n1 - Nick\n2 - Contraseña\n\nOpcion: ");
                    if (menuMod < 1 && menuMod > 2) {
                        System.err.println("Error, opcion no valida");
                    }
                } while (menuMod < 1 || menuMod > 2);
                SLeer1.limpiar();
                switch (menuMod) {
                    case 1:

                        boolean salida = false;
                        while (salida != true) {
                            String nuevoNombre = SLeer1.datoString("Introduce el nuevo nombre: ");
                            if (existeJugador(nuevoNombre) == true) {

                                System.err.println("Error, el jugador introducido ya existe.");

                            } else {

                                String update = "UPDATE jugador SET nick = '" + nuevoNombre + "' WHERE nick = '" + nomJug + "';";
                                PreparedStatement psUpdate = con.prepareStatement(update);
                                psUpdate.executeUpdate();
                                System.out.println("Nombre del jugador modificado correctamente\n\n");
                                salir = true;
                                salida = true;

                            }
                        }
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

    public static boolean existeEvolucion(String nombre) {
        try {
            Connection con = getConexion();
            String consulta = ("SELECT nomDigiEv FROM digimon WHERE nomDigiEv = '" + nombre + "';");
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
        //System.out.println(d1.getTipo());
        boolean salir = false;
        while (salir != true) {
            String nomDig = SLeer1.datoString("Introduce el nombre del digimon: ");
            d1.setNombreDig(nomDig);

            if (existeDigimon(nomDig) == false) {
                int atqDig = SLeer1.datoInt("Introduce el ataque del digimon: ");
                d1.setAtaque(atqDig);

                int defDig = SLeer1.datoInt("Introduce la defensa del digimon: ");
                d1.setDefensa(defDig);
                SLeer1.limpiar();

                Tipo t = null;
                boolean bandera = false;
                do {
                    int menuTipo = 0;
                    do {
                        menuTipo = SLeer1.datoInt("Introduce el tipo del digimon: \n----------------------------------\n1 - NULO\n2 - VACUNA\n3 - VIRUS\n4 - ANIMAL\n5 - PLANTA\n6 - ELEMENTAL\nOpcion: ");
                        if (menuTipo < 1 || menuTipo > 6) {
                            System.err.println("Error, opcion no valida");
                        }
                    } while (menuTipo < 1 || menuTipo > 6);

                    switch (menuTipo) {
                        case 1:
                            t = Tipo.NULO;
                            System.out.println("Has elegido el tipo Nulo");
                            bandera = true;
                            break;
                        case 2:
                            t = Tipo.VACUNA;
                            System.out.println("Has elegido el tipo Vacuna");
                            bandera = true;
                            break;
                        case 3:
                            t = Tipo.VIRUS;
                            System.out.println("Has elegido el tipo Virus");
                            bandera = true;
                            break;
                        case 4:
                            t = Tipo.ANIMAL;
                            System.out.println("Has elegido el tipo Animal");
                            bandera = true;
                            break;
                        case 5:
                            t = Tipo.PLANTA;
                            System.out.println("Has elegido el tipo Planta");
                            bandera = true;
                            break;
                        case 6:
                            t = Tipo.ELEMENTAL;
                            System.out.println("Has elegido el tipo Elemental");
                            bandera = true;
                            break;
                    }

                } while (bandera != true);
                salir = true;

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
                ps.setString(4, t.name());
                ps.setInt(5, d1.getNivel());
                ps.setString(6, d1.getNombreDigEvo());
                ps.executeUpdate();
                System.out.println("Se ha agregado el digimon " + nomDig + " a la base de datos\n\n");
                salir = true;

            } else {
                System.out.println("El digimon " + nomDig + " ya existe, prueba con otro nombre.");
            }

        }
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
                    menuMod = SLeer1.datoInt("\nElige el campo a modificar:\n--------------------------- \n1 - Nombre\n2 - Ataque\n3 - Defensa\n4 - Tipo\n5 - Nivel\n6 - Nombre Evolución\n\nOpcion: ");
                    if (menuMod < 1 || menuMod > 6) {
                        System.err.println("Error, opcion no valida");
                    }
                } while (menuMod < 1 || menuMod > 6);
                SLeer1.limpiar();
                switch (menuMod) {
                    case 1:
                        boolean salirnom = false;
                        while (salirnom != true) {
                            String nuevoNombreD = SLeer1.datoString("Introduce el nuevo nombre: ");
                            if (existeDigimon(nuevoNombreD) == true) {
                                System.err.println("Error,el digimon ya existe");

                            } else {
                                String update = "UPDATE digimon SET nomDig = '" + nuevoNombreD + "' WHERE nomDig = '" + nomDig + "';";
                                PreparedStatement psUpdate = con.prepareStatement(update);
                                psUpdate.executeUpdate();
                                System.out.println("Nombre del digimon modificado correctamente\n\n");
                                salir = true;

                            }

                        }
                        break;
                    case 2:
                        int nuevoAtaque = SLeer1.datoInt("Introduce el nuevo ataque del digimon : ");
                        String update2 = "UPDATE digimon SET ataque = '" + nuevoAtaque + "' WHERE nomDig = '" + nomDig + "';";
                        PreparedStatement psUpdate2 = con.prepareStatement(update2);
                        psUpdate2.executeUpdate();
                        System.out.println("Ataque modificado correctamente\n");
                        salir = true;
                        break;
                    case 3:
                        int nuevaDefensa = SLeer1.datoInt("Introduce la nueva defensa del digimon : ");
                        String update3 = "UPDATE digimon SET defensa = '" + nuevaDefensa + "' WHERE nomDig = '" + nomDig + "';";
                        PreparedStatement psUpdate3 = con.prepareStatement(update3);
                        psUpdate3.executeUpdate();
                        System.out.println("Defensa modificada correctamente\n");
                        salir = true;
                        break;
                    case 4:
                        Tipo t = null;
                        boolean bandera = false;
                        do {
                            int menuMod2 = 0;
                            do {
                                menuMod2 = SLeer1.datoInt("\nElige el tipo: \n--------------\n1 - NULO\n2 - VACUNA\n3 - VIRUS\n4 - ANIMAL\n5 - PLANTA\n6 - ELEMENTAL\nOpcion: ");
                                if (menuMod2 < 1 && menuMod2 > 6) {
                                    System.err.println("Error, opcion no valida");
                                }
                            } while (menuMod2 < 1 || menuMod2 > 6);

                            switch (menuMod2) {
                                case 1:
                                    t = Tipo.NULO;
                                    bandera = true;
                                    break;
                                case 2:
                                    t = Tipo.VACUNA;
                                    bandera = true;
                                    break;
                                case 3:
                                    t = Tipo.VIRUS;
                                    bandera = true;
                                    break;
                                case 4:
                                    t = Tipo.ANIMAL;
                                    bandera = true;
                                    break;
                                case 5:
                                    t = Tipo.PLANTA;
                                    bandera = true;
                                    break;
                                case 6:
                                    t = Tipo.ELEMENTAL;
                                    bandera = true;
                                    break;
                            }

                        } while (bandera != true);
                        String update4 = "UPDATE digimon SET tipo = '" + t.name() + "' WHERE nomDig = '" + nomDig + "';";
                        PreparedStatement psUpdate4 = con.prepareStatement(update4);
                        psUpdate4.executeUpdate();
                        System.out.println("Tipo modificado correctamente\n\n");
                        salir = true;
                        break;
                    case 5:
                        int nuevoNivel = 0;
                        do {
                            nuevoNivel = SLeer1.datoInt("Introduce el nuevo nivel del digimon (del 1 al 3): ");
                        } while (nuevoNivel < 1 || nuevoNivel > 3);

                        String update5 = "UPDATE digimon SET nivel = '" + nuevoNivel + "' WHERE nomDig = '" + nomDig + "';";
                        PreparedStatement psUpdate5 = con.prepareStatement(update5);
                        psUpdate5.executeUpdate();
                        System.out.println("Nivel modificado correctamente\n\n");
                        salir = true;
                        break;
                    case 6:
                        boolean salidaev = false;
                        while (salidaev != true) {
                            String nuevaEvolucion = SLeer1.datoString("Introduce la nueva evolucion del digimon : ");
                            if (existeEvolucion(nuevaEvolucion) == true) {
                                System.err.println("Error, la evolución introducida ya existe.");

                            } else {
                                String update6 = "UPDATE digimon SET nomDigiEv  = '" + nuevaEvolucion + "' WHERE nomDig = '" + nomDig + "';";
                                PreparedStatement psUpdate6 = con.prepareStatement(update6);
                                psUpdate6.executeUpdate();
                                System.out.println("Evolución modificada correctamente\n\n");
                                salir = true;
                                break;
                            }

                        }

                }
            } else {
                System.err.println("El digimon " + nomDig + " no existe");
            }
        }
    }

    public static void restablecerPrograma() throws Exception {
        System.out.println("Borrando jugadores...");
        Connection con = getConexion();
        String restablecerJug = "DELETE FROM jugador;";
        PreparedStatement psRestablecerJug = con.prepareStatement(restablecerJug);
        psRestablecerJug.executeUpdate();
        System.out.println("Jugadores eliminados correctamente\n\n");

        System.out.println("Borrando digimones...");
        Connection con2 = getConexion();
        String restablecerDig = "DELETE FROM digimon;";
        PreparedStatement psRestablecerDig = con2.prepareStatement(restablecerDig);
        psRestablecerDig.executeUpdate();
        System.out.println("Digimones eliminados correctamente\n\n");
    }
}
