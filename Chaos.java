package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chaos extends JPanel {
	
	private static final Random rand = new Random();
	
	private static final Color[] colors = {
			Color.yellow, Color.blue, Color.cyan,
			Color.green, Color.magenta, Color.orange,
			Color.pink, Color.red, Color.black, Color.gray
	};
	
	private static final int W = 1000;
	private static final int H = 680;
	
	private static class Ball {
		private int x;
		private int y;
		private int r;
		private int dx;
		private int dy;
		private Color color;
		
		public Ball(int x, int y, int r, int dx, int dy) {
			this.x = x;
			this.y = y;
			this.r = r;
			this.dx = dx;
			this.dy = dy;
			this.color = colors[rand.nextInt(colors.length)];
		}
		
		public void move() {
			if (x < 0 || x > W - r) dx = -dx;
			if (y < 0 || y > H - r) dy = -dy;
			x += dx;
			y += dy;
		}
	}
	
	private Ball balls[] = new Ball[50];
	
	public Chaos() {
		for (int i = 0; i < balls.length; i++)
			balls[i] = new Ball(
					rand.nextInt(W/2),
					rand.nextInt(H/2),
					rand.nextInt(100),
					rand.nextInt(5),
					rand.nextInt(5));
		setVisible(true);
		setPreferredSize(new Dimension(W, H));
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		var gc = (Graphics2D) g;
		
		for (Ball ball: balls) {
			gc.setColor(ball.color);
			gc.fillOval(ball.x, ball.y, ball.r, ball.r);
			
			ball.move();
		}
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {}
		
		repaint();
	}
	
	public static void main(String[] args) throws Exception {
		var frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Chaos(), BorderLayout.CENTER);
		frame.pack();
	}
}
