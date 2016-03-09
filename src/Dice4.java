import java.lang.Math;

public class Dice4 extends Dice{
	double numSides = 4;

	public void Roll(){
		System.out.print("Your FOUR sided die rolled a ");
		if(rand > ((1/numSides)*(numSides-1))){
			System.out.println("4");
		
		}
		else if(rand > ((1/numSides)*(numSides-2))){
			System.out.println("3");
		}
		else if (rand >((1/numSides)*(numSides-1))){
			System.out.println("2");
		}
		else{
			System.out.println("1");
		}
		
	}
}
