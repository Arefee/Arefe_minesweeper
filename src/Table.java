
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Table extends JPanel {

	public Aaa[][] cells;

	// sakhtan jadvale bazi va ijade cellol ha
	public Table(GameCore gameCore, int n) {

		cells = new Aaa[n][n];
		setLayout(new GridLayout(n, n));

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				cells[i][j] = new Aaa(gameCore, i, j);

				add(cells[i][j]);
			}

		}
		gameCore.setCell(cells);

	} // payan Table

} // payan class table
