package edu.learn;

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

public class Line extends JPanel{
	private Integer x1;
	private Integer y1;
	private Integer x2;
	private Integer y2;

	public Line(Integer x1,Integer y1,Integer x2,Integer y2) {
		  this.x1=x1;
		  this.y1=y1;
		  this.x2=x2;
		  this.y2=y2;
          this.setVisible(true); 
          revalidate();
          repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawLine(x1, y1, x2, y2);
		
	}
}
