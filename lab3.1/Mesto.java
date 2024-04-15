package sladoled;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Mesto extends Canvas implements Runnable {
private Aparat aparat;
private Sladoled sl;
private Thread nit=new Thread(this);
private float d=0;
private boolean radi;
private ArrayList<Mini> lista=new ArrayList<Mini>();
private Color trenutna;
private int visina;



public Color getTrenutna() {
	return trenutna;
}


public void setTrenutna(Color trenutna) {
	this.trenutna = trenutna;
}


public int getVisina() {
	return visina;
}


public void setVisina(int visina) {
	this.visina = visina;
}


public ArrayList<Mini> getLista() {
	return lista;
}


public void setLista(ArrayList<Mini> lista) {
	this.lista = lista;
}


public boolean isRadi() {
	return radi;
}


public void setRadi(boolean radi) {
	this.radi = radi;
}

public void pokreni() {
	nit.start();
}

public Mesto(Aparat a) {
	this.aparat=a;
	pokreni();
}

 
public Sladoled getSl() {
	return sl;
}

public void paint(Graphics g) {
	//visina=getHeight()-(int)(getHeight()*d);
	for(int i = 0; i < lista.size(); ++i) {
		g.setColor(lista.get(i).getBoja());
		g.fillRect(0, lista.get(i).getVisina(), getWidth(), (int)(getHeight()*0.1));
	}
	//g.setColor(Color.BLACK);
	//g.fillRect(0,getHeight()-(int)(getHeight()*d),getWidth(), (int)(getHeight()*d));
     visina=getHeight()-(int)(getHeight()*d);
}
@Override
public void run()  {
	try { 
		while(!Thread.interrupted()) {
			while(radi) {
				Thread.sleep(500);
				if(d>=1.0) {//zaustavi();
				aparat.getButton().setEnabled(true);
				revalidate();
				}
		repaint();
      d+=0.1;
       }//repaint();
		}//repaint();
	} catch(InterruptedException e) {
	}
	
}


private void zaustavi() {
	if(nit!=null) nit.interrupt();
	
}


public void pokreniTocenje() {
	sl.setCasa(200);
}


public float getD() {
	return d;
}


public void setD(float d) {
	this.d = d;
}


}
