package modelo;

import java.time.LocalDate;

public class Alumno {

	private int id;
	private String nombre;
	private Carrera carrera_id;
	private LocalDate fechaNacimiento;
	
	public Alumno() {
		
	}
	
	public Alumno(int id, String nombre, Carrera carrera_id, LocalDate fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.carrera_id = carrera_id;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Alumno(String nombre, Carrera carrera_id, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.carrera_id = carrera_id;
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
		return carrera_id;
	}

	public void setCarrera(Carrera carrera_id) {
		this.carrera_id = carrera_id;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
}
