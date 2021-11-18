package edu.learn;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class Fill extends JPanel{
	private Integer x;
	private Integer y;
	private Color color;
	public Fill(Integer x,Integer y,Color color) {
		  this.x=x;
		  this.y=y;
		  this.color=color;
          this.setVisible(true); 
          revalidate();
          repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.fillRect(0, x, 0, y);
		
	}
}
