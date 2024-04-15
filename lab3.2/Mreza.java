package brojevi;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;

import brojevi.Polje.Status;

public class Mreza extends Panel {
	
	private Polje[][] matricaPolja;
	private int vrsta=4, kolona=5;
	private ArrayList<Polje> izabrano= new ArrayList<Polje>();
	private Igra igra;
	
	
	
	public Mreza(int v, int k, Igra igra) {
		matricaPolja=new Polje[v][k];
		this.vrsta=v;
		this.kolona=k;
		this.igra=igra;
		this.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(v,k, 3,3));
		int br=0;
		for(int i=0;i<v;i++) {
			for(int j=0;j<k;j++) {
				matricaPolja[i][j]=new Polje(this, br);
				br++;
				add(matricaPolja[i][j]);
			}
		}
		matricaPolja[2][3].setStatus(Status.IZABRANO);
		
		
	}
	
	public int brojIzabranih() {
		azuriraj();
		return izabrano.size();		}

	public int getVrsta() {
		return vrsta;
	}

	public int getKolona() {
		return kolona;
	}
	
	public void azuriraj() {
		izabrano.clear();
		for(int i=0; i<vrsta;i++) {
			for (int j=0;j<kolona;j++) {
				if(matricaPolja[i][j].getStatus()==Status.IZABRANO)
					izabrano.add(matricaPolja[i][j]);
			}
	}
		//getIgra().setKvota();
		//getIgra().setDobitak();
		
	}

	public ArrayList<Polje> getIzabrano() {
		return izabrano;
	}

	public Igra getIgra() {
		return igra;
	}
	
	
}
