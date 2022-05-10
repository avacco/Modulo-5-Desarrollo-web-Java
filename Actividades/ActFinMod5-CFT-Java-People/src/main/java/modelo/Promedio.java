package modelo;

public class Promedio {

	private float promedio;
	private Asignatura asignatura;
	private Estudiante estudiante;
	
	public Promedio(float promedio, Asignatura asignatura, Estudiante estudiante) {
		this.promedio = promedio;
		this.asignatura = asignatura;
		this.estudiante = estudiante;
	}

	public float getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
}
