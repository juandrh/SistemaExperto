package difuso;

// Clase Elemento del patrón Composite


public class Variable  {

		public String descripcion;
		public float a,b;
	
	  public Variable(String descripcion, float a, float b ) { // a, b puntos de cambio de la función de pertenencia
		  this.descripcion = descripcion;
		  this.a = a;
		  this.b = b;
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
