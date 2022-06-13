package entidades;

/**
 *
 * @author Lautaro Pavez
 */
public class Familia {

    private Integer id;
    private String nombre;
    private Integer edad_minima;
    private Integer edad_maxima;
    private Integer num_hijos;
    private String email;
    private Casa casa;
    private Integer id_casa_familia;


    public Familia() {
        this.casa = new Casa();
        this.id_casa_familia = casa.getId_casa(); 
    }

    public Familia(Integer id, String nombre, Integer edad_minima, Integer edad_maxima, Integer num_hijos, String email, Integer id_casa_familia, Casa casa) {
        this.id = id;
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.edad_maxima = edad_maxima;
        this.num_hijos = num_hijos;
        this.email = email;
        this.id_casa_familia = id_casa_familia;
        this.casa = casa;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(Integer edad_minima) {
        this.edad_minima = edad_minima;
    }

    public Integer getEdad_maxima() {
        return edad_maxima;
    }

    public void setEdad_maxima(Integer edad_maxima) {
        this.edad_maxima = edad_maxima;
    }

    public Integer getNum_hijos() {
        return num_hijos;
    }

    public void setNum_hijos(Integer num_hijos) {
        this.num_hijos = num_hijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }
   
    public Integer getId_casa_familia() {
        return id_casa_familia;
    }

    public void setId_casa_familia(Integer id_casa_familia) {
        this.id_casa_familia = id_casa_familia;
    }

    
    @Override
    public String toString() {
        return String.format("%-10s%-20s%-10s%-10s%-10s%-25s%-10s\n", id, nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia);
        //return "Familias{" + "id=" + id + ", nombre=" + nombre + ", edad_minima=" + edad_minima + ", edad_maxima=" + edad_maxima + ", num_hijos=" + num_hijos + ", email=" + email + '}';
    }
    
    
}
