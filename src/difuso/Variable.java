package difuso;

import java.util.List;

// Clase Elemento del patr�n Composite


public class Variable extends Expresion {

	
	  public Variable(String descripcion, float a, float b ) { // a, b puntos de inflexi�n de la funci�n de pertenencia
		  super(descripcion, a,  b );
		  }
	  
	 
	// Funciones sem�nticas (de pertenencia)
	  public float fs(Callable f,float x)	
	  {
		   return f.call(a, b, x);		
	}
	  
	 
	
	
	public String toString() {		
		return descripcion;
	}




	
}
