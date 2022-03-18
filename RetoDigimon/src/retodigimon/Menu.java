package retodigimon;

import Sleer1.SLeer1;

public class Menu {

    public Menu(){
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
        if("usuario_admin"){
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
                break;
            case 2:
                System.out.println("\nHas elegido la opción equipo");
                break;
            case 3:
                System.out.println("\nHas elegido la opción mis digimons");
                break;
            case 4:
                System.out.println("\nSaliendo...");
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

    public static void menuPrincipal(int opcion) {
        SLeer1.limpiar();
        switch (opcion) {
            case 1:
                System.out.println("\nHas elegido crear un nuevo jugador");

                Jugador j1 = new Jugador();

                System.out.println(j1.getNick() + " - " + j1.getContrasenya());
                break;
            case 2:
                System.out.println("\nHas elegido eliminar un nuevo jugador");
                break;
            case 3:
                System.out.println("\nHas elegido modificar un nuevo jugador");
                break;
            case 4:
                System.out.println("\nHas elegido crear un nuevo digimon");
                break;
            case 5:
                System.out.println("\nHas elegido eliminar un nuevo digimon");
                break;
            case 6:
                System.out.println("\nHas elegido modificar un nuevo digimon");
                break;
            case 7:
                System.out.println("\nHas elegido restablecer los datos del programa");
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
