import java.util.*;

public class GestorAcademico implements ServiciosAcademicosI {
    private final List<Estudiante> estudiantes = new ArrayList<>();
    private final List<Curso> cursos           = new ArrayList<>();
    // idCurso → conjunto de idEstudiante
    private final Map<Integer, Set<Integer>> inscripciones = new HashMap<>();

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (estudiantes.stream().noneMatch(e -> e.getId() == estudiante.getId()))
            estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (cursos.stream().noneMatch(c -> c.getId() == curso.getId()))
            cursos.add(curso);
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso)
            throws EstudianteYaInscritoException {
        if (cursos.stream().noneMatch(c -> c.getId() == idCurso))
            throw new IllegalArgumentException("Curso no existe");

        inscripciones.putIfAbsent(idCurso, new HashSet<>());
        Set<Integer> inscritos = inscripciones.get(idCurso);
        if (!inscritos.add(estudiante.getId()))
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en el curso");
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso)
            throws EstudianteNoInscritoEnCursoException {
        Set<Integer> inscritos = inscripciones.get(idCurso);
        if (inscritos == null || !inscritos.remove(idEstudiante))
            throw new EstudianteNoInscritoEnCursoException("El estudiante no estaba inscrito");
    }

    /* Métodos utilitarios solo para demo */
    public void mostrarEstado() {
        System.out.println("=== Estudiantes ===");
        estudiantes.forEach(System.out::println);
        System.out.println("=== Cursos ===");
        cursos.forEach(System.out::println);
        System.out.println("=== Inscripciones ===");
        inscripciones.forEach((id, set) ->
                System.out.println("Curso " + id + " → " + set));
    }
}