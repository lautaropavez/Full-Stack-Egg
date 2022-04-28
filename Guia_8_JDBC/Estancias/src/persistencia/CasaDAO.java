package persistencia;

import entidades.Casa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import service.MiExcepcion;

/**
 *
 * @author Lautaro Pavez
 */
/*
Realizar un menú en java a través del cual se permita elegir qué consulta se 
desea realizar. Las consultas a realizar sobre la BD son las siguientes:
a) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima
inferior a 10 años.
b) Buscar y listar las casas disponibles para el periodo comprendido entre 
el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
c) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.
d) Consulta la BD para que te devuelva aquellas casas disponibles a partir de 
una fecha dada y un número de días específico.
e) Listar los datos de todos los clientes que en algún momento realizaron una
estancia y la descripción de la casa donde la realizaron.
f) Listar todas las estancias que han sido reservadas por un cliente, mostrar
el nombre, país y ciudad del cliente y además la información de la casa que 
reservó. La que reemplazaría a la anterior
g) Debido a la devaluación de la libra esterlina con respecto al euro se desea 
incrementar el precio por día en un 5% de todas las casas del Reino Unido. 
Mostar los precios actualizados.
h) Obtener el número de casas que existen para cada uno de los países diferentes.
i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas 
(comentarios) que están ‘limpias’.
j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad 
de las fechas. Para finalizar, pensar junto con un compañero cómo sería posible
optimizar las tablas de la BD para tener un mejor rendimiento
 */
public class CasaDAO extends DAO {
    //GUARDA
    public void guardarCasa(Casa c) throws MiExcepcion { //FIjarme si anda el metodo porque en la llamada los numeros y date estsn con comillas simples
        try {
            if (c == null) {
                throw new MiExcepcion("Debe indicar la casa");
            }
            //SENTENCIA DE INSERCIÓN
            String sql = "INSERT INTO producto (id_casa, calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda)"
                    + " VALUES ( '" + c.getId_casa()
                    + "' , '" + c.getCalle()
                    + "' , '" + c.getNumero()
                    + "' , '" + c.getCodigo_postal()
                    + "' , '" + c.getCiudad()
                    + "' , '" + c.getPais()
                    + "' , '" + c.getFecha_desde()
                    + "' , '" + c.getFecha_hasta()
                    + "' , '" + c.getTiempo_min()
                    + "' , '" + c.getTiempo_max()
                    + "' , '" + c.getPrecio_habitacion()
                    + "' , '" + c.getTipo_vivienda()
                    + "');";

            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();

            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL GUARDAR PRODUCTO");
        } finally {
            desconectarBase();
        }
    }
    
    //MODIFICA
    public void modificarCasa(Casa c) throws Exception {
        try {
            if (c == null) {
                throw new Exception("Debe indicar la casa");
            }

            //SENTENCIA SQL DE MODIFICACIÓN 
            String plantilla = "UPDATE casas SET "
                    + "calle = '%s', "
                    + "numero = %d, " //Es indistinto si le pongo comillas simples a lo que quiero setear que sean numeros(precio, codigo,etc)
                    + "codigo_postal = '%s', " //posible error
                    + "ciudad = '%s', "
                    + "pais = '%s', "
                    + "fecha_desde = %t, "
                    + "fecha_hasta = %t, "
                    + "tiempo_minimo = %d, "
                    + "tiempo_maximo = %d, "
                    + "precio_habitacion = %s, " // Lo convierto al double en un String (explicación ultimo video de JDBC min 16:50)
                    + "tipo_vivienda = '%s' "
                    + "WHERE id_casa = %d ;";

            String sql = String.format(plantilla, c.getId_casa(), c.getCalle(), c.getNumero(),
                    c.getCodigo_postal(), c.getCiudad(), c.getPais(), c.getFecha_desde(),
                    c.getFecha_hasta(), c.getTiempo_min(), c.getTiempo_max(), c.getPrecio_habitacion(),
                    c.getTipo_vivienda(), c.getId_casa());
            System.out.printf("");

            //OTRA MANERA DE MANDAR EL STRING POR SI NO FUNCIONA 
//             String sql = "UPDATE casas SET"
//                    + "calle = '" + c.getCalle() + "', "
//                    + "numero = '" + c.getNumero() + "', "
//                    + "codigo_postal= '" + c.getCodigo_postal() + "', "
//                    + "ciudad = '" + c.getCiudad() + "', "
//                    + "pais = '" + c.getPais() + "', "
//                    + "fecha_desde = '" + c.getFecha_desde() + "', "
//                    + "fecha_hasta = '" + c.getFecha_hasta() + "', "
//                    + "tiempo_minimo = '" + c.getTiempo_min() + "', "
//                    + "tiempo_maximo = '" + c.getTiempo_max() + "', "
//                    + "precio_habitacion = '" + c.getPrecio_habitacion() + "', "
//                    + "tipo_vivienda = '" + c.getTipo_vivienda() + "' "
//                    + "WHERE id_casa = '" + c.getId_casa() + "';";
            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();

            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL MODIFICAR CASA");
        } finally {
            desconectarBase();
        }
    }
    
    //BUSCA
    public Casa buscarCasaPorId(Integer id) throws MiExcepcion {
        try {
            //SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM casas WHERE id_casa = " + id + " ;";

            consultarBase(sql);

            Casa c = null;

            while (resultado.next()) {
                c = new Casa();

                c.setId_casa(resultado.getInt(1));
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_min(resultado.getInt(9));
                c.setTiempo_max(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getDouble(11));
                c.setTipo_vivienda(resultado.getString(12));
            }

            return c;
        } catch (SQLException | MiExcepcion e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER CASA");
        } finally {
            desconectarBase();
        }
    }
    
    //BUSCAR MAS BARATA
    public Casa buscarMasBarata() throws MiExcepcion {

        try {
            /* SENTENCIA SQL DE CONSULTA
            select *
            from producto
            order by precio
            limit 1;
             */
            String sql = "SELECT * FROM casas order by precio_habitacion LIMIT 1 ;";
            consultarBase(sql);
            Casa c = null;

            while (resultado.next()) {
                c = new Casa(); //instancio en objeto de mi clase Producto

                c.setId_casa(resultado.getInt(1));
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_min(resultado.getInt(9));
                c.setTiempo_max(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getDouble(11));
                c.setTipo_vivienda(resultado.getString(12));
            }

            return c;

        } catch (SQLException | MiExcepcion e) {
            
            System.out.println(e.getMessage());
            // e.printStackTrace();
            throw new MiExcepcion("ERROR AL OBTENER CASA");
        } finally {
            desconectarBase();
        }
    }
    
    //LISTA BUSCA POR PAIS
    public List<Casa> buscarCasaPorPais(String pais) throws MiExcepcion {//Lo ponemos como lista para en el menu mostrar la lista de todos las casas. METODO QUE SERA UTILIZADO POR OTRO METODO EN SERVICE PARA BUSCAR CASAS POR PAIS

        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM casas WHERE pais = '" + pais + "';";

            consultarBase(sql);
            List<Casa> casas = new ArrayList<>();
            Casa c = null;

            while (resultado.next()) {
                c = new Casa();

                c.setId_casa(resultado.getInt(1));
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_min(resultado.getInt(9));
                c.setTiempo_max(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getDouble(11));
                c.setTipo_vivienda(resultado.getString(12));

                casas.add(c);//Agrego a la lista el objeto instanciado y seteado
            }

            return casas;
        } catch (SQLException | MiExcepcion e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER CASA");
        } finally {
            desconectarBase();
        }
    }
    
    //LISTA BUSCA POR CIUDAD
    public List<Casa> buscarCasaPorCiudad(String ciudad) throws MiExcepcion {//Lo ponemos como lista para en el menu mostrar la lista de todos las casas. METODO QUE SERA UTILIZADO POR OTRO METODO EN SERVICE PARA BUSCAR CASAS POR CIUDAD  
        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM casas WHERE ciudad = '" + ciudad + "';";

            consultarBase(sql);
            List<Casa> casas = new ArrayList<>();
            Casa c = null;

            while (resultado.next()) {
                c = new Casa();

                c.setId_casa(resultado.getInt(1));
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_min(resultado.getInt(9));
                c.setTiempo_max(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getDouble(11));
                c.setTipo_vivienda(resultado.getString(12));

                casas.add(c);//Agrego a la lista el objeto instanciado y seteado
            }

            return casas;
        } catch (SQLException | MiExcepcion e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER CASA");
        } finally {
            desconectarBase();
        }
    }
    
    
    //LISTA BUSCA POR TIPO DE CASA
    public List<Casa> buscarCasaPorTipo(String tipo_vivienda) throws MiExcepcion {//Lo ponemos como lista para en el menu mostrar la lista de todos las casas. METODO QUE SERA UTILIZADO POR OTRO METODO EN SERVICE PARA BUSCAR CASAS POR CIUDAD 
        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM casas WHERE tipo_vivienda = '" + tipo_vivienda + "';";

            consultarBase(sql);
            List<Casa> casas = new ArrayList<>();
            Casa c = null;

            while (resultado.next()) {
                c = new Casa();

                c.setId_casa(resultado.getInt(1));
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_min(resultado.getInt(9));
                c.setTiempo_max(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getDouble(11));
                c.setTipo_vivienda(resultado.getString(12));

                casas.add(c);//Agrego a la lista el objeto instanciado y seteado
            }

            return casas;
        } catch (SQLException | MiExcepcion e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER CASA");
        } finally {
            desconectarBase();
        }
    }
    
    // //LISTA BUSCA POR RANGO PRECIO
    public List<Casa> obtenerRangoPrecios(double min, double max) throws MiExcepcion {

        try {

            /* SENTENCIA SQL DE CONSULTA */
            String sql = "SELECT * FROM casas WHERE precio_habitacion BETWEEN " + min +" AND " + max + " ;";
            
            consultarBase(sql);
            List<Casa> casas = new ArrayList<>();
            Casa c = null;

            while (resultado.next()) {
                c = new Casa();

                c.setId_casa(resultado.getInt(1));
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_min(resultado.getInt(9));
                c.setTiempo_max(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getDouble(11));
                c.setTipo_vivienda(resultado.getString(12));

                casas.add(c);//Agrego a la lista el objeto instanciado y seteado
            }

            return casas;
        } catch (SQLException | MiExcepcion e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER CASA");
        } finally {
            desconectarBase();
        }
    }
    
    //LISTA BUSCA POR RANGO FECHA- EN PROCESO
    public List<Casa> obtenerRangoFecha(Date fecha_desde, Date fecha_hasta) throws MiExcepcion {

        try {
            //POSIBLE FORMA SE SETEAR, SERIA SEPARARLO POR DIA, MES, AÑO Y VER COMO SE PASA POR MYSQLS
            /* SENTENCIA SQL DE CONSULTA */
            
            String sql = "SELECT * FROM casas WHERE fecha_desde = '" + fecha_desde + "'" + " ;";
            
            consultarBase(sql);
            List<Casa> casas = new ArrayList<>();
            Casa c = null;

            while (resultado.next()) {
                c = new Casa();

                c.setId_casa(resultado.getInt(1));
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_min(resultado.getInt(9));
                c.setTiempo_max(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getDouble(11));
                c.setTipo_vivienda(resultado.getString(12));

                casas.add(c);//Agrego a la lista el objeto instanciado y seteado
            }

            return casas;
        } catch (SQLException | MiExcepcion e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER CASA");
        } finally {
            desconectarBase();
        }
    }
    
    //VERIFICA SI EXISTE CASA
    public boolean verificaCasaPorId(int id_casa) throws MiExcepcion {

        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM casas WHERE id_casa = '" + id_casa + "';";
            consultarBase(sql);

            return resultado.next();
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER CASA");
        } finally {
            desconectarBase();
        }

    }
    
    //ELIMINA
    public void eliminarCasa(Integer id) throws MiExcepcion {
        try {
            //SENTENCIA SQL DE CONSULTA
            String sql = " DELETE FROM casas WHERE id_casa = " + id + " ;";

            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();

            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL ELIMINAR CASA");
        } finally {
            desconectarBase();
        }
    }

    public ArrayList<Casa> listarCasas() throws MiExcepcion {
        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM casas";

            consultarBase(sql);

            ArrayList<Casa> casas = new ArrayList<>();
            Casa c = null;

            while (resultado.next()) {
                c = new Casa();

                c.setId_casa(resultado.getInt(1));
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_min(resultado.getInt(9));
                c.setTiempo_max(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getDouble(11));
                c.setTipo_vivienda(resultado.getString(12));

                casas.add(c);   //Agrego el objeto "c" a la lista -casas-
            }

            return casas;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER CASAS");
        }finally{
            desconectarBase();
        }
    }
    
}