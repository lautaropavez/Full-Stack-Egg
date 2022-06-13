package entidad;
/**
 *
 * @author Lautaro Pavez
 */
public class Fabricante {
    private int codigo;
    private String nombre;
    private String nacionalidad;

    public Fabricante() {
    }

    public Fabricante(int codigo, String nombre, String nacionalidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-20s%-15s", codigo, nombre, nacionalidad); //Debemos poner los mismos numeros aca que en servicio fabricante en la linea 149
    }
    
}
