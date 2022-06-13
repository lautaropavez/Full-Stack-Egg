package POO.PersonaApp;
//    • Metodo crearPersona(): el método crear persona, le pide los valores de los atributos
//      al usuario y después se le asignan a sus respectivos atributos para llenar el objeto
//      Persona. Además, comprueba que el sexo introducido sea correcto, es decir, H, M o
//      O. Si no es correcto se deberá mostrar un mensaje
//    • Método calcularIMC(): calculara si la persona está en su peso ideal (peso en
//      kg/(altura^2 en mt2)). Si esta fórmula da por resultado un valor menor que 20, la
//      función devuelve un -1. Si la fórmula da por resultado un número entre 20 y 25
//      (incluidos), significa que el peso está por debajo de su peso ideal y la función
//      devuelve un 0. Finalmente, si el resultado de la fórmula es un valor mayor que 25
//      significa que la persona tiene sobrepeso, y la función devuelve un 1. Se recomienda
//      hacer uso de constantes para devolver estos valores.(Una constante se define con la 
//      palabra final, la cual significa que el contenido de ese valor no se modifica a lo 
//      largo de la ejecución del programa, se declara arriba porque es un valor que no 
//      cambia nunca, ademas se escribe en MAYUSCULAS y separando las palabras con guion bajo,
//      además hay que darles valor en el momento que se declaran)
//    • Método esMayorDeEdad(): indica si la persona es mayor de edad. La función
//      devuelve un booleano.

import java.util.Scanner;

public class ServicePersona {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private final int IMC_BAJO = -1;
    private final int IMC_IDEAL = 0;
    private final int IMC_ALTO = 1;
    int contMayor = 0;
    int contMenor = 0;
    /* El método crear persona, le pide los valores de los atributos
     * al usuario y después se le asignan a sus respectivos atributos para llenar el objeto
     * Persona. Además, comprueba que el sexo introducido sea correcto, es decir, H, M o
     * O. Si no es correcto se deberá mostrar un mensaje
    */
    public Persona crearPersona() {

        //Persona datos = new Persona();

        System.out.println("----------------Bienvenido Usuario---------------- \n"
                + "Ingrese el nombre de la persona: ");
        String nombre = leer.nextLine();

        System.out.println("Ingrese la edad: ");
        int edad = leer.nextInt();

        System.out.println("Ingrese el sexo(H,M,O):");
        char sexo = Character.toUpperCase(leer.next().charAt(0)); //para acceder a los metodos de character podemos hacerlo desde la clase "Character", si yo hubiera puesto "char" no me da esas opciones
        // ponemos toUppercase para que lo que lea lo pase a mayuscula.        
        System.out.println("Ingrese el peso(kg):");
        double peso = leer.nextDouble();

        System.out.println("Ingrese la altura:");
        double altura = leer.nextDouble();

        while (sexo != 'H' && sexo != 'M' && sexo != 'O') {
            System.out.println("Dato ingresado incorrecto, ingreselo nuevamente: ");
            sexo = Character.toUpperCase(leer.next().charAt(0));
        }

        while (peso <= 0) {
            System.out.println("Dato ingresado incorrecto, ingrese un numero superior a 0: ");
            peso = leer.nextDouble();
        }

        while (altura <= 0) {
            System.out.println("Dato ingresado incorrecto, ingreselo nuevamente: ");
            altura = leer.nextDouble();
        }

        return new Persona(nombre, edad, sexo, peso, altura);
    }

    public int calcularIMC(Persona p) {
        double altura = p.getAltura();
        double peso = p.getPeso();
        double IMC = peso/Math.pow(altura,2);
        
        if(IMC < 20){
            return IMC_BAJO;// 1
        }else if(IMC > 25){
            return IMC_ALTO;// 1
        }else {
            return IMC_IDEAL;// 0
        }
    }
/**
     * Método esMayorDeEdad(): indica si la persona es mayor de edad.La función
     * devuelve un booleano.
     *
     * @param p Persona
     * @return boolean
     */  
    public boolean esMayorDeEdad(Persona p){ //Asi es como lo hizo Adrian Camus en su github y me sirvio
        boolean mayor = false;
        try{
            if (p.getEdad() >=18) {
                mayor = true;
                contMayor++;
            }else{
                contMenor++;
            }
        }catch(RuntimeException e){
            System.out.println("\nERROR: " + e.getMessage());
            System.out.println("Ingrese una persona");
            System.out.println("");

        }
        return mayor;
    }
    
//     public boolean esMayorDeEdad(Persona p){
//     return p.getEdad()>=18; // haciendo esto directamente nos devuelve true o false
//
//     }
     
    
    
    
    public Persona[] crearPersonas(int cant){
       Persona[] personas = new Persona[cant];
       
        for(int i = 0; i < personas.length; i++) {
            personas[i] = crearPersona();   // Persona en la posición 0 llama a crear personas, carga nombre, edad, peso, altura y termina. Persona en la posición 1 llama carga todos los datos y así hasta persona 3
        }
        
        return personas;
    } 
    
    public void porcentajesPeso(Persona[] personas){ //Lo podriamos haber hecho en el main pero queda mas ordenado aqui
        int contadorAlto = 0;
        int contadorBajo = 0;
        int contadorIdeal = 0;
        int cantidadPersonas = personas.length;
        
        //FOR EACH (para cada)
        for (Persona persona : personas) {  //el "persona" se puede llamar de cualquier manera, se pone solo el nombre con el autocompletado del TAB
           //"persona verde" es un objeto del tipo Persona(blanca) que va a ir recorriendo posicion por posicion un arreglo o una lista, cual? la que esté despues de los dos puntos, en este caso la que le pasamos por parametros
            
            switch(calcularIMC(persona)){   //calcularIMC recibe una persona(objeto - blanca), cuál? la que vaya recorriendo nuestro for.
                case -1:                    // Todo lo que hagamos aca adentro lo va a hacer para cada objeto de tipo persona que encuentre desde la primera hasta la ultima posicion de esta lista
                    System.out.println(persona.getNombre() + " está por debajo de su peso ideal.");  
                    contadorBajo++;
                    break;
                case 0:
                    System.out.println(persona.getNombre() + " está en su peso ideal. ;) ");
                    contadorIdeal++;
                    break;
                case 1:
                    System.out.println(persona.getNombre() + " está por encima de su peso ideal.");
                    contadorAlto++;
                    break;
            }                               
        }
        
        System.out.println("Hay " + ((contadorBajo*100)/cantidadPersonas) + "% de personas que están por debajo de su peso ideal.");
        System.out.println("Hay " + ((contadorIdeal*100)/cantidadPersonas) + "% de personas que están en su peso ideal.");
        System.out.println("Hay " + ((contadorAlto*100)/cantidadPersonas) + "% de personas que están por encima de su peso ideal.");
        
    }
    
    public void porcentajeEdad(Persona[] personas){
        int cantidadPersonas = personas.length;
        int contMayores = 0;
        
        for (Persona persona : personas){
            if (esMayorDeEdad(persona)){
                contMayores++;
                System.out.println(persona.getNombre() + " es mayor de edad.");
            }
        }
        System.out.println("Hay " + (contMayores*100)/cantidadPersonas + "% de mayores de edad." );
        System.out.println("Hay " + ((cantidadPersonas - contMayores)*100)/cantidadPersonas + "% de menores de edad.");
    }
    
    public Persona[] crearPersonasTest(){
        
        Persona[] personas = new Persona[4];
        
        personas[0] = new Persona("Pepe",15,'H',75.0,1.85);
        personas[1] = new Persona("Juana",30,'M',90.0,1.95);
        personas[2] = new Persona("Tito",65,'H',30.0,1.65);
        personas[3] = new Persona("Gabriel",44,'O',120.0,1.78);
      
        return personas;
    }
}
