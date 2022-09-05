package spring;

/**
 * @author Lautaro Pavez
 */
public class Spring {

    public static void main(String[] args) {
        /*
        ========================== Info Complementaria ========================= 
        DOCUMENTACIÓN DE THYMELEAF (INFO IMPORTANTE): Acá podemos ver como se hace un formulario trabajando con el objeto entero y no solo con atributos  http://acodigo.blogspot.com/2017/04/spring-mvc-validar-formularios.html
                                                      http://acodigo.blogspot.com/2017/04/spring-mvc-validar-formularios.html
        + INFO DE THYMELEAF: https://frontbackend.com/thymeleaf/working-with-forms-in-thymeleaf (VALIDACIONES CON THYMELEAF)
                             th:field : se utiliza para vincular entradas con propiedades en el bean de respaldo de formulario,
                             th:errors - atributo que contiene errores de validación de formulario,
                             th:errorclass : clase CSS que se agregará a una entrada de formulario si un campo específico tiene errores de validación,
                             th:object : un atributo que contiene un objeto de comando (objeto de bean de formulario principal) que es una representación de formulario en el lado del backend.
        En proyecto cuando me salga un error 500(error interno) debuguear para solucionarlo.
        En proyecto le saque del pom las modificaciones para el mail para que no me hagan pishing
        En proyecto si hay un libro con una relación por ejemplo de autor antes de eliminar el libro para que no elimine el autor, debo poner los autores y editoriales = a null para que no se rompa 
        En proyectos NO creamos métodos eliminar porque Spring ya nos tiene métodos precreados que eliminan por id
       IMPORTANTE: https://es.stackoverflow.com/questions/73955/cual-es-la-diferencia-entre-spring-jsf-jsp
       @Transactional(readOnly = true) : https://www.arquitecturajava.com/spring-transactional-readonly-y-optimizaciones/ 
                                         https://stackoverflow.com/questions/1614139/spring-transactional-read-only-propagation
       @Transactional y Controladores  : https://stackoverflow.com/questions/23118789/why-we-shouldnt-make-a-spring-mvc-controller-transactional?noredirect=1&lq=1
        MultipartFile : -  https://www.baeldung.com/spring-multipartfile-to-file
                        -  https://swagger.io/docs/specification/describing-request-body/multipart-requests/
                        -  https://www.geeksforgeeks.org/define-multipart-form-data/
                        -  https://www.bezkoder.com/spring-boot-upload-csv-file/        
                        -  https://www.codegrepper.com/code-examples/java/file+to+multipartfile+in+java
                        -  https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/multipart/MultipartFile.html
                        -  https://stackoverflow.com/questions/16648549/converting-file-to-multipartfile
        URI, URL, URN : -  https://ginzo.tech/blog/diferencia-entre-url-y-uri/
                        -  https://www.arimetrics.com/glosario-digital/uri
        @RequestParam vs @PathVariable : -  https://es.stackoverflow.com/questions/380131/cual-es-basicamente-la-diferencia-entre-la-anotacion-requestparam-y-pathvari#:~:text=Mi%20recomendaci%C3%B3n%20es%20que%20uses,un%20recurso%20o%20entidad%20%C3%BAnica.
                                         -  https://www.iteramos.com/pregunta/48857/requestparam-vs-pathvariable
        Info de consultas a la Base de datos avanzadas: el que dice 137 --> https://stackoverflow.com/questions/21456494/spring-jpa-query-with-like 
        endpoints: buscar info
        API restful: buscar info(@RequestParam vs @PathVariable- link de stack)
        scope: buscar info(sale en el html de thymeleaf)
        Documentación thymeleaf
        Enum repasar
        BUSCAR INFO (claseServiceUsuario) --> ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                        HttpSession session = attr.getRequest().getSession(true);        

                  POSIBLE RECURSO DE ESTUDIO - http://www.profesor-p.com/2-spring/
        DOCUMENTACIÓN: 
                                             - https://docs.spring.io/spring-restdocs/docs/current/reference/html5/
                                             - https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#application-properties.templating.spring.thymeleaf.reactive.media-types
                                             - https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#web
                                             - https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-http2
        
        Dato: RESTful API is an architectural style for an application program interface (API) that uses HTTP requests to access and use data. That data can be used to GET, PUT, POST and DELETE data types, which refers to the reading, updating, creating and deleting of operations concerning resources.
        
        Curso de Spring Boot 9hs, Spring DATA JPA, Spring Security: https://www.youtube.com/watch?v=zvR-Oif_nxg
        Curso de Spring Boot Aplication CRUD: https://www.youtube.com/watch?v=TW5PD_TJMXo
        Crear una API REST desde cero con Spring Boot https://www.youtube.com/watch?v=jO-o3qQZDuU
        Introducción a Spring MVC + Thymeleaf usando Spring Boot  https://www.youtube.com/watch?v=bVM6MX-dGJI
        7.-Desarrollo Web con Spring: Petición POST a través de formulario https://www.youtube.com/watch?v=rTDKYXZc178
        Curso PHP MYSQL SWEETALERT Y BOOTSTRAP: https://www.youtube.com/watch?v=nWKREPF8xyk
        Desarrollar Api Rest con Java Spring Boot https://www.youtube.com/watch?v=vTu2HQrXtyw
        Conceptos básicos: Spring framework, Spring MVC y Spring Boot  https://www.youtube.com/watch?v=cTozN8W6FGo
        Inicio de sesión y registro de usuarios con Spring Security + Thymeleaf + MySQL y Bootstrap https://www.youtube.com/watch?v=0wTsLRxS3gA&t=6s
        
        ========================== Charla Informativa =========================== 
        
        Para usar Spring tenemos 2 opciones: 1)Podemos usar STS que es como el propio id de Spring o 2) Un Pluggin en Netbeans 
        
       ===================== Guia Programación Web =============================
       ----------------- Notas -----------------
        Pág 8 POM: Project Object Model
               jar: Un archivo JAR es un tipo de archivo que permite ejecutar aplicaciones y herramientas escritas en el lenguaje Java. Las siglas están deliberadamente escogidas para que coincidan con la palabra inglesa "jar". Los archivos JAR están comprimidos con el formato ZIP y cambiada su extensión a .jar
               DI(Dependency Injector): Inyector de Dependencias
               Añadir dependencias a nuestro proyecto
               POJO significa Plain Old Java Object. Se trata de un objeto Java común, no vinculado por ninguna restricción especial que no sea forzada por la especificación de lenguaje Java y que no requiera ninguna ruta de clase. POJOs se utilizan para aumentar la legibilidad y la reutilización de un programa
        Pág 9 Funcionalidades Spring
        Pág 13 Tipo de Inyección de dependencias:
                                                -Constructor: instanciamos la clase sin usar el new
                                                -Setter: Con método setter
        Pág 14 Anotaciones
        Pág 18 URI es la abreviatura de Uniform Resource Identifier, en español identificador uniforme de recursos. Este término genérico se emplea para todos los tipos de nombres y direcciones que se refieren a objetos internet tales como páginas, imágenes, videos, etc.
        Un URI es por tanto una cadena de caracteres que se utilizan para identificar un recurso o un nombre en internet. Su propósito es permitir la interacción entre diferentes recursos en Internet y otro tipo de red. 
        Mi recomendación es que uses la anotación @RequestParam para filtrar una consulta, y la anotación @PathVariable para identificar un recurso o entidad única. (Info al final de info de complementaria/URI/stackOver...)
       
        ===================== Intro Spring Parte 1 - Mañana ====================
       
        Dice lo mismo que V1 de Videos Egg
        Metodo POST: Generalmente se emplean cuando llenamos formularios
        Min 6 Maven
        Min 7 POM--> Dentro del POM va a estar la configuración general del proyecto, manejo de dependecias
        Min 9 Spring Framework: tiene Arquitectura de capas, donde cada capa contiene objetos con responsbilidades similares, las capas superiores tienen conocimiento de las inferiores pero no al revés. Seria como cuando usabamos el servicio, DAO y el Main.
              Spring MVC
        Min 10 Capas IMPORTANTE GRÁFICO
        Min 11 Anotaciones
        Min 15 crear Proyecto de String con String Initializr
        Min 17 Por convención en Group se escribe la url de atrás hacia adelante (ej: com.example), en Package Name se escribe solo el nombre del paquete, tenemos que trabajar dentro de este paquete siempre pq sino SpringBoot le cuesta deployar el proyecto
               en Name lo que queramos pero ese va a ser el nombre de nuestra carpeta del proyecto (min 37)
               en Packagin podemos elegir jar o war, tienen diferentes formas de estructurar los archivos al trabajar pero cuando es un proyecto grande y nosotros queremos subirlo despues a algún lugar a veces es mejor trabajar con war porque genera un archivo de web aplication y jar trabaja con archivos más separados (min 38)
        Min 19 Vemos donde lo descargamos el zip, extraemos, lo abrimos desde Netbeans ya extraido
        Min 21 Generalmente nos va a aparecer con unloadable, entonces apretamos encima click derecho y Clean and Build, lo que esto hace es empezar a construir el proyecto, descargar las dependencias que le dijimos y una vez que termina nos dice que todo funciona correctamente o algo se rompió
        Min 25 En carpeta Project Files(Archivos de proyecto) se encuentra el pom, acá esta toda la info del proyecto
        Min 26 En pom existe otra etiqueta que es versión que es donde nosotros ponemos la versión de la dependencia pero con Spring Boot no hace falta poner la versión ya que solo busca la versión compatible 
        Min 27 También tenemos nuestro paquete Source Packages donde tenemos nuestro Main
               Nosotros tenemos que trabajar desde el paquete lauti.egg.mendoza, cuando creemos entidades por ejemplo debe ser desde ahí que creamos el paquete
        Min 28 También tenemos la carpeta Other Source --> src/main/resources --> <default package> : Acá es donde van algunas configuraciones para la base de datos, para alguna de las dependencias que utilicemos. 
                                                                              --> static : Acá es donde va el css, las imágenes
                                                                              --> templates : Acá es donde va el html
        Min 30 Corremos el programa (como dice el profe o click derecho al proyecto y run), para hacerlo como dice el profe no debemos estar parados en ninguna clase 
        Min 31 Ponemos en la web localhost:8080 y nos sale error pero es bueno porque significa que anda pero que no tenemos ningún html cargado
               En el output si nos dice " Tomcat initialized with port(s): 8080 (http) " Tomcat es el servidor que nos provee Spring
        Min 32 Muy Importante frenar el proyecto actual cuando le demos run de nuevo, sino se rompe porque el puerto 8080 ya está en uso
        Min 35 crea de nuevo proyecto desde la web
        Min 36 Explicación de lo que nos sale en el pom
        min 37 en Name lo que queramos pero ese va a ser el nombre de nuestra carpeta del proyecto 
        Min 38 en Packagin podemos elegir jar o war, tienen diferentes formas de estructurar los archivos al trabajar pero cuando es un proyecto grande y nosotros queremos subirlo despues a algún lugar a veces es mejor trabajar con war porque genera un archivo de web aplication y jar trabaja con archivos más separados
        Min 40 desde netbeans vamos a utilizar un plugin
        Min 45 Que es repositorio
        Min 48 Con las dependencias no vamos a tener la unidad de persistencia, no vamos a tener que crear el entity manager
       
       ===================== Intro Spring Parte 1 - Tarde ======================
       
        Min 6 HTTP MIME: tipo estandarizado de señalar cierto formato de nuestros archivos
        Min 9 Gráfico de peticiones y respuestas
        Min 10 dudas compañeros
        Min 11 Renderizar: Es cuando vos mostras lo que tu servidor te entrega, cuando abriamos el OpenLiveServer en HTML para ver lo que teniamos en código en el navegador
        Min 12 Postmat
        Min 14 GET cuando yo quiera solicitar algo y POST cuando yo quiera enviar algo a mi servidor(ej: cuando guardo un usuario, me registro a una página, ahí envío mi info al servidor)
        Min 14:52 TODOS LOS MÉTODOS QUE EXISTEN, nosotros por ahora veremos GET y POST
        Min 17 Headers, acá es donde entra la parte del MIME. El Header va a contener cierta información de la respuesta, es decir METADATA de nuestro servidor
        Min 26 F12 ver partes de la página
        Min 30 Para usar Spring tenemos que tener configurado Maven
        Min 33 Estamos en la página de Spring(Vamos a Projects y ahi nos sales los subproyectos )Elemento Padre Spring y subproyectos de Spring: SpringBoot, SpringCloud, SpringData Spring Batch, Spring Secutiry.
        Min 34 El pluggin es para que nosotros podamos generar desde NetBeans proyectos en Spring, ahora el profe nos enseña esta otra forma de generarlos
        Min 36 Nosotros vamos a utilizar Spring Boot(lo que más se pide en las empresas), no usaremos Spring de forma directa porque sino deberiamos hacer muchas configuraciones manualmente
        Min 37 Spring Boot toma las facilidades de Spring y nos permite otras autoconfiguraciones para que nosotros no las hagamos manualmente
        Min 39 Nosotros vamos a hacer un Monolito(mi front y mi back están integrados en el mismo proyecto), lo malo de esto es que si mi proyecto deja de funcionar toda mi aplicación va a fallar, lo bueno son los microservicios que sirven para segmentar mi app, se usa demasiado en las empresas grandes
        Min 40-44 IMPORTANTE Microservicios (La parte de microservicios la desarrollan programadores que tienen mucho conocimiento en Spring Boot y gran experiencia, a eso debemos apuntar en un futuro como programadores)
        Min 45 IMPORTANTE Con Spring primero tenemos que aprender lo que vemos en el curso, después por nuestra cuenta hacer API REST y despues como 3ra etapa integrar eso en un microservicio
        Min 46 Página de Spring --> vamos a Projects --> Spring Initializer
        Min 47 = Min 15 Clase 1 Mañana
        Min 49 en Group pongo el dominio al revéz, en Artifact ponemos lo que nosotros queramos, en Name lo que queramos pero ese va a ser el nombre de nuestra carpeta del proyecto, el package es una combinación del group y del Artifact
        Min 51 Vamos a usar una dependencia(dependencia = libreria)
        Min 52 En los videos de Youtube el profe implementa muchas dependencias que requieren configuracion como seguridad y la base de datos(No es necesario hacerlo a esta altura, estar tranquilos que ya lo vamos a ver), entonces por ahora evitar la dependencia de security y mysql
        Min 53 Utilizamos la dependencia Spring Web, esto nos provee que podamos crear aplicaciones con arquitectura con MVC, Aplicaciones REST y nos provee un servidor. Si nosotros no usamos Spring tenemos que instalar un servidor independiente,configurar ese servidor
        Min 54 Vemos donde lo descargamos el zip, extraemos, lo abrimos desde Netbeans ya extraido
        Min 55 Carpetas de nuestro proyecto, tenemos nuestro paquete Source Packages donde tenemos nuestro Main, en el Main ya no vamos a generar código. En la linea 6 del Main tenemos una anotación->
               -> @SpringBootApplication: SpringBoot para su funcionamiento necesita cierta estructura, esta anotación lo que hace es habilitar cierta onfiguración y realiza el escaneo de componentes(cuando se levanta la Aplicación SpringBoot y yo tengo habilitado el escaneo de componentes, 
                                          va a ir a rastrear ciertas clases de aplicacion y las va a integar a un proyecto Spring, mañana lo vemos mejor)
               Tenemos nuestras carpetas de Testeo,También tenemos la carpeta Other Source(es donde nosotros vamos a configurar nuestra aplicación) --> src/main/resources --> <default package> --> application.properties: Acá es donde van algunas configuraciones para la base de datos, para alguna de las dependencias que utilicemos y JDBC. 
                                                                                                                                                    --> static : Acá es donde va el css, las imágenes
                                                                                                                                                    --> templates : Acá es donde va el html  , la conexión con la base de datos 
               En carpeta Project Files(Archivos de proyecto) se encuentra el pom, es un archivo que tiene mucha METADATA de nuestro proyecto (Min 1:03)
        Min 1:00 Debemos crear todo dentro del mismo paquete, el que creamos al crear el proyecto, sino Spring no lo puede reconocer
        Min 1:04 Vemos el pom
        Min 1:05 Vamos a correr la app
        Min 1:06 MAVEN gestiona las dependencias, las descarga solo una vez y ya quedan guardadas para futuros proyectos
        Min 1:07 TomCat
        Min 1:08 localhost:8080 --> 8080 es el puerto por defecto de Sprin Boot como en mysql que era el 306
        Min 1:09 En application.properties es donde establecemos nuestra configuración de la aplicaciónm si queremos configurar la base de datos es acá
       
       ===================== Intro Spring Parte 2- Mañana ======================
       
        Min 1 Vamos a la pág Sprin Initializer a descargar más dependencias en el proyecto que descargamos la clase pasada
        Min 2 Vamos a necesitar 3 dependencias, MySQL DRIVER, Spring Data JPA( Motor para persistir datos de JPA), Thymeleaf (por ahora nos va a permitir mostrar html en las vistas(pagina de localhost) pero tiene mas funcionalidades)
        Min 5 ERROR en consola por que no configuramos MySQL DRIVER(error de url) y Spring Data JPA, lo solucinamos en clase, tenemos que configurar la conexion a la base de datos y el url(este error nos tira en la clase)
        Min 6 Solución de ERROR, vamos a Other Source --> src/main/resources --> <default package> --> application.properties: acá es donde nosotros configurariamos nuestro proyecto, en esto de mysql y jpa configurar usuario, contraseña, el driver que nosotros vamos a utilizar, como vamos a querer que trabajen, que guarden los datos
        Min 7 application.properties (lo que haciamos en JDBC manual): 
              Primero TODO lo que es MYSQL
              2 linea configura el data source, setea el url a la base de datos que nos queremos conectar y la url tiene algunas cosas más por ej el "useSSL=false" para que no nos tire unos WARNING. También dice ejemplo4 porque ya tiene creada la base de datos a ese nombre
              3 linea setea el usuario
              4 linea setea la contraeña
              5 linea setea el driver: un poco distinto tambien al que usabamos en jdbc
              LUEGO JPA
              7 linea a traves de formularios o hagamos cosas que alteren las tablas, nos lo va a mostrar en la consola, ej: para crear una persona 
              8 linea Se actualizan las tablas y todo si es que agregamos un atributo nuevo o algo por el estilo
              9 linea dialecto que usa JPA, que es como almacena datos en la base de datos, esta es en base a primary key
              THYMELEAF
              10 linea "spring.thymeleaf.cache= false" es para que no guarde archivos basura
        Min 13 creamos el html, vamos a templates, new (vemos si sale html ahí sino-->), other y ahi le damos ok a html, le ponemos el nombre que queramos y la creamos
        Min 14 corremos de nuevo el programa y nos muestra el html, pero para enviar información tenemos que usar los controladores
        Min 16 Controladores: creamos clase y le ponemos estas anotaciones--> @Controller @RequestMapping
        Min 17 @Controller @RequestMapping(ej si pongo /persona en la pagina entonces va a buscar un controlador que en RequestMapping diga /persona, pero si lo dejo vacío y en la pagina web no pongo nada, va a entender que tiene que ir al controlador actual)
        Min 18 @GetMapping 
        Min 26 Los repositorios serian nuestros nuevos DAOs donde estarian todos los métodos y las QUERYS 
       
       ====================== Intro Spring Parte 2- Tarde ======================
       
        Min 1 Maven es una herramienta para construir proyectos, Spring es un framework para crear páginas Web
        Min 2 Arquitectura de capas 
        Min 3 GRÁFICO DE MVC: El usuario va a ver el HTML en su navegador y va a enviar info al Controlador(es el que gestiona, portero del edificio), tenemos nuestra capa servicio que se ecarga de la lógica, el servicio nunca se comunica con el html, el repositorio se comunica con la base de datos, 
              pero mi html no sabe que existe la base de datos
        Min 4 Por comodidad es común que nosotros hagamos una búsqueda de un usuario directamente en el controlador haciendo uso de la clase repositorio NO DEBEMOS HACERLO para evitar futuros errores.
        Min 5 Las entidades se comunican solo con el repositorio
        Min 8 Explicación de anotaciones @Entity, @Service, @Transactional, @Repository, @Controller
        Min 9 Vamos a crear Proyecto siguiendo los pdfs de PASO 1 Y 2 
        Min 12 PASO 2 Vamos a crear Proyecto desde Netbeans
        Min 15 Principal beneficio de STS es que podemos debuggear sin conflictos, en cambio en Netbeans a veces pueden surgir algún conflicto
        Min 17 por protocolo el Group y el artefacto tienen que ir com.loquesea (osea seria el dominio que van a tener). 
               Jar: es un poco más rapido y no puedo modificar el sountac ¿?
               War: Si nosotros exportaramos nuestro proyecto a un servidor no local no vamos a tener conflicto de hacer cambios en la arquitectura, por ahora los dos nos sirven por igual
        Min 19 Dependencias: Son cajitas de herramientas que yo dejo precargadas en mi proyecto y el dia de mañana no voy a tener conflicto de versiones. La del correo electronico la puedo agregar después
               Spring Boot DevTools: es para cuando nosotros estemos corriendo el programa detecte si hacemos algún cambio y se cambia de manera automática
               Thymeleaf: Nos permite hacer nuestros HTML dinámicos
               Spring Security: Uno de los fuertes de los proyectos Spring
        Min 22 Cuando nosotros creamos el proyecto se abre solo el pom
        Min 23 pom
        Min 24 creamos base de datos
        Min 25 modificamos application.properties : Acá también pondriamos en un futuro la configuración de un correo electrónico si queremos enviar notificaciones
        Min 27 Paso 8 de Guia 1, los Controladores son los gestores de habilitar y deshabilitar las rutas adonde yo voy accediendo
        Min 28 Creo Controlador, toda carpeta debe nacer de la única carpeta creada del proyecto
        Min 34 Dudas Maven es una arquitectura de proyecto y Spring Framework que va a necesitar de Maven
        Min 35 Creo clase Controlador (en pdf Paso 1 sale)
        Min 36 @GetMapping("/") : este controlador nos va a decir que cuando yo ingrese a este mapeo que hace las rutas de las peticiones, cuando ingreso al portal inicial va a entrar y retornar index.html
        Min 38 Por protocolo y buenas practicas la pagina de inicio de cualquier página se debe llamar index.html
        Min 39 los html van en templates y las imágenes, estilos de bootstrap van en static porque no tienen relación. El html lo puedo hacer en visual y lo pego después
        Min 40 Paso 9 en Navigator pongo SpringBoot run
        Min 42 Diferencia de cuando lo corrimos con Profe Cristian, debemos acordarnos que es un servidor y el servidor siempre va a estar corriendo, además como yo elegí mi dependencia Spring Security y no la configuro, por defecto Spring me genera un password
        Min 44 En usuario ponemos user y en contra la contra que nos dieron
        
       =============== Entidades y Repositorios Spring - Mañana ================
       
        Min 1 Entidades es muy parecido a lo que haciamos con JPA, para que la Base de datos entienda que estas clases van a ser tablas, tenemos que definirlas como entidades con @Entity y toda entidad tenia que tener una anotación @Id
        Min 3 Forma de hacer los id como se hacen en los proyectos reales, se usa un generador de tipo universal, uuid(identificador unico universal) y vamos a usar una estrategia de identificador uuid2
        Min 6 Hacemos relación ManyToOne pero no bidireccional
        Min 7 Si yo no tengo constructor por defecto la entidad entiende que existe un constructor vació con default, si ya existe un constructor vamos a tener que crear el constructor vacío tambien si queremos usarlo
        Min 8 Como las id se generan automaticamente tal vez no hace falta ponerlas en el constructor
        Min 10 Como a todas las entidades le poniamos arriba @Entity, a todos los repos le ponemos @Repository. Los repos son interfaces
        Min 11 extends JpaRepository
        Min 14 Métodos de Repository que usamos mucho: save, findById, findAll, delete
        Min 17 @Query
        Min 18 antes nosotros usabamos el .setParameter ahora vamos a usar una anotacion que se va allamar Param
        Min 19 Para buscar por id lo que te devuelve el método es un objeto de tipo Optional
        Min 20 creamos un método para que nos devuelva un objeto Persona y no un Option
        Min 31:26 método delete para eliminar
        
        ================ Entidades y Repositorios Spring - Tarde ===============
       
        Min 2 Spring Data JPA lo que hace es trabajar la parte de persistencia de datos
        Min 3 Spring data se divide en muchos subproyectos, uno es JPA, otro puede ser MongoDB que son Base de Datos no relaciones, o con MYSQL o con PostGress
        Min 4 Nosotros vamos a trabajar con Spring Data JPA que es la API de persistencia de Java
        Min 5 Cuando nosotros vimos JPA lo que hicimos fue trabajarlo con Eclipse Link pero el más usado es Hibernate, ahora con Spring Data JPA lo hacemos con Hibernate
              Dependencias que deberiamos tener en nuestro proyecto
        Min 9 En los videos Sebastian hace una combinación alfanumérica de Id, en esta clase lo vamos a hacer solo de numeros, en @GeneratedValue entre parentesis le tenemos que colocar la estrategia, sino se pone solo en auto incremental
              Va a poner por defecto lo que seria(estrategy = GenerationType.IDENTITY)
        Min 10 anotacion Column() nos sirve para que solamente se puedan crear usuarios que tengan nomre y apellido, quiero que sea un campo obligatorio
        Min 12 Consulta Importante Compañera: Si yo le pongo el @Column en nuestro diseño de entidad relación este campo en la base de datos va a estar con el color celeste por lo que va a ser obligatorio. NO VA A REEMPLAZAR las excecpciones, si yo le mando por ejemplo a la BD sin un nombre, en la BD se va a generar la excepción
               Yo tengo que controlarla antes, osea en Java
        Min 18 Si yo planteo un OneToMany en Usuario con mascotas, en mascotas tengo que plantear ManyToOne(la relación inversa) y asi planteamos una relación bidireccional
        Min 21 Lo podemos trabajar de varias formas: de manera bidireccional pero lo que pasa es que se genera la tabla intermedia, cuando trabajamos con listas y esa lista esta relacionada a otra entidad siempre se genera una tabla intermedia,
               esta tabla intermedia se pide evitarla para que haya un buen diseño de base de datos, igualmente en algunos casos es imposible obviar la tabla intermedia pero en este caso OneToMany y ManyToOne se puede obviar de algún lado
        Min 22 Entonces si nosotros queremos trabajarla de manera bidireccional tenemos que usar el mappedby --> @OneToMany(mappedBy = "usuario") , entre "" va el nombre del atributo con el que lo voy a relacionar en la otra clase
               Con esto establezco que en la base de datos no se grafique una relación, una tabla intermedia pero si en Java por ende a la entidad Mascota le asignamos la entidad de la relación
        Min 25 EXPLICACIÓN IMPORTANTE, la propietaria de la relación va a ser la entidad mascota porque es la que tiene llave foránea
        Min 26 Que pasa si yo no coloco el mappedby
        Min 32 EXPLICACIÓN IMPORTANTE, la tabla intermedia me permite hacer una relación de Uno a Muchos y Muchos a Uno
        Min 38 Porque usamos Mappedby
        Min 46 Donde ponemos el MappedBy? Donde nosotros no queremos que se genere el campo extra
        Min 50 Que pasa si hacemos una relación OneToOne en las 2 entidades sin el mappedby? No es eficiente
        Min 59 Tabla intermedia: cuando manejo listas se crea la tabla intermedia si o si
        Min 1:01 RESUMEN EXPLICACIÓN 
        Min 1:02 Creación repositorios
        Min 1:04 La forma de trabajar de Spring Data JPA no es a través del Entity Manager aunque internamente sigue actuando
        Min 1:04 Cuando teniamos la anotación SpringBootAplication se generaba una autoconfiguración y un escaneo de componentes, @Repository es un componente que yo le digo a Spring, cuando levantes la aplicación registrame esta interface
        Lo que nosotros haciamos antes con los DAOs ahora lo hacemos con los repositorios osea de interfaces
        Esta interface va a extender de otra interface
        Cada entidad tiene que tener un repositorio, en el diamante(estructura con < >) en primer lugar yo pongo el nombre de la entidad y en 2do lugar yo pongo el tipo de dato del id de esta entidad
        De esta forma vamos a poder acceder a metodos como antes usabamos el merge,commit,etc
        Min 1:09 JpaRepository a su vez extiende de otra clase y esta de otra y asi, generando un hilo de herencias.
        
        ======================= Servicios Spring - Mañana ======================
        
        Min 2 anotación @Autowired: Spring va a instanciar la clase por nosotros, es decir, va a crear un objeto y cuando lo necesite alguna clase usar lo va a mandar solamente a ese objeto
        Min 4 Creación métodos
        Min 10 En método modificar podemos traer las variables por separado o el objeto completo
        Min 15 @Transactional: Lo usamos para todas las transacciones, tiene el rollback por defecto. Se lo ponemos al de las validaciones porque tiene una llamada a la base de datos(buscarporDNI)
        Min 17 Como nosotros trabajamos en función de capas lo único que vamos a poder llamar desde ServicioPersona: es PersonaRepositorio pr y ServicioCiudad cs. Porque como buena práctica podemos llamar solo al repoitorio de Persona y a los otros servicios de las otras entidades, por ejemplo a CiudadRepositorio no la podemos llamar
        Min 18 Lo mismo nos va a pasar en los Controladores vamos a llamar a Servicio, NUNCA DEBEMOS LLAMAR DESDE LOS CONTROLADORES A LOS REPOSITORIOS
        Min 20 findById con Optional: nos trae un Optional, no la persona en sí, entonces para obtener a la persona tenems
        Min 26 Hay que hacer una sola página o muchos? cuando trabajo solo con uno usando JavaScript uso simplePageAplication. Es preferible hacer varios HTML 
        Min 27 findById con Optional y sin Optional
        Min 28 Cuando uso @Transactional 
        Min 29 Buscar por Id cuando es un String largo, los id van a viajar por la url, se ve mejor en thymeleaf
        Min 30 Cuando hacemos un buscador, no buscamos por Id porque no lo conozco, sino que lo buscamos por DNI que es un atributo único
        Min 31 Relación ciudad y persona: 2 posibilidades: 
                        1) Usar el cascade para que cuando creemos la persona con la ciudad, se cree la ciudad directamente
        Min 32-36       2) Crear la ciudad y una vez que creamos la ciudad, crear recién ahi a la persona(método public Ciudad buscarporId). 2 formas: 1)Que tire el ERROR de que no existe en la BD y crear un formulario aparte que te cree la ciudad y cuando la vas creando que te muestre todas las ciudades que ya han sido creadas
        Min 37-43                                                                                                    2)Que en el mismo formulario general, te crea la Ciudad si vos ponés guardar.
        Min 43/44  Proyecto del Profe Libreria, vemos LibroServicio método crearLibro
        Min 48-49 Profe trabaja los try and Catch en los controladores, los muestra. Si sucede una excepción en el repositorio no hace falta arrojarla y volverla a atrapar en el servicio y después en el controlador
                  Muestra CONTROLADOR DE LIBRO
        Min 54 Pasos para crear Proyecto: creo las entidades, luego los repositorios con sus querys, los servicios y los controladores. El profe creaba una vista y en función a eso creaba el controlador.
               A veces para crear el controlador necesitas tener creada la vista para ver donde va X botón que haga tal cosa y de ahí saco la lógica para hacer el html con thymeleaf, es como el controlador y las vistas van más en conjunto 
        
        ======================= Servicios Spring - Tarde =======================
        
        Min 1 Vamos a usar el Proyecto Perros 1 subido en GitHub
              Los servicios deben contener todas las lógicas necesarias para procesar las transacciones de negocios(alta,baja,modific,busqueda,etc)
              Siempre Servicio se comunica con el repositorio
        Min 2 anotación @AutoWired instancia los objetos de manera automática y a su vez, si yo cree una instancia de perro repositorio en otra clase(que no debería hacerlo), con esta anotación lo que hace es ir y buscar esa instancia, 
              es decir un proyecto crea una única instancia de esta clase que estoy llamando. Por lo tanto esto optimiza el rendimiento de mi proyecto. el @AutoWired reemplaza a cuando haciamos el " = new Perro() "
              Lo que hace no es que vas a crear una nueva instancia, sino que busca en memoria si ve que existe el espacio de memoria ya utilizado para esto la utiliza
        Min 5 Si yo no le creo constructor, por defecto tiene un constructor vacío que puedo llamar
        Min 7 anotación @AutoWired no es la capacidad que yo tengo de esta anotacion para crear un espacio de memoria de un molde, a crear una instancia de una clase para hacer uso de sus recursos esa es la diferencia principal
              Seteo los datos ingresados
        Min 8 Seteo booleano, seteo date (fecha)-> le pone new date porque le pone la fecha actual por eso no trae ninguna fecha
        Min 9 Crea el método crearPersona
              Método de Repositorio predeterminado: .save
        Min 10 Las excepciones tienen 3 estadios para ser controladas: 
               1) Utiliza el HTML: verifico que el input que yo uso en mi html sea especifico al dato que quiero recibir, NO puede ser la única porque el HTML es muy inseguro. 
               2) Verificar en mi controlador si yo quiero que este dato sea requerido, usamos @Request (Param = true or false) es decir si quiero obligar al usuario que ponga o no un dato
               3) En mi Servicio puedo dejarla dentro del metodo(como haciamos en proyectos anteriores) o haciendo un método para validar en base a los criterios de la lógica de negocio que yo quiero inventar
        Min 11:30 muestra método de validación que tiene ella en su clase
        Min 12 Con el .save ya se está guardando el objeto en la base de datos aunque sea un void. Como si lo hiciera a través del DAO
               Casi todas las anotaciones tienen atributos especificos que yo puedo hacer uso, uno de estos es propagation que es de @Transactional
        Min 13 @Transactional debo ponerla en todo método que manipule la base de datos si no lo ponemos trabaja mal internamente aunque no de ERROR. El @Transactional le advierte que al procesar los datos hace un duplicado del objeto para luego mandarlo si esta bien
               Este atributo propagation es una forma de como pueden comportarse las transacciones, poniendole la anotacion rollbackFor se hace de forma directa. Por defecto esta transaccion nace con esos atributos asi que no es necesario ponerlos
        Min 15 Hay otras Transacciones que podemos tener, IMPORTANTE vemos PDF de la Profe sobre anotaciones y distintos tipos de propagation de la anotación Transaction
               @Transactional(readOnly = true) -> Optimiza el funcionamiento de mi aplicación, SÓLO SE USA SI SON OPERACIONES DE CONSULTA
        Min 18 Transaction a importar es la de Spring, NO javax
        Min 19 Método validar y funcionamiento Excepciones
        Min 20 Método perro alta y baja
        Min 21 Si quiero establecer un parámetro requerido lo tengo que hacer en el controlador al try and catch
        Min 22 Porque no uso try and catch? Si yo quiero un parámetro requerido lo voy a hacer desde el try and catch en el CONTROLADOR
        Min 23 Estoy agarrando la excepción (en el método validación), la estoy tirando y después la va a agarrar el controlador con el html
        Min 25 Uso de QUERYS(anotaciones), casitodas las que ya vienen con Spring
        Min 29 @Transactional(readOnly = true) : cuando yo tengo que hacer métodos de consulta en mi base de datos debo avisarle a JPA que es una transacción, pero con esto le aviso que es solo una consulta para que no me haga una duplicación del Objeto en memoria para ver
               si en algún momento lo modifica,guarda o pega en la base de datos. Entonces si el método es de consulta ponemos la anotación readOnly y en unn futuro cuando tengamos una base de datos con miles de registros, esto agiliza mucho las consultas
        Min 30 Método validar 
        IMPORTANTE
        Min 32 Método Optional para buscar por Id, funciona similar a cuando nosotros usabamos el Iterador en Colecciones para eliminar
               Clase UsuarioServicio usa MultipartFile archivo, BCryptPasswordEncoder(), investigar. También tiene los atributos mail y clave, idFoto
               Método public void habilitar(Método getOne),deshabilitar, public void registrar, public void modificar(usa el Optional)
        Min 33 Claves encriptadas
        Min 34 Nunca debo eliminar Información por lo que debo usar los métodos habilitar y deshabilitar
               Método getOne: Esta utilidad es relacionada al repositorio, que es un método precargado y que ya recibe un parámetro que es el Id, pero si yo quiero traer uno por correo electrónico debo traer mi QUERY específica en el repositorio
        Min 35 como en los repositorios pongo extends Jpa... NO SE CREA MÁS LA UNIDAD DE PERSISTENCIA
        Min 36 En los videos de Youtube el profe encapsula los get y set con el refactor pero es igual a como lo hacemos con el ALT e Insert
        Min 37 Si quiero eliminar: la profe dice que es preferible no eliminar algún dato deberiamos darlo de baja con un booleano por ej pero si lo queremos eliminar igual debemos tener 2 consideraciones: 
               1) Criterio de cascada que voy a tener, es decir, si creo un Autor y se elimina el Autor, se eliminan los objetos relacionados a este Autor si cree una relación. 
               2) El autor se creo solo(de forma independiente) o gracias a un libro que le dio un espacio de memoria
        Min 38 Caso: Autor tiene relacion con el libro ManyToOne que es propiedad del libro la relación. Tengo que decidir que va a pasar.
               Porque si yo tengo el autor x que tenia 4 libros y lo elimino, los libros no son eliminados pero no van a tener Autor. Entonces si lo quiero eliminar tengo que ponerle el atributo cascade en las entidades
        Min 40 Para usar el findById con cualquier tipo de Id(Integer o String)tengo que utilizar la clase Optional sino se puede utilizar getOne pero se encuentra obsoleta
        Min 42 INNER JOIN: NO es necesario hacerlos porque... ver video
        
        =================== THYMELEAF + CONTROLLER - Mañana ====================
        
        Min 1 Es un motor de plantillas(plantillas serian los templates, osea los html)
        Min 2 Usa template Suits
        Min 3 vemos entidad Perro de proyecto PerroV1
        Min 5 dependencia de thymeleaf
        Min 6 Main Controller, le ponemos @Controller a la clase
        Min 7 @RequestMapping es la URL que va a escuchar a este controlador. Si le ponemos localhost:8080 es lo mismo que poner solo la "/"
              Si yo tengo @RequestMapping("/usuario") la URL en la que yo llamaria a toda esta clase seria localhost:8080/usuario
              En el caso de los index no se le coloca nada
        Min 9 En el método, en el return debemos retornar el nombre de nuestro html
        Min 10 @GetMapping : a través de una operación GET vamos a acceder a una URL desde la barra. Esta notación seria a lo que llamamos verbos HTTP o métodos HTTP, y estos métodos lo que hacen es definir la acción que se va a realizar sobre un determinado recurso
        Min 11 Diferencia entre GET y POST :
                                            - GET se utiliza únicamente para consultar información al servidor, podemos decir que es muy parecido a realizar un SELECT(pq cuando hacemos un select hacemos una petición a la BD  para que nos traiga info) en la BD
                                            - POST es utilizado para solicitar la creación de un nuevo registro, parecido a cuando hacemos un INSERT en la BD, es la creación de algo nuevo
        Min 14 Nuestro index lo que va a hacer es renderizar. RENDERIZAR: Mostrar una Vista, mostrarla, plasmarla, armarla
        Min 15 Muestra el index, también los th que necesitamos para tener thymeleaf y spring security, con esta linea de codigo ya vamos a poder implementar etiquetas dinámicas adentro del html
        Min 18 muestra Perro Controller
        Min 21 Con el @Autowired inicializamos la clase PerroService
        Min 22 Los controladores son los que se comunican con la Vista(templates) y el Back mediante los servicios. Se manejan solo con las lógicas de vistas, decide que info viene y va que peticiones hacemos y que se muestra en la vista
        Min 25 vamos a hacer todo lo que es el CRUD (Registro,modificación y baja pq eliminación esta explic en los videos)
        Min 25:59 muestra todo el html de form perro
        Min 26 formulario
               @GetMapping va a renderizar esta vista(return form-perro) cuando mi URL sea la del coment de la linea de abajo, osea cuando entramos a esta URL te retorna el formulario
        Min 27 Método @PostMapping, desde el mismo /registro (podrian no tener el mismo nombre y cambiar el nombre del método), lo que importa es que cuando haga la misma URL me lleguen algunas determinadas variables o parametros, por ej: nombre, foto, apodo, raza
        Min 28 ModelMap, además de poder inyectar mensajes sirve para pasar valores y Collections(colecciones de valores) (en 2da lista de reproducción MVC vamos a encontrar todo esto)
        Min 29 @RequestParam indica que determinada variable es requerido para el método 
        Min 32 @PostMapping entra recién cuando tengamos un botón que haga submit sino con el @GetMapping sólo lo mostramos
               vemos PerroService: desde el Controlador llamo al servicio, al método guardar y le paso lo que quiero que guarde(el guardar perro no le pasa el objeto, sino que le pasa los atributos)
        Min 33 botón submit: el tipo submit sabe que tiene que enviar información, es importante que el botón esté dentro del formulario para que sepa que hacer
        Min 34: muestra un a que dice volver en form perro
        Min 35 vemos html y relación de @PostMapping con el a través de método POST
        Min 39 ModelMap es una clase de Java con métodos, a través del ModelMap inyecto 
        Min 40 método .put : recibe una llave? y un valor --> modelo.put("éxito","Registro exitoso"); "éxito" es la llave y "Registro exitoso" es el valor de esta llave
        Min 41 cómo hago desde el front para saber que tengo que mostrar esto? (esto= ventana emergente que dice que se realizo con éxito)
        Min 42 IMPORTANTE nos muestra html. Con el th hacemos referencia que es una etiqueta thymeleaf, poniendo th:text manejamos el texto que le queremos poner desde nuestro controlador
        Min 45 card: rectángulo gigante (verde en este caso) 
        Min 48 Vemos que pasa si lo agarra el try and catch
        Min 49 Vemos el html mas completo, vemos el formulario completo
        Min 50 Cuando seteamos valores o variables usamos el signo $, ahora que estamos haciendo un action estamos haciendo referencia a una URL, entonces le avisamos que cuando entre a la URL /perro/registro del método POST, quedaria asi --> th:action="@{/perro/registro}" method="POST" , vamos a enviar toda la información de mi formulario
        Min 51 en el model.put podemos pasarle como llave cualquier cantidad de palabras pq le pasamos el String, lo único también debemos cambiarlo en el html y siempre deben ser solo 2 parametros
        Min 52 card title
        Min 54 IMPORTANTE Duda URL, mirar clase. No se concatenan lo que tenga en el requesmapping de mi clase main con lo que tenga en mi requestmapping de cualquier otra clase
        Min 56 Método POST no puede estar declarado en el botón, se declara en el formulario 
        Min 57 href lo que hace es mandarme a una URL, si le agrego la etiqueta th: quedaria th:href="@{/}" le pongo una @, pasa lo mismo que el action(min 50), le avisamos a que ruta va a ir acá le digo
        Min 58 tabla de html común
        Min 1:00 Nueva funcionalidad de thymeleaf, que es recorrer una lista con th:each ="perro : ${perros}", funciona igual que un for each, por ejemplo acá le pasamos un auxiliar que se llama perro y le pasamos la variable entre llaves con el signo $(pesos) con una lista perros
                 Cuando sabe con que lista trabajar, de donde vienen estos perros? Eso lo vemos a través de nuestro modelo, con nuestro modelo vamos a inyectarle una lista para que thymeleaf la recorra
                 Vemos el método @GetMapping("/lista") en el controller y lo armamos de cero, uso el método que creamos en el service que trae todos
        Min 1:04 vemos el método en service Perro que lista todos (activos e inactivos)
        Min 1:06 Mandamos la lista con modelo .addAttribute. .addAttribute tiene otras funcionalidades para mandar un atributo o una colección por ej.
        Min 1:09 scope investigar
        Min 1:11 cuando queremos poner un sino, algo que equivale a un else en thymeleaf ponemos unless (th:if = if, unless = else)
        Min 1:12 referencias href--> alta,baja modificar
        Min 1:17 vemos Controller(controlador) perro completo
        Min 1:18 como sabemos que está conectado a la Base de datos? Porque en el output dice Hibernate, Hibernate utiliza JPA como motor de persistencia para poder crear nuestras tablas
        Min 1:22 como comentar en HTML <!-- blablabla -->
        Min 1:23 como damos de baja un perro
                 vemos en el controlador de perro, el método lista
        Min 1:25 vemos ERROR, hack para saber donde se nos rompe cuando nos sale en la web, ponemos CTRL + F y la palabra line y nos muestra la linea donde se rompió
                 Modificar: vemos método en el Controller
        Min 1:26 hacemos otro formulario en HTML para modificar
                 vemos la importancia del ID
        Min 1:28 Partes de una URL, PathVariable es una anotación dentro de Spring que nos sirve para configurar variables dentro de la URL(va a viajar en nuestra URL)
        Min 1:30 @PathVariable es una anotación, en este caso lo usamos con nuestro Id
        Min 1:31 le inyectamos el modelo, usa el perroService y dentro de el, el método getOne 
        Min 1:32 basicamente lo que hace es recibir el id y buscarlo mediante el servicio perro y mostrarlo en el html, que lo manda(al html) a través del modelo 
        Min 1:33:33 EXPLICACION IMPORTANTE de como funciona modificacion a través de URL
        Min 1:34:43 MODIFICAMOS html de formulario perro modificar 
                 vemos el método @PostMapping que es el que le va a mandar el perro
        Min 1:35 Mandamos el id, como se evaluan las expresiones en thymeleaf cuando queremos pasar este tipo de cosas? Existe una sintaxis: __${perro.id}__  (esto se pone en el html pero es para avisarle a thymeleaf y Spring), que hago con estos guines bajos? es una expresión de preprocesamiento que es interna y se evalua antes de la expresión, en otras palabras le estoy dando prioridad, osea que lo primero que se va a evaluar va a ser "perro.id"
                 En otras palabras le digo: "Antes de irte al controlador de modificar, evaluame cuál es el id."
                 Y una vez que tenemos el resultado del id, te permite ingresar a toda la URL de este controlador 
        Min 1:38 Hago lo mismo con el botón de modificar de list-usuario y list-libro , le agrego __${perro.id}__
        Min 1:40 etiqueta(tag) nueva de thymeleaf --> th:value se usa mucho en los input, ej: th:value=${perro.nombre}
        Min 1:42 el name de los tags tiene que coincidir con el nombre de las variables que estamos poniendo
        Min 1:43 le agregamos ModelMap modelo al @PostMapping de perro Controller
        Min 1:44 placeholder: en el caso de que no haya nada se va a mostrar lo que pusimos en el place holder en html
        Min 1:45 El id viaja pero es necesario que lo tengamos en un input oculto(hidden) para que hagamos referencia permanentemente a ese 
                 Entonces lo ideal seria ponerlo despues de declarar nuestro formulario y ponemos: <input hidden th:value= "${id}" name= "id"> para que cuando entre al id que pusimos en el formulario, nos muestre del id que hacemos referencia en el hidden, todos los valores que tenemos debajo  
        Min 1:47 lo que hace devTools es que se vayan mostrando los cambios sin tener que volver a correrlo
        Min 1:49 placeholder 
        Min 1:52 input hidden: Cuando nosotros vamos a querer modificar y utilizamos un formulario, y queremos trabajar con un objeto en específico, con una entidad que nosotros tenemos creada, necesitamos esa id para que el formulario sepa que vamos a trabajar con esa entidad, si no lo enviamos, cuando hagamos el submmit va a crear otro objeto nuevo en lugar de modificar el que nosotros modificamos ya que no tendria el id que le pasamos.
        Min 1:54 Como tiramos las excepciones que tenemos en el servicio --> e.getMessage()
        Min 1:55 Diferencia entre modelo.put y modelo.addAttribute: Para mandar una Collection es lo mismo pero el addAttribute puede mandar colecciones, mapas,objetos, string con el nombre del atributo más el objeto. La diferencia del addAttribute es que te trabaja objetos no valores
        Min 1:57 Profe en clase thy pone un return pero se lo devuelve lista vacía (mirar clase thy turno tarde min 1:28)
        
        =================== THYMELEAF + CONTROLLER - Tarde =====================
        
        Min 2 vemos atributos
        Min 3 si o si tenemos que poner @Controller para avisarle a spring que la clase es un controlador
        Min 8 muestra dependencia de thymeleaf
              Tiene 2 url de thymeleaf, 1 de thymeleaf y otra para la seguridad
        Min 14 Como pasar las referencias de los controllers sin thymeleaft, ej: 
                                                                                con th --> th:href="@{/usuario/lista}" 
                                                                                sin th -->  href="/usuario/lista"
        Min 19:10 muestra su index con los 2 botones de cargar perro y mostrar lista perros
        Min 21-23 Consulta(IMPORTANTE): Habla sobre Controladores. El profe hace un solo Controlador y ahi hace todos los métodos, pero lo ideal por buenas prácticas es que haya un controlador para cada entidad 
        Min 36: cuando en el HTML ponemos $ es porque trabajamos con variables, si es con @ trabajamos con URLs
        Min 40-41 Porque el DevTools nos sirve para cargar todo dinamico menos los controladores, pq los controladores son estáticos no dinamicos, por lo que tenemos que reiniciar el proyecto
                  Hay una forma de evitar tener que reiniciar, configurando el pom --> que estadio queremos que se configure de manera automática pero NO es recomendable pq por ej si tenes un usuario logueado, al hacer eso que se reinicia de forma automática perderias el usuario logueado
        Min 44 ERROR rollback puede ser porque están mal las validaciones en el servicio
        Min 51 __${perro.id}__ Normalmente se va a utilizar esto solo cuando hagamos referencia a los id, solo en las URL, los action o href que hagan referencia a un id
        Min 52-53 Si yo NO pongo el id dentro del formulario me va a crear un nuevo objeto de forma automática en lugar de modificar el existente
                  El id lo pongo con un input hidden
        Min 56 vemos método get One que es parecido al findbyid
        Min 59 cuando nos tira ese tipo de ERROR (error 500) ponemos CTRL + F y buscamos line asi nos dice la linea en la que vamos a tener el error
        Min 1:25 Cada vez que nosotros hacemos una modificación en la BD vamos a ver en el Output que se nos aparece --> Hibernate: Es una ORM (object relational mapping) que utiliza a JPA como motor de persistencia y lo que hace es mapear todo lo que pasa a nivel entidades y base
                 y en base a ee mapeo genera las tablas y los insert correspondientes. Por lo que cada vez que hagamos algun tipo de modificación o hagamos un método POST es muy probable que nos salga --> Hibernate: select usuario...
                 Esto está configurado en el aplication properties.
        Min 1:28 IMPORTANTE soluciona problema de video anterior con redirect que lo usa en alta y baja
        Min 1:29 IMPORTANTE métodos de alta y baja Controladores y service
        Min 1:30 En la BD nunca debemos eliminar registros
        
        ======================= Consulta - Tarde 09-11 (Profe Cristian) =========================
        
        Min 3 La seguridad la vemos al final, igual que el envío de mails es algo complementario
        Min 4 Sebastian Arbona en videos se equivoca en crear los Controladores en la parte de testeos
        Min 12 Cuando nos aparece WhiteLabel error buscamos line y vemos donde tenemos el error
        Min 14 Netbeans tira generalmente problemas en el html, ver si es importante o no es depende el caso
        Min 17:30 Duda IMPORTANTE de RELACIONES: la mejor forma de plantear una relación en este ejercicio. En Libro pone ManyToOne a Autor y en Autor no pone nada (aplicarlo en proyecto), porque un libro si o si tiene que tener una editorial y un autor
                  y la parte de autor, un autor tiene muchos libros, puede estar asociado a muchos libros, pero no es necesario en este caso, si vos querés los libros de determinado autor los podés buscar a través de libro, te ahorras el paso de crear una lista en Autor.
                  Recomendación generar la relación solo desde el lado de libro 
        Min 22 ERROR compañero
               Recomedación profe: Antes de crear un libro obligar al Usuario que cree editoriales y que cree Autores (profe)
        Min 26 Acamus: Se habia planteado que cuando se muestre un libro nos muestre una lista desplegable de los autores, si no está la que yo quiero, crearle encima uno nuevo, para esto deberiamos crear un botón que nos dirija a crear Autor y lo mismo con Editorial y una vez que lo crees vas a poder verlo en las opciones
               Profe: Mostrarle las opciones y si no lo encuentra que lo cree con un botón para agregar un autor o editorial nuevo
        Min 29:30 Profe nos muestra lo que hizo: - Hace página de libros, de autores y de editoriales
        Min 30:30 - Muestra tabla de lista-libro
                  - Muestra crear Libro(IMPORTANTE: Profe le pone primero en el dropdown seleccionar autor, para que no seleccione ninguno por defecto)
        Min 32 IMPORTANTE Debate sobre como hacer creación Autor
               Acamus:  Cuando estás creando libro creas un Autor en un constructor vacío, buscas el nombre, devuelve el nombre y te da ese autor y listo. Igualas el autor que creaste con ese que buscas. podrias tener un botón que sea crear nuevo autor dentro del formulario crear Libro
        En definitiva para crear Autor o Editorial, se puede de dos formas: 1) Mostrar dropdown + un botón para agregar un Autor si este no existe en las opciones, que deberiamos hacer una validacion en el html o nose donde de que si no ingreso nada en el dropdown pero en el input de agregar es distinto a nulo,
                                                                               Osea que agrego un nuevo autor, entonces que setee ese
                                                                            2) Poner dropdown más botón de agregar un Autor que nos derive a otra página de agregar Autor y ahi agregarlo, lo malo es que deberiamos volver a crear libro y es una paja
        Min 34 Compañero muestra su página Lista libro su tabla
               Muestra su ERROR que no le deja mostrar los libros que tiene, le muestra un String re largo y lo soluciona a medias, poniendole un toString en autor y editorial 
        Min 36 Muestra su Libro Controller  
        Min 37 Muestra su Libro Servicio y su entidad Libro, entidad Autor
        Min 39 IMPORTANTE: Más adelante nosotros vamos a utilizar una dependencia que te genera los constructores, get y sets, con anotaciones asi no los tenemos que anotar nosotros
        Min 42 Cuando vos pones el RequestParam implicitamente vos le decís que estás esperando un dato, por lo que si vos no le envias ese dato se genera un error 400 pq la solicitud que le estás enviando no se corresponde con lo que espera tu método del controlador, entonces lo que debemos hacer es:
               1) En nuestros inputs poner required simple pero no efectivo
               2) Colocar en cada RequestParam entre paréntesis(required = false) osea que si viene vacío no se rompa. No recomendado en este caso
        Min 45 Cuál es el objetivo de poner required = false? Depende del caso, pq vos podés usar el mismo controlador para muchas cosas
        Min 48 ERROR compañero,problema: puso GeneratedValue(generator = "uuid") en el id pero le puso que sea Integer y para que se autogenere de esta forma tiene que ser un String.
               Solución:(Mejor explicado min 7 clase 11-11) Si quiere seguir haciendolo con Integer en GeneratedValue debe ser "id", así GeneratedValue("id") o sino modificar el id de Integer a String
        Min 49 Muestra su entidad Usuario, entidad Producto
        Min 53 Oompañero muestra su crear Libro con dropdowns + botón Agregar autor y lo mismo en editorial
        Min 54 Muestra Autor Controller y Autor servicio(crearAutor)
               Explicación de @Transactional
        Min 55 le pone a @Transactional(readOnly = true)
        Min 55 Muestra Autor Repository

        ======================= Consulta - Tarde 11-11 (Profe Cristian) =========================
        
        Min 0 ERROR compañera: vemos Libro servicio
        Min 2 borra findall y findbyid del repositorio pq son métodos que te da Spring por defecto
        Min 3 compa tiene findByNombre con un Optional en su repo
        Min 7 lo mismo que compa de clase anterior, puso GeneratedValue(generator = "uuid") y necesita poner GeneratedValue(strategy = GenerationType.IDENTITY) que se pone cuando tu id es un Integer o Long(cuando es cualquier tipo de numero y NO String)
        Min 9 Los métodos de las interfaces por defecto son públicos, por lo que es redundante si lo ponemos
              Los métodos de las interfaces no llevan public, sólo llevan lo que devuelven y el nombre nada más
        Min 14 compañero muestra su Controller Autor (métodos alta baja lista)
        Min 18 compañero muestra su Controller Autor completo
        Min 19 compañero muestra su HTML Autor la parte del formulario
        Min 20 ERROR compañero
        Min 31 solución ERROR: era que en el html le faltaba una / a la dirección que el ponía --> "@{/autor/blabla}" 
                               Y tambien no le puso el atributo name al input por lo que no lo enviaba
        Min 33-40 ERROR Netbeans instalación con Mac creo, solución agrego una linea de código y tenía mal el maven aplicado
        Min 41 ERROR compañero en Repo
        Min 45 IDES que se pueden usar en vez de Netbeans, Eclipse o Intellige
        Min 46 compañero muestra sus páginas HTML registrar/cargar/crear Libro, Autor y Editorial
        Min 47 ERROR compañero en HTML, solución: tenia mal puesta la ruta en el HTML
        Min 48 Como debuggear/hacer debugg en Netbeans: doble click en la línea que queremos debuggear hasta quue esté con cuadrado rojo, vamos al nombre de proyecto, click derecho y ponemos Debug, 
               Luego cuando llegue a ese punto, vamos apretando F7 para ir avanzando
        Min 49 Netbeans es más fácil para lo que aprendemos, IntelliJ es más complicado y consume más recursos
        Min 50 Donde se va viendo el Debuggeo? En realidad lo que nosotros usamos es para ver las variables
        Min 53 Recomendable crear para cada Entidad un Controlador para segmentar
        Min 59 " SELECT a FROM Autor a.alta = :true " está mal porque los dos puntos se ponen cuando vos le envias una variable unicamente, por lo que deberia ser "... = true " sin ":"
        
        ======================= Spring Security - Mañana(Profe Cristian) =========================
        
        
        
        ======================= Spring Security - Tarde (Profe Cristian) =========================
        ======================= Consulta - Tarde 23-11 (Profe Cristian) =========================
        ======================= Consulta - Tarde 24-11 (Profe Cristian) =========================
        ======================= Consulta - Tarde 25-11 (Profe Cristian) =========================

        
       ###########################################################################################################################################################################################
       ##########################################################################  Sección Videos Egg ############################################################################################
       ###########################################################################################################################################################################################
        ========== Fundamentos web | Programación | Spring Framework | V1 | Egg Educación ========== 
       
        HTTP es un protocolo sin estado porque no guarda información sobre las peticiones que realizo el cliente con anterioridad
        HTTP utiliza MIME(Extensiones Multiproposito de Correo de Internet), convenciones dirigidas al intercambio de archivos de manera transparente para el usuario, el tipo MIME sirve para que el servidor indique el tipo de contenido que esta enviando un cliente 
        y al cliente le sirve para saber de que manera representar el contenido que recibe de un servidor
        Min 4 Petición HTTP
        Min 5 Metodo GET y POST
        Min 8 Telnet
       
        ========== Configuración - Spring Initializer - Dependencias | Programación | Spring Framework | V2 ========== 
       
        Min Creamos proyecto en Spring Initializer
        Min Dependencias que vamos a usar: Spring Web, Thymeleaf(es para que nuestro html sea dinámico, entonces a través de ciertos TABs vamos a poder darle dinamismo a ese html y utilizar los modelos de Spring para enviar info dsde los controladores a las interfaces),
            Spring Data JPA, Spring Security, MySQL Driver, Java Mail Sender (Para enviar mails en la plataforma)
       
        ========== Capa de acceso a datos - Entidades - Repositorios | Programación | Spring Framework | V3 ========== 
       
        -- Capas de un Proyecto--
        Capa Superior: Interfaz de Usuario
        Capa de Comunicación: Mediador entre capas de usuario y capas inferiores
        Capa de Servicio: Contiene las reglas del Negocio
        Capa de Acceso a Datos
        Vamos a utilizar el API de persistencia Java e Hibernate para construitr entidades y repositorios
        Los repositorios sirven como interfaces entre modelos de objetos y la base de datos subyacente. Los repositorios son los encargados de crear, eliminar y buscar objetos de nuestro dominio y además simplifican la complejidad subyacente
        Min 3-9 creamos las entidades del tinder mascotas
        Min 6 Temporal
        Min 9 Relaciones, crea 2 mascotas un votador y un votado
        Min 12 Mapeamos sexo como una enumeración porque tiene valores predeterminados, cremos paquete para las enumeraciones
        Min 13 Ponemos anotación enum al atributo
        Min 14 @Id @GeneratedValue() GenericGenerator; Esto genera una cadena de texto que no se va a repetir nunca
        Min 15 Repositorios: va a ser un repositorio Usuario y la llave primaria de Usuario es de tipo String
        Min 16 generamos un método que devuelva el usuario vinculado a un correo electrónico (mail)
        Min 18 metodo que busca una lista de Votos Propios(los que hice yo), ordenada por fecha descendente (de más nuevo a más viejo)
        Min 19 metodo que busca una lista de Votos recibidos
        
        ============ Capa de servicios 1: Servicios - Clase Error - Optional | Programación | Spring Framework | V4 ============ 
        
        Min 0 vemos la clase Servicio Usuario
        Hacemos todo lo que dijo en nuestra clase Libreria Web --> Usuario
        
        ============================= Capa de Servicios 2 | Programación | Spring Framework | V5  ============================== 
        Min 1 crear Mascota
        Min 3:30 modificar mascota
        Min 10 eliminar / dar de baja mascota
        
        ============================= Capa de Servicios 3 | Programación | Spring Framework | V6  ============================== 
        
        Min 0 método voto
        Min 8 método devolver voto
        Min 9 agregamos seguridad
 
        ====================== Capa de servicios 4 - Entidad Foto | Programación | Spring Framework | V7  ====================== 
        
        Min 1 creamos entidad foto
        Min 2 atributo mime nos dice que tipo de foto es
              @Lob para las fotos, es para archivos grandes en general
              @Basic(fetch = Fetch.TYPE.LAZY) con esto le indicamos que no queremos que inmediatamente se cargue la foto, sino que lo cargue solamente cuando lo pida, haciendo que los querys sean mas livianos
              Cuando consulte la foto, sólo va a traer los atributos que están marcados como viber y mediante un método get traigo los atributos lazy
        Min 3:44 creamos get y sets
        Min 4 creamos la relación con mascota OneToOne como atributo
        Min 5 creamos repositorio portada 
              creamos servicio portada: archivo MultipartFile(es el archivo donde se almacena el archivo de la foto)
              archivo.getContentType nos devuelve el mime, osea el tipo de archivo
        Min 9 creamos método actualizar : Esto funciona para 2 casos, 1° que el usuario o la mascota que yo quiero modificar haya tenido una foto(portada) cargada, entonces va a buscar esa foto y la cambia y 2° caso si la primera vez no le cargue foto, entonces se va a crear en la BD y la va a persistir
        Min 11:50 vinculamos el servicio foto con el servicio usuario y mascota
        
        ===================== Capa de servicios 5 - Spring Security | Programación | Spring Framework | V8 ===================== 
        
        Min 0 Conectamos usuario con Spring Security
              Nuestro sevicio usuario implementa una interfaz que establece Spring Security que se llama UserDetailsService
              La interfaz nos obliga a implementar un método Abstracto que se llama LoadByUserName(lo usamos en Libreria Web usuarioService)
        Min 4:20 creamos el método ConfigureGlobal
        Min 4:50 vamos al servicio de usuario y utilizamos el mismo encriptador
        Min 5 modificamos método de registro y método modificar de Usuario
        
        ======================= Capa de servicios 6 - Mail Sender | Programación | Spring Framework | V9 ======================== 
        
        Antes que nada descargo la dependencia del mail sender(nose si tengo que poner algo en application properties)
        Min 0 creamos método enviar
        Min 2 marco método enviar como @Asinc (asíncrono): lo que hace esto es que el hilo de ejecución no espera a que se termine de enviar el mail, lo ejecuta en un hilo paralelo
              Por eso el usuario tiene una respuesta inmediata, no tiene que esperar a que se termine de enviar el mail
        
        ========== Capa de servicios 7 - Transactional | Programación | Spring Framework | V10 ========== 
        
        Min 1 @Transactional: Si el método se ejecuta sin lanzar excepciones, entonces se hace un commit a la BD y se aplican todos los cambios
                              Si lanza una excepción se vuelve atrás(rollback)
        
        ==================================================================================================================================================================================
        =================================================================***** MVC *****==================================================================================================
        ==================================================================================================================================================================================
        
        ========================= Inicio, Login y Registro | Programación | Modelo Vista Controlador | V1 =========================
        
        Min 0:39 nos muestra las páginas que tiene el proyecto TINDER MASCOTAS
        Min 2:07 muestra el index
        Min 3 vemos el index
        Min 4 pestaña Navigation la ponemos desde Window
        Min 5 el puerto localhost8080 se puede cambiar desde la configuración de la aplicación 
        Min 7:20 vemos el index código completo(casi)
        Min 8:06 vemos el código de registro
        
        ========================= Guardar Formulario de registro | Programación | Modelo Vista Controlador | V2 =========================

        Min 1 vemos el código de registro(dato para crear el formulario)
        Min 2 creamos método POST registrar
        Min 3 Los inputs tienen un nombre( nombre de la variable con la que va a viajar el controlador) 
        Min 3:34 @RequestParam: con RequestParam podemos indicar si es obligatorio o si es opcional, por defecto son obligatorios
        Min 6:15 El controlador deberia tomar estos datos y derivarlos al componente UsuarioService
        Min 6:23 vemos UsuarioService. Por el momento no mandamos la foto ni la lógica del mail
        Min 7 llamamos a Usuario Service
        Min 8 ponemos try and catch en el controlador

        ========================= Validar formularios | Programación | Modelo Vista Controlador | V3 =========================
        
        Min 1:40 Creamos un parámetro ModelMap: Esto va a contener el modelo, recordemos la clase modelo... los modelos en Spring servian para que nosotros insertaramos toda esa información que vamos a mostrar en pantalla que vamos a necesitar en las interfaces de usuario
        Min 2 modelo.put("error", ex);  Este modelo lo vamos a utilizar para enviar en este caso el mensaje de error en la pantalla. Usamos el método put, vamos a elegir un nombre de variable para que la pantalla recupere este valor, vamos a tomar la excepción y vamos a retornar a la pantalla el mensaje vinculado a esa excepción
        Min 8 como Ingresamos las variables nuevamente
        Min 9 Cuando se loguea con exito, lo mandamos a la pag exito 
        
        ========================= Guardar imagen | Programación | Modelo Vista Controlador | V4 =========================
        
        Min 0: Le sacamos el th:value="${portada}" en porque no queremos que recargue la imagen si lo agarra el try pq se equivoco, osea que debe ponerla de nuevo
                    <label>Portada</label> <input type="" name="portada" class="form-control"  placeholder="Portada del libro">
        Min 2:43 Muestra ServicePerro
        Min 3-4 Nos muestra tipos de errores que podemos tener con thymeleaf que no se guarda la foto
        Min 5 vemos que valida las 2 claves que recibimos en service y controlador
        
        ========================= Mostrar combo en pantalla | Programación | Modelo Vista Controlador | V5 =========================
        
        Min 1 Vemos cómo hacemos el tema de las zonas de los perros para que solo le aparezcan los perros de cierta zona
              Agregamos algunas zonas
              Mostrar combo en pantalla, modificamos el html
        Min 2:45 El dato zonas lo saca del Model. Modificamos en el controller el método Get
        Min 3:40 Explica como funciona 
        Min 4:33 Explica como funciona 
                 Modifica serviceUsuario y controladorUsuario

        ========================= Configurar Spring Security en el login | Programación | Modelo Vista Controlador | V6 ==================================
        
        Min 1 Creamos ConfiguracionSeguridad y anotamos todo ahí
        Min 4 Modificamos el HTML
        Min 7 Modificamos el Controlador
        Min 8 agregamos la card para error al html
        Min 9 crea un html de inicio igual al index
        
        ========================== Agregar seguridad a los accesos a la aplicación | Programación | Modelo Vista Controlador | V7 =========================
        

        
        ========================= Recuperar y utilizar información de la sesión | Programación | Modelo Vista Controlador | V8 ============================
        ========================= Registración de Usuario Completa | Programación | Modelo Vista Controlador | V9 =========================================
        ========================= Securización | Programación | Modelo Vista Controlador | V10 ============================================================
        ========================= Controlador para devolver una imagen | Programación | Modelo Vista Controlador | V11 ====================================
        
        Min 17:30-19:43 muestra métodos en clase MultimediaService que no conozco, creo que para devolver imagen también
        Min 20 Hay veces que no conviene por una cuestión de cache y navegador, que no conviene que las imagenes usen el id como parámetro sino pasarlo como una ruta completa y distinta para cada usuario, 
               sobre todo para las búsquedas, para Google que no guarda las imagenes por parámetros sino que las URLs completas o también para hacer URLS amigables
               Entonces le decimos que el id que necesitamos en el método del controlador lo va a sacar de lo que venga por la URL con path variable
        
        ========================= Desarrollo del Modulo de Mascotas 1 | Programación | Modelo Vista Controlador | V12 =====================================
        ========================= Desarrollo del Modulo de Mascotas 2 | Programación | Modelo Vista Controlador | V12 =====================================

        
        ====================================================================================================
        ====================================================================================================
        ====================================================================================================
        ====================================================================================================
        ====================================   ERRORES   ===================================================
        ====================================================================================================
        ====================================================================================================
        th:replace -->Tenia un problema para poner a cada vista html el titulo distinto en el header que es igual para todos
        Lo solucione con esto: https://stackoverflow.com/questions/31451830/head-and-title-in-thymeleaf
        Y también en la misma página me sale otra manera de hacerlo si quiero agregar algun css u otra cosa que no esté en ese header, seria agarrando todo con un div y meterlo, dejando el header intacto pero a la vez trayendo las cosas con el div
        Posible más información https://www.baeldung.com/spring-thymeleaf-fragments
        
        ERROR MultipartFile cuando quiero enviar un objeto en modificar libro: Current request is not a multipart request org.springframework.web.multipart.MultipartException: Current request is not a multipart request at
                                                          Posibles soluciones: - https://www.youtube.com/watch?v=m1O3mPgm2Jg
                                                                               - https://www.digitalocean.com/community/tutorials/how-to-use-the-mysql-blob-data-type-to-store-images-with-php-on-ubuntu-18-04-es
                                                                               - https://stackoverflow.com/questions/42013087/multipartexception-current-request-is-not-a-multipart-request
        
        
        
        Recursos con los que hago el email sender: https://www.youtube.com/watch?v=kyL0m9y1n0A Send Email from Spring Boot Application (sin imagen y con imagen)
                                                   https://www.youtube.com/watch?v=ugIUObNHZdo Send Email Using Spring Boot | Gmail SMTP | Java Mail Sender
                                                   https://www.youtube.com/watch?v=XV92kJ8tmmA (Todavía no lo he visto)
                                                   https://www.youtube.com/watch?v=QwQuro7ekvc  Java Tutorial - Complete User Login and Registration Backend + Email Verification
        
        Spring security: - https://stackoverflow.com/questions/72381114/spring-security-upgrading-the-deprecated-websecurityconfigureradapter-in-spring
                         - https://pharos.sh/codificacion-de-contrasena-con-spring-security/
                         - https://foroayuda.es/la-propiedad-security-basic-enabled-esta-obsoleta-la-configuracion-automatica-de-seguridad-ya-no-se-puede-personalizar/
        
        Info sobre problemas con css styles: - https://github.com/apache/netbeans/blob/master/ide/css.lib/src/org/netbeans/modules/css/lib/nbparser/CssParser.java
                                             - https://stackoverflow.com/questions/10022796/why-am-i-getting-this-error-premature-end-of-file
                                             - https://stackoverflow.com/questions/23453551/how-do-i-get-rid-of-these-errors-that-netbeans-is-reporting-on-my-preprocessed-c
                                             - https://itecnote.com/tecnote/css-how-to-get-rid-of-these-errors-that-netbeans-is-reporting-on-the-preprocessed-css/
                                             - https://community.bmc.com/s/article/Remedy-AR-System-Server-Remedy-Web-Service-is-not-getting-loaded-in-Developer-Studio
                                             - https://www.youtube.com/watch?v=qxw3lqWmFUE (Como poner bootstrap en Netbeans)
                                             - ERROR QUE ME SALIA: Filter out the "Premature end of file " CSS Parsing errors.
        PROBLEMA PRINCIPAL localhost/:106 Refused to apply style from 'http://localhost:8080/static/css/style.css' because its MIME type ('application/json') is not a supported stylesheet MIME type, and strict MIME checking is enabled.                                     
                                             - https://stackoverflow.com/questions/3027891/how-to-get-rid-of-library-references-issue-in-netbeans-java?rq=1
                   IMPORTANTE PARA  PROBLEMA - https://community.magento.com/t5/Magento-2-x-Programming/How-to-fix-its-MIME-type-text-html-is-not-a-supported-stylesheet/td-p/128970
                   IMPORTANTE PARA  PROBLEMA - https://developerf1.com/how-to/solving-stylesheet-not-loaded-because-of-mime-type
             IMPORTANTE VIDEO PARA  PROBLEMA - https://www.youtube.com/watch?v=G6TegxmaI9o Integrar Correctamente Plantilla Bootstrap en Proyecto SpringBoot con Thymeleaf
                                      (HECHO)- https://github.com/froala/angular-froala/issues/170
                                      (HECHO)- https://exerror.com/mime-type-text-html-is-not-a-supported-stylesheet-mime-type-and-strict-mime-checking-is-enabled/ 
                                      (HECHO)- https://stackoverflow.com/questions/48248832/stylesheet-not-loaded-because-of-mime-type
                                       (MIME)- https://github.com/h5bp/server-configs-nginx/blob/main/mime.types   
                                 (IMPORTANTE)- https://stackoverflow.com/questions/477816/what-is-the-correct-json-content-type
                          (IMPORTANTE)(HECHO)- https://stackoverflow.com/questions/60306334/spring-serves-static-content-as-application-json-no-matter-what
                                 (SIN HACER) - https://www.faqcode4u.com/faq/352660/bootstrap-not-working-with-spring-boot
                                 (SIN HACER) - https://stackoverflow.com/questions/58505262/thymeleaf-with-spring-boot-and-bootstrap-dont-work-in-page-with-pathvariable
                                 (SIN HACER) - https://stackoverflow.com/questions/51390127/bootstrap-not-working-with-spring-boot
                                 (SIN HACER) - https://stackoverflow.com/questions/49263433/refused-to-apply-style-because-its-mime-type-application-json-is-not-a-suppo
                                      (HECHO)- https://stackoverflow.com/questions/21203402/css-not-loading-in-spring-boot
                                      (HECHO)- https://stackoverflow.com/questions/31947707/why-will-netbeans-not-run-my-css-file
                                      (HECHO)- https://github.com/jaylindquist/spring-boot-service-and-static EJEMPLO
        Posible solución para problema con el mail(Búsqueda->application properties email spring boot): (MODIFICACIÓN APPLICATION PROPERTIES) https://www.geeksforgeeks.org/spring-boot-sending-email-via-smtp/
                                                                                                        https://howtodoinjava.com/spring-core/send-email-with-spring-javamailsenderimpl-example/
                                                                                                        https://stackoverflow.com/questions/24776669/failed-to-load-applicationcontext-from-unit-test-filenotfound
        CONTROLADOR DE ERRORES EJ: https://stackoverflow.com/questions/31134333/this-application-has-no-explicit-mapping-for-error
        BUSQUEDAS:
                                             - https://www.google.com/search?q=my+netbeans+dont+read+bootstrap&oq=my+netbeans+dont+read+boots&aqs=chrome.1.69i57j33i10i160l3.11457j0j7&sourceid=chrome&ie=UTF-8
                                             - https://www.google.com/search?q=how+to+change+content+type+of+file&oq=how+to+ch&aqs=chrome.1.69i57j69i59j46i512j0i512l2j69i60l2j69i61.4035j0j7&sourceid=chrome&ie=UTF-8
                                             - https://www.google.com/search?q=Content-Type%3A+application%2Fjson&sxsrf=ALiCzsbe5gvUI5m0IJFGnl7Aa7wx4Sg-iw%3A1659366622247&ei=3uznYozPDvGJ1sQP_cWhgAc&ved=0ahUKEwiMtsiw9qX5AhXxhJUCHf1iCHAQ4dUDCA4&uact=5&oq=Content-Type%3A+application%2Fjson&gs_lcp=Cgdnd3Mtd2l6EAMyBAgAEEcyBAgAEEcyBAgAEEcyBAgAEEcyBAgAEEcyBAgAEEcyBAgAEEcyBAgAEEdKBAhBGABKBAhGGABQygNYygNgwQVoAHADeACAAQCIAQCSAQCYAQCgAQHIAQjAAQE&sclient=gws-wiz
        IMPORTANTE BUSQUEDA QUE NO LLEGUE A VER - https://www.google.com/search?q=spring+boot+changed+style+css+class+to+application%2Fjson&oq=spring+boot+changed+style+css+class+to+application%2F&aqs=chrome.1.69i57j33i10i160l4j33i22i29i30.31131j0j7&sourceid=chrome&ie=UTF-8
        Info sobre problemas con el mail(Solucionado): - https://stackoverflow.com/questions/51274765/how-to-have-javamailsender-not-fail-the-application-context-loading-on-a-wrong-m
                                          - https://medium.com/karibu-blog/c%C3%B3mo-enviar-un-mail-con-spring-boot-f86c2f7af678
                                          - https://www.geeksforgeeks.org/spring-boot-sending-email-via-smtp/
       
        
        */
    }

}
