package telefon;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

public class Telefon extends Panel {
private Broj broj;
private Color boja;
private Imenik imenik;
private Tastatura tastatura;
public Telefon(Broj broj, Color boja) {
	this.broj = broj;
	this.boja = boja;
	setLayout(new GridLayout(0,1));
	add(tastatura);
	add(imenik);
}
public Broj getBroj() {
	return broj;
}


/*public String dodajKontakt() {
	
}*/

}
