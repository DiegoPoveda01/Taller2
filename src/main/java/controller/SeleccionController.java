package controller;

import model.Seleccion;
import model.data.dao.SeleccionDAO;
import model.data.DBConnector;
import model.data.DBGenerator;
import org.jooq.DSLContext;

public class SeleccionController {

    public static boolean añadirSeleccion(String nombre, int rankingFIFA) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("SuperCopa");
        if(!SeleccionDAO.validarExistenciaSeleccion(query,"nombre_seleccion",nombre)){
            Seleccion seleccion = new Seleccion(nombre,rankingFIFA);
            SeleccionDAO.agregarSeleccion(query, seleccion);
            DBConnector.closeConnection();
            return true;
        }
        else{
            System.out.println("eror");
            return false;
        }
    }
    public static Object[] getNombreSelecciones() throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("SuperCopa");
        Object[] selecciones = SeleccionDAO.getNombreSeleccion(query);
        DBConnector.closeConnection();
            return selecciones;
    }

}
