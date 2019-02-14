import java.util.*;
import java.util.concurrent.TimeUnit;

public class Conoway_Game {

	private Cell [] [] matrix;
	private Cell [] [] updateMatrix;

	private int [] rowM = {-1,-1,-1,0,0,1,1,1};
	private int [] colM = {-1,0,1,-1,1,-1,0,1};

	public Conoway_Game(int r, int c)
	{
		matrix = new Cell [r][c];
		updateMatrix = new Cell [r][c];

		for(int row = 0; row<matrix.length; row++)
			for(int col=0; col<matrix[0].length; col++)
			{
				matrix[row][col] = new Cell();
				updateMatrix[row][col] = new Cell();
			}

	}

	public static void main(String [] args)
	{
		Conoway_Game test = new Conoway_Game(30,30);

		/*test.matrix[2][3].alive = true;
		test.matrix[2][4].alive = true;
		test.matrix[2][5].alive = true;

		test.matrix[4][1].alive = true;
		test.matrix[5][1].alive = true;
		test.matrix[6][1].alive = true;

		test.matrix[7][3].alive = true;
		test.matrix[7][4].alive = true;
		test.matrix[7][5].alive = true;

		test.matrix[6][6].alive = true;
		test.matrix[5][6].alive = true;
		test.matrix[4][6].alive = true;


		test.matrix[6][8].alive = true;
		test.matrix[5][8].alive = true;
		test.matrix[4][8].alive = true;

		test.matrix[7][9].alive = true;
		test.matrix[7][10].alive = true;
		test.matrix[7][11].alive = true;

		test.matrix[2][9].alive = true;
		test.matrix[2][10].alive = true;
		test.matrix[2][11].alive = true;

		test.matrix[4][13].alive = true;
		test.matrix[5][13].alive = true;
		test.matrix[6][13].alive = true;


		test.matrix[9][9].alive = true;
		test.matrix[9][10].alive = true;
		test.matrix[9][11].alive = true;

		test.matrix[10][8].alive = true;
		test.matrix[11][8].alive = true;
		test.matrix[12][8].alive = true;

		test.matrix[14][9].alive = true;
		test.matrix[14][10].alive = true;
		test.matrix[14][11].alive = true;

		test.matrix[12][13].alive = true;
		test.matrix[11][13].alive = true;
		test.matrix[10][13].alive = true;


		test.matrix[9][3].alive = true;
		test.matrix[9][4].alive = true;
		test.matrix[9][5].alive = true;

		test.matrix[10][6].alive = true;
		test.matrix[11][6].alive = true;
		test.matrix[12][6].alive = true;

		test.matrix[14][5].alive = true;
		test.matrix[14][4].alive = true;
		test.matrix[14][3].alive = true;

		test.matrix[12][1].alive = true;
		test.matrix[11][1].alive = true;
		test.matrix[10][1].alive = true;*/


	



	}
	
	public void importCells()
	{
		/*matrix[3][3].alive = true;
		matrix[3][2].alive = true;
		matrix[3][1].alive = true;
		matrix[2][3].alive = true;
		matrix[1][2].alive = true;*/


		matrix[8][3].alive = true;
		matrix[9][3].alive = true;
		matrix[8][4].alive = true;
		matrix[9][4].alive = true;

		matrix[8][8].alive = true;

		matrix[7][9].alive = true;
		matrix[6][10].alive = true;

		matrix[9][9].alive = true;
		matrix[10][10].alive = true;

		matrix[9][11].alive = true;
		matrix[8][11].alive = true;
		matrix[7][11].alive = true;

		matrix[6][12].alive = true;
		matrix[5][12].alive = true;

		matrix[10][12].alive = true;
		matrix[11][12].alive = true;

		matrix[8][23].alive = true;
		matrix[9][23].alive = true;
		matrix[8][24].alive = true;
		matrix[9][24].alive = true;

	}


	public Cell [] [] getMatrix()
	{
		return matrix;
	}
	
	public void rules()
	{
		for(int row = 0; row<matrix.length; row++)
		{
			for(int col = 0; col<matrix[0].length; col++)
			{
				
				if(matrix[row][col].alive)
				{
					int numAlive = checkAlive(row,col);

					if(numAlive < 2)
						updateMatrix[row][col].alive = false;

					else if(numAlive > 3)
						updateMatrix[row][col].alive = false;

					else if(numAlive == 3 || numAlive == 2)
						updateMatrix[row][col].alive = true;
				}
				else
				{
					int numAlive = checkAlive(row,col);

					if(numAlive == 3)
						updateMatrix[row][col].alive = true;
				}

			}
		}

		for(int row = 0; row<matrix.length; row++)
			for(int col=0; col<matrix[0].length; col++)
				matrix[row][col] = updateMatrix[row][col];

		for(int row = 0; row<matrix.length; row++)
			for(int col=0; col<matrix[0].length; col++)
				updateMatrix[row][col] = new Cell();


	}

	private int checkAlive(int row, int col)
	{
		int toRet = 0;
		for(int i =0; i<8; i++)
		{
			if(!(row+rowM[i] >= matrix.length || row+rowM[i] < 0 || col+colM[i] >= matrix[0].length || col+colM[i] < 0))
				if(matrix[row+rowM[i]][col+colM[i]].alive)
					toRet++;
		}
		return toRet;
	}
}