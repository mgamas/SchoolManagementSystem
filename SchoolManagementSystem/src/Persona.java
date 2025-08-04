
import java.time.LocalDate;

public class Persona {
    private final int id;
    private String nombre;
    private String apellido;
    private LocalDate fechaDeNacimiento;

    public Persona(int id, String nombre, String apellido, LocalDate fechaDeNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public LocalDate getFechaDeNacimiento() { return fechaDeNacimiento; }
}
