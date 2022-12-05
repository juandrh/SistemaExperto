package principal;

public abstract class CreadorSistemaExperto {
	
	SistemaExperto sistema;
	public abstract SistemaExperto crearSistemaExperto();
	
	public void crearVariables() {
		sistema = crearSistemaExperto();
		sistema.crearVariables();
		}

	public void añadirDatosEntrada() {		
		sistema.añadirDatosEntrada();
		}
	public void añadirReglas() {		
		sistema.añadirReglas();
		}
	public void ejecutarMotor() {		
		sistema.ejecutarMotor();
		}
	public void mostrarResultado() {		
		sistema.mostrarResultado();
		}
	
	
}
