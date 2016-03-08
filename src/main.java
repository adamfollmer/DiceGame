import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new Map();
		map.PrintMap();
		Player player = new Player("Player 1", 100);
		
		//map.MapLocation();
		player.MoveUp(map);
		//map.MapLocation();
		System.out.println();
		map.PrintMap();	
	}

}
