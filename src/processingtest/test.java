package processingtest;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.data.Table;

public class test extends PApplet {

	PGraphics pg;
	Table outputTable;
	ArrayList<Node> nodesToDraw;
	public static final int SIZE_WIDTH = 1000;
	public static final int SIZE_HEIGHT = 1000;

	public static final Object[][] testArray = new Object[][] {
			{ "Bob", 1.0, 1.0 }, { "Reg", 2.0, 2.705 }, { "stan", 3.0, 2.0 },
			{ "Leon", 4.0, 1.75 }, { "Cat", 12.0, 2.0 },
			{ "Coffee", 2.0, 2.5 }, { "Ethel", 19.0, 3.383157894736842 },
			{ "Tom", 5.0, 2.0 } };

	public void fuse() {
		// Object[][] joinedArray = join();
	}

	private static Table arrayToTable(Object[][] convertArray) {
		Table table = new Table();

		table.addColumn("className");
		table.addColumn("methodCount");
		table.addColumn("averageCRAP");
		table.addColumn("percentChanged");
		table.addColumn("changeFlag");

		for (int i = 0; i < convertArray.length; i++) {
			table.addRow();
		}
		// populate table with values from fused 2D array
		for (int i = 0; i < convertArray.length; i++) {
			for (int j = 0; j < convertArray[i].length; j++) {
				if (convertArray[i][j].getClass() == String.class) {
					table.setString(i, j, (String) convertArray[i][j]);
				} else if (convertArray[i][j].getClass() == double.class) {
					table.setDouble(i, j, (double) convertArray[i][j]);
				} else if (convertArray[i][j].getClass() == int.class) {
					table.setInt(i, j, (int) convertArray[i][j]);
				}
			}

		}

		return table;

	}

	public void setup() {
		outputTable = arrayToTable(testArray);
		makeNodes(outputTable);
		size(SIZE_WIDTH, SIZE_HEIGHT);
		pg = createGraphics(SIZE_WIDTH, SIZE_HEIGHT);
	}

	public void draw() {

		pg.beginDraw();
		pg.background(218, 165, 32);
		pg.stroke(255);
		pg.endDraw();

		// Draw the offscreen buffer to the screen with image()
		image(pg, 120, 60);
	}

	public void makeNodes(Table table) {
		System.out.println(table.getRowCount());
		// Node tempNode;
		for (int i = 0; i < table.getRowCount(); i++) {
			System.out.println(table.getString(i, "className"));
			// nodesToDraw.add(new Node(table.getString(i, "className")));
		}

	}

}