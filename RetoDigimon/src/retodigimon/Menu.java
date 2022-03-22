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

    public static void menuPrincipal(int opcion) {
        SLeer1.limpiar();
        switch (opcion) {
            case 1:
                System.out.println("\nHas elegido crear un nuevo jugador");
                Conexion.crearJugador();

                System.out.println("Nombre: "+j1.getNick() + " - " + "Contraseña: " + j1.getContrasenya());

                muestraMenu();
                break;
            case 2:
                System.out.println("\nHas elegido eliminar un nuevo jugador");
                muestraMenu();
                break;
            case 3:
                System.out.println("\nHas elegido modificar un nuevo jugador");
                muestraMenu();
                break;
            case 4:
                System.out.println("\nHas elegido crear un nuevo digimon");
                
                Digimon d1 = new Digimon();
                SLeer1.limpiar();
                System.out.println("Nombre: " +d1.getNombreDig()+ "\nAtaque: " +d1.getAtaque()+ "\nDefensa: " +d1.getDefensa()+ "\nTipo: " +d1.getTipo()+ "\nNivel: " +d1.getNivel()+"\nDigievolucion: " +d1.getNombreDigEvo());
                //El nombre de la evolucion no se muestra, comprobar.
                
                muestraMenu();
                break;
            case 5:
                System.out.println("\nHas elegido eliminar un nuevo digimon");
                muestraMenu();
                break;
            case 6:
                System.out.println("\nHas elegido modificar un nuevo digimon");
                muestraMenu();
                break;
            case 7:
                System.out.println("\nHas elegido restablecer los datos del programa");
                muestraMenu();
                break;
            case 8:
                System.out.println("\nSaliendo del programa...");
                muestraMenu();
                break;
            default: 
                System.out.println("Opción no válida, introduce una opción entre 1 y 8...\n\n"); 
                menuPrincipal(muestraMenu());
        }
    }
}
