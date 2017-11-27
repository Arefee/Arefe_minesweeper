
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class PanelFrame extends JFrame {

	private static Table aa;
	private JLabel jLabel;
	private JButton start;
	private JButton score;
	private JButton help;

	// dorost kardan zahere safhe bazi
	public PanelFrame(final GameCore gameCore, int n, String name) {
		setTitle(name);
		aa = new Table(gameCore, n);
		setLayout(null);
		jLabel = new JLabel();
		start = new JButton("start/end");
		// reset kardan bazi ba estefade az start/end
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				gameCore.resetGame();
			}
		});
		score = new JButton("score");
		help = new JButton("help");
		// moshakhas kardan andaze va makan ajza
		start.setBounds(20, 10, 100, 30);
		score.setBounds(150, 10, 100, 30);
		help.setBounds(270, 10, 100, 30);
		jLabel.setBounds(400, 10, 100, 30);
		aa.setBounds(20, 60, 480, 450);
		add(start);
		add(score);
		add(help);
		add(jLabel);
		add(aa);
		// estetade va moshakhas kardan time
		MyTimer tm = new MyTimer();
		tm.jLabel = jLabel;
		gameCore.setTimerStuts(tm);

	}// payan PanelFrame

} // payane class PanelFrame
