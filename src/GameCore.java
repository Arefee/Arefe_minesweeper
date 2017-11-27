
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;

// haste bazi
public class GameCore {
	private static boolean[][] arr;
	// public static int a=0;
	private static final Random randomNumber = new Random();
	private MouseClickHandler cellClick = new MouseClickHandler();
	private boolean gameStart;
	MyTimer timerStatus;
	public Aaa[][] cell;
	private int x;
	private double h;

	// gharar dadan bomb ha be sort random dar cellol ha
	public GameCore(int x, double h) {
		this.x = x;
		this.h = h;
		arr = new boolean[x][x];
		for (int i = 0; i < (h * x * x); i++) {
			int j = randomNumber.nextInt(x);
			int k = randomNumber.nextInt(x);
			arr[j][k] = true;
		}

	}

	// getter cell
	public Aaa[][] getCell() {
		return cell;
	}

	// seter cell
	public void setCell(Aaa[][] cell) {
		this.cell = cell;
	}

	// getter TimerStatus
	public MyTimer getTimerStuts() {
		return timerStatus;
	}

	// setter TimerStatus
	public void setTimerStuts(MyTimer timerStatus) {
		this.timerStatus = timerStatus;
	}

	// baresi roydad haie click kardan
	private class MouseClickHandler extends MouseAdapter {

		public void mouseClicked(MouseEvent event) {
			Aaa myButton = (Aaa) event.getSource(); // cellol click shode
			// shoroe bazi
			if (gameStart == false) {
				gameStart = true;
				timerStatus.tm.start();
			}
			// click rast roie cellol
			if (event.getButton() == MouseEvent.BUTTON3)
				if (myButton.getStatus() == Aaa.FLAGGED) {
					myButton.setStatus(Aaa.DEACTIVATED);
					myButton.setEnabled(true);
				} else {
					myButton.setStatus(Aaa.FLAGGED);
					myButton.setEnabled(false);
				}
			// click chap roie cellol
			if (event.getButton() == MouseEvent.BUTTON1)
				if (myButton.getStatus() != Aaa.ACTIVATED) {
					myButton.setStatus(Aaa.ACTIVATED);
					int n = action(myButton.xPos, myButton.yPos);

					if (n == 9) {// click bar roie bomb va payan bazi
						myButton.setIcon(new ImageIcon("Pictures/bombrevealed.gif"));
						timerStatus.tm.stop();
						for (int i = 0; i < arr.length; i++) {
							for (int j = 0; j < arr.length; j++) {
								if (arr[i][j] == true && (i != myButton.xPos || j != myButton.yPos))
									cell[i][j].setIcon(new ImageIcon("Pictures/bombdeath.gif"));
							}
						}
						JOptionPane.showMessageDialog(null, "ops!   s: " + timerStatus.count);
						resetGame();
					} else { // namaiesh tedad bomb haie atrafe yek cellol
						if (n == 0) { // halat bazgashti va gostaresh khodkar
							int x = myButton.xPos;
							int y = myButton.yPos;
							if (x != 0)
								clickOthers(x - 1, y);
							if (x != (cell.length - 1))
								clickOthers(x + 1, y);
							if (y != 0)
								clickOthers(x, y - 1);
							if (y != (cell.length - 1))
								clickOthers(x, y + 1);
							if (x != 0 && y != 0)
								clickOthers(x - 1, y - 1);
							if (x != 0 && y != (cell.length - 1))
								clickOthers(x - 1, y + 1);
							if (x != (cell.length - 1) && y != 0)
								clickOthers(x + 1, y - 1);
							if (x != (cell.length - 1) && y != (cell.length - 1))
								clickOthers(x + 1, y + 1);

						} else if (n == 1)
							myButton.setIcon(new ImageIcon("Pictures/open1.gif"));
						else if (n == 2)
							myButton.setIcon(new ImageIcon("Pictures/open2.gif"));
						else if (n == 3)
							myButton.setIcon(new ImageIcon("Pictures/open3.gif"));
						else if (n == 4)
							myButton.setIcon(new ImageIcon("Pictures/open4.gif"));
						else if (n == 5)
							myButton.setIcon(new ImageIcon("Pictures/open5.gif"));
						else if (n == 6)
							myButton.setIcon(new ImageIcon("Pictures/open6.gif"));
						else if (n == 7)
							myButton.setIcon(new ImageIcon("Pictures/open7.gif"));
						else if (n == 8)
							myButton.setIcon(new ImageIcon("Pictures/open8.gif"));
						myButton.setEnabled(false);

						// check kardan halat bord va payan bazi
						boolean finished = true;
						for (int i = 0; i < cell.length; i++)
							for (int j = 0; j < cell.length; j++)
								if (cell[i][j].status == Aaa.DEACTIVATED && !arr[i][j])
									finished = false;
						if (finished) {
							JOptionPane.showMessageDialog(null, "won!   s: " + timerStatus.count);
						}
					}
				}
		} // payan mouseClicked

		// halat bazgashti va gostaresh kodkar
		public void clickOthers(int x, int y) {
			Aaa myButton = cell[x][y];
			if (myButton.getStatus() != Aaa.ACTIVATED) {
				myButton.setStatus(Aaa.ACTIVATED);
				myButton.setEnabled(false);

				int n = action(x, y);
				if (n == 0) { // halat bazgashti
					if (x != 0)
						clickOthers(x - 1, y);
					if (x != (cell.length - 1))
						clickOthers(x + 1, y);
					if (y != 0)
						clickOthers(x, y - 1);
					if (y != (cell.length - 1))
						clickOthers(x, y + 1);
					if (x != 0 && y != 0)
						clickOthers(x - 1, y - 1);
					if (x != 0 && y != (cell.length - 1))
						clickOthers(x - 1, y + 1);
					if (x != (cell.length - 1) && y != 0)
						clickOthers(x + 1, y - 1);
					if (x != (cell.length - 1) && y != (cell.length - 1))
						clickOthers(x + 1, y + 1);
				} else if (n == 1)
					myButton.setIcon(new ImageIcon("Pictures/open1.gif"));
				else if (n == 2)
					myButton.setIcon(new ImageIcon("Pictures/open2.gif"));
				else if (n == 3)
					myButton.setIcon(new ImageIcon("Pictures/open3.gif"));
				else if (n == 4)
					myButton.setIcon(new ImageIcon("Pictures/open4.gif"));
				else if (n == 5)
					myButton.setIcon(new ImageIcon("Pictures/open5.gif"));
				else if (n == 6)
					myButton.setIcon(new ImageIcon("Pictures/open6.gif"));
				else if (n == 7)
					myButton.setIcon(new ImageIcon("Pictures/open7.gif"));
				else if (n == 8)
					myButton.setIcon(new ImageIcon("Pictures/open8.gif"));

			}
		} // payan tabe clickOthers
	} // payan class MouseClickHandler

	// getter MouseClickHandler
	public MouseClickHandler getCellClick() {
		return cellClick;
	}

	// shemordane tedad bomb ha dar atrafe yek cellol
	public int action(int x, int y) {
		if (arr[x][y] == true)
			return 9;
		else {
			int a = 0;
			if (x != 0 && y != 0)
				if (arr[x - 1][y - 1] == true)
					a++;
			if (x != 0)
				if (arr[x - 1][y] == true)
					a++;
			if (x != 0 && y != (arr.length - 1))
				if (arr[x - 1][y + 1] == true)
					a++;
			if (y != 0)
				if (arr[x][y - 1] == true)
					a++;
			if (y != (arr.length - 1))
				if (arr[x][y + 1] == true)
					a++;
			if (x != (arr.length - 1) && y != 0)
				if (arr[x + 1][y - 1] == true)
					a++;
			if (x != (arr.length - 1))
				if (arr[x + 1][y] == true)
					a++;
			if (x != (arr.length - 1) && y != (arr.length - 1))
				if (arr[x + 1][y + 1] == true)
					a++;
			return a;

		}
	} // payan tabe action

	// reset kardan bazi dar hengam bazi va dar enteha
	public void resetGame() {
		arr = new boolean[x][x];
		for (int i = 0; i < (h * x * x); i++) {
			int j = randomNumber.nextInt(x);
			int k = randomNumber.nextInt(x);
			arr[j][k] = true;
		}
		for (int i = 0; i < x; i++)
			for (int j = 0; j < x; j++) {
				cell[i][j].status = Aaa.DEACTIVATED;
				cell[i][j].setEnabled(true);
				cell[i][j].setIcon(null);
			}
		timerStatus.tm.stop();
		timerStatus.count = 0;
		gameStart = false;
	} // payan tabe resetGame

}// payan class GameCore