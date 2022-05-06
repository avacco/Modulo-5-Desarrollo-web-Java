package modelo;

import java.time.LocalDate;

public class OrdenDeTrabajo {

	private int id;
	private String estado;
	private String producto;
	private String cliente;
	private int electrodomestico_id;
	private LocalDate fechaSolicitud;
	private LocalDate fechaActualizacionOrden;
	
	public OrdenDeTrabajo() {
		
	}

	public OrdenDeTrabajo(String estado, LocalDate fechaSolicitud, LocalDate fechaActualizacionOrden, int electrodomestico_id, String producto, String cliente) {
		this.estado					 = estado;
		this.fechaSolicitud 		 = fechaSolicitud;
		this.fechaActualizacionOrden = fechaActualizacionOrden;
		this.electrodomestico_id 	 = electrodomestico_id;
		this.producto 				 = producto;
		this.cliente 				 = cliente;
	}

	public OrdenDeTrabajo(int id, String estado, LocalDate fechaSolicitud, LocalDate fechaActualizacionOrden, int electrodomestico_id, String producto, String cliente) {
		this.id 					 = id;
		this.estado					 = estado;
		this.fechaSolicitud 		 = fechaSolicitud;
		this.fechaActualizacionOrden = fechaActualizacionOrden;
		this.electrodomestico_id 	 = electrodomestico_id;
		this.producto 				 = producto;
		this.cliente 				 = cliente;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getElectrodomestico_id() {
		return electrodomestico_id;
	}

	public void setElectrodomestico_id(int electrodomestico_id) {
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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}



		
}
