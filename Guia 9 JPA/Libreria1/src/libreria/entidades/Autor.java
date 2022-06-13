package libreria.entidades;

import com.sun.istack.internal.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Lautaro Pavez
 */

@Entity // Esta anotacion, avisa que esta clase se convertira en TABLA
public class Autor {
    
    @Id
    @GeneratedValue
    private String id;
    
    @NotNull
    private String nombre;
    
    private boolean alta;

    public Autor() {
    }

    public Autor(String id, String nombre, boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-30s", nombre, id);
        //return "Autor{" + "id=" + id + ", nombre=" + nombre + ", alta=" + alta + '}';
    }
    
    
}
