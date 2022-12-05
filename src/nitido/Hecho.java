package nitido;

import java.util.List;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos con base de
 * conocimiento de ejemplo. 
 * Implementa los patrones: Interpreter, Composite y factory.
 * 
 * Sistema Experto N�tido 
 * Clase elemento del patron composite
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */


public class Hecho extends Expresion {

	
	  public Hecho(String descripcion ) {
		  super(descripcion); 
		  }
	 
	public boolean evaluar(List<Hecho> hechos)
	{
		// �Est� la descripci�n en la lista de hechos?
		for (int i = 0; i < hechos.size(); i++) {
			if(hechos.get(i).getDescripcion().equals(descripcion)) return true;
		}		
		return false;
	}
	
	
	
	public String toString() {		
		return descripcion;
	}

	
}
