package principal;

import difuso.SEDifuso;

public class CreadorSistemaExpertoDifuso extends CreadorSistemaExperto{

	@Override
	public SistemaExperto crearSistemaExperto() {
		System.out.println("Creando sistema experto difuso ...");
		return new SEDifuso();
		
	}

	

}
