import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new Map();
		map.PrintMap();
		
		
		Dice4 d4 = new Dice4();
		Dice6 d6 = new Dice6();
		Dice8 d8 = new Dice8();
		Dice10 d10 = new Dice10();
		Dice12 d12 = new Dice12();
		Dice20 d20 = new Dice20();
	
		
			System.out.println("d4");
			d4.Roll();
			System.out.println("d6");
			d6.Roll();
			System.out.println("d8");
			d8.Roll();
			System.out.println("d10");
			d10.Roll();
			System.out.println("d12");
			d12.Roll();
			System.out.println("d20");
			d20.Roll();
			
			
	}

}
