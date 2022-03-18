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
        this.nombreDig = SLeer1.datoString("Nombre del digimon: ");
        this.ataque = SLeer1.datoInt("Ataque del digimon: ");
        this.defensa = SLeer1.datoInt("Defensa del digimon: ");
        this.tipo = Tipo.NULO;
        this.nivel = SLeer1.datoInt("Nivel del digimon: ");
        this.nombreDigEvo = SLeer1.datoString("Nombre de la evolución: ");
    }

    //CONSTRUCTOR CON SOLO NOMBRE
    //Digimon d2 = new Digimon("Pepe");
    public Digimon(String nombreDig) {
        this.nombreDig = nombreDig;
        ataque = 0;
        defensa = 0;
        tipo = Tipo.NULO;
        nivel = 1;
        nombreDigEvo = "";
    }

    //CONSTRUCTOR CON NOMBRE Y TIPO
    //Digimon d3 = new Digimon("Pepe",Tipo.PLANTA);
    public Digimon(String nombreDig, Tipo tipo) {
        this.nombreDig = nombreDig;
        ataque = 0;
        defensa = 0;
        this.tipo= tipo;
        nivel = 1;
        nombreDigEvo = "";
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
