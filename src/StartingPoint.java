import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class StartingPoint extends Applet implements Runnable, KeyListener {
	
	/**
	 * CHALLENGE  : 
	 * 
	 * i) make the size fo the window when the programme 
	 * 	  runs bigger
	 * 
	 * ii) increase the number of platforms to 8	
	 */

	private Image i;
	private Graphics doubleG;
	Ball b;
	private int numPlatforms = 7;
	Platform p[] = new Platform[numPlatforms];

	/**
	 * Initialisation : 
	 * Defines window size. 
	 * Makes thuis class listen for KeyEvents.
	 */
	@Override
	public void init() {
		setSize(800, 600);
		addKeyListener(this);
	}

	@Override
	public void start() {
		b = new Ball();
		for (int i = 0; i < p.length; i++) {
			Random r = new Random();
			p[i] = new Platform(getWidth() + 200 * i, getHeight() - 40 - r.nextInt(400));
		}
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while (true) {
			b.update(this);
			for (int i = 0; i < p.length; i++) {
				p[i].update(this, b);
			}
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void stop() {
		//not used
	}

	
	@Override
	public void destroy() {
		// not used
	}


	/****************************************
	 * GRAPHICS 
	 ****************************************/

	@Override
	public void update(Graphics g) {
		if (i == null) {
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
		}

		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);

		doubleG.setColor(getForeground());
		paint(doubleG);

		g.drawImage(i, 0, 0, this);

	}

	@Override
	public void paint(Graphics g) {
		b.paint(g);
		for (int i = 0; i < p.length; i++) {
			p[i].paint(g);
		}

	}


	/****************************************
	 * KEY LISTENERS
	 ****************************************/

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			//MOVES BALL LEFT
			b.moveLeft();
			break;

		case KeyEvent.VK_RIGHT:
			//MOVES BALL RIGHT
			b.moveRight();
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// not used
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// not used
	}

}
