package gamoflife2;

public class GameOfLife2 {
	boolean[][] cState;
	boolean[][] nextState;
	int size;

	GameOfLife2(int size) {

		this.size = size;
		cState = new boolean[this.size][this.size];
		nextState = new boolean[this.size][this.size];

		for (int i = 0; i < cState.length; i++)
			for (int j = 0; j < cState[i].length; j++)
				cState[i][j] = false;
	}

	private void setCellNextState(int linha, int coluna, boolean isAlive) {
		nextState[linha][coluna] = isAlive;
	}

	public void setCell(int linha, int coluna, boolean isAlive) {
		try {
			cState[linha][coluna] = isAlive;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Set em posicao invalida: linha=" + linha + " coluna=" + coluna);
		}
	}

	public boolean isCellAlive(int linha, int coluna) {
		try {
			return cState[linha][coluna];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Get em posicao invalida: linha=" + linha + " coluna=" + coluna);
		}
		return false;
	}

	private int safe(int i) {
		return (i < 0) ? this.size - 1 : i % this.size;
	}

	private int getQtdeNeighborsAlive(int lin, int col) {

		short soma = 0;

		for (int i = lin - 1; i <= lin + 1; i++)
			for (int j = col - 1; j <= col + 1; j++)
				soma += (cState[safe(i)][safe(j)] ? 1 : 0);

		return soma - (cState[safe(lin)][safe(col)] ? 1 : 0);
	}

	public void show() {

		System.out.println();
		for (int i = 0; i < cState.length; i++) {
			System.out.println();
			for (int j = 0; j < cState[i].length; j++)
				System.out.print(cState[i][j] ? "#" : ".");
		}
	}

	public void exec() {

		int qtdeVivos;

		for (int i = 0; i < cState.length; i++) {
			for (int j = 0; j < cState[i].length; j++) {

				qtdeVivos = getQtdeNeighborsAlive(i, j);

				// regras VIVO
				if (isCellAlive(i, j)) {
					setCellNextState(i, j, (qtdeVivos == 2 || qtdeVivos == 3));
				}
				// regra MORTO
				else {
					setCellNextState(i, j, (qtdeVivos == 3));
				}

			}
		}

		// cState <- nextState
		for (int i = 0; i < cState.length; i++)
			for (int j = 0; j < cState[i].length; j++)
				cState[i][j] = nextState[i][j];

		show();
	}
}