public class Dice8 extends Dice{
	int numSides = 8;
	
	public Dice8() {
		switch (rand.nextInt(numSides)) {
		case 0:
			roll = 1;
			break;
		case 1:
			roll = 2;
			break;
		case 2:
			roll = 3;
			break;
		case 3:
			roll = 4;
			break;
		case 4:
			roll = 5;
			break;
		case 5:
			roll = 6;
			break;
		case 6:
			roll = 7;
			break;
		default:
			roll = 8;
			break;
		}

	}
}
