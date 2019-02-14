
public class Cell {
	
	boolean alive;
	
	
	public String toString()
	{
		String toRet = "";
		
		if(alive)
			toRet="Alive";
		else
			toRet = "Dead";
		
		
		return toRet;
	}

}
