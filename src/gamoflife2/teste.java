package gamoflife2;

public class teste {

	public static void main(String[] args) {

		GameOfLife2 game = new GameOfLife2(9); // matriz 9x9

		game.setCell(3, 3, true);
		game.setCell(3, 4, true);
		game.setCell(3, 5, true);
		game.setCell(4, 3, true);
		game.setCell(4, 4, true);
		game.setCell(5, 3, true);
		game.setCell(7, 7, true);
		game.setCell(8, 8, true);
		game.setCell(8, 7, true);
		game.setCell(8, 6, true);		
		
		game.show();
		
		for (int i = 0; i < 3; i++)
			game.exec();

	}

}