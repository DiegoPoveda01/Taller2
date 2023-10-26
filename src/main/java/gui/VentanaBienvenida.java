package gui;
import javax.swing.*;
import java.awt.event.*;
public class VentanaBienvenida extends Ventana {

    private JLabel textoMenu;
    private JButton botonRegistrarSeleccion;
    private JButton botonSalida;
    private JButton botonRegistrarJugador;
    private JButton botonBuscarJugador;

    public VentanaBienvenida() {
        super("SuperCopa FIFA 2023", 500, 520);
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonRegistrarSeleccion();
        generarBotonRegistrarJugador();
        generarBotonBuscarSeleccion();
        generarBotonSalir();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "SuperCopa2023";
        super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 20, 30, 500, 30);
    }

    private void generarBotonRegistrarSeleccion() {
        String textoBoton = "Registrar Seleccion";
        this.botonRegistrarSeleccion = super.generarBoton(textoBoton, 150, 100, 175, 40);
        this.add(this.botonRegistrarSeleccion);
        this.botonRegistrarSeleccion.addActionListener(this);
    }

    private void generarBotonSalir() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 150, 420, 175, 40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }

    private void generarBotonRegistrarJugador() {
        String textoBoton = "Registrar Jugador";
        this.botonRegistrarJugador = super.generarBoton(textoBoton, 150, 180, 175, 40);
        this.add(this.botonRegistrarJugador);
        this.botonRegistrarJugador.addActionListener(this);
    }
    private void generarBotonBuscarSeleccion(){
        String textoBoton = "Buscar Jugador";
        this.botonBuscarJugador=super.generarBoton(textoBoton, 150, 260, 175, 40);
        this.add(this.botonBuscarJugador);
        this.botonBuscarJugador.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrarSeleccion) {
            VentanaRegistroSeleccion ventanaRegistroSeleccion = new VentanaRegistroSeleccion();
            //Cierra la ventana actual
            this.dispose();
        }
        if(e.getSource() == this.botonRegistrarJugador){
            try {
                VentanaRegistroJugador ventanaRegistroJugador = new VentanaRegistroJugador();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
        if(e.getSource() == this.botonBuscarJugador){
            try {
                VentanaBusquedaSeleccion ventanaBusquedaSeleccion = new VentanaBusquedaSeleccion();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }

        if(e.getSource() == this.botonSalida){
            this.dispose();
            System.exit(0);
        }

    }
}
