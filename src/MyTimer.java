
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class MyTimer {
	public int count = 0;
	public JLabel jLabel;

	// estefade az class Timer va ejra shodan barname dar har sanie
	Timer tm = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			count++;
			String str = String.valueOf(count);
			jLabel.setText(str);

		}
	});
} // payan class MyTimer
