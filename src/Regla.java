public class Regla {

	Expresion antecedente;
	Hecho consecuente;

	public Regla(Expresion antecedente, Hecho consecuente) {
		this.antecedente = antecedente;
		this.consecuente = consecuente;
	}

	public boolean esAntecedente(Expresion exp) {
		return exp.contiene(exp);
	}

	public Hecho getConsecuente() {
		return consecuente;
	}
	
	public String toString() {		
		return antecedente.getDescripcion() + " -> " + consecuente.getDescripcion()  ;
	}

}
