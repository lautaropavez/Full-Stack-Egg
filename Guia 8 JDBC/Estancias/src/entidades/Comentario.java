
package entidades;

/**
 *
 * @author Lautaro Pavez
 */
public class Comentario {
    
    private Integer id_comentario;
    private Casa casa;
    private String comentario;

    public Comentario() {
    }

    public Comentario(Integer id_comentario, Casa casa, String comentario) {
        this.id_comentario = id_comentario;
        this.casa = casa;
        this.comentario = comentario;
    }

    public Integer getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Integer id_comentario) {
        this.id_comentario = id_comentario;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}
