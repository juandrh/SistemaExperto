package principal;

public interface SistemaExperto {
	
	public abstract void crearVariables();
	public abstract void a�adirDatosEntrada();  // Base de conocimiento: Inputs, Hechos 
	public abstract void a�adirReglas();  // Base de conocimiento: Reglas
	public abstract void ejecutarMotor();  // Motor inferencia
	public abstract void mostrarResultado(); // Acci�n a realizar

}
