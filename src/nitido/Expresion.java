package nitido;

import java.util.List;

// Clase Componente del patrón Composite

public abstract class Expresion {

	protected String descripcion;	
	
	public Expresion (String descripcion) {		
		this.descripcion = descripcion;		
	}
	
	public String getDescripcion () {		
		return descripcion;		
	}
	
	public abstract boolean evaluar(List<Hecho> hechos);	
		
	public abstract String toString() ;
		
	
	

}
