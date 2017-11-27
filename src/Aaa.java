
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Aaa extends JButton {
	private GameCore gameCore;
	public int xPos;
	public int yPos;
	public char status = DEACTIVATED;
	public static char ACTIVATED = 'A';
	public static char DEACTIVATED = 'D';
	public static char FLAGGED = 'F';

	// moshakhas kardan vazeeat har cellol az nazar faal va gheire faal boodan
	public Aaa(GameCore gameCore, int xPos, int yPos) {
		this.gameCore = gameCore;
		this.xPos = xPos;// mokhtasat x cellol
		this.yPos = yPos; // mokhtasat y cellol
		addMouseListener(gameCore.getCellClick());
	} // payan Aaa

	// getter status
	public char getStatus() {
		return status;
	}

	// setter status
	public void setStatus(char status) {
		this.status = status;
	}

}// payan class Aaa
