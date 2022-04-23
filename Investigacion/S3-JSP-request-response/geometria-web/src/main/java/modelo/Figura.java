package modelo;

interface Figura {
	// Estos metodos estan vacios porque no hay modo de acceder a ellos,
	// seran heredados por los hijos de la clase Figura.
	public abstract double calcularArea();
	public abstract double calcularPerimetro();
}
