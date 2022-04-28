package persistencia;

import entidades.Casa;
import entidades.Cliente;
import entidades.Estancia;
import java.sql.SQLException;
import java.util.ArrayList;
import service.MiExcepcion;

/**
 *
 * @author Lautaro Pavez
 */
public class EstanciaDAO extends DAO{
    
    public void guardarEstancia(Estancia e) throws MiExcepcion { //FIjarme si anda el metodo porque en la llamada los numeros y date estsn con comillas simples
        try {
            if (e == null) {
                throw new MiExcepcion("Debe indicar la casa");
            }
            //SENTENCIA DE INSERCIÓN
            String sql = "INSERT INTO estancias (id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta)"
                    + " VALUES ( '" + e.getId_estancia()
                    + "' , '" + e.getCliente().getId_cliente()
                    + "' , '" + e.getCasa().getId_casa()
                    + "' , '" + e.getNombre_huesped()
                    + "' , '" + e.getFecha_desde()
                    + "' , '" + e.getFecha_hasta()
                    + "');";

            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();

            insertarModificarEliminar(sql);
        } catch (MiExcepcion ex) {
            System.out.println(ex.getMessage());
            throw new MiExcepcion("ERROR AL GUARDAR ESTANCIA");
        } finally {
            desconectarBase();
        }
    }

    public void modificarEstancia(Estancia e) throws Exception {
        try {
            if (e == null) {
                throw new Exception("ESTANCIA INVALIDA");
            }

            //SENTENCIA SQL DE MODIFICACIÓN 
             String sql = "UPDATE estancias SET"
                    + "id_cliente = '" + e.getCliente().getId_cliente()+ "', "
                    + "id_casa = '" + e.getCasa().getId_casa()+ "', "
                    + "nombre_huesped= '" + e.getNombre_huesped()+ "', "
                    + "fecha_desde = '" + e.getFecha_desde() + "', "
                    + "fecha_hasta = '" + e.getFecha_hasta() + "', "
                    + "WHERE id_estancia = '" + e.getId_estancia() + "';";
            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();

            insertarModificarEliminar(sql);
        } catch (MiExcepcion ex) {
            System.out.println(ex.getMessage());
            throw new MiExcepcion("ERROR AL MODIFICAR ESTANCIA");
        } finally {
            desconectarBase();
        }
    }

    public Estancia buscarEstanciaPorId(Integer id) throws MiExcepcion, SQLException {
        try {
            //SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM estancias WHERE id_estancia = " + id + " ;";
            //ACA DEBEMOS HACER ALGUN TIPO DE INNER JOIN O VER CLASE DE PROFESORA QUE EXPLICA COMO JUNTAR LAS 3 TABLAS
            consultarBase(sql);

            Estancia e = null;
            Casa c = null;
            Cliente cl = null; 
            while (resultado.next()) {
                e = new Estancia();
                c = new Casa();
                cl = new Cliente();
                        
                e.setId_estancia(resultado.getInt(1));
                e.setNombre_huesped(resultado.getString(4)); // POSIBLE ERROR POR EL NUMERO 2, A CHEQUEAR
                e.setFecha_desde(resultado.getDate(5)); // POSIBLE ERROR POR EL NUMERACION, A CHEQUEAR
                e.setFecha_hasta(resultado.getDate(6)); // POSIBLE ERROR POR EL NUMERACION, A CHEQUEAR
                
                c.setId_casa(resultado.getInt(1));  // POSIBLE ERROR POR EL NUMERACION, A CHEQUEAR
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
                
                cl.setId_cliente(resultado.getInt(1));
                cl.setNombre(resultado.getString(2));
                cl.setCalle(resultado.getString(3));
                cl.setNumero(resultado.getInt(4));
                cl.setCod_postal(resultado.getString(5));
                cl.setCiudad(resultado.getString(6));
                cl.setPais(resultado.getString(7));
                cl.setEmail(resultado.getString(8));     
                
                e.setCasa(c);
                e.setCliente(cl);
            }

            return e;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER ESTANCIA");
        } finally {
            desconectarBase();
        }
    }
    
    //VERIFICA SI EXISTE CASA
    public boolean verificaEstanciaPorId(Integer id) throws MiExcepcion {

        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM estancias WHERE id_estancia = '" + id + "';";
            consultarBase(sql);

            return resultado.next();
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER ESTANCIA");
        } finally {
            desconectarBase();
        }

    }

    public void eliminarEstancia(Integer id) throws MiExcepcion {
        try {
            //SENTENCIA SQL DE CONSULTA
            String sql = " DELETE FROM estancias WHERE id_estancia = " + id + " ;";

            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();

            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL ELIMINAR ESTANCIA");
        } finally {
            desconectarBase();
        }
    }

    public ArrayList<Estancia> listarEstancias() throws MiExcepcion {
        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM estancias";

            consultarBase(sql);

            ArrayList<Estancia> estancias = new ArrayList<>();
            Estancia e = null;
            Casa c = null;
            Cliente cl = null;
            
            while (resultado.next()) {
                e = new Estancia();
                c = new Casa();
                cl = new Cliente();
                
                e.setId_estancia(resultado.getInt(1));
                e.setNombre_huesped(resultado.getString(4)); // POSIBLE ERROR POR NUMERACION, A CHEQUEAR
                e.setFecha_desde(resultado.getDate(5)); // POSIBLE ERROR POR NUMERACION, A CHEQUEAR
                e.setFecha_hasta(resultado.getDate(6)); // POSIBLE ERROR POR NUMERACION, A CHEQUEAR
                
                
                c.setId_casa(resultado.getInt(1)); // POSIBLE ERROR POR NUMERACION, A CHEQUEAR
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

                cl.setId_cliente(resultado.getInt(1));
                cl.setNombre(resultado.getString(2));
                cl.setCalle(resultado.getString(3));
                cl.setNumero(resultado.getInt(4));
                cl.setCod_postal(resultado.getString(5));
                cl.setCiudad(resultado.getString(6));
                cl.setPais(resultado.getString(7));
                cl.setEmail(resultado.getString(8));   
                
                e.setCasa(c);
                e.setCliente(cl);
                
                estancias.add(e);   //Agrego el objeto "c" a la lista -casas-
            }

            return estancias;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER CASAS");
        }finally{
            desconectarBase();
        }
    }
}
