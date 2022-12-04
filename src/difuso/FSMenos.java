package difuso;

public class FSMenos  implements Callable {

	@Override
	public float call(float a, float b, float x) {
		float valor;
		if (x<a) {
			valor = 1.0f;
		} else if (x<(a+b)/2) {  // punto medio 
			valor = -x;
		} else {
			valor = 0.0f;
		}		
		return valor;		
	}


	
}
