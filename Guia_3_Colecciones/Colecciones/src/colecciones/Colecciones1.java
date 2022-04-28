package colecciones;

public class Colecciones1 {
    
    public static void main(String[] args) {
       ServiceColecciones1 servMasc = new ServiceColecciones1(); //Aca ya tenemos creado el objeto que corresponde al servicio
       
       //Creo las 2 mascotas y después las muestro
       servMasc.crearMascota();
       servMasc.crearMascota();
       
       //Las muestro
       servMasc.MostrarMascotas();
       
       
       
       
       
       
       
    }
}
