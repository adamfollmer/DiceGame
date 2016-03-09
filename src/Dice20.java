public class Dice20 extends Dice{
	int numSides = 20;
	
	public Dice20() {
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
		case 7:
			roll = 8;
			break;
		case 8:
			roll = 9;
			break;
		case 9:
			roll = 10;
			break;
		case 10:
			roll = 11;
			break;
		case 11:
			roll = 12;
			break;
		case 12:
			roll = 13;
			break;
		case 13:
			roll = 14;
			break;
		case 14:
			roll = 15;
			break;
		case 15:
			roll = 16;
			break;
		case 16:
			roll = 17;
			break;
		case 17:
			roll = 18;
			break;
		case 18:
			roll = 19;
			break;
		default:
			roll = 20;
			break;
		}

	}

}
