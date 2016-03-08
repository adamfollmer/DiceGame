
public class Map {
	//String[][]Map = new String[5][5]
	String [][]Map = {{"X","X","X","X","X"},
			{"O","X","X","X","X"},
			{"X","X","X","X","X"},
			{"X","X","X","X","X"},
			{"X","X","X","X","X"}};


	public void PrintMap(){
		/*or(int i = 0; i<Map.length;i++){
			for(int j = 0; i<Map[i].length;i++){
				
			}
		}
		*/
		
		for(int i = 0; i< Map.length;i++){
			for(int j = 0; j < Map[i].length; j++){
				if(i==0 && j<5){
					System.out.print(Map[i][j]);
				}
				if(i==0 && j==5){
					System.out.println(" ");
				}
				else if(i==1 && j<10){
					System.out.print(Map[i][j]);
				}
				else if (i==2 && j<15){
					System.out.print(Map[i][j]);

				}
				else if (i==3 && j<20){
					System.out.println(Map[i][j]);
				}
				else if(i==4 && j<25){
					System.out.print(Map[i][j]);
				}
			}
		}
	}
}

