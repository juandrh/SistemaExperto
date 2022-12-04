package nitido;

import java.util.List;

// Clase Elemento del patrón Composite


public class Hecho extends Expresion {

	
	  public Hecho(String descripcion ) {
		  super(descripcion); 
		  }
	 
	public boolean evaluar(List<Hecho> hechos)
	{
		// ¿Está la descripción en la lista de hechos?
		for (int i = 0; i < hechos.size(); i++) {
			if(hechos.get(i).getDescripcion().equals(descripcion)) return true;
		}		
		return false;
	}
	
	
	
	public String toString() {		
		return descripcion;
	}

	
}
