package krzyzyk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

public class Krzyzyk {
	private int x;
	private int y;
	private Color kolor;
	Random rnd;
	
	public Krzyzyk(Dimension d){
		rnd = new Random();
		kolor = new Color (rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat());
		x = rnd.nextInt(d.width);
		y = rnd.nextInt(d.height);
	}
	
	public void rysuj(Graphics g){
		g.setColor(kolor);
		g.drawString("+", x, y);
	}

	public void ruch(Dimension d) {
		x = x + 5;
		
		if(x >= d.width) x = 0;
	}

	public boolean zawiera(int x2, int y2) {
		double dist = (x2-x)*(x2-x)+(y2-y)*(y2-y); 
		return dist <= 20;
	}

	public void przesunPrawo(){
		x = x + 30;
	}
	
	public void przesunGora(){
		y= y - 30;
	}

	public void zmienKolor() {
		kolor = Color.black;
	}

	public void nowaPozycja(Dimension d) {
		x = rnd.nextInt(d.width);
		y = rnd.nextInt(d.height);
	}

}
