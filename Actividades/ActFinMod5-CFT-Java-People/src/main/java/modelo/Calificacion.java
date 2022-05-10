package modelo;

public class Calificacion {
	
	private int numeroEvaluacion;
	private float nota;
	private int id_estudiante;
	private int id_asignatura;
	
	public Calificacion() {
		
	}
	
	public Calificacion(int numeroEvaluacion, float nota, int id_estudiante, int id_asignatura) {
		this.numeroEvaluacion = numeroEvaluacion;
		this.nota = nota;
		this.id_estudiante = id_estudiante;
		this.id_asignatura = id_asignatura;
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

	public int getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public int getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(int id_asignatura) {
		this.id_asignatura= id_asignatura;
	}
	
	

}
