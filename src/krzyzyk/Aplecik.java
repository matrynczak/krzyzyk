package krzyzyk;

import java.applet.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Aplecik extends Applet{
	private ArrayList<Krzyzyk> krzyze = new ArrayList();
	Random rnd = new Random();

	@Override
	public void init() {
		int n = 3 + rnd.nextInt(10);
		setSize(500,500);
		setBackground(Color.yellow);
		Dimension d = getSize();
		for (int i=0; i<n; i++)
			krzyze.add(new Krzyzyk(d));
		
		class Animacja extends TimerTask{

			@Override
			public void run() {
				for(Krzyzyk k : krzyze)
					k.ruch(d);
				repaint();
			}
		}
		
		Timer go = new Timer();
		go.schedule(new Animacja(), 200, 1000);
		
		addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
					if(e.getButton() == MouseEvent.BUTTON1)
						for(Krzyzyk k : krzyze)
							if(k.zawiera(e.getX(), e.getY()))
								k.przesunPrawo();
						repaint();
					if(e.getButton() == MouseEvent.BUTTON3)
						for(Krzyzyk k : krzyze)
							if(k.zawiera(e.getX(), e.getY()))
								k.przesunGora();
						repaint();
					if(e.getButton() == MouseEvent.BUTTON2)
						for(Krzyzyk k : krzyze)
							if(k.zawiera(e.getX(), e.getY()))
								k.zmienKolor();
						repaint();
			}

		});
		
		
		addKeyListener (new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
					for(Krzyzyk k : krzyze)
						k.nowaPozycja(d);
			}
			
		});
		

	}

	@Override
	public void paint(Graphics g) {
		for(Krzyzyk k : krzyze)
			k.rysuj(g);
	}

}
