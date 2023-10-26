package gui;

import controller.SeleccionController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaRegistroSeleccion extends Ventana {
    private JLabel textoEncabezado, textoCodigo, textoNombre, textoRankingSeleccion;
    private JTextField campoNombre, campoRanking;
    private JButton botonRegistrar, botonCancelar;


    public VentanaRegistroSeleccion(){
        super("Registro de Seleccion", 500, 520);
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarBotonCancelar();
        generarBotonRegistrar();
        generarCampoNombre();
        generarCampoRankingSelecion();
    }
    private void generarEncabezado() {
        String textoCabecera = "Registro de Seleccion";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 100, 10, 290, 50);

    }
    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Seleccion";
        this.botonRegistrar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonRegistrar);
        this.botonRegistrar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }
    private void generarCampoNombre(){
        String textoNombre= "Nombre:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }
    private void generarCampoRankingSelecion(){
        String textoCodigo= "Ranking:";
        super.generarJLabel(this.textoRankingSeleccion,textoCodigo,20,100,150,20);
        this.campoRanking= super.generarJTextField(200,100,250,20);
        this.add(this.campoRanking);
    }

    private boolean registrarSeleccion() throws ClassNotFoundException {
        if(this.campoNombre.getText().length()==0 || this.campoRanking.getText().length()==0){
            return false;
        }
        else{
            return SeleccionController.añadirSeleccion(this.campoNombre.getText(), Integer.parseInt(this.campoRanking.getText()));

        }
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrar) {
            try {
                if(registrarSeleccion()) {
                    JOptionPane.showMessageDialog(this,"Seleccion registrada");
                    VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this,"Seleccion ya ingresada");
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
