package model;

public class Seleccion {
  private String nombre;
  private int rankingFIFA;


    public Seleccion(String nombre, int rankingFIFA) {
        this.nombre = nombre;
        this.rankingFIFA = rankingFIFA;
    }

    public String getNombre() {
        return nombre;
    }
    public int getRankingFIFA() {
        return rankingFIFA;
    }
}
