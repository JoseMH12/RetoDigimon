package retodigimon;

import Sleer1.SLeer1;

public class Menu {
    
    public static int pideNumero(String mensaje) {
        int num = 0;
        do {
            num = SLeer1.datoInt(mensaje);
            if (num > 3 || num < 1){
                System.err.println("Por favor, introduce un número entre 1 y 3.");
            }
        } while (num > 3 || num < 1);
        return num;
    }
    
    public static void muestraMenu(){
        System.out.println("\t1 - Combate");
        System.out.println("\t2 - Mis digimon");
        System.out.println("\t3 - Salir");
    }
    
    public static void menuPrincipal(int num){
        switch (num){
            case 1: System.out.println("hola"); break;
            case 2: System.out.println("hola2"); break;
            case 3: System.out.println("Saliendo del programa..."); break;
            default: System.out.println("Opción no válida"); break;
        }
    }
}
