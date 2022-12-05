package principal;

public interface SistemaExperto {
	
	public abstract void crearVariables();
	public abstract void añadirDatosEntrada();  // Base de conocimiento: Inputs, Hechos 
	public abstract void añadirReglas();  // Base de conocimiento: Reglas
	public abstract void ejecutarMotor();  // Motor inferencia
	public abstract void mostrarResultado(); // Acción a realizar

}
