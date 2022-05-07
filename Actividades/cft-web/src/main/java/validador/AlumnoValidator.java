package validador;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

import modelo.Alumno;

public class AlumnoValidator {
	
	private String id;
	private String nombre;
	private String fechaNacimiento;
	
	private int idValidado;
	private String nombreValidado;
	private LocalDate fechaNacimientoValidada;
	
	private Map<String, String> errores = new HashMap<String, String>();
	
	
	public AlumnoValidator(String id, String nombre, String fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	

	public Alumno makeObject() {
		if(isValid()) {
			return new Alumno(idValidado,nombreValidado,null,fechaNacimientoValidada);
		} else {
			return null;
		}
	}
	
	public boolean isValid() {
		boolean isIdValid 				= isIdValid();
		boolean isNombreValid 			= isNombreValid();
		boolean isFechaNacimientoValid 	= isFechaNacimientoValid();
		
		if( isIdValid && isNombreValid && isFechaNacimientoValid) {
			return true;
		} else {		
			return false;
		}
	}

	
	// chequea si los atributos son validos segun reglas establecidas
	
	public boolean isFechaNacimientoValid() {
		try {
			fechaNacimientoValidada = LocalDate.parse(this.fechaNacimiento);
		} catch (DateTimeParseException e) {
			errores.put("fechaNacimiento", "El formato de la fecha de nacimiento no es valido");
			return false;
		}
		
		LocalDate ahora 	= LocalDate.now();
		Period periodoEdad 	= Period.between(ahora, fechaNacimientoValidada);
		int edad 			= Math.abs(periodoEdad.getYears());
		
		if(edad >= 18) {
			return true;
		}else {
			errores.put("fechaNacimiento", "Debe ser mayor de edad");
			return false;
		}
	}

	public boolean isNombreValid() {
		if(nombre.length() > 3) {
			nombreValidado = nombre;
			return true;
		} else {
			errores.put("nombre", "El nombre es demasiado corto");
			return false;
		}
	}

	public boolean isIdValid() {
		try {
			idValidado = Integer.parseInt(id);			
		} catch(Exception e) {
			idValidado = 0;
		}
		return true;
	}
	
	public Map<String, String> getErrores() {
		return errores;
	}
	

}
