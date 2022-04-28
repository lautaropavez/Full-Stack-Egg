package jpa;

/**
 * @author Lautaro Pavez
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
        @JoinColumn: min 8
        Las anotaciones pueden recibir parametros
        EntityManager es quien maneja la interacción con la base de datos
        Utilidades de EntityManager (min 17)
        Lenguaje SQL de JPA --> JPQL: explicacion min 21
        Las consultas pueden traer uno o varios resultados(en este caso usamos una lista o arraylist)
        En JPA al traer un objeto lo trae completo, a diferencia de JDBC que trae un registro entonces podiamos traer una parte si queriamos
        Explicacion Proyecto JPAModeloBase min 28
        min 35: unico caso en que  no va a crear una columna es cuando esta escrito @Transiet que es un dato transitorio
        */
       /**/
       /**/
       /**/
       /**/
       /**/
       /**/
       /**/
       /**/
       /**/
       /**/
       /**/
       /**/
       /**/
    }

}
