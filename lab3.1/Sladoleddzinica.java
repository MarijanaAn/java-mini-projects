package sladoled;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Sladoleddzinica extends Frame {
	private Aparat aparat;
	private Panel dodajUkus=new Panel();
	private TextField nazivSl=new TextField(10);
	private TextField boja=new TextField(8);
	private Button dodaj=new Button("Dodaj ukus");
	private Mesto mesto;
	
	private void populateWindow() throws GPostojiUkus {
		
		
		add(dodajUkus, BorderLayout.SOUTH);
		dodajUkus.setBackground(Color.CYAN);
		Label naziv=new Label("Naziv:");
		naziv.setFont(new Font(null, Font.BOLD, 15));
		dodajUkus.add(naziv);
		dodajUkus.add(nazivSl);
		Label b= new Label("Boja:");
		b.setFont(new Font(null, Font.BOLD, 15));
		dodajUkus.add(b);
		dodajUkus.add(boja);
		dodajUkus.add(dodaj);
	
	dodaj.addActionListener((ae) ->  { 
		if(nazivSl.getText().length()==0 || boja.getText().length()==0) {
			return;
		}
		Ukus u=new Ukus(nazivSl.getText(),Color.decode("#"+boja.getText()) );
		try {
			aparat.dodajUkus(u);
			revalidate();
		} catch (GPostojiUkus e) {
			
			System.err.println(e);
		}

	});
	revalidate();
	}
public Sladoleddzinica() throws GPostojiUkus {
	super("Sladoleddzinica");
	setBounds(700,200,400,300);
	setResizable(true);
	setVisible(true);
	setTitle("Sladoleddzinica");
	populateWindow();
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			dispose();
		}
	});
	
	aparat=new Aparat(this);
	add(aparat, BorderLayout.CENTER);
	//aparat.getLabela().setAlignment(Label.LEFT);
	Ukus u=new Ukus("Cokolada", Color.BLUE);
	//Ukus u1=new Ukus("Cokolada", Color.RED);
	try {
	aparat.dodajUkus(u);
	//aparat.dodajUkus(u1);
	} catch(GPostojiUkus e) {System.err.println(e);}
revalidate();
}

public static void main(String[] args) throws GPostojiUkus {
	new Sladoleddzinica();
}
}
