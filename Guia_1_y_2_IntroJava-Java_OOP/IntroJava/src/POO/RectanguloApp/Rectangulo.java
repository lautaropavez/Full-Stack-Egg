package POO.RectanguloApp;
//4. Crear una clase Rectángulo que modele rectángulos por medio de un atributo
//privado base y un atributo privado altura. La clase incluirá un método para crear el
//rectángulo con los datos del Rectángulo dados por el usuario. También incluirá un
//método para calcular la superficie del rectángulo y un método para calcular el
//perímetro del rectángulo. Por último, tendremos un método que dibujará el
//rectángulo mediante asteriscos usando la base y la altura. Se deberán además definir
//los métodos getters, setters y constructores correspondientes.
//Superficie = base * altura / Perímetro = (base + altura) * 2.
public class Rectangulo {

    private int base;
    private int altura;
    
    //Constructor vacio
    public Rectangulo(){   
    }
    
    //Constructor con los parámetros para crear el rectángulo con los datos dados por el usuario.
    public Rectangulo(int base, int altura){
      this.base = base;
      this.altura = altura;
    }

//------------------------------------------------------------------------------
    
    public void setBase(int base) {
        this.base = base;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }
    
//------------------------------------------------------------------------------
    
    /*
    * método para calcular la superficie del rectángulo
    */
    public int Calcularsuperficie(int base,int altura){
        int superficie = base * altura;
        return superficie;
    }
    
    /*
    * método para calcular el perímetro del rectángulo.
    */
    public int Calcularperimetro(int base,int altura){
        int perimetro =  (base + altura) * 2;
        return perimetro;
    }
    
    /*
    *método que dibujará el rectángulo mediante 
    * asteriscos usando la base y la altura
    */
    public void dibujarRectangulo(int base,int altura){
       //i recorre la altura
       for(int i = 1; i <= altura ; i++ ){
           //j recorre la base
           for(int j = 1; j <= base ; j++ ){
               if(( i > 1 && i < altura) && ( j > 1 && j < base)){
                   System.out.print("   ");
               }else{
                   System.out.print(" * ");
               }
           }
           System.out.println(" ");
       }
    }
    
}
