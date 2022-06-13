package Figuras;
//    Ya que este calculo se va a repetir en las dos formas geométricas, vamos a crear 
//    una Interfaz, llamada calculosFormas que tendrá, los dos métodos para calcular 
//    el área, el perímetro y el valor de PI como constante.
//    Desarrollar el ejercicio para que las formas implementen los métodos de la interfaz 
//    y se calcule el área y el perímetro de los dos. En el main se crearán las formas 
//    y se mostrará el resultado final.
public interface calculosFormas {
    
    public abstract void calcularArea();
    public abstract void calcularPerimetro();
    double PI = 3.141592;

}
