import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;


/**
 * Handles drawing the Map
 *
 * @author Ofek Gila
 * @since November 29th, 2017
 */
public class MapGui extends JPanel {

	private Map map;
	private int leftOffset, topOffset;
	private int squareSize;

	public MapGui() {
		setBackground(new Color(34, 139, 34, 150));
	}

	public void initializeMap(Map map) {
		this.map = map;
		onresize();
		repaint();
	}

	private void onresize() {
		int sWidth = getWidth() / map.getWidth();
		int sHeight = getHeight() / map.getHeight();
		squareSize = Math.min(sWidth, sHeight);

		leftOffset = (getWidth() - squareSize * map.getWidth()) / 2;
		topOffset = (getHeight() - squareSize * map.getHeight()) / 2;
	}

	private int getX(double x) {
		return (int)(x * squareSize + leftOffset);
	}

	private int getY(double y) {
		return (int)(y * squareSize + topOffset);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (map == null) return;

		drawAxes(g);
		drawTiles(g);
	}

	private void drawAxes(Graphics g) {
		g.setColor(Color.BLACK);

		// Horizontal lines
		for (int i = 0; i <= map.getHeight(); i++)
			g.drawLine(getX(0), getY(i), getX(map.getWidth()), getY(i));

		// Vertical Lines
		for (int i = 0; i <= map.getWidth(); i++)
			g.drawLine(getX(i), getY(0), getX(i), getY(map.getHeight()));
	}

	private void drawTiles(Graphics g) {
		for (int x = 0; x < map.getWidth(); x++)
			for (int y = 0; y < map.getHeight(); y++)
				drawTile(g, map.getTile(x, y), x, y);
	}

	private void drawTile(Graphics g, Tile tile, int x, int y) {

		if (tile == null) return;

		if (tile instanceof Path)
			g.setColor(new Color(222, 184, 135));

		g.fillRect(getX(x), getY(y), squareSize, squareSize);
	}

}

