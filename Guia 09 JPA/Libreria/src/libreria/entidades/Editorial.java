package libreria.entidades;

import com.sun.istack.internal.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Lautaro Pavez
 */

@Entity // Esta anotacion, avisa que esta clase se convertira en TABLA
public class Editorial {
    @Id
    @GeneratedValue
    private String id;
    
    @NotNull
    @Column(unique = true)
    private String nombre;
    
    private boolean alta;

    public Editorial() {
    }

    public Editorial(String id, String nombre, boolean alta) {
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
        //return "Editorial{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
}
