package model;


public class Jugador {

 private String nombre;
 private int numero;
 private String posicion;
 private String nombrePais;
 private Seleccion seleccion;

    public Jugador(String nombre, int numero, String posicion, String nombrePais, Seleccion seleccion) {
        this.nombre = nombre;
        this.numero = numero;
        this.posicion = posicion;
        this.nombrePais = nombrePais;
        this.seleccion = seleccion;

    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public String getNombre() {
        return nombre;
    }
    public int getNumero() {
        return numero;
    }
    public String getPosicion() {
        return posicion;
    }
    public String getNombrePais() {
        return nombrePais;
    }


    @Override
    public String toString(){
        return this.nombre+","+this.numero+","+this.posicion+","+this.nombrePais+","+this.seleccion.getNombre();
    }
}
