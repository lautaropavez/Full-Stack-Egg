package Mascota;

import Enum.SexoHumano;
import java.util.Date;
import java.util.List;

public class Usuario {

    private String nombre;
    private String apellido;
    private Integer dni;
    private String pais;
    private int edad; //es común ponerlo en string ya que no hacemos cuentas de ingun tipo con el dni
    private Date nacimiento;  //clase date es para poner fechas  
    private SexoHumano sexo;
    
//  private Mascota mascota; //De esta manera estamos vinculando que el usuario tiene una relación hacia una mascota, el usuario se vincula a la mascota
    private List<Mascota> Mascota; // De esta manera un usuario se vincula a muchas mascotas.
    
    private Mascota mascotaFavorita;
    
    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String pais, int edad, Date nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.edad = edad;
        this.nacimiento = nacimiento;
    }
//------------------------------------------------------------------------------ Realizado por mi solo de aca en adelante

    public void setMascota(List<Mascota> Mascota) {
        this.Mascota = Mascota;
    }

    public void setMascotaFavorita(Mascota mascotaFavorita) {
        this.mascotaFavorita = mascotaFavorita;
    }
    
    public void setSexo(SexoHumano sexo) {
        this.sexo = sexo;
    }
        
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public SexoHumano getSexo() {
        return sexo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPais() {
        return pais;
    }

    public Integer getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public List<Mascota> getMascota() {
        return Mascota;
    }

    public Mascota getMascotaFavorita() {
        return mascotaFavorita;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", pais=" + pais + ", edad=" + edad + ", nacimiento=" + nacimiento + ", sexo=" + sexo + ",\n Mascota=" + Mascota + ",\n mascotaFavorita=" + mascotaFavorita + '}';
    }
    
    
}
