package model.data.dao;

import model.Jugador;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class JugadorDAO {
    
    public static void agregarJugador(DSLContext query, Jugador jugador){
        Table tablaJugador= table(name("Jugador"));
        Field[] columnas = tablaJugador.fields("nombre","numero","posicion","nombre_pais","nombre_seleccion");
        query.insertInto(tablaJugador, columnas[0], columnas[1],columnas[2],columnas[3],columnas[4])
                .values(jugador.getNombre(), jugador.getNumero(), jugador.getPosicion(), jugador.getNombrePais(), jugador.getSeleccion().getNombre())
                .execute();

    }
    public List obtenerJugador(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Jugador")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaJugadores(resultados);
    }
    private List obtenerListaJugadores(Result resultados){
        List<Jugador> jugadores = new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String nombre = (String) resultados.getValue(fila,"nombre");
            int numero = (int) resultados.getValue(fila,"numero");
            String posicion = (String) resultados.getValue(fila,"posicion");
            String nombrePais = (String) resultados.getValue(fila,"nombre_pais");
            String nombreSeleccion = (String) resultados.getValue(fila,"nombre_seleccion");
            jugadores.add(new Jugador(nombre,numero,posicion,nombrePais,null));
        }
        return jugadores;
    }
    public static String[][] obtenerJugadoresPorSeleccion(DSLContext query, String nombre, String nombre_selecion){
        Table jugador = DSL.table("Jugador");
        Table seleccion = DSL.table("Seleccion");
        Result resultados = query.select().from(jugador).join(seleccion).on(DSL.field("nombre_seleccion").eq(DSL.field("nombre_seleccion")))
                .where(DSL.field("nombre").eq(nombre)).and(DSL.field("nombre_seleccion").eq(nombre_selecion)).fetch();
        return exportardatos(resultados);
    }
    private static String[][] exportardatos(Result resultados){
        String[][] datosResultado=new String[resultados.size()][4];
        for(int registro = 0; registro < resultados.size(); registro ++){
            datosResultado[registro][0] = (String) resultados.getValue(registro,"nombre");
            datosResultado[registro][1] = (String) resultados.getValue(registro,"numero");
            datosResultado[registro][2] = (String) resultados.getValue(registro,"posicion");
            datosResultado[registro][3] = (String) resultados.getValue(registro,"nombre_pais");
            datosResultado[registro][4] = (String) resultados.getValue(registro,"nombre_seleccion");
        }
        return datosResultado;
    }
    public static boolean validarExistenciaJugador(DSLContext query,String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Jugador")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
            return false;
        }
    }
}
