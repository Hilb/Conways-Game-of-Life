import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class GridsCanvas extends JPanel {
	private int width, height;
	private int rows;
	private int cols;

	private JFrame frame = new JFrame();

	private Cell [] [] matrix;

	GridsCanvas(int w, int h, int r, int c, Cell [] [] mat) 
	{
		setSize(width = w, height = h);
		rows = r;
		cols = c;

		matrix = mat;
	}

	public void paint(Graphics g) 
	{		
		int matrixR = 0;
		int matrixC = 0;
		
		width = getSize().width;
		height = getSize().height;
		
		int rowHt = height / (rows);
		int rowWid = width / (cols);
		
		for(int col =0; col<width; col+=rowWid)
		{
			for(int row = 0; row<height-15; row+=rowHt)
			{
				if(matrix[matrixR][matrixC].alive)
					g.setColor(Color.ORANGE);	
				else
					g.setColor(Color.BLUE);

				g.fillRect(row, col, row+15, height/rows);
				
				matrixR++;
			}
			matrixR = 0;
			matrixC++;
		}

		g.setColor(Color.BLACK);
		int i;
		for (i = 0; i < rows; i++)
			g.drawLine(0, i * rowHt, width, i * rowHt);

		for (i = 0; i < cols; i++)
			g.drawLine(i * rowWid, 0, i * rowWid, height);
	}
	
	public void updateMatrix(Cell [] [] mat)
	{
		matrix = mat;
	}

}
public class Gui_Game extends JFrame 
{
	GridsCanvas xyz;
	
	
	public Gui_Game(Cell [] [] matrix) {
		xyz = new GridsCanvas(200, 200, 30, 30, matrix);
		xyz.setPreferredSize(new Dimension(450,450));
		xyz.setMaximumSize(new Dimension(500,500));
		xyz.setMinimumSize(new Dimension(500,500));

		add(xyz);
		pack();
	}
	
	public void updateMatrix(Cell [] [] mat)
	{
		xyz.updateMatrix(mat);
	}

}