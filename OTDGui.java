import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 * Handles the gui for the game.
 *
 * @author Ofek Gila
 * @since November 29th, 2017
 */
public class OTDGui extends JFrame {

	public final int SCREEN_WIDTH, SCREEN_HEIGHT;

	private MapGui mapGui;
	private TileInfoGui tileInfoGui;

	private Map map;

	public OTDGui() {

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		SCREEN_WIDTH = getMinWidth();
		SCREEN_HEIGHT = gd.getDisplayMode().getHeight();

		setSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		setupGrid();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		mapGui.initializeMap(new Map(20, 10));
	}

	private int getMinWidth() {
		// Returns the display with the minimum width (for my extended display setup)
		int minWidth = Integer.MAX_VALUE;
		for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices())
			if (gd.getDisplayMode().getWidth() < minWidth)
				minWidth = gd.getDisplayMode().getWidth();
		return minWidth;
	}

	private void setupGrid() {
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		setupMapGui();
		setupTileInfoGui();
	}

	private void setupMapGui() {
		mapGui = new MapGui();
		add(mapGui, BorderLayout.CENTER);
	}

	private void setupTileInfoGui() {
		tileInfoGui = new TileInfoGui();
		tileInfoGui.setPreferredSize(new Dimension(
			SCREEN_WIDTH, (int)(SCREEN_HEIGHT * 0.2)
		));
		add(tileInfoGui, BorderLayout.SOUTH);
	}

}
