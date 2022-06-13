package POO.MatemmaticaApp;
//    9. Realizar una clase llamada Matemática que tenga como atributos dos números reales
//    con los cuales se realizarán diferentes operaciones matemáticas. La clase debe tener
//    un constructor vacío, parametrizado y get y set. En el main se creará el objeto y se
//    usará el Math.random para generar los dos números y se guardaran en el objeto con
//    su respectivos set. Deberá además implementar los siguientes métodos:
//    • Método devolverMayor() para retornar cuál de los dos atributos tiene el mayor
//    valor.
//    • Método calcularPotencia() para calcular la potencia del mayor valor de la clase
//    elevado al menor número. Previamente se deben redondear ambos valores.
//    • Método calculaRaiz(), para calcular la raíz cuadrada del menor de los dos valores.
//    Antes de calcular la raíz cuadrada se debe obtener el valor absoluto del número.
public class ServiceMatematica {
    
    Matematica matt = new Matematica();
    
    public double devolverMayor(Matematica matt){
        double mayor = Math.max(matt.getNum1(),matt.getNum2());
        return mayor;
    }
    
    public double Menor(Matematica matt){
        double menor =  Math.min(matt.getNum1(),matt.getNum2());
        return menor;
    }
    
    public int calcularPotencia(Matematica matt){ //potencia calculada pasando los dos numeros a enteros
       int mayorr =(int) devolverMayor(matt);
       int minimo = (int) Menor(matt);            
 //    int min = Math.min((int)matt.getNum1(),(int)matt.getNum2());     //Otra manera de escribir el minimo 
       int potencia = (int)Math.pow(mayorr,minimo);
       
       return potencia;
    }
    
    public double calcularPotenciaaa(Matematica matt){ //potencia calculada con los numeros como estaban sin redondear
       double mayorr =devolverMayor(matt);
       double min = Menor(matt);
       double potencia = Math.pow(mayorr,min);
       
       return potencia;
    }
    
    public int ValorAbsoluto(Matematica matt){
        int MinAbs = Math.abs((int) Menor(matt));
        
        return MinAbs;
    }
    
    public double calculaRaiz(Matematica matt){
        double raiz = Math.sqrt((double) ValorAbsoluto(matt));
        return raiz;
    }
    
    
}
