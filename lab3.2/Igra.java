package brojevi;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import brojevi.Polje.Status;

public class Igra extends Frame {
	
	private Mreza mreza;
	private Panel control=new Panel();
	private Panel traka=new Panel();
	Button igraj=new Button("Igraj");
	TextField utext=new TextField(5);
	Label kvota=new Label();
	Label dobitak=new Label();
	Label balans=new Label();
	int vrednost=0;
	private void populateWindow() {
		add(control, BorderLayout.EAST);
		control.setBackground(Color.LIGHT_GRAY);
		control.setBounds(200,0,0,0);
		control.setLayout(new GridLayout(0,1));
		balans.setText("Balans:  "+ vrednost );
		control.add(balans);
		Label ulog=new Label("Ulog:");
		utext.setText("100");
		Panel c=new Panel();
		c.add(ulog);
		c.add(utext);
		control.add(c);
		//kvota.setText("Kvota:    " + mreza.getVrsta()*mreza.getKolona()/mreza.brojIzabranih());
		control.add(kvota);
		//dobitak.setText("Dobitak:   ");
		control.add(dobitak);
		control.add(igraj);
		
		if(mreza.brojIzabranih()==0) igraj.setEnabled(false);

		utext.addTextListener ((te) -> {if(utext.getText().length()==0) {
			utext.setText("0");
			setKvota(0);
			setDobitak(0);
		}
			int text= Integer.parseInt(utext.getText());
			mreza.azuriraj();
			setKvota(mreza.getVrsta()*mreza.getKolona()/mreza.brojIzabranih());
			setDobitak(mreza.getVrsta()*mreza.getKolona()/mreza.brojIzabranih()*text );
		});
		
		igraj.addActionListener((ae) -> 
		{
			Generator g=new Generator(0,mreza.getVrsta()*mreza.getKolona()-1 );
			mreza.azuriraj();
			boolean jeste=false;
			int b=g.generisi();
			Label l=new Label(""+b);
			l.setBackground(Color.DARK_GRAY);
			l.setFont(new Font(null,Font.BOLD, 15 ));
			traka.add(l);
			
			
			for(int i=0;i<mreza.getIzabrano().size();i++) {
				if(mreza.getIzabrano().get(i).getBroj()==b) {
					jeste=true;
				}
			}
			
			if(jeste==true) {
				traka.setBackground(Color.GREEN);
				vrednost+=mreza.getVrsta()*mreza.getKolona()/mreza.brojIzabranih()*Integer.parseInt(utext.getText());
				balans.setText("Balans:  "+ vrednost);
			}
			else { traka.setBackground(Color.RED);
			vrednost-=mreza.getVrsta()*mreza.getKolona()/mreza.brojIzabranih()*Integer.parseInt(utext.getText());
			balans.setText("Balans:  "+ vrednost);
			}
		});
		
		revalidate();
	}
	
	public void setKvota(float i){
		kvota.setText("Kvota:   "+ i );
	}
	
	public void setDobitak(float i)  {
		
		dobitak.setText("Dobitak:   "+ i);
	}
private Igra() {
	super("Igra");
	mreza =new Mreza(4,5,this);
	add(mreza, BorderLayout.CENTER);
	add(control, BorderLayout.EAST);
	add(traka, BorderLayout.SOUTH);
	traka.setBackground(Color.DARK_GRAY);
	setBounds(700,200,500,300);
	setResizable(true);
	populateWindow();
	pack();
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			dispose();
		}
	});
	setVisible(true);
	utext.setText("100");
	setKvota(mreza.getVrsta()*mreza.getKolona()/mreza.brojIzabranih());
	setDobitak(mreza.getVrsta()*mreza.getKolona()/mreza.brojIzabranih()*100 );
	if(mreza.brojIzabranih()==0) igraj.setEnabled(false);
	revalidate();
	
}
public static void main(String[] args) {
	new Igra();
}
}
