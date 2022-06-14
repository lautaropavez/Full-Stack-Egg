package servicio;

import entidad.Fabricante;
import excepcion.MiExcepcion;
import java.util.List;
import java.util.Set;
import persistencia.FabricanteDAO;

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
public class ServicioFabricante {
    
    private FabricanteDAO dao;

    public ServicioFabricante() {
        this.dao = new FabricanteDAO();
    }
    
    public void crearFabricante(Integer codigo, String nombre,String nacionalidad)throws MiExcepcion{
        
        try {
            //VALIDACIÓN
            if (codigo == null || codigo < 0) {
                throw new MiExcepcion("Debe ingresar un codigo");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new MiExcepcion("Debe ingresar un nombre");
            }
            if (nacionalidad == null || nacionalidad.trim().isEmpty()) {
                throw new MiExcepcion("Debe ingresar una nacionalidad");
            }
            if (dao.verificarCodigo(codigo))
            {
                throw new MiExcepcion("YA EXISTE UN FABRICANTE CON ESTE CÓDIGO");
            }
            
            Fabricante fabricante = new Fabricante();
            
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);
            fabricante.setNacionalidad(nacionalidad);
            
            dao.guardarFabricante(fabricante);
        } catch (MiExcepcion e) {
            throw e;
        } catch (Exception e) { 
            throw new MiExcepcion("ERROR DEL SISTEMA");
        }
    }
    
    //Agregado por mí, no es requerido por el ejercicio. (CREO QUE NO ME SIRVE)
    public void modificarFabricante(Integer codigo,String nombre,String nacionalidad)throws MiExcepcion {
        
        try {
            // VALIDACIÓN
            if (codigo == null || codigo < 0) {
                throw new MiExcepcion("Debe ingresar un codigo");
            }
            if(nombre == null | nombre.trim().isEmpty()){
                throw new MiExcepcion("Debe ingresar un nombre");
            }
            if(nacionalidad == null | nacionalidad.trim().isEmpty()){
                throw new MiExcepcion("Debe ingresar un país");
            }
            
            //Buscamos
            Fabricante fabricante = dao.buscarFabricantePorCodigo(codigo);
            if (fabricante == null) {
                throw new MiExcepcion("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN FABRICANTE");
            }
            

            fabricante.setNombre(nombre);
            fabricante.setNacionalidad(nacionalidad);
            
            dao.modificarFabricante(fabricante);
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }      
    }
    
    public void eliminarFabricantePorCodigo(Integer codigo) throws MiExcepcion {
        try {
            // VALIDACIÓN
            if (codigo == null) {
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }
            //Buscamos
            Fabricante fabricante = dao.buscarFabricantePorCodigo(codigo);

            if (fabricante == null) {
                throw new MiExcepcion("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN FABRICANTE");
            }
            
            dao.eliminarFabricantePorCodigo(codigo);
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    public void eliminarFabricantePorNombre(String nombre) throws MiExcepcion {
        try {
            // VALIDACIÓN
             if (nombre == null || nombre.trim().isEmpty()) {
                throw new MiExcepcion("DEBE INGRESAR UN NOMBRE");
            }
             
            //Buscamos
            Fabricante fabricante = dao.buscarFabricantePorNombre(nombre);
            
            if (fabricante == null) {
                throw new MiExcepcion("EL NOMBRE INGRESADO NO ESTÁ ASOCIADO A NINGÚN FABRICANTE");
            }
           
            dao.eliminarFabricanteporNombre(nombre);
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    public void mostrarFabricantes() throws MiExcepcion{
        
        try {
            List<Fabricante> fabricantes = dao.obtenerFabricantes();
            
            if (fabricantes.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN FABRICANTES");
            }else{
                System.out.println("*** LISTA DE FABRICANTES ***");
                System.out.printf("%-15s%-20s%-15s\n","CODIGO", "NOMBRE", "NACIONALIDAD"); //FORMATO DE IMPRESIÓN 
                for (Fabricante fabricante : fabricantes) {
                    System.out.println(fabricante);   
                }
                System.out.println();
                
            }
        } catch (MiExcepcion e) {
            throw e;
        } catch (Exception e) {
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    public void buscaPorNombre(String nomb) throws MiExcepcion{
        try {
            List<Fabricante> fabricantes = dao.buscarFabricanteporNom(nomb);
            
            if (fabricantes.isEmpty()){
                throw new MiExcepcion("NO EXISTEN FABRICANTES");
            }else{
                System.out.println("\n*** LISTA DE FABRICANTES ***");
                System.out.printf("%-6s%-6s%-12s\n", "CODIGO", "NOMBRE", "NACIONALIDAD"); // FORMATO DE IMPRESIÓN, + INFO sobre System.out.printf(""); https://xperti.io/blogs/formatting-with-printf-in-java/
                
                fabricantes.forEach(aux -> {System.out.println(aux);});
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
}
