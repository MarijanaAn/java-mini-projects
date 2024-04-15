package telefon;

import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;

public class ListaStavki extends Panel {
private ArrayList<Stavka> stavke=new ArrayList<Stavka>();
public ListaStavki() {
	setLayout(new GridLayout(0,1));
}

public void dodajStavku(Stavka s) {
	getStavke().add(s);
	add(s);
}

public ArrayList<Stavka> getStavke() {
	return stavke;
}

public void setStavke(ArrayList<Stavka> stavke) {
	this.stavke = stavke;
}
}
