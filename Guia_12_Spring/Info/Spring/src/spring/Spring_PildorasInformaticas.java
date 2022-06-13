package spring;

/**
 * @author Lautaro Pavez
 */
/*
 ===============================================================================
                                    TEMARIO

1) Que es Spring 
2) Preparacion Eclipse para Spring
3) Inversión de control y configuración XML
4) Inyección de dependencias
5) Alcance y ciclos de vida de los beans
6) Configuración con Java annotations
7) Configuración con codigo Java 
8) Aplicaciones Web con Spring. MVC

 ===============================================================================
*/
public class Spring_PildorasInformaticas {

    public static void main(String[] args) {
        /*IMPORTANTE: https://es.stackoverflow.com/questions/73955/cual-es-la-diferencia-entre-spring-jsf-jsp*/
        /*==================== Introducción. Vídeo 2 ====================*/
        /* Spring es el FRAMEWORK más utilizado para realizar aplicaciones Java, Spring es la alternativa al desarrollo de aplicaciones Java Enterprise(JEE) porque es mas simple y más ligero
           Frame-Work: entorno o marco de trabajo compuesto por reaglas y herramientas que facilitan mucho el desarrollo de aplicaciones
           Hoy en dia las aplicaciones empresariales de Java se implementan con Spring  
        */
        /*==================== Core Spring. Vídeo 3 ====================*/
        /*---- Ventajas -----
         - Inyección de dependecias(favorece el "loose coupling"). loose coupling: Es cuando tienes que modificar un programa Java y esa modificación la tienes que repetir en un montón de clases para que todo funcione. El loose coupling es cuando esa modificación la debes hacer solamente en una clase para que todo funcione
           La inyección de dependecias permitela separación de los módulos de un programa Java para que todas aquellas modificaciones solo las debas hacer en un lugar en concreto y no repetir esa modificación.
         - Desarrollo sencillo con POJOs (Plain Old Java Objects = Objetos planos antiguos de JAVA ): es una clase sencilla que no hereda de otra y no implementa niguna interfaz.
         - Minimiza el código repetitivo (boilerplate code): es algo parecido al loose coupling.
         - Simplifica el acceso a datos 
         - AOP (Programación orientada a Aspectos)
         ---- Core de Spring -----
         Se divide en 5 partes: 
         - Contenedor central: Beans, Context, Core, SpEL(Spring Expression Lenguage)
         - Infraestructura: AOP, Aspects, Instrumentation, Messages
         - Modulo Acceso a Datos: JDBC (más fácil que el que usamos, porque usa unas Helpper clases y escribimos menos código), ORM(Object Relational Mapping: nos permite utilizar la programacion orientada a objetos con base de datos, tambien nos permite una alta interacción con Hibernate ), Transactions(se divide en OXM y JMS(Java Messaging Service)): nos permite reducir código a la hora de hacer llamadas a la base de datos
         - Web/MVC : Servlet(un pequeño programa residente en el servidor que generalmente se ejecuta automáticamente en respuesta a la entrada del usuario.)
                     WebSocket: JSF y Struts
                     Web
                     Portlet(una aplicación utilizada por un sitio web del portal para recibir solicitudes de clientes y devolver información) nos permitira el acceso web remoto
         - Pruebas/Test: Unit, Mock Objects, Integration
        */
        /*==================== Instalación Tomcat y Entorno de desarrollo. Vídeo 4 ====================*/
        /* 
         Instala Eclipse y elige donde poner su WorkSpace (carpeta donde se van a guardar todos los proyectos)
        */
        /*==================== Descarga e instalación librerías Spring. Spring JAR files. Vídeo 5 ====================*/
        /*==================== Inversion Of Control I. Vídeo 6 ====================*/
        /* 
        
        */
        /* 
         
        */
        
    }

}
