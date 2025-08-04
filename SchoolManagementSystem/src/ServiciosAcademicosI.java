public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante);
    void agregarCurso(Curso curso);
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso)
            throws EstudianteYaInscritoException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso)
            throws EstudianteNoInscritoEnCursoException;
}

/* Excepciones personalizadas */
class EstudianteYaInscritoException extends Exception {
    public EstudianteYaInscritoException(String msg) { super(msg); }
}
class EstudianteNoInscritoEnCursoException extends Exception {
    public EstudianteNoInscritoEnCursoException(String msg) { super(msg); }
}