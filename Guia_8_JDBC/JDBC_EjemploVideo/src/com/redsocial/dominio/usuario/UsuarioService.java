package com.redsocial.dominio.usuario;

import com.redsocial.persistencia.UsuarioDAO;
import java.util.Collection;

public class UsuarioService {

    private UsuarioDAO dao;

    public UsuarioService() {
        this.dao = new UsuarioDAO();
    }

    public void crearUsuario(String correoElectronico, String clave) throws Exception {

        try {
            //Validamos
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }
            if (correoElectronico.contains("@") == false) {
                throw new Exception("El correo electrónico es incorrecto");
            }
            if (clave == null || clave.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave");
            }
            if (clave.length() < 8) {
                throw new Exception("La clave no puede tener menos de 8 caracteres");
            }
            //Acá (línea de abajo) hago una validación para evitar que se me repita mi correo electrónico, esto se podria obviar si ponemos en la tabla cuando lo creamos que el correo electrónico es unique(no se repite)
            if (buscarUsuarioPorCorreoElectronico(correoElectronico) != null) { // Acá digo: Si al buscar usuario por correoelectronico es distinto a null, es decir yo uso el correo que estoy usando para registrarme lo busco en la base de datos, si encuentro algo yo digo que ya existe en la linea de abajo
                throw new Exception("Ya existe un usuario con el correo electrónico indicado " + correoElectronico);
            }

            //Creamos el usuario
            Usuario usuario = new Usuario();
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setClave(clave);
            dao.guardarUsuario(usuario); // El usuario que cree lo paso acá
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarClaveUsuario(String correoElectronico, String claveActual, String nuevaClave) throws Exception {

        try {

            //Validamos
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el usuario");
            }

            if (claveActual == null || claveActual.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave actual");
            }

            if (nuevaClave == null || nuevaClave.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave nueva");
            }

            //Buscamos
            Usuario usuario = buscarUsuarioPorCorreoElectronico(correoElectronico);

            //Validamos
            if (!usuario.getClave().equals(claveActual)) {
                throw new Exception("La clave actual no es la registrada en el sistema para el correo electrónico indicado");
            }

            //Modificamos
            usuario.setClave(nuevaClave);

            dao.modificarUsuario(usuario);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarUsuario(String correoElectronico) throws Exception {

        try {

            //Validamos 
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }

            dao.eliminarUsuario(correoElectronico);
        } catch (Exception e) {
            throw e;
        }
    }

    public Usuario buscarUsuarioPorCorreoElectronico(String correoElectronico) throws Exception {

        try {

            //Validamos
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }

            Usuario usuario = dao.buscarUsuarioPorCorreoElectronico(correoElectronico);

            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

    public Usuario buscarUsuarioPorId(Integer id) throws Exception {

        try {

            //Validamos
            if (id == null) {
                throw new Exception("Debe indicar el id");
            }

            Usuario usuario = dao.buscarUsuarioPorId(id);

            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Usuario> listarUsuario() throws Exception {

        try {

            Collection<Usuario> usuarios = dao.listarUsuarios();

            return usuarios;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirUsuarios() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Usuario> usuarios = listarUsuario();

            //Imprimimos los usuarios
            if (usuarios.isEmpty()) {
                throw new Exception("No existen usuarios para imprimir");
            } else {
                for (Usuario u : usuarios) {
                    System.out.println(u);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
