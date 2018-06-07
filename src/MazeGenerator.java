import java.util.LinkedList;
import java.util.Random;

 class Position {
	int x;
	int y;
	Position prev;
	int steps;
	
	Position(int x, int y, int steps){
		this.x = x;
		this.y = y;
		this.steps = steps;
	}
	Position(int x, int y, Position prev){
		this.x = x;
		this.y = y;
		this.prev = prev;
	}
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	boolean equal(Position pos) {
		return (this.x == pos.x && this.y == pos.y);
	}
	
	static int getDirection(Position pos1, Position pos2) {
		if (pos1.x == pos2.x) {
			if (pos2.y == pos1.y - 1)
				return 3;
			return 4;
		} else {
			if (pos2.x == pos1.x - 1)
				return 1;
			return 2;
		}
	}
	
}

public class MazeGenerator {
       
	private int blockDim;
	private int modNum;
	private int mazeWidth;
	private int mazeHeight;
	private int[][] maze;
	private int stepsObtained;
	private int minStepsWanted;
	private int maxStepsWanted;
	Random rand;
	
	MazeGenerator(int mazewidth, int mazeheight, int blockdim, int modnum, int minstepsw, int maxstepw){
		blockDim = blockdim;
		modNum = modnum;
		mazeWidth = mazewidth;
		mazeHeight = mazeheight;
		minStepsWanted = minstepsw;
		maxStepsWanted = maxstepw;
		maze = new int[mazeHeight][mazeWidth];
		rand = new Random();
	}
	
	int[][] generateMaze(int startX, int startY){
	    int num, i, j, x, y;
	    
	    do{
	    for(i = 0; i < mazeHeight; ++i)
	    	for(j = 0; j < mazeWidth; ++j)
	    		maze[i][j] = 0;
	    
	    for(i = 0; i < mazeHeight; ++i){
	        maze[i][0] = 2;
	        maze[i][mazeWidth - 1] = 2;
	    }
	    
	    for(i = 0; i < mazeWidth; ++i){
	    	maze[0][i] = 2;
	        maze[mazeHeight - 1][i] =  2;
	    }
	  
		for(i = 1; i <= mazeHeight - blockDim - 1; i += blockDim)
			for(j = (i == 1?blockDim:0) + 1; j <= mazeWidth - blockDim - 1; j += blockDim){
			
				num = rand.nextInt() % modNum;
				
				if (num == 0){
					for(x = i; x < i + blockDim; ++x)
						for(y = j; y < j + blockDim; ++y){
							maze[x][y] = 2;
						}
				}
			
			}
		
		   stepsObtained = testMaze(startX, startY);
		 //  if (stepsObtained > 0)
			 //  {showMaze(); Thread.sleep(1000);}
		   
	    } while(stepsObtained == 0);
	    
		maze[mazeHeight - 2][mazeWidth - 2] = 3;
				
		return maze;
	}
	
	
	
	private int testMaze(int startX, int startY){
		int i, j;
		boolean use[][] = new boolean[mazeHeight][mazeWidth];
		Position startPos = new Position(startX, startY, 0);
		Position finishPos = new Position(mazeHeight - 2, mazeWidth - 2); 
		
		int[] dx = new int[4], dy = new int[4];
		dx[0] = 1; dx[1] = -1; dy[2] = 1; dy[3] = -1;
		
		LinkedList<Position> queue= new LinkedList<Position>();
	   	queue.add(startPos);
	   	use[startPos.x][startPos.y] = true;
	   	
	   	while(queue.size() != 0){
	   		Position actPos = queue.getFirst();
	   		queue.removeFirst();
	   		
	   		if (actPos.equal(finishPos))
	   			return actPos.steps;
	   		
	   		for(i = 0; i < 4; ++i){
	   			Position newPos = new Position(actPos.x + dx[i], actPos.y + dy[i], actPos.steps + 1);
	   			if (newPos.x >= 0 && newPos.x < mazeHeight && newPos.y >= 0 && newPos.y < mazeWidth
	   			    && maze[newPos.x][newPos.y] != 2 && use[newPos.x][newPos.y] == false  		
	   					)
	   			{ queue.add(newPos);
	   			  use[newPos.x][newPos.y] = true;
	   			}
	   		}
	   	}
	   	
		return 0;
	}
	
	int findDirection(int startX, int startY) {
	    int i, pas = 0;
	    boolean use[][] = new boolean[mazeHeight][mazeWidth];
	    Position startPos = new Position(startX, startY, new Position(0, 0));
		Position finishPos = new Position(mazeHeight - 2, mazeWidth - 2); 
		int[] dx = new int[4], dy = new int[4];
		dx[0] = 1; dx[1] = -1; dy[2] = 1; dy[3] = -1;
			
		LinkedList<Position> queue= new LinkedList<Position>();
		queue.add(startPos);
		use[startPos.x][startPos.y] = true;
		   	
		while(queue.size() != 0){
		   	  Position actPos = queue.getFirst();
		   	  queue.removeFirst();
		   	  pas++; 		
		   	  for(i = 0; i < 4; ++i){
		   		  Position newPos = new Position(actPos.x + dx[i], actPos.y + dy[i], actPos);
		   		  if (newPos.x >= 0 && newPos.x < mazeHeight && newPos.y >= 0 && newPos.y < mazeWidth
		   			  && maze[newPos.x][newPos.y] != 2 && use[newPos.x][newPos.y] == false  		
		   					)
		   			{ queue.add(newPos);
		   			  use[newPos.x][newPos.y] = true;	
		   			}
		   		}
		   
		   	 if (actPos.equal(finishPos)){
		   		 
		   	   // System.out.println("Pas = " + pas + "\n");
	   		     return reconstructDirection(startPos, actPos);
		   	 }
		}	
		System.out.println("Error findDir");
		return 0; 
	}
	
	int reconstructDirection(Position startPos, Position finishPos) {
		if (startPos.equal(finishPos)) {
			//System.out.println("Error reconstruct dir");
			return 0;
		}
		
		
		while(finishPos.prev.equal(startPos) == false) {
			finishPos = finishPos.prev;
		}		
		return Position.getDirection(startPos, finishPos);				
	}
	
	void showMaze(){
		for(int i = 0; i < mazeHeight; ++i){
			for(int j = 0; j < mazeWidth; ++j)
				System.out.print(maze[i][j]);
		
	     System.out.print("\n");
		}
		
		System.out.print("\n" + "Minimum Steps :" + stepsObtained + "\n");
	}
	
};
