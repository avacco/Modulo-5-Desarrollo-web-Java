package modelo;

public class Rectangulo implements Figura {
	
	private double base;
	private double altura;
	
	public Rectangulo(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}

	public Rectangulo() {
		super();
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		return this.base * this.altura;
	}

	@Override
	public double calcularPerimetro() {
		return (this.base * 2) + (this.altura * 2);
	}



}
