
package entidades;

import java.util.Date;

/**
 *
 * @author Lautaro Pavez
 */
public class Estancia {
    
    private Integer id_estancia;
    private Cliente cliente;
    private Casa casa;
//  private Integer id_cliente;
//  private Integer id_casa;
    private String nombre_huesped;
    private Date fecha_desde;
    private Date fecha_hasta;

    public Estancia() {
        this.cliente = new Cliente();
        this.casa = new Casa();
    }

    public Estancia(Integer id_estancia, Cliente cliente, Casa casa, String nombre_huesped, Date fecha_desde, Date fecha_hasta) {
        this.id_estancia = id_estancia;
        this.cliente = cliente;
        this.casa = casa;
        this.nombre_huesped = nombre_huesped;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
    }

    public Integer getId_estancia() {
        return id_estancia;
    }

    public void setId_estancia(Integer id_estancia) {
        this.id_estancia = id_estancia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getNombre_huesped() {
        return nombre_huesped;
    }

    public void setNombre_huesped(String nombre_huesped) {
        this.nombre_huesped = nombre_huesped;
    }

    public Date getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(Date fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public Date getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(Date fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }
 
}
