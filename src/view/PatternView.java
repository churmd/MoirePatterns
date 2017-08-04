package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.Model;

public class PatternView extends JPanel{

	private Model model;

	public PatternView(Model model) {
		this.model = model;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}
	
	@Override
	public void update(Graphics g) {
		super.update(g);
		repaint();
	}
}
