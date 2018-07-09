import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	/**
	 ** CHALLENGE  : 
	 * 
	 * i) change the gravity variable so 
	 * the ball falls with "realistic" acceleration.
	 * 
	 * 
	 * ii) change the colour of the ball.
	 */

	private double dx = 0;
	private double dy = 0;
	private int radius = 20;
	private double gravity = 2;
	private double energyLoss = 1;
	private double dt = .2;
	private double xFriction = .9;
	private int x = 400;
	private int y = radius + 1;
	private double gameDy = -80;

	/**
	 * constructor if parameters not defined 
	 */
	
	public Ball() {
		
	}
	
	/**
	 * constructor with parameters given
	 */

	public Ball(int i, int j) {
		x = i;
		y = j;
	}
	
	/**
	 * changes dx to +3 (to the right)
	 */

	public void moveRight() {
		if (dx + 1 < 20) {
			dx += 3;
		}
	}
	
	/**
	 * changes dx to -3 (to the left)
	 */

	public void moveLeft() {
		if (dx - 1 > -20) {
			dx -= 3;
		}
	}
	
	/**
	 * updates the ball graphics location within window
	 */

	public void update(StartingPoint sp) {
		if (x + dx > sp.getWidth() - radius - 1) {
			x = sp.getWidth() - radius - 1;
			dx = -dx;

		}
		if (x + dx < 0 + radius + 1) {
			x = 0 + radius + 1;
			dx = -dx;
		} else {
			x += dx;
		}

		if (y == sp.getHeight() - radius - 1) {
			dx *= xFriction;
			if (Math.abs(dx) < .8) {
				dx = 0;
			}
		}
		if (y > sp.getHeight() - radius - 1) {
			y = sp.getHeight() - radius - 1;
			dy *= energyLoss;
			dy = -dy;
		} else {
			dy = dy + gravity * dt;
			y += dy * dt + .5 * gravity * dt * dt;
		}
	}
	
	/**
	 * paints the ball graphic
	 */

	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);

	} 

	
	/****************************************
	 * VARIABLE GETTER AND SETTERS
	 ****************************************/

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public double getDx() {
			return dx;
		}

		public double getDy() {
			return dy;
		}

		public void setDx(double dx) {
			this.dx = dx;
		}

		public void setDy(double dy) {
			this.dy = dy;
		}

		public double getGravity() {
			return gravity;
		}

		public void setGravity(double gravity) {
			this.gravity = gravity;
		}

		public int getRadius() {
			return radius;
		}

		public double getGameDy() {
			return gameDy;
		}

		public void setGameDy(double gameDy) {
			this.gameDy = gameDy;
		}
	/**
	 * --------------------------------------------
	 */
}
