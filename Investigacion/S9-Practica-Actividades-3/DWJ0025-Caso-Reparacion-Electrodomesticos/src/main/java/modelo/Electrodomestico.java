package modelo;

public class Electrodomestico {

	private int id;
	private String nombre;
	private String falla;
	private String cliente;
	
	public Electrodomestico() {
		
	}
	
	public Electrodomestico(int id, String nombre, String falla, String cliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.falla = falla;
		this.cliente = cliente;
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

	public String getFalla() {
		return falla;
	}

	public void setFalla(String falla) {
		this.falla = falla;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
}
