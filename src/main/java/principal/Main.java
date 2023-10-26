package principal;

import gui.VentanaBienvenida;
import model.data.DBGenerator;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        DBGenerator.iniciarBD("SuperCopa");
        VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
    }
}
