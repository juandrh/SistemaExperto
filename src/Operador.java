import java.util.ArrayList;
import java.util.List;

// Clase Compusto del patrón Composite

public abstract class Operador extends Expresion {

	List<Expresion> expresiones;
	
	public Operador() {
		super();
		expresiones = new ArrayList<Expresion>();
	}
	
	public void anadir(Expresion e) {
		
		expresiones.add(e); }

	

}
