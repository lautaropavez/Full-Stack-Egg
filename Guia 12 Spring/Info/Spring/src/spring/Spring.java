package spring;

/**
 * @author Lautaro Pavez
 */
public class Spring {

    public static void main(String[] args) {
       /*
        ========== Info Complementaria ========== 
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
        endpoints: buscar info
        API restful: buscar info(@RequestParam vs @PathVariable- link de stack)
        scope: buscar info(sale en el html de thymeleaf)
        Documentaci??n thymeleaf
        Enum repasar
       ========== Charla Informativa ========== 
        
        Para usar Spring tenemos 2 opciones: 1)Podemos usar STS que es como el propio id de Spring o 2) Un Pluggin en Netbeans 
        
       ========== Guia Programaci??n Web ========== 
       ----------------- Notas -----------------
        P??g 8 POM: Project Object Model
               jar: Un archivo JAR es un tipo de archivo que permite ejecutar aplicaciones y herramientas escritas en el lenguaje Java. Las siglas est??n deliberadamente escogidas para que coincidan con la palabra inglesa "jar". Los archivos JAR est??n comprimidos con el formato ZIP y cambiada su extensi??n a .jar
               DI(Dependency Injector): Inyector de Dependencias
               A??adir dependencias a nuestro proyecto
               POJO significa Plain Old Java Object. Se trata de un objeto Java com??n, no vinculado por ninguna restricci??n especial que no sea forzada por la especificaci??n de lenguaje Java y que no requiera ninguna ruta de clase. POJOs se utilizan para aumentar la legibilidad y la reutilizaci??n de un programa
        P??g 9 Funcionalidades Spring
        P??g 13 Tipo de Inyecci??n de dependencias:
                                                -Constructor: instanciamos la clase sin usar el new
                                                -Setter: Con m??todo setter
        P??g 14 Anotaciones
        P??g 18 URI es la abreviatura de Uniform Resource Identifier, en espa??ol identificador uniforme de recursos. Este t??rmino gen??rico se emplea para todos los tipos de nombres y direcciones que se refieren a objetos internet tales como p??ginas, im??genes, videos, etc.
        Un URI es por tanto una cadena de caracteres que se utilizan para identificar un recurso o un nombre en internet. Su prop??sito es permitir la interacci??n entre diferentes recursos en Internet y otro tipo de red. 
        Mi recomendaci??n es que uses la anotaci??n @RequestParam para filtrar una consulta, y la anotaci??n @PathVariable para identificar un recurso o entidad ??nica. (Info al final de info de complementaria/URI/stackOver...)
       
        ========== Intro Spring Parte 1 - Ma??ana ==========
       
        Dice lo mismo que V1 de Videos Egg
        Metodo POST: Generalmente se emplean cuando llenamos formularios
        Min 6 Maven
        Min 7 POM--> Dentro del POM va a estar la configuraci??n general del proyecto, manejo de dependecias
        Min 9 Spring Framework: tiene Arquitectura de capas, donde cada capa contiene objetos con responsbilidades similares, las capas superiores tienen conocimiento de las inferiores pero no al rev??s. Seria como cuando usabamos el servicio, DAO y el Main.
              Spring MVC
        Min 10 Capas IMPORTANTE GR??FICO
        Min 11 Anotaciones
        Min 15 crear Proyecto de String con String Initializr
        Min 17 Por convenci??n en Group se escribe la url de atr??s hacia adelante (ej: com.example), en Package Name se escribe solo el nombre del paquete, tenemos que trabajar dentro de este paquete siempre pq sino SpringBoot le cuesta deployar el proyecto
               en Name lo que queramos pero ese va a ser el nombre de nuestra carpeta del proyecto (min 37)
               en Packagin podemos elegir jar o war, tienen diferentes formas de estructurar los archivos al trabajar pero cuando es un proyecto grande y nosotros queremos subirlo despues a alg??n lugar a veces es mejor trabajar con war porque genera un archivo de web aplication y jar trabaja con archivos m??s separados (min 38)
        Min 19 Vemos donde lo descargamos el zip, extraemos, lo abrimos desde Netbeans ya extraido
        Min 21 Generalmente nos va a aparecer con unloadable, entonces apretamos encima click derecho y Clean and Build, lo que esto hace es empezar a construir el proyecto, descargar las dependencias que le dijimos y una vez que termina nos dice que todo funciona correctamente o algo se rompi??
        Min 25 En carpeta Project Files(Archivos de proyecto) se encuentra el pom, ac?? esta toda la info del proyecto
        Min 26 En pom existe otra etiqueta que es versi??n que es donde nosotros ponemos la versi??n de la dependencia pero con Spring Boot no hace falta poner la versi??n ya que solo busca la versi??n compatible 
        Min 27 Tambi??n tenemos nuestro paquete Source Packages donde tenemos nuestro Main
               Nosotros tenemos que trabajar desde el paquete lauti.egg.mendoza, cuando creemos entidades por ejemplo debe ser desde ah?? que creamos el paquete
        Min 28 Tambi??n tenemos la carpeta Other Source --> src/main/resources --> <default package> : Ac?? es donde van algunas configuraciones para la base de datos, para alguna de las dependencias que utilicemos. 
                                                                              --> static : Ac?? es donde va el css, las im??genes
                                                                              --> templates : Ac?? es donde va el html
        Min 30 Corremos el programa (como dice el profe o click derecho al proyecto y run), para hacerlo como dice el profe no debemos estar parados en ninguna clase 
        Min 31 Ponemos en la web localhost:8080 y nos sale error pero es bueno porque significa que anda pero que no tenemos ning??n html cargado
               En el output si nos dice " Tomcat initialized with port(s): 8080 (http) " Tomcat es el servidor que nos provee Spring
        Min 32 Muy Importante frenar el proyecto actual cuando le demos run de nuevo, sino se rompe porque el puerto 8080 ya est?? en uso
        Min 35 crea de nuevo proyecto desde la web
        Min 36 Explicaci??n de lo que nos sale en el pom
        min 37 en Name lo que queramos pero ese va a ser el nombre de nuestra carpeta del proyecto 
        Min 38 en Packagin podemos elegir jar o war, tienen diferentes formas de estructurar los archivos al trabajar pero cuando es un proyecto grande y nosotros queremos subirlo despues a alg??n lugar a veces es mejor trabajar con war porque genera un archivo de web aplication y jar trabaja con archivos m??s separados
        Min 40 desde netbeans vamos a utilizar un plugin
        Min 45 que es repositorio
        Min 48 Con las dependencias no vamos a tener la unidad de persistencia, no vamos a tener que crear el entity manager
       
       ========== Intro Spring Parte 1 - Tarde ==========
       
        Min 6 HTTP MIME: tipo estandarizado de se??alar cierto formato de nuestros archivos
        Min 9 Gr??fico de peticiones y respuestas
        Min 10 dudas compa??eros
        Min 11 Renderizar: Es cuando vos mostras lo que tu servidor te entrega, cuando abriamos el OpenLiveServer en HTML para ver lo que teniamos en c??digo en el navegador
        Min 12 Postmat
        Min 14 GET cuando yo quiera solicitar algo y POST cuando yo quiera enviar algo a mi servidor(ej: cuando guardo un usuario, me registro a una p??gina, ah?? env??o mi info al servidor)
        Min 14:52 TODOS LOS M??TODOS QUE EXISTEN, nosotros por ahora veremos GET y POST
        Min 17 Headers, ac?? es donde entra la parte del MIME. El Header va a contener cierta informaci??n de la respuesta, es decir METADATA de nuestro servidor
        Min 26 F12 ver partes de la p??gina
        Min 30 Para usar Spring tenemos que tener configurado Maven
        Min 33 Estamos en la p??gina de Spring(Vamos a Projects y ahi nos sales los subproyectos )Elemento Padre Spring y subproyectos de Spring: SpringBoot, SpringCloud, SpringData Spring Batch, Spring Secutiry.
        Min 34 El pluggin es para que nosotros podamos generar desde NetBeans proyectos en Spring, ahora el profe nos ense??a esta otra forma de generarlos
        Min 36 Nosotros vamos a utilizar Spring Boot(lo que m??s se pide en las empresas), no usaremos Spring de forma directa porque sino deberiamos hacer muchas configuraciones manualmente
        Min 37 Spring Boot toma las facilidades de Spring y nos permite otras autoconfiguraciones para que nosotros no las hagamos manualmente
        Min 39 Nosotros vamos a hacer un Monolito(mi front y mi back est??n integrados en el mismo proyecto), lo malo de esto es que si mi proyecto deja de funcionar toda mi aplicaci??n va a fallar, lo bueno son los microservicios que sirven para segmentar mi app, se usa demasiado en las empresas grandes
        Min 40-44 IMPORTANTE Microservicios (La parte de microservicios la desarrollan programadores que tienen mucho conocimiento en Spring Boot y gran experiencia, a eso debemos apuntar en un futuro como programadores)
        Min 45 IMPORTANTE Con Spring primero tenemos que aprender lo que vemos en el curso, despu??s por nuestra cuenta hacer API REST y despues como 3ra etapa integrar eso en un microservicio
        Min 46 P??gina de Spring --> vamos a Projects --> Spring Initializer
        Min 47 = Min 15 Clase 1 Ma??ana
        Min 49 en Group pongo el dominio al rev??z, en Artifact ponemos lo que nosotros queramos, en Name lo que queramos pero ese va a ser el nombre de nuestra carpeta del proyecto, el package es una combinaci??n del group y del Artifact
        Min 51 Vamos a usar una dependencia(dependencia = libreria)
        Min 52 En los videos de Youtube el profe implementa muchas dependencias que requieren configuracion como seguridad y la base de datos(No es necesario hacerlo a esta altura, estar tranquilos que ya lo vamos a ver), entonces por ahora evitar la dependencia de security y mysql
        Min 53 Utilizamos la dependencia Spring Web, esto nos provee que podamos crear aplicaciones con arquitectura con MVC, Aplicaciones REST y nos provee un servidor. Si nosotros no usamos Spring tenemos que instalar un servidor independiente,configurar ese servidor
        Min 54 Vemos donde lo descargamos el zip, extraemos, lo abrimos desde Netbeans ya extraido
        Min 55 Carpetas de nuestro proyecto, tenemos nuestro paquete Source Packages donde tenemos nuestro Main, en el Main ya no vamos a generar c??digo. En la linea 6 del Main tenemos una anotaci??n->
               -> @SpringBootApplication: SpringBoot para su funcionamiento necesita cierta estructura, esta anotaci??n lo que hace es habilitar cierta onfiguraci??n y realiza el escaneo de componentes(cuando se levanta la Aplicaci??n SpringBoot y yo tengo habilitado el escaneo de componentes, 
                                          va a ir a rastrear ciertas clases de aplicacion y las va a integar a un proyecto Spring, ma??ana lo vemos mejor)
               Tenemos nuestras carpetas de Testeo,Tambi??n tenemos la carpeta Other Source(es donde nosotros vamos a configurar nuestra aplicaci??n) --> src/main/resources --> <default package> --> application.properties: Ac?? es donde van algunas configuraciones para la base de datos, para alguna de las dependencias que utilicemos y JDBC. 
                                                                                                                                                    --> static : Ac?? es donde va el css, las im??genes
                                                                                                                                                    --> templates : Ac?? es donde va el html  , la conexi??n con la base de datos 
               En carpeta Project Files(Archivos de proyecto) se encuentra el pom, es un archivo que tiene mucha METADATA de nuestro proyecto (Min 1:03)
        Min 1:00 Debemos crear todo dentro del mismo paquete, el que creamos al crear el proyecto, sino Spring no lo puede reconocer
        Min 1:04 Vemos el pom
        Min 1:05 Vamos a correr la app
        Min 1:06 MAVEN gestiona las dependencias, las descarga solo una vez y ya quedan guardadas para futuros proyectos
        Min 1:07 TomCat
        Min 1:08 localhost:8080 --> 8080 es el puerto por defecto de Sprin Boot como en mysql que era el 306
        Min 1:09 En application.properties es donde establecemos nuestra configuraci??n de la aplicaci??nm si queremos configurar la base de datos es ac??
       
       ==========Intro Spring Parte 2- Ma??ana==========
       
        Min 1 Vamos a la p??g Sprin Initializer a descargar m??s dependencias en el proyecto que descargamos la clase pasada
        Min 2 Vamos a necesitar 3 dependencias, MySQL DRIVER, Spring Data JPA( Motor para persistir datos de JPA), Thymeleaf (por ahora nos va a permitir mostrar html en las vistas(pagina de localhost) pero tiene mas funcionalidades)
        Min 5 ERROR en consola por que no configuramos MySQL DRIVER(error de url) y Spring Data JPA, lo solucinamos en clase, tenemos que configurar la conexion a la base de datos y el url(este error nos tira en la clase)
        Min 6 Soluci??n de ERROR, vamos a Other Source --> src/main/resources --> <default package> --> application.properties: ac?? es donde nosotros configurariamos nuestro proyecto, en esto de mysql y jpa configurar usuario, contrase??a, el driver que nosotros vamos a utilizar, como vamos a querer que trabajen, que guarden los datos
        Min 7 application.properties (lo que haciamos en JDBC manual): 
              Primero TODO lo que es MYSQL
              2 linea configura el data source, setea el url a la base de datos que nos queremos conectar y la url tiene algunas cosas m??s por ej el "useSSL=false" para que no nos tire unos WARNING. Tambi??n dice ejemplo4 porque ya tiene creada la base de datos a ese nombre
              3 linea setea el usuario
              4 linea setea la contrae??a
              5 linea setea el driver: un poco distinto tambien al que usabamos en jdbc
              LUEGO JPA
              7 linea a traves de formularios o hagamos cosas que alteren las tablas, nos lo va a mostrar en la consola, ej: para crear una persona 
              8 linea Se actualizan las tablas y todo si es que agregamos un atributo nuevo o algo por el estilo
              9 linea dialecto que usa JPA, que es como almacena datos en la base de datos, esta es en base a primary key
              THYMELEAF
              10 linea "spring.thymeleaf.cache= false" es para que no guarde archivos basura
        Min 13 creamos el html, vamos a templates, new (vemos si sale html ah?? sino-->), other y ahi le damos ok a html, le ponemos el nombre que queramos y la creamos
        Min 14 corremos de nuevo el programa y nos muestra el html, pero para enviar informaci??n tenemos que usar los controladores
        Min 16 Controladores: creamos clase y le ponemos estas anotaciones--> @Controller @RequestMapping
        Min 17 @Controller @RequestMapping(ej si pongo /persona en la pagina entonces va a buscar un controlador que en RequestMapping diga /persona, pero si lo dejo vac??o y en la pagina web no pongo nada, va a entender que tiene que ir al controlador actual)
        Min 18 @GetMapping 
        Min 26 Los repositorios serian nuestros nuevos DAOs donde estarian todos los m??todos y las QUERYS 
       
       ==========Intro Spring Parte 2- Tarde==========
       
        Min 1 Maven es una herramienta para construir proyectos, Spring es un framework para crear p??ginas Web
        Min 2 Arquitectura de capas 
        Min 3 GR??FICO DE MVC: El usuario va a ver el HTML en su navegador y va a enviar info al Controlador(es el que gestiona, portero del edificio), tenemos nuestra capa servicio que se ecarga de la l??gica, el servicio nunca se comunica con el html, el repositorio se comunica con la base de datos, 
              pero mi html no sabe que existe la base de datos
        Min 4 Por comodidad es com??n que nosotros hagamos una b??squeda de un usuario directamente en el controlador haciendo uso de la clase repositorio NO DEBEMOS HACERLO para evitar futuros errores.
        Min 5 Las entidades se comunican solo con el repositorio
        Min 8 Explicaci??n de anotaciones @Entity, @Service, @Transactional, @Repository, @Controller
        Min 9 Vamos a crear Proyecto siguiendo los pdfs de PASO 1 Y 2 
        Min 12 PASO 2 Vamos a crear Proyecto desde Netbeans
        Min 15 Principal beneficio de STS es que podemos debuggear sin conflictos, en cambio en Netbeans a veces pueden surgir alg??n conflicto
        Min 17 por protocolo el Group y el artefacto tienen que ir com.loquesea (osea seria el dominio que van a tener). 
               Jar: es un poco m??s rapido y no puedo modificar el sountac ???
               War: Si nosotros exportaramos nuestro proyecto a un servidor no local no vamos a tener conflicto de hacer cambios en la arquitectura, por ahora los dos nos sirven por igual
        Min 19 Dependencias: Son cajitas de herramientas que yo dejo precargadas en mi proyecto y el dia de ma??ana no voy a tener conflicto de versiones. La del correo electronico la puedo agregar despu??s
               Spring Boot DevTools: es para cuando nosotros estemos corriendo el programa detecte si hacemos alg??n cambio y se cambia de manera autom??tica
               Thymeleaf: Nos permite hacer nuestros HTML din??micos
               Spring Security: Uno de los fuertes de los proyectos Spring
        Min 22 Cuando nosotros creamos el proyecto se abre solo el pom
        Min 23 pom
        Min 24 creamos base de datos
        Min 25 modificamos application.properties : Ac?? tambi??n pondriamos en un futuro la configuraci??n de un correo electr??nico si queremos enviar notificaciones
        Min 27 Paso 8 de Guia 1, los Controladores son los gestores de habilitar y deshabilitar las rutas adonde yo voy accediendo
        Min 28 Creo Controlador, toda carpeta debe nacer de la ??nica carpeta creada del proyecto
        Min 34 Dudas Maven es una arquitectura de proyecto y Spring Framework que va a necesitar de Maven
        Min 35 Creo clase Controlador (en pdf Paso 1 sale)
        Min 36 @GetMapping("/") : este controlador nos va a decir que cuando yo ingrese a este mapeo que hace las rutas de las peticiones, cuando ingreso al portal inicial va a entrar y retornar index.html
        Min 38 Por protocolo y buenas practicas la pagina de inicio de cualquier p??gina se debe llamar index.html
        Min 39 los html van en templates y las im??genes, estilos de bootstrap van en static porque no tienen relaci??n. El html lo puedo hacer en visual y lo pego despu??s
        Min 40 Paso 9 en Navigator pongo SpringBoot run
        Min 42 Diferencia de cuando lo corrimos con Profe Cristian, debemos acordarnos que es un servidor y el servidor siempre va a estar corriendo, adem??s como yo eleg?? mi dependencia Spring Security y no la configuro, por defecto Spring me genera un password
        Min 44 En usuario ponemos user y en contra la contra que nos dieron
        
       ========== Entidades y Repositorios Spring - Ma??ana ==========
       
        Min 1 Entidades es muy parecido a lo que haciamos con JPA, para que la Base de datos entienda que estas clases van a ser tablas, tenemos que definirlas como entidades con @Entity y toda entidad tenia que tener una anotaci??n @Id
        Min 3 Forma de hacer los id como se hacen en los proyectos reales, se usa un generador de tipo universal, uuid(identificador unico universal) y vamos a usar una estrategia de identificador uuid2
        Min 6 Hacemos relaci??n ManyToOne pero no bidireccional
        Min 7 Si yo no tengo constructor por defecto la entidad entiende que existe un constructor vaci?? con default, si ya existe un constructor vamos a tener que crear el constructor vac??o tambien si queremos usarlo
        Min 8 Como las id se generan automaticamente tal vez no hace falta ponerlas en el constructor
        Min 10 Como a todas las entidades le poniamos arriba @Entity, a todos los repos le ponemos @Repository. Los repos son interfaces
        Min 11 extends JpaRepository
        Min 14 M??todos de Repository que usamos mucho: save, findById, findAll, delete
        Min 17 @Query
        Min 18 antes nosotros usabamos el .setParameter ahora vamos a usar una anotacion que se va allamar Param
        Min 19 Para buscar por id lo que te devuelve el m??todo es un objeto de tipo Optional
        Min 20 creamos un m??todo para que nos devuelva un objeto Persona y no un Option
        Min 31:26 m??todo delete para eliminar
        
        ========== Entidades y Repositorios Spring - Tarde=========
       
        Min 2 Spring Data JPA lo que hace es trabajar la parte de persistencia de datos
        Min 3 Spring data se divide en muchos subproyectos, uno es JPA, otro puede ser MongoDB que son Base de Datos no relaciones, o con MYSQL o con PostGress
        Min 4 Nosotros vamos a trabajar con Spring Data JPA que es la API de persistencia de Java
        Min 5 Cuando nosotros vimos JPA lo que hicimos fue trabajarlo con Eclipse Link pero el m??s usado es Hibernate, ahora con Spring Data JPA lo hacemos con Hibernate
              Dependencias que deberiamos tener en nuestro proyecto
        Min 9 En los videos Sebastian hace una combinaci??n alfanum??rica de Id, en esta clase lo vamos a hacer solo de numeros, en @GeneratedValue entre parentesis le tenemos que colocar la estrategia, sino se pone solo en auto incremental
              Va a poner por defecto lo que seria(estrategy = GenerationType.IDENTITY)
        Min 10 anotacion Column() nos sirve para que solamente se puedan crear usuarios que tengan nomre y apellido, quiero que sea un campo obligatorio
        Min 12 Consulta Importante Compa??era: Si yo le pongo el @Column en nuestro dise??o de entidad relaci??n este campo en la base de datos va a estar con el color celeste por lo que va a ser obligatorio. NO VA A REEMPLAZAR las excecpciones, si yo le mando por ejemplo a la BD sin un nombre, en la BD se va a generar la excepci??n
               Yo tengo que controlarla antes, osea en Java
        Min 18 Si yo planteo un OneToMany en Usuario con mascotas, en mascotas tengo que plantear ManyToOne(la relaci??n inversa) y asi planteamos una relaci??n bidireccional
        Min 21 Lo podemos trabajar de varias formas: de manera bidireccional pero lo que pasa es que se genera la tabla intermedia, cuando trabajamos con listas y esa lista esta relacionada a otra entidad siempre se genera una tabla intermedia,
               esta tabla intermedia se pide evitarla para que haya un buen dise??o de base de datos, igualmente en algunos casos es imposible obviar la tabla intermedia pero en este caso OneToMany y ManyToOne se puede obviar de alg??n lado
        Min 22 Entonces si nosotros queremos trabajarla de manera bidireccional tenemos que usar el mappedby --> @OneToMany(mappedBy = "usuario") , entre "" va el nombre del atributo con el que lo voy a relacionar en la otra clase
               Con esto establezco que en la base de datos no se grafique una relaci??n, una tabla intermedia pero si en Java por ende a la entidad Mascota le asignamos la entidad de la relaci??n
        Min 25 EXPLICACI??N IMPORTANTE, la propietaria de la relaci??n va a ser la entidad macota porque es la que tiene llave for??nea
        Min 26 Que pasa si yo no coloco el mappedby
        Min 32 EXPLICACI??N IMPORTANTE, la tabla intermedia me permite hacer una relaci??n de Uno a Muchos y Muchos a Uno
        Min 38 Porque usamos Mappedby
        Min 46 Donde ponemos el MappedBy? Donde nosotros no queremos que se genere el campo extra
        Min 50 Que pasa si hacemos una relaci??n OneToOne en las 2 entidades sin el mappedby? No es eficiente
        Min 59 Tabla intermedia: cuando manejo listas se crea la tabla intermedia si o si
        Min 1:01 RESUMEN EXPLICACI??N 
        Min 1:02 Creaci??n repositorios
        Min 1:04 La forma de trabajar de Spring Data JPA no es a trav??s del Entity Manager aunque internamente sigue actuando
        Min 1:04 Cuando teniamos la anotaci??n SpringBootAplication se generaba una autoconfiguraci??n y un escaneo de componentes, @Repository es un componente que yo le digo a Spring, cuando levantes la aplicaci??n registrame esta interface
        Lo que nosotros haciamos antes con los DAOs ahora lo hacemos con los repositorios osea de interfaces
        Esta interface va a extender de otra interface
        Cada entidad tiene que tener un repositorio, en el diamante(estructura con < >) en primer lugar yo pongo el nombre de la entidad y en 2do lugar yo pongo el tipo de dato del id de esta entidad
        De esta forma vamos a poder acceder a metodos como antes usabamos el merge,commit,etc
        Min 1:09 JpaRepository a su vez extiende de otra clase y esta de otra y asi, generando un hilo de herencias.
        
        ========== Servicios Spring - Ma??ana ==========
        
        Min 2 anotaci??n @Autowired: Spring va a instanciar la clase por nosotros, es decir, va a crear un objeto y cuando lo necesite alguna clase usar lo va a mandar solamente a ese objeto
        Min 4 Creaci??n m??todos
        Min 10 En m??todo modificar podemos traer las variables por separado o el objeto completo
        Min 15 @Transactional: Lo usamos para todas las transacciones, tiene el rollback por defecto. Se lo ponemos al de las validaciones porque tiene una llamada a la base de datos(buscarporDNI)
        Min 17 Como nosotros trabajamos en funci??n de capas lo ??nico que vamos a poder llamar desde ServicioPersona: es PersonaRepositorio pr y ServicioCiudad cs. Porque como buena pr??ctica podemos llamar solo al repoitorio de Persona y a los otros servicios de las otras entidades, por ejemplo a CiudadRepositorio no la podemos llamar
        Min 18 Lo mismo nos va a pasar en los Controladores vamos a llamar a Servicio, NUNCA DEBEMOS LLAMAR DESDE LOS CONTROLADORES A LOS REPOSITORIOS
        Min 20 findById con Optional: nos trae un Optional, no la persona en s??, entonces para obtener a la persona tenems
        Min 26 Hay que hacer una sola p??gina o muchos? cuando trabajo solo con uno usando JavaScript uso simplePageAplication. Es preferible hacer varios HTML 
        Min 27 findById con Optional y sin Optional
        Min 28 Cuando uso @Transactional 
        Min 29 Buscar por Id cuando es un String largo, los id van a viajar por la url, se ve mejor en thymeleaf
        Min 30 Cuando hacemos un buscador, no buscamos por Id porque no lo conozco, sino que lo buscamos por DNI que es un atributo ??nico
        Min 31 Relaci??n ciudad y persona: 2 posibilidades: 
                        1) Usar el cascade para que cuando creemos la persona con la ciudad, se cree la ciudad directamente
        Min 32-36       2) Crear la ciudad y una vez que creamos la ciudad, crear reci??n ahi a la persona(m??todo public Ciudad buscarporId). 2 formas: 1)Que tire el ERROR de que no existe en la BD y crear un formulario aparte que te cree la ciudad y cuando la vas creando que te muestre todas las ciudades que ya han sido creadas
        Min 37-43                                                                                                    2)Que en el mismo formulario general, te crea la Ciudad si vos pon??s guardar.
        Min 43/44  Proyecto del Profe Libreria, vemos LibroServicio m??todo crearLibro
        Min 48-49 Profe trabaja los try and Catch en los controladores, los muestra. Si sucede una excepci??n en el repositorio no hace falta arrojarla y volverla a atrapar en el servicio y despu??s en el controlador
                  Muestra CONTROLADOR DE LIBRO
        Min 54 Pasos para crear Proyecto: creo las entidades, luego los repositorios con sus querys, los servicios y los controladores. El profe creaba una vista y en funci??n a eso creaba el controlador.
               A veces para crear el controlador necesitas tener creada la vista para ver donde va X bot??n que haga tal cosa y de ah?? saco la l??gica para hacer el html con thymeleaf, es como el controlador y las vistas van m??s en conjunto 
        
        ========== Servicios Spring - Tarde ==========
        
        Min 1 Vamos a usar el Proyecto Perros 1 subido en GitHub
              Los servicios deben contener todas las l??gicas necesarias para procesar las transacciones de negocios(alta,baja,modific,busqueda,etc)
              Siempre Servicio se comunica con el repositorio
        Min 2 anotaci??n @AutoWired instancia los objetos de manera autom??tica y a su vez, si yo cree una instancia de perro repositorio en otra clase(que no deber??a hacerlo), con esta anotaci??n lo que hace es ir y buscar esa instancia, 
              es decir un proyecto crea una ??nica instancia de esta clase que estoy llamando. Por lo tanto esto optimiza el rendimiento de mi proyecto. el @AutoWired reemplaza a cuando haciamos el " = new Perro() "
              Lo que hace no es que vas a crear una nueva instancia, sino que busca en memoria si ve que existe el espacio de memoria ya utilizado para esto la utiliza
        Min 5 Si yo no le creo constructor, por defecto tiene un constructor vac??o que puedo llamar
        Min 7 anotaci??n @AutoWired no es la capacidad que yo tengo de esta anotacion para crear un espacio de memoria de un molde, a crear una instancia de una clase para hacer uso de sus recursos esa es la diferencia principal
              Seteo los datos ingresados
        Min 8 Seteo booleano, seteo date (fecha)-> le pone new date porque le pone la fecha actual por eso no trae ninguna fecha
        Min 9 Crea el m??todo crearPersona
              M??todo de Repositorio predeterminado: .save
        Min 10 Las excepciones tienen 3 estadios para ser controladas: 
               1) Utiliza el HTML: verifico que el input que yo uso en mi html sea especifico al dato que quiero recibir, NO puede ser la ??nica porque el HTML es muy inseguro. 
               2) Verificar en mi controlador si yo quiero que este dato sea requerido, usamos @Request (Param = true or false) es decir si quiero obligar al usuario que ponga o no un dato
               3) En mi Servicio puedo dejarla dentro del metodo(como haciamos en proyectos anteriores) o haciendo un m??todo para validar en base a los criterios de la l??gica de negocio que yo quiero inventar
        Min 11:30 muestra m??todo de validaci??n que tiene ella en su clase
        Min 12 Con el .save ya se est?? guardando el objeto en la base de datos aunque sea un void. Como si lo hiciera a trav??s del DAO
               Casi todas las anotaciones tienen atributos especificos que yo puedo hacer uso, uno de estos es propagation que es de @Transactional
        Min 13 @Transactional debo ponerla en todo m??todo que manipule la base de datos si no lo ponemos trabaja mal internamente aunque no de ERROR. El @Transactional le advierte que al procesar los datos hace un duplicado del objeto para luego mandarlo si esta bien
               Este atributo propagation es una forma de como pueden comportarse las transacciones, poniendole la anotacion rollbackFor se hace de forma directa. Por defecto esta transaccion nace con esos atributos asi que no es necesario ponerlos
        Min 15 Hay otras Transacciones que podemos tener, IMPORTANTE vemos PDF de la Profe sobre anotaciones y distintos tipos de propagation de la anotaci??n Transaction
        Min 18 Transaction a importar es la de Spring, NO javax
        Min 19 M??todo validar y funcionamiento Excepciones
        Min 20 M??todo perro alta y baja
        Min 21 Si quiero establecer un par??metro requerido lo tengo que hacer en el controlador al try and catch
        Min 22 Porque no uso try and catch? Si yo quiero un par??metro requerido lo voy a hacer desde el try and catch en el CONTROLADOR
        Min 23 Estoy agarrando la excepci??n (en el m??todo validaci??n), la estoy tirando y despu??s la va a agarrar el controlador con el html
        Min 25 Uso de QUERYS(anotaciones), casitodas las que ya vienen con Spring
        Min 29 @Transactional(readOnly = true) : cuando yo tengo que hacer m??todos de consulta en mi base de datos debo avisarle a JPA que es una transacci??n, pero con esto le aviso que es solo una consulta para que no me haga una duplicaci??n del Objeto en memoria para ver
               si en alg??n momento lo modifica,guarda o pega en la base de datos. Entonces si el m??todo es de consulta ponemos la anotaci??n readOnly y en unn futuro cuando tengamos una base de datos con miles de registros, esto agiliza mucho las consultas
        Min 30 M??todo validar 
        IMPORTANTE
        Min 32 M??todo Optional para buscar por Id, funciona similar a cuando nosotros usabamos el Iterador en Colecciones para eliminar
               Clase UsuarioServicio usa MultipartFile archivo, BCryptPasswordEncoder(), investigar. Tambi??n tiene los atributos mail y clave, idFoto
               M??todo public void habilitar(M??todo getOne),deshabilitar, public void registrar, public void modificar(usa el Optional)
        Min 33 Claves encriptadas
        Min 34 Nunca debo eliminar Informaci??n por lo que debo usar los m??todos habilitar y deshabilitar
               M??todo getOne: Esta utilidad es relacionada al repositorio, que es un m??todo precargado y que ya recibe un par??metro que es el Id, pero si yo quiero traer uno por correo electr??nico debo traer mi QUERY espec??fica en el repositorio
        Min 35 como en los repositorios pongo extends Jpa... NO SE CREA M??S LA UNIDAD DE PERSISTENCIA
        Min 36 En los videos de Youtube el profe encapsula los get y set con el refactor pero es igual a como lo hacemos con el ALT e Insert
        Min 37 Si quiero eliminar: la profe dice que es preferible no eliminar alg??n dato deberiamos darlo de baja con un booleano por ej pero si lo queremos eliminar igual debemos tener 2 consideraciones: 
               1) Criterio de cascada que voy a tener, es decir, si creo un Autor y se elimina el Autor, se eliminan los objetos relacionados a este Autor si cree una relaci??n. 
               2) El autor se creo solo(de forma independiente) o gracias a un libro que le dio un espacio de memoria
        Min 38 Caso: Autor tiene relacion con el libro ManyToOne que es propiedad del libro la relaci??n. Tengo que decidir que va a pasar.
               Porque si yo tengo el autor x que tenia 4 libros y lo elimino, los libros no son eliminados pero no van a tener Autor. Entonces si lo quiero eliminar tengo que ponerle el atributo cascade en las entidades
        Min 40 Para usar el findById con cualquier tipo de Id(Integer o String)tengo que utilizar la clase Optional sino se puede utilizar getOne pero se encuentra obsoleta
        Min 42 INNER JOIN: NO es necesario hacerlos porque... ver video
        
        ========== THYMELEAF + CONTROLLER - Ma??ana ==========
        
        Min 1 Es un motor de plantillas(plantillas serian los templates, sea los html)
        Min 2 Usa template Suits
        Min 3 vemos entidad Perro de proyecto PerroV1
        Min 5 dependencia de thymeleaf
        Min 6 Main Controller, le ponemos @Controller a la clase
        Min 7 @RequestMapping es la URL que va a escuchar a este controlador. Si le ponemos localhost:8080 es lo mismo que poner solo la "/"
              Si yo tengo @RequestMapping("/usuario") la URL en la que yo llamaria a toda esta clase seria localhost:8080/usuario
              En el caso de los index no se le coloca nada
        Min 9 En el m??todo, en el return debemos retornar el nombre de nuestro html
        Min 10 @GetMapping : a trav??s de una operaci??n GET vamos a acceder a una URL desde la barra. Esta notaci??n seria a lo que llamamos verbos HTTP o m??todos HTTP, y estos m??todos lo que hacen es definir la acci??n que se va a realizar sobre un determinado recurso
        Min 11 Diferencia entre GET y POST :
                                            - GET se utiliza ??nicamente para consultar informaci??n al servidor, podemos decir que es muy parecido a realizar un SELECT(pq cuando hacemos un select hacemos una petici??n a la BD  para que nos traiga info) en la BD
                                            - POST es utilizado para solicitar la creaci??n de un nuveo registro, parecido a cuando hacemos un INSERT en la BD, es la creaci??n de algo nuevo
        Min 14 Nuestro index lo que va a hacer es renderizar. RENDERIZAR: Mostrar una Vista, mostrarla, plasmarla, armarla
        Min 15 Muestra el index, tambi??n los th que necesitamos para tener thymeleaf y spring security, con esta linea de codigo ya vamos a poder implementar etiquetas din??micas adentro del html
        Min 18 muestra Perro Controller
        Min 21 Con el @Autowired inicializamos la clase PerroService
        Min 22 Los controladores son los que se comunican con la Vista(templates) y el Back mediante los servicios. Se manejan solo con las l??gicas de vistas, decide que info viene y va que peticiones hacemos y que se muestra en la vista
        Min 25 vamos a hacer todo lo que es el CRUD (Registro,modificaci??n y baja pq eliminaci??n esta explic en los videos)
        Min 26 formulario
               @GetMapping va a renderizar esta vista(return form-perro) cuando mi URL sea la del coment de la linea de abajo, osea cuando entramos a esta URL te retorna el formulario
        Min 27 M??todo @PostMapping, desde el mismo /registro (podrian no tener el mismo nombre y cambiar el nombre del m??todo), lo que importa es que cuando haga la misma URL me lleguen algunas determinandas variables o parametros, por ej: nombre, foto, apodo, raza
        Min 28 ModelMap, adem??s de poder inyectar mensajes sirve para pasar valores y Collections(colecciones de valores) (en 2da lista de reproducci??n MVC vamos a encontrar todo esto)
        Min 29 @RequestParam indica que determinada variable es requerido para el m??todo 
        Min 32 @PostMapping entra reci??n cuando tengamos un bot??n que haga submit sino con el @GetMapping s??lo lo mostramos
               vemos PerroService: desde el Controlador llamo al servicio, al m??todo guardar y le paso lo que quiero que guarde(el guardar perro no le pasa el objeto, sino que le pasa los atributos)
        Min 33 bot??n submit: el tipo submit sabe que tiene que enviar informaci??n, es importante que el bot??n est?? dentro del formulario para que sepa que hacer
        Min 35 vemos html y relaci??n de @PostMapping con el a trav??s de m??todo POST
        Min 39 ModelMap es una clase de Java con m??todos, a trav??s del ModelMap inyecto 
        Min 40 m??todo .put : recibe una llave? y un valor --> modelo.put("??xito","Registro exitoso"); "??xito" es la llave y "Registro exitoso" es el valor de esta llave
        Min 41 c??mo hago desde el front para saber que tengo que mostrar esto? (esto= ventana emergente que dice que se realizo con ??xito)
        Min 42 IMPORTANTE nos muestra html. Con el th hacemos referencia que es una etiqueta thymeleaf, poniendo th:text manejamos el texto que le queremos poner dede nuestro controlador
        Min 45 card: rect??ngulo gigante (verde en este caso) 
        Min 48 vemos que pasa si lo agarra el try and catch
        Min 49 vemos el html mas completo
        Min 50 cuando seteamos valores o variables usamos el signo $, ahora que estamos haciendo un action estamos haciendo referencia a una URL, entonces le avisamos que cuando entre a la URL /perro/registro del m??todo POST, quedaria asi --> th:action="@{/perro/registro}" method="POST" , vamos a enviar toda la informaci??n de mi formulario
        Min 51 en el model.put podemos pasarle como llave cualquier cantidad de palabras pq le pasamos el String, lo ??nico tambi??n debemos cambiarlo en el html y siempre deben ser solo 2 parametros
        Min 52 card title
        Min 54 IMPORTANTE Duda URL, mirar clase. No se concatenan lo que tenga en el requesmapping de mi clase main con lo que tenga en mi requestmapping de cualquier otra clase
        Min 56 M??todo POST no puede estar declarado en el bot??n, se declara en el formulario 
        Min 57 href lo que hace es mandarme a una URL, si le agrego la etiqueta th: quedaria th:href="@{/}" le pongo una @, pasa lo mismo que el action(min 50), le avisamos a que ruta va a ir ac?? le digo
        Min 58 tabla de html com??n
        Min 1:00 Nueva funcionalidad e thymeleaf, que es recorrer una lista con th:each ="perro : ${perros}", funciona igual que un for each, por ejemplo ac?? le pasamos un auxiliar que se llama perro y le pasamos la variable entre llaves con el signo $(pesos) con una lista perros
                 Cuando sabe con que lista trabajar, de donde vienen estos perros? Eso lo vemos a trav??s de nuestro modelo, con nuestro modelo vamos a inyectarle una lista para que thymeleaf la recorra
                 Vemos el m??todo @GetMapping("/lista") en el controller y lo armamos de cero, uso el m??todo que creamos en el service que trae todos
        Min 1:09 scope investigar
        Min 1:11 cuando queremos poner un sino, algo que equivale a un else en html ponemos unless
        Min 1:12 referencias href--> alta,baja modificar
        Min 1:17 vemos Controller(controlador) perro completo
        Min 1:18 como sabemos que est?? conectado a la Base de datos? Porque en el output dice Hibernate, Hibernate utiliza JPA como motor de persistencia para poder crear nuestras tablas
        Min 1:22 como comentar en HTML <!-- blablabla -->
        Min 1:23 como damos de baja un perro
                 vemos en el controlador de perro, el m??todo lista
        Min 1:25 vemos ERROR, hack para saber donde se nos rompe cuando nos sale en la web, ponemos CTRL + F y la palabra line y nos muestra la linea donde se rompi??
                 Modificar: vemos m??todo en el Controller
        Min 1:26 hacemos otro formulario en HTML para modificar
                 vemos la importancia del ID
        Min 1:28 Partes de una URL, PathVariable es una anotaci??n dentro de Spring que nos sirve para configurar variables dentro de la URL(va a viajar en nuestra URL)
        Min 1:30 @PathVariable es una anotaci??n, en este caso lo usamos con nuestro Id
        Min 1:31 le inyectamos el modelo, usa el perroService y dentro de el, el m??todo getOne 
        Min 1:32 basicamente lo que hace es recibir el id y buscarlo mediante el servicio perro y mostrarlo en el html, que lo manda(al html) a trav??s del modelo 
        Min 1:34-43 MODIFICAMOS html de formulario perro modificar 
                 vemos el m??todo @PostMapping que es el que le va a mandar el perro
        Min 1:35 Mandamos el id, como se evaluan las expresiones en thymeleaf cuando queremos pasar este tipo de cosas? Existe una sintaxis: __${perro.id}__  (esto se pone en el html pero es para avisarle a thymeleaf y Spring), que hago con estos guines bajos? es una expresi??n de preprocesamiento que es interna y se evalua antes de la expresi??n, en otras palabras le estoy dando prioridad, osea que lo primero que se va a evaluar va a ser "perro.id"
                 Y una vez que tenemos el resultado del id, te permite ingresar a toda la URL de este controlador 
        Min 1:38 Hago lo mismo con el bot??n de modificar, le agrego __${perro.id}__
        Min 1:40 etiqueta(tag) nueva de thymeleaf --> th:valid se usa mucho en los input, ej: th:value=${perro.nombre}
        Min 1:42 el name de los tags tiene que coincidir con el nombre de las variables que estamos poniendo
        Min 1:43 le agregamos ModelMap modelo al @PostMapping de perro Controller
        Min 1:44 placeholder: en el caso de que no haya nada se va a mostrar lo que pusimos en el place holder en html
        Min 1:45 El id viaja pero es necesario que lo tengamos en un input oculto(hidden) para que hagamos referencia permanentemente a ese 
                 Entonces lo ideal seria ponerlo despues de declarar nuestro formulario y ponemos: <input hidden th:value= "${id}" name= "id"> para que cuando entre al id que pusimos en el formulario, nos muestre del id que hacemos referencia en el hidden, todos los valores que tenemos debajo  
        Min 1:47 lo que hace devTools es que se vayan mostrando los cambios sin tener que volver a correrlo
        Min 1:49 placeholder 
        Min 1:52 input hidden: Cuando nosotros vamos a querer modificar y utilizamos un formulario, y queremos trabajar con un objeto en espec??fico, con una entidad que nosotros tenemos creada, necesitamos esa id para que el formulario sepa que vamos a trabajar con esa entidad, si no lo enviamos, cuando hagamos el submmit va a crear otro objeto nuevo en lugar de modificar el que nosotros modificamos ya que no tendria el id que le pasamos.
        Min 1:54 Como tiramos las excepciones que tenemos en el servicio --> e.getMessage()
        Min 1:55 Diferencia entre modelo.put y modelo.addAttribute: Para mandar una Collection es lo mismo pero el addAttribute puede mandar colecciones, mapas,objetos, string con el nomrbe del atributo m??s el objeto. La diferencia del addAttribute es que te trabaja objetos no valores
        
        ========== THYMELEAF + CONTROLLER - Tarde ==========
        
        Min 2 vemos atributos
        Min 3 si o si tenemos que poner @Controller para avisarle a spring que la clase es un controlador
        Min 4
        
       ###########################################################################################################################################################################################
       ##########################################################################  Secci??n Videos Egg ############################################################################################
       ###########################################################################################################################################################################################
       
        ========== Fundamentos web | Programaci??n | Spring Framework | V1 | Egg Educaci??n ========== 
       
        HTTP es un protocolo sin estado porque no guarda informaci??n sobre las peticiones que realizo el cliente con anterioridad
        HTTP utiliza MIME(Extensiones Multiproposito de Correo de Internet), convenciones dirigidas al intercambio de archivos de manera transparente para el usuario, el tipo MIME sirve para que el servidor indique el tipo de contenido que esta enviando un cliente 
        y al cliente le sirve para saber de que manera representar el contenido que recibe de un servidor
        Min 4 Petici??n HTTP
        Min 5 Metodo GET y POST
        Min 8 Telnet
       
        ========== Configuraci??n - Spring Initializer - Dependencias | Programaci??n | Spring Framework | V2 ========== 
       
          Min Creamos proyecto en Spring Initializer
          Min Dependencias que vamos a usar: Spring Web, Thymeleaf(es para que nuestro html sea din??mico, entonces a trav??s de ciertos TABs vamos a poder darle dinamismo a ese html y utilizar los modelos de Spring para enviar info dsde los controladores a las interfaces),
              Spring Data JPA, Spring Security, MySQL Driver, Java Mail Sender (Para enviar mails en la plataforma)
       
        ========== Capa de acceso a datos - Entidades - Repositorios | Programaci??n | Spring Framework | V3 ========== 
       
        -- Capas de un Proyecto--
        Capa Superior: Interfaz de Usuario
        Capa de Comunicaci??n: Mediador entre capas de usuario y capas inferiores
        Capa de Servicio: Contiene las reglas del Negocio
        Capa de Acceso a Datos
        Vamos a utilizar el API de persistencia Java e Hibernate para construitr entidades y repositorios
        Los repositorios sirven como interfaces entre modelos de objetos y la base de datos subyacente. Los repositorios son los encargados de crear, eliminar y buscar objetos de nuestro dominio y adem??s simplifican la complejidad subyacente
        Min 3-9 creamos las entidades del tinder mascotas
        Min 6 Temporal
        Min 9 Relaciones, crea 2 mascotas un votador y un votado
        Min 12 Mapeamos sexo como una enumeraci??n porque tiene valores predeterminados, cremos paquete para las enumeraciones
        Min 13 Ponemos anotaci??n enum al atributo
        Min 14 @Id @GeneratedValue() GenericGenerator; Esto genera una cadena de texto que no se va a repetir nunca
        Min 15 Repositorios: va a ser un repositorio Usuario y la llave primaria de Usuario es de tipo String
        Min 16 generamos un m??todo que devuelva el usuario vinculado a un correo electr??nico (mail)
        Min 18 metodo que busca una lista de Votos Propios(los que hice yo), ordenada por fecha descendente (de m??s nuevo a m??s viejo)
        Min 19 metodo que busca una lista de Votos recibidos
        
        ========== Capa de servicios 1: Servicios - Clase Error - Optional | Programaci??n | Spring Framework | V4 ========== 
        Min 0 vemos la clase Servicio Usuario
        Hacemos todo lo que dijo en nuestra clase Libreria Web --> Usuario
        ========== Capa de Servicios 2 | Programaci??n | Spring Framework | V5  ========== 
        
        ========== V6 ========== 
        ========== V7 ========== 
        ========== V8 ========== 
        ========== V9 ========== 
        ========== V10 ========== 
        
        
        
       */       
    }

}
