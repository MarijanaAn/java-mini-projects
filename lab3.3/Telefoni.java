package telefon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Telefoni extends Frame {
	
	private Tastatura t;
	private Stavka stavka;
public Telefoni() {
	setBounds(700,200,500,300);
	setResizable(true);
	setTitle("Telefoni");
	setLayout(new BorderLayout());
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			dispose();
		}
	});
	setVisible(true);
	setBackground(Color.CYAN);
	populateWindow() ;

	/*Stavka stavka1=new Stavka("natpis", "tekst");
	Stavka stavka2=new Stavka("natpi", "teks");
	ListaStavki l=new ListaStavki();
	l.dodajStavku(stavka1);
	l.dodajStavku(stavka2);
	add(l);*/
	revalidate();
}

private void populateWindow() {
	setBackground(Color.CYAN);
	Panel tast=new Panel();
	add(tast, BorderLayout.SOUTH);
	tast.setBackground(Color.YELLOW);
	tast.setLayout(new BorderLayout());
	
	Tastatura t=new Tastatura("s");
	tast.add(t, BorderLayout.CENTER);
	t.setBackground(Color.PINK);
	
}

public static void main(String [] args) {
	new Telefoni();
}
}
