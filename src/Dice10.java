
public class Dice10 extends Dice{
	int numSides = 10;
	
	public void Roll(){
		if(rand > ((1/numSides)*(numSides-1))){
			System.out.println("You rolled a 10");
		}
		else if(rand > ((1/numSides)*(numSides-2))){
			System.out.println("You rolled a 9");
		}
		else if(rand > ((1/numSides)*(numSides-3))){
			System.out.println("You rolled a 8");
		}
		else if(rand > ((1/numSides)*(numSides-4))){
			System.out.println("You rolled a 7");
		}
		else if(rand > ((1/numSides)*(numSides-5))){
			System.out.println("You rolled a 6");
		}
		else if(rand > ((1/numSides)*(numSides-6))){
			System.out.println("You rolled a 5");
		}
		else if(rand > ((1/numSides)*(numSides-7))){
			System.out.println("You rolled a 4");
		}
		else if(rand > ((1/numSides)*(numSides-8))){
			System.out.println("You rolled a 3");
		}
		else if(rand > ((1/numSides)*(numSides-9))){
			System.out.println("You rolled a 2");
		}
		else{
			System.out.println("You rolled a 1");
		}
	}
}
