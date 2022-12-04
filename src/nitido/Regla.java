package nitido;

import java.util.List;

public class Regla {

	Expresion antecedente;
	Hecho consecuente;
	//String descConsecuente;
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
		return antecedente.toString() + " -> " + consecuente.getDescripcion()  ;
	}
	
	

}
