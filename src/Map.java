
public class Map {	
	int xCoordinate = 0;
	int yCoordinate = 0;

	// String[][]Map = new String[5][5]
	String[][] map = {{ "O", "X", "X", "X", "X","X"}, 
			{ "X", "X", "X", "X", "X", "X"}, 
			{ "X", "X", "X", "X", "X", "X"},
			{ "X", "X", "X", "X", "X", "X"}, 
			{ "X", "X", "X", "X", "X", "X"}, 
			{ "X", "X", "X", "X", "X", "X"}};

	public void PrintMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
	}

	public void MapLocation(int x, int y, Map map){
		//map[x]][y] = "O";
		String location = "unknown";
		for(int i = 0; i<map.map.length; i++){
			for(int j = 0; j<map.map.length;j++){
				if(map.map[i][j] == "O"){
					location = map.map[i][j];
					xCoordinate = j;
					yCoordinate =i;

					System.out.println("Current Location is " + "["+i + ","+j+"]");
				}
			}
		}

	}


	public int getXCoordinate(){
		xCoordinate = 0;
		for(int i = 0; i<map.length; i++){
			for(int j = 0; j<map.length;j++){
				if(map[i][j] == "O"){
					return xCoordinate = i;
				}
			}
		}
		return xCoordinate;
	}

	public int getYCoordinate(){
		yCoordinate = 0;
		for(int i = 0; i<map.length; i++){
			for(int j = 0; j<map.length;j++){
				if(map[i][j] == "O"){
					return yCoordinate = j;
				}
			}
		}
		return yCoordinate;
	}


	public boolean CheckIfBottomEdgeOfMap(int x, int y){
		boolean atEdge = false;		
		
		if(x==5 && y ==1){
			//System.out.println("You are at bottom1");
			atEdge = true;
		}
		else if(x==5 && y==2){
			//System.out.println("You are at bottom2");
			atEdge = true;
		}
		else if(x==5 && y ==3){
			//System.out.println("You are at bottom3");
			atEdge = true;
		}
		else if(x==5 && y==4){
			//System.out.println("You are at bottom4");
			atEdge = true;
		}
		
		

		return atEdge;
	}


	public boolean CheckIfTopEdgeOfMap(int x, int y){
		boolean atEdge = false;	
		
		if(x==0 && y ==1){
			//System.out.println("You are at top1");
			atEdge =true;
		}
		else if(x==0 && y==2){
			//System.out.println("You are at top2");
			atEdge = true;
		}
		else if(x==0 && y ==3){
			//System.out.println("You are at top3");
			atEdge = true;
		}
		else if(x==0 && y==4){
			//System.out.println("You are at top4");
			atEdge = true;
		}
		return atEdge;
	}
	
	public boolean CheckIfLeftEdgeOfMap(int x, int y){
		boolean atEdge = false;	
		
		if(x==1 && y==0){
			//System.out.println("You are at leftEdge1");
			atEdge = true;
		}
		else if(x==2 && y==0){
			//System.out.println("You are at leftEdge2");
			atEdge = true;
		}
		else if(x==3 && y==0){
			//System.out.println("You are at leftEdge3");
			atEdge = true;
		}
		else if(x==4 && y==0){
			//System.out.println("You are at leftEdge4");
			atEdge = true;
		}
		
		return atEdge;
	}
	
	public boolean CheckIfRightEdgeOfMap(int x, int y){
		boolean atEdge = false;	
		
		if(x==1 && y==5){
			//System.out.println("You are at rightEdge1");
			atEdge = true;
		}
		else if(x==2 && y==5){
			//System.out.println("You are at rightEdge2");
			atEdge = true;
		}
		else if(x==3 && y==5){
			//System.out.println("You are at rightEdge3");
			atEdge = true;
		}
		else if(x==4 && y==5){
			//System.out.println("You are at rightEdge4");
			atEdge = true;
		}
		
		return atEdge;
	}
	
	
	public boolean CheckIfBottomLeftCornerOfMap(int x, int y){
		boolean atCorner =false;
		if(x==5 && y==0){
			//System.out.println("You are at the top left corner");
			atCorner = true;
		}
		return atCorner;
	}


	public boolean CheckIfBottomRightCornerOfMap(int x, int y){
		boolean atCorner =false;
		if(x == 5 && y==5){
			//System.out.println("You are at the top right corner");
			atCorner = true;
		}
		return atCorner;
	}

	public boolean CheckIfTopLeftCornerOfMap(int x, int y){
		boolean atCorner =false;
		if(x == 0 && y==0){
			//System.out.println("You are at the top left corner");
			atCorner = true;
		}
		return atCorner;
	}

	public boolean CheckIfTopRightCornerOfMap(int x, int y){
		boolean atCorner =false;
		if(x == 0 && y == 5){
			//System.out.println("You are at the bottom right corner");
			atCorner = true;
		}
		return atCorner;
	}


}
