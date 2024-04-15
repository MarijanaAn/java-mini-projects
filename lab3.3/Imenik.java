package telefon;

import java.awt.Component;

public class Imenik extends ListaStavki {

	@Override
	public void dodajStavku(Stavka s) {
		if(s instanceof Kontakt) add(s);
	}
	
	public String dohvatiIme(Broj broj) throws GNePostoji {
		String s = null;
		boolean postoji=false;
		for(int i=0;i<getStavke().size();i++) {
			if(broj.getS()==getStavke().get(i).getTekst().getText()) {
		 s= getStavke().get(i).getNaslov().getText();
		 postoji=true;}
		}
		if(postoji) {
		return s;
		}else throw new GNePostoji();
	}
	
	
	
	public String dohvatiBroj(String ime) throws GNePostoji {
		String s = null;
		boolean postoji=false;
		for(int i=0;i<getStavke().size();i++) {
			if(ime==getStavke().get(i).getNaslov().getText()) {
		 s= getStavke().get(i).getTekst().getText();
			postoji=true;}
		}
		if(postoji) {
		return s;
		}
		else throw new GNePostoji();
	}
}
