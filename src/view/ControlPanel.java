package view;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSlider;

import control.Controller;
import model.Model;
import model.patterns.PatternType;

public class ControlPanel extends JPanel {

	private Controller con;
	private JComboBox<PatternType> patterns;
	private JSlider angle, xOffset, yOffset;
	private Model model;

	public ControlPanel(Model model, Controller controller) {
		super();
		this.con = controller;
		this.model = model;
		
		patterns = makeComboBox();
		xOffset = makeXOffset();
		yOffset = makeYOffset();
		angle = makeAngle();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(patterns);
		add(xOffset);
		add(yOffset);
		add(angle);
	}

	private JComboBox<PatternType> makeComboBox() {
		JComboBox<PatternType> cb = new JComboBox<>(PatternType.values());
		cb.setSelectedIndex(0);
		cb.addActionListener(e -> con.changePattern((PatternType) cb.getSelectedItem()));
		return cb;
	}

	private JSlider makeXOffset() {
		JSlider slider = new JSlider(-100, 100, (int) (model.getxOffset() * 100));
		slider.setMajorTickSpacing(20);
		slider.setPaintTicks(true);
		slider.addChangeListener(e -> {
			double xo = slider.getValue() / 100.0;
			con.setXOffset(xo);
		});
		return slider;
	}
	
	private JSlider makeYOffset() {
		JSlider slider = new JSlider(-100, 100, (int) (model.getyOffset() * 100));
		slider.setMajorTickSpacing(20);
		slider.setPaintTicks(true);
		slider.addChangeListener(e -> {
			double yo = slider.getValue() / 100.0;
			con.setYOffset(yo);
		});
		return slider;
	}
	
	private JSlider makeAngle() {
		JSlider slider = new JSlider(0, (int) (2 * Math.PI * 100), (int)(model.getAngle()));
		slider.setMajorTickSpacing((int) ((2 * Math.PI * 100) / 10.0));
		slider.setPaintTicks(true);
		slider.addChangeListener(e -> {
			double angle = slider.getValue() / 100.0;
			con.setAngle(angle);
		});
		return slider;
	}
}
