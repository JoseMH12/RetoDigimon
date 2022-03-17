package retodigimon;

import Sleer1.SLeer1;

public class Menu {
    
    public static int muestraMenu() {
        System.out.println("------ Bienvenido al mundo digimon ------\n");
        System.out.println("\t1 - Crear jugador");
        System.out.println("\t2 - Eliminar jugador");
        System.out.println("\t3 - Modificar jugador");
        System.out.println("\n\t4 - Crear digimon");
        System.out.println("\t5 - Eliminar digimon");
        System.out.println("\t6 - Modificar digimon");
        System.out.println("\n\t7 - Borrar datos");
        System.out.println("\t8 - Salir");

        int opcion = SLeer1.datoInt("\nElige una opción: ");
        return opcion;
    }

    public static void menuPrincipal(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("\nHas elegido crear un nuevo jugador");
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
                System.out.println("\nOpción no válida");
                break;
        }
    }
}
