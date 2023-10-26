package gui;

import controller.SeleccionController;
import controller.JugadorController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaBusquedaSeleccion extends Ventana {
    private JButton botonBuscar, botonRegresar;
    private JLabel textoEncabezado, textoCarrera, textoNombre;
    private JComboBox campoSeleccion;
    private JTextField campoNombre;

    public VentanaBusquedaSeleccion() throws ClassNotFoundException {
        super("Búsqueda de Seleccion", 500, 520);
        generarElementosVentana();
    }

    private void generarElementosVentana() throws ClassNotFoundException {
        generarCampoNombre();
        generarBotonBuscarVehiculo();
        generarBotonCancelar();
        generarListaSelecciones();
    }

    private void generarCampoNombre() {
        String textoNombre = "Nombre seleccion:";
        super.generarJLabel(this.textoNombre, textoNombre, 20, 50, 150, 20);
        this.campoNombre = super.generarJTextField(200, 50, 250, 20);
        this.add(this.campoNombre);
    }

    private void generarListaSelecciones() throws ClassNotFoundException {
        super.generarJLabel(this.textoCarrera, "Selecciones inscritas:", 20, 100, 150, 20);
        this.campoSeleccion = super.generarListaDesplegable(SeleccionController.getNombreSelecciones(), 200, 100, 250, 20);
        this.add(this.campoSeleccion);
    }

    private void generarBotonBuscarVehiculo() {
        String textoBoton = "Buscar Seleccion";
        this.botonBuscar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonBuscar);
        this.botonBuscar.addActionListener(this);
    }

    private void generarBotonCancelar() {
        String textoBotonRegresar = "Regresar";
        this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
        this.add(this.botonRegresar);
        this.botonRegresar.addActionListener(this);
    }

    private String[][] exportarDatos() throws ClassNotFoundException {
        if (this.campoNombre.getText().length() == 0 && this.campoSeleccion.getSelectedItem().equals("Error no existen carreras")) {
            JOptionPane.showMessageDialog(this, "Ingrese datos validos");
            return new String[0][0];
        } else if (this.campoNombre.getText().length() == 0) {
            return JugadorController.mostrarJugadoresPorSeleccion(this.campoSeleccion.getSelectedItem().toString(), this.campoNombre.getText());
        }
        return JugadorController.mostrarJugadoresPorSeleccion(this.campoSeleccion.getSelectedItem().toString(), this.campoNombre.getText());
    }


        public void actionPerformed (ActionEvent e){
            if (e.getSource() == this.botonBuscar) {
                String[] nombreColumnas = {"Nombre estudiante", "N° de matricula", "Carrera", "CodigoCarrera"};
                try {
                    VentanaTabla ventanaTabla = new VentanaTabla(exportarDatos(), nombreColumnas);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
            if (e.getSource() == this.botonRegresar) {
                VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                this.dispose();
            }

        }
    }
