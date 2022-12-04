package difuso;

import java.util.List;

public class Regla {

	Expresion antecedente;
	
	Variable consecuente;
	//String descConsecuente;
	

	public Regla(Expresion antecedente, Variable consecuentes) {
		this.antecedente = antecedente;
		this.consecuente = consecuente;
		
	}

	
public void aplicarRegla() {
		
		//hechos.add(consecuente);
	}

	public Variable getConsecuente() {
		
		return consecuente;
	}
		
	public String toString() {		
		return antecedente.toString() + " -> " + consecuente.getDescripcion()  ;
	}
	
	

}
