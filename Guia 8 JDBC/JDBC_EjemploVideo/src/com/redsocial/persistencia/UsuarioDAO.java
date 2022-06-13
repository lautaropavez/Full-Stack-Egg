package com.redsocial.persistencia;

import com.redsocial.dominio.usuario.Usuario;
import java.util.ArrayList;
import java.util.Collection;

public final class UsuarioDAO extends DAO {

    public void guardarUsuario(Usuario usuario) throws Exception {
        try {
            if (usuario == null) {
                throw new Exception("Debe indicar el usuario");
            }
            
            String sql = "INSERT INTO Usuario (correoElectronico, clave)" // Acá le digo inserta en la tabla usuario los siguientes atributos correo y clave y los plasmo en una QUERY
                    + "VALUES ( '" + usuario.getCorreoElectronico() + "' , '" + usuario.getClave() + "' );"; // Cuyos valores son (tener cuidado con las comillas, las simples son para el VARCHAR de my sql y las dobles son porque es un string de java)

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    // Min 7 video4 podemos hacer que se pueda modificar solo el usuario o solo la clave tambien
    public void modificarUsuario(Usuario usuario) throws Exception {
        try {
            if (usuario == null) {
                throw new Exception("Debe indicar el usuario que desea modificar");
            }

            String sql = "UPDATE Usuario SET "
                    + "clave = '" + usuario.getClave() + "' WHERE correoElectronico = '" + usuario.getCorreoElectronico() + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarUsuario(String correEletronico) throws Exception {
        try {

            String sql = "DELETE FROM Usuario WHERE correoElectronico = '" + correEletronico + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    //Esta consulta va a consultar en la tabla usuario todo lo que tenga la condicion semejante a lo que busco, si yo busco por correo electronico es importante que me llegue el correo electronico
    public Usuario buscarUsuarioPorCorreoElectronico(String correoElectronico) throws Exception {
        try {
            
            // 
            String sql = "SELECT * FROM Usuario "
                    + " WHERE correoElectronico = '" + correoElectronico + "'";

            consultarBase(sql);

            Usuario usuario = null; // Lo empiezo como nulo porque en las siguientes lineas me voy a encargar de hacerlo nacer y rellenarlo a este usuario
            
            while (resultado.next()) { // resultado.next() : nos dice si en resultado hay algun valor próximo
                usuario = new Usuario();
                usuario.setId(resultado.getInt(1));
                usuario.setCorreoElectronico(resultado.getString(2));
                usuario.setClave(resultado.getString(3));
            }
            desconectarBase();
            return usuario;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Usuario buscarUsuarioPorId(Integer id) throws Exception {
        try {

            String sql = "SELECT * FROM Usuario "
                    + " WHERE id = '" + id + "'";

            consultarBase(sql);

            Usuario usuario = null;
            while (resultado.next()) {
                usuario = new Usuario();
             // Estos proximos setters me van a setear algo al usuario que yo cree en la linea anterior, le voy a setear los resultados que voy a extraer de cada columna de resultado
                usuario.setId(resultado.getInt(1)); // Poniendo getInt(1) yo digo que voy a sacar un valor numerico del resultado y puedo decir que es la 1° coluumna(en estos casos se empieza desde el 1, no desde cero pq es la columna 1) si no se la posicion ponemos resultado.getInt("id") y buscaia matchear con esa columna
                usuario.setCorreoElectronico(resultado.getString(2)); 
                usuario.setClave(resultado.getString(3));
            }
            desconectarBase();
            return usuario;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    // Asi hago cuando son múltiples filas
    public Collection<Usuario> listarUsuarios() throws Exception {
        try {
            String sql = "SELECT correoElectronico, clave FROM Usuario ";

            consultarBase(sql);

            Usuario usuario = null;
            Collection<Usuario> usuarios = new ArrayList(); // Genero una coleccion que es un conjunto de Objetos que nace como un ArrayList()
            //En la linea debajo lo que hago es tomar la 1° fila de ese resultado y la proceso, hago nacer el usuario seteo el id, correo y clave y ese usuario lo añado a la lista de usuarios
            while (resultado.next()) {
                usuario = new Usuario();
                usuario.setCorreoElectronico(resultado.getString(1)); //Pongo .getString porque en 1° posición de mi columna de datos solo está correo electronico y despues clave. En el otro caso teniamos el 1° posicion al ID pero lo obvie en la consulta
                usuario.setClave(resultado.getString(2));
                usuarios.add(usuario);
            }
            desconectarBase();
            return usuarios;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}
