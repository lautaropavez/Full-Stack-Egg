package com.mza.Libreria.servicios;

import com.mza.Libreria.entidades.Libro;
import com.mza.Libreria.entidades.Prestamo;
import com.mza.Libreria.entidades.Usuario;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.repositorios.PrestamoRepository;
import com.mza.Libreria.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lautaro Pavez
 */
@Service
public class ServicePrestamo {

    @Autowired
    ServiceLibro servLibro;

    @Autowired
    ServiceUsuario servUsuario;

    @Autowired
    PrestamoRepository repoPrestamo;

    @Autowired
    UsuarioRepository repoUsuario;

    @Transactional
    public Prestamo creaPrestamo(String idLibro, String idUsuario) throws MiExcepcion {

        Libro libroPrestado = new Libro();
        Usuario usuario = new Usuario();
        try {
            libroPrestado = servLibro.buscarPorId(idLibro);
            usuario = servUsuario.buscarPorId(idUsuario);
        } catch (Exception e) {
            throw new MiExcepcion("No se pudo crear el prestamo: " + e.getMessage());
        }

        //Verifico que existan ejemplares disponibles para realizar el prestamo
        if (libroPrestado.getEjemplaresRestantes() > 0 && libroPrestado.getAlta()) {
            libroPrestado.setEjemplaresRestantes(libroPrestado.getEjemplaresRestantes() - 1);
            libroPrestado.setEjemplaresPrestados(libroPrestado.getEjemplaresPrestados() + 1);
        } else {
            throw new MiExcepcion("No se puede prestar el Libro, no quedan ejemplares disponibles");
        }
        //creo un nuevo prestamo y le seteo atributos
        Prestamo prestamo = new Prestamo();
        prestamo.setAlta(Boolean.TRUE);
        prestamo.setPrestamo(new Date());
        prestamo.setDevolucion(sumarRestarDiasFecha(prestamo.getPrestamo(),21));
        //Le seteo el Libro al Prestamo
        prestamo.setLibro(libroPrestado);
        //El usuario al prestamo
        prestamo.setUsuario(usuario);
        usuario.setCantidadPrestamos(usuario.getCantidadPrestamos() + 1);
        repoPrestamo.save(prestamo);
        repoUsuario.save(prestamo.getUsuario());

        return prestamo;
    }

    @Transactional
    public void confirmaPrestamo(Prestamo prestamo) throws MiExcepcion {
        try {
            repoPrestamo.save(prestamo);
            repoUsuario.save(prestamo.getUsuario());
        } catch (Exception e) {
            throw new MiExcepcion("No se pudo confirmar el prestamo: " + e.getMessage());
        }
    }

    
    @Transactional(readOnly = true)
    public List<Prestamo> listaPrestamos() throws MiExcepcion {
        return repoPrestamo.findAll();
    }
    
    // Suma los días recibidos a la fecha  
    private Date sumarRestarDiasFecha(Date fecha, int dias) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(fecha); // Configuramos la fecha que se recibe

        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    }
    
    @Transactional(readOnly = true)
    public Prestamo buscarPorId(String id) {
        Optional<Prestamo> p = repoPrestamo.findById(id);
        if (p.isPresent()) {
            Prestamo prestamo = p.get();
            return prestamo;
        } else {
            return null; //throw new MiExcepcion("Este libro no existe."); esto debo ponerlo en el controlador
        }
    }
    
    @Transactional(readOnly = true)
    public List<Prestamo> buscarPorUsuario(String id) {
        return repoPrestamo.listarPorUsuario(id);
    }
    
    @Transactional 
    public Prestamo baja(String id) throws MiExcepcion {
        Prestamo prestamo = buscarPorId(id);
        prestamo.setAlta(false);
        prestamo.getLibro().setEjemplaresRestantes(prestamo.getLibro().getEjemplaresRestantes() + 1);
        prestamo.getLibro().setEjemplaresPrestados(prestamo.getLibro().getEjemplaresPrestados() - 1);
        return repoPrestamo.save(prestamo);
    }
    
    @Transactional 
    public Prestamo alta(String id) throws MiExcepcion{
        Prestamo prestamo = buscarPorId(id);
        prestamo.setAlta(true);
        if (prestamo.getLibro().getEjemplaresRestantes() > 0 && prestamo.getLibro().getAlta()) {
            prestamo.getLibro().setEjemplaresRestantes(prestamo.getLibro().getEjemplaresRestantes() - 1);
            prestamo.getLibro().setEjemplaresPrestados(prestamo.getLibro().getEjemplaresPrestados() + 1);
        } else {
            throw new MiExcepcion("No se puede prestar el Libro, no quedan ejemplares disponibles");
        }
        return repoPrestamo.save(prestamo);
    }
}

