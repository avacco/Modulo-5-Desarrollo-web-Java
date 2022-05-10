package modelo;

public class Estudiante {

	private int id;
	private String nombre1;
	private String nombre2;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String rut;
	private String dv;
	private String genero;
	private String fono;
	private String curso;
	
	public Estudiante() {
		
	}

	

	public Estudiante(int id, String nombre1, String nombre2, String apellidoPaterno, String apellidoMaterno,
			String rut, String dv, String genero, String fono, String curso) {
		this.id = id;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.rut = rut;
		this.dv = dv;
		this.genero = genero;
		this.fono = fono;
		this.curso = curso;
	}
	
	public Estudiante(String nombre1, String nombre2, String apellidoPaterno, String apellidoMaterno,
			String rut, String dv, String genero, String fono, String curso) {
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.rut = rut;
		this.dv = dv;
		this.genero = genero;
		this.fono = fono;
		this.curso = curso;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	
	
}
