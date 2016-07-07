
public class Verificari {
	
	public boolean dubluExemplar(Carte a, Carte b) {
		if(a.getAutor().equals(b.getAutor()) && a.getTitlu().equals(b.getTitlu()) 
			&& a.getEditura().equals(b.getEditura()) && a.getNumarPagini()==b.getNumarPagini())
				return true;
		else 	return false;
	}
	
	public Carte returneazaCarteGroasa(Carte a, Carte b) {
		if(a.getNumarPagini()>b.getNumarPagini())
			return a;
		else return b;
	}
	
	public void afisareDetalii(Carte a) {
		System.out.println("Nume carte: " + a.getTitlu().toUpperCase());
		System.out.println("Nume autor: " + a.getAutor().toLowerCase());
		System.out.println("Nume editura: " + a.getEditura());
	}
	
	public Verificari(){
		
	}
}
