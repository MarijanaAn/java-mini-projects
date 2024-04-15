package brojevi;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Polje extends Canvas {
private Mreza mreza;
protected int x=75, y=75;
public enum Status {SLOBODNO, IZABRANO};
private Status status=Status.SLOBODNO;
private int broj;
private Label br=new Label();


public Polje(Mreza m, int b) {
	super();
	setBounds(0,0,10,10);
	mreza=m;
	broj=b;
	addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
			if(getStatus()==Status.SLOBODNO) {
				setStatus(Status.IZABRANO);
				m.azuriraj();
				repaint();
				
			} else {setStatus(Status.SLOBODNO);
			m.azuriraj();
			repaint();
			}
			}
	});
	setBackground(Color.orange);
	
}

public void paint(Graphics g) {
	if (status==Status.IZABRANO) {
		g.setColor(Color.BLUE);
		g.fillOval(0, 0, getWidth(), getHeight());
		drawBroj(broj);
		
		
	}
	if(status==Status.SLOBODNO) {
		g.setColor(Color.ORANGE);
		drawS(broj);
	}
}


public void drawS(int broj) {
	Graphics g=getGraphics();
	g.setColor(Color.BLACK);
	g.setFont(new Font(null, Font.BOLD,min()/3));
	int visina=(int)g.getFontMetrics().getStringBounds(""+broj, g).getHeight();
	int sirina=(int)g.getFontMetrics().getStringBounds(""+broj, g).getWidth();
	g.drawString(""+broj,getWidth()/2-sirina/2, getHeight()/2+visina/2);

}

public int min() {
	if(getWidth() >getHeight() ) {
		return getHeight();
	}else return getWidth();
}




public void drawBroj(int broj) {
	Graphics g=getGraphics();
	g.setColor(Color.WHITE);
	int visina=(int)g.getFontMetrics().getStringBounds(""+broj, g).getHeight();
	int sirina=(int)g.getFontMetrics().getStringBounds(""+broj, g).getWidth();
	g.setFont(new Font(null, Font.BOLD,min()/3));
	g.drawString(""+broj,  getWidth()/2-sirina/2,  getHeight()/2+visina/2);
	//g.setFont(new Font(null, Font.BOLD,min()/3));

}

public Status getStatus() {
	return status;
}

public void setStatus(Status status) {
	this.status = status;
}

public int getBroj() {
	return broj;
}


}
