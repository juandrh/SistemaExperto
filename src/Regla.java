public class Regla {

	Expresion antecedente;
	Hecho consecuente;

	public Regla(Expresion antecedente, Hecho consecuente) {
		this.antecedente = antecedente;
		this.consecuente = consecuente;
	}

	public boolean esAntecedente(Expresion exp) {
		return exp.equals(antecedente);
	}

	public Hecho getConsecuente() {
		return consecuente;
	}
	
	public String toString() {		
		return antecedente.descripcion + " -> " + consecuente.descripcion  ;
	}

}
