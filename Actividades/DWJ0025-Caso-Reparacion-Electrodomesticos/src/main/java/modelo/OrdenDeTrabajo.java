package modelo;

import java.time.LocalDate;

public class OrdenDeTrabajo {

	private int id;
	private String estado;
	private Electrodomestico electrodomestico_id;
	private LocalDate fechaSolicitud;
	private LocalDate fechaActualizacionOrden;
	
	public OrdenDeTrabajo() {
		
	}

	public OrdenDeTrabajo(String estado, LocalDate fechaSolicitud, LocalDate fechaActualizacionOrden, Electrodomestico electrodomestico_id) {
		this.estado					 = estado;
		this.fechaSolicitud 		 = fechaSolicitud;
		this.fechaActualizacionOrden = fechaActualizacionOrden;
		this.electrodomestico_id 	 = electrodomestico_id;
	}

	public OrdenDeTrabajo(int id, String estado, LocalDate fechaSolicitud, LocalDate fechaActualizacionOrden, Electrodomestico electrodomestico_id) {
		this.id 					 = id;
		this.estado					 = estado;
		this.fechaSolicitud 		 = fechaSolicitud;
		this.fechaActualizacionOrden = fechaActualizacionOrden;
		this.electrodomestico_id 	 = electrodomestico_id;
	}
	
	public OrdenDeTrabajo(int id, String estado) {
		this.id 					  = id;
		this.estado 				  = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Electrodomestico getElectrodomestico_id() {
		return electrodomestico_id;
	}

	public void setElectrodomestico_id(Electrodomestico electrodomestico_id) {
		this.electrodomestico_id = electrodomestico_id;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public LocalDate getFechaActualizacionOrden() {
		return fechaActualizacionOrden;
	}

	public void setFechaActualizacionOrden(LocalDate fechaActualizacionOrden) {
		this.fechaActualizacionOrden = fechaActualizacionOrden;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


		
}
