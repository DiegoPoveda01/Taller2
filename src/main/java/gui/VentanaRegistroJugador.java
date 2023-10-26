package gui;

import controller.SeleccionController;
import controller.JugadorController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaRegistroJugador extends Ventana {
    private JLabel textoEncabezado, textoNumero, textoNombre, textoSeleccion, textoPosicion;
    private JTextField campoNombre, campoNumero, campoPosicion, campoNombrePais;
    private JComboBox campoSeleccion;
    private JButton botonRegistrar, botonCancelar;


    public VentanaRegistroJugador() throws ClassNotFoundException {
        super("Registro de Jugador", 500, 520);
        generarElementosVentana();
    }
    private void generarElementosVentana() throws ClassNotFoundException {
        generarEncabezado();
        generarBotonCancelar();
        generarBotonRegistrar();
        generarCampoPosicion();
        generarCampoNombre();
        generarCampoNumero();
        generarListaSeleccion();
    }
    private void generarEncabezado() {
        String textoCabecera = "Registro de Jugador";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }
    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Jugador";
        this.botonRegistrar = super.generarBoton(textoBoton, 55, 400, 170, 20);
        this.add(this.botonRegistrar);
        this.botonRegistrar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 170, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }
    private void generarCampoNombre(){
        String textoNombre= "Nombre:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }
    private void generarCampoNumero(){
        String textoNumero= "Numero:";
        super.generarJLabel(this.textoNumero,textoNumero,20,100,150,20);
        this.campoNumero= super.generarJTextField(200,100,250,20);
        this.add(this.campoNumero);
    }
    private void generarCampoPosicion(){
        String textoPosicion= "Posicion:";
        super.generarJLabel(this.textoPosicion,textoPosicion,20,150,150,20);
        this.campoPosicion= super.generarJTextField(200,150,250,20);
        this.add(this.campoPosicion);
    }
    private void generarListaSeleccion() throws ClassNotFoundException {
        super.generarJLabel(this.textoSeleccion, "Selección:", 20, 200, 100, 20);
        this.campoSeleccion = super.generarListaDesplegable(SeleccionController.getNombreSelecciones(), 200, 200, 250, 20);
        this.add(this.campoSeleccion);
    }
    private boolean registrarJugador() throws ClassNotFoundException {
        if (this.campoPosicion.getText().length() == 0 || this.campoNombre.getText().length() == 0 || this.campoNumero.getText().length() == 0 || this.campoSeleccion.getSelectedItem().equals("Error no existen selecciones") || this.campoSeleccion.getSelectedItem().equals("Error no existen selecciones")) {
            return false;
        } else {
            return JugadorController.registrarJugador(
                    this.campoNombre.getText(),
                    Integer.parseInt(this.campoNumero.getText()),
                    this.campoPosicion.getText(),
                    this.campoSeleccion.getSelectedItem().toString() // Agregar la selección
            );
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrar) {
            try {
                if(registrarJugador()) {
                    JOptionPane.showMessageDialog(this,"Jugador registrado correctamente");
                    VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this,"Ingrese datos validos");
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        }
        if (e.getSource() == this.botonCancelar){
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
            this.dispose();
        }

    }

}
