package difuso;

public class FSMas extends FSemantica implements Callable {

	@Override
	public float call(float a, float b, float x) {
		 float valor;
			if (x>b) {
				valor = 1.0f;
			} else if (x>(a+b)/2) {
				valor = x;
			} else {
				valor = 0.0f;
			}		
			
			return valor;
	}


	
}
