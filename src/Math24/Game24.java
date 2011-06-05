package Math24;

import java.util.Scanner;

public class Game24 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int a, b, c, d;
		// TODO Auto-generated method stub
		System.out.println("Welcome to game24!");
		while (true) {
			System.out.println("Enter 4 integers:");
			Scanner in = new Scanner(System.in);
			a = in.nextInt();
			if (a == 0) {
				System.out.println("Thank you for play Game24");
				return;
			}
			b = in.nextInt();
			c = in.nextInt();
			d = in.nextInt();

			FourNumbers nums = new FourNumbers(a,b,c,d);
			System.out.println("The result is " + nums.Compute());
		}
	}

}
