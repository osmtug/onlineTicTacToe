package grille;

import java.io.Serializable;
import java.util.Vector;

public class GrilleTicTacToe implements Serializable {
	
	private Vector<Vector<Integer>> grid;
	public static int X = 1;
	public static int O = 2;
	
	public GrilleTicTacToe() {
		grid = new Vector<Vector<Integer>>();
		grid.add(new Vector<Integer>());
		grid.add(new Vector<Integer>());
		grid.add(new Vector<Integer>());
		grid.get(0).add(0);
		grid.get(0).add(0);
		grid.get(0).add(0);
		grid.get(1).add(0);
		grid.get(1).add(0);
		grid.get(1).add(0);
		grid.get(2).add(0);
		grid.get(2).add(0);
		grid.get(2).add(0);
	}
	
	public GrilleTicTacToe(Vector<Vector<Integer>> g) {
		grid = g;
	}
	
	public String toString() {
	   String ligne1 = getString(grid.get(0).get(0)) + "|" + getString(grid.get(0).get(1)) + "|" + getString(grid.get(0).get(2));
	   String ligne2 = "-+-+-";
	   String ligne3 = getString(grid.get(1).get(0)) + "|" + getString(grid.get(1).get(1)) + "|" + getString(grid.get(1).get(2));
	   String ligne4 = "-+-+-";
	   String ligne5 = getString(grid.get(2).get(0)) + "|" + getString(grid.get(2).get(1)) + "|" + getString(grid.get(2).get(2));
	   
	   return ligne1 + "\n" + ligne2 + "\n" + ligne3 + "\n" + ligne4 + "\n" + ligne5;
	}

	public Vector<Vector<Integer>> getGrid() {
		return grid;
	}

	public void setGrid(Vector<Vector<Integer>> grid) {
		this.grid = grid;
	}
	
	public String getString(int val) {
		if (val == X) {
			return "X";
		}else if(val == O) {
			return "O";
		}else {
			return " ";
		}
	}
	
	public void placeSymbole(int player, int i, int j) {
		grid.get(i).set(j, player);
	}
	
	public boolean checkValidePosition(int i, int j) {
		if(i < 0 || j < 0 || i > 2 || j > 2) return false;
		if(grid.get(i).get(j) != 0) return false;
		
		return true;
	}
	
	public boolean checkAlignedSymbols() {
		// Horizontal
		if(grid.get(0).get(0) == grid.get(0).get(1) && grid.get(0).get(0) == grid.get(0).get(2) && grid.get(0).get(0) != 0) return true;
		if(grid.get(1).get(0) == grid.get(1).get(1) && grid.get(1).get(0) == grid.get(1).get(2) && grid.get(1).get(0) != 0) return true;
		if(grid.get(2).get(0) == grid.get(2).get(1) && grid.get(2).get(0) == grid.get(2).get(2) && grid.get(2).get(0) != 0) return true;
		
		// Vertical
		if(grid.get(0).get(0) == grid.get(1).get(0) && grid.get(0).get(0) == grid.get(2).get(0) && grid.get(0).get(0) != 0) return true;
		if(grid.get(0).get(1) == grid.get(1).get(1) && grid.get(0).get(1) == grid.get(2).get(1) && grid.get(0).get(1) != 0) return true;
		if(grid.get(0).get(2) == grid.get(1).get(2) && grid.get(0).get(2) == grid.get(2).get(2) && grid.get(0).get(2) != 0) return true;
		
		// Diagonal
		if(grid.get(0).get(0) == grid.get(1).get(1) && grid.get(0).get(0) == grid.get(2).get(2) && grid.get(0).get(0) != 0) return true;
		if(grid.get(0).get(2) == grid.get(1).get(1) && grid.get(0).get(2) == grid.get(2).get(0) && grid.get(0).get(2) != 0) return true;
		
		return false;
	}
	
	public boolean tie() {
		for(int i = 0; i < grid.size(); i++) {
			for(int j = 0; j < grid.size(); j++) {
				if (grid.get(i).get(j) == 0) return false;
			}
		}
		return true;
	}

}
