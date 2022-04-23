package modelo;

public class Triangulo implements Figura {
	
	private double base;
	private double altura;
	private double caateto1;
	private double cateto2;
	
	public Triangulo() {
		super();
	}
	
	public Triangulo(double base, double altura, double caateto1, double cateto2) {
		super();
		this.base = base;
		this.altura = altura;
		this.caateto1 = caateto1;
		this.cateto2 = cateto2;
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

	public double getCaateto1() {
		return caateto1;
	}

	public void setCaateto1(double caateto1) {
		this.caateto1 = caateto1;
	}

	public double getCateto2() {
		return cateto2;
	}

	public void setCateto2(double cateto2) {
		this.cateto2 = cateto2;
	}
	

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcularPerimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

}
