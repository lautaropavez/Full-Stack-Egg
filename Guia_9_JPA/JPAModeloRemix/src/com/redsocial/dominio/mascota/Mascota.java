package com.redsocial.dominio.mascota;

import com.redsocial.dominio.usuario.Usuario;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity // Esta anotacion, avisa que esta clase se convertira en TABLA
public class Mascota {
//CADA ATRIBUTO DEFINIDO EN UNA CLASE DEL TIPO ENTIDAD, SE CONVIERTE EN  UNA COLUMNA EN MI TABLA
    @Id // Declaro que el siguiente atributo sera el ID
    @GeneratedValue
    private String id;
    private String apodo;
    private String raza;
    @ManyToOne /* La relacion si fue declarada onetomany en la otra, y quiero trabajarla de forma BI DIRECCIONAL
                La declaro aca manytone*/
    @JoinColumn(name = "duenio_id") // El JoinColumn, hace referencia a como llamar esa columna donde guardo a mi Usuario
    private Usuario duenio;

    public Mascota() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Usuario getDuenio() {
        return duenio;
    }

    public void setDuenio(Usuario duenio) {
        this.duenio = duenio;
    }

    
    @Override
    public String toString() {
        return "Mascota{" + "id=" + id + ", apodo=" + apodo + ", raza=" + raza + '}';
    }

}
