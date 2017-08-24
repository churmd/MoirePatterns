package view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import control.Controller;
import model.Model;
import model.patterns.PatternType;

public class ControlPanel extends JPanel implements Observer{

	private Controller con;
	private JComboBox<PatternType> patterns;
	private JSlider angle, xOffset, yOffset;
	private Model model;
	private double multiplier;

	public ControlPanel(Model model, Controller controller) {
		super();
		this.con = controller;
		this.model = model;
		multiplier = 1000;
		
		patterns = makeComboBox();
		xOffset = makeXOffset();
		yOffset = makeYOffset();
		angle = makeAngle();
		
		JLabel patternLabel = new JLabel("Pattern");
		JLabel xAxisLabel = new JLabel("X-Axis");
		JLabel yAxisLabel = new JLabel("Y-Axis");
		JLabel angleLabel = new JLabel("Angle");
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(Box.createVerticalGlue());
		
		add(patternLabel);
		patternLabel.setAlignmentX(CENTER_ALIGNMENT);
		add(patterns);
		patterns.setAlignmentX(CENTER_ALIGNMENT);
		
		add(Box.createVerticalGlue());
		
		add(xAxisLabel);
		xAxisLabel.setAlignmentX(CENTER_ALIGNMENT);
		add(xOffset);
		xOffset.setAlignmentX(CENTER_ALIGNMENT);
		
		add(Box.createVerticalGlue());
		
		add(yAxisLabel);
		yAxisLabel.setAlignmentX(CENTER_ALIGNMENT);
		add(yOffset);
		yOffset.setAlignmentX(CENTER_ALIGNMENT);
		
		add(Box.createVerticalGlue());
		
		add(angleLabel);
		angleLabel.setAlignmentX(CENTER_ALIGNMENT);
		add(angle);
		angle.setAlignmentX(CENTER_ALIGNMENT);
		
		add(Box.createVerticalGlue());
	}

	private JComboBox<PatternType> makeComboBox() {
		JComboBox<PatternType> cb = new JComboBox<>(PatternType.values());
		cb.setMaximumSize(new Dimension(Short.MAX_VALUE, 50));
		cb.setSelectedIndex(0);
		cb.addActionListener(e -> con.changePattern((PatternType) cb.getSelectedItem()));
		return cb;
	}

	private JSlider makeXOffset() {
		JSlider slider = new JSlider(-100, 100, (int) (model.getxOffset() * multiplier));
		slider.setMajorTickSpacing(20);
		slider.setPaintTicks(true);
		slider.addChangeListener(e -> {
			double xo = slider.getValue() / multiplier;
			con.setXOffset(xo);
		});
		return slider;
	}
	
	private JSlider makeYOffset() {
		JSlider slider = new JSlider(-100, 100, (int) (model.getyOffset() * multiplier));
		slider.setMajorTickSpacing(20);
		slider.setPaintTicks(true);
		slider.addChangeListener(e -> {
			double yo = slider.getValue() / multiplier;
			con.setYOffset(yo);
		});
		return slider;
	}
	
	private JSlider makeAngle() {
		JSlider slider = new JSlider(-180, 180, (int) Math.toDegrees(model.getAngle()));
		slider.setMajorTickSpacing(36);
		slider.setPaintTicks(true);
		slider.addChangeListener(e -> {
			double angle = slider.getValue();
			con.setAngle(Math.toRadians(angle));
		});
		return slider;
	}

	@Override
	public void update(Observable o, Object arg) {
		patterns.setSelectedItem(model.getPatternType());
		xOffset.setValue((int) (model.getxOffset() * multiplier));
		yOffset.setValue((int) (model.getyOffset() * multiplier));
		angle.setValue((int) Math.toDegrees(model.getAngle())); 
	}
}
