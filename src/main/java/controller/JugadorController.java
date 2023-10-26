package controller;

import model.Seleccion;
import model.Jugador;
import model.data.dao.SeleccionDAO;
import model.data.DBConnector;
import model.data.DBGenerator;
import model.data.dao.JugadorDAO;
import org.jooq.DSLContext;

public class JugadorController {

    public static boolean registrarJugador(String nombre, int numero, String posicion, String nombrePais) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("SuperCopa");
        if(!JugadorDAO.validarExistenciaJugador(query,"nombre",nombre)){
            Seleccion seleccion = SeleccionDAO.buscarSeleccion(query,nombrePais);
            Jugador jugador = new Jugador(nombre,numero,posicion,nombrePais,seleccion);
            JugadorDAO.agregarJugador(query, jugador);
            DBConnector.closeConnection();
            return true;
        }
        else{
            DBConnector.closeConnection();
            return false;
        }
    }
    public static String[][] mostrarJugadoresPorSeleccion(String nombreJugador, String nombrePais) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("SuperCopa");
        String[][] datosJugadores= JugadorDAO.obtenerJugadoresPorSeleccion(query,nombreJugador, nombrePais);
        DBConnector.closeConnection();
        return datosJugadores;
    }
}
