import java.time.LocalDate;

public class Estudiante extends Persona {
    private EstadoEstudiante estado;

    public Estudiante(int id, String nombre, String apellido,
                      LocalDate fechaDeNacimiento, EstadoEstudiante estado) {
        super(id, nombre, apellido, fechaDeNacimiento);
        this.estado = estado;
    }

    public EstadoEstudiante getEstado() { return estado; }
    public void setEstado(EstadoEstudiante estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "%d - %s %s (%s)".formatted(getId(), getNombre(), getApellido(), estado);
    }
}

enum EstadoEstudiante { MATRICULADO, INACTIVO, GRADUADO }