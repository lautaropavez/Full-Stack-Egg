package hoteles;

public class Hotel {
    
    protected Integer cantidadHabitaciones; // protected significa que el atributo es publico para la familia y privado para los externos a la familia, es decir

    public Hotel(Integer cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public Integer getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }
    
    
}
