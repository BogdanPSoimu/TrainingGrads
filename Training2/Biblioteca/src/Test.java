import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
	    String titlu1 = s.nextLine();
	    String autor1 = s.nextLine();
	    String editura1 = s.nextLine();
	    int numarPagini1 = s.nextInt();
	    
		Carte carte1 = new Carte(titlu1, autor1, editura1, numarPagini1);
		
		Carte carte2 = new Carte("adeq", "EUGEN", "EdiT",55);
		
		Verificari verif = new Verificari();
		
		Carte c = new Carte();
		c=verif.carteGroasa(carte1, carte2);
		verif.afisareDetalii(c);
		
		if(verif.dubluExemplar(carte1, carte2)==true)
			System.out.println("Cartea este in dublu exemplar.");
		else System.out.println("Cartea nu este in dublu exemplar.");
	}
	
}
