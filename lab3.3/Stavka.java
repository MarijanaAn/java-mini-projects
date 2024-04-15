package telefon;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Stavka extends Panel {
	protected Label naslov=new Label();
	protected Label tekst=new Label();
	public Stavka(String n, String t) {
		setLayout(new GridLayout(0,1));
        naslov.setText(n);
     naslov.setFont(new Font(null, Font.BOLD, 15));
     add(naslov);
        tekst.setText(t);
add(tekst);
	}
	
	public void promeniNaslov(Label naslov) {
		this.naslov = naslov;
	}

	public Label getNaslov() {
		return naslov;
	}

	public Label getTekst() {
		return tekst;
	}
	

	
	
}
