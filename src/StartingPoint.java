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
	 * INITIALISATION
	 */

	private Image i;
	private Graphics doubleG;
	Ball b;
	Platform p[] = new Platform[7];

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

	/** 
	 *  THREAD
	 */
	
	@Override
	public void run() {
		// thread information
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

	}

	
	@Override
	public void destroy() {

	}


	/**
	 * GRAPHICS METHODS
	 */

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


	/** 
	 * KEY LISTENERS
	 */

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			b.moveLeft();
			break;

		case KeyEvent.VK_RIGHT:
			b.moveRight();
			break;
		}

	}

	
	/** 
	 * UNUSED OVERRIDEN METHODS
	 */
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// not used
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// not used
	}

}
