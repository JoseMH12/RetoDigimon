package retodigimon;

import Sleer1.SLeer1;

public class Menu {

    public Menu()throws Exception{
        int opcion = muestraMenu();
        menuPrincipal(opcion);
    }
    /*public static String logIn(){
        System.out.println("------ Bienvenido al mundo digimon ------\n");
        String usuario= SLeer1.datoString("Nombre usuario: ");
        String contraseña=SLeer1.datoString("Contraseña: ");
        String login=usuario+contraseña;
        return login;
    }*/
    
    /*public static void comprobacionUser(String login){
        
        if(login.equals(Conexion.CLAVE)){
        muestraMenuAd();
        }else if("usuario existe"){
            muestraMenuUs();
        }else{
            String usuario= SLeer1.datoString("Nombre usuario: ");
            String contraseña=SLeer1.datoString("Contraseña: ");
            "crear usuario"
        }
    }*/
    /*public static int muestraMenuUs(){
        System.out.println("------ Menu Jugador ------\n");
        System.out.println("\t1 - Jugar");
        System.out.println("\t2 - Equipo");
        System.out.println("\t3 - Mis Digimons");
        System.out.println("\t4 - Salir");
        int opcion = SLeer1.datoInt("Elige una opción: ");
        return opcion;
    }*/
    /*public static void menuPrincipalUs(int opcion){
       SLeer1.limpiar();
        switch (opcion) {
            case 1:
                System.out.println("\nHas elegido la opción jugar");
                muestraMenu();
                break;
            case 2:
                System.out.println("\nHas elegido la opción equipo");
                muestraMenu();
                break;
            case 3:
                System.out.println("\nHas elegido la opción mis digimons");
                muestraMenu();
                break;
            case 4:
                System.out.println("\nSaliendo...");
                muestraMenu();
                break;
            default: 
                System.out.println("Opción no válida, introduce una opción entre 1 y 4 ...\n\n"); 
                menuPrincipal(muestraMenu());
        }
    }*/
    public static int muestraMenu() {               //muestra menu admin
        System.out.println("------ Menu de administrador ------\n");
        System.out.println("\t1 - Crear jugador");
        System.out.println("\t2 - Eliminar jugador");
        System.out.println("\t3 - Modificar jugador");
        System.out.println("\n\t4 - Crear digimon");
        System.out.println("\t5 - Eliminar digimon");
        System.out.println("\t6 - Modificar digimon");
        System.out.println("\n\t7 - Borrar datos");
        System.out.println("\t8 - Salir");
        
        int opcion = SLeer1.datoInt("Elige una opción: ");
        return opcion;
    }

    public static void menuPrincipal(int opcion) throws Exception{
        SLeer1.limpiar();
        switch (opcion) {
            case 1:
                System.out.println("\nHas elegido crear un nuevo jugador");
                Conexion.crearJugador();
                menuPrincipal(muestraMenu());
                break;
            case 2:
                System.out.println("\nHas elegido eliminar un nuevo jugador");
                menuPrincipal(muestraMenu());
                break;
            case 3:
                System.out.println("\nHas elegido modificar un nuevo jugador");
                menuPrincipal(muestraMenu());
                break;
            case 4:
                System.out.println("\nHas elegido crear un nuevo digimon");
                try{
                    Conexion.crearDigimon();
                    menuPrincipal(muestraMenu());
                }catch (Exception ex){
                    System.err.println("Error: " + ex.getMessage());
                    System.out.println("\n");
                    menuPrincipal(muestraMenu());
                }
                break;
            case 5:
                System.out.println("\nHas elegido eliminar un nuevo digimon");
                try{
                    Conexion.eliminarDigimon();
                    menuPrincipal(muestraMenu());
                }catch (Exception ex){
                    System.err.println("Error: " + ex.getMessage());
                    System.out.println("\n");
                    menuPrincipal(muestraMenu());
                }
                break;
            case 6:
                System.out.println("\nHas elegido modificar un nuevo digimon");
                try{
                    Conexion.modificarDigimon();
                    menuPrincipal(muestraMenu());
                }catch (Exception ex){
                    System.err.println("Error: " + ex.getMessage());
                    System.out.println("\n");
                    menuPrincipal(muestraMenu());
                }
                break;
            case 7:
                System.out.println("\nHas elegido restablecer los datos del programa");
                menuPrincipal(muestraMenu());
                break;
            case 8:
                System.out.println("\nSaliendo del programa...");
                break;
            default: 
                System.out.println("Opción no válida, introduce una opción entre 1 y 8...\n\n"); 
                menuPrincipal(muestraMenu());
        }
    }
}
