import java.lang.Math;

public class Dice4 extends Dice{
	double numSides = 4;

	public void Roll(){
		if(rand > ((1/numSides)*(numSides-1))){
			System.out.println("you rolled a 4");
		
		}
		else if(rand > ((1/numSides)*(numSides-2))){
			System.out.println("you rolled a 3");
		}
		else if (rand >((1/numSides)*(numSides-1))){
			System.out.println("you rolled a 2");
		}
		else{
			System.out.println("you rolled a 1");
		}
		
	}
}
