public class Dice4 extends Dice {
	int numSides = 4;

	public Dice4() {
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
		default:
			roll = 4;
			break;
		}

	}
}
