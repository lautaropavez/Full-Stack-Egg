package persistencia;

import excepcion.MiExcepcion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Lautaro Pavez
 */
public abstract class DAO {
    
    protected Connection conexion = null;
    protected Statement sentencia = null;
    protected ResultSet resultado = null;
    
    private final String USER ="root";
    private final String PASSWORD = "root";
//  private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/tienda?useSSL=false";
            
    protected void conectarBase() throws MiExcepcion{
        try {
            Class.forName(DRIVER);
            //String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion  = DriverManager.getConnection(URL,USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new MiExcepcion("ERROR AL CONECTARSE");
        }
    }
    
    protected void desconectarBase() throws MiExcepcion{
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
            throw new MiExcepcion("ERROR AL DESCONECTARSE");
        }
    }
    
    protected void insertarModificarEliminar(String sql) throws MiExcepcion{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.execute(sql);
        } catch (SQLException e){
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                throw new MiExcepcion("ERROR AL REALIZAR ROLLBACK");
            }
            throw new MiExcepcion("ERROR AL EJECUTAR SENTENCIA");
        }finally{
            desconectarBase();
        }
    }
    
    protected void consultarBase(String sql) throws MiExcepcion{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        }catch(SQLException e){
            throw new MiExcepcion("ERROR AL CONSULTAR");
        }
    }
}
