import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new Map();
		Player player = new Player("Player 1", 100);
		
		GamePlay gamePlay = new GamePlay();
		gamePlay.printInstructions();
		map.PrintMap();
		gamePlay.PlayerControl(player, map);
		
	}

}
