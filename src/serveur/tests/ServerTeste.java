package serveur.tests;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import grille.GrilleTicTacToe;
import serveur.Serveur;

class ServeurTeste {
	  
	@Test
	@DisplayName("mêmes symboles alignés sur une ligne vérticale")
	void test1() {
		GrilleTicTacToe grille;
		Vector<Vector<Integer>> grid = new Vector<Vector<Integer>>();
		grid.add(new Vector<Integer>());
		grid.add(new Vector<Integer>());
		grid.add(new Vector<Integer>());
		grid.get(0).add(1);
		grid.get(0).add(0);
		grid.get(0).add(0);
		grid.get(1).add(1);
		grid.get(1).add(0);
		grid.get(1).add(0);
		grid.get(2).add(1);
		grid.get(2).add(0);
		grid.get(2).add(0);
		grille = new GrilleTicTacToe(grid);
		assertTrue(Serveur.check_aligned_symbols(grille));
	}
	
	@Test
	@DisplayName("mêmes symboles alignés sur une ligne horizontale")
	void test2() {
		GrilleTicTacToe grille;
		Vector<Vector<Integer>> grid = new Vector<Vector<Integer>>();
		grid.add(new Vector<Integer>());
		grid.add(new Vector<Integer>());
		grid.add(new Vector<Integer>());
		grid.get(0).add(1);
		grid.get(0).add(1);
		grid.get(0).add(1);
		grid.get(1).add(0);
		grid.get(1).add(0);
		grid.get(1).add(0);
		grid.get(2).add(0);
		grid.get(2).add(0);
		grid.get(2).add(0);
		grille = new GrilleTicTacToe(grid);
		assertTrue(Serveur.check_aligned_symbols(grille));
	}
	
	@Test
	@DisplayName("mêmes symboles alignés sur une diagonale")
	void test3() {
		GrilleTicTacToe grille;
		Vector<Vector<Integer>> grid = new Vector<Vector<Integer>>();
		grid.add(new Vector<Integer>());
		grid.add(new Vector<Integer>());
		grid.add(new Vector<Integer>());
		grid.get(0).add(1);
		grid.get(0).add(0);
		grid.get(0).add(0);
		grid.get(1).add(0);
		grid.get(1).add(1);
		grid.get(1).add(0);
		grid.get(2).add(0);
		grid.get(2).add(0);
		grid.get(2).add(1);
		grille = new GrilleTicTacToe(grid);
		assertTrue(Serveur.check_aligned_symbols(grille));
	}
	
	@Test
	@DisplayName("pas de combinaison gagnante")
	void test4() {
		GrilleTicTacToe grille;
		Vector<Vector<Integer>> grid = new Vector<Vector<Integer>>();
		grid.add(new Vector<Integer>());
		grid.add(new Vector<Integer>());
		grid.add(new Vector<Integer>());
		grid.get(0).add(1);
		grid.get(0).add(1);
		grid.get(0).add(2);
		grid.get(1).add(2);
		grid.get(1).add(1);
		grid.get(1).add(0);
		grid.get(2).add(0);
		grid.get(2).add(0);
		grid.get(2).add(0);
		grille = new GrilleTicTacToe(grid);
		assertFalse(Serveur.check_aligned_symbols(grille));
	}
}
