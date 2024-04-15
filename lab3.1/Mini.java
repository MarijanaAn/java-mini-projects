package sladoled;


import java.awt.Color;

public class Mini{
	public int visina;
	public Color boja;
	public int getVisina() {
		return visina;
	}
	public void setVisina(int visina) {
		this.visina = visina;
	}
	public Color getBoja() {
		return boja;
	}
	public void setBoja(Color boja) {
		this.boja = boja;
	}
	public Mini(int v, Color c) {
		visina = v; boja = c;
	}
}