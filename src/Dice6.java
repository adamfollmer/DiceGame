
public class Dice6 extends Dice{
	double numSides = 6;
	public void Roll(){
		if(rand > ((1/numSides)*(numSides-3))){
			System.out.println("You rolled a 6");
		}
		else if(rand > ((1/numSides)*(numSides-4))){
			System.out.println("You rolled a 5");
		}
		else if(rand > ((1/numSides)*(numSides-5))){
			System.out.println("You rolled a 4");
		}
		else if(rand > ((1/numSides)*(numSides-6))){
			System.out.println("You rolled a 3");
		}
		else if(rand > ((1/numSides)*(numSides-7))){
			System.out.println("You rolled a 2");
		}
		else{
			System.out.println("You rolled a 1");
		}
	}
	
	
}
