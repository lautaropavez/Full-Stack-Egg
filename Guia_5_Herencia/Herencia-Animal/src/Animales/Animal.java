package Animales;

public class Animal {
    protected String nombre;
    protected String alimento;    
    protected Integer edad;
    protected String raza;

    public Animal(String nombre, String alimento, Integer edad, String raza) {
        this.nombre = nombre;
        this.alimento = alimento;
        this.edad = edad;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void alimentarse(){
        
        if ((this.alimento).equals("Carnivoro")){
            System.out.println(this.nombre + " se alimenta de carne." );
        }else{
            System.out.println(this.nombre + " se alimenta de " + this.alimento);
        }
    }
    
    
//    public void Alimentarse(String alimento){
//        switch (alimento) {
//            case alimento.equals("Croquetas"):
//                System.out.println("El perro "+ getNombre() + " se alimenta de croquetas." );
//            case "Carnivoro":
//                System.out.println("El perro "+ getNombre() + " se alimenta de carne." );
//            case "Galletas":
//                System.out.println("El gato "+ getNombre() + " se alimenta de galletas.");
//            
//            case "Pasto":
//                System.out.println("El caballo "+ getNombre() + " se alimenta de pasto.");
//            
//                break;
//           
//        }
//    } 
                                
}
