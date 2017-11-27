
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PanelDemo {

	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("Enter your name");// graftan
																		// name
		String x = JOptionPane.showInputDialog("Enter the order of matrix"); // moshakhs
																				// kardan
																				// andaze
																				// jadval
		String d = JOptionPane.showInputDialog(" Enter the density of bombs(0 to 1 like 0.25)"); // moshakas
																									// kardan
																									// daraje
																									// sakhti
																									// bazi
		int number1 = Integer.valueOf(x);
		double number2 = Double.valueOf(d);
		GameCore gameCore = new GameCore(number1, number2);
		PanelFrame panelFrame = new PanelFrame(gameCore, number1, name);
		panelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelFrame.setSize(550, 600);
		panelFrame.setResizable(false);
		panelFrame.setVisible(true);
	} // payane main
} // payane class panelDemo
