package retodigimon;

import Sleer1.SLeer1;

public class Digimon {
    //ATRIBUTOS DE LA CLASE
    private String nombreDig = "";
    private int ataque = 0;
    private int defensa = 0;
    private Tipo tipo = Tipo.NULO;
    private int nivel = 1;
    private String nombreDigEvo = "";
    

    //CONSTRUCTOR VACIO
    //Digimon d1 = new Digimon();
    public Digimon() {
       
    }

    public String getNombreDig() {
        return nombreDig;
    }

    public void setNombreDig(String nombreDig) {
        this.nombreDig = nombreDig;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombreDigEvo() {
        return nombreDigEvo;
    }

    public void setNombreDigEvo(String nombreDigEvo) {
        this.nombreDigEvo = nombreDigEvo;
    }
}
