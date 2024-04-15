package telefon;

public class Broj {
private int kod;
private int pozivniBroj;
private int brPretplatnika;
private String s;
private int d;

public Broj(int kod, int pozivniBroj, int brPretplatnika) {
	this.kod = kod;
	this.pozivniBroj = pozivniBroj;
	this.brPretplatnika = brPretplatnika;
}
public Broj(String st) {
	this.s=st;
	pretvori(st);
}

public void pretvori(String s) {
	this.kod=Integer.parseInt(s.substring(0,3));
	this.pozivniBroj=Integer.parseInt(s.substring(3,5));
	this.brPretplatnika=Integer.parseInt(s.substring(5));
}
public String getS() {
	return s;
}
public int getKod() {
	return kod;
}

public int getPozivniBroj() {
	return pozivniBroj;
}

public int getBrPretplatnika() {
	return brPretplatnika;
}

public boolean proveraDrzave(Broj b) {
	if(this.getKod()==b.getKod()) {return true;}
	else return false;
}

public boolean proveraMreze(Broj b) {
	if(this.getKod()==b.getKod() && this.getPozivniBroj()==b.getPozivniBroj()) {return true;}
	else return false;
}


@Override
public boolean equals(Object o) {
	if(this==o) return true;
	if(o==null) return false;
	//if(getClass()!=o.getClass() ) return false;
	Broj b=(Broj) o;
	if(this.getBrPretplatnika()!=b.getBrPretplatnika() || this.proveraMreze(b)==false) { return false;} else {
	return true;
	}
}

@Override
public String toString() {
	return "+" + kod + pozivniBroj + " " + brPretplatnika;
}






}
