package jdbc;

public class JDBC {

    public static void main(String[] args) {
       
        /* Debemos tener creada la base de datos porque sino es muy dificil que Java la cree automaticamente. En JDBC vamos a tener que diagramar las tablas que nosotros vamos a necesitar*/
        /*Clase 19 Turno Tarde*/
        /*
        * Con JDBC vamos a utilizar un patrón de arquitectura DAO(Data Acces Object)
        * Un patrón de diseño es una forma estandarizada de organizar nuestro codigo para resolver un determinado problema
        * DAO va a ser la encargada de interactuar con nuestra base de datos, establecer la conexión ejecutar sentencias, modificar y eliminar determinadas cosas
        * Clase Entidad: Sin modificaciones. Creo el molde de mis futuros objetos.
        * Clase Servicio: Realizo la lógica actual para A-B-M. Recordar crear una instancia de mi clase DAO 
        * Clase DAO para cada entidad: Realizo la lógica necesaria para los CRUD (create-read-update). Acá se encuentran mis consultas sql nativas
        * Clase DAO superclase: Dejo mis funciones encargadas de conectarse, desconectarse, insertarModificarEliminar, funciones
        * -- Importante --
        * Yendo a Services-->jdbc:mysql://localhost...-->perros(database que yo quiero)-->Tables-->La tabla que yo elegí-->Click derecho execute command-->Se nos abre una hoja para escribir sentencias SQL 
        * Info importante: min 1:04
        */
        /*20 Clase de repaso Turno Tarde*/
        /*
         * Hace un INNER JOIN en clase TIENDA min 19-22
         * Min 53:10 en el ejercicio de estancias para las fechas tenemos que importar el date del paquete java.util
        */
        /*21 Clase Consulta JDBC Tarde*/
        // Vemos en el minuto 10 como desactivar modo seguro de MYSQL
        /*22 Clase Consulta Turno Tarde*/
         /*
         * El método String.format es un método estático,(ya lo se usar) pero en el min 16 vemos como simplificar el uso de las queryspara el llamado a mysql, esta bueno si neceitamos tambien pasar un double a entero (int) en java
         * Min 21:Manipulacion de fechas para ejercicio 1 extra Haciendas: utilizamos el date de java.utl(min 22)
         * Min 30: UUID.randomUUID 
        */

    }

}
