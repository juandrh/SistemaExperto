import java.util.ArrayList;
import java.util.List;

// Clase Compuesto del patrón Composite

public abstract class Operador extends Expresion {

	List<Expresion> expresiones;

	public Operador(String descripcion) {
		super(descripcion);
		expresiones = new ArrayList<Expresion>();
	}

	public void anadir(Expresion e) {

		expresiones.add(e);
	}


}
