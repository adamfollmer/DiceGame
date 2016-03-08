
public class Map {
	// String[][]Map = new String[5][5]
	String[][] Map = { { "X", "X", "X", "X", "X" }, { "X", "X", "X", "X", "X" }, { "X", "X", "X", "X", "X" },
			{ "X", "X", "O", "X", "X" }, { "X", "X", "X", "X", "X" } };

	public void PrintMap() {
		for (int i = 0; i < Map.length; i++) {
			for (int j = 0; j < Map.length; j++) {
				System.out.print(Map[i][j]);
			}
			System.out.println();
		}
	}

	public void MapLocation(){
		String location = "unknown";

		for(int i = 0; i<Map.length; i++){
			for(int j = 0; j<Map.length;j++){
				if(Map[i][j] == "O"){
					location = Map[i][j];
					//System.out.println("Current Location is " + "["+i + ","+j+"]");
				}
			}
		}

	}
}
