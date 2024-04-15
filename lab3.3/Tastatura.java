package telefon;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Tastatura extends Panel implements Runnable {
private Label natpis=new Label();
private Button[][] dugmad;
private static final int brojKarata =2;
public void promeniNatpis(String s) {
	natpis.setText(s);
}

public Tastatura(String s) {
	CardLayout cardLayout=new CardLayout();
	Panel cardPanel=new Panel(cardLayout);
	natpis.setText(s);
	add(natpis, BorderLayout.NORTH);
	Panel card;
	
for(int k=0;k<brojKarata;k++) {
	card=new Panel();
	card.setLayout(new GridLayout(4,3,3,3));
	card.setBackground(Color.WHITE);
	dugmad=new Button[4][3];
	if(k==0) {
		int br=0;
	for(int i=0; i<3;i++)  {
		for(int j=0; j<3;j++)  {
			Button b=new Button(""+ ++br);
			dugmad[i][j]=b;
			dugmad[i][j].setEnabled(true);
			card.add(dugmad[i][j], BorderLayout.CENTER);
		}
		
	}
	dugmad[3][0]=new Button("*");
	card.add(dugmad[3][0], BorderLayout.CENTER);
	dugmad[3][1]=new Button("0");
	card.add(dugmad[3][1], BorderLayout.CENTER);
	dugmad[3][2]=new Button("+");
	card.add(dugmad[3][2], BorderLayout.CENTER);
	cardPanel.add(card);
	
	dugmad[1][1].addActionListener((ae)->
	promeniNatpis(dugmad[1][1].getName()));
} 
if(k==1) {
	dugmad[0][0]=new Button("");
	card.add(dugmad[0][0], BorderLayout.CENTER);
	dugmad[0][1]=new Button("ABC");
	card.add(dugmad[0][1], BorderLayout.CENTER);
	dugmad[0][2]=new Button("DEF");
	card.add(dugmad[0][2], BorderLayout.CENTER);
	dugmad[1][0]=new Button("GHI");
	card.add(dugmad[1][0], BorderLayout.CENTER);
	dugmad[1][1]=new Button("JKL");
	card.add(dugmad[1][1], BorderLayout.CENTER);
	dugmad[1][2]=new Button("MNO");
	card.add(dugmad[1][2], BorderLayout.CENTER);
	dugmad[2][0]=new Button("PRSQ");
	card.add(dugmad[2][0], BorderLayout.CENTER);
	dugmad[2][1]=new Button("TUV");
	card.add(dugmad[2][1], BorderLayout.CENTER);
	dugmad[2][2]=new Button("WXYZ");
	card.add(dugmad[2][2], BorderLayout.CENTER);
	dugmad[3][0]=new Button("");
	card.add(dugmad[3][0], BorderLayout.CENTER);
	dugmad[3][1]=new Button("_");
	card.add(dugmad[3][1], BorderLayout.CENTER);
	dugmad[3][2]=new Button("");
	card.add(dugmad[3][2], BorderLayout.CENTER);
cardPanel.add(card);

dugmad[1][1].addActionListener((ae)->
promeniNatpis(dugmad[1][1].getName()));
} }
	add(cardPanel, BorderLayout.CENTER);
	
	Button next=new Button("next");
	next.addActionListener((ae) -> {
		cardLayout.next(cardPanel);
	});
	add(next, BorderLayout.SOUTH);
}

@Override
public void run() {
	// TODO Auto-generated method stub
	
}
}
