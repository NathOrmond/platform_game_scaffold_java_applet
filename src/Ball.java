import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	private double dx = 0;
	private double dy = 0;
	private int radius = 20;
	private double gravity = 15;
	private double energyLoss = 1;
	private double dt = .2;
	private double xFriction = .9;
	private int x = 400;
	private int y = radius + 1;
	private double gameDy = -80;

	public Ball() {

	}

	public Ball(int i, int j) {
		// TODO Auto-generated constructor stub
		x = i;
		y = j;
	}

	
		
	public void moveRight() {
		if (dx + 1 < 20) {
			dx += 3;
		}
	}

	public void moveLeft() {
		if (dx - 1 > -20) {
			dx -= 3;
		}
	}

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

	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);

	} 


	
	/**
	 * GETTERS AND SETTERS
	 */
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
