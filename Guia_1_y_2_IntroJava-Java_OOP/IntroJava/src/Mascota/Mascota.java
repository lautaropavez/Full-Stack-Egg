package Mascota;

import Enum.SexoAnimal;
import java.util.Objects;

public class Mascota <T> implements Comparable<Mascota>{ // Nosotros al poner implements Comparable<Mascota> estamos haciendo que nuestra clase mascota sea capaz de compararse con otra mascota. Muy similar al comparator pero no me da tanta libertad.

    private String nombre;
    private String apodo;
    private String tipo;     //Conejo, gato, perro, loro, carpincho
    private String color;
    private T raza; //Le ponemos t
    private SexoAnimal sexo;
    private Integer edad;
    private boolean cola;
    private int energia;

    public Mascota() {
        energia = 1000;
    }

    public Mascota(String nombre, String apodo, String tipo) {
        this.nombre = nombre; //esto son asignaciones a distintos objetos segun pelado video 4;
        this.apodo = apodo;

        if (tipo.equalsIgnoreCase("Perro") || tipo.equalsIgnoreCase("Gato") || tipo.equalsIgnoreCase("Loro") || tipo.equalsIgnoreCase("Carpincho")) {
            this.tipo = tipo;
        }

        this.energia = 1000;
    }

    //Podemos construir la cantidad de constructores que deseemos 

    public Mascota(String nombre, String apodo, String tipo, String color, T raza, SexoAnimal sexo, Integer edad, boolean cola, int energia) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.tipo = tipo;
        this.color = color;
        this.raza = raza;
        this.sexo = sexo;
        this.edad = edad;
        this.cola = cola;
        this.energia = energia;
    }
    

    //--------------------------------------------------------------------------
    
    public void setNombre(String nombre) {
        if (nombre.length() > 0) {            //Aca vemos que los setters pueden tener lógica adentro
            this.nombre = nombre;
        }
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRaza(T raza) {
        this.raza = raza;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setSexo(SexoAnimal sexo) {
        this.sexo = sexo;
    }
    
    public void setCola(boolean cola) {
        this.cola = cola;
    }

    //--------------------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getColor() {
        return color;
    }

    public T getRaza() {
        return raza;
    }

    public Integer getEdad() {
        return edad;
    }
    
     public SexoAnimal getSexo() {
        return sexo;
    }
     
    public boolean isCola() {
        return cola;
    }

    public int pasear(int energiaRestar) {

        energia = energia - energiaRestar;
//      energia -= energiaRestar; //Es otra manera de hacerlo;

        return energia;
    }
    
    //Apretamos Alt+Insert ---> " equals and Hascode "
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nombre);
        hash = 83 * hash + Objects.hashCode(this.apodo);
        hash = 83 * hash + Objects.hashCode(this.tipo);
        hash = 83 * hash + Objects.hashCode(this.color);
        hash = 83 * hash + Objects.hashCode(this.raza);
        hash = 83 * hash + Objects.hashCode(this.edad);
        hash = 83 * hash + (this.cola ? 1 : 0);
        hash = 83 * hash + this.energia;
        return hash;
    }

    // equals va a enseñar para que se compare un objeto con otro objeto, una mascota contra otra mascota, bastante similar al comparator solo que acá lo hago en la clase, la clase ya e sae comparar contra otra clase similar
    // El equals devuelve un valor booleano dependiendo la comparación.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mascota other = (Mascota) obj;
        if (this.cola != other.cola) {
            return false;
        }
        if (this.energia != other.energia) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apodo, other.apodo)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.raza, other.raza)) {
            return false;
        }
        if (!Objects.equals(this.edad, other.edad)) {
            return false;
        }
        return true;
    }
    
    
    
    
    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", apodo=" + apodo + ", tipo=" + tipo + ", color=" + color + ", raza=" + raza + ", edad=" + edad + ", cola=" + cola + ", energia=" + energia + '}';
    }

    @Override
    public int compareTo(Mascota t) { // Es un compareTo para la clase Mascota, java no sabe que es una mascota
       return t.getNombre().compareTo(this.nombre); //This.nombre es que hago referencia de que estoy parado en esta clase como el objeto 1 y me llega desde afuera, un mascota t, que es uno que se quiere comparar contra mí
                                                    // Entonces tenemos que agarrar el nombre en el que estoy parado contra el objet que me llego afuera. Con esto ya tenemos establecido mi criterio de orden.
    }

}
