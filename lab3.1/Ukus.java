package sladoled;

import java.awt.Color;

public class Ukus {
private String naziv;
private Color boja;
private int kolicina;


public int getKolicina() {
	return kolicina;
}
public void setKolicina(int kolicina) {
	this.kolicina = kolicina;
}
public Ukus(String naziv, Color boja) {
	this.naziv = naziv;
	this.boja = boja;
}
public String getNaziv() {
	return naziv;
}
public Color getBoja() {
	return boja;
}
@Override
public boolean equals(Object o) {
	if(this==o) return true;
	if(o==null) return false;
	if(getClass()!=o.getClass()) return false;
	Ukus u=(Ukus) o;
	if(naziv!=u.naziv) return false;
	else return true;
}
@Override
public String toString() {
	return "[" + naziv + "]";
}


}
