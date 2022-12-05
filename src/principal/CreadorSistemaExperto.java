package principal;

/**
 * Aplicaci�n creadora de sistemas expertos n�tidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Creador de sistemas expertos
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */

public abstract class CreadorSistemaExperto {
	
	SistemaExperto sistema;
	public abstract SistemaExperto crearSistemaExperto();
	
	public void crearVariables() {
		sistema = crearSistemaExperto();
		sistema.crearVariables();
		}

	public void a�adirDatosEntrada() {		
		sistema.a�adirDatosEntrada();
		}
	public void a�adirReglas() {		
		sistema.a�adirReglas();
		}
	public void ejecutarMotor() {		
		sistema.ejecutarMotor();
		}
	public void mostrarResultado() {		
		sistema.mostrarResultado();
		}
	
	
}
