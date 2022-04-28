package herencia.ejemplo;
//CLASE REPASO HERENCIA CON PROFESORA
public class Persona {

    protected String nombre;
    protected String apellido;
    protected byte edad;

    public Persona(String nombre, String apellido, byte edad) {
        // Debemos recordar que el this hace referencia al atributo de la clase a la que estoy trabajando, this.nombre hace referencia al atributo de la linea 5
        // Mientras que a la derecha del igual estamos trabajando con el dato que toma como parametro
        this.nombre = nombre;
        this.apellido = apellido;
        // Si el señor me creo un objeto utilizando el constructor por parámetros, tambien deberemos validar la edad aca.
        this.edad = validarEdad(edad); //Porque puedo llamar al método validar desde el constructor? Porque yo lo defini de tipo byte, es decir retorna un numero.
        //Entonces como funciona Java --> Viene llama al objeto, crea el objeto, recibe los datos y va a hacer la validacion, cuando llega a la linea 15, va a pivotear el metodo, verifica, si está bien deja ese dato sino retorna el valor por defecto
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = validarEdad(edad);  //Lo utiliza al metodo cuando ingresa un dato. En vez de poner recibe la edad, lo que voy a hacer es invocar a mi método
                                        //Pensando bien la logica, cuando SETEA un dato especifico, si la edad esta equivocada por defecto se ira a 10.
    }
    
    private byte validarEdad(byte edadI){
        if (edadI >= 6) {
            this.edad = edadI; //Le pongo el this.edad para asegurarme de que le hago referencia al atributo y no al parametro que recibe de la función
        }else{
            this.edad = 10;  // Valor por defecto
        }
        return this.edad;
    }
    
    
    // Este método lo creo para mostrar datos
    public void mostrarDatos(){
        System.out.println("\nNombre Persona: " + nombre +
                "\nApellido Persona: "+ apellido +
                "\nEdad Persona: " + edad);
       
    }
}
