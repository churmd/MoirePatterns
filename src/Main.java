import java.awt.BorderLayout;

import javax.swing.JFrame;

import control.Controller;
import model.Model;
import view.ControlPanel;
import view.PatternView;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		Controller con = new Controller(model);
		PatternView view = new PatternView(model);
		ControlPanel cp = new ControlPanel(model, con);
		
		model.addObserver(view);
		
		JFrame frame = new JFrame("Moire Patterns");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(view, BorderLayout.CENTER);
		frame.add(cp, BorderLayout.EAST);
		
		frame.setVisible(true);
//		
//		for(int i = 0; i < 30; i++) {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			double angle = i / 100.0;
//			model.setAngle(angle);
//		}
	}

}
