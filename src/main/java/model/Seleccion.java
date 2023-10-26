package model;

public class Seleccion {
  private String nombre;
  private int rankingFIFA;
  private int id;

    public Seleccion(String nombre, int rankingFIFA, int id) {
        this.nombre = nombre;
        this.rankingFIFA = rankingFIFA;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public int getRankingFIFA() {
        return rankingFIFA;
    }
    public int getId() {
        return id;
    }
}
