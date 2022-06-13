package persistencia;
import entidad.Fabricante;
import excepcion.MiExcepcion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Lautaro Pavez
 */
//    a) Lista el nombre de todos los productos que hay en la tabla producto.
//    b) Lista los nombres y los precios de todos los productos de la tabla producto.
//    c) Listar aquellos productos que su precio esté entre 120 y 202.
//    d) Buscar y listar todos los Portátiles de la tabla producto.
//    e) Listar el nombre y el precio del producto más barato.
//    f) Ingresar un producto a la base de datos.
//    g) Ingresar un fabricante a la base de datos
//    h) Editar un producto con datos a elección.
public final class FabricanteDAO extends DAO{
    
    public void guardarFabricante(Fabricante fabricante) throws MiExcepcion{
        try {
            if (fabricante == null) {
                throw new MiExcepcion("Debe indicar el fabricante");
            }
            // SENTENCIA SQL DE INSERCIÓN
            String sql = "INSERT INTO fabricante (codigo,nombre,nacionalidad)" 
                    + "VALUES ('" + fabricante.getCodigo() + "' , '" + fabricante.getNombre() + "' , '" + fabricante.getNacionalidad() + "' );";
            
            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();
            
            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL GUARDAR FABRICANTE");
        }finally{
            desconectarBase();
        }
    }
    
    //No pedido por el ejercicio
    public void modificarFabricante(Fabricante fabricante) throws Exception{
        try {
            if(fabricante == null){
                throw new Exception("Debe indicar el fabricante");
            }
            
            // SENTENCIA SQL DE MODIFICACIÓN
            String sql = "UPDATE fabricante SET "
                    + "nombre = '" + fabricante.getNombre() + "', "
                    + "nacionalidad = '" + fabricante.getNacionalidad() + "' " 
                    + "WHERE codigo = '" + fabricante.getCodigo() + "';"; //Es indistinto si le pongo comillas simples a lo que quiero setear que sean numeros(precio, codigo,etc)
            
            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();
            
            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }
    
    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {//Este metodo nos sirve para el metodo eliminar por Nombre en la clase ServicioFabricante
        try {
            
            String sql = "SELECT * FROM fabricante "
                    + " WHERE nombre = '" + nombre + "';";

            consultarBase(sql);

            Fabricante fabricante = null; // Lo empiezo como nulo porque en las siguientes lineas me voy a encargar de hacerlo nacer y rellenarlo a este usuario
            
            while (resultado.next()) { // resultado.next() : nos dice si en resultado hay algun valor próximo
                fabricante = new Fabricante();

                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricante.setNacionalidad(resultado.getString(3));
            }
            
            return fabricante;
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }
    
    public Fabricante buscarFabricantePorCodigo(Integer codigo) throws MiExcepcion { //Este metodo nos sirve para el metodo eliminar por Codigo en la clase ServicioFabricante
        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM fabricante WHERE codigo = '" + codigo + "';";

            consultarBase(sql);

            Fabricante fabricante = null;

            while (resultado.next()) {
                fabricante = new Fabricante();

                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricante.setNacionalidad(resultado.getString(3));
            }
              
            return fabricante;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER FABRICANTE");
        } finally {
            desconectarBase();
        }
    }
    
    public void eliminarFabricantePorCodigo(Integer codigo) throws MiExcepcion{
        try {
            //SENTENCIA SQL DE ELIMINACIÓN
            String sql = "DELETE FROM fabricante WHERE codigo = '" + codigo + "';";
            
            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();
            
            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL ELIMINAR FABRICANTE");
        } finally {
            desconectarBase();
        }
    }
    
    public void eliminarFabricanteporNombre(String nombre) throws MiExcepcion {
        try {
            //SETENCIA SQL DE ELIMINACIÓN
            String sql = "DELETE FROM fabricante WHERE nombre = '" + nombre + "';";

            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();

            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL ELIMINAR FABRICANTE");
        } finally {
            desconectarBase();
        }
    }
    
    public void ConsultartablaFabricante(String sql)throws MiExcepcion{
        try {
            String consulta = sql;
            
             // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(consulta);
            System.out.println();
            
            consultarBase(sql);
            //insertarModificarEliminar(consulta); // No sería esta porque esta la modificaría
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL REALIZAR LA CONSULTA");
        }finally{
            desconectarBase();
        }
    }
    
    public List<Fabricante> obtenerFabricantes() throws MiExcepcion{
        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM fabricante"; 
        
            consultarBase(sql);
        
            List<Fabricante> fabricantes = new ArrayList<>();
            Fabricante fabricante = null;
        
            while (resultado.next()) {
                fabricante = new Fabricante();
                
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricante.setNacionalidad(resultado.getString(3));
                
                fabricantes.add(fabricante);                       
            }
            
            return fabricantes;
        } catch (SQLException | MiExcepcion e) {
        System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER USUARIOS");
        } finally {
            desconectarBase();
        }
    }
    
    //COMPROBAR SI FUNCIONA, POSIBLE ERROR EN LINEA 152 AL LADO DE LA COMILLA SIMPLE LE PUSE UN PUNTO Y COMA
    public List<Fabricante> buscarFabricanteporNom(String nombre) throws MiExcepcion{
        try {
            String sql = "SELECT * FROM fabricante "
                    + "WHERE nombre = '" + nombre + "';";
            
            consultarBase(sql);
            List<Fabricante> fabricantes = new ArrayList<>();
            Fabricante p = null;// Lo empiezo como nulo porque en las siguientes lineas me voy a encargar de hacerlo nacer y rellenarlo a este fabricante
            
            while (resultado.next()) {                
                p = new Fabricante(); //instancio el objeto de mi clase Fabricante
                
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setNacionalidad(resultado.getString(3));
                
                fabricantes.add(p); //Agrego a la lista el objeto instanciado y seteado
                
            }
            
            return fabricantes;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER FABRICANTE");
        } finally {
            desconectarBase();
        }
    }
    
    //VERIFICA SI EXISTE ALGÚN FABRICANTE CON ESE CÓDIGO
    public boolean verificarCodigo(int codigo) throws MiExcepcion {

        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM fabricante WHERE codigo = '" + codigo + "';";
            consultarBase(sql);
            
            return resultado.next();
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER FABRICANTE");
        } finally {
            desconectarBase();
        }
    }
    
    
    
}
