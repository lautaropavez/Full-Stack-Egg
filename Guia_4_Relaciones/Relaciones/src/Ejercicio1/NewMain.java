package Ejercicio1;
//    Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener
//    que pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo,
//    mostrar desde la clase Persona, la información del Perro y de la Persona.
public class NewMain {

    public static void main(String[] args) {
       
        Perro m1 = new Perro("Zeus","Ovejero",5,2.1);
        Perro m2 = new Perro("Thor","Pitbull",2,1.2);
        
       Persona pers1 = new Persona("Lautaro","Pavez",23,40973161,m1);
       Persona pers2 = new Persona("Matias","Rodriguez",49,33973161,m2);
       
        System.out.println(pers1.toString());
        System.out.println(pers2.toString());
       
       
     
       
//        u.setSexo(SexoHumano.HOMBRE);
//        
//        System.out.println(u.getSexo());
//        
//        System.out.println(RazaPerro.PITBULL.getValor());
//               Mascota m1 = new Mascota("Fernando","Chiquito","Perro");
//
//      Mascota m2 = new Mascota("Pepa","Lola","Gato");
//      
//      List<Mascota> mascotas = new ArrayList();
//      
//      mascotas.add(m1);
//      mascotas.add(m2);
//        
//      Usuario u = new Usuario();
//      
//      u.setApellido("Fiorde");
//      u.setSexo(SexoHumano.HOMBRE);
//      u.setNacimiento(new Date("1/01/2022")); // new Date() solo sin el String lo que hace es poner la fecha que es ahora.
//      
//      u.setMascotaFavorita(m1);
//      
//      u.setMascota(mascotas);
//      
//        System.out.println(u.toString());
    }

}
