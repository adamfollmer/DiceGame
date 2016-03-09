//Marco, can we streamline this code better?
public class DiceCup {
	Dice[] diceArray = new Dice[6];
	Dice d4 = new Dice4();
	Dice6 d6 = new Dice6();
	Dice8 d8 = new Dice8();
	Dice10 d10 = new Dice10();
	Dice12 d12 = new Dice12();
	Dice20 d20 = new Dice20();
	
	public DiceCup() {
		diceArray[0] = d4;
		diceArray[1] = d6;
		diceArray[2] = d8;
		diceArray[3] = d10;
		diceArray[4] = d12;
		diceArray[5] = d20;
	}
	
}