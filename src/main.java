import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new Map();
		Player player1 = new Player("Player 1", 100);
		Player player2 = new Player("Player 2", 100);
		
		GamePlay gamePlay = new GamePlay();
		gamePlay.printInstructions(player1, player2);
		
		
		
		player1.playerOneTurn = true;
		player2.playerTwoTurn = true;
		boolean stillPlay = true;
		
		while(player1.playerOneTurn || player2.playerTwoTurn || stillPlay){
			if(player1.playerOneTurn){
				System.out.println();
				gamePlay.PlayerTurn(player1, map);
				player2.playerTwoTurn = true;
				player1.playerOneTurn = false;
			}
			else if (player2.playerTwoTurn){
				System.out.println();
				gamePlay.PlayerTurn(player2, map);
				player1.playerOneTurn = true;
				player2.playerTwoTurn = false;
			}
		}
		
	}

}
