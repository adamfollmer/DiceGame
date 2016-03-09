
public class Dice12 extends Dice {
	double numSides = 12;
	
	public void Roll(){
		System.out.print("Your TWELVE sided die rolled ");
		if(rand > ((1/numSides)*(numSides-1))){
			System.out.println("a 12");
		}
		else if(rand > ((1/numSides)*(numSides-2))){
			System.out.println("an 11");
		}
		else if(rand > ((1/numSides)*(numSides-3))){
			System.out.println("a 10");
		}
		else if(rand > ((1/numSides)*(numSides-4))){
			System.out.println("a 9");
		}
		else if(rand > ((1/numSides)*(numSides-5))){
			System.out.println("Yan 8");
		}
		else if(rand > ((1/numSides)*(numSides-6))){
			System.out.println("a 7");
		}
		else if(rand > ((1/numSides)*(numSides-7))){
			System.out.println("a 6");
		}
		else if(rand > ((1/numSides)*(numSides-8))){
			System.out.println("a 5");
		}
		else if(rand > ((1/numSides)*(numSides-9))){
			System.out.println("a 4");
		}
		else if(rand > ((1/numSides)*(numSides-10))){
			System.out.println("a 3");
		}
		else if(rand > ((1/numSides)*(numSides-11))){
			System.out.println("a 2");
		}
		else{
			System.out.println("a 1");
		}
	}
}
