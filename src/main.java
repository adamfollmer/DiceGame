import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new Map();
		Player player1 = new Player("Player 1", 100);
		Player player2 = new Player("Player 2", 100);
		AI computerPlayer = new AI("Computer", 100);
		
		GamePlay gamePlay = new GamePlay();
		gamePlay.printInstructions(player1, player2, computerPlayer);
		gamePlay.GameTurn(player1, player2, computerPlayer, map, gamePlay);
		
	}

}
