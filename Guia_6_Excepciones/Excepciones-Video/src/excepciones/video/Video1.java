package excepciones.video;

public class Video1 {

    public static void main(String[] args) {

        ////////////////////////////////////////////////////////////////////////
        ////////////////////////  EXCEPCIONES  //////////////////////////////////
        /////////////////////////////////////////////////////////////////////////
        
        
        /////////////////////////////////////////////////////////////////////////
        /////////////////  CAPTURAR EXCEPCIONES INDIVUDUALMENTE  ////////////////
        /////////////////////////////////////////////////////////////////////////
        
        int valor2 = 5;
        System.out.println("El numero entero se inicializo en " + 5);

        try {

            valor2 = Integer.valueOf("a");
            System.out.println("El numero indicado es " + valor2);

        //En la parte del catch especificamos la excepcion que se puede producir
        } catch (NumberFormatException e) { //Como no pudo convertir la cadena a un valor entero (se salto la linea 22) el CATCH atrapó la excepcion y luego se ejecuto la decision que habiamos tomado para hacer con ella
            System.out.print("El valor indicado no es un numero.");
        }

        /////////////////////////////////////////////////////////////////////////
        /////////////////  CAPTURAR TODAS LAS EXCEPCIONES  //////////////////////
        /////////////////////////////////////////////////////////////////////////
        
        try {

            int valor3 = Integer.valueOf("q");
            System.out.println("El numero indicado es " + valor3);

        } catch (Exception e) { //La EXCEPCION exception atrapa TODAS las excepciones
            System.out.print("El valor indicado no es un numero.");
        }
        
        /////////////////////////////////////////////////////////////////////////
        //////////////////////////  BLOQUE FINALLY  /////////////////////////////
        /////////////////////////////////////////////////////////////////////////
        
        //El bloque Finally se ejecuta siempre, independientemente que se lance una excepcion o no
        try {

            int valor4 = Integer.valueOf("a");
            System.out.println("El numero indicado es " + valor4);
            
        }catch (NumberFormatException e) { 
            System.out.print("El valor indicado no es un numero.");
        }catch (Exception e){ 
            System.out.print("El valor indicado no es un numero.");
        }finally{
            int valor5 = 7;
            System.out.println("El numero indicado es " + valor5);
        }
        
        //Lo repetimos pero en este caso si se puede convertir el 10
        try {

            int valor4 = Integer.valueOf("10");
            System.out.println("El numero indicado es " + valor4);
            
        }catch (NumberFormatException e) { 
            System.out.print("El valor indicado no es un numero.");
        }catch (Exception e){ 
            System.out.print("El valor indicado no es un numero.");
        }finally{
            int valor5 = 7;
            System.out.println("El numero indicado es " + valor5);
        }
        
        //Aca vemos que indistintamente de si se puede convertir o no se ejecuta el bloque finally
        
        
    }

}
