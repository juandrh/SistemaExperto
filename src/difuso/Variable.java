package difuso;

// Clase Elemento del patr�n Composite


public class Variable  {

		public String descripcion;
		public float a,b;
	
	  public Variable(String descripcion, float a, float b ) { // a, b puntos de cambio de la funci�n de pertenencia
		  this.descripcion = descripcion;
		  this.a = a;
		  this.b = b;
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
