package POO.CadenaApp;
//    8. Realizar una clase llamada Cadena que tenga como atributos una frase (de tipo de
//    String) y su longitud. En el main se creará el objeto y se le pedirá al usuario que ingrese
//    una frase que puede ser una palabra o varias palabras separadas por un espacio en
//    blanco y a través de los métodos set, se guardará la frase y la longitud de manera
//    automática según la longitud de la frase ingresada.
public class Cadena {
    private String frase;
    private int long_frase;

    public Cadena() {
    }
         
    public Cadena(String frase, int long_frase) {
        this.frase = frase;
        this.long_frase = long_frase;
    }

//------------------------------------------------------------------------------
    
    public void setFrase(String frase) {
        this.frase = frase;
    }

    public void setLong_frase(int long_frase) {
        this.long_frase = long_frase;
    }
    
//------------------------------------------------------------------------------   

    public String getFrase() {
        return frase;
    }

    public int getLong_frase() {
        return long_frase;
    }
    

}
