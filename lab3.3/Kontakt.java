package telefon;

public class Kontakt extends Stavka {
private String ime;
private String br;
private Broj broj=new Broj(br);
	public Kontakt(String n, String broj) {
		super(n, broj);
		
	}

}
