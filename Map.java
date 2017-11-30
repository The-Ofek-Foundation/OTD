import java.util.ArrayList;

/**
 * Maintains an array of tiles for this map
 *
 * @author Ofek Gila
 * @since November 29th, 2017
 */
public class Map {

	private Tile[][] tiles;
	private ArrayList<NPC> characters;

	private int width, height;

	public Map(int width, int height) {
		this.width = width;
		this.height = height;
		this.tiles = new Tile[width][height];
		this.characters = new ArrayList<NPC>();

		generateMap();
	}

	private void generateMap() {
		for (int i = 0; i < width; i++)
			tiles[i][height / 2] = new Path();
	}


	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public Tile getTile(int x, int y) { return tiles[x][y]; }
}

