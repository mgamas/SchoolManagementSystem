import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Estudiante e1 = new Estudiante(1, "Ana", "Gómez",
                LocalDate.of(2000, 3, 15), EstadoEstudiante.MATRICULADO);
        Estudiante e2 = new Estudiante(2, "Luis", "Pérez",
                LocalDate.of(1999, 7, 9), EstadoEstudiante.MATRICULADO);

        Curso c1 = new Curso(101, "POO", "Programación Orientada a Objetos", 4, "1.0");
        Curso c2 = new Curso(102, "Estructuras", "Estructuras de Datos", 3, "2.1");

        GestorAcademico gestor = new GestorAcademico();
        gestor.matricularEstudiante(e1);
        gestor.matricularEstudiante(e2);
        gestor.agregarCurso(c1);
        gestor.agregarCurso(c2);

        try {
            gestor.inscribirEstudianteCurso(e1, 101);
            gestor.inscribirEstudianteCurso(e2, 102);
            // Intento duplicado para disparar la excepción
            gestor.inscribirEstudianteCurso(e1, 101);
        } catch (Exception ex) {
            System.out.println("⚠️ " + ex.getMessage());
        }

        gestor.mostrarEstado();
    }
}