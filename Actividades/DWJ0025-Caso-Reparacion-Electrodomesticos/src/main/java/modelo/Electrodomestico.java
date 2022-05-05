package modelo;

public class Electrodomestico {

	private int id;
	private String nombre;
	private String falla;
	private Cliente cliente_id;
	
	public Electrodomestico() {
		
	}
	
	public Electrodomestico(String nombre, String falla, Cliente cliente_id) {
		this.nombre 	= nombre;
		this.falla 		= falla;
		this.cliente_id = cliente_id;
	}
	
	public Electrodomestico(int id, String nombre, String falla, Cliente cliente_id) {
		this.id 		= id;
		this.nombre 	= nombre;
		this.falla 		= falla;
		this.cliente_id = cliente_id;

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

	public Cliente getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Cliente cliente_id) {
		this.cliente_id = cliente_id;
	}




	
	
}
