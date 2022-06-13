package POO;

public class Auto {

    // Debemos especificar las caracteristicas comunes.
    private int ruedas;  
    private int largo;  //largo  en cm.
    private int ancho;  //ancho en cm.
    private int motor;  //motor en cm cúbicos.
    private int peso_plataforma;    //peso en kg.
    //Abajo caracteristicas que pueden variar dependiendo el coche:
    private String color;
    private boolean asientosCuero, climatizador;
    private int peso_total;
    
    // siguiente paso: Decir cuantas ruedas hay, cual es el ancho, largo, etc.
    // Eso lo hacemos con un método constructor (es un método especial que se encarga de dar un estado inicial a nuestro objeto).
    // ¿cómo se construye? ponemos public NombredelaClase (siempre debe tener el mismo nombre de la clase y es lo que lo diferencia de un método normal).
    public Auto() {
        //CONSTRUCTOR: Acá debemos construir el estado inicial del objeto, cuantas ruedas tiene, que largo, etc.

        ruedas = 4;
        largo = 2000;
        ancho = 300;
        motor = 1600;
        peso_plataforma = 500;
        color = "Rojo";
    }

    public String Dime_Largo() {    //MÉTODO GETTER que nos proporciona el largo del coche
        return "El largo del coche es " + largo;
    }
    
    public String dime_datos_generales(){ //MÉTODO GETTER
        return "La plataforma del vehículo tiene " + ruedas + " ruedas" +
                ". Mide " + (largo/1000) + " metros con un ancho de " + 
                ancho + " cm y un peso de plataforma de "+ peso_plataforma + " kg.";
    }

    public void establece_color(String color_coche) {  //MÉTODO SETTER
        //color = "azul";
        color = color_coche;
    }

    public String Dime_Color() {    //MÉTODO GETTER que nos proporciona el color del coche
        return "El color del coche es " + color +".";
    }
    
    //Se puede construir el setter y despues el getter y viceversa. Además no hace falta que vayan en parejas, por ejemplo para los datos generales solamente construimos un getter pero porque el constructor ya le habia dado un valor a estas variables.
    
    public void configura_asientos(String asientosCuero ){     //MÉTODO SETTER
                                                               // Cuando sucede que el nombre del argumento(lo que está entre paretesis del método setter) es igual al nombre de la variable declarada en la clase,
//        if(asientosCuero == "si"){                           // lo que hacemos es usar el operador this que sirve para hacer referencia a la propia clase.
//            this.asientosCuero = true;                       // ponemos el this delante del nombre de la variable y con esto le indicamos a java que estamos haciendo referencia a la variable de la clase
//        } else{                                              // se puede hacer con el if o mas corto con el equals.
//            this.asientosCuero = false;
//        }  
        this.asientosCuero = "si".equalsIgnoreCase(asientosCuero); 
    }
    
    public String dime_asientos(){                             //MÉTODO GETTER
        if (asientosCuero == true){                            // Porque no ponemos el this? porque no hay confusion aca ya que en este metodo no hay asientos cuero por lo que solo existiria el asientoscuero que es la variable.
            return "El auto tiene asientos de cuero.";         // El método debe devolver un string pase lo que pase, por lo que no podemos dejar el if sin el else porque en ese caso no devolveria nada
        } else{
            return "El auto tiene asiento de serie.";
        }  
    }
    
    public void configura_climatizador(String climatizador){   //MÉTODO SETTER
        
        this.climatizador = "si".equalsIgnoreCase(climatizador);
        
//        if("si".equalsIgnoreCase(climatizador)){            //Otra manera, mismo resultado
//            this.climatizador = true;
//        }else{
//            this.climatizador = false;
//        }
    }
    
    public String dime_climatizador(){                         //MÉTODO GETTER
        if(climatizador==true){
            return "El auto tiene climatizador";
        } else{
            return "El auto lleva aire acondicionado";
        }
    }
    
    public String dime_pesocoche(){                             //MÉTODO SETTER y GETTER ¿? Porque? Porque estamos estableciendo el valor de una variable y por otro lado le decimos que nos devuelva un dato
        int peso_carroceria = 500;
        peso_total = peso_plataforma + peso_carroceria;
        if(asientosCuero==true){
            peso_total = peso_total + 50;
        }
        if(climatizador == true){
          peso_total = peso_total + 20;
        }
        
        return "El peso del coche es " + peso_total;
    }
    
    public int precio_coche(){                              //MÉTODO GETTER
        int precio_final = 10000;
        
        if(asientosCuero==true){
            precio_final += 2000;
        }
        if(climatizador==true){
            precio_final += 1500;
        }
        
        return precio_final;
    }
}
