
public class Dice6 extends Dice{
	double numSides = 6;
	public void Roll(){
		System.out.print("Your SIX sided die rolled a ");
		if(rand > ((1/numSides)*(numSides-3))){
			System.out.println("6");
		}
		else if(rand > ((1/numSides)*(numSides-4))){
			System.out.println("5");
		}
		else if(rand > ((1/numSides)*(numSides-5))){
			System.out.println("4");
		}
		else if(rand > ((1/numSides)*(numSides-6))){
			System.out.println("3");
		}
		else if(rand > ((1/numSides)*(numSides-7))){
			System.out.println("2");
		}
		else{
			System.out.println("1");
		}
	}
	
	
}
