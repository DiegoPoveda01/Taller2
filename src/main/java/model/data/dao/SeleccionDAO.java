package model.data.dao;

import model.Seleccion;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class SeleccionDAO {
    public static void agregarSeleccion(DSLContext query, Seleccion seleccion){
        Table tablaSeleccion= table(name("Seleccion"));
        Field[] columnas = tablaSeleccion.fields("nombre_seleccion","rankingFIFA","id");
        query.insertInto(tablaSeleccion, columnas[0], columnas[1],columnas[2])
                .values(seleccion.getNombre(), seleccion.getRankingFIFA(), seleccion.getId());
    }
    public static boolean validarExistenciaSeleccion(DSLContext query,String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Seleccion")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public static Seleccion buscarSeleccion(DSLContext query, Object dato){
        Result resultados= (Result) buscarSeleccion(query,"id",dato);
        String nombreSelecion = (String) resultados.getValue(0,"nombre_seleccion");
        int rankingFIFA = (int) resultados.getValue(0,"rankingFIFA");
        int id = (int) resultados.getValue(0,"id");
        return new Seleccion(nombreSelecion,rankingFIFA,id);
    }

    public static List buscarSeleccion(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Seleccion")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return resultados;
    }
    public static Object[] getNombreSeleccion(DSLContext query){
        Table seleccion= DSL.table("Seleccion");
        Result resultados = query.select(seleccion.field("nombre_seleccion")).from(seleccion).fetch();
        if(resultados.size()==0){
            return new String[]{"No existen selecciones"};
        }
        else {
            return resultados.getValues("nombre_seleccion").toArray();
        }
    }

}
