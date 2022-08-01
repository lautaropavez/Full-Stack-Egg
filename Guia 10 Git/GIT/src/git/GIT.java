package git;
/**
 * @author Lautaro Pavez
*/
public class GIT {

    public static void main(String[] args) {
        /* 28 Intro GIT Mañana */
        /*
        * Para bajar el proyecto que tenemos en github page, debemos ir adonde queremos que se descargue esa carpeta(aca podemos apretar clck secundario y poner gith bash here).
        * Para movernos en la consola (GITBASH) se pone: 
        * cd + (nombre adonde se quiera mover), ejemplo: "cd desktop".Luego de poner esto nos avisa que esta en el escritorio en el ejemplo, entonces acá yo voy a descargar 
        * la carpeta y el proyecto. Para descargar el proyecto voy a poner "git clone + (url del proyecto en github)" Y para volver se pone "cd .." (2 puntos) 
        * git remote -v : Nos sirve para decirnos si verdaderamente esta vinculado con nuestro repositorio remoto.
        * git status : Nos dice el estado del archivo, nos puede decir si nuestra rama master esta actualizada y que hay un archivo modificado(se pone en rojo)
        * git add +(nombrearchivo) : Nos dice voy a subir este archivo y lo voy a preparar para cuando haga un commit, se incluya en ese commit y pueda subir los repositorios
        * git add . : para subir todos los archivos, luego apretamos git status y nos aparece el arhivo README en verde lo que nos dice que está listo para ser comiteado.Ahora por lo tanto crearemos ese commit,
        * git commit -m +"(mensaje)", ejemplo: git commit -m "cambios en el README"
        * git push : para subirlo, nos va a pedir el usuario (mi nombre todo junto) mas la contraseña que es el TOKEN que nosotros hicimos en GITHUB 
        * git fetch : trae un archivo y nos dice si hay algun cambio que nosotros no tengamos, como traemos esos cambios? con un git pull
        * git pull : Nos actualiza nuestro repositorio local
        * git checkout -b + "nombre de la nueva rama": Esto crea la rama y nos posiciona sobre la rama para modificar lo que sea sin modificar nada en la rama master. Ejemplo: git checkout -b + NuevaRama.
        * Al ya estar posicionados en nuestra nueva rama, abrimos el mismo archivo(parece que es el mismo archivo pero en realidad es la nueva rama, ya no es mas el main-master) y lo que hacemos es modificarlo
        * git bash nos avisa que estamos posicionados en nuevaRama, como antes nos avisaba que estabamos posicionados es main. Ponemos git status luego de modificar y guardar esa nueva rama y vemos que README nos sale en rojo.
        * Ahora ponemos git add o git add README.md, luego git status y nos aparece en verde que quiere decir que ya esta agregado para ser comiteado. y ahora ponemos: git commit -m "modificamos el readme en la nueva rama".
        * Ya esta realizado el commit por lo que ahora debemos pushearlo, ponemos: git push origin nuevaRama. git push origin(origin hace referencia a nuestro repositorio remoto)+ nombreRama
        * Ahora vamos a github y en la parte izquierda vamos a ver la rama main, la apretamos y vemos que tiene la rama. El main-master como vemos queda igual, ahora cuando este listo para agregar esa rama al main vamos a hacer el MERGE
        * Nos vamos a posicionar sobre nuestra rama principal(main) y vamos a traer todos los cambios que hay en esas ramas. 1° Nos posicionamos sobre esa rama con git checkout main o master depende como lo tengamos nosotros, Ahora hacemos 
        * git merge nuevaRama : Quiere decir que nos va a unificar y nos va a traer todo lo que esta en nuevaRama al main. Y la consola nos dice que nos trajo el unico elemento que hemos modificado que es el README.
        * Estamos en la rama master, me trajo el cambio de nuestra nueva rama asi que ahora lo tengo que subir con
        * git push y listo. Si lo queremos corroborar vamos a la rama master, actualizamos y vemos que se agrego lo que habiamos puesto en la rama nueva.
        * fetch y metch son comandos con funcionalidades distintas pero el pull une esos 2 comandos, por lo que a veces no es necesario que hagamos con el fetch y merch sino que con el pull ya se trae los cambios, descarga los cambios y los actualiza en su rama. 
        * Lo que dijimos si nos serviria si nosotros tuvieramos una sola rama porque si nosotros nos posicionamos sobre la rama master y hacemos un pull y tiene varias ramas va a traer todo. Por lo que si tenemos varias ramas si vamos a tener que hacer el merch 
        * de la rama que queremos.
        */
        
        /*Info extra: 
        * git --version : nos devuelve que version es la que tenemos descargada, en nuestro caso es 2.35.1
        * COMMIT : En los sistemas de control de versiones, una commit es una operación que envía los últimos cambios del código fuente al repositorio, haciendo que estos cambios formen parte de la revisión principal del repositorio.
        *          Las confirmaciones en los sistemas de control de versiones se mantienen en el repositorio de forma indefinida. Por lo tanto, cuando otros usuarios hagan una actualización o una comprobación desde el repositorio,
        *          recibirán la última versión confirmada, a menos que especifiquen que deseen recuperar una versión anterior del código fuente en el repositorio.
        * git AltGr : nos dice todos los git que hemos puesto cuando vamos girando la rueda del mouse y manteniendola apretada
        * git.ignore : elija que archivos no deben ser leidos https://www.youtube.com/watch?v=24td-L6MHmY mas info acá y acá https://docs.github.com/es/get-started/getting-started-with-git/ignoring-files
        * git.ignore : En esta pagina esta todos los ignore de Java y demas lenguajes, https://github.com/github/gitignore/blob/main/Java.gitignore
        * origin : En Git, "origen" es un nombre abreviado para el repositorio remoto del que se clonó originalmente un proyecto. Más precisamente, se usa en lugar de la URL del repositorio original y, por lo tanto, hace que la referencia sea mucho más fácil.
        */ 
        /* 28 Intro GIT Tarde */
        /*
        * Un repositorio es un lugar para guardar cosas, GIT funciona a través de repositorios, existen 2 tipos de repositorios:
        * El repositorio local(dentro de la compu) y uno remoto que es a traves del cual nos sincronizamos con nuestros compañeros 
        * Para operar con git tenemos que generar un repositorio local en nuestra compu. ¿Como le indico a GIT que mi proyecto va a ser un repositorio?
        * A través de comandos, el comando para inicializar un repositorio es GIT INIT(en minúscula). 
        * A través del comando commit establezco un punto en el proyecto, siempre estamos trabajando en el mismo proyecto, no estamos generando una copia.
        * Branch es una rama para trabajar en paralelo, generalmente a la rama principal se lo denomina como la rama main. Yo a partir de esa rama main
        * puedo generar otra rama. Cuando incorporemos cambios en un proyecto real vamos a crear una rama al principio, no se modifica el main de una. 
        * Acá entra el método de fusionar (MERGE), se le dice mergear es cuando fusionamos esa rama con código  que yo cree en paralelo con la rama main.
        * Cuando trabajamos en equipo usamos un GIT PULL para traer todos los cambios, actualizas tu repositorio local, le incorporo los cambios. Y luego 
        * con GIT PUSH subo mis cambios para que mis compañeros actualizen sus repos.
        * Aquellos cambios que nosotros hagamos a nuestros proyectos primero lo incorporamos en el staging area a traves del comando GIT ADD que es como
        * un lugar de preparacion anterior al repositorio y luego los comiteo al repo.
        * git init: Apretamos esto y se crea el repo.(min 51) es la rama que se crea cuando yo creo un repositorio
        * git log : Si yo quiero saber cuantos commit tengo en mi repositorio. Nos dice la fecha, autor y mail del que hizo el commit. 
        */
        /* 29 GIT Tarde */
        /* 
        * A partir de minuto 27 mirar, creamos un repositorio remoto y otro local. 
        * git config --globlal init.defaultBranch main : Es para configurar de forma global todos los repositorios que vos crees, ahora no tenes que 
        * generar uno x uno de master a main sino que todos quedan con main. Previamente en github tenemos creado el repo vacío y en la compu vamos a 
        * crear una carpeta con un archivo de texto llamado hola el cual vamos a subir al repositorio remoto y abrimos gitbash ahí,ahora vamos a inicializar un repositorio:
        * git init (Luego de esta accion nos aparece que estamos posicionados en el main)
        * git status(para ver estado en el que se encuentra nuestro repositorio, nos sale hola.txt en rojo osea no lo reconoce, no esta en el stagen area)
        * git add .
        * git status(para ver estado en el que se encuentra nuestro repositorio, ahora si lo reconoce)
        * git commit -m "Primer commit" (lo comiteamos, creamos un punto de control)
        * git log
        * ----- Ahora vamos a vincular nuestro repositorio remoto con el local -----
        * git remote add origin https://TOKEN@github.com/USUARIO-QUE-CREO-EL- REPOSITORIO/NOMBRE-DEL-PROYECTO.git (abajo lo pongo con mis datos reales)
        * git remote add origin https://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@github.com/lautaropavez/HolaMundo.git (este es un comando para vincularnos a traves del token con nuestro repositorio remoto)
        * git remote -v (para saber si lo tenemos vinculado min 40) si nos aparece -->     
        *     origin https://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@github.com/lautaropavez/HolaMundo.git (fetch)
        *     origin https://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@github.com/lautaropavez/HolaMundo.git (push)
        * Si nos aparece las 2 lineas de arriba es porque esta vinculado
        * Hasta ahora esta vinculado, pero yo necesito enviar mi repositorio local a mi remoto, entonces:
        * git push origin main (con esto ya estamos generando la vinculacion y estamos pushiando un cambio)
        */
        /* 30 GIT Tarde */
        /* 
        * Si inicializo por error un repositorio y no quiero que esté vinculado a GIT: En documentos vamos a Vistas o buscamos la parte configuracion para habilitar los elementos ocultos,
        * le doy click y nos aparece una carpeta que dice git, esta carpeta es la que le indica a git que esto es un repositorio, si yo la elimino deja de ser un repositorio
        * Vemos cambios en los commits en github
        */
        /* Video 2 GIT Youtube */
        /*
        * Cuando yo abro una carpeta cualquiera y no nos dice main-master al costado es porque no está vinculada a git. En el caso contrario es porque si lo está pero no quiere decir que 
        * tenga repositorios creados en la misma. ¿Cómo creamos un repositorio? Ponemos:
        * git init (crea una carpeta oculta o no que maneja toda la informacion en cuanto a las versiones o ramas que va a tener este proyecto de forma local y remota)
        * git remote add origin https://github.com/lautaropavez/HolaMundo.git (Acá estamos añadiendo una vinculación de un repositorio remoto, origin es el area que vamos a manejar por convencion pero puede ser el que queramos)
        * git config -l : nos muestra la lista de configuraciones
        * clear : te limpia la pantalla
        */
        /* Video 3 GIT Youtube */
        /*
        * Vamos a agarrar MansaLibreria y lo vamos a enviar a nuestro repositorio remoto
        * git status (esta todo en rojo)
        * git add .
        * git status (esta todo en verde)
        * git commit -m "Primer commit"
        * git status (si ponemos esto despues de commit no va a estar ni rojo ni verde, porque ya esta comiteado)
        * git push origin master(enviamos informacion adonde(depende del alias que pongamos en este caso es a origin) y bajo la rama master, en repositorio remoto todavia no existe esa rama)
        * si lo ejecutamos se va a crear la rama master en nuestro repositorio remoto y vamos a enviar la informacion de todo el proyecto hacia el repositorio.
        * Ahora vamos a ejecutar un cambio en nuestro proyecto, vamos a agarrar la entidad cliente y le agragamos un atributo. Ponemos:
        * git status (nos dice que se han modificado las siguientes clases: ...) Entonces ahora ponemos: 
        * git add .(para agregar todo lo que se haya modificado), luego ponemos 
        * git status(se pone en verde) solo para ver, hacemos un
        * git commit -m "segundo commit", si solo ponemos git commit y enter entonces se va a poner algo en la pantalla donde nos pedira el mensaje que le queremos poner al commit, 
        * cuando ya metimos el mensaje apretamos ESC + :wq (abajo a la izquierda)(w de write y q de quite, escribo y salgo), le damos ENTER, Ponemos:
        * git status (y vemos que el commit ya se realizo) Por lo que ahora haremos un 
        * git push origin master (vamos a enviar desde master local a master remoto).
        * Una vez realizado esto refrescamos la pagina de github y vemos qu hay cosas que entraron sobre el primer commit y cosas que entraron sobre el segundo commit,
        * si apretamos sobre 2do commit vemos las cosas que han sido modificadas sobre el 2do commit, luego en el video se agrega un 3er commit con sus respectivos git add,etc. Luego con 
        * git log nos muestra el historial de esta rama de lo que ha pasado en cuanto a los commit
        */
        /* Video 4 GIT Youtube */
        /* 
        * Acá veremos como movernos entre diferentes commits(como viajar al pasado del archivo), nosotros creamos la rama master, establecimos el primer commit, hicimos unos cambios, hicimos el 2do commit, hicimos otros cambios y hicimos el tercer commit
        * Es decir tenemos tres puntos a lo largo de nuestra historia, nosotros estamos posicionados en el HEAD(cabecera,tercer commit), 
        * PODEMOS volver en el tiempo y quedarnos en el primer commit o ir al 3er commit de nuevo, lo que debemos hacer es copar el codigo del primer commit(al final del video anterior habiamos puesto git log y ahi nos
        * sale el codigo de todos los commit) y ponemos:
        * git checkout + codigo : Le damos enter, acá nos puede surgir un mensaje diciendo que hay cambios que están disponibles y aca podemos hacer dos cosas: 1_ comitearlos (lo que seria actualizar el repo en la nube) o 
        * 2_ descartarlos con git checkout -- .(ya que tal vez los hicimos sin querer) luego de esto volvemos a hacer el git checkout + codigo, nos saldra un mensaje y vemos que ahora estamos posicionados en el primer commit.
        * Para volver ponemos git checkout master y listo, l podemos verificar poniendo git log y nos muestra que estamos en la cabecera
        */
        /* Video 5 GIT Youtube */
        /* 
        * Creacion de una nueva rama llamada develop en remoto
        * git branch -a :  nos muestra todas las ramas existentes, tanto local como remotas.
        * git fetch : Con esto traemos todas las ramas que se hayan generado, commits o cambios realizados
        * git branch -a : Ahora si nos sale la rama develop que ha sido creada en remoto(Nos muestra en rojo lo que esta en el repositorio remoto, en blanco las locales y verde donde estoy parado)
        * Para crear una rama desde otra rama: nos posicionamos en la rama develop con git checkout develop, ahora deberemos crear la rama nueva con
        * git branch feature/agustin/login , feature: es una denominacion para encapsular el ordenamiento del nombre de la rama, entonces va a ser una rama perteneciente a agustin, todas mis ramas van a permanecer a esa carpeta(contenedor) y el nombre de la tarea va a ser login
        * No es correcto realizar ramas unicamente por nombre. ej: yo trabajo siempre sobre agustin, NO. Yo tengo que trabajar sobre la rama de mi tarea.
        * git branch -a : Y vemos que está en verde la rama que estoy parado y en blanco las ramas locales y rojo las remotas. Ponemos:
        * git checkout feature/agustin/login y nos posicionamos en dicha rama
        * git push origin feature/agustin/login : y le digo que estos cambios hay que empujarlos al login. Vemos en github y esta creada la nueva rama que fue generada desde mi computadora y yo envie la info al repositor remoto. 
        * Ahora generamos un cambio en nuestro archivo de Java
        * git diff : nos muestra las diferencias o lo nuevo en el archivo, en este caso lo nuevo lo pone en verde. Ahora si lo subimos poniendo
        * git add .
        * git status : para corroborar
        * git commit -m "Primer commit desde login"
        * git push origin feature/agustin/login : es decir desde mi rama hacia esa rama remota
        * Vamos a github, corroboramos que estamos parados en esa rama,actualizamos la pag y nos sale mi "Primer commit desde login"
        */
        /* Video 6 GIT Youtube */
        /* REGLA DE ORO: antes de realizar el merge, siempre GIT PULL en la rama que va a recibir el merge, por si alguien realizo algún cambio
        * git pull origin develop
        * git merge feature/agustin/login
        * APARECIÓ UN CONFLICTO: Nos dice que en entidades cliente_.class hay algo duplicado o inesperado. Solucionado el tema del conflicto seguimos
        * git commit -m ""
        * git push origin develop
       ¨* minuto 639 hace un merge a develop con un pull
        */
        /* Video 7 GIT Youtube */
        /* 
        * Clonar repositorio
        * Abrimos la carpeta vacia donde queremos clonar el repositorio, vamos a git bash
        * git init (inicializamos el repositorio)
        * git remote add origin https: url del proyecto...  (conectamos el repositorio local vacio al repositorio remoto que tiene todos los datos de los videos anteriores)
        * git remote -v (corroboramos que esten vinculados)
        * git pull origin master (Aca traemos todo lo que estaba en master de forma remota a nuestro repo local)
        */
        /* Video 8 GIT Youtube */
        /* 
        * git --help : Nos explica que hace cada uno de los comandos
        */
        /* Video 2 Pildoras Informaticas */
        /* 
        * git reset --hard 01cdac6(codigo de la instantanea a la que queremos retornar) : Si hicimos 2 commits, con esto podemos volver al primero pero el 2do commit lo elimina
        * git log --oneline : nos muestra lo del git log en una linea
        * git commit -am "" : Te hace el commit y el add a la vez
        * git commit --amend : Para editar el commit si lo escribimos mal, nos manda al editor vin, acá tenemos que poner :i (esto le dice al editor que podemos empezar a editar), apretamos la tecla 
        * git config --global user.username (como cambiar el user de git)
        * git config --global user.email (como cambiar el email de git)
        * Suprimir para borrar esa descripcion, tecla ESC para salir de modo edición y ahora para escribir una nueva edicion(commit) :i, ENTER y escribimos lo que iria en el commit, luego ENTER Y ESC y listo, para salir del editor tenemos que poner :wq
        * 
        */
        /* Video 3 Pildoras Informaticas */
        /* min 8 Podemos modificar el nombre del commit */
        /* Video 4 Pildoras Informaticas */
        /*
        * tags: Etiquetas que nos permiten especificar versiones de nuestro proyecto.
        * git tag 12-4-22v1 -m "Versión 1 del proyecto", apretamos enter y ahora lo tenemos que pushear (antes de pushear pdemos hacer un git log)
        * git push --tags y ahi se suben las tags a mi repositorio remoto, por ejemplo en este caso cuando una persona apriete la pestaña tags podra descargarse el proyecto hasta este punto. En un futuro cuando creemos mas versiones 
        * se podran descargar el tag(la version) que elijan que estara actualizado hasta ese punto.
        */
        /* Video 5 Pildoras Informaticas */
        /*
        * git branch : con esto veo las ramas del proyecto, con el * y marcada en verde nos marca la rama en la que estamos parados
        * 
        */
        /* Video 6 Pildoras Informaticas */
        /*
        * Espacio de trabajo (work-space)
        * Despues de iniciar en git se nos ponen los archivos en verde
        * Ayudas de VSC con GIT: *U en verde: Unfollow significa que no hay seguimiento para estos archivos, osea no los hemos agregado al staging area
        *                        *A cuando estan add, osea agregados
        *                        *M en rojo, cuando hay Modificaciones pendientes
        * Una vez que commiteamos desaparece el color verde la A de nuestros archivos.
        */
        /* Video 7 Pildoras Informaticas */
        /* 
        * git branch -d GIT: para borrar rama GIT
        * git log --oneline : nos muestra lo del git log en una linea
        * Si hacemos click en el 3er ícono de VSC que dice Control de código fuente podemos prescindir de la consola y hacer las cosas desde ahi(crear una rama,commit,etc)
        * Si lo hacemos en la barra celeste de abajo tambien nos sale que podemos crear una nueva rama y otras cosas mas
        * En la barra inferior azul nos dice en que rama estamos parados
        */
        /* En la barra inferior azul nos dice en que rama estamos parados*/
        /* Video 8 Pildoras Informaticas */
        /* Video 9 Pildoras Informaticas */
        /* Video 10 Pildoras Informaticas */
        /* Video 11 Pildoras Informaticas */
        /* ERRORES */
        /*
        fatal: The current branch master has no upstream branch, INFO:
        https://stackoverflow.com/questions/23401652/fatal-the-current-branch-master-has-no-upstream-branch
        https://www.delftstack.com/es/howto/git/reset-and-restore-in-git/
        https://stackoverflow.com/questions/17096311/why-do-i-need-to-explicitly-push-a-new-branch/17096880#17096880
        https://ajaxhispano.com/ask/por-que-necesito-hacer-set-set-upstream-todo-el-tiempo-14543/
        ERROR COMPLETO fatal: The current branch con-14 has no upstream branch.To push the current branch and set the remote as upstream, use
        git push --set-upstream origin con-14
        Solucionado con: git push --set-upstream origin con-14 . Lo que me salio cuando lo hice:
        git push --set-upstream origin con-14
        $ git push --set-upstream origin con-14
        Enumerating objects: 28, done.
        Counting objects: 100% (28/28), done.
        Delta compression using up to 2 threads
        Compressing objects: 100% (22/22), done.
        Writing objects: 100% (22/22), 3.65 KiB | 534.00 KiB/s, done.
        Total 22 (delta 18), reused 0 (delta 0), pack-reused 0
        remote: Analyzing objects... (22/22) (284 ms)
        remote: Storing packfile... done (55 ms)
        remote: Storing index... done (49 ms)
        To https://tercerbit.visualstudio.com/ADMC/_git/ADMC
         * [new branch]      con-14 -> con-14
        branch 'con-14' set up to track 'origin/con-14'.
        
        
        */

    }

}

