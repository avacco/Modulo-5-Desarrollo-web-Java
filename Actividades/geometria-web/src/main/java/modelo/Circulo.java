package modelo;

public class Circulo implements Figura{
	
	private double diametro;
	
	public Circulo(double diametro) {
		super();
		this.diametro = diametro;
	}


	public Circulo() {
		super();
	}
	


	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}

	

	public double radioCirculo() {
		return this.diametro / 2;
	}


	@Override
	public double calcularArea() {
		return Math.PI * Math.pow((diametro/2), 2);
	}


	@Override
	public double calcularPerimetro() {
		return Math.PI * this.diametro;
	}
	

}
