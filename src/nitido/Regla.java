package nitido;

import java.util.List;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos con base de
 * conocimiento de ejemplo. 
 * Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Sistema Experto N�tido Clase para reglas
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */

public class Regla {

	Expresion antecedente;
	Hecho consecuente;
	List<Hecho> hechos;

	public Regla(Expresion antecedente, Hecho consecuente, List<Hecho> hechos) {
		this.antecedente = antecedente;
		this.consecuente = consecuente;
		this.hechos = hechos;
	}

	public boolean esAplicable() {
		return antecedente.evaluar(hechos);
	}

	public void aplicarRegla() {

		hechos.add(consecuente);
	}

	public Hecho getConsecuente() {

		return consecuente;
	}

	public String toString() {
		return antecedente.toString() + " -> " + consecuente.getDescripcion();
	}

}
