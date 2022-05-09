package modelo;

public class Asignatura {

	private String id_asignatura;
	private String nombre;
	
	public Asignatura() {
		
	}

	public Asignatura(String id_asignatura, String nombre) {
		this.id_asignatura = id_asignatura;
		this.nombre = nombre;
	}

	public String getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(String id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
