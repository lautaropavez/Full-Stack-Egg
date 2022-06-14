package service;

import entidades.Casa;
import java.util.Date;
import java.util.List;
import persistencia.CasaDAO;

/**
 *
 * @author Lautaro Pavez
 */

public class ServiceCasa {
    
    private CasaDAO cdao;
    Date fecha_existencia = new Date(2000, 00, 01); // Es para establecer un limite desde cuando se pueden fijar fechas, esta fecha es el 1 de enero del 2000
    
    public ServiceCasa() {
        this.cdao = new CasaDAO();
    }
    
    // CREAR     
    public void crearCasa(Integer id, String calle, Integer num, String codigo_postal, String ciudad, String pais, Date fecha_desde, Date fecha_hasta, Integer tiempo_min, Integer tiempo_max, Double precio_habitacion,String tipo_vivienda) throws MiExcepcion {
        try {
            //VALIDACIÓN
            if (id == null || id < 0) {
                throw new MiExcepcion("Debe ingresar un id");
            }
            if (calle == null || calle.trim().isEmpty()) {
                throw new MiExcepcion("Debe ingresar una calle");
            }
            if (num == null || num < 0) {
                throw new MiExcepcion("Debe ingresar un numero");
            }
            if (codigo_postal == null || codigo_postal.trim().isEmpty()) {
                throw new MiExcepcion("Debe ingresar un condigo postal");
            }
            if (ciudad == null || ciudad.trim().isEmpty()) {
                throw new MiExcepcion("Debe ingresar una ciudad");
            }
            if (pais == null || pais.trim().isEmpty()) {
                throw new MiExcepcion("Debe ingresar un pais");
            }
            if (fecha_desde == null || fecha_desde.after(fecha_hasta) || !fecha_desde.after(fecha_existencia)) {
                throw new MiExcepcion("Debe ingresar una fecha correcta");
            }
            if (fecha_hasta == null || !fecha_hasta.after(fecha_desde) || !fecha_hasta.after(fecha_existencia)) {
                throw new MiExcepcion("Debe ingresar una fecha correcta");
            }
            if (tiempo_min == null || num < 0) {
                throw new MiExcepcion("Debe ingresar un numero");
            }
            if (tiempo_max == null || num < 0) {
                throw new MiExcepcion("Debe ingresar un numero");
            }
            if (precio_habitacion == null || precio_habitacion < 0) {
                throw new MiExcepcion("Debe ingresar un precio");
            }
            if (tipo_vivienda == null ||  tipo_vivienda.trim().isEmpty() || !tipo_vivienda.equals("casa") || !tipo_vivienda.equals("duplex") || !tipo_vivienda.equals("piso") || !tipo_vivienda.equals("chalet")) {
                throw new MiExcepcion("Debe ingresar un tipo");
            }
            
            if (cdao.verificaCasaPorId(id))
            {
                throw new MiExcepcion("YA EXISTE UNA CASA CON ESTE ID");
            }
            Casa c = new Casa();
            
            c.setId_casa(id);
            c.setCalle(calle);
            c.setNumero(num);
            c.setCodigo_postal(codigo_postal);
            c.setCiudad(ciudad);
            c.setPais(pais);
            c.setFecha_desde(fecha_desde);
            c.setFecha_hasta(fecha_hasta);
            c.setTiempo_min(tiempo_min);
            c.setTiempo_max(tiempo_max);
            c.setPrecio_habitacion(precio_habitacion);
            c.setTipo_vivienda(tipo_vivienda);
            
            cdao.guardarCasa(c);

        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DEL SISTEMA");
        }
    }
    
    //MODIFICAR
    public void modificarCasa(Integer id, String calle, Integer num, String codigo_postal, String ciudad, String pais, Date fecha_desde, Date fecha_hasta, Integer tiempo_min, Integer tiempo_max, Double precio_habitacion,String tipo_vivienda) throws MiExcepcion {
        try {
            //VALIDACIÓN 
            if (calle == null || calle.trim().isEmpty()) {
                throw new MiExcepcion("Debe ingresar una calle");
            }
            if (num == null || num < 0) {
                throw new MiExcepcion("Debe ingresar un numero");
            }
            if (codigo_postal == null || codigo_postal.trim().isEmpty()) {
                throw new MiExcepcion("Debe ingresar un condigo postal");
            }
            if (ciudad == null || ciudad.trim().isEmpty()) {
                throw new MiExcepcion("Debe ingresar una ciudad");
            }
            if (pais == null || pais.trim().isEmpty()) {
                throw new MiExcepcion("Debe ingresar un pais");
            }
            if (fecha_desde == null || fecha_desde.after(fecha_hasta) || !fecha_desde.after(fecha_existencia)) {
                throw new MiExcepcion("Debe ingresar una fecha correcta");
            }
            if (fecha_hasta == null || !fecha_hasta.after(fecha_desde) || !fecha_hasta.after(fecha_existencia)) {
                throw new MiExcepcion("Debe ingresar una fecha correcta");
            }
            if (tiempo_min == null || num < 0) {
                throw new MiExcepcion("Debe ingresar un numero");
            }
            if (tiempo_max == null || num < 0) {
                throw new MiExcepcion("Debe ingresar un numero");
            }
            if (precio_habitacion == null || precio_habitacion < 0) {
                throw new MiExcepcion("Debe ingresar un precio");
            }
            if (tipo_vivienda == null ||  tipo_vivienda.trim().isEmpty() || !tipo_vivienda.equals("casa") || !tipo_vivienda.equals("duplex") || !tipo_vivienda.equals("piso") || !tipo_vivienda.equals("chalet")) {
                throw new MiExcepcion("Debe ingresar un tipo");
            } 

            Casa c = cdao.buscarCasaPorId(id);

            if (c == null) {
                throw new MiExcepcion("EL ID INGRESADO NO ESTÁ ASOCIADO A NINGUNA CASA");
            }

            c.setId_casa(id);
            c.setCalle(calle);
            c.setNumero(num);
            c.setCodigo_postal(codigo_postal);
            c.setCiudad(ciudad);
            c.setPais(pais);
            c.setFecha_desde(fecha_desde);
            c.setFecha_hasta(fecha_hasta);
            c.setTiempo_min(tiempo_min);
            c.setTiempo_max(tiempo_max);
            c.setPrecio_habitacion(precio_habitacion);
            c.setTipo_vivienda(tipo_vivienda);
            
            cdao.modificarCasa(c);
            
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    //ELIMINAR
    public void eliminarCasa(Integer id) throws MiExcepcion {
        try {
            // VALIDACIÓN
            if (id == null || id < 0) {
                throw new MiExcepcion("DEBE INGRESAR UN ID");
            }
            //Buscamos
            Casa casa = cdao.buscarCasaPorId(id);

            if (casa == null) {
                throw new MiExcepcion("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGUNA CASA");
            }

            cdao.eliminarCasa(id);
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    //MUESTRA
    public void muestraCasa() throws MiExcepcion { 

        try {
            List<Casa> casas = cdao.listarCasas();

            if (casas.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            } else {
                System.out.println("*** LISTA DE USUARIOS ***");
                System.out.printf("%-5s%-30s%-8s%-8s%-25s%-25s%-25s%-25s%-5s%-5s%-8s%-10s\n", "ID", "CALLE", "NUMERO", "CODIGO_POSTAL", "CIUDAD", "PAIS", "FECHA DESDE", "FECHA HASTA", "TIEMPO MIN", "TIEMPO MAXIMO", "PRECIO HABITACION", "TIPO"); //FORMATO DE IMPRESIÓN 

                casas.forEach(c -> {
                    System.out.println(c);
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
    
    //MUESTRA MAS BARATA
    public void buscarMasBarata() throws MiExcepcion{

        try {
           Casa c = cdao.buscarMasBarata(); 
           
            if (c == null)
            {
                throw new MiExcepcion("NO HAY CASA");
            }
            System.out.println("\n*** CASA MAS ECONOMICA ***");
            System.out.printf("%-5s%-30s%-8s%-8s%-25s%-25s%-25s%-25s%-5s%-5s%-8s%-10s\n", "ID", "CALLE", "NUMERO", "CODIGO_POSTAL", "CIUDAD", "PAIS", "FECHA DESDE", "FECHA HASTA", "TIEMPO MIN", "TIEMPO MAXIMO", "PRECIO HABITACION", "TIPO"); //FORMATO DE IMPRESIÓN 
                    
            System.out.printf("%-15s%-35s%-15s%-25s\n",c.getId_casa(),c.getCalle(),c.getCodigo_postal(), c.getCiudad(), c.getPais(),c.getFecha_desde(),c.getFecha_hasta(),c.getTiempo_min(),c.getTiempo_max(),c.getPrecio_habitacion(),c.getTipo_vivienda()); 
            System.out.println();
        } catch (MiExcepcion e){
            // e.printStackTrace();
            throw e;
        } catch (Exception e){
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
        
    //MUESTRA POR PAIS
    public void buscaPorPais(String pais) throws MiExcepcion {
        try {
            List<Casa> casas = cdao.buscarCasaPorPais(pais);

            if (casas.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN CASAS");
            } else {
                System.out.println("*** LISTA DE USUARIOS ***");
                System.out.printf("%-5s%-30s%-8s%-8s%-25s%-25s%-25s%-25s%-5s%-5s%-8s%-10s\n", "ID", "CALLE", "NUMERO", "CODIGO_POSTAL", "CIUDAD", "PAIS", "FECHA DESDE", "FECHA HASTA", "TIEMPO MIN", "TIEMPO MAXIMO", "PRECIO HABITACION", "TIPO"); //FORMATO DE IMPRESIÓN 
                
                casas.forEach(aux -> {
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
    
    //MUESTRA POR CIUDAD
    public void buscaPorCiudad(String ciudad) throws MiExcepcion {
        try {
            List<Casa> casas = cdao.buscarCasaPorCiudad(ciudad);

            if (casas.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN CASAS");
            } else {
                System.out.println("*** LISTA DE USUARIOS ***");
                System.out.printf("%-5s%-30s%-8s%-8s%-25s%-25s%-25s%-25s%-5s%-5s%-8s%-10s\n", "ID", "CALLE", "NUMERO", "CODIGO_POSTAL", "CIUDAD", "PAIS", "FECHA DESDE", "FECHA HASTA", "TIEMPO MIN", "TIEMPO MAXIMO", "PRECIO HABITACION", "TIPO"); //FORMATO DE IMPRESIÓN 
                
                casas.forEach(aux -> {
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
    
    //MUESTRA POR TIPO CASA
    public void buscaPorTipo(String tipo_vivienda) throws MiExcepcion {
        try {
            List<Casa> casas = cdao.buscarCasaPorTipo(tipo_vivienda);

            if (casas.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN CASAS");
            } else {
                System.out.println("*** LISTA DE USUARIOS ***");
                System.out.printf("%-5s%-30s%-8s%-8s%-25s%-25s%-25s%-25s%-5s%-5s%-8s%-10s\n", "ID", "CALLE", "NUMERO", "CODIGO_POSTAL", "CIUDAD", "PAIS", "FECHA DESDE", "FECHA HASTA", "TIEMPO MIN", "TIEMPO MAXIMO", "PRECIO HABITACION", "TIPO"); //FORMATO DE IMPRESIÓN 
                
                casas.forEach(aux -> {
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
    
    //MUESTRA POR RANGO FECHA- **EN PROCESO**
    public void buscaPorRangoFecha(Date fecha_desde, Date fecha_hasta) throws MiExcepcion {
        try {
            List<Casa> casas = cdao.obtenerRangoFecha(fecha_desde, fecha_hasta);

            if (casas.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN CASAS");
            } else {
                System.out.println("*** LISTA DE USUARIOS ***");
                System.out.printf("%-5s%-30s%-8s%-8s%-25s%-25s%-25s%-25s%-5s%-5s%-8s%-10s\n", "ID", "CALLE", "NUMERO", "CODIGO_POSTAL", "CIUDAD", "PAIS", "FECHA DESDE", "FECHA HASTA", "TIEMPO MIN", "TIEMPO MAXIMO", "PRECIO HABITACION", "TIPO"); //FORMATO DE IMPRESIÓN 
                
                casas.forEach(aux -> {
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
    
    //MUESTRA RANGO PRECIO
    public void muestraRango(double min,double max) throws MiExcepcion{
        try {
            List<Casa> casas = cdao.obtenerRangoPrecios(min, max);
            
            if (casas.isEmpty())
            {
                throw new MiExcepcion("NO EXISTEN CASAS");
            } else{
                  System.out.println("*** LISTA DE CASAS ***");
                System.out.printf("%-5s%-30s%-8s%-8s%-25s%-25s%-25s%-25s%-5s%-5s%-8s%-10s\n", "ID", "CALLE", "NUMERO", "CODIGO_POSTAL", "CIUDAD", "PAIS", "FECHA DESDE", "FECHA HASTA", "TIEMPO MIN", "TIEMPO MAXIMO", "PRECIO HABITACION", "TIPO"); //FORMATO DE IMPRESIÓN 
                
                casas.forEach(c ->{
                    System.out.printf("%-5s%-30s%-8s%-8s%-25s%-25s%-25s%-25s%-5s%-5s%-8s%-10s\n",c.getId_casa(),c.getCalle(),c.getCodigo_postal(), c.getCiudad(), c.getPais(),c.getFecha_desde(),c.getFecha_hasta(),c.getTiempo_min(),c.getTiempo_max(),c.getPrecio_habitacion(),c.getTipo_vivienda()); 
                });
                System.out.println();
                
                //POR SI NO FUNCIONA EL DE ARRIBA
//                casas.forEach(c -> {
//                    System.out.println(c);
//                });
//                System.out.println();          
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
    
//    NO LA VOY A NECESITAR LA DEJO POR LAS DUDAS HASTA QUE CORRA EL EJERCICIO
//    public void listarPorNombre() throws MiExcepcion {
//        try {
//
//            List<Producto> productos = dao.obtenerProductos();
//
//            if (productos.isEmpty()) {
//                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
//            } else {
//                System.out.println("*** LISTA DE PRODUCTOS ***");
//                System.out.printf("%-35s%-10s\n", "NOMBRE","PRECIO"); // FORMATO DE IMPRESIÓN
//                for (Producto aux : productos) {
//                    System.out.printf("%-35s%-10s\n",aux.getNombre(),aux.getPrecio());
//                   
//                }
//                System.out.println();
//            }
//
//        } catch (MiExcepcion e) {
//            // e.printStackTrace();
//            throw e;
//        } catch (Exception e) {
//            // e.printStackTrace();
//            throw new MiExcepcion("ERROR DE SISTEMA");
//        }
//    }
    

}
