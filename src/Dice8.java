
public class Dice8 extends Dice{
	double numSides = 8;
	
	public void Roll(){
		System.out.print("Your EIGHT sided die rolled ");
		if(rand > ((1/numSides)*(numSides-1))){
			System.out.println("an 8");
		}
		else if(rand > ((1/numSides)*(numSides-2))){
			System.out.println("a 7");
		}
		else if(rand > ((1/numSides)*(numSides-3))){
			System.out.println("a 6");
		}
		else if(rand > ((1/numSides)*(numSides-4))){
			System.out.println("a 5");
		}
		else if(rand > ((1/numSides)*(numSides-5))){
			System.out.println("a 4");
		}
		else if(rand > ((1/numSides)*(numSides-6))){
			System.out.println("a 3");
		}
		else if(rand > ((1/numSides)*(numSides-7))){
			System.out.println("a 2");
		}
		else{
			System.out.println("a 1");
		}
	}
}
