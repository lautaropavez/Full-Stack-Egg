package Libros;
//  1. Crear una clase llamada Libro que contenga los siguientes atributos: ISBN, Título,
//  Autor, Número de páginas, y un constructor con todos los atributos pasados por
//  parámetro y un constructor vacío. Crear un método para cargar un libro pidiendo los
//  datos al usuario y luego informar mediante otro método el número de ISBN, el título,
//  el autor del libro y el numero de páginas.

public class Libro {

    // debemos especificar las caracteristicas comunes.
    private String ISBN;
    private String titulo;
    private String autor;
    private int numPaginas;
    
    public Libro(){ //constructor vacío
	}
    
    //     @param ISBN
    //     @param titulo;
    //     @param autor
    //     @param numPaginas
     
    public Libro(String ISBN, String titulo, String autor, int numPaginas){ //Los constructores no se pueden repetir, por lo que para diferenciarlos hay que ponerle argumentos;
        
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }
    
    public void setnumero_libro(String ISBN){       //MÉTODO SETTER
  
        this.ISBN = ISBN;
    }
    
    public String getDimeISBN(){                    //MÉTODO GETTER
        return "Número de ISBN: " + ISBN + ".";
    }
    
    public void settitulo_libro(String titulo){     //MÉTODO SETTER
    
        this.titulo = titulo;
    }
    
    public String getDimetitulo(){                 //MÉTODO GETTER
        return "El titulo del libro es: " + titulo + ".";
    }
    
    public void setautor_libro(String autor){     //MÉTODO SETTER
    
        this.autor = autor;
    }
    
    public String getDimeautor(){                 //MÉTODO GETTER
        return "El nombre del autor es: " + autor + ".";
    }
    
    public void setpaginas_libro(int numPaginas){ //MÉTODO SETTER
    
        this.numPaginas = numPaginas;
    }
    
    public int getDime_num_pag(){                 //MÉTODO GETTER
            return numPaginas;
    }
    
    public String toString(){                     //MÉTODO GETTER
	return "[ Libro ] \nISBN = " + ISBN + " \nTitulo = " + titulo + " \nAutor = " +     //apretamos alt + Insert y ponemos toString, lo cual nos devuelve una funcion 
                autor + " \nNumero de Paginas = " + numPaginas;                             //que nos devuelve un mensaje formateado y armado según cada libro
    }
}
