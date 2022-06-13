package POO.Ejercicio12Persona;

import java.util.Date;
import java.util.Scanner;

public class ServicePersona {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    PersonaDate persona1 = new PersonaDate();

    public void crearPersona() {

        Date fecha_actual = new Date();

        //Persona datos = new Persona();
        System.out.println("Bienvenido Usuario: \n"
                + "Ingrese el nombre de la persona: ");
        String nombre = leer.nextLine();

        System.out.println("Ingrese su fecha de nacimiento. ");
        System.out.println("AÑO: ");
        int year = leer.nextInt();
        year -= 1900;
        System.out.println("MES N°: ");
        int mes = leer.nextInt();
        mes -= 1;
        System.out.println("DIA: ");
        int dia = leer.nextInt();

        System.out.println("SEXO(H,M,O):");
        char sexo = Character.toUpperCase(leer.next().charAt(0)); //para acceder a los metodos de character podemos hacerlo desde la clase "Character", si yo hubiera puesto "char" no me da esas opciones
        // ponemos toUppercase para que lo que lea lo pase a mayuscula.        

        System.out.println("ALTURA:");
        double altura = leer.nextDouble();

        while (sexo != 'H' && sexo != 'M' && sexo != 'O') {
            System.out.println("Dato ingresado incorrecto, ingreselo nuevamente: ");
            sexo = Character.toUpperCase(leer.next().charAt(0));
        }

        while (altura <= 0) {
            System.out.println("Dato ingresado incorrecto, ingreselo nuevamente: ");
            altura = leer.nextDouble();
        }

        persona1.setNombre(nombre);
        persona1.setFecha_nac(new Date(year, mes, dia));
        persona1.setFecha_actual(fecha_actual);
        persona1.setSexo(sexo);
        persona1.setAltura(altura);
    }

    public void Calcular_edad() {
        persona1.setEdad(persona1.getFecha_actual().getYear() - persona1.getFecha_nac().getYear());
        System.out.println("La edad de " + persona1.getNombre() + " es de " + persona1.getEdad() + " años.");
    }

    public void menorQue(int edad) {
        if (persona1.getEdad() < edad) {
            System.out.println("La edad de " + persona1.getNombre() + " es Menor de la edad del Usuario 2.");
        }else if(persona1.getEdad()>edad){
            System.out.println("La edad del Usuario 2 es Menor de la edad de " + persona1.getNombre() + ".");
        }else{
           System.out.println("Los dos tienen la misma edad.");
        }
    }

    public void Mostrar_Personal(){
        System.out.println("\n<<<<< DATOS USUARIO 1>>>>>");
        System.out.println("-Nombre: " + persona1.getNombre());
        System.out.println("-Nacimiento: " + persona1.getFecha_nac());
        System.out.println("-Edad: " + persona1.getEdad());
        System.out.println("-Altura: " + persona1.getAltura());
        switch (persona1.getSexo()) {
                case 'H':
                    System.out.println("Hombre");
                    break;
                case 'M':
                    System.out.println("Mujer");
                    break;    
                case 'O':
                    System.out.println("Otre");
                    break;    
        }
      
    }


}
