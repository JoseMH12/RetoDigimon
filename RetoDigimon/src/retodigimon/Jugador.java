package retodigimon;

public class Jugador {
    
    //ATRIBUTOS DE LA CLASE
    private String nick = "";
    private String contrasenya = "";
    private int partidas_ganadas = 0;
    private int partidas_jugadas = 0;

    //CONSTRUCTOR VACIO
    //Jugador j1 = new Jugador();
    public Jugador() {
        String nick = "";
        String contrasenya = "";
        int partidas_ganadas = 0;
        int partidas_jugadas = 0;
    }

    //CONSTRUCTOR CON SOLO NOMBRE
    //Jugador j2 = new Jugador("Pepe");
    public Jugador(String nick) {
        this.nick = nick;
        String contrasenya = "";
        int partidas_ganadas = 0;
        int partidas_jugadas = 0;
    }

    //CONSTRUCTOR CON NOMBRE Y CONTRASEÑA
    //Jugador j3 = new Jugador("Pepe","123");
    public Jugador(String nick, String contrasenya) {
        this.nick = "Pepe";
        this.contrasenya = "123";
        int partidas_ganadas = 0;
        int partidas_jugadas = 0;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public int getPartidas_ganadas() {
        return partidas_ganadas;
    }

    public void setPartidas_ganadas(int partidas_ganadas) {
        this.partidas_ganadas = partidas_ganadas;
    }

    public int getPartidas_jugadas() {
        return partidas_jugadas;
    }

    public void setPartidas_jugadas(int partidas_jugadas) {
        this.partidas_jugadas = partidas_jugadas;
    }

}
