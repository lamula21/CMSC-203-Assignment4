
public class Plot extends Object {

	private int x;
	private int y;
	private int width;
	private int depth;
	
	
	
	public Plot(){
		x= 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	
	public Plot ( Plot p){
		
		x= p.x ;
		y = p.y;
		width = p.width;
		depth = p.depth;
		
	}

	
	public Plot(int x, int y, int width, int depth){
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}


	@Override
	public String toString() {
		System.out.println();
		return "Upper left: (" + x + "," + y + "); Width: " +
				width + " Depth: " + depth;
	}

	//check
	public boolean overlaps(Plot plot) {
		
		
		
		if ( plot.x >= x + width || plot.x + plot.width <= x || plot.y >= y + depth || plot.y + plot.depth <= y )
			return false;
		else 
			return true;
		
		
		
		
	}
	
	
	
	public boolean encompasses(Plot plot) {
		if ( 	   (plot.x >= x) 
				&& (plot.y >= y) // this two conditions if plot2 same size of plot1
				&& (plot.x + plot.width) <= (x + width)
				&& (plot.x + plot.depth) <= (y + depth) // this 2 conditions if plot2 is inside plot1
			)
			return true;
		else
			return false;
		
	}
}
