package sladoled;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Aparat extends Panel  {

	private Panel ukusi=new Panel();
	private ArrayList<Ukus> u=new ArrayList<Ukus>();
	private Mesto mesto;
	private Button prodaja= new Button("Prodaj"); 
	private Label labela=new Label();
	private Sladoleddzinica sl;
	private Sladoled sladoled=new Sladoled(200);
	
	
	public Aparat(Sladoleddzinica s) {
		sl=s;
		prodaja.setEnabled(false);
		Panel l=new Panel();
		setLayout(new BorderLayout(3,3));
		setBackground(Color.GRAY);
		add(l, BorderLayout.SOUTH);
		l.setBackground(Color.GRAY);
		labela.setText("Sladoled:  ");
		labela.setAlignment(Label.LEFT);
		labela.setFont(new Font(null, Font.BOLD, 15));
		//labela.setAlignment(Label.LEFT);
		l.add(labela);
		mesto=new Mesto(this);
		Panel d=new Panel();
		d.setLayout(new GridLayout(2,1));
		d.add(prodaja);
		d.add(mesto, BorderLayout.EAST);
		Panel centar=new Panel();
		centar.setLayout(new GridLayout(1,2));
		centar.add(ukusi);
		centar.add(d);
		add(centar, BorderLayout.CENTER);
		centar.setBackground(Color.GRAY);
		mesto.setBackground(Color.WHITE);
		//add(ukusi, BorderLayout.CENTER);
		ukusi.setBackground(Color.LIGHT_GRAY);
		ukusi.setLayout(new GridLayout(0,2));
		prodaja.addActionListener((ae) -> {
			Graphics g=mesto.getGraphics();
			g.setColor(Color.white);
			mesto.setD((float) 0.0);
			g.fillRect(0, 0, getWidth(), getHeight());
			mesto.getLista().clear();
			repaint();
			prodaja.setEnabled(false);
		});
	}
	
	
	public void setLabela(String s) {
		labela.setText(s);
	}
	
	public void dodajUkus(Ukus uk) throws GPostojiUkus {
		String s=uk.getNaziv();
		Button b=new Button(s);
		b.setBackground(uk.getBoja());
	b.addMouseListener(new MouseAdapter(){

		@Override
		public void mouseClicked(MouseEvent e) {
			mesto.getLista().add(new Mini(mesto.getVisina(), mesto.getTrenutna()));
			mesto.setTrenutna(uk.getBoja());
			sladoled.dodaj(uk, 20);
			labela.setAlignment(Label.LEFT);
			setLabela("Sladoled:  " +sladoled.toString());
			//labela.setAlignment(Label.LEFT);
			//mesto.setRadi(true);
			mesto.repaint();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			mesto.getLista().add(new Mini(mesto.getVisina(), mesto.getTrenutna()));
			mesto.setTrenutna(uk.getBoja());
			sladoled.dodaj(uk, 20);
			labela.setAlignment(Label.LEFT);
			setLabela("Sladoled:  " +sladoled.toString());
			mesto.setRadi(true);
			mesto.repaint();
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			mesto.setRadi(false);
		}

		
	});
		
		if(u.contains(uk)) {
		throw new GPostojiUkus(); 
	}else {
		//sladoled.dodaj(uk,20);
		//setLabela(sladoled.toString());
		u.add(uk);
		ukusi.add(b);
	}
	}

	public ArrayList<Ukus> getU() {
		return u;
	}


	public Label getLabela() {
		return labela;
	}


public Button getButton() {
	return prodaja;
}
}
