package persistencia;

import entidad.Producto;
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
public final class ProductoDAO extends DAO {
    //GUARDAR
    public void guardarProducto(Producto producto) throws MiExcepcion {
        try {
            if (producto == null) {
                throw new MiExcepcion("Debe indicar el producto");
            }
            // SENTENCIA SQL DE INSERCIÓN
            String sql = "INSERT INTO producto (codigo,nombre,precio,codigo_fabricante)"
                    + "VALUES ( '" + producto.getCodigo() + "' , '" + producto.getNombre() + "' , '" + producto.getPrecio() + "' , '" + producto.getCodigoFabricante() + "' );";

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

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el usuario");
            }

            //SENTENCIA SQL DE MODIFICACIÓN 
            String sql = "UPDATE producto SET "
                    + "nombre = '" + producto.getNombre() + "', "
                    + "precio = " + producto.getPrecio() + ", "
                    + "codigo_fabricante = " + producto.getCodigoFabricante() + " "
                    + "WHERE codigo = " + producto.getCodigo() + ";";   //Es indistinto si le pongo comillas simples a lo que quiero setear que sean numeros(precio, codigo,etc)

            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();

            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL MODIFICAR PRODUCTO");
        } finally {
            desconectarBase();
        }
    }
    
    //BUSCAR
    public Producto buscarProductoPorCodigo(int cod) throws MiExcepcion { //Este metodo nos sirve para el metodo eliminar en la clase ServicioProducto

        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM producto WHERE codigo = '" + cod + "';";
            consultarBase(sql);
            Producto p = null;

            while (resultado.next()) {
                p = new Producto();

                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
            }
            return p;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER PRODUCTO");
        } finally {
            desconectarBase();
        }
    } 

    //BUSCAR
    public Producto buscarProductoPorNombre(String nomb) throws MiExcepcion {

        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM producto WHERE nombre = '" + nomb + "';";
            consultarBase(sql);
            Producto p = null;

            while (resultado.next()) {
                p = new Producto();//instancio en objeto de mi clase Producto

                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
            }
            return p;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER PRODUCTO");
        } finally {
            desconectarBase();
        }
    }
    
    //BUSCAR- NO SIRVE ESTE MÉTODO PORQUE HACE UNA LISTA DE LO QUE BUSCA POR CODIGO Y SIEMPRE EL CODIGO ES UNICO
//    public List<Producto> buscarProductoPorCod(Integer codigo) throws MiExcepcion {
//        try {
//            // SENTENCIA SQL DE CONSULTA
//            String sql = "SELECT * FROM producto WHERE codigo = '" + codigo + "';";
//
//            consultarBase(sql);
//            List<Producto> productos = new ArrayList<>();
//            Producto p = null;
//
//            while (resultado.next()) {
//                p = new Producto();
//
//                p.setCodigo(resultado.getInt(1));
//                p.setNombre(resultado.getString(2));
//                p.setPrecio(resultado.getDouble(3));
//                p.setCodigoFabricante(resultado.getInt(4));
//
//                productos.add(p);//Agrego a la lista el objeto instanciado y seteado
//            }
//
//            return productos;
//        } catch (SQLException | MiExcepcion e) {
//            System.out.println(e.getMessage());
//            throw new MiExcepcion("ERROR AL OBTENER PRODUCTO");
//        } finally {
//            desconectarBase();
//        }
//   }
    
    public List<Producto> buscarProductoporNomb(String nombre) throws MiExcepcion { //Lo ponemos como lista para en el menu mostrar la lista de todos los productos. Vamos a hacer un metodo igual pero en vez de List va a ser Producto solo(osea Object) en otras palabras en este metodo pasamos una lista, en el otro un objeto
        try {
            String sql = "SELECT * FROM producto "
                    + "WHERE nombre = '" + nombre + "';";

            consultarBase(sql);
            List<Producto> productos = new ArrayList<>();
            Producto p = null; // Lo empiezo como nulo porque en las siguientes lineas me voy a encargar de hacerlo nacer y rellenarlo a este usuario

            while (resultado.next()) {
                p = new Producto(); //instancio en objeto de mi clase Producto

                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));

                productos.add(p);//Agrego a la lista el objeto instanciado y seteado
            }

            return productos;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER PRODUCTO");
        } finally {
            desconectarBase();
        }
    }

    //ELIMINAR
    public void eliminarProductoporCodigo(Integer codigo) throws MiExcepcion {
        try {
            //SETENCIA SQL DE ELIMINACIÓN
            String sql = "DELETE FROM producto WHERE codigo = '" + codigo + "';";

            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();

            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL ELIMINAR PRODUCTO");
        } finally {
            desconectarBase();
        }
    }

    //ELIMINAR
    public void eliminarProductoporNombre(String nombre) throws MiExcepcion {
        try {
            //SETENCIA SQL DE ELIMINACIÓN
            String sql = "DELETE FROM producto WHERE nombre = '" + nombre + "';";

            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();

            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL ELIMINAR PRODUCTO");
        } finally {
            desconectarBase();
        }
    }
    
    //OBTENER
    public List<Producto> obtenerProductos() throws MiExcepcion {
        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM producto";

            consultarBase(sql);

            List<Producto> productos = new ArrayList<>();
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();

                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));

                productos.add(producto);
            }

            return productos;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER PRODUCTOS");
        } finally {
            desconectarBase();
        }
    }

    //NO LA USO PORQUE NO ES NECESARIO, YA QUE SEGUN PROFE NECESITAMOS HACR CONSULTAS PERSONALIZADAS EN EL FUTURO
    public void ConsultartablaProducto(String sql) throws MiExcepcion { //Fijarme si la puedo hacer abstracta
        try {
            //String consulta = sql;

            consultarBase(sql);

        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL REALIZAR LA CONSULTA");
        } finally {
            desconectarBase();
        }
    }

    //VERIFICA SI EXISTE FABRICANTE
    public boolean verificarFabricante(Integer cod_fab) throws MiExcepcion {

        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM fabricante WHERE codigo = '" + cod_fab + "';";
            consultarBase(sql);
            return resultado.next();

        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER FABRICANTE");
        } finally {
            desconectarBase();
        }
    }

    //VERIFICA SI EXISTE ALGÚN PRODUCTO CON ESE CÓDIGO
    public boolean verificarCodigo(Integer codigo) throws MiExcepcion {

        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM producto WHERE codigo = '" + codigo + "';";
            consultarBase(sql);
            return resultado.next();

        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER PRODUCTO");
        } finally {
            desconectarBase();
        }
    }

    //BUSCAR MAS BARATO
    public Producto buscarMasBarato() throws MiExcepcion {

        try {
            /* SENTENCIA SQL DE CONSULTA
            select *
            from producto
            order by precio
            limit 1;
             */
            String sql = "SELECT * FROM producto order by precio LIMIT 1 ;";
            consultarBase(sql);
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto(); //instancio en objeto de mi clase Producto

                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            return producto;

        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER PRODUCTO");
        } finally {
            desconectarBase();
        }
    }
    
    //OBTENER RANGO PRECIOS
    public List<Producto> obtenerRangoPrecios(double min, double max) throws MiExcepcion {

        try {

            /* SENTENCIA SQL DE CONSULTA
                select * from producto p JOIN fabricante f ON f.codigo = p.codigo_fabricante "
                    + "WHERE p.precio BETWEEN "+min+ "AND "+max+" ;";
            */
            String sql = "SELECT * FROM producto WHERE precio BETWEEN " + min +" AND " + max + " ;";
            
            //String sql = "select from producto p JOIN fabricante f ON f.codigo = p.codigo_fabricante "
            //        + "WHERE p.precio BETWEEN " + min + " AND " + max + " ;";

            consultarBase(sql);
            List<Producto> productos = new ArrayList<>();
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();

                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));

                productos.add(producto);
            }

            return productos;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER USUARIOS");
        } finally {
            desconectarBase();
        }

    }
}
