package model;

public class Seleccion {
  private String nombre;
  private String rankingFIFA;
  private int id;

    public Seleccion(String nombre, String rankingFIFA, int id) {
        this.nombre = nombre;
        this.rankingFIFA = rankingFIFA;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public String getRankingFIFA() {
        return rankingFIFA;
    }
    public int getId() {
        return id;
    }
}
