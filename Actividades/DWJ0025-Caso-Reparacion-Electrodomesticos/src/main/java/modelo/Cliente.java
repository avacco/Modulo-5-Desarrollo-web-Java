package modelo;

import java.util.ArrayList;

public class Cliente {
	
	private int id;
	private String nombre;
	private String telefono;
	private String direccion;
	private ArrayList<Electrodomestico> electrodomesticos;
	
	public Cliente() {
		
	}
	
	public Cliente(String nombre, String telefono, String direccion) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	
	public Cliente(int id, String nombre, String telefono, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Electrodomestico> getElectrodomesticos() {
		return electrodomesticos;
	}

	public void setElectrodomesticos(ArrayList<Electrodomestico> electrodomesticos) {
		this.electrodomesticos = electrodomesticos;
	}

	
	
	
}
