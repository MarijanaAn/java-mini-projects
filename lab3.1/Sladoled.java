package sladoled;

import java.util.ArrayList;

public class Sladoled {
private ArrayList<Ukus> ukusi= new ArrayList<Ukus> ();
private int casa;
private int kolicina;
private ArrayList<Integer> kol =new ArrayList<Integer> ();

	
	public Sladoled(int casa) {
	this.casa = casa;
}


	public ArrayList<Ukus> getUkusi() {
		return ukusi;
	}


	public void dodaj(Ukus u, int k) {
		if(ukusi.contains(u)) {
			if(k+kolicina>casa) {
				u.setKolicina(casa-kolicina+u.getKolicina());
				kolicina=casa;
			}
			else {u.setKolicina(k+u.getKolicina()) ;
				kolicina+=k;
		}
		}
			else {
		if(k+kolicina>casa) {
			u.setKolicina(casa-kolicina);
			ukusi.add(u);
			kolicina=casa;
		}
		else  {
			u.setKolicina(k);
			ukusi.add(u);
			kolicina+=k;
		}
		}
	}


	
	@Override
	public String toString() {
		StringBuilder  sb= new StringBuilder( );
		for(int i=0; i<this.ukusi.size();i++)  {
			sb.append(this.ukusi.get(i).getKolicina()).append("ml").append(this.ukusi.get(i));
		}
		return sb.toString();
	}
	
	
	public int getCasa() {
		return casa;
	}
	
	public void setCasa(int c) {
		casa=c;
	}
}


