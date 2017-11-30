import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Dimension;

/**
 * Handles the gui for the game.
 *
 * @author Ofek Gila
 * @since November 29th, 2017
 */
public class OTDGui extends JFrame {

	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

	private Map map;

	public OTDGui() {
		setupLayout();

		setSize(SCREEN_SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void setupLayout() {
		GridLayout grid = new GridLayout(2, 0);
		setLayout(grid);
		add(new JButton("Hello"));
		add(new JButton("Goodbye"));
	}

}
