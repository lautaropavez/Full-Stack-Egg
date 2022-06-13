package servicio;

import entidad.Producto;
import excepcion.MiExcepcion;
import java.util.List;
import persistencia.ProductoDAO;

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
public class ServicioProducto {

    private ProductoDAO dao;

    public ServicioProducto() {
        this.dao = new ProductoDAO();
    }

    public void crearProducto(Integer codigo, String nombre, Double precio, Integer cod_fab) throws MiExcepcion {

        try {
            //VALIDACIÓN
            if (codigo == null || codigo < 0) {
                throw new MiExcepcion("Debe ingresar un codigo");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new MiExcepcion("Debe ingresar un nombre");
            }
            if (precio == null || precio < 0) {
                throw new MiExcepcion("Debe ingresar un precio");
            }
            if (cod_fab == null | cod_fab < 0) {
                throw new MiExcepcion("Debe ingresar un codigo de fabricante");
            }

            if (!dao.verificarFabricante(cod_fab)) {
                throw new MiExcepcion("NO EXISTE EL FABRICANTE");
            }
            
            if (dao.verificarCodigo(codigo))
            {
                throw new MiExcepcion("YA EXISTE UN PRODUCTO CON ESTE CÓDIGO");
            }
            Producto producto = new Producto();

            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(cod_fab);

            dao.guardarProducto(producto);

        } catch (MiExcepcion e) {
            throw e;
        } catch (Exception e) {
            throw new MiExcepcion("ERROR DEL SISTEMA");
        }
    }

    public void modificarProducto(Integer codigo, String nombre, Double precio, Integer cod_fab) throws MiExcepcion {
        try {
            //VALIDACIÓN 
            if (codigo == null || codigo < 0) {
                throw new MiExcepcion("Debe ingresar un codigo");
            }
            if (nombre == null | nombre.trim().isEmpty()) {
                throw new MiExcepcion("Debe ingresar un nombre");
            }
            if (precio == null || precio < 0) {
                throw new MiExcepcion("Debe ingresar un precio");
            }
            if (cod_fab == null | cod_fab < 0) {
                throw new MiExcepcion("Debe ingresar un codigo de fabricante");
            }
            
            if (!dao.verificarFabricante(cod_fab)) {
                throw new MiExcepcion("NO EXISTE EL FABRICANTE");
            }       
            
            Producto producto = dao.buscarProductoPorCodigo(codigo);

            if (producto == null) {
                throw new MiExcepcion("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN FABRICANTE");
            }

            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(cod_fab);

            dao.modificarProducto(producto);
        } catch (MiExcepcion e) {
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    public void eliminarProductoPorCodigo(Integer codigo) throws MiExcepcion {
        try {
            // VALIDACIÓN
            if (codigo == null || codigo < 0) {
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }
            //Buscamos
            Producto producto = dao.buscarProductoPorCodigo(codigo);

            if (producto == null) {
                throw new MiExcepcion("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN PRODUCTO");
            }

            dao.eliminarProductoporCodigo(codigo);
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    public void eliminarProductoPorNombre(String nombre) throws MiExcepcion {
        try {
            // VALIDACIÓN
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new MiExcepcion("DEBE INGRESAR UN NOMBRE");
            }
            //Buscamos
            Producto producto = dao.buscarProductoPorNombre(nombre);

            if (producto == null) {
                throw new MiExcepcion("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN PRODUCTO");
            }

            dao.eliminarProductoporNombre(nombre);
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    //MUESTRA
    public void muestraProducto() throws MiExcepcion { //muestraProducto()

        try {
            List<Producto> productos = dao.obtenerProductos();

            if (productos.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            } else {
                System.out.println("*** LISTA DE USUARIOS ***");
                System.out.printf("%-8s%-34s%-15s%-10s\n", "CODIGO", "NOMBRE", "PRECIO $", "COD FABRICANTE"); //FORMATO DE IMPRESIÓN 
//                System.out.println("\n*** LISTA DE PRODUCTOS ***");
//                System.out.printf("%-8s%-10s%-15s%-5s\n", "CODIGO", "Cod.FABR", "PRECIO $", "NOMBRE");
                productos.forEach(aux -> {
                    System.out.println(aux);
                });
                System.out.println();
//                for (Producto producto : productos) { //OTRA FORMA DE HACERLO
//                    System.out.println(producto);   
//                }
            }
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    //MUESTRA POR NOMBRE
    public void muestraPorNombre(String nombre) throws MiExcepcion {
        try {
            List<Producto> productos = dao.obtenerProductos();

            if (productos.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            } else {
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-15s\n", "NOMBRE"); // FORMATO DE IMPRESIÓN
                productos.forEach(aux -> {
                    System.out.println(aux.getNombre());
                });
                System.out.println();
            }
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }

    }
    
    //BUSCA POR NOMBRE
    public void buscaPorNombre(String nomb) throws MiExcepcion {
        try {
            List<Producto> productos = dao.buscarProductoporNomb(nomb);

            if (productos.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            } else {
                System.out.println("\n*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-8s%-10s%-10s%-15s\n", "CODIGO", "Cod.FABR", "PRECIO $", "NOMBRE"); // FORMATO DE IMPRESIÓN, + INFO sobre System.out.printf("") https://xperti.io/blogs/formatting-with-printf-in-java/

                productos.forEach(aux
                        -> {
                    System.out.println(aux);
                });
                System.out.println();
            }
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }

    }

    public void listarPorNombre() throws MiExcepcion {
        try {

            List<Producto> productos = dao.obtenerProductos();

            if (productos.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            } else {
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-35s%-10s\n", "NOMBRE","PRECIO"); // FORMATO DE IMPRESIÓN
                for (Producto aux : productos) {
                    System.out.printf("%-35s%-10s\n",aux.getNombre(),aux.getPrecio());
                   
                }
                System.out.println();
            }

        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    public void buscarMasBarato() throws MiExcepcion{

        try {
           Producto p = dao.buscarMasBarato(); 
           
            if (p == null)
            {
                throw new MiExcepcion("NO HAY PRODUCTO");
            }
            System.out.println("\n*** PRODUCTO MAS ECONOMICO ***");
            System.out.printf("%-15s%-35s%-15s%-25s\n", "CODIGO","NOMBRE","PRECIO","FABRICANTE");//                        
            System.out.printf("%-15s%-35s%-15s%-25s\n",p.getCodigo(),p.getNombre(), "$" + p.getPrecio(), p.getCodigoFabricante()); 
            System.out.println();
        } catch (MiExcepcion e){
            // e.printStackTrace();
            throw e;
        } catch (Exception e)
        {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    public void muestraRango(double min,double max) throws MiExcepcion{
        try {
            List<Producto> productos = dao.obtenerRangoPrecios(min, max);
            
            if (productos.isEmpty())
            {
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            } else{
                  System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-15s%-35s%-15s%-25s\n", "CODIGO", "NOMBRE", "PRECIO", "FABRICANTE"); // FORMATO DE IMPRESIÓN
                productos.forEach(aux ->{
                    System.out.printf("%-15s%-35s%-15s%-25s\n", aux.getCodigo(), aux.getNombre(), "$" + aux.getPrecio(), aux.getCodigoFabricante());
                });
                System.out.println();
            }
        } catch (MiExcepcion e) {
         // e.printStackTrace();
            throw e;
        } catch (Exception e)
        {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
}
