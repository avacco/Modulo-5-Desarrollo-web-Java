package modelo;

public class Alumno {
	
	private int id;
	private String nombre;
	private String rut;
	private String direccion;
	private String comuna;
	
	public Alumno() {
		
	}
	
	public Alumno(int id, String nombre, String rut, String direccion, String comuna) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rut = rut;
		this.direccion = direccion;
		this.comuna = comuna;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	
	
}
