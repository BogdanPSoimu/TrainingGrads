
public class Main {

	public static void main(String[] args) {
		NumarComplex a = new NumarComplex(10.54f,9.56f);
		NumarComplex b = new NumarComplex(5.23f,4.24f);
		Operatii o=new Operatii();

		o.adunare(a,b);
		o.scadere(a,b);
	}

}
