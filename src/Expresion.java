
// Clase Componente del patrón Composite

public abstract class Expresion {

	protected String descripcion;
	
	protected boolean valor ;
	public abstract boolean evaluar();
	public abstract String getDescripcion();
	public abstract boolean contiene(Expresion exp);
	
	public String toString() {		
		return descripcion;
	}
	
	

}
