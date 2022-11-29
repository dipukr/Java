package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sort extends JPanel {

	private int data[] = {4,6,1,7,3,2,8,5};
	private int frameCount = 0;
	
	public Sort(int width, int height) {
		setVisible(true);
		setBackground(new Color(39, 40, 34));
		setPreferredSize(new Dimension(width, height));
	}
	
	public void swap(int i, int j) {
		int val = data[i];
		data[i] = data[j];
		data[j] = val;
	}
	
	public int minIndex(int start) {
		int val = start;
		for (int i = start; i < data.length; i++)
			if (data[i] < data[val])
				val = i;
		return val;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		var gc = (Graphics2D) g;
		
		gc.setColor(Color.white);
		
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[i]; j++)
				gc.fillRect(200 + i * 70, 550 - j * 70, 69, 69);
		
		int minIndex = minIndex(frameCount);
		swap(frameCount, minIndex);
		frameCount++;
		
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {}
		
		if (frameCount != data.length)
			repaint();
	}
	
	public static void main(String[] args) throws Exception {
		var frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Anim(1000, 680), BorderLayout.CENTER);
		frame.pack();
	}
}