package difuso;

import java.util.List;

// Clase Elemento del patrón Composite


public class Variable extends Expresion {

	
	  public Variable(String descripcion, float a, float b ) { // a, b puntos de inflexión de la función de pertenencia
		  super(descripcion, a,  b );
		  }
	  
	 
	// Funciones semánticas (de pertenencia)
	  public float fs(Callable f,float x)	
	  {
		   return f.call(a, b, x);		
	}
	  
	 
	
	
	public String toString() {		
		return descripcion;
	}




	
}
