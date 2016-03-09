public class Dice6 extends Dice {
	int numSides = 6;

	public Dice6() {
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
		default:
			roll = 6;
			break;
		}

	}

}
