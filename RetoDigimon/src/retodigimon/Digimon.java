package retodigimon;

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
        String nombreDig = "";
        int ataque = 0;
        int defensa = 0;
        Tipo tipo = Tipo.NULO;
        int nivel = 1;
        String nombreDigEvo = "";
    }

    //CONSTRUCTOR CON SOLO NOMBRE
    //Digimon d2 = new Digimon("Pepe");
    public Digimon(String nombreDig) {
        this.nombreDig = nombreDig;
        int ataque = 0;
        int defensa = 0;
        Tipo tipo = Tipo.NULO;
        int nivel = 1;
        String nombreDigEvo = "";
    }

    //CONSTRUCTOR CON NOMBRE Y TIPO
    //Digimon d3 = new Digimon("Pepe",Tipo.PLANTA);
    public Digimon(String nombreDig, Tipo tipo) {
        this.nombreDig = nombreDig;
        int ataque = 0;
        int defensa = 0;
        this.tipo= tipo;
        int nivel = 1;
        String nombreDigEvo = "";
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
