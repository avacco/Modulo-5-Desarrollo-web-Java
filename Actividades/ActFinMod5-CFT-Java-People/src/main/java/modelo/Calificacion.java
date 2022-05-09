package modelo;

public class Calificacion {
	
	private int numeroEvaluacion;
	private float nota;
	private Estudiante estudiante;
	private Calificacion calificacion;
	
	public Calificacion() {
		
	}
	
	public Calificacion(int numeroEvaluacion, float nota, Estudiante estudiante, Calificacion calificacion) {
		this.numeroEvaluacion = numeroEvaluacion;
		this.nota = nota;
		this.estudiante = estudiante;
		this.calificacion = calificacion;
	}

	public int getNumeroEvaluacion() {
		return numeroEvaluacion;
	}

	public void setNumeroEvaluacion(int numeroEvaluacion) {
		this.numeroEvaluacion = numeroEvaluacion;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Calificacion getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}
	
	

}
