/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package retodigimon;

/**
 *
 * @author auron
 */
public class RetoDigimon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jugador j1 = new Jugador();
        Jugador j2 = new Jugador("Jose");
        Jugador j3 = new Jugador("Andres", "123");
        Digimon d1 = new Digimon();
        Digimon d2 = new Digimon("Metalgreimon");
        Digimon d3 = new Digimon("Agumon", Tipo.VACUNA);

        System.out.println(d3.getNombreDig() + " " + d3.getTipo());
    }
    
}
