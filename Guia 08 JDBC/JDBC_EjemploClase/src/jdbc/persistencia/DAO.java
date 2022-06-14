package jdbc.persistencia;

import java.sql.*;
import jdbc.excepcion.MiExcepcion;

public class DAO {

    // ADMINISTRA NUESTRA CONEXIÓN
    protected Connection conexion = null;
    // INSTRUCCIÓN DE CONSULTA
    protected Statement sentencia = null;
    // MANIPULA LOS RESULTADOS
    protected ResultSet resultado = null;

    private final String USUARIO = "root";
    private final String CLAVE = "root";
    // USTEDES DEBEN COLOCAR ESTA CADENA EN EL CONTROLADOR: "com.mysql.jdbc.Driver"
    private final String CONTROLADOR = "com.mysql.jdbc.Driver"; //El profe usa esta cadena de controlador para el driver porque es otra versión mas nueva(según el)
    // UBICACIÓN DE LA BASE DE DATOS
    private final String URL = "jdbc:mysql://localhost:3306/egg?useSSL=false"; // Lo que establezco en la url: jdbc(el protocolo de comunicación),mysql(subprotocolo de comunicacion,el gestor de base
                                                                               // de datos, puede ser otro), localhost(host donde corre mysql que es nuestra propia compu
                                                                               // por lo que es local),":3306"(puerto donde corre mysql),"/NombreDeMiBaseDeDatos"(debo 
                                                                               // tenerla creada con anterioridad), "?useSSL=false"(acá basicamente le decimos que no agregue
                                                                               // seguridad porque estabmos trabajando desde nuestra maquina).
    
    protected void conectarBase() throws MiExcepcion {
        try {
            // CARGA EL CONTROLADOR
            Class.forName(CONTROLADOR);
            // ESTABLECE LA CONEXIÓN
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE); //Con estos 3 datos yo puedo acceder a MySQL Workbench desde Java
        } catch (ClassNotFoundException | SQLException e) { //Si no encuentra el driver(si está mal el CONTROLADOR por ej) va a largar la excepción ClassNotFoundException que significa que no encuentra 
                                                            // las clases para cargar ese driver. Y si no puede hacer una conexión exitosa a MySQL me la a largar una SQLException
            // e.printStackTrace();
            throw new MiExcepcion("ERROR AL CONECTARSE");
        }
    }

    protected void desconectarBase() throws MiExcepcion {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR AL DESCONECTARSE");
        }
    }

    protected void insertarModificarEliminar(String sql) throws MiExcepcion {
        try {
            conectarBase();
            sentencia = conexion.createStatement(); // lo que hago acá es habilitar a mi atributo sentencia, que sentencia va a ser el encargado de ejecutar mis sentencias sql
            sentencia.executeUpdate(sql); // Lo que hago es ejecutar mi sentencia, le paso como parametro una cadena
        } catch (SQLException e) {
            try {
                conexion.rollback(); // Si se produce un error en nuestra base de datos, volvemos hacia atras esa transaccion para que no modifique nuestra base de datos 
            } catch (SQLException ex) { //el rollback tambien puede tirar una excepcion por lo que hago otro try and catch
                // ex.printStackTrace();
                throw new MiExcepcion("ERROR AL REALIZAR ROLLBACK");
            }
            // e.printStackTrace();
            throw new MiExcepcion("ERROR AL EJECUTAR SENTENCIA");
        } finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String sql) throws MiExcepcion {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql); // En el método anterior llamamos al metodo executeUpdate, mientras que acá llamamos al método execute query, una vez que 
                                                     // ejecutemos esa sentencia la información que recuperemos la vamos a alojar en resultado. A traves de este atributo nosotros vamos a poder sacar la información
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR AL CONSULTAR");
        }
    }
}
