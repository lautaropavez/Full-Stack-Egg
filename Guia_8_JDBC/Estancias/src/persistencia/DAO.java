package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import service.MiExcepcion;

/**
 *
 * @author Lautaro Pavez
 */
public class DAO {

    protected Connection conexion = null;
    protected Statement sentencia = null;
    protected ResultSet resultado = null;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/estancias?useSSL=false";
    
    protected void conectarBase() throws MiExcepcion{
        try {
          // CARGA EL CONTROLADOR
          Class.forName(DRIVER);
          conexion = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new MiExcepcion("ERROR AL CONECTARSE");  
        }   
    }
    
    protected void desconectarBase()throws MiExcepcion{
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
    
    protected void insertarModificarEliminar(String sql) throws MiExcepcion{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            try {
               conexion.rollback(); // Si se produce un error en nuestra base de datos, volvemos hacia atras esa transaccion para que no modifique nuestra base de datos 
            } catch (SQLException ex) { //el rollback tambien puede tirar una excepcion por lo que hago otro try and catch
                // ex.printStackTrace();
                throw new MiExcepcion("ERROR AL REALIZAR ROLLBACK");
            }
            // e.printStackTrace();
            throw new MiExcepcion("ERROR AL EJECUTAR SENTENCIA");
        }
    }
    
    protected void consultarBase(String sql) throws MiExcepcion{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR AL CONSULTAR");
        }
    }
}
