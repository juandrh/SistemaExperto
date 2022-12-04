package difuso;

import java.util.List;

// Clase Componente del patrón Composite

public abstract class Expresion {

	protected String descripcion;	
	protected float a,b;
	
	public Expresion (String descripcion, float a, float b) {		
		this.descripcion = descripcion;		
		this.a = a;
		this.b = b;			
	}	
	
	public String getDescripcion () {		
		return descripcion;		
	}
	
	public abstract float fs(Callable f,float x);	
				
	
	public abstract String toString() ;
		
	
	

}
