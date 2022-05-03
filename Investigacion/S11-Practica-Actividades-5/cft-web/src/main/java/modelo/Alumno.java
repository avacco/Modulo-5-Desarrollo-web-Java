package modelo;

import java.time.LocalDate;

public class Alumno {

	private int id;
	private String nombre;
	private Carrera carrera;
	private LocalDate fechaNacimiento;
	
	public Alumno() {
		
	}
	
	public Alumno(int id, String nombre, Carrera carrera, LocalDate fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.carrera = carrera;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Alumno(String nombre, Carrera carrera, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.carrera = carrera;
		this.fechaNacimiento = fechaNacimiento;
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

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
}
