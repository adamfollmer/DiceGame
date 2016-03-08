
public class Map {	
	int xCoordinate = 0;
	int yCoordinate = 0;
	
	// String[][]Map = new String[5][5]
	String[][] map = { { "X", "X", "X", "X", "X" }, { "X", "X", "X", "X", "X" }, { "X", "X", "X", "X", "X" },
			{ "X", "X", "O", "X", "X" }, { "X", "X", "X", "X", "X" } };

	public void PrintMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
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
					//location = Map[i][j];
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
					//location = Map[i][j];
					return yCoordinate = j;
				}
			}
		}
		return yCoordinate;
	}

}
