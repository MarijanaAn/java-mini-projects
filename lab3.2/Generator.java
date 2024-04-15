package brojevi;

import java.util.Random;

public class Generator {
	private int donja;
	private int gornja;
	
public Generator(int donja, int gornja) {
	this.gornja=gornja;
	this.donja=donja;
}

public int generisi() {
	int n=(int)( Math.random()*gornja)+donja;
	return n;
}
}
