package Mascota;
import java.util.ArrayList;  //Nos sirve tambien si en vez de List usaramos ArrayList pero con List tenemos acceso a varios metodos más
import java.util.List;
import java.util.Scanner;

public class ServiceColeccionesMascota {
    //VAMOS A TRABAJAR CON LA CLASE MASCOTA QUE CREAMOS EN POO
    public Scanner leer;
    public List<Mascota> mascotas;
    
    public ServiceColeccionesMascota(){
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.mascotas = new ArrayList();
    }
    
    public Mascota crearMascota(){
        System.out.println("Introducir nombre: ");
        String nombre = leer.next();
        
        System.out.println("Introducir apodo: ");
        String apodo = leer.next();
        
        System.out.println("Introducir tipo: ");
        String tipo = leer.next();
        
        Mascota m = new Mascota(nombre,apodo,tipo);
      
        return m;
    }
    public void agregarMascota(Mascota m){
        mascotas.add(m);
    }
    public void MostrarMascotas(){
        
        System.out.println("Las mascotas actuales de la Lista Mascota son: ");
        
        for (Mascota var : mascotas) { // 1° Tipo de dato de la variable auxiliar a mostrar. 2° variable. 3° Sobre que se va a resolver.
            System.out.println(var);
        }
        
        System.out.println("Cantidad = " + mascotas.size());
    }
    
    /*
    * Crea mascotas todos iguales
    * @param cantidad equivale a la cantidad de mascotas a crear y añadir a la 
    * lista
    */
    public void fabricaPerros(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            mascotas.add(new Mascota("Pedro","Peluza","Perro"));
        }
    }
    /*
    * Crea mascotas pidiendo los datos por teclado
    * @param cantidad
    */
    public void fabricaMascota(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            Mascota mascotacreada = crearMascota();
            agregarMascota(mascotacreada);
            System.out.println(mascotacreada.toString());
        }
    } // Necesita recibir como parámetro el indice de que mascota quiero modificar de mi coleccion
   
    /*
    * To do añadir Try an Catch
    */
//    public void actualizarMascota(int index){
//        
//        //Llamo la lista que contiene estas mascotas, hago un get index(así la busco por el índice)
//        Mascota m = mascotas.get(index); // A la lista de mascotas yo obtengo a través del método get, que me obtiene un objeto de la lista 
//                                         // pero le tengo que pasar el indice, entonces yo le paso el indice como parámetro y en base a eso busca la mascota, 
//                                         // la agarra, la mete en la variable auxiliar m que es de ámbito(scout) local y justamente la extraigo. Sigue...
//                                         
//        m.setApodo("Roberto");           //(Acá sigue)Una vez que la extraje pongo m.setApodo y le cambio el apodo a roberto sin interesarme el que tenga antes
//                                         // Esto se puede hacer porque estos objetos estan pasados por referencia. 
//    }                                    // Lo que hacemos aca entonces es tomar el objeto original le cambiamos el atributo y directamente ya se ve impactado en la lista, no es necesario volver a guardarlo en la coleccion  
//    public void actualizarMascota(int index){ //Acá llamo a la función crearMascota, creo una nueva mascota en la variable m(que es ambito local de este nuevo método) y yo uso el método set de mascotas
//       
//        System.out.println("");
//        System.out.println("---------------Actualizar---------------");
//        Mascota m = crearMascota();//
//        
//        mascotas.set(index, m); //pongo el nombre de la coleccion + .(punto) + método set -> el cuál necesita un índice de que voy a cambiar y un objeto que tengo que añadir,
//                                // en este caso como la lista(Arraylist) es de mascotas, tengo que poner un objeto de tipo mascota
//    }
    public void actualizarMascota(int index){ 
       
        if (index <= (mascotas.size()-1)) {
            System.out.println("");
            System.out.println("---------------Actualizar---------------");
            Mascota m = crearMascota();
        
            mascotas.set(index, m);    
        }else{
            System.out.println("Fallo al actualizar, el indice es erroneo.");
        }                           
    }
    
// Entonces podemos actualizar los datos, modificando por referencia al objeto(1° caso) o creando un nuevo objeto y pisando en base al índice (2° caso).
    
// Tenemos varias formas de eliminar: 
//  *1° remove: Pasandole el objeto puntual, la referencia de memoria de que objeto queremos eliminar. 
//  *2° remove: Pasando el indice. 
//  *3° remove_All: Pasar en base a una colección. 
//  *4° remove_If: Se pone un condicional para establecer con que filtro vamos a eliminar.
//  *5 replace_All: Reemplaza todos.
//  *6 retain_All: Contrasta otra coleccion.
   
//    public void eliminarMascota(int index){
//        mascotas.remove(index);
//    }
    
    public void eliminarMascota(int index){
        
        if (index <= (mascotas.size()-1)) {
            mascotas.remove(index);
        }else{
            System.out.println("Fallo al eliminar, el indice es erroneo.");
        }
        
    }
    
    public void eliminarPorNombre( String nombre ){
        
        for (int i = 0; i < mascotas.size(); i++) {
            
           Mascota m = mascotas.get(i);
 
            if (m.getNombre().equals(nombre)) {
                mascotas.remove(i);
            }
        }
    }
    public void actualizarPorNombre( String nombreviejo, String nombreNuevo ){
        
        for (int i = 0; i < mascotas.size(); i++) {
            
           Mascota m = mascotas.get(i);
            if (m.getNombre().equals(nombreviejo)) {
                m.setNombre(nombreNuevo);
            }
        }
    }
}
