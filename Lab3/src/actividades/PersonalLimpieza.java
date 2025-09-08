package actividades;

import java.util.ArrayList;
import java.util.List;

public class PersonalLimpieza {
    private int idPersonalLimpieza;
    private String nombrePersonalLimpieza;
    private String contactoPersonalLimpieza;
    private List<Habitacion> habitacionesAsignadasLimpieza;

    public PersonalLimpieza(int idPersonalLimpieza, String nombrePersonalLimpieza, String contactoPersonalLimpieza) {
        this.idPersonalLimpieza = idPersonalLimpieza;
        this.nombrePersonalLimpieza = nombrePersonalLimpieza;
        this.contactoPersonalLimpieza = contactoPersonalLimpieza;
        this.habitacionesAsignadasLimpieza = new ArrayList<>();
    }

    public void asignarHabitacion(Habitacion habitacion) {
        habitacionesAsignadasLimpieza.add(habitacion);
    }

    public List<Habitacion> getHabitacionesAsignadasLimpieza() {
        return habitacionesAsignadasLimpieza;
    }

    public int getIdPersonalLimpieza() {
        return idPersonalLimpieza;
    }

    public String getNombrePersonalLimpieza() {
        return nombrePersonalLimpieza;
    }

    public String getContactoPersonalLimpieza() {
        return contactoPersonalLimpieza;
    }
}