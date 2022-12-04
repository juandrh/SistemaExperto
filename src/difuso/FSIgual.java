package difuso;

public class FSIgual  implements Callable {

	@Override
	public float call(float a, float b, float x) {
		  float valor;
			if (x<a || x>b) {
				valor = 0.0f;
			} else if (x<(a+b)/2) {
				valor = x+1.0f;
			} else {
				valor = -x+1.0f;
			}	
			return valor;
	}


	
}
