package com.redsocial.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "perros";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    //Métodos que padre DAO le va a dar a sus hijos
    protected void conectarBase() throws Exception {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";  //Esta es la URL que nos conecta a la base de datos, min 9 video 2 nos dice como verla
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD); // A través de DriverManager que es una funcionalidad
            // Posible error en conexion o en alguna otra seria que importemos desde com.mysql siendo que las debemos importar a todas desde java.sql
        } catch (ClassNotFoundException | SQLException ex) { // Ponemos esta excepcion porque es mucho mas detallista en lo que pasa. Este catch atrapa 2 potenciales problemas
            throw ex;
        }
    }

    protected void desconectarBase() throws Exception {
        try {
            // Si resultado es distinto a null significa que la variable ResultSet  esta albergando algun resultado de consultas. Recordemos que este método es desconectar base por lo que 
            // queremos "matar" todas las consultas. Porque yo siempre en la base de datos tengo que consultar todo lo que necesito y una vez que termino de sacarlo de la base de datos y 
            // plasmarlo en Java, tengo que cortar la base de datos, no puedo dejarla abierta ya que si por ej tenemos un pull de conection de 10 conexiones a la base de datos pq mi servidor
            // asi lo dicta, no puedo dejar 1 conexion en espera y ocupar 10 conexiones, si quiere entrar una 11°ava conexión, no va a poder porque hay 10 en espera sin hacer nada, entonces 
            // yo busco lo que necesito y lo cierro.
            if (resultado != null) { 
                resultado.close(); //asi lo cerramos
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    // Este metodo no va a devolver nada, es un método que impacta a la base de datos. En esta variable (String sql) voy a recibir la consulta a ejecutar que insertaria,modif o eliminaria algo 
    // en la base de datos. Llamo a conectarBase() pq cada vez que hago una consulta, me conecto hago lo que necesito y me desconecto
    // En la variable sentencia yo voy a volcar una potencial creacion de una sentencia. Uso la variable conexion, digo que voy a estar preparandome para crear una sentencia que usa las querys 
    // que ejecutamos anteriormente en mysql y en la linea de abajo finalmente dentro de sentencia que ya se preparo para la creacion de una sentencia ejecute una QUERY(la que nos llega como 
    // parametro). Esto podria darme un error del tipo SQLExcepcion. Conectar base nos puede tirar errores de 2 tipos: SQLExcepcion y ClassNotFoundExcepcion
    // 
    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            // conexion.rollback();  // rollback nos sirve por ejemplo si yo meto 1 millón de cosas en la base de datos, voy por la linea u objeto 500.000 y algo pasa, el rollback me permite irme para atrás y que no se hayan ejecutado esas 500 inserciones 
            /*
                Descomentar la linea anterior si desean tener en cuenta el rollback.
                Correr el siguiente script en Workbench
            
                SET autocommit=1;
                COMMIT;
            
                **Sin rollback igual anda
             */
            throw ex;
        } finally {
            desconectarBase(); //Lo ponemos en el finally asi siempre se desconecta de la base de datos
        }
    }
    
    // Cuando yo consulto una base de datos no tengo que insertar ni modificar nada, solo ir leer e irme y necesito traerme lo que lei
    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql); // Aca albergo el producto de la consulta
        } catch (Exception ex) {
            throw ex;
        }
    }
}
