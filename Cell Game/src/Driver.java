import java.awt.Graphics;

public class Driver {
	
	public static void main(String [] args)
	{
		Conoway_Game a = new Conoway_Game(30,30);
		a.importCells();
		Gui_Game theGui = new Gui_Game(a.getMatrix());
		theGui.setVisible(true);
		
		for(int i = 0; i<i+1; i++)
		{
			a.rules();
			Cell [] [] matrix = a.getMatrix();
			theGui.updateMatrix(a.getMatrix());
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			theGui.repaint();	
		}	
	}
}
