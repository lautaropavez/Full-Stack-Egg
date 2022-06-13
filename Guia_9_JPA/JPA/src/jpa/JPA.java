package jpa;

import java.util.UUID;

/**
 * @author Lautaro Pavez
 */
/**
 * Pensamientos Mios: 
 * ver como es el crear limpiador de pantalla en el menu
 * Arreglar asunto de try an catch
 * Eliminar eliminarAutor de ServiceAutor y lo mismo con editorial (ver como lo hizo acamus)
 * InputMismatchException acamus
 * 
 */
/**
 * ERRORES QUE TENGO EN LIBRERIA:
 * - Crear libro de la misma editorial
 * INFO de error que me apareció --> https://coderanch.com/t/529568/java/resolving-error-java-lang-illegalargumentexception , https://exchangetuts.com/entity-must-be-managed-to-call-remove-1640030164689140 , https://stackoverflow.com/questions/29775627/entity-must-be-managed-to-call-remove-when-i-try-to-delete-an-entity                                
 */
public class JPA {

    public static void main(String[] args) {
       /* Video 1 Youtube EGG */
       /*
         JPA es la API de Persistencia que permite astraerse a esa capa que permite JDBC, es decir nos permite trabajar con objetos sin tener que estar pensando
         como hacer un INSERT, UPDATE en una sentencia SQL nativa. JPA tiene su propio lenguaje de consultas (JPAQUERY) el cual nos permite traer objetos, vamos a tener 
         que cambiar nuestro y empezar a pensar que lo que nosotros recuperamos son objetos y no registros de una base de datos, entonces cuando nosotros hacemos
         una consulta JPA nos devuelve un objeto y no un registro y nosotros recien ahi lo teniamos que recorrer como pasaba con resulset para poder en ese 
         momento ir seteando los valores y retornar el objeto a la capa de servicios. Vamos al codigo
       
        */
       /* Clase 23 Turno Tarde Intro JPA */
       /*
        JPA utiliza un modelo ORM (Mapeo de Objetos Relacionales) es la principal diferencia con JDBC ya que JDBC nos trae registros, mientras que JPA nos trae objetos.
        JPA tiene anotaciones o etiquetas que nos permite declarar el modo de relacionar nuestras clases y atributos con las tablas de nuestra base de datos, vemos algunas anotaciones (min 2:47)
        A partir de ahora lo unico que tengo que hacer en MYSQL (que tambien lo puedo hacer en Netbeans) es crear mi base de datos especifica con la que voy a trabajar,
        luego yo creando las entidades especificas en mi unidad de persistencia, poniendo esta anotacion @Entity cuando mi programa corra de forma automatica me va a 
        crear las tablas.
        Importante: TODA tabla debe tener un Id (Primary Key), se recomienda que no sea un atributo del objeto, es decir, que no sea ni DNI, correo o telefono porque la
        teoria nos dice que el id no debe ser manipulado una vez que fue creado, osea no tengo que poder modificarlo. 
        @GeneratedValue: especifica que se genere automaticamente el id.
        @Transiet: Se utiliza para aquellos atributos que yo voy a declarar en mi maqueta del objeto en mi clase entidad, que no tiene que ser persistido en la base de 
        datos, solo debe adquirida esa info cuando hago la consulta especifica(ej:edad,saldo). Basicamente porque son datos que van a a ir cambiando con el tiempo
        @Temporal afecta las fechas
        Tambien tengo anotaciones- etiquetas que afectan principalmente a los nombres
        @Table: Lo que nos va a permitir es modificar el nombre de una tabla en MYSQL
        @Column:  modificar el nombre de una columna en MYSQL
        min 8 @JoinColumn 
        Las anotaciones pueden recibir parametros
        min 13: Con el tiempo vamos a darnos cuenta que una relacion ManyToOne es mas comoda para el mapeo 
        EntityManager es quien maneja la interacción con la base de datos, tiene solamente 4 transacciones
        min 17: Utilidades de EntityManager 
        min 21: Lenguaje SQL de JPA --> JPQL: explicacion 
        Las consultas pueden traer uno o varios resultados(en este caso usamos una lista o arraylist)
        En JPA al traer un objeto lo trae completo, a diferencia de JDBC que trae un registro entonces podiamos traer una parte si queriamos
        min 28: Explicacion Proyecto JPAModeloBase 
        min 35: unico caso en que  no va a crear una columna es cuando esta escrito @Transiet que es un dato transitorio, y donde se guardaria esa info del dato transitorio? 
        No es guardada min 36:36
        min 40 importante
        */
       /* Clase 24 Repaso JPA Turno Tarde */
       /*
       Min 19 IMPORTANTE--> como hacemos para ver las tablas creadas momentaneamente
       Min 22 Siempre vamos a tener alta y baja de servicio en todos los proyectos
       Min 23:23 Autor y editorial
       Min 27 relacion 1 a 1 si elimino usuario se elimina la mascota del usuario
       Min 30 return null en try and catch
       */
       /* Clase 25 Repaso JPA Turno Tarde */
       /*
        *Para edad usamos tipo de dato byte*
        Min 0...FINAL  Vemos proyecto del profe y errores de alumnos
        Min 1 creacion Libro en proyecto profe
        Min 7 verificacion y creación de autores en proyecto profe
        Min 23 clase Utilidad para leer  
        Min 25 ERROR alumno
        Min 30 Generated Value(Strategy = IDENTITY) de esta manera es autoincremental si le pongo SEQUENCE se autoincrementa de la manera que y le diga por ej 5 en 5.
        Min 33-34 y 39- Cuando manejemos base de datos lo que importa es el manejo del tipo de dato en la base de datos. lo que te da velocidad en una aplicación es manejar bien el dato en la base de datos por ej un byte en vez de long
        Min 45 Anotaciones:
            Collumn(nullable = false) con esto digo que este dato tiene que ser obligatorio
            JoinColumn forma de hacer una foreing key (opcional)
            ManyToOne --> Muchos libros pueden pertenecer a un autor.
            En la practica lo que mas se usa son las ManyToOne y OneToMany
        Min 50 ManyToMany: si hacemos ManyToMany tenemos que hacer una Lista de Autores
        Min 55 Para no generar la tabla intermedia(solo para cuando trabajamos de forma bidireccional)--> OneToMany(mappedby= "autor") Esto lo hago en autor(forma bidireccional) para el atributo autor que es un objeto, de esta forma yo ceo la relacion de forma manual sería y no me crea la tabal intermedia,no hace falta que sea OneToMany
       */
       /* Clase 26 Repaso JPA Turno Tarde */
       /*
        Min 1 Aconsejable usar listas en vez de Collections
        Min 3 muestra su clase LibroDAO con sus llamadas a la base de datos y vemos que tiene try and catch
        Min 5 profe manda Lista de manera simplificada
        Min 6 autor.class libro.class editorial.class, jpa me va a permitir parsearmelo de forma automatica
        Min 7 clase DAO devuelve lista
        Min 8 clase DAO devuelve objeto Autor 
        Min 9 ¡¡IMPORTANTE!! DIFERENCIA ENTRE TRABAJAR CON LISTAS Y CON UN OBJETO, Si no lo encuentra en la lista me la devuelve vacia, pero si no encuentra un objeto en el DAO me devuelve una excepcion --> NoResultException, entonces yo la debo controlar y retornar manualmente un null,
        por lo tanto en el servicio que lo recibe en vez de poner un if a ver si esta vacio como es para las listas, hago un if si es null.
        Min 14 Hacemos consultas, JDBC trabaja con consultas nativas SQL y JPA trabaja con JPQL
        Min 17 JPQL nos permite que yo no tenga que hacer muchos INNER JOIN, puedo traer datos de 2 tablas
        Min 18 como traer info de 2 tablas juntas
        Min 23 función CONCAT para buscar solo una parte de una palabra por ej busco pe y me trae todos los nombres con pe, deberia tener una lista que me los reciba, fijarme en mi Libro DAO si lo tengo igual
        Min 25 En una consulta setear mas de 1 parámetro, fijarme en mi Libro DAO si lo tengo igual
        Min 26-28 BOOLEANO true parametro
        Min 35 ERROR de Driver
        Min 40 Relaciones o Mapeo Bidireccional, ManyToOne OneToMany, libro y editorial
        Min 45 En la realidad con el manejo de tablas grandes ej banco, no se usan tabla intermedia, de que forma no la uso? con el mappedby explicado al final del video anterior. 
        Min 47 es importante hacer relacion bidireccional? depende la situación
        Min 49 En la ManyToOne no te muestra e mappedby sino en la OneToMany
        Min 52 ERROR se traba Netbeans 
       */
       /* Clase 27 Cierre JPA Turno Tarde */
       /*
        Min 3 Cascada dejarla cargada y ponerle ALL asi nos olvdamos directamente
        Min 4 Si yo creo una relacion y no dejo cargada la cascada, nos va a aparecer despues un error Null Pointer Exception en el output. Yo estoy utilizando un elemento persistencia que es el gestor que se ocupa de dejar los datos en la base de datos, si yo no 
              dejo prefijado esto, cuando yo creo el libro tengo conflictos con las persistencias y el DAO en este caso del autor NO persiste este elemento. Pero si creo una relacion y dejo precargada como se va a comportar en cascada, creo un Autor si el autor no 
              existe, persistilo en la tabla, caso contrario traelo y demás.
        Min 5 que hacer si ya existe un dato. La propiedad esta(cascada) no esta diciendo que cree un elemento sino que persista la información(que se mantenga en el tiempo)
        Min 6 Column (nullable = false) es como la notación @Notnull y lo que hago es obligarlo a que este el dato(que no sea nulo)
        Min 6-7 Cuando yo trabajo relaciones unidireccionales OneToOne, como termina siendo la obtención de datos de este atributo, fer carga un libro, viene de forma lazy o eager?
        En las relaciones OneToOne por defecto viene eager, no viene lazy.
        Min 9 ERROR compañero, cuando llamamos a algo y nos manda un @ + simbolos,num,etc es porque nos manda el espacio de memoria del objeto y esto sucede porque no le pusimos el método tostring a la entidad
        Min 10 ERROR que nos aconseja profe, tener cuidado cuando tengamos relaciones bidireccionales, el tema del uso del tostring de los elementos, porque nos puede pasar que quede en un bucle infinito
        Min 11 cuando creamos una relación bidireccional, el elemento relacionado de la tabla debil (en el caso de libro con autor seria autor) tenemos que imprimir atributo x atributo específico para evitar ese bucle
        Min 14 las 2 lineas rojas que nos aparecen en el output cuando lo abrimos es un WARNING de que estamos accediendo de manera NO segura a la base de datos
        Min 15-20 ¡¡IMPORTANTE!! Error compañera de return null en el DAO le debemos poner un try and catch
        Min 20 A diferencia de JDBC yo ya no me traigo más registros o datos de mi registro, yo o me traigo el objeto o no me lo traigo. 
        Min 21 ERROR compañero se traia un elemento de editorial y lo guardaba en un objeto de tipo editorial, por lo que le daba error porque es incompatible
        Min 22 esta bien que un servicio llame a otro. La teoria dice que si creaste una relación 1 a 1 por cuestión de jerarquía persona-mascota, libro-entidad, no deberia sostener en el tiempo en la tabla secundaria el dato de la tabla principal
        Min 24 si quiero ELIMINAR LIBROS POR AUTOR tengo que hacer la relación desde el autor
        Min 27 ERROR compañero, solución usar rollback
        Min 28-34 ERROR compañero, problemas de transacción, error en el DAO
       */
       /* Curso Spring. FetchType Eager vs FetchType Lazy. Vídeo 64  https://www.youtube.com/watch?v=Bi3uIoW2nG4&t=211s, mas info acá https://stackoverflow.com/questions/2990799/difference-between-fetchtype-lazy-and-eager-in-java-persistence-api*/
       /*
        A la hora de trabajar con Spring o Hibernate, cuando nosotros tenemos 2 entidades relacionadas entre si, con una relación de 1 a varios (1 cliente realiza varios pedidos), al momento de pedir info a la base de datos, como se proporciona esta info?
        Eager: ansioso, en programación→ cuando hacemos una consulta a la base de datos nos devuelve toda la información disponible de una vez, ej: el cliente con todos los pedidos que ha realizado en su historial
        Lazy: Perezoso, en programación→ cuando hacemos una consulta a la base de datos nos devuelve la información cuando se necesita, ej: solo nos devuelve la info del cliente no de sus pedidos, a menos que le pidamos algun pedido en especial. Es on demand osea a petición.
        El tipo Lazy suele ser la opción más escogida
        Min 7 Cómo indicamos en el mapeo ORM si el FetchType debe ser Lazy o Eager
        Min 7 bis IMPORTANTE anotaciones cascadeType. , etc
        Min 8 le pone un FetchType.LAZY a un OneToMany
        Min 8 Ventajas y desventajas: Si nuestros clientes tienen pocos pedidos nos conviene eager mientras que si tienen muchos nos conviene lazy. Ventaja de lazy nos proporciona la info especifica y consumimos menos recursos pero tenemos que hacer mas llamadas, con el EAGER hacemos una llamada a la base de datos
        Min 9 Si no eespecificamos el fetch, el fetch que se aplica es: 
              Uno a Uno(OneToOne)         ---> Eager
              Uno a varios(OneToMany)     ---> Lazy
              Varios a uno(ManyToOne)     ---> Eager
              Varios a varios(ManyToMany) ---> Lazy
        Min 11 como ponerlo en nuestra clase la notacion FetchType
       */  
    }
}
    
